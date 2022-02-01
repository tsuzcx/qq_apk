package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"})
public final class m
{
  static final HashMap<String, Boolean> KpA;
  public static final m KpB;
  private static final String Kpu = "MpShareVideoPlayInfo";
  private static final String Kpv = "PlayUrl";
  private static final String Kpw = "VideoSize";
  static final String Kpx = "SaveTime";
  private static final String Kpy = "block";
  private static final String Kpz = "errMsg";
  static final String TAG = "MicroMsg.MpShareViewUtil";
  
  static
  {
    AppMethodBeat.i(39742);
    KpB = new m();
    TAG = "MicroMsg.MpShareViewUtil";
    Kpu = "MpShareVideoPlayInfo";
    Kpv = "PlayUrl";
    Kpw = "VideoSize";
    Kpx = "SaveTime";
    Kpy = "block";
    Kpz = "errMsg";
    KpA = new HashMap();
    AppMethodBeat.o(39742);
  }
  
  public static String YI(String paramString)
  {
    AppMethodBeat.i(39739);
    p.h(paramString, "key");
    paramString = z.aBG().F(paramString, true);
    String str = paramString.getString(Kpv, "");
    long l = paramString.wW(Kpx);
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
    {
      AppMethodBeat.o(39739);
      return null;
    }
    AppMethodBeat.o(39739);
    return str;
  }
  
  public static void a(String paramString, bgv parambgv)
  {
    AppMethodBeat.i(39741);
    p.h(paramString, "key");
    p.h(parambgv, "resp");
    ay localay = ay.aRX(Kpu);
    localay.encode(paramString + Kpw, parambgv.Gnw);
    localay.encode(paramString + Kpy, parambgv.GVd);
    localay.encode(paramString + Kpz, parambgv.GVe);
    paramString = z.aBG().F(paramString, true);
    paramString.aI(Kpv, parambgv.yBZ);
    paramString.x(Kpx, System.currentTimeMillis());
    AppMethodBeat.o(39741);
  }
  
  public static cch aXW(String paramString)
  {
    AppMethodBeat.i(39740);
    p.h(paramString, "key");
    ay localay = ay.aRX(Kpu);
    cch localcch = new cch();
    localcch.Gnw = localay.decodeInt(paramString + Kpw, 0);
    localcch.GVd = localay.decodeInt(paramString + Kpy, 0);
    localcch.GVe = localay.decodeString(paramString + Kpz, "");
    AppMethodBeat.o(39740);
    return localcch;
  }
  
  public static HashMap<String, Boolean> fKO()
  {
    return KpA;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString, y.f paramf) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final b paramb)
    {
      AppMethodBeat.i(39738);
      m localm = m.KpB;
      ae.i(m.fKP(), "getplayurl errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      localm = m.KpB;
      m.fKO().remove(this.kAY);
      ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39737);
          IPCRunCgi.a locala = (IPCRunCgi.a)((WeakReference)this.KpD.KpC.NiY).get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m
 * JD-Core Version:    0.7.0.1
 */