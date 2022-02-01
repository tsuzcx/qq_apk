package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"})
public final class m
{
  private static final String GEA = "block";
  private static final String GEB = "errMsg";
  static final HashMap<String, Boolean> GEC;
  public static final m GED;
  private static final String GEw = "MpShareVideoPlayInfo";
  private static final String GEx = "PlayUrl";
  private static final String GEy = "VideoSize";
  static final String GEz = "SaveTime";
  static final String TAG = "MicroMsg.MpShareViewUtil";
  
  static
  {
    AppMethodBeat.i(39742);
    GED = new m();
    TAG = "MicroMsg.MpShareViewUtil";
    GEw = "MpShareVideoPlayInfo";
    GEx = "PlayUrl";
    GEy = "VideoSize";
    GEz = "SaveTime";
    GEA = "block";
    GEB = "errMsg";
    GEC = new HashMap();
    AppMethodBeat.o(39742);
  }
  
  public static void a(String paramString, ayj paramayj)
  {
    AppMethodBeat.i(39741);
    k.h(paramString, "key");
    k.h(paramayj, "resp");
    ax localax = ax.aFD(GEw);
    localax.encode(paramString + GEy, paramayj.CVe);
    localax.encode(paramString + GEA, paramayj.DwQ);
    localax.encode(paramString + GEB, paramayj.DwR);
    paramString = y.arz().E(paramString, true);
    paramString.ax(GEx, paramayj.vNV);
    paramString.u(GEz, System.currentTimeMillis());
    AppMethodBeat.o(39741);
  }
  
  public static bsg aKX(String paramString)
  {
    AppMethodBeat.i(39740);
    k.h(paramString, "key");
    ax localax = ax.aFD(GEw);
    bsg localbsg = new bsg();
    localbsg.CVe = localax.decodeInt(paramString + GEy, 0);
    localbsg.DwQ = localax.decodeInt(paramString + GEA, 0);
    localbsg.DwR = localax.decodeString(paramString + GEB, "");
    AppMethodBeat.o(39740);
    return localbsg;
  }
  
  public static String aiG(String paramString)
  {
    AppMethodBeat.i(39739);
    k.h(paramString, "key");
    paramString = y.arz().E(paramString, true);
    String str = paramString.getString(GEx, "");
    long l = paramString.aa(GEz);
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
    {
      AppMethodBeat.o(39739);
      return null;
    }
    AppMethodBeat.o(39739);
    return str;
  }
  
  public static HashMap<String, Boolean> fae()
  {
    return GEC;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString, v.e parame) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final b paramb)
    {
      AppMethodBeat.i(39738);
      m localm = m.GED;
      ad.i(m.faf(), "getplayurl errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      localm = m.GED;
      m.fae().remove(this.jCN);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39737);
          IPCRunCgi.a locala = (IPCRunCgi.a)((WeakReference)this.GEF.GEE.Jhw).get();
          if (locala != null)
          {
            locala.a(paramInt1, paramInt2, paramString, paramb);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m
 * JD-Core Version:    0.7.0.1
 */