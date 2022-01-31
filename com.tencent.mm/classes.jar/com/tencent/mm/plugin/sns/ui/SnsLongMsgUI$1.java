package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class SnsLongMsgUI$1
  implements View.OnClickListener
{
  SnsLongMsgUI$1(SnsLongMsgUI paramSnsLongMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39061);
    paramView = new Intent();
    paramView.setClass(this.rSF, SnsUploadUI.class);
    paramView.putExtra("KSnsPostManu", true);
    paramView.putExtra("KTouchCameraTime", bo.aox());
    paramView.putExtra("sns_comment_type", 1);
    paramView.putExtra("Ksnsupload_type", 9);
    this.rSF.startActivity(paramView);
    this.rSF.finish();
    AppMethodBeat.o(39061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLongMsgUI.1
 * JD-Core Version:    0.7.0.1
 */