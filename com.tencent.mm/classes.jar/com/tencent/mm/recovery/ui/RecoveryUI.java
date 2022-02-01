package com.tencent.mm.recovery.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.e.c;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recovery.b;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.RecoveryCrash.Record;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecoveryUI
  extends AppCompatActivity
{
  private TextView InK;
  private TextView InL;
  private RecoveryCrash.Record InM;
  private ProgressBar jtq;
  private Button uzP;
  
  private void fkN()
  {
    AppMethodBeat.i(186170);
    this.uzP.setClickable(true);
    this.uzP.setVisibility(0);
    this.jtq.setVisibility(8);
    AppMethodBeat.o(186170);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(186166);
    if (ak.getResources() == null)
    {
      localResources = super.getResources();
      AppMethodBeat.o(186166);
      return localResources;
    }
    Resources localResources = ak.getResources();
    AppMethodBeat.o(186166);
    return localResources;
  }
  
  public void onBackPressed() {}
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186167);
    super.onCreate(paramBundle);
    f.i("MicroMsg.recovery.ui", "activity onCreate, id = ".concat(String.valueOf(this)));
    try
    {
      setRequestedOrientation(1);
    }
    catch (Throwable paramBundle)
    {
      try
      {
        for (;;)
        {
          setContentView(2131492934);
          this.InK = ((TextView)findViewById(2131306137));
          this.InL = ((TextView)findViewById(2131306160));
          this.uzP = ((Button)findViewById(2131297591));
          this.jtq = ((ProgressBar)findViewById(2131303527));
          this.uzP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(186164);
              RecoveryUI.a(RecoveryUI.this);
              RecoveryUI.b(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(2131762265));
              paramAnonymousView = new CountDownLatch(3);
              h.MqF.aO(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186160);
                  if (paramAnonymousView.getCount() > 0L) {}
                  try
                  {
                    paramAnonymousView.await(10000L, TimeUnit.MILLISECONDS);
                    label31:
                    RecoveryUI.b(RecoveryUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(186159);
                        if (!RecoveryUI.this.isFinishing())
                        {
                          RecoveryUI.c(RecoveryUI.this);
                          RecoveryUI.b(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(2131762266));
                          RecoveryUI.d(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(2131762261));
                          RecoveryUI.d(RecoveryUI.this).setOnClickListener(new View.OnClickListener()
                          {
                            public final void onClick(View paramAnonymous4View)
                            {
                              AppMethodBeat.i(186158);
                              RecoveryUI.e(RecoveryUI.this);
                              AppMethodBeat.o(186158);
                            }
                          });
                        }
                        AppMethodBeat.o(186159);
                      }
                    });
                    AppMethodBeat.o(186160);
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
                  AppMethodBeat.i(186161);
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(186161);
                }
              }, 3000L);
              h.MqF.aO(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186162);
                  RecoveryUI.f(RecoveryUI.this);
                  RecoveryCrash.hP(RecoveryUI.this.getApplication()).fkR().save();
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(186162);
                }
              });
              h.MqF.aO(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186163);
                  RecoveryUI.g(RecoveryUI.this);
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(186163);
                }
              });
              AppMethodBeat.o(186164);
            }
          });
          paramBundle = getSupportActionBar();
          if (paramBundle != null) {
            paramBundle.hide();
          }
          fkN();
          this.InK.setText(getResources().getString(2131762264));
          this.InL.setText(getResources().getString(2131762267));
          this.uzP.setText(getResources().getString(2131762262));
          this.InM = ((RecoveryCrash.Record)getIntent().getParcelableExtra("extra_crash_record"));
          paramBundle = com.tencent.mm.recoveryv2.i.hX(getApplication());
          paramBundle.IoA = false;
          paramBundle.Iox = true;
          paramBundle.save();
          b.fkM();
          AppMethodBeat.o(186167);
          return;
          paramBundle = paramBundle;
          f.w("MicroMsg.recovery.ui", "set portrait mode fail", paramBundle);
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          f.w("MicroMsg.recovery.ui", "setContentView fail, try raw layout", paramBundle);
          setContentView(2131496507);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186169);
    super.onDestroy();
    f.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(186169);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(186168);
    super.onNewIntent(paramIntent);
    f.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(186168);
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