package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public List<WeakReference<a>> oCX;
  private String zcJ;
  
  public f()
  {
    AppMethodBeat.i(28190);
    this.oCX = new ArrayList();
    this.zcJ = "";
    this.zcJ = com.tencent.mm.plugin.shake.c.c.a.dSG();
    AppMethodBeat.o(28190);
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(28194);
    if (paramb == null)
    {
      ae.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
      AppMethodBeat.o(28194);
      return;
    }
    ae.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
    if (!com.tencent.mm.plugin.shake.c.c.a.dSg()) {
      ae.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    ae.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.zcK + "  endtime:" + paramb.zcL + "  flowlevelmin:" + paramb.zcO + "  flowlevelmax:" + paramb.zcP + " entrancename:" + paramb.zcM + " activitytype:" + paramb.zcN);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKs, Integer.valueOf(paramb.zcK));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKt, Integer.valueOf(paramb.zcL));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKu, paramb.zcM);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKy, Integer.valueOf(paramb.zcN));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKv, Integer.valueOf(paramb.zcO));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKw, Integer.valueOf(paramb.zcP));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKx, paramb.zcQ);
    AppMethodBeat.o(28194);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(28196);
    if (paramd == null)
    {
      ae.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
      AppMethodBeat.o(28196);
      return;
    }
    ae.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.zcR);
    ae.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.zcJ);
    if (TextUtils.isEmpty(paramd.zcR))
    {
      ae.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(28196);
      return;
    }
    if (TextUtils.isEmpty(this.zcJ))
    {
      ae.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.y.c.ahI().x(262154, true);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IKz, paramd.zcR);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IKA, paramd.zcS);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IKB, paramd.zcT);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (!this.zcJ.equals(paramd.zcR))
    {
      ae.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.y.c.ahI().x(262154, true);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IKz, paramd.zcR);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IKA, paramd.zcS);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IKB, paramd.zcT);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (this.zcJ.equals(paramd.zcR)) {
      ae.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(28196);
  }
  
  private static b ayA(String paramString)
  {
    AppMethodBeat.i(28193);
    Object localObject = bx.M(paramString, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(28193);
      return null;
    }
    paramString = new b();
    String str = (String)((Map)localObject).get(".sysmsg.begintime");
    if ((!TextUtils.isEmpty(str)) && (isNumeric(str)))
    {
      paramString.zcK = bu.getInt(str, 0);
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label290;
      }
      paramString.zcL = bu.getInt(str, 0);
      label104:
      paramString.zcM = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label313;
      }
      paramString.zcN = bu.getInt(str, 0);
      label156:
      ae.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label321;
      }
      paramString.zcO = bu.getInt(str, 0);
      label207:
      paramString.zcQ = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label344;
      }
    }
    for (paramString.zcP = bu.getInt((String)localObject, 0);; paramString.zcP = 0)
    {
      AppMethodBeat.o(28193);
      return paramString;
      ae.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.zcK = 0;
      break;
      label290:
      ae.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.zcL = 0;
      break label104;
      label313:
      paramString.zcN = 1;
      break label156;
      label321:
      ae.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.zcO = 0;
      break label207;
      label344:
      ae.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static d ayB(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = bx.M(paramString, "sysmsg");
    if (paramString == null)
    {
      AppMethodBeat.o(28195);
      return null;
    }
    d locald = new d();
    locald.zcR = ((String)paramString.get(".sysmsg.reddotid"));
    locald.zcS = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.zcT = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(28195);
    return locald;
  }
  
  private static void dSt()
  {
    AppMethodBeat.i(28192);
    tp localtp = new tp();
    com.tencent.mm.sdk.b.a.IvT.l(localtp);
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
    if (this.oCX == null)
    {
      AppMethodBeat.o(28198);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).dSu();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28198);
  }
  
  public final void m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(28191);
    ae.i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(paramLong)));
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
      AppMethodBeat.o(28191);
      return;
    }
    if (paramInt == 0)
    {
      ae.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
      a(ayA(paramString));
      dSt();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.c.c.a.dSf();
      AppMethodBeat.o(28191);
      return;
      if (paramInt == 1)
      {
        ae.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(ayB(paramString));
        dSt();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void dSu();
  }
  
  public static final class b
    extends f.c
  {
    protected int zcK = 0;
    protected int zcL = 0;
    protected String zcM = "";
    protected int zcN = 0;
    protected int zcO = 0;
    protected int zcP = 7;
    protected String zcQ = "";
  }
  
  public static class c {}
  
  public static final class d
    extends f.c
  {
    protected String zcR;
    protected String zcS;
    protected String zcT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */