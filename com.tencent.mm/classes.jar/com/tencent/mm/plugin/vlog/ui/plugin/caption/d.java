package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "", "dataOffset", "totalLen", "voiceId", "(Lcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "()I", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class d
  extends n
  implements com.tencent.mm.network.k
{
  public static final a LuZ;
  ArrayList<dxl> LuW;
  boolean LuX;
  com.tencent.mm.bx.b LuY;
  private g callback;
  String filePath;
  int htk;
  private com.tencent.mm.al.b iaa;
  
  static
  {
    AppMethodBeat.i(201210);
    LuZ = new a((byte)0);
    AppMethodBeat.o(201210);
  }
  
  public d(int paramInt1, int paramInt2, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(201209);
    this.htk = paramInt1;
    this.LuY = paramb;
    this.LuW = new ArrayList();
    this.filePath = "";
    paramb = new b.a();
    paramb.c((a)new dxm());
    paramb.d((a)new dxn());
    paramb.wg("/cgi-bin/micromsg-bin/mmccvoicetrans");
    paramb.nB(3835);
    paramb.nD(0);
    paramb.nE(0);
    paramb = paramb.atI();
    d.g.b.k.g(paramb, "builder.buildInstance()");
    this.iaa = paramb;
    paramb = this.iaa.auL();
    if (paramb == null)
    {
      paramb = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
      AppMethodBeat.o(201209);
      throw paramb;
    }
    paramb = (dxm)paramb;
    if (this.LuY == null)
    {
      Object localObject = String.valueOf(System.currentTimeMillis()) + hashCode();
      Charset localCharset = d.n.d.UTF_8;
      if (localObject == null)
      {
        paramb = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(201209);
        throw paramb;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      d.g.b.k.g(localObject, "(this as java.lang.String).getBytes(charset)");
      this.LuY = new com.tencent.mm.bx.b((byte[])localObject);
    }
    paramb.LwJ = this.LuY;
    paramb.htk = this.htk;
    paramb.Khv = null;
    paramb.LwK = 0;
    paramb.LwL = paramInt2;
    paramb.CUg = 10;
    this.LuX = true;
    AppMethodBeat.o(201209);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201206);
    ad.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201206);
    return i;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(201208);
    Object localObject = this.iaa.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(201208);
      throw ((Throwable)localObject);
    }
    int i = ((dxn)localObject).progress;
    AppMethodBeat.o(201208);
    return i;
  }
  
  public final int getType()
  {
    return 3835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201207);
    ad.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ad.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
    }
    this.LuW.clear();
    paramq = this.LuW;
    paramArrayOfByte = this.iaa.auM();
    if (paramArrayOfByte == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(201207);
      throw paramString;
    }
    paramq.addAll((Collection)((dxn)paramArrayOfByte).LwM);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201207);
      return;
    }
    AppMethodBeat.o(201207);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.d
 * JD-Core Version:    0.7.0.1
 */