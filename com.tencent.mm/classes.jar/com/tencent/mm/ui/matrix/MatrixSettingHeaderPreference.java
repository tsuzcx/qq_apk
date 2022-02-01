package com.tencent.mm.ui.matrix;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.preference.Preference;

public class MatrixSettingHeaderPreference
  extends Preference
{
  a KBB;
  
  public MatrixSettingHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MatrixSettingHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(38882);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131302196);
    final ImageView localImageView = (ImageView)paramView.findViewById(2131302195);
    localTextView.setText(i.MATRIX_VERSION);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      int clickCount = 3;
      Toast tDF;
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38881);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this) == null)
        {
          a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38881);
          return true;
        }
        this.clickCount -= 1;
        if (this.tDF == null) {
          this.tDF = Toast.makeText(MatrixSettingHeaderPreference.this.mContext, MatrixSettingHeaderPreference.this.mContext.getResources().getString(2131761190, new Object[] { Integer.valueOf(this.clickCount) }), 1);
        }
        if (this.clickCount <= 0) {
          this.tDF.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(2131761189));
        }
        for (;;)
        {
          ObjectAnimator.ofPropertyValuesHolder(localImageView, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.1F, 0.9F), Keyframe.ofFloat(0.2F, 0.9F), Keyframe.ofFloat(0.3F, 1.1F), Keyframe.ofFloat(0.4F, 1.1F), Keyframe.ofFloat(0.5F, 1.1F), Keyframe.ofFloat(0.6F, 1.1F), Keyframe.ofFloat(0.7F, 1.1F), Keyframe.ofFloat(0.8F, 1.1F), Keyframe.ofFloat(0.9F, 1.1F), Keyframe.ofFloat(1.0F, 1.0F) }), PropertyValuesHolder.ofKeyframe(View.ROTATION, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1F, -3.0F), Keyframe.ofFloat(0.2F, -3.0F), Keyframe.ofFloat(0.3F, 3.0F), Keyframe.ofFloat(0.4F, -3.0F), Keyframe.ofFloat(0.5F, 3.0F), Keyframe.ofFloat(0.6F, -3.0F), Keyframe.ofFloat(0.7F, 3.0F), Keyframe.ofFloat(0.8F, -3.0F), Keyframe.ofFloat(0.9F, 3.0F), Keyframe.ofFloat(1.0F, 0.0F) }) }).setDuration(1000L).start();
          this.tDF.show();
          if ((this.clickCount == 0) && (MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this) != null)) {
            MatrixSettingHeaderPreference.a(MatrixSettingHeaderPreference.this).fJM();
          }
          a.a(true, this, "com/tencent/mm/ui/matrix/MatrixSettingHeaderPreference$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(38881);
          return true;
          this.tDF.setText(MatrixSettingHeaderPreference.this.mContext.getResources().getString(2131761190, new Object[] { Integer.valueOf(this.clickCount) }));
        }
      }
    });
    AppMethodBeat.o(38882);
  }
  
  static abstract interface a
  {
    public abstract void fJM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference
 * JD-Core Version:    0.7.0.1
 */