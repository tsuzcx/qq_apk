package com.tencent.mm.ui.matrix;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

final class MatrixSettingHeaderPreference$1
  implements View.OnLongClickListener
{
  Toast BRG;
  int clickCount = 3;
  
  MatrixSettingHeaderPreference$1(MatrixSettingHeaderPreference paramMatrixSettingHeaderPreference, ImageView paramImageView) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(38881);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    if (MatrixSettingHeaderPreference.a(this.XKP) == null)
    {
      a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(38881);
      return true;
    }
    this.clickCount -= 1;
    if (this.BRG == null) {
      this.BRG = Toast.makeText(this.XKP.mContext, this.XKP.mContext.getResources().getString(R.l.eLK, new Object[] { Integer.valueOf(this.clickCount) }), 1);
    }
    if (this.clickCount <= 0) {
      this.BRG.setText(this.XKP.mContext.getResources().getString(R.l.eLJ));
    }
    for (;;)
    {
      ObjectAnimator.ofPropertyValuesHolder(this.rGz, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.ROTATION, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1F, -3.0F), Keyframe.ofFloat(0.2F, -3.0F), Keyframe.ofFloat(0.3F, 3.0F), Keyframe.ofFloat(0.4F, -3.0F), Keyframe.ofFloat(0.5F, 3.0F), Keyframe.ofFloat(0.6F, -3.0F), Keyframe.ofFloat(0.7F, 3.0F), Keyframe.ofFloat(0.8F, -3.0F), Keyframe.ofFloat(0.9F, 3.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(1000L).start();
      this.BRG.show();
      if ((this.clickCount == 0) && (MatrixSettingHeaderPreference.a(this.XKP) != null)) {
        MatrixSettingHeaderPreference.a(this.XKP).hXz();
      }
      a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(38881);
      return true;
      this.BRG.setText(this.XKP.mContext.getResources().getString(R.l.eLK, new Object[] { Integer.valueOf(this.clickCount) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */