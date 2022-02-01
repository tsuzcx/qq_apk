package com.tencent.mm.plugin.shake.shakecard.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xg;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private String PzX;
  public List<WeakReference<a>> eNV;
  
  public e()
  {
    AppMethodBeat.i(28190);
    this.eNV = new ArrayList();
    this.PzX = "";
    this.PzX = com.tencent.mm.plugin.shake.shakecard.b.a.gXz();
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
    if (!com.tencent.mm.plugin.shake.shakecard.b.a.gWX()) {
      Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.PzY + "  endtime:" + paramb.PzZ + "  flowlevelmin:" + paramb.PAc + "  flowlevelmax:" + paramb.PAd + " entrancename:" + paramb.PAa + " activitytype:" + paramb.PAb);
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHD, Integer.valueOf(paramb.PzY));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHE, Integer.valueOf(paramb.PzZ));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHF, paramb.PAa);
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHJ, Integer.valueOf(paramb.PAb));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHG, Integer.valueOf(paramb.PAc));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHH, Integer.valueOf(paramb.PAd));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHI, paramb.PAe);
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
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.PAf);
    Log.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.PzX);
    if (TextUtils.isEmpty(paramd.PAf))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(28196);
      return;
    }
    if (TextUtils.isEmpty(this.PzX))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.aa.c.aYo().R(262154, true);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acHK, paramd.PAf);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acHL, paramd.PAg);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acHM, paramd.PAh);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (!this.PzX.equals(paramd.PAf))
    {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.aa.c.aYo().R(262154, true);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acHK, paramd.PAf);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acHL, paramd.PAg);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acHM, paramd.PAh);
      onChange();
      AppMethodBeat.o(28196);
      return;
    }
    if (this.PzX.equals(paramd.PAf)) {
      Log.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(28196);
  }
  
  private static b aVL(String paramString)
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
      paramString.PzY = Util.getInt(str, 0);
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label291;
      }
      paramString.PzZ = Util.getInt(str, 0);
      label105:
      paramString.PAa = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label314;
      }
      paramString.PAb = Util.getInt(str, 0);
      label157:
      Log.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label322;
      }
      paramString.PAc = Util.getInt(str, 0);
      label208:
      paramString.PAe = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label345;
      }
    }
    for (paramString.PAd = Util.getInt((String)localObject, 0);; paramString.PAd = 0)
    {
      AppMethodBeat.o(28193);
      return paramString;
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.PzY = 0;
      break;
      label291:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.PzZ = 0;
      break label105;
      label314:
      paramString.PAb = 1;
      break label157;
      label322:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.PAc = 0;
      break label208;
      label345:
      Log.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static d aVM(String paramString)
  {
    AppMethodBeat.i(28195);
    paramString = XmlParser.parseXml(paramString, "sysmsg", null);
    if (paramString == null)
    {
      AppMethodBeat.o(28195);
      return null;
    }
    d locald = new d();
    locald.PAf = ((String)paramString.get(".sysmsg.reddotid"));
    locald.PAg = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.PAh = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(28195);
    return locald;
  }
  
  private static void gXl()
  {
    AppMethodBeat.i(28192);
    new xg().publish();
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
    if (this.eNV == null)
    {
      AppMethodBeat.o(28198);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).gXm();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28198);
  }
  
  public final void p(String paramString, long paramLong, int paramInt)
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
      a(aVL(paramString));
      gXl();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.shakecard.b.a.gWW();
      AppMethodBeat.o(28191);
      return;
      if (paramInt == 1)
      {
        Log.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(aVM(paramString));
        gXl();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void gXm();
  }
  
  public static final class b
    extends e.c
  {
    protected String PAa = "";
    protected int PAb = 0;
    protected int PAc = 0;
    protected int PAd = 7;
    protected String PAe = "";
    protected int PzY = 0;
    protected int PzZ = 0;
  }
  
  public static class c {}
  
  public static final class d
    extends e.c
  {
    protected String PAf;
    protected String PAg;
    protected String PAh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.shakecard.a.e
 * JD-Core Version:    0.7.0.1
 */