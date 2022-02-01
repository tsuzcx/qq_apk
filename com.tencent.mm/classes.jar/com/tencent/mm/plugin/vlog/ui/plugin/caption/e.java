package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "captionType", "", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "dataOffset", "totalLen", "voiceId", "(ILcom/tencent/mm/protobuf/ByteString;IIILcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCaptionType", "()I", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLastSeq", "", "()Z", "setLastSeq", "(Z)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSeq", "setSeq", "(I)V", "transRequest", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "getVoiceId", "()Lcom/tencent/mm/protobuf/ByteString;", "setVoiceId", "(Lcom/tencent/mm/protobuf/ByteString;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getProgress", "getTransResult", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-vlog_release"})
public final class e
  extends q
  implements m
{
  public static final a NyM;
  final int NxP;
  ArrayList<ta> NyJ;
  boolean NyK;
  b NyL;
  private i callback;
  String filePath;
  private com.tencent.mm.an.d kwO;
  int mbp;
  
  static
  {
    AppMethodBeat.i(226939);
    NyM = new a((byte)0);
    AppMethodBeat.o(226939);
  }
  
  public e(int paramInt1, b paramb1, int paramInt2, int paramInt3, int paramInt4, b paramb2)
  {
    AppMethodBeat.i(226936);
    this.NxP = paramInt1;
    this.mbp = paramInt2;
    this.NyL = paramb2;
    this.NyJ = new ArrayList();
    this.filePath = "";
    paramb2 = new d.a();
    paramb2.c((a)new tb());
    paramb2.d((a)new tc());
    paramb2.TW("/cgi-bin/micromsg-bin/mmccvoicetrans");
    paramb2.vD(3835);
    paramb2.vF(0);
    paramb2.vG(0);
    paramb2 = paramb2.bgN();
    p.j(paramb2, "builder.buildInstance()");
    this.kwO = paramb2;
    paramb2 = this.kwO.bhX();
    if (paramb2 == null)
    {
      paramb1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransRequest");
      AppMethodBeat.o(226936);
      throw paramb1;
    }
    paramb2 = (tb)paramb2;
    if (this.NyL == null)
    {
      Object localObject = String.valueOf(System.currentTimeMillis()) + hashCode();
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject == null)
      {
        paramb1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(226936);
        throw paramb1;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      this.NyL = new b((byte[])localObject);
    }
    paramb2.Sci = this.NyL;
    paramb2.mbp = this.mbp;
    paramb2.Scj = paramb1;
    paramb2.Sck = paramInt3;
    paramb2.Scl = paramInt4;
    paramb2.Scm = 10;
    if (paramb1 == null)
    {
      this.NyK = true;
      AppMethodBeat.o(226936);
      return;
    }
    if (paramb1.UH.length + paramInt3 >= paramInt4) {
      this.NyK = true;
    }
    AppMethodBeat.o(226936);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(226905);
    Log.i("MicroMsg.NetSceneGetVideoCaption", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(226905);
    return i;
  }
  
  public final int getProgress()
  {
    AppMethodBeat.i(226916);
    Object localObject = this.kwO.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(226916);
      throw ((Throwable)localObject);
    }
    int i = ((tc)localObject).progress;
    AppMethodBeat.o(226916);
    return i;
  }
  
  public final int getType()
  {
    return 3835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226912);
    Log.i("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneGetVideoCaption", "onGYNetEnd error");
    }
    this.NyJ.clear();
    params = this.NyJ;
    paramArrayOfByte = this.kwO.bhY();
    if (paramArrayOfByte == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CCVoiceTransResponse");
      AppMethodBeat.o(226912);
      throw paramString;
    }
    params.addAll((Collection)((tc)paramArrayOfByte).Scn);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(226912);
      return;
    }
    AppMethodBeat.o(226912);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.e
 * JD-Core Version:    0.7.0.1
 */