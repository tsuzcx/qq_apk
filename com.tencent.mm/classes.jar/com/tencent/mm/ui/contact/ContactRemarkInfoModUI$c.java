package com.tencent.mm.ui.contact;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.R.e;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.MMClearEditText;

final class ContactRemarkInfoModUI$c
  extends ClickableSpan
{
  public String fGK;
  
  public ContactRemarkInfoModUI$c(ContactRemarkInfoModUI paramContactRemarkInfoModUI, String paramString)
  {
    this.fGK = paramString;
  }
  
  public final void onClick(View paramView)
  {
    ContactRemarkInfoModUI.f(this.vKT);
    ContactRemarkInfoModUI.a(this.vKT, true, -1);
    ContactRemarkInfoModUI.g(this.vKT).setText(j.a(this.vKT, ah.pm(this.fGK), ContactRemarkInfoModUI.g(this.vKT).getTextSize()));
    ContactRemarkInfoModUI.g(this.vKT).setSelection(ContactRemarkInfoModUI.g(this.vKT).getText().length());
    ContactRemarkInfoModUI.x(this.vKT).setVisibility(8);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.vKT.getResources().getColor(R.e.blue_text_color));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.c
 * JD-Core Version:    0.7.0.1
 */