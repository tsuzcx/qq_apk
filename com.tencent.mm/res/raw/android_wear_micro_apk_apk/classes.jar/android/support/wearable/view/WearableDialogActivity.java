package android.support.wearable.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.wearable.e;
import android.support.wearable.g;
import android.support.wearable.i;
import android.support.wearable.j;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

@TargetApi(21)
public class WearableDialogActivity
  extends Activity
  implements Handler.Callback, r, View.OnApplyWindowInsetsListener, View.OnClickListener, View.OnLayoutChangeListener
{
  private ObservableScrollView DW;
  private ViewGroup DX;
  private ViewGroup DY;
  private TextView DZ;
  private TextView Ea;
  private Button Eb;
  private Button Ec;
  private Button Ed;
  private ObjectAnimator Ee;
  private PropertyValuesHolder Ef;
  private boolean Eg;
  private float Eh;
  private int Ei;
  private Handler mHandler;
  private Interpolator mInterpolator;
  
  private static boolean a(Button paramButton, CharSequence paramCharSequence, Drawable paramDrawable)
  {
    if (TextUtils.isEmpty(null))
    {
      paramButton.setVisibility(8);
      return false;
    }
    paramButton.setText(null);
    paramButton.setVisibility(0);
    return true;
  }
  
  private int fv()
  {
    return fx() - Math.min(this.DX.getHeight(), this.Ei);
  }
  
  private int fw()
  {
    return Math.min(fx(), 0);
  }
  
  private int fx()
  {
    return -this.DX.getTop() + Math.max(this.DW.getScrollY(), 0) + this.DW.getHeight();
  }
  
  private void fy()
  {
    if ((!this.Eg) || (this.Ee == null))
    {
      if (this.Ee != null) {
        this.Ee.cancel();
      }
      this.Ef = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { fv(), fw() });
      this.Ee = ObjectAnimator.ofPropertyValuesHolder(this.DX, new PropertyValuesHolder[] { this.Ef, PropertyValuesHolder.ofFloat(View.TRANSLATION_Z, new float[] { this.Eh, 0.0F }) });
      this.Ee.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          WearableDialogActivity.a(WearableDialogActivity.this).a(null);
          WearableDialogActivity.b(WearableDialogActivity.this).setTranslationY(0.0F);
          WearableDialogActivity.b(WearableDialogActivity.this).setTranslationZ(0.0F);
        }
      });
      this.Ee.setDuration(500L);
      this.Ee.setInterpolator(this.mInterpolator);
      this.Ee.start();
    }
    for (;;)
    {
      this.Eg = true;
      return;
      if (this.Ee.isRunning())
      {
        int i = fv();
        int j = fw();
        if (i < j)
        {
          this.Ef.setFloatValues(new float[] { i, j });
          if (this.DX.getTranslationY() < i) {
            this.DX.setTranslationY(i);
          }
        }
        else
        {
          this.Ee.cancel();
          this.DX.setTranslationY(0.0F);
          this.DX.setTranslationZ(0.0F);
        }
      }
      else
      {
        this.DX.setTranslationY(0.0F);
        this.DX.setTranslationZ(0.0F);
      }
    }
  }
  
  public final void fp()
  {
    this.mHandler.removeMessages(1001);
    fy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    fy();
    return true;
  }
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    Resources localResources = getResources();
    if (paramWindowInsets.isRound())
    {
      this.Ei = localResources.getDimensionPixelSize(e.ws);
      this.DZ.setPadding(localResources.getDimensionPixelSize(e.wo), localResources.getDimensionPixelSize(e.wp), localResources.getDimensionPixelSize(e.wo), 0);
      this.DZ.setGravity(17);
      this.Ea.setPadding(localResources.getDimensionPixelSize(e.wo), 0, localResources.getDimensionPixelSize(e.wo), localResources.getDimensionPixelSize(e.wn));
      this.Ea.setGravity(17);
      this.DX.setPadding(localResources.getDimensionPixelSize(e.wo), 0, localResources.getDimensionPixelSize(e.wm), localResources.getDimensionPixelSize(e.wl));
    }
    for (;;)
    {
      return paramView.onApplyWindowInsets(paramWindowInsets);
      this.Ei = getResources().getDimensionPixelSize(e.wr);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 16908313: 
      finish();
      return;
    case 16908314: 
      finish();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int m = 1;
    int k = 0;
    super.onCreate(paramBundle);
    setTheme(j.wK);
    setContentView(i.wG);
    this.DY = ((ViewGroup)findViewById(g.wx));
    this.DZ = ((TextView)this.DY.findViewById(g.ww));
    this.Ea = ((TextView)this.DY.findViewById(16908299));
    this.DX = ((ViewGroup)this.DY.findViewById(g.wy));
    this.Eb = ((Button)this.DX.findViewById(16908313));
    this.Eb.setOnClickListener(this);
    this.Ec = ((Button)this.DX.findViewById(16908314));
    this.Ec.setOnClickListener(this);
    this.Ed = ((Button)this.DX.findViewById(16908315));
    this.Ed.setOnClickListener(this);
    label197:
    label227:
    int j;
    if (TextUtils.isEmpty(null))
    {
      this.DZ.setVisibility(8);
      if (!TextUtils.isEmpty(null)) {
        break label361;
      }
      this.Ea.setVisibility(8);
      boolean bool = a(this.Eb, null, null);
      if ((!a(this.Ec, null, null)) && (!bool)) {
        break label380;
      }
      i = 1;
      j = m;
      if (!a(this.Ed, null, null))
      {
        if (i == 0) {
          break label385;
        }
        j = m;
      }
      label249:
      paramBundle = this.DX;
      if (j == 0) {
        break label390;
      }
    }
    label385:
    label390:
    for (int i = k;; i = 8)
    {
      paramBundle.setVisibility(i);
      this.mHandler = new Handler(this);
      this.mInterpolator = AnimationUtils.loadInterpolator(this, 17563661);
      this.Eh = getResources().getDimension(e.wq);
      this.DW = ((ObservableScrollView)findViewById(g.wB));
      this.DW.addOnLayoutChangeListener(this);
      this.DW.a(this);
      this.DW.setOnApplyWindowInsetsListener(this);
      return;
      this.Ea.setVisibility(0);
      this.DZ.setText(null);
      break;
      label361:
      this.Ea.setVisibility(0);
      this.Ea.setText(null);
      break label197;
      label380:
      i = 0;
      break label227;
      j = 0;
      break label249;
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.Ee != null) {
      this.Ee.cancel();
    }
    this.mHandler.removeMessages(1001);
    this.Eg = false;
    if (this.DY.getHeight() > this.DW.getHeight())
    {
      this.DX.setTranslationZ(this.Eh);
      this.mHandler.sendEmptyMessageDelayed(1001, 1500L);
      this.Ee = ObjectAnimator.ofPropertyValuesHolder(this.DX, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { fw(), fv() }), PropertyValuesHolder.ofFloat(View.TRANSLATION_Z, new float[] { 0.0F, this.Eh }) });
      this.Ee.setDuration(500L);
      this.Ee.setInterpolator(this.mInterpolator);
      this.Ee.start();
      return;
    }
    this.DX.setTranslationY(0.0F);
    this.DX.setTranslationZ(0.0F);
    this.DX.offsetTopAndBottom(this.DW.getHeight() - this.DY.getHeight());
    this.DY.setBottom(this.DW.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableDialogActivity
 * JD-Core Version:    0.7.0.1
 */