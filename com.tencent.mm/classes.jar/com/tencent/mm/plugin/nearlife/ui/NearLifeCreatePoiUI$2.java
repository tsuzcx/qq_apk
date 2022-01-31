package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class NearLifeCreatePoiUI$2
  implements View.OnClickListener
{
  NearLifeCreatePoiUI$2(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.mFF.mController.uMN, SelectPoiCategoryUI.class);
    this.mFF.startActivityForResult(paramView, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.2
 * JD-Core Version:    0.7.0.1
 */