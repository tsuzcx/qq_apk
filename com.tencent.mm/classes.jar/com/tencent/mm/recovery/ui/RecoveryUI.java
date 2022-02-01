package com.tencent.mm.recovery.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecoveryUI
  extends AppCompatActivity
{
  private TextView Gin;
  private ProgressBar iXo;
  private Button tpW;
  
  private void eRM()
  {
    AppMethodBeat.i(194737);
    this.tpW.setClickable(true);
    this.tpW.setVisibility(0);
    this.iXo.setVisibility(8);
    AppMethodBeat.o(194737);
  }
  
  public void onBackPressed() {}
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194734);
    super.onCreate(paramBundle);
    e.i("MicroMsg.recovery.ui", "activity onCreate, id = ".concat(String.valueOf(this)));
    try
    {
      setRequestedOrientation(1);
      setContentView(2131492934);
      this.Gin = ((TextView)findViewById(2131306160));
      this.tpW = ((Button)findViewById(2131297591));
      this.iXo = ((ProgressBar)findViewById(2131303527));
      this.tpW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(194732);
          RecoveryUI.a(RecoveryUI.this);
          RecoveryUI.b(RecoveryUI.this).setText(2131762265);
          paramAnonymousView = new CountDownLatch(3);
          com.tencent.e.h.JZN.aS(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194728);
              if (paramAnonymousView.getCount() > 0L) {}
              try
              {
                paramAnonymousView.await(10000L, TimeUnit.MILLISECONDS);
                label31:
                RecoveryUI.b(RecoveryUI.this).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(194727);
                    if (!RecoveryUI.this.isFinishing())
                    {
                      RecoveryUI.c(RecoveryUI.this);
                      RecoveryUI.b(RecoveryUI.this).setText(2131762266);
                      RecoveryUI.d(RecoveryUI.this).setText(2131762261);
                      RecoveryUI.d(RecoveryUI.this).setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous4View)
                        {
                          AppMethodBeat.i(194726);
                          RecoveryUI.e(RecoveryUI.this);
                          AppMethodBeat.o(194726);
                        }
                      });
                    }
                    AppMethodBeat.o(194727);
                  }
                });
                AppMethodBeat.o(194728);
                return;
              }
              catch (Throwable localThrowable)
              {
                break label31;
              }
            }
          });
          RecoveryUI.b(RecoveryUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194729);
              paramAnonymousView.countDown();
              AppMethodBeat.o(194729);
            }
          }, 3000L);
          com.tencent.e.h.JZN.aS(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194730);
              RecoveryUI.f(RecoveryUI.this);
              com.tencent.mm.bz.c.hE(RecoveryUI.this.getApplication()).eRP().save();
              paramAnonymousView.countDown();
              AppMethodBeat.o(194730);
            }
          });
          com.tencent.e.h.JZN.aS(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194731);
              RecoveryUI.g(RecoveryUI.this);
              paramAnonymousView.countDown();
              AppMethodBeat.o(194731);
            }
          });
          AppMethodBeat.o(194732);
        }
      });
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      eRM();
      this.Gin.setText(2131762267);
      paramBundle = com.tencent.mm.bz.h.hJ(getApplication());
      paramBundle.GiR = false;
      paramBundle.GiO = true;
      paramBundle.save();
      AppMethodBeat.o(194734);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        e.w("MicroMsg.recovery.ui", "set portrait mode fail", paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(194736);
    super.onDestroy();
    e.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(194736);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(194735);
    super.onNewIntent(paramIntent);
    e.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(194735);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recovery.ui.RecoveryUI
 * JD-Core Version:    0.7.0.1
 */