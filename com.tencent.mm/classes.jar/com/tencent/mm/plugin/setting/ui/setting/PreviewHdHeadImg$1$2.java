package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.base.n.d;

final class PreviewHdHeadImg$1$2
  implements n.d
{
  PreviewHdHeadImg$1$2(PreviewHdHeadImg.1 param1) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(126988);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(126988);
      return;
      a.gmP.n(this.qGp.qGo);
      AppMethodBeat.o(126988);
      return;
      PreviewHdHeadImg.b(this.qGp.qGo);
      AppMethodBeat.o(126988);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.setClass(this.qGp.qGo.getContext(), PreviewLastHdHeadImg.class);
      o.acQ();
      paramMenuItem.putExtra("CropImage_OutputPath", d.E(r.Zn() + ".crop", true));
      o.acQ();
      paramMenuItem.putExtra("last_avatar_path", d.E(r.Zn() + ".last", true));
      this.qGp.qGo.startActivityForResult(paramMenuItem, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1.2
 * JD-Core Version:    0.7.0.1
 */