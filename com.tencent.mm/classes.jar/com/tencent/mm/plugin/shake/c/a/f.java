package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public List<WeakReference<a>> kkV;
  private String qNI;
  
  public f()
  {
    AppMethodBeat.i(24519);
    this.kkV = new ArrayList();
    this.qNI = "";
    this.qNI = com.tencent.mm.plugin.shake.c.c.a.clJ();
    AppMethodBeat.o(24519);
  }
  
  private static f.b Zb(String paramString)
  {
    AppMethodBeat.i(24522);
    Object localObject = br.F(paramString, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(24522);
      return null;
    }
    paramString = new f.b();
    String str = (String)((Map)localObject).get(".sysmsg.begintime");
    if ((!TextUtils.isEmpty(str)) && (isNumeric(str)))
    {
      paramString.qNJ = Integer.valueOf(str).intValue();
      str = (String)((Map)localObject).get(".sysmsg.endtime");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label292;
      }
      paramString.qNK = Integer.valueOf(str).intValue();
      label107:
      paramString.qNL = ((String)((Map)localObject).get(".sysmsg.entrancename"));
      str = (String)((Map)localObject).get(".sysmsg.activitytype");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label314;
      }
      paramString.qNM = Integer.valueOf(str).intValue();
      label159:
      ab.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is ".concat(String.valueOf(str)));
      str = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmin");
      if ((TextUtils.isEmpty(str)) || (!isNumeric(str))) {
        break label322;
      }
      paramString.qNN = Integer.valueOf(str).intValue();
      label210:
      paramString.qNP = ((String)((Map)localObject).get(".sysmsg.shakecardentrancetip"));
      localObject = (String)((Map)localObject).get(".sysmsg.flowcontrollevelmax");
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!isNumeric((String)localObject))) {
        break label344;
      }
    }
    for (paramString.qNO = Integer.valueOf((String)localObject).intValue();; paramString.qNO = 0)
    {
      AppMethodBeat.o(24522);
      return paramString;
      ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is ".concat(String.valueOf(str)));
      paramString.qNJ = 0;
      break;
      label292:
      ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is ".concat(String.valueOf(str)));
      paramString.qNK = 0;
      break label107;
      label314:
      paramString.qNM = 1;
      break label159;
      label322:
      ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is ".concat(String.valueOf(str)));
      paramString.qNN = 0;
      break label210;
      label344:
      ab.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is ".concat(String.valueOf(localObject)));
    }
  }
  
  private static f.d Zc(String paramString)
  {
    AppMethodBeat.i(24524);
    paramString = br.F(paramString, "sysmsg");
    if (paramString == null)
    {
      AppMethodBeat.o(24524);
      return null;
    }
    f.d locald = new f.d();
    locald.qNQ = ((String)paramString.get(".sysmsg.reddotid"));
    locald.qNR = ((String)paramString.get(".sysmsg.reddotdesc"));
    locald.qNS = ((String)paramString.get(".sysmsg.reddottext"));
    AppMethodBeat.o(24524);
    return locald;
  }
  
  private static void a(f.b paramb)
  {
    AppMethodBeat.i(24523);
    if (paramb == null)
    {
      ab.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
      AppMethodBeat.o(24523);
      return;
    }
    ab.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
    if (!com.tencent.mm.plugin.shake.c.c.a.cli()) {
      ab.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
    }
    ab.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + paramb.qNJ + "  endtime:" + paramb.qNK + "  flowlevelmin:" + paramb.qNN + "  flowlevelmax:" + paramb.qNO + " entrancename:" + paramb.qNL + " activitytype:" + paramb.qNM);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxx, Integer.valueOf(paramb.qNJ));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxy, Integer.valueOf(paramb.qNK));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxz, paramb.qNL);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxD, Integer.valueOf(paramb.qNM));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxA, Integer.valueOf(paramb.qNN));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxB, Integer.valueOf(paramb.qNO));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxC, paramb.qNP);
    AppMethodBeat.o(24523);
  }
  
  private void a(f.d paramd)
  {
    AppMethodBeat.i(24525);
    if (paramd == null)
    {
      ab.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
      AppMethodBeat.o(24525);
      return;
    }
    ab.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + paramd.qNQ);
    ab.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.qNI);
    if (TextUtils.isEmpty(paramd.qNQ))
    {
      ab.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
      AppMethodBeat.o(24525);
      return;
    }
    if (TextUtils.isEmpty(this.qNI))
    {
      ab.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
      com.tencent.mm.x.c.PJ().y(262154, true);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxE, paramd.qNQ);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxF, paramd.qNR);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxG, paramd.qNS);
      onChange();
      AppMethodBeat.o(24525);
      return;
    }
    if (!this.qNI.equals(paramd.qNQ))
    {
      ab.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
      com.tencent.mm.x.c.PJ().y(262154, true);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxE, paramd.qNQ);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxF, paramd.qNR);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxG, paramd.qNS);
      onChange();
      AppMethodBeat.o(24525);
      return;
    }
    if (this.qNI.equals(paramd.qNQ)) {
      ab.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
    }
    AppMethodBeat.o(24525);
  }
  
  private static void clv()
  {
    AppMethodBeat.i(24521);
    qv localqv = new qv();
    com.tencent.mm.sdk.b.a.ymk.l(localqv);
    AppMethodBeat.o(24521);
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(24526);
    boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
    AppMethodBeat.o(24526);
    return bool;
  }
  
  private void onChange()
  {
    AppMethodBeat.i(24527);
    if (this.kkV == null)
    {
      AppMethodBeat.o(24527);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if (localObject != null) {
          ((a)localObject).clw();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(24527);
  }
  
  public final void j(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(24520);
    ab.i("MicroMsg.ShakeCardMsgMgr", "msg_id is ".concat(String.valueOf(paramLong)));
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
      AppMethodBeat.o(24520);
      return;
    }
    if (paramInt == 0)
    {
      ab.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
      a(Zb(paramString));
      clv();
    }
    for (;;)
    {
      com.tencent.mm.plugin.shake.c.c.a.clh();
      AppMethodBeat.o(24520);
      return;
      if (paramInt == 1)
      {
        ab.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
        a(Zc(paramString));
        clv();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void clw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */