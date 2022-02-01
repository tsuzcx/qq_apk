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
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.RecoveryCrash.Record;
import com.tencent.mm.recoveryv2.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecoveryUI
  extends AppCompatActivity
{
  private TextView NBi;
  private TextView NBj;
  private RecoveryCrash.Record NBk;
  private ProgressBar krF;
  private Button xRO;
  
  private void guy()
  {
    AppMethodBeat.i(193927);
    this.xRO.setClickable(true);
    this.xRO.setVisibility(0);
    this.krF.setVisibility(8);
    AppMethodBeat.o(193927);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(193923);
    if (MMApplicationContext.getResources() == null)
    {
      localResources = super.getResources();
      AppMethodBeat.o(193923);
      return localResources;
    }
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(193923);
    return localResources;
  }
  
  public void onBackPressed() {}
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193924);
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
          setContentView(2131492960);
          this.NBi = ((TextView)findViewById(2131309501));
          this.NBj = ((TextView)findViewById(2131309538));
          this.xRO = ((Button)findViewById(2131297838));
          this.krF = ((ProgressBar)findViewById(2131306294));
          this.xRO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(193921);
              RecoveryUI.a(RecoveryUI.this);
              RecoveryUI.b(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(2131764331));
              paramAnonymousView = new CountDownLatch(3);
              h.RTc.aX(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193917);
                  if (paramAnonymousView.getCount() > 0L) {}
                  try
                  {
                    paramAnonymousView.await(10000L, TimeUnit.MILLISECONDS);
                    label31:
                    RecoveryUI.b(RecoveryUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(193916);
                        if (!RecoveryUI.this.isFinishing())
                        {
                          RecoveryUI.c(RecoveryUI.this);
                          RecoveryUI.b(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(2131764332));
                          RecoveryUI.d(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(2131764327));
                          RecoveryUI.d(RecoveryUI.this).setOnClickListener(new View.OnClickListener()
                          {
                            public final void onClick(View paramAnonymous4View)
                            {
                              AppMethodBeat.i(193915);
                              RecoveryUI.e(RecoveryUI.this);
                              AppMethodBeat.o(193915);
                            }
                          });
                        }
                        AppMethodBeat.o(193916);
                      }
                    });
                    AppMethodBeat.o(193917);
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
                  AppMethodBeat.i(193918);
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(193918);
                }
              }, 3000L);
              h.RTc.aX(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193919);
                  RecoveryUI.f(RecoveryUI.this);
                  RecoveryCrash.iI(RecoveryUI.this.getApplication()).guC().save();
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(193919);
                }
              });
              h.RTc.aX(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193920);
                  RecoveryUI.g(RecoveryUI.this);
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(193920);
                }
              });
              AppMethodBeat.o(193921);
            }
          });
          paramBundle = getSupportActionBar();
          if (paramBundle != null) {
            paramBundle.hide();
          }
          guy();
          this.NBi.setText(getResources().getString(2131764330));
          this.NBj.setText(getResources().getString(2131764333));
          this.xRO.setText(getResources().getString(2131764328));
          this.NBk = ((RecoveryCrash.Record)getIntent().getParcelableExtra("extra_crash_record"));
          paramBundle = com.tencent.mm.recoveryv2.i.iQ(getApplication());
          paramBundle.NBY = false;
          paramBundle.NBV = true;
          paramBundle.save();
          AppMethodBeat.o(193924);
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
          setContentView(2131492961);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193926);
    super.onDestroy();
    f.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(193926);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(193925);
    super.onNewIntent(paramIntent);
    f.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(193925);
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