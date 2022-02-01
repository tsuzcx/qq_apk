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
import com.tencent.mm.ca.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecoveryUI
  extends AppCompatActivity
{
  private TextView ELb;
  private ProgressBar ixl;
  private Button sic;
  
  private void eCr()
  {
    AppMethodBeat.i(190227);
    this.sic.setClickable(true);
    this.sic.setVisibility(0);
    this.ixl.setVisibility(8);
    AppMethodBeat.o(190227);
  }
  
  public void onBackPressed() {}
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190224);
    super.onCreate(paramBundle);
    e.i("MicroMsg.recovery.ui", "activity onCreate, id = ".concat(String.valueOf(this)));
    try
    {
      setRequestedOrientation(1);
      setContentView(2131492934);
      this.ELb = ((TextView)findViewById(2131306160));
      this.sic = ((Button)findViewById(2131297591));
      this.ixl = ((ProgressBar)findViewById(2131303527));
      this.sic.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(190222);
          RecoveryUI.a(RecoveryUI.this);
          RecoveryUI.b(RecoveryUI.this).setText(2131762265);
          paramAnonymousView = new CountDownLatch(3);
          com.tencent.e.h.Iye.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190218);
              if (paramAnonymousView.getCount() > 0L) {}
              try
              {
                paramAnonymousView.await(10000L, TimeUnit.MILLISECONDS);
                label31:
                RecoveryUI.b(RecoveryUI.this).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(190217);
                    if (!RecoveryUI.this.isFinishing())
                    {
                      RecoveryUI.c(RecoveryUI.this);
                      RecoveryUI.b(RecoveryUI.this).setText(2131762266);
                      RecoveryUI.d(RecoveryUI.this).setText(2131762261);
                      RecoveryUI.d(RecoveryUI.this).setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous4View)
                        {
                          AppMethodBeat.i(190216);
                          RecoveryUI.e(RecoveryUI.this);
                          AppMethodBeat.o(190216);
                        }
                      });
                    }
                    AppMethodBeat.o(190217);
                  }
                });
                AppMethodBeat.o(190218);
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
              AppMethodBeat.i(190219);
              paramAnonymousView.countDown();
              AppMethodBeat.o(190219);
            }
          }, 3000L);
          com.tencent.e.h.Iye.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190220);
              RecoveryUI.f(RecoveryUI.this);
              com.tencent.mm.ca.c.ht(RecoveryUI.this.getApplication()).eCu().save();
              paramAnonymousView.countDown();
              AppMethodBeat.o(190220);
            }
          });
          com.tencent.e.h.Iye.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190221);
              RecoveryUI.g(RecoveryUI.this);
              paramAnonymousView.countDown();
              AppMethodBeat.o(190221);
            }
          });
          AppMethodBeat.o(190222);
        }
      });
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      eCr();
      this.ELb.setText(2131762267);
      paramBundle = com.tencent.mm.ca.h.hy(getApplication());
      paramBundle.ELF = false;
      paramBundle.ELC = true;
      paramBundle.save();
      AppMethodBeat.o(190224);
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
    AppMethodBeat.i(190226);
    super.onDestroy();
    e.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(190226);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190225);
    super.onNewIntent(paramIntent);
    e.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(190225);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recovery.ui.RecoveryUI
 * JD-Core Version:    0.7.0.1
 */