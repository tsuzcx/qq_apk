package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;

final class SelectContactUI$a
{
  TextView gSy;
  private AlphaAnimation vNH;
  private AlphaAnimation vNI;
  boolean vNJ = false;
  
  final void ac(Activity paramActivity)
  {
    if (this.gSy == null) {
      this.gSy = ((TextView)paramActivity.findViewById(R.h.select_contact_float_tips));
    }
    if (this.gSy.getVisibility() == 8) {
      return;
    }
    if (this.vNI == null)
    {
      this.vNI = new AlphaAnimation(1.0F, 0.0F);
      this.vNI.setAnimationListener(new SelectContactUI.a.2(this));
    }
    this.vNI.setDuration(300L);
    if (this.vNH != null) {
      this.vNH.cancel();
    }
    this.gSy.startAnimation(this.vNI);
  }
  
  public final void d(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.vNJ))
    {
      if (this.gSy == null) {
        this.gSy = ((TextView)paramActivity.findViewById(R.h.select_contact_float_tips));
      }
      if (this.gSy.getVisibility() != 0)
      {
        this.gSy.setText(R.l.room_add_member_tips);
        this.gSy.setOnClickListener(new SelectContactUI.a.1(this, paramActivity));
        if (this.vNH == null) {
          this.vNH = new AlphaAnimation(0.0F, 1.0F);
        }
        this.vNH.setDuration(300L);
        if (this.vNI != null) {
          this.vNI.cancel();
        }
        this.gSy.setVisibility(0);
        this.gSy.startAnimation(this.vNH);
      }
    }
    while (paramInt1 >= paramInt2) {
      return;
    }
    ac(paramActivity);
    this.vNJ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.a
 * JD-Core Version:    0.7.0.1
 */