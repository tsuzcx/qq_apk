package com.tencent.mm.plugin.sns.ad.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;

public final class b
  extends a<bvj, bvk>
{
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(202054);
    a(new bvj(), new bvk(), "/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon", 4743, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(202054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.b
 * JD-Core Version:    0.7.0.1
 */