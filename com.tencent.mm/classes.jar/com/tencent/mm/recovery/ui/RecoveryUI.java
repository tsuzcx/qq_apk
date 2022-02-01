package com.tencent.mm.recovery.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecoveryUI
  extends AppCompatActivity
{
  private TextView HTD;
  private RecoveryCrash.Record HTE;
  private ProgressBar jqx;
  private Button uot;
  
  private void fgV()
  {
    AppMethodBeat.i(192846);
    this.uot.setClickable(true);
    this.uot.setVisibility(0);
    this.jqx.setVisibility(8);
    AppMethodBeat.o(192846);
  }
  
  public void onBackPressed() {}
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192843);
    super.onCreate(paramBundle);
    f.i("MicroMsg.recovery.ui", "activity onCreate, id = ".concat(String.valueOf(this)));
    try
    {
      setRequestedOrientation(1);
      setContentView(2131492934);
      this.HTD = ((TextView)findViewById(2131306160));
      this.uot = ((Button)findViewById(2131297591));
      this.jqx = ((ProgressBar)findViewById(2131303527));
      this.uot.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(192841);
          RecoveryUI.a(RecoveryUI.this);
          RecoveryUI.b(RecoveryUI.this).setText(2131762265);
          paramAnonymousView = new CountDownLatch(3);
          h.LTJ.aR(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192837);
              if (paramAnonymousView.getCount() > 0L) {}
              try
              {
                paramAnonymousView.await(10000L, TimeUnit.MILLISECONDS);
                label31:
                RecoveryUI.b(RecoveryUI.this).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(192836);
                    if (!RecoveryUI.this.isFinishing())
                    {
                      RecoveryUI.c(RecoveryUI.this);
                      RecoveryUI.b(RecoveryUI.this).setText(2131762266);
                      RecoveryUI.d(RecoveryUI.this).setText(2131762261);
                      RecoveryUI.d(RecoveryUI.this).setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymous4View)
                        {
                          AppMethodBeat.i(192835);
                          RecoveryUI.e(RecoveryUI.this);
                          AppMethodBeat.o(192835);
                        }
                      });
                    }
                    AppMethodBeat.o(192836);
                  }
                });
                AppMethodBeat.o(192837);
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
              AppMethodBeat.i(192838);
              paramAnonymousView.countDown();
              AppMethodBeat.o(192838);
            }
          }, 3000L);
          h.LTJ.aR(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192839);
              RecoveryUI.f(RecoveryUI.this);
              RecoveryCrash.hJ(RecoveryUI.this.getApplication()).fgZ().save();
              paramAnonymousView.countDown();
              AppMethodBeat.o(192839);
            }
          });
          h.LTJ.aR(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192840);
              RecoveryUI.g(RecoveryUI.this);
              paramAnonymousView.countDown();
              AppMethodBeat.o(192840);
            }
          });
          AppMethodBeat.o(192841);
        }
      });
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      fgV();
      this.HTD.setText(2131762267);
      this.HTE = ((RecoveryCrash.Record)getIntent().getParcelableExtra("extra_crash_record"));
      paramBundle = com.tencent.mm.recoveryv2.i.hR(getApplication());
      paramBundle.HUs = false;
      paramBundle.HUp = true;
      paramBundle.save();
      b.fgU();
      AppMethodBeat.o(192843);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        f.w("MicroMsg.recovery.ui", "set portrait mode fail", paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(192845);
    super.onDestroy();
    f.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(192845);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(192844);
    super.onNewIntent(paramIntent);
    f.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(192844);
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