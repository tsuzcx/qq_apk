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
  private boolean adQ;
  private String adf;
  private ImageView aeA;
  private String afI;
  private TextView afL;
  private ImageButton agD;
  private ImageButton agE;
  private RelativeLayout.LayoutParams agF;
  private RelativeLayout.LayoutParams agG;
  private float agH;
  private int agI;
  private com.tencent.mm.wear.a.b.a agJ;
  private PowerManager.WakeLock agK;
  private boolean agL;
  private boolean agM;
  private Animation agN;
  private Animation agO;
  private Runnable agP = new Runnable()
  {
    public final void run()
    {
      ReplyVoipUI.d(ReplyVoipUI.this).vibrate(750L);
      if (!ReplyVoipUI.e(ReplyVoipUI.this)) {
        ReplyVoipUI.c(ReplyVoipUI.this).postDelayed(ReplyVoipUI.b(ReplyVoipUI.this), 1500L);
      }
      if ((ReplyVoipUI.f(ReplyVoipUI.this) != null) && (ReplyVoipUI.g(ReplyVoipUI.this) != null)) {
        com.tencent.mm.wear.a.b.a.aiT.post(new Runnable()
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
  private e agQ = new e() {};
  private e agR = new e() {};
  private Vibrator agp;
  
  private void ca(int paramInt)
  {
    try
    {
      com.tencent.mm.wear.app.f.b localb = new com.tencent.mm.wear.app.f.b(paramInt, getUsername().getBytes("utf8"));
      h.mc().a(localb);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  private void nt()
  {
    this.agF.rightMargin = -80;
    RelativeLayout.LayoutParams localLayoutParams = this.agF;
    this.agF.height = 80;
    localLayoutParams.width = 80;
    this.agG.leftMargin = -80;
    localLayoutParams = this.agG;
    this.agG.height = 80;
    localLayoutParams.width = 80;
    this.agI = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903106);
    getWindow().addFlags(6946944);
    this.adf = getIntent().getStringExtra("key_talker");
    d.c("MicroMsg.ReplyVoipUI", "voip talker=%s", new Object[] { this.adf });
    this.afI = getIntent().getStringExtra("key_nickname");
    ((WatchViewStub)findViewById(2131558521)).a(new w()
    {
      public final void a(WatchViewStub paramAnonymousWatchViewStub)
      {
        ReplyVoipUI.a(ReplyVoipUI.this, paramAnonymousWatchViewStub);
      }
    });
    this.agp = ((Vibrator)getSystemService("vibrator"));
    this.agK = ((PowerManager)getSystemService("power")).newWakeLock(268435482, "ReplyVoipUI");
    if (!this.agK.isHeld()) {
      this.agK.acquire();
    }
    com.tencent.mm.sdk.a.a.WJ.a(this.agR);
    com.tencent.mm.sdk.a.a.WJ.a(this.agQ);
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
    com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
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
    if (this.agK.isHeld()) {
      this.agK.release();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.adQ = true;
    com.tencent.mm.sdk.a.a.WJ.b(this.agR);
    com.tencent.mm.sdk.a.a.WJ.b(this.agQ);
    this.agJ.removeCallbacks(this.agP);
    this.agJ.getLooper().quit();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.agH = paramMotionEvent.getX();
      nt();
      this.agD.requestLayout();
      this.agL = true;
    }
    float f3;
    float f1;
    label329:
    do
    {
      return true;
      if (paramMotionEvent.getAction() == 1)
      {
        if (this.agF.rightMargin >= -5)
        {
          d.c("MicroMsg.ReplyVoipUI", "OnClickAccept", new Object[0]);
          ca(11027);
          this.agD.setEnabled(false);
          this.agE.setEnabled(false);
          finish();
          this.adQ = true;
        }
        for (;;)
        {
          this.agL = false;
          return true;
          if (this.agG.leftMargin >= -5)
          {
            d.c("MicroMsg.ReplyVoipUI", "OnClickReject", new Object[0]);
            ca(11028);
            this.agD.setEnabled(false);
            this.agE.setEnabled(false);
            finish();
            this.adQ = true;
          }
          else
          {
            nt();
            this.agD.requestLayout();
          }
        }
      }
      f3 = paramMotionEvent.getX() - this.agH;
      d.e("MicroMsg.ReplyVoipUI", "horizontalDis: %f", new Object[] { Float.valueOf(f3) });
      if (this.agI == 0) {
        if (f3 <= 0.0F) {
          break label329;
        }
      }
      for (this.agI = 2;; this.agI = 1)
      {
        float f2 = Math.abs(f3) / 160.0F;
        f1 = f2;
        if (f2 >= 1.0F) {
          f1 = 1.0F;
        }
        if ((this.agI != 2) || (f3 < 0.0F)) {
          break;
        }
        this.agG.leftMargin = ((int)((1.0F - f1) * -80.0F));
        paramMotionEvent = this.agG;
        localLayoutParams = this.agG;
        i = (int)(f1 * 240.0F + 80.0F);
        localLayoutParams.height = i;
        paramMotionEvent.width = i;
        this.agE.bringToFront();
        this.agE.requestLayout();
        return true;
      }
    } while ((this.agI != 1) || (f3 > 0.0F));
    this.agF.rightMargin = ((int)((1.0F - f1) * -80.0F));
    paramMotionEvent = this.agF;
    RelativeLayout.LayoutParams localLayoutParams = this.agF;
    int i = (int)(f1 * 240.0F + 80.0F);
    localLayoutParams.height = i;
    paramMotionEvent.width = i;
    this.agD.bringToFront();
    this.agD.requestLayout();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.ReplyVoipUI
 * JD-Core Version:    0.7.0.1
 */