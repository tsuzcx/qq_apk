package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.to;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public List<WeakReference<a>> owv;
  private String yMz;
  
  public f()
  {
    AppMethodBeat.i(28190);
    this.owv = new ArrayList();
    this.yMz = "";
    this.yMz = com.tencent.mm.plugin.shake.c.c.a.dPj();
    AppMethodBeat.o(28190);
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(28194);
    if (paramb == null)
    {
      ad.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
      AppMethodBeat.o(28194);
      return;
    }
    ad.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
    if (!com.tencent.mm.plugin.shake.c.c.a.dOJ()) {
      ad.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    ad.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.yMA + "  endtime:" + paramb.yMB + "  flowlevelmin:" + paramb.yME + "  flowlevelmax:" + paramb.yMF + " entrancename:" + paramb.yMC + " activitytype:" + paramb.yMD);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpY, Integer.valueOf(paramb.yMA));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpZ, Integer.valueOf(paramb.yMB));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqa, paramb.yMC);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqe, Integer.valueOf(paramb.yMD));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqb, Integer.valueOf(paramb.yME));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqc, Integer.valueOf(paramb.yMF));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqd, paramb.yMG);
    AppMethodBeat.o(28194);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(28196);
    if (paramd == null)
    {
      ad.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
      AppMethodBeat.o(28196);
      return;
    }
    ad.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.yMH);
    ad.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.yMz);
    if (TextUtils.isEmpty(paramd.yMH))
    {
      ad.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(28196);
      return;
    }
    if (TextUtils.isEmpty(this.yMz))
    {
      ad.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.z.c.aht().x(262154, true);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Iqf, paramd.yMH);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Iqg, paramd.yMI);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Iqh, paramd.yMJ);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (!this.yMz.equals(paramd.yMH))
    {
      ad.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.z.c.aht().x(262154, true);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Iqf, paramd.yMH);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Iqg, paramd.yMI);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Iqh, paramd.yMJ);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (this.yMz.equals(paramd.yMH)) {
      ad.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(28196);
  }
  
  private static b axk(String paramString)
  {
    AppMethodBeat.i(28193);
    Object localObject = bw.M(paramString, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(28193);
      return null;
    }
    paramString = new b();
    String str = (String)((Map)localObject).get(".sysmsg.begintime");
    if ((!TextUtils.isEmpty(str)) && (isNumeric(str)))
    {
      paramString.yMA = bt.getInt(str, 0);
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label290;
      }
      paramString.yMB = bt.getInt(str, 0);
      label104:
      paramString.yMC = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label313;
      }
      paramString.yMD = bt.getInt(str, 0);
      label156:
      ad.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label321;
      }
      paramString.yME = bt.getInt(str, 0);
      label207:
      paramString.yMG = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label344;
      }
    }
    for (paramString.yMF = bt.getInt((String)localObject, 0);; paramString.yMF = 0)
    {
      AppMethodBeat.o(28193);
      return paramString;
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.yMA = 0;
      break;
      label290:
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.yMB = 0;
      break label104;
      label313:
      paramString.yMD = 1;
      break label156;
      label321:
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.yME = 0;
      break label207;
      label344:
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static d axl(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = bw.M(paramString, "sysmsg");
    if (paramString == null)
    {
      AppMethodBeat.o(28195);
      return null;
    }
    d locald = new d();
    locald.yMH = ((String)paramString.get(".sysmsg.reddotid"));
    locald.yMI = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.yMJ = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(28195);
    return locald;
  }
  
  private static void dOW()
  {
    AppMethodBeat.i(28192);
    to localto = new to();
    com.tencent.mm.sdk.b.a.IbL.l(localto);
    AppMethodBeat.o(28192);
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(28197);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(28197);
    return bool;
  }
  
  private void onChange()
  {
    AppMethodBeat.i(28198);
    if (this.owv == null)
    {
      AppMethodBeat.o(28198);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).dOX();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28198);
  }
  
  public final void m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(28191);
    ad.i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(paramLong)));
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
      AppMethodBeat.o(28191);
      return;
    }
    if (paramInt == 0)
    {
      ad.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
      a(axk(paramString));
      dOW();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.c.c.a.dOI();
      AppMethodBeat.o(28191);
      return;
      if (paramInt == 1)
      {
        ad.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(axl(paramString));
        dOW();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void dOX();
  }
  
  public static final class b
    extends f.c
  {
    protected int yMA = 0;
    protected int yMB = 0;
    protected String yMC = "";
    protected int yMD = 0;
    protected int yME = 0;
    protected int yMF = 7;
    protected String yMG = "";
  }
  
  public static class c {}
  
  public static final class d
    extends f.c
  {
    protected String yMH;
    protected String yMI;
    protected String yMJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */