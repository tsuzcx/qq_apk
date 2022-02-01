package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public List<WeakReference<a>> nqa;
  private String wmy;
  
  public f()
  {
    AppMethodBeat.i(28190);
    this.nqa = new ArrayList();
    this.wmy = "";
    this.wmy = com.tencent.mm.plugin.shake.c.c.a.dpw();
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
    if (!com.tencent.mm.plugin.shake.c.c.a.doW()) {
      ad.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    ad.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.wmz + "  endtime:" + paramb.wmA + "  flowlevelmin:" + paramb.wmD + "  flowlevelmax:" + paramb.wmE + " entrancename:" + paramb.wmB + " activitytype:" + paramb.wmC);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfR, Integer.valueOf(paramb.wmz));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfS, Integer.valueOf(paramb.wmA));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfT, paramb.wmB);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfX, Integer.valueOf(paramb.wmC));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfU, Integer.valueOf(paramb.wmD));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfV, Integer.valueOf(paramb.wmE));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfW, paramb.wmF);
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
    ad.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.wmG);
    ad.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.wmy);
    if (TextUtils.isEmpty(paramd.wmG))
    {
      ad.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(28196);
      return;
    }
    if (TextUtils.isEmpty(this.wmy))
    {
      ad.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.z.c.adr().x(262154, true);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FfY, paramd.wmG);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FfZ, paramd.wmH);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fga, paramd.wmI);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (!this.wmy.equals(paramd.wmG))
    {
      ad.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.z.c.adr().x(262154, true);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FfY, paramd.wmG);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FfZ, paramd.wmH);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fga, paramd.wmI);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (this.wmy.equals(paramd.wmG)) {
      ad.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(28196);
  }
  
  private static b anb(String paramString)
  {
    AppMethodBeat.i(28193);
    Object localObject = bw.K(paramString, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(28193);
      return null;
    }
    paramString = new b();
    String str = (String)((Map)localObject).get(".sysmsg.begintime");
    if ((!TextUtils.isEmpty(str)) && (isNumeric(str)))
    {
      paramString.wmz = bt.getInt(str, 0);
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label290;
      }
      paramString.wmA = bt.getInt(str, 0);
      label104:
      paramString.wmB = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label313;
      }
      paramString.wmC = bt.getInt(str, 0);
      label156:
      ad.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label321;
      }
      paramString.wmD = bt.getInt(str, 0);
      label207:
      paramString.wmF = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label344;
      }
    }
    for (paramString.wmE = bt.getInt((String)localObject, 0);; paramString.wmE = 0)
    {
      AppMethodBeat.o(28193);
      return paramString;
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.wmz = 0;
      break;
      label290:
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.wmA = 0;
      break label104;
      label313:
      paramString.wmC = 1;
      break label156;
      label321:
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.wmD = 0;
      break label207;
      label344:
      ad.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static d anc(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = bw.K(paramString, "sysmsg");
    if (paramString == null)
    {
      AppMethodBeat.o(28195);
      return null;
    }
    d locald = new d();
    locald.wmG = ((String)paramString.get(".sysmsg.reddotid"));
    locald.wmH = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.wmI = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(28195);
    return locald;
  }
  
  private static void dpj()
  {
    AppMethodBeat.i(28192);
    so localso = new so();
    com.tencent.mm.sdk.b.a.ESL.l(localso);
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
    if (this.nqa == null)
    {
      AppMethodBeat.o(28198);
      return;
    }
    int i = 0;
    while (i < this.nqa.size())
    {
      Object localObject = (WeakReference)this.nqa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).dpk();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28198);
  }
  
  public final void k(String paramString, long paramLong, int paramInt)
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
      a(anb(paramString));
      dpj();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.c.c.a.doV();
      AppMethodBeat.o(28191);
      return;
      if (paramInt == 1)
      {
        ad.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(anc(paramString));
        dpj();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void dpk();
  }
  
  public static final class b
    extends f.c
  {
    protected int wmA = 0;
    protected String wmB = "";
    protected int wmC = 0;
    protected int wmD = 0;
    protected int wmE = 7;
    protected String wmF = "";
    protected int wmz = 0;
  }
  
  public static class c {}
  
  public static final class d
    extends f.c
  {
    protected String wmG;
    protected String wmH;
    protected String wmI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */