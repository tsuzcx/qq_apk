package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/MpShareVideoPlayUtil;", "", "()V", "TAG", "", "doingMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDoingMap", "()Ljava/util/HashMap;", "mpShareVideoBlock", "getMpShareVideoBlock", "()Ljava/lang/String;", "mpShareVideoErrorMsg", "getMpShareVideoErrorMsg", "mpShareVideoPlayInfo", "getMpShareVideoPlayInfo", "mpShareVideoPlayURL", "getMpShareVideoPlayURL", "mpShareVideoSaveTime", "getMpShareVideoSaveTime", "mpShareVideoSize", "getMpShareVideoSize", "doGetPlayUrlCgi", "mPShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "imgPath", "callBack", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "getPlayUrl", "key", "getPlayUrlInfo", "Lcom/tencent/mm/protocal/protobuf/MpShareVideoPlayUrlInfo;", "setPlayInfo", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetPlayUrlResp;", "app_release"})
public final class m
{
  private static final String JTU = "MpShareVideoPlayInfo";
  private static final String JTV = "PlayUrl";
  private static final String JTW = "VideoSize";
  static final String JTX = "SaveTime";
  private static final String JTY = "block";
  private static final String JTZ = "errMsg";
  static final HashMap<String, Boolean> JUa;
  public static final m JUb;
  static final String TAG = "MicroMsg.MpShareViewUtil";
  
  static
  {
    AppMethodBeat.i(39742);
    JUb = new m();
    TAG = "MicroMsg.MpShareViewUtil";
    JTU = "MpShareVideoPlayInfo";
    JTV = "PlayUrl";
    JTW = "VideoSize";
    JTX = "SaveTime";
    JTY = "block";
    JTZ = "errMsg";
    JUa = new HashMap();
    AppMethodBeat.o(39742);
  }
  
  public static void a(String paramString, bgf parambgf)
  {
    AppMethodBeat.i(39741);
    p.h(paramString, "key");
    p.h(parambgf, "resp");
    ax localax = ax.aQA(JTU);
    localax.encode(paramString + JTW, parambgf.FUX);
    localax.encode(paramString + JTY, parambgf.GBD);
    localax.encode(paramString + JTZ, parambgf.GBE);
    paramString = y.aBq().F(paramString, true);
    paramString.aH(JTV, parambgf.yma);
    paramString.x(JTX, System.currentTimeMillis());
    AppMethodBeat.o(39741);
  }
  
  public static cbn aWu(String paramString)
  {
    AppMethodBeat.i(39740);
    p.h(paramString, "key");
    ax localax = ax.aQA(JTU);
    cbn localcbn = new cbn();
    localcbn.FUX = localax.decodeInt(paramString + JTW, 0);
    localcbn.GBD = localax.decodeInt(paramString + JTY, 0);
    localcbn.GBE = localax.decodeString(paramString + JTZ, "");
    AppMethodBeat.o(39740);
    return localcbn;
  }
  
  public static String asA(String paramString)
  {
    AppMethodBeat.i(39739);
    p.h(paramString, "key");
    paramString = y.aBq().F(paramString, true);
    String str = paramString.getString(JTV, "");
    long l = paramString.wn(JTX);
    if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
    {
      AppMethodBeat.o(39739);
      return null;
    }
    AppMethodBeat.o(39739);
    return str;
  }
  
  public static HashMap<String, Boolean> fGD()
  {
    return JUa;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(String paramString, y.f paramf) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final b paramb)
    {
      AppMethodBeat.i(39738);
      m localm = m.JUb;
      ad.i(m.fGE(), "getplayurl errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      localm = m.JUb;
      m.fGD().remove(this.kxJ);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39737);
          IPCRunCgi.a locala = (IPCRunCgi.a)((WeakReference)this.JUd.JUc.MLV).get();
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