package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;

final class SnsSelectContactDialog$2
  implements View.OnClickListener
{
  SnsSelectContactDialog$2(SnsSelectContactDialog paramSnsSelectContactDialog) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("Select_Contact", bk.c(SnsSelectContactDialog.c(this.pbH), ","));
    this.pbH.setResult(-1, paramView);
    this.pbH.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog.2
 * JD-Core Version:    0.7.0.1
 */