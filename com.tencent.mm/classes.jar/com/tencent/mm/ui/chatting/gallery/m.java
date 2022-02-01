package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"})
public final class m
{
  private static final String PBA = "VideoSize";
  static final String PBB = "SaveTime";
  private static final String PBC = "block";
  private static final String PBD = "errMsg";
  static final HashMap<String, Boolean> PBE;
  public static final m PBF;
  private static final String PBy = "MpShareVideoPlayInfo";
  private static final String PBz = "PlayUrl";
  static final String TAG = "MicroMsg.MpShareViewUtil";
  
  static
  {
    AppMethodBeat.i(39742);
    PBF = new m();
    TAG = "MicroMsg.MpShareViewUtil";
    PBy = "MpShareVideoPlayInfo";
    PBz = "PlayUrl";
    PBA = "VideoSize";
    PBB = "SaveTime";
    PBC = "block";
    PBD = "errMsg";
    PBE = new HashMap();
    AppMethodBeat.o(39742);
  }
  
  public static void a(String paramString, bsr parambsr)
  {
    AppMethodBeat.i(39741);
    p.h(paramString, "key");
    p.h(parambsr, "resp");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV(PBy);
    localMultiProcessMMKV.encode(paramString + PBA, parambsr.Lia);
    localMultiProcessMMKV.encode(paramString + PBC, parambsr.LZv);
    localMultiProcessMMKV.encode(paramString + PBD, parambsr.LZw);
    paramString = ad.aVe().G(paramString, true);
    paramString.aK(PBz, parambsr.CEI);
    paramString.y(PBB, System.currentTimeMillis());
    AppMethodBeat.o(39741);
  }
  
  public static String aiK(String paramString)
  {
    AppMethodBeat.i(39739);
    p.h(paramString, "key");
    paramString = ad.aVe().G(paramString, true);
    String str = paramString.getString(PBz, "");
    long l = paramString.Fk(PBB);
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
    {
      AppMethodBeat.o(39739);
      return null;
    }
    AppMethodBeat.o(39739);
    return str;
  }
  
  public static crj bnb(String paramString)
  {
    AppMethodBeat.i(39740);
    p.h(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV(PBy);
    crj localcrj = new crj();
    localcrj.Lia = localMultiProcessMMKV.decodeInt(paramString + PBA, 0);
    localcrj.LZv = localMultiProcessMMKV.decodeInt(paramString + PBC, 0);
    localcrj.LZw = localMultiProcessMMKV.decodeString(paramString + PBD, "");
    AppMethodBeat.o(39740);
    return localcrj;
  }
  
  public static HashMap<String, Boolean> gTg()
  {
    return PBE;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString, z.f paramf) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
    {
      AppMethodBeat.i(39738);
      m localm = m.PBF;
      Log.i(m.gTh(), "getplayurl errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      localm = m.PBF;
      m.gTg().remove(this.$key);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39737);
          IPCRunCgi.a locala = (IPCRunCgi.a)((WeakReference)this.PBH.PBG.SYG).get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m
 * JD-Core Version:    0.7.0.1
 */