package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ai;

final class FavRecordDetailUI$1
  implements j.a
{
  FavRecordDetailUI$1(FavRecordDetailUI paramFavRecordDetailUI) {}
  
  public final void a(String paramString, l paraml)
  {
    if (paraml == null) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while (paraml.obj == null);
        l = ((Long)paraml.obj).longValue();
      } while ((l < 0L) || (FavRecordDetailUI.a(this.ntD) != l));
      paramString = com.tencent.mm.plugin.record.b.b.fu(FavRecordDetailUI.a(this.ntD));
      paraml = new b();
      paraml.khA = paramString;
    } while ((paramString == null) || (paramString.field_favProto == null));
    paraml.ntu = paramString.field_favProto.sXc;
    ai.d(new FavRecordDetailUI.1.1(this, paraml));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.1
 * JD-Core Version:    0.7.0.1
 */