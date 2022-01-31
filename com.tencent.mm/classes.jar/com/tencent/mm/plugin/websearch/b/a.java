package com.tencent.mm.plugin.websearch.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends com.tencent.mm.ai.a<bxv>
{
  b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(91363);
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 1944;
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchlocalpage";
    ((b.a)localObject).fsX = new bxu();
    ((b.a)localObject).fsY = new bxv();
    this.rr = ((b.a)localObject).ado();
    this.rr = this.rr;
    localObject = (bxu)this.rr.fsV.fta;
    ((bxu)localObject).xHR = paramString;
    ((bxu)localObject).Scene = 25;
    ((bxu)localObject).lGH = com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext());
    ((bxu)localObject).xqU = com.tencent.mm.plugin.websearch.api.aa.acv();
    AppMethodBeat.o(91363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a
 * JD-Core Version:    0.7.0.1
 */