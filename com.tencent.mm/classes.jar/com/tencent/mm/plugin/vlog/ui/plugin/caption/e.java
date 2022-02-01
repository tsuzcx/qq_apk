package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "captionType", "", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "dataOffset", "totalLen", "voiceId", "(ILcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCaptionType", "()I", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class e
  extends n
  implements k
{
  public static final a CiB;
  final int ChD;
  com.tencent.mm.bw.b CiA;
  ArrayList<rv> Ciy;
  boolean Ciz;
  private f callback;
  String filePath;
  private com.tencent.mm.ak.b gRX;
  int iqb;
  
  static
  {
    AppMethodBeat.i(192055);
    CiB = new a((byte)0);
    AppMethodBeat.o(192055);
  }
  
  public e(int paramInt1, com.tencent.mm.bw.b paramb1, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bw.b paramb2)
  {
    AppMethodBeat.i(192054);
    this.ChD = paramInt1;
    this.iqb = paramInt2;
    this.CiA = paramb2;
    this.Ciy = new ArrayList();
    this.filePath = "";
    paramb2 = new b.a();
    paramb2.c((a)new rw());
    paramb2.d((a)new rx());
    paramb2.DN("/cgi-bin/micromsg-bin/mmccvoicetrans");
    paramb2.oS(3835);
    paramb2.oU(0);
    paramb2.oV(0);
    paramb2 = paramb2.aDS();
    p.g(paramb2, "builder.buildInstance()");
    this.gRX = paramb2;
    paramb2 = this.gRX.aEU();
    if (paramb2 == null)
    {
      paramb1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
      AppMethodBeat.o(192054);
      throw paramb1;
    }
    paramb2 = (rw)paramb2;
    if (this.CiA == null)
    {
      Object localObject = String.valueOf(System.currentTimeMillis()) + hashCode();
      Charset localCharset = d.UTF_8;
      if (localObject == null)
      {
        paramb1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(192054);
        throw paramb1;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      this.CiA = new com.tencent.mm.bw.b((byte[])localObject);
    }
    paramb2.Ggt = this.CiA;
    paramb2.iqb = this.iqb;
    paramb2.Ggu = paramb1;
    paramb2.Ggv = paramInt3;
    paramb2.Ggw = paramInt4;
    paramb2.Ggx = 10;
    if (paramb1 == null)
    {
      this.Ciz = true;
      AppMethodBeat.o(192054);
      return;
    }
    if (paramb1.size() + paramInt3 >= paramInt4) {
      this.Ciz = true;
    }
    AppMethodBeat.o(192054);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(192051);
    ae.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(192051);
    return i;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(192053);
    Object localObject = this.gRX.aEV();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(192053);
      throw ((Throwable)localObject);
    }
    int i = ((rx)localObject).progress;
    AppMethodBeat.o(192053);
    return i;
  }
  
  public final int getType()
  {
    return 3835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192052);
    ae.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
    }
    this.Ciy.clear();
    paramq = this.Ciy;
    paramArrayOfByte = this.gRX.aEV();
    if (paramArrayOfByte == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(192052);
      throw paramString;
    }
    paramq.addAll((Collection)((rx)paramArrayOfByte).Ggy);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(192052);
      return;
    }
    AppMethodBeat.o(192052);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.e
 * JD-Core Version:    0.7.0.1
 */