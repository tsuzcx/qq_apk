package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SelectContactUI$a
{
  private AlphaAnimation PZw;
  private AlphaAnimation PZx;
  boolean PZy = false;
  TextView nnM;
  
  final void bs(Activity paramActivity)
  {
    AppMethodBeat.i(37989);
    if (this.nnM == null) {
      this.nnM = ((TextView)paramActivity.findViewById(2131307512));
    }
    if (this.nnM.getVisibility() == 8)
    {
      AppMethodBeat.o(37989);
      return;
    }
    if (this.PZx == null)
    {
      this.PZx = new AlphaAnimation(1.0F, 0.0F);
      this.PZx.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(37987);
          SelectContactUI.a.this.nnM.setVisibility(8);
          AppMethodBeat.o(37987);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    this.PZx.setDuration(300L);
    if (this.PZw != null) {
      this.PZw.cancel();
    }
    this.nnM.startAnimation(this.PZx);
    AppMethodBeat.o(37989);
  }
  
  public final void e(final Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37988);
    if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.PZy))
    {
      if (this.nnM == null) {
        this.nnM = ((TextView)paramActivity.findViewById(2131307512));
      }
      if (this.nnM.getVisibility() != 0)
      {
        this.nnM.setText(2131764651);
        this.nnM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37986);
            b localb = new b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            SelectContactUI.a.this.PZy = true;
            SelectContactUI.a.this.bs(paramActivity);
            a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37986);
          }
        });
        if (this.PZw == null) {
          this.PZw = new AlphaAnimation(0.0F, 1.0F);
        }
        this.PZw.setDuration(300L);
        if (this.PZx != null) {
          this.PZx.cancel();
        }
        this.nnM.setVisibility(0);
        this.nnM.startAnimation(this.PZw);
      }
      AppMethodBeat.o(37988);
      return;
    }
    if (paramInt1 < paramInt2)
    {
      bs(paramActivity);
      this.PZy = false;
    }
    AppMethodBeat.o(37988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.a
 * JD-Core Version:    0.7.0.1
 */