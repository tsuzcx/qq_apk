package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectContactUI$a
{
  private AlphaAnimation Afo;
  private AlphaAnimation Afp;
  boolean Afq = false;
  TextView ivt;
  
  final void aE(Activity paramActivity)
  {
    AppMethodBeat.i(33870);
    if (this.ivt == null) {
      this.ivt = ((TextView)paramActivity.findViewById(2131820919));
    }
    if (this.ivt.getVisibility() == 8)
    {
      AppMethodBeat.o(33870);
      return;
    }
    if (this.Afp == null)
    {
      this.Afp = new AlphaAnimation(1.0F, 0.0F);
      this.Afp.setAnimationListener(new SelectContactUI.a.2(this));
    }
    this.Afp.setDuration(300L);
    if (this.Afo != null) {
      this.Afo.cancel();
    }
    this.ivt.startAnimation(this.Afp);
    AppMethodBeat.o(33870);
  }
  
  public final void e(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33869);
    if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.Afq))
    {
      if (this.ivt == null) {
        this.ivt = ((TextView)paramActivity.findViewById(2131820919));
      }
      if (this.ivt.getVisibility() != 0)
      {
        this.ivt.setText(2131302664);
        this.ivt.setOnClickListener(new SelectContactUI.a.1(this, paramActivity));
        if (this.Afo == null) {
          this.Afo = new AlphaAnimation(0.0F, 1.0F);
        }
        this.Afo.setDuration(300L);
        if (this.Afp != null) {
          this.Afp.cancel();
        }
        this.ivt.setVisibility(0);
        this.ivt.startAnimation(this.Afo);
      }
      AppMethodBeat.o(33869);
      return;
    }
    if (paramInt1 < paramInt2)
    {
      aE(paramActivity);
      this.Afq = false;
    }
    AppMethodBeat.o(33869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.a
 * JD-Core Version:    0.7.0.1
 */