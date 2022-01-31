package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.y;

final class b$c
  implements View.OnClickListener
{
  private b$c(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof b.e)) {
      return;
    }
    b.f(this.ogK).bBw();
    paramView = (b.e)paramView.getTag();
    if (paramView.ogR == null)
    {
      y.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
      return;
    }
    paramView.ogR.field_fileStatus = 6;
    o.Sv().c(paramView.ogR, new String[] { "localId" });
    this.ogK.a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b.c
 * JD-Core Version:    0.7.0.1
 */