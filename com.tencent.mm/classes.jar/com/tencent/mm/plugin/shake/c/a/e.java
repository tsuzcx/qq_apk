package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vq;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private String Jnh;
  public List<WeakReference<a>> cSF;
  
  public e()
  {
    AppMethodBeat.i(28190);
    this.cSF = new ArrayList();
    this.Jnh = "";
    this.Jnh = com.tencent.mm.plugin.shake.c.c.a.fHJ();
    AppMethodBeat.o(28190);
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(28194);
    if (paramb == null)
    {
      Log.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
      AppMethodBeat.o(28194);
      return;
    }
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
    if (!com.tencent.mm.plugin.shake.c.c.a.fHj()) {
      Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.Jni + "  endtime:" + paramb.Jnj + "  flowlevelmin:" + paramb.Jnm + "  flowlevelmax:" + paramb.Jnn + " entrancename:" + paramb.Jnk + " activitytype:" + paramb.Jnl);
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgo, Integer.valueOf(paramb.Jni));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgp, Integer.valueOf(paramb.Jnj));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgq, paramb.Jnk);
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgu, Integer.valueOf(paramb.Jnl));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgr, Integer.valueOf(paramb.Jnm));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgs, Integer.valueOf(paramb.Jnn));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgt, paramb.Jno);
    AppMethodBeat.o(28194);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(28196);
    if (paramd == null)
    {
      Log.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
      AppMethodBeat.o(28196);
      return;
    }
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.Jnp);
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.Jnh);
    if (TextUtils.isEmpty(paramd.Jnp))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(28196);
      return;
    }
    if (TextUtils.isEmpty(this.Jnh))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.aa.c.aFn().D(262154, true);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vgv, paramd.Jnp);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vgw, paramd.Jnq);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vgx, paramd.Jnr);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (!this.Jnh.equals(paramd.Jnp))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.aa.c.aFn().D(262154, true);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vgv, paramd.Jnp);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vgw, paramd.Jnq);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vgx, paramd.Jnr);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (this.Jnh.equals(paramd.Jnp)) {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(28196);
  }
  
  private static b aXT(String paramString)
  {
    AppMethodBeat.i(28193);
    Object localObject = XmlParser.parseXml(paramString, "sysmsg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(28193);
      return null;
    }
    paramString = new b();
    String str = (String)((Map)localObject).get(".sysmsg.begintime");
    if ((!TextUtils.isEmpty(str)) && (isNumeric(str)))
    {
      paramString.Jni = Util.getInt(str, 0);
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label291;
      }
      paramString.Jnj = Util.getInt(str, 0);
      label105:
      paramString.Jnk = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label314;
      }
      paramString.Jnl = Util.getInt(str, 0);
      label157:
      Log.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label322;
      }
      paramString.Jnm = Util.getInt(str, 0);
      label208:
      paramString.Jno = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label345;
      }
    }
    for (paramString.Jnn = Util.getInt((String)localObject, 0);; paramString.Jnn = 0)
    {
      AppMethodBeat.o(28193);
      return paramString;
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.Jni = 0;
      break;
      label291:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.Jnj = 0;
      break label105;
      label314:
      paramString.Jnl = 1;
      break label157;
      label322:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.Jnm = 0;
      break label208;
      label345:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static d aXU(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if (paramString == null)
    {
      AppMethodBeat.o(28195);
      return null;
    }
    d locald = new d();
    locald.Jnp = ((String)paramString.get(".sysmsg.reddotid"));
    locald.Jnq = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.Jnr = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(28195);
    return locald;
  }
  
  private static void fHw()
  {
    AppMethodBeat.i(28192);
    vq localvq = new vq();
    EventCenter.instance.publish(localvq);
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
    if (this.cSF == null)
    {
      AppMethodBeat.o(28198);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      Object localObject = (WeakReference)this.cSF.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).fHx();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28198);
  }
  
  public final void n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(28191);
    Log.i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(paramLong)));
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
      AppMethodBeat.o(28191);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
      a(aXT(paramString));
      fHw();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.c.c.a.fHi();
      AppMethodBeat.o(28191);
      return;
      if (paramInt == 1)
      {
        Log.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(aXU(paramString));
        fHw();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void fHx();
  }
  
  public static final class b
    extends e.c
  {
    protected int Jni = 0;
    protected int Jnj = 0;
    protected String Jnk = "";
    protected int Jnl = 0;
    protected int Jnm = 0;
    protected int Jnn = 7;
    protected String Jno = "";
  }
  
  public static class c {}
  
  public static final class d
    extends e.c
  {
    protected String Jnp;
    protected String Jnq;
    protected String Jnr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.e
 * JD-Core Version:    0.7.0.1
 */