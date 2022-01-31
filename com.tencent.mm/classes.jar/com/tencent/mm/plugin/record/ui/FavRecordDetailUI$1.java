package com.tencent.mm.plugin.record.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.al;

final class FavRecordDetailUI$1
  implements k.a
{
  FavRecordDetailUI$1(FavRecordDetailUI paramFavRecordDetailUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(24202);
    if (paramm == null)
    {
      AppMethodBeat.o(24202);
      return;
    }
    if (paramm.obj == null)
    {
      AppMethodBeat.o(24202);
      return;
    }
    long l = ((Long)paramm.obj).longValue();
    if (l < 0L)
    {
      AppMethodBeat.o(24202);
      return;
    }
    if (FavRecordDetailUI.a(this.pZl) == l)
    {
      paramString = com.tencent.mm.plugin.record.b.g.kY(FavRecordDetailUI.a(this.pZl));
      paramm = new b();
      paramm.mCk = paramString;
      if ((paramString != null) && (paramString.field_favProto != null))
      {
        paramm.pZa = paramString.field_favProto.wVc;
        al.d(new FavRecordDetailUI.1.1(this, paramm));
      }
    }
    AppMethodBeat.o(24202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.1
 * JD-Core Version:    0.7.0.1
 */