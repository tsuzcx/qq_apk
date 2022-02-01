package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.un;
import com.tencent.mm.model.bg;
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

public final class f
{
  private String DhB;
  public List<WeakReference<a>> pQG;
  
  public f()
  {
    AppMethodBeat.i(28190);
    this.pQG = new ArrayList();
    this.DhB = "";
    this.DhB = com.tencent.mm.plugin.shake.c.c.a.eUH();
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
    if (!com.tencent.mm.plugin.shake.c.c.a.eUh()) {
      Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.DhC + "  endtime:" + paramb.DhD + "  flowlevelmin:" + paramb.DhG + "  flowlevelmax:" + paramb.DhH + " entrancename:" + paramb.DhE + " activitytype:" + paramb.DhF);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSq, Integer.valueOf(paramb.DhC));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSr, Integer.valueOf(paramb.DhD));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSs, paramb.DhE);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSw, Integer.valueOf(paramb.DhF));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSt, Integer.valueOf(paramb.DhG));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSu, Integer.valueOf(paramb.DhH));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSv, paramb.DhI);
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
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.DhJ);
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.DhB);
    if (TextUtils.isEmpty(paramd.DhJ))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(28196);
      return;
    }
    if (TextUtils.isEmpty(this.DhB))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.y.c.axV().B(262154, true);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NSx, paramd.DhJ);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NSy, paramd.DhK);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NSz, paramd.DhL);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (!this.DhB.equals(paramd.DhJ))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.y.c.axV().B(262154, true);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NSx, paramd.DhJ);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NSy, paramd.DhK);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NSz, paramd.DhL);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (this.DhB.equals(paramd.DhJ)) {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(28196);
  }
  
  private static b aNk(String paramString)
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
      paramString.DhC = Util.getInt(str, 0);
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label291;
      }
      paramString.DhD = Util.getInt(str, 0);
      label105:
      paramString.DhE = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label314;
      }
      paramString.DhF = Util.getInt(str, 0);
      label157:
      Log.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label322;
      }
      paramString.DhG = Util.getInt(str, 0);
      label208:
      paramString.DhI = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label345;
      }
    }
    for (paramString.DhH = Util.getInt((String)localObject, 0);; paramString.DhH = 0)
    {
      AppMethodBeat.o(28193);
      return paramString;
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.DhC = 0;
      break;
      label291:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.DhD = 0;
      break label105;
      label314:
      paramString.DhF = 1;
      break label157;
      label322:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.DhG = 0;
      break label208;
      label345:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static d aNl(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if (paramString == null)
    {
      AppMethodBeat.o(28195);
      return null;
    }
    d locald = new d();
    locald.DhJ = ((String)paramString.get(".sysmsg.reddotid"));
    locald.DhK = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.DhL = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(28195);
    return locald;
  }
  
  private static void eUu()
  {
    AppMethodBeat.i(28192);
    un localun = new un();
    EventCenter.instance.publish(localun);
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
    if (this.pQG == null)
    {
      AppMethodBeat.o(28198);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).eUv();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28198);
  }
  
  public final void m(String paramString, long paramLong, int paramInt)
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
      a(aNk(paramString));
      eUu();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.c.c.a.eUg();
      AppMethodBeat.o(28191);
      return;
      if (paramInt == 1)
      {
        Log.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(aNl(paramString));
        eUu();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void eUv();
  }
  
  public static final class b
    extends f.c
  {
    protected int DhC = 0;
    protected int DhD = 0;
    protected String DhE = "";
    protected int DhF = 0;
    protected int DhG = 0;
    protected int DhH = 7;
    protected String DhI = "";
  }
  
  public static class c {}
  
  public static final class d
    extends f.c
  {
    protected String DhJ;
    protected String DhK;
    protected String DhL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */