package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"})
public final class m
{
  public static final m IeA;
  private static final String Iet = "MpShareVideoPlayInfo";
  private static final String Ieu = "PlayUrl";
  private static final String Iev = "VideoSize";
  static final String Iew = "SaveTime";
  private static final String Iex = "block";
  private static final String Iey = "errMsg";
  static final HashMap<String, Boolean> Iez;
  static final String TAG = "MicroMsg.MpShareViewUtil";
  
  static
  {
    AppMethodBeat.i(39742);
    IeA = new m();
    TAG = "MicroMsg.MpShareViewUtil";
    Iet = "MpShareVideoPlayInfo";
    Ieu = "PlayUrl";
    Iev = "VideoSize";
    Iew = "SaveTime";
    Iex = "block";
    Iey = "errMsg";
    Iez = new HashMap();
    AppMethodBeat.o(39742);
  }
  
  public static void a(String paramString, bcb parambcb)
  {
    AppMethodBeat.i(39741);
    k.h(paramString, "key");
    k.h(parambcb, "resp");
    aw localaw = aw.aKU(Iet);
    localaw.encode(paramString + Iev, parambcb.EnO);
    localaw.encode(paramString + Iex, parambcb.ESl);
    localaw.encode(paramString + Iey, parambcb.ESm);
    paramString = y.ayq().F(paramString, true);
    paramString.aF(Ieu, parambcb.wYr);
    paramString.v(Iew, System.currentTimeMillis());
    AppMethodBeat.o(39741);
  }
  
  public static bwx aQC(String paramString)
  {
    AppMethodBeat.i(39740);
    k.h(paramString, "key");
    aw localaw = aw.aKU(Iet);
    bwx localbwx = new bwx();
    localbwx.EnO = localaw.decodeInt(paramString + Iev, 0);
    localbwx.ESl = localaw.decodeInt(paramString + Iex, 0);
    localbwx.ESm = localaw.decodeString(paramString + Iey, "");
    AppMethodBeat.o(39740);
    return localbwx;
  }
  
  public static String anB(String paramString)
  {
    AppMethodBeat.i(39739);
    k.h(paramString, "key");
    paramString = y.ayq().F(paramString, true);
    String str = paramString.getString(Ieu, "");
    long l = paramString.tx(Iew);
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
    {
      AppMethodBeat.o(39739);
      return null;
    }
    AppMethodBeat.o(39739);
    return str;
  }
  
  public static HashMap<String, Boolean> fpU()
  {
    return Iez;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString, v.f paramf) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final b paramb)
    {
      AppMethodBeat.i(39738);
      m localm = m.IeA;
      ac.i(m.fpV(), "getplayurl errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      localm = m.IeA;
      m.fpU().remove(this.kdj);
      ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39737);
          IPCRunCgi.a locala = (IPCRunCgi.a)((WeakReference)this.IeC.IeB.KUQ).get();
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