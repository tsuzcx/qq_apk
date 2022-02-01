package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"})
public final class r
{
  static final String TAG = "MicroMsg.MpShareViewUtil";
  private static final String WWA = "errMsg";
  static final HashMap<String, Boolean> WWB;
  public static final r WWC;
  private static final String WWv = "MpShareVideoPlayInfo";
  private static final String WWw = "PlayUrl";
  private static final String WWx = "VideoSize";
  static final String WWy = "SaveTime";
  private static final String WWz = "block";
  
  static
  {
    AppMethodBeat.i(39742);
    WWC = new r();
    TAG = "MicroMsg.MpShareViewUtil";
    WWv = "MpShareVideoPlayInfo";
    WWw = "PlayUrl";
    WWx = "VideoSize";
    WWy = "SaveTime";
    WWz = "block";
    WWA = "errMsg";
    WWB = new HashMap();
    AppMethodBeat.o(39742);
  }
  
  public static void a(String paramString, cal paramcal)
  {
    AppMethodBeat.i(39741);
    p.k(paramString, "key");
    p.k(paramcal, "resp");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV(WWv);
    localMultiProcessMMKV.encode(paramString + WWx, paramcal.Sjq);
    localMultiProcessMMKV.encode(paramString + WWz, paramcal.block);
    localMultiProcessMMKV.encode(paramString + WWA, paramcal.TiP);
    paramString = ad.beh().I(paramString, true);
    paramString.aO(WWw, paramcal.IKh);
    paramString.v(WWy, System.currentTimeMillis());
    AppMethodBeat.o(39741);
  }
  
  public static String aqw(String paramString)
  {
    AppMethodBeat.i(39739);
    p.k(paramString, "key");
    paramString = ad.beh().I(paramString, true);
    String str = paramString.getString(WWw, "");
    long l = paramString.Mh(WWy);
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
    {
      AppMethodBeat.o(39739);
      return null;
    }
    AppMethodBeat.o(39739);
    return str;
  }
  
  public static daa bzB(String paramString)
  {
    AppMethodBeat.i(39740);
    p.k(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV(WWv);
    daa localdaa = new daa();
    localdaa.Sjq = localMultiProcessMMKV.decodeInt(paramString + WWx, 0);
    localdaa.block = localMultiProcessMMKV.decodeInt(paramString + WWz, 0);
    localdaa.TiP = localMultiProcessMMKV.decodeString(paramString + WWA, "");
    AppMethodBeat.o(39740);
    return localdaa;
  }
  
  public static HashMap<String, Boolean> hSN()
  {
    return WWB;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString, aa.f paramf) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
    {
      AppMethodBeat.i(39738);
      r localr = r.WWC;
      Log.i(r.hSO(), "getplayurl errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      localr = r.WWC;
      r.hSN().remove(this.$key);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39737);
          IPCRunCgi.a locala = (IPCRunCgi.a)((WeakReference)this.WWE.WWD.aaBC).get();
          if (locala != null)
          {
            locala.a(paramInt1, paramInt2, paramString, paramd);
            AppMethodBeat.o(39737);
            return;
          }
          AppMethodBeat.o(39737);
        }
      });
      AppMethodBeat.o(39738);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.r
 * JD-Core Version:    0.7.0.1
 */