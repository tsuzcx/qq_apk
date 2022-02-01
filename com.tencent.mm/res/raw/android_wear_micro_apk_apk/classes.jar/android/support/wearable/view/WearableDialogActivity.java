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
  private ObservableScrollView FL;
  private ViewGroup FM;
  private ViewGroup FN;
  private TextView FO;
  private TextView FP;
  private Button FQ;
  private Button FR;
  private Button FS;
  private ObjectAnimator FT;
  private PropertyValuesHolder FU;
  private boolean FV;
  private float FW;
  private int FX;
  private Handler dG;
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
  
  private int fE()
  {
    return fG() - Math.min(this.FM.getHeight(), this.FX);
  }
  
  private int fF()
  {
    return Math.min(fG(), 0);
  }
  
  private int fG()
  {
    return -this.FM.getTop() + Math.max(this.FL.getScrollY(), 0) + this.FL.getHeight();
  }
  
  private void fH()
  {
    if ((!this.FV) || (this.FT == null))
    {
      if (this.FT != null) {
        this.FT.cancel();
      }
      this.FU = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { fE(), fF() });
      this.FT = ObjectAnimator.ofPropertyValuesHolder(this.FM, new PropertyValuesHolder[] { this.FU, PropertyValuesHolder.ofFloat(View.TRANSLATION_Z, new float[] { this.FW, 0.0F }) });
      this.FT.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          WearableDialogActivity.a(WearableDialogActivity.this).a(null);
          WearableDialogActivity.b(WearableDialogActivity.this).setTranslationY(0.0F);
          WearableDialogActivity.b(WearableDialogActivity.this).setTranslationZ(0.0F);
        }
      });
      this.FT.setDuration(500L);
      this.FT.setInterpolator(this.mInterpolator);
      this.FT.start();
    }
    for (;;)
    {
      this.FV = true;
      return;
      if (this.FT.isRunning())
      {
        int i = fE();
        int j = fF();
        if (i < j)
        {
          this.FU.setFloatValues(new float[] { i, j });
          if (this.FM.getTranslationY() < i) {
            this.FM.setTranslationY(i);
          }
        }
        else
        {
          this.FT.cancel();
          this.FM.setTranslationY(0.0F);
          this.FM.setTranslationZ(0.0F);
        }
      }
      else
      {
        this.FM.setTranslationY(0.0F);
        this.FM.setTranslationZ(0.0F);
      }
    }
  }
  
  public final void fy()
  {
    this.dG.removeMessages(1001);
    fH();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    fH();
    return true;
  }
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    Resources localResources = getResources();
    if (paramWindowInsets.isRound())
    {
      this.FX = localResources.getDimensionPixelSize(e.yh);
      this.FO.setPadding(localResources.getDimensionPixelSize(e.yd), localResources.getDimensionPixelSize(e.ye), localResources.getDimensionPixelSize(e.yd), 0);
      this.FO.setGravity(17);
      this.FP.setPadding(localResources.getDimensionPixelSize(e.yd), 0, localResources.getDimensionPixelSize(e.yd), localResources.getDimensionPixelSize(e.yc));
      this.FP.setGravity(17);
      this.FM.setPadding(localResources.getDimensionPixelSize(e.yd), 0, localResources.getDimensionPixelSize(e.yb), localResources.getDimensionPixelSize(e.ya));
    }
    for (;;)
    {
      return paramView.onApplyWindowInsets(paramWindowInsets);
      this.FX = getResources().getDimensionPixelSize(e.yg);
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
    setTheme(j.yz);
    setContentView(i.yv);
    this.FN = ((ViewGroup)findViewById(g.ym));
    this.FO = ((TextView)this.FN.findViewById(g.yl));
    this.FP = ((TextView)this.FN.findViewById(16908299));
    this.FM = ((ViewGroup)this.FN.findViewById(g.yn));
    this.FQ = ((Button)this.FM.findViewById(16908313));
    this.FQ.setOnClickListener(this);
    this.FR = ((Button)this.FM.findViewById(16908314));
    this.FR.setOnClickListener(this);
    this.FS = ((Button)this.FM.findViewById(16908315));
    this.FS.setOnClickListener(this);
    label197:
    label227:
    int j;
    if (TextUtils.isEmpty(null))
    {
      this.FO.setVisibility(8);
      if (!TextUtils.isEmpty(null)) {
        break label361;
      }
      this.FP.setVisibility(8);
      boolean bool = a(this.FQ, null, null);
      if ((!a(this.FR, null, null)) && (!bool)) {
        break label380;
      }
      i = 1;
      j = m;
      if (!a(this.FS, null, null))
      {
        if (i == 0) {
          break label385;
        }
        j = m;
      }
      label249:
      paramBundle = this.FM;
      if (j == 0) {
        break label390;
      }
    }
    label385:
    label390:
    for (int i = k;; i = 8)
    {
      paramBundle.setVisibility(i);
      this.dG = new Handler(this);
      this.mInterpolator = AnimationUtils.loadInterpolator(this, 17563661);
      this.FW = getResources().getDimension(e.yf);
      this.FL = ((ObservableScrollView)findViewById(g.yq));
      this.FL.addOnLayoutChangeListener(this);
      this.FL.a(this);
      this.FL.setOnApplyWindowInsetsListener(this);
      return;
      this.FP.setVisibility(0);
      this.FO.setText(null);
      break;
      label361:
      this.FP.setVisibility(0);
      this.FP.setText(null);
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
    if (this.FT != null) {
      this.FT.cancel();
    }
    this.dG.removeMessages(1001);
    this.FV = false;
    if (this.FN.getHeight() > this.FL.getHeight())
    {
      this.FM.setTranslationZ(this.FW);
      this.dG.sendEmptyMessageDelayed(1001, 1500L);
      this.FT = ObjectAnimator.ofPropertyValuesHolder(this.FM, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { fF(), fE() }), PropertyValuesHolder.ofFloat(View.TRANSLATION_Z, new float[] { 0.0F, this.FW }) });
      this.FT.setDuration(500L);
      this.FT.setInterpolator(this.mInterpolator);
      this.FT.start();
      return;
    }
    this.FM.setTranslationY(0.0F);
    this.FM.setTranslationZ(0.0F);
    this.FM.offsetTopAndBottom(this.FL.getHeight() - this.FN.getHeight());
    this.FN.setBottom(this.FL.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableDialogActivity
 * JD-Core Version:    0.7.0.1
 */