package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "captionType", "", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "dataOffset", "totalLen", "voiceId", "(ILcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCaptionType", "()I", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends p
  implements m
{
  public static final a UlH;
  final int UkR;
  b UlI;
  ArrayList<uq> UlJ;
  boolean UlK;
  private h callback;
  String filePath;
  private c nao;
  int oUj;
  
  static
  {
    AppMethodBeat.i(283239);
    UlH = new a((byte)0);
    AppMethodBeat.o(283239);
  }
  
  public e(int paramInt1, b paramb1, int paramInt2, int paramInt3, int paramInt4, b paramb2)
  {
    AppMethodBeat.i(283237);
    this.UkR = paramInt1;
    this.oUj = paramInt2;
    this.UlI = paramb2;
    this.UlJ = new ArrayList();
    this.filePath = "";
    paramb2 = new c.a();
    paramb2.otE = ((a)new ur());
    paramb2.otF = ((a)new us());
    paramb2.uri = "/cgi-bin/micromsg-bin/mmccvoicetrans";
    paramb2.funcId = 3835;
    paramb2.otG = 0;
    paramb2.respCmdId = 0;
    paramb2 = paramb2.bEF();
    kotlin.g.b.s.s(paramb2, "builder.buildInstance()");
    this.nao = paramb2;
    paramb2 = c.b.b(this.nao.otB);
    if (paramb2 == null)
    {
      paramb1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
      AppMethodBeat.o(283237);
      throw paramb1;
    }
    paramb2 = (ur)paramb2;
    if (this.UlI == null)
    {
      Object localObject = System.currentTimeMillis() + hashCode();
      Charset localCharset = d.UTF_8;
      if (localObject == null)
      {
        paramb1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(283237);
        throw paramb1;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      this.UlI = new b((byte[])localObject);
    }
    paramb2.Zaa = this.UlI;
    paramb2.oUj = this.oUj;
    paramb2.Zab = paramb1;
    paramb2.Zac = paramInt3;
    paramb2.Zad = paramInt4;
    paramb2.Zae = 10;
    if (paramb1 == null)
    {
      this.UlK = true;
      AppMethodBeat.o(283237);
      return;
    }
    if (paramb1.Op.length + paramInt3 >= paramInt4) {
      this.UlK = true;
    }
    AppMethodBeat.o(283237);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(283249);
    Log.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
    AppMethodBeat.o(283249);
    return i;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(283261);
    Object localObject = c.c.b(this.nao.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(283261);
      throw ((Throwable)localObject);
    }
    int i = ((us)localObject).progress;
    AppMethodBeat.o(283261);
    return i;
  }
  
  public final int getType()
  {
    return 3835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(283256);
    Log.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
    }
    this.UlJ.clear();
    params = this.UlJ;
    paramArrayOfByte = c.c.b(this.nao.otC);
    if (paramArrayOfByte == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(283256);
      throw paramString;
    }
    params.addAll((Collection)((us)paramArrayOfByte).Zaf);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(283256);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.e
 * JD-Core Version:    0.7.0.1
 */