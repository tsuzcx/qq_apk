package com.tencent.mm.ui.contact;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.MMClearEditText;

final class ContactRemarkInfoModUI$c
  extends ClickableSpan
{
  public String hKa;
  
  public ContactRemarkInfoModUI$c(ContactRemarkInfoModUI paramContactRemarkInfoModUI, String paramString)
  {
    this.hKa = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33649);
    ContactRemarkInfoModUI.f(this.Acv);
    ContactRemarkInfoModUI.a(this.Acv, true, -1);
    ContactRemarkInfoModUI.g(this.Acv).setText(j.b(this.Acv, ah.nullAsNil(this.hKa), ContactRemarkInfoModUI.g(this.Acv).getTextSize()));
    ContactRemarkInfoModUI.g(this.Acv).setSelection(ContactRemarkInfoModUI.g(this.Acv).getText().length());
    ContactRemarkInfoModUI.w(this.Acv).setVisibility(8);
    AppMethodBeat.o(33649);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(33650);
    paramTextPaint.setColor(this.Acv.getResources().getColor(2131689771));
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(33650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.c
 * JD-Core Version:    0.7.0.1
 */