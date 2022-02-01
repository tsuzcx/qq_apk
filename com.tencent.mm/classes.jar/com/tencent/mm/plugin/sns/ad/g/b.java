package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdc;

public final class b
  extends a<cdb, cdc>
{
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(270641);
    a(new cdb(), new cdc(), "/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon", 4743, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(270641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.b
 * JD-Core Version:    0.7.0.1
 */