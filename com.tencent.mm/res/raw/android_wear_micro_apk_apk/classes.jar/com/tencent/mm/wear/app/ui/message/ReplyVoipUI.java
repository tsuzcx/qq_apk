package com.tencent.mm.wear.app.ui.message;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.w;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.b.a.m;
import com.tencent.mm.b.a.n;
import com.tencent.mm.sdk.a.e;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.UnsupportedEncodingException;

public class ReplyVoipUI
  extends MMActivity
{
  private String agG;
  private boolean ahs;
  private ImageView aic;
  private Vibrator ajR;
  private String ajk;
  private TextView ajn;
  private ImageButton akf;
  private ImageButton akg;
  private RelativeLayout.LayoutParams akh;
  private RelativeLayout.LayoutParams aki;
  private float akj;
  private int akk;
  private com.tencent.mm.wear.a.b.a akl;
  private PowerManager.WakeLock akm;
  private boolean akn;
  private boolean ako;
  private Animation akp;
  private Animation akq;
  private Runnable akr = new Runnable()
  {
    public final void run()
    {
      ReplyVoipUI.d(ReplyVoipUI.this).vibrate(750L);
      if (!ReplyVoipUI.e(ReplyVoipUI.this)) {
        ReplyVoipUI.c(ReplyVoipUI.this).postDelayed(ReplyVoipUI.b(ReplyVoipUI.this), 1500L);
      }
      if ((ReplyVoipUI.f(ReplyVoipUI.this) != null) && (ReplyVoipUI.g(ReplyVoipUI.this) != null)) {
        com.tencent.mm.wear.a.b.a.amv.post(new Runnable()
        {
          public final void run()
          {
            if (!ReplyVoipUI.h(ReplyVoipUI.this))
            {
              if (ReplyVoipUI.i(ReplyVoipUI.this))
              {
                ReplyVoipUI.a(ReplyVoipUI.this, false);
                ReplyVoipUI.f(ReplyVoipUI.this).bringToFront();
                ReplyVoipUI.f(ReplyVoipUI.this).startAnimation(ReplyVoipUI.j(ReplyVoipUI.this));
                return;
              }
              ReplyVoipUI.a(ReplyVoipUI.this, true);
              ReplyVoipUI.g(ReplyVoipUI.this).bringToFront();
              ReplyVoipUI.g(ReplyVoipUI.this).startAnimation(ReplyVoipUI.k(ReplyVoipUI.this));
              return;
            }
            ReplyVoipUI.j(ReplyVoipUI.this).cancel();
            ReplyVoipUI.k(ReplyVoipUI.this).cancel();
          }
        });
      }
    }
  };
  private e aks = new e() {};
  private e akt = new e() {};
  
  private void cw(int paramInt)
  {
    try
    {
      com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(paramInt, getUsername().getBytes("utf8"));
      h.mP().a(localb);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  private void og()
  {
    this.akh.rightMargin = -80;
    RelativeLayout.LayoutParams localLayoutParams = this.akh;
    this.akh.height = 80;
    localLayoutParams.width = 80;
    this.aki.leftMargin = -80;
    localLayoutParams = this.aki;
    this.aki.height = 80;
    localLayoutParams.width = 80;
    this.akk = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903106);
    getWindow().addFlags(6946944);
    this.agG = getIntent().getStringExtra("key_talker");
    d.c("MicroMsg.ReplyVoipUI", "voip talker=%s", new Object[] { this.agG });
    this.ajk = getIntent().getStringExtra("key_nickname");
    ((WatchViewStub)findViewById(2131558522)).a(new w()
    {
      public final void a(WatchViewStub paramAnonymousWatchViewStub)
      {
        ReplyVoipUI.a(ReplyVoipUI.this, paramAnonymousWatchViewStub);
      }
    });
    this.ajR = ((Vibrator)getSystemService("vibrator"));
    this.akm = ((PowerManager)getSystemService("power")).newWakeLock(268435482, "ReplyVoipUI");
    if (!this.akm.isHeld()) {
      this.akm.acquire();
    }
    com.tencent.mm.sdk.a.a.YM.a(this.akt);
    com.tencent.mm.sdk.a.a.YM.a(this.aks);
    new Thread()
    {
      public final void run()
      {
        Looper.prepare();
        ReplyVoipUI.a(ReplyVoipUI.this, new com.tencent.mm.wear.a.b.a(Looper.myLooper()));
        ReplyVoipUI.c(ReplyVoipUI.this).post(ReplyVoipUI.b(ReplyVoipUI.this));
        Looper.loop();
      }
    }.start();
    com.tencent.mm.wear.a.b.a.amv.postDelayed(new Runnable()
    {
      public final void run()
      {
        d.c("MicroMsg.ReplyVoipUI", "voip ui handler finish talker=%s", new Object[] { ReplyVoipUI.a(ReplyVoipUI.this) });
        ReplyVoipUI.this.finish();
      }
    }, 15000L);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.akm.isHeld()) {
      this.akm.release();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.ahs = true;
    com.tencent.mm.sdk.a.a.YM.b(this.akt);
    com.tencent.mm.sdk.a.a.YM.b(this.aks);
    this.akl.removeCallbacks(this.akr);
    this.akl.getLooper().quit();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.akj = paramMotionEvent.getX();
      og();
      this.akf.requestLayout();
      this.akn = true;
    }
    float f3;
    float f1;
    label329:
    do
    {
      return true;
      if (paramMotionEvent.getAction() == 1)
      {
        if (this.akh.rightMargin >= -5)
        {
          d.c("MicroMsg.ReplyVoipUI", "OnClickAccept", new Object[0]);
          cw(11027);
          this.akf.setEnabled(false);
          this.akg.setEnabled(false);
          finish();
          this.ahs = true;
        }
        for (;;)
        {
          this.akn = false;
          return true;
          if (this.aki.leftMargin >= -5)
          {
            d.c("MicroMsg.ReplyVoipUI", "OnClickReject", new Object[0]);
            cw(11028);
            this.akf.setEnabled(false);
            this.akg.setEnabled(false);
            finish();
            this.ahs = true;
          }
          else
          {
            og();
            this.akf.requestLayout();
          }
        }
      }
      f3 = paramMotionEvent.getX() - this.akj;
      d.d("MicroMsg.ReplyVoipUI", "horizontalDis: %f", new Object[] { Float.valueOf(f3) });
      if (this.akk == 0) {
        if (f3 <= 0.0F) {
          break label329;
        }
      }
      for (this.akk = 2;; this.akk = 1)
      {
        float f2 = Math.abs(f3) / 160.0F;
        f1 = f2;
        if (f2 >= 1.0F) {
          f1 = 1.0F;
        }
        if ((this.akk != 2) || (f3 < 0.0F)) {
          break;
        }
        this.aki.leftMargin = ((int)((1.0F - f1) * -80.0F));
        paramMotionEvent = this.aki;
        localLayoutParams = this.aki;
        i = (int)(f1 * 240.0F + 80.0F);
        localLayoutParams.height = i;
        paramMotionEvent.width = i;
        this.akg.bringToFront();
        this.akg.requestLayout();
        return true;
      }
    } while ((this.akk != 1) || (f3 > 0.0F));
    this.akh.rightMargin = ((int)((1.0F - f1) * -80.0F));
    paramMotionEvent = this.akh;
    RelativeLayout.LayoutParams localLayoutParams = this.akh;
    int i = (int)(f1 * 240.0F + 80.0F);
    localLayoutParams.height = i;
    paramMotionEvent.width = i;
    this.akf.bringToFront();
    this.akf.requestLayout();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyVoipUI
 * JD-Core Version:    0.7.0.1
 */