package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "captionType", "", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "dataOffset", "totalLen", "voiceId", "(ILcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCaptionType", "()I", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class e
  extends n
  implements k
{
  public static final e.a BRc;
  ArrayList<rt> BQZ;
  final int BQe;
  boolean BRa;
  com.tencent.mm.bx.b BRb;
  private f callback;
  String filePath;
  private com.tencent.mm.al.b gPp;
  int inh;
  
  static
  {
    AppMethodBeat.i(196596);
    BRc = new e.a((byte)0);
    AppMethodBeat.o(196596);
  }
  
  public e(int paramInt1, com.tencent.mm.bx.b paramb1, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bx.b paramb2)
  {
    AppMethodBeat.i(196595);
    this.BQe = paramInt1;
    this.inh = paramInt2;
    this.BRb = paramb2;
    this.BQZ = new ArrayList();
    this.filePath = "";
    paramb2 = new b.a();
    paramb2.c((a)new ru());
    paramb2.d((a)new rv());
    paramb2.Dl("/cgi-bin/micromsg-bin/mmccvoicetrans");
    paramb2.oP(3835);
    paramb2.oR(0);
    paramb2.oS(0);
    paramb2 = paramb2.aDC();
    p.g(paramb2, "builder.buildInstance()");
    this.gPp = paramb2;
    paramb2 = this.gPp.aEE();
    if (paramb2 == null)
    {
      paramb1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
      AppMethodBeat.o(196595);
      throw paramb1;
    }
    paramb2 = (ru)paramb2;
    if (this.BRb == null)
    {
      Object localObject = String.valueOf(System.currentTimeMillis()) + hashCode();
      Charset localCharset = d.UTF_8;
      if (localObject == null)
      {
        paramb1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(196595);
        throw paramb1;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      this.BRb = new com.tencent.mm.bx.b((byte[])localObject);
    }
    paramb2.FNU = this.BRb;
    paramb2.inh = this.inh;
    paramb2.FNV = paramb1;
    paramb2.FNW = paramInt3;
    paramb2.FNX = paramInt4;
    paramb2.FNY = 10;
    if (paramb1 == null)
    {
      this.BRa = true;
      AppMethodBeat.o(196595);
      return;
    }
    if (paramb1.size() + paramInt3 >= paramInt4) {
      this.BRa = true;
    }
    AppMethodBeat.o(196595);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(196592);
    ad.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(196592);
    return i;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(196594);
    Object localObject = this.gPp.aEF();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(196594);
      throw ((Throwable)localObject);
    }
    int i = ((rv)localObject).progress;
    AppMethodBeat.o(196594);
    return i;
  }
  
  public final int getType()
  {
    return 3835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196593);
    ad.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
    }
    this.BQZ.clear();
    paramq = this.BQZ;
    paramArrayOfByte = this.gPp.aEF();
    if (paramArrayOfByte == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(196593);
      throw paramString;
    }
    paramq.addAll((Collection)((rv)paramArrayOfByte).FNZ);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(196593);
      return;
    }
    AppMethodBeat.o(196593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.e
 * JD-Core Version:    0.7.0.1
 */