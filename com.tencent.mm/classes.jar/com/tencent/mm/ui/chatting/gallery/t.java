package com.tencent.mm.ui.chatting.gallery;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.message.y;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.protocal.protobuf.cpt;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  private static final String TAG;
  public static final t aeGb;
  private static final String aeGc;
  private static final String aeGd;
  private static final String aeGe;
  private static final String aeGf;
  private static final String aeGg;
  private static final String aeGh;
  private static final HashMap<String, Boolean> aeGi;
  
  static
  {
    AppMethodBeat.i(39742);
    aeGb = new t();
    TAG = "MicroMsg.MpShareViewUtil";
    aeGc = "MpShareVideoPlayInfo";
    aeGd = "PlayUrl";
    aeGe = "VideoSize";
    aeGf = "SaveTime";
    aeGg = "block";
    aeGh = "errMsg";
    aeGi = new HashMap();
    AppMethodBeat.o(39742);
  }
  
  public static void a(String paramString, cpu paramcpu)
  {
    AppMethodBeat.i(39741);
    s.u(paramString, "key");
    s.u(paramcpu, "resp");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV(aeGc);
    localMultiProcessMMKV.encode(s.X(paramString, aeGe), paramcpu.Zhu);
    localMultiProcessMMKV.encode(s.X(paramString, aeGg), paramcpu.block);
    localMultiProcessMMKV.encode(s.X(paramString, aeGh), paramcpu.aawp);
    paramString = ad.bCb().M(paramString, true);
    paramString.aY(aeGd, paramcpu.OQR);
    paramcpu = aeGf;
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramcpu)) {
      paramString.oks.put(paramcpu, Long.valueOf(l));
    }
    AppMethodBeat.o(39741);
  }
  
  private static final void a(String paramString1, ah.f paramf, int paramInt1, int paramInt2, String paramString2, c paramc)
  {
    AppMethodBeat.i(254449);
    s.u(paramf, "$weakCallBack");
    Log.i(TAG, "getplayurl errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString2);
    aeGi.remove(paramString1);
    MMHandlerThread.postToMainThread(new t..ExternalSyntheticLambda1(paramf, paramInt1, paramInt2, paramString2, paramc));
    AppMethodBeat.o(254449);
  }
  
  private static final void a(ah.f paramf, int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(254447);
    s.u(paramf, "$weakCallBack");
    paramf = (IPCRunCgi.a)((WeakReference)paramf.aqH).get();
    if (paramf != null) {
      paramf.callback(paramInt1, paramInt2, paramString, paramc);
    }
    AppMethodBeat.o(254447);
  }
  
  public static boolean a(y paramy, String paramString, IPCRunCgi.a parama)
  {
    AppMethodBeat.i(254443);
    s.u(paramy, "mPShareVideoInfo");
    s.u(paramString, "imgPath");
    s.u(parama, "callBack");
    paramString = paramy.Hl(paramString);
    long l = ad.bCb().M(paramString, true).EP(aeGf);
    if (Math.abs(System.currentTimeMillis() - l) < 300000L)
    {
      s.s(paramString, "key");
      if (!Util.isNullOrNil(ajV(paramString)))
      {
        Log.i(TAG, "not do cgi in 5 min");
        AppMethodBeat.o(254443);
        return false;
      }
    }
    if ((aeGi.containsKey(paramString)) && (aeGi.get(paramString) != null))
    {
      localObject = aeGi.get(paramString);
      s.checkNotNull(localObject);
      s.s(localObject, "doingMap[key]!!");
      if (((Boolean)localObject).booleanValue())
      {
        Log.w(TAG, s.X(paramString, " is doing"));
        AppMethodBeat.o(254443);
        return false;
      }
    }
    Log.i(TAG, "MP_VIDEO  start do exchange video link");
    Object localObject = (Map)aeGi;
    s.s(paramString, "key");
    ((Map)localObject).put(paramString, Boolean.TRUE);
    localObject = new ah.f();
    ((ah.f)localObject).aqH = new WeakReference(parama);
    parama = new cpt();
    parama.vid = paramy.YMn;
    parama.aawn = paramy.YMm;
    parama.aawo = paramy.videoUrl;
    paramy = new c.a();
    paramy.otE = ((a)parama);
    paramy.otF = ((a)new cpu());
    paramy.uri = "/cgi-bin/mmbiz-bin/appmsg/getplayurl";
    paramy.funcId = 2962;
    paramy.otG = 0;
    paramy.respCmdId = 0;
    IPCRunCgi.a(paramy.bEF(), new t..ExternalSyntheticLambda0(paramString, (ah.f)localObject));
    AppMethodBeat.o(254443);
    return true;
  }
  
  public static String ajV(String paramString)
  {
    AppMethodBeat.i(39739);
    s.u(paramString, "key");
    paramString = ad.bCb().M(paramString, true);
    String str = paramString.getString(aeGd, "");
    long l = paramString.EP(aeGf);
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
    {
      AppMethodBeat.o(39739);
      return null;
    }
    AppMethodBeat.o(39739);
    return str;
  }
  
  public static drh bBp(String paramString)
  {
    AppMethodBeat.i(39740);
    s.u(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV(aeGc);
    drh localdrh = new drh();
    localdrh.Zhu = localMultiProcessMMKV.decodeInt(s.X(paramString, aeGe), 0);
    localdrh.block = localMultiProcessMMKV.decodeInt(s.X(paramString, aeGg), 0);
    localdrh.aawp = localMultiProcessMMKV.decodeString(s.X(paramString, aeGh), "");
    AppMethodBeat.o(39740);
    return localdrh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.t
 * JD-Core Version:    0.7.0.1
 */