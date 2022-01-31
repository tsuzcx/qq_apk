package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class PreviewHdHeadImg$1$2
  implements n.d
{
  PreviewHdHeadImg$1$2(PreviewHdHeadImg.1 param1) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      a.eUS.m(this.nSr.nSq);
      return;
    case 2: 
      PreviewHdHeadImg.b(this.nSr.nSq);
      return;
    }
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.nSr.nSq.mController.uMN, PreviewLastHdHeadImg.class);
    o.JQ();
    paramMenuItem.putExtra("CropImage_OutputPath", d.A(q.Gj() + ".crop", true));
    o.JQ();
    paramMenuItem.putExtra("last_avatar_path", d.A(q.Gj() + ".last", true));
    this.nSr.nSq.startActivityForResult(paramMenuItem, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1.2
 * JD-Core Version:    0.7.0.1
 */