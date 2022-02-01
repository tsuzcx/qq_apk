package com.tencent.mm.plugin.sns.ad.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.cso;

public final class c
  extends a<csn, cso>
{
  public c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(309867);
    a(new csn(), new cso(), "/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon", 4743, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(309867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.h.c
 * JD-Core Version:    0.7.0.1
 */