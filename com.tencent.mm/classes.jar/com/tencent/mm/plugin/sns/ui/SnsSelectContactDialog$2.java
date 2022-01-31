package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsSelectContactDialog$2
  implements View.OnClickListener
{
  SnsSelectContactDialog$2(SnsSelectContactDialog paramSnsSelectContactDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39188);
    paramView = new Intent();
    paramView.putExtra("Select_Contact", bo.d(SnsSelectContactDialog.c(this.rUr), ","));
    this.rUr.setResult(-1, paramView);
    this.rUr.finish();
    AppMethodBeat.o(39188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog.2
 * JD-Core Version:    0.7.0.1
 */