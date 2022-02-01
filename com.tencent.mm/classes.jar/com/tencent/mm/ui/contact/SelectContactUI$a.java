package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SelectContactUI$a
{
  private AlphaAnimation Xwt;
  private AlphaAnimation Xwu;
  boolean Xwv = false;
  TextView qpt;
  
  final void by(Activity paramActivity)
  {
    AppMethodBeat.i(37989);
    if (this.qpt == null) {
      this.qpt = ((TextView)paramActivity.findViewById(R.h.select_contact_float_tips));
    }
    if (this.qpt.getVisibility() == 8)
    {
      AppMethodBeat.o(37989);
      return;
    }
    if (this.Xwu == null)
    {
      this.Xwu = new AlphaAnimation(1.0F, 0.0F);
      this.Xwu.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(37987);
          SelectContactUI.a.this.qpt.setVisibility(8);
          AppMethodBeat.o(37987);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    this.Xwu.setDuration(300L);
    if (this.Xwt != null) {
      this.Xwt.cancel();
    }
    this.qpt.startAnimation(this.Xwu);
    AppMethodBeat.o(37989);
  }
  
  public final void e(final Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37988);
    if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.Xwv))
    {
      if (this.qpt == null) {
        this.qpt = ((TextView)paramActivity.findViewById(R.h.select_contact_float_tips));
      }
      if (this.qpt.getVisibility() != 0)
      {
        this.qpt.setText(R.l.eQG);
        this.qpt.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37986);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SelectContactUI.a.this.Xwv = true;
            SelectContactUI.a.this.by(paramActivity);
            a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37986);
          }
        });
        if (this.Xwt == null) {
          this.Xwt = new AlphaAnimation(0.0F, 1.0F);
        }
        this.Xwt.setDuration(300L);
        if (this.Xwu != null) {
          this.Xwu.cancel();
        }
        this.qpt.setVisibility(0);
        this.qpt.startAnimation(this.Xwt);
      }
      AppMethodBeat.o(37988);
      return;
    }
    if (paramInt1 < paramInt2)
    {
      by(paramActivity);
      this.Xwv = false;
    }
    AppMethodBeat.o(37988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.a
 * JD-Core Version:    0.7.0.1
 */