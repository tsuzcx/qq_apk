package android.support.wearable.activity;

import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.f;
import android.support.wearable.g;
import android.support.wearable.i;
import android.support.wearable.view.ActionLabel;
import android.support.wearable.view.ActionPage;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

@TargetApi(21)
public class ConfirmationActivity
  extends Activity
{
  private ActionPage An;
  private final Handler dG = new Handler();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("animation_type", 1);
    paramBundle = paramBundle.getStringExtra("message");
    this.An = new ActionPage(this);
    final long l;
    if (i == 3)
    {
      setContentView(i.yx);
      ((TextView)findViewById(g.message)).setText(paramBundle);
      l = 2000L;
      this.An.setKeepScreenOn(true);
      this.dG.postDelayed(new Runnable()
      {
        public final void run()
        {
          ConfirmationActivity.this.finish();
          ConfirmationActivity.this.overridePendingTransition(0, 17432577);
        }
      }, l);
      return;
    }
    this.An.eX();
    this.An.setStateListAnimator(new StateListAnimator());
    this.An.bj(ActionPage.Bq);
    setContentView(this.An);
    if (paramBundle != null) {
      this.An.setText(paramBundle);
    }
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Unknown type of animation: ".concat(String.valueOf(i)));
    }
    for (paramBundle = getDrawable(f.yk);; paramBundle = getDrawable(f.yj))
    {
      this.An.setImageDrawable(paramBundle);
      final ActionLabel localActionLabel = this.An.eW();
      l = Math.max(0L, 1666L - (localActionLabel.animate().getDuration() + 50L) * 2L);
      ((Animatable)paramBundle).start();
      localActionLabel.setAlpha(0.0F);
      localActionLabel.animate().alpha(1.0F).setStartDelay(50L).withEndAction(new Runnable()
      {
        public final void run()
        {
          localActionLabel.animate().alpha(0.0F).setStartDelay(l);
        }
      });
      l = 1666L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.activity.ConfirmationActivity
 * JD-Core Version:    0.7.0.1
 */