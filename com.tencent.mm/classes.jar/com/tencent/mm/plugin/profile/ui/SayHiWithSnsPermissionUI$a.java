package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.R.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;

final class SayHiWithSnsPermissionUI$a
  extends ClickableSpan
{
  public String fGK;
  
  public SayHiWithSnsPermissionUI$a(SayHiWithSnsPermissionUI paramSayHiWithSnsPermissionUI, String paramString)
  {
    this.fGK = paramString;
  }
  
  public final void onClick(View paramView)
  {
    SayHiWithSnsPermissionUI.b(this.mZo).setText(j.a(this.mZo, bk.pm(this.fGK), SayHiWithSnsPermissionUI.b(this.mZo).getTextSize()));
    SayHiWithSnsPermissionUI.b(this.mZo).setSelection(SayHiWithSnsPermissionUI.b(this.mZo).getText().length());
    SayHiWithSnsPermissionUI.m(this.mZo).setVisibility(8);
    SayHiWithSnsPermissionUI.l(this.mZo)[4] = 1;
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.mZo.getResources().getColor(R.e.blue_text_color));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI.a
 * JD-Core Version:    0.7.0.1
 */