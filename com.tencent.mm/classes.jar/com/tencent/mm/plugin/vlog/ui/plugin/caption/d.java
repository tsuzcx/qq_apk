package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "", "dataOffset", "totalLen", "voiceId", "(Lcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "()I", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class d
  extends n
  implements com.tencent.mm.network.k
{
  public static final a Aut;
  ArrayList<qc> Auq;
  boolean Aur;
  com.tencent.mm.bw.b Aus;
  private g callback;
  String filePath;
  private com.tencent.mm.ak.b gvE;
  int hTM;
  
  static
  {
    AppMethodBeat.i(207895);
    Aut = new a((byte)0);
    AppMethodBeat.o(207895);
  }
  
  public d(int paramInt1, int paramInt2, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(207894);
    this.hTM = paramInt1;
    this.Aus = paramb;
    this.Auq = new ArrayList();
    this.filePath = "";
    paramb = new b.a();
    paramb.c((a)new qd());
    paramb.d((a)new qe());
    paramb.Am("/cgi-bin/micromsg-bin/mmccvoicetrans");
    paramb.op(3835);
    paramb.or(0);
    paramb.os(0);
    paramb = paramb.aAz();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.gvE = paramb;
    paramb = this.gvE.aBC();
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
      AppMethodBeat.o(207894);
      throw paramb;
    }
    paramb = (qd)paramb;
    if (this.Aus == null)
    {
      Object localObject = String.valueOf(System.currentTimeMillis()) + hashCode();
      Charset localCharset = d.n.d.UTF_8;
      if (localObject == null)
      {
        paramb = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(207894);
        throw paramb;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      d.g.b.k.g(localObject, "(this as java.lang.String).getBytes(charset)");
      this.Aus = new com.tencent.mm.bw.b((byte[])localObject);
    }
    paramb.EgN = this.Aus;
    paramb.hTM = this.hTM;
    paramb.EgO = null;
    paramb.EgP = 0;
    paramb.EgQ = paramInt2;
    paramb.EgR = 10;
    this.Aur = true;
    AppMethodBeat.o(207894);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(207891);
    ac.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(207891);
    return i;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(207893);
    Object localObject = this.gvE.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(207893);
      throw ((Throwable)localObject);
    }
    int i = ((qe)localObject).progress;
    AppMethodBeat.o(207893);
    return i;
  }
  
  public final int getType()
  {
    return 3835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207892);
    ac.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
    }
    this.Auq.clear();
    paramq = this.Auq;
    paramArrayOfByte = this.gvE.aBD();
    if (paramArrayOfByte == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(207892);
      throw paramString;
    }
    paramq.addAll((Collection)((qe)paramArrayOfByte).EgS);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(207892);
      return;
    }
    AppMethodBeat.o(207892);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.d
 * JD-Core Version:    0.7.0.1
 */