package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "captionType", "", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "dataOffset", "totalLen", "voiceId", "(ILcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCaptionType", "()I", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class e
  extends q
  implements m
{
  public static final a GLm;
  public final int GKp;
  public ArrayList<sy> GLj;
  public boolean GLk;
  public b GLl;
  private i callback;
  public String filePath;
  private com.tencent.mm.ak.d hJu;
  public int jlm;
  
  static
  {
    AppMethodBeat.i(191745);
    GLm = new a((byte)0);
    AppMethodBeat.o(191745);
  }
  
  public e(int paramInt1, b paramb1, int paramInt2, int paramInt3, int paramInt4, b paramb2)
  {
    AppMethodBeat.i(191744);
    this.GKp = paramInt1;
    this.jlm = paramInt2;
    this.GLl = paramb2;
    this.GLj = new ArrayList();
    this.filePath = "";
    paramb2 = new d.a();
    paramb2.c((a)new sz());
    paramb2.d((a)new ta());
    paramb2.MB("/cgi-bin/micromsg-bin/mmccvoicetrans");
    paramb2.sG(3835);
    paramb2.sI(0);
    paramb2.sJ(0);
    paramb2 = paramb2.aXF();
    p.g(paramb2, "builder.buildInstance()");
    this.hJu = paramb2;
    paramb2 = this.hJu.aYJ();
    if (paramb2 == null)
    {
      paramb1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
      AppMethodBeat.o(191744);
      throw paramb1;
    }
    paramb2 = (sz)paramb2;
    if (this.GLl == null)
    {
      Object localObject = String.valueOf(System.currentTimeMillis()) + hashCode();
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject == null)
      {
        paramb1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(191744);
        throw paramb1;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      this.GLl = new b((byte[])localObject);
    }
    paramb2.LaW = this.GLl;
    paramb2.jlm = this.jlm;
    paramb2.LaX = paramb1;
    paramb2.LaY = paramInt3;
    paramb2.LaZ = paramInt4;
    paramb2.Lba = 10;
    if (paramb1 == null)
    {
      this.GLk = true;
      AppMethodBeat.o(191744);
      return;
    }
    if (paramb1.zy.length + paramInt3 >= paramInt4) {
      this.GLk = true;
    }
    AppMethodBeat.o(191744);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(191741);
    Log.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(191741);
    return i;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(191743);
    Object localObject = this.hJu.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(191743);
      throw ((Throwable)localObject);
    }
    int i = ((ta)localObject).progress;
    AppMethodBeat.o(191743);
    return i;
  }
  
  public final int getType()
  {
    return 3835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(191742);
    Log.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
    }
    this.GLj.clear();
    params = this.GLj;
    paramArrayOfByte = this.hJu.aYK();
    if (paramArrayOfByte == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(191742);
      throw paramString;
    }
    params.addAll((Collection)((ta)paramArrayOfByte).Lbb);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(191742);
      return;
    }
    AppMethodBeat.o(191742);
  }
  
  public final void setFilePath(String paramString)
  {
    AppMethodBeat.i(191740);
    p.h(paramString, "<set-?>");
    this.filePath = paramString;
    AppMethodBeat.o(191740);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.e
 * JD-Core Version:    0.7.0.1
 */