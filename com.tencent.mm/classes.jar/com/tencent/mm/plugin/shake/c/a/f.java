package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public List<WeakReference<a>> nTa;
  private String xxO;
  
  public f()
  {
    AppMethodBeat.i(28190);
    this.nTa = new ArrayList();
    this.xxO = "";
    this.xxO = com.tencent.mm.plugin.shake.c.c.a.dDG();
    AppMethodBeat.o(28190);
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(28194);
    if (paramb == null)
    {
      ac.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
      AppMethodBeat.o(28194);
      return;
    }
    ac.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
    if (!com.tencent.mm.plugin.shake.c.c.a.dDg()) {
      ac.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    ac.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.xxP + "  endtime:" + paramb.xxQ + "  flowlevelmin:" + paramb.xxT + "  flowlevelmax:" + paramb.xxU + " entrancename:" + paramb.xxR + " activitytype:" + paramb.xxS);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDF, Integer.valueOf(paramb.xxP));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDG, Integer.valueOf(paramb.xxQ));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDH, paramb.xxR);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDL, Integer.valueOf(paramb.xxS));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDI, Integer.valueOf(paramb.xxT));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDJ, Integer.valueOf(paramb.xxU));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDK, paramb.xxV);
    AppMethodBeat.o(28194);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(28196);
    if (paramd == null)
    {
      ac.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
      AppMethodBeat.o(28196);
      return;
    }
    ac.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.xxW);
    ac.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.xxO);
    if (TextUtils.isEmpty(paramd.xxW))
    {
      ac.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(28196);
      return;
    }
    if (TextUtils.isEmpty(this.xxO))
    {
      ac.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.y.c.aeH().x(262154, true);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GDM, paramd.xxW);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GDN, paramd.xxX);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GDO, paramd.xxY);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (!this.xxO.equals(paramd.xxW))
    {
      ac.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.y.c.aeH().x(262154, true);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GDM, paramd.xxW);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GDN, paramd.xxX);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GDO, paramd.xxY);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (this.xxO.equals(paramd.xxW)) {
      ac.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(28196);
  }
  
  private static b ask(String paramString)
  {
    AppMethodBeat.i(28193);
    Object localObject = bv.L(paramString, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(28193);
      return null;
    }
    paramString = new b();
    String str = (String)((Map)localObject).get(".sysmsg.begintime");
    if ((!TextUtils.isEmpty(str)) && (isNumeric(str)))
    {
      paramString.xxP = bs.getInt(str, 0);
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label290;
      }
      paramString.xxQ = bs.getInt(str, 0);
      label104:
      paramString.xxR = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label313;
      }
      paramString.xxS = bs.getInt(str, 0);
      label156:
      ac.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label321;
      }
      paramString.xxT = bs.getInt(str, 0);
      label207:
      paramString.xxV = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label344;
      }
    }
    for (paramString.xxU = bs.getInt((String)localObject, 0);; paramString.xxU = 0)
    {
      AppMethodBeat.o(28193);
      return paramString;
      ac.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.xxP = 0;
      break;
      label290:
      ac.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.xxQ = 0;
      break label104;
      label313:
      paramString.xxS = 1;
      break label156;
      label321:
      ac.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.xxT = 0;
      break label207;
      label344:
      ac.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static d asl(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = bv.L(paramString, "sysmsg");
    if (paramString == null)
    {
      AppMethodBeat.o(28195);
      return null;
    }
    d locald = new d();
    locald.xxW = ((String)paramString.get(".sysmsg.reddotid"));
    locald.xxX = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.xxY = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(28195);
    return locald;
  }
  
  private static void dDt()
  {
    AppMethodBeat.i(28192);
    sx localsx = new sx();
    com.tencent.mm.sdk.b.a.GpY.l(localsx);
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
    if (this.nTa == null)
    {
      AppMethodBeat.o(28198);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).dDu();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28198);
  }
  
  public final void k(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(28191);
    ac.i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(paramLong)));
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
      AppMethodBeat.o(28191);
      return;
    }
    if (paramInt == 0)
    {
      ac.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
      a(ask(paramString));
      dDt();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.c.c.a.dDf();
      AppMethodBeat.o(28191);
      return;
      if (paramInt == 1)
      {
        ac.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(asl(paramString));
        dDt();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void dDu();
  }
  
  public static final class b
    extends f.c
  {
    protected int xxP = 0;
    protected int xxQ = 0;
    protected String xxR = "";
    protected int xxS = 0;
    protected int xxT = 0;
    protected int xxU = 7;
    protected String xxV = "";
  }
  
  public static class c {}
  
  public static final class d
    extends f.c
  {
    protected String xxW;
    protected String xxX;
    protected String xxY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */