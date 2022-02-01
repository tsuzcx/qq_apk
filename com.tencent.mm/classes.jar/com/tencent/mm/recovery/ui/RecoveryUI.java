package com.tencent.mm.recovery.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.f.a;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.RecoveryCrash.Record;
import com.tencent.mm.recoveryv2.g;
import com.tencent.mm.recoveryv2.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.recovery.wx.R.id;
import com.tencent.recovery.wx.R.layout;
import com.tencent.recovery.wx.R.string;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RecoveryUI
  extends AppCompatActivity
{
  private Button CVZ;
  private TextView UOL;
  private TextView UOM;
  private RecoveryCrash.Record UON;
  private ProgressBar njo;
  
  private void hpW()
  {
    AppMethodBeat.i(202351);
    this.CVZ.setClickable(true);
    this.CVZ.setVisibility(0);
    this.njo.setVisibility(8);
    AppMethodBeat.o(202351);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(202334);
    if (MMApplicationContext.getResources() == null)
    {
      localResources = super.getResources();
      AppMethodBeat.o(202334);
      return localResources;
    }
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(202334);
    return localResources;
  }
  
  public void onBackPressed() {}
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202346);
    super.onCreate(paramBundle);
    g.i("MicroMsg.recovery.ui", "activity onCreate, id = ".concat(String.valueOf(this)));
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
          setContentView(R.layout.activity_recovery);
          this.UOL = ((TextView)findViewById(R.id.tv_main));
          this.UOM = ((TextView)findViewById(R.id.tv_tips));
          this.CVZ = ((Button)findViewById(R.id.btn_main));
          this.njo = ((ProgressBar)findViewById(R.id.progress_main));
          this.CVZ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(final View paramAnonymousView)
            {
              AppMethodBeat.i(202283);
              RecoveryUI.a(RecoveryUI.this);
              RecoveryUI.b(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(R.string.recovery_tips_loading));
              paramAnonymousView = new CountDownLatch(3);
              h.ZvG.be(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(201879);
                  if (paramAnonymousView.getCount() > 0L) {}
                  try
                  {
                    paramAnonymousView.await(10000L, TimeUnit.MILLISECONDS);
                    label31:
                    RecoveryUI.b(RecoveryUI.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(202428);
                        if (!RecoveryUI.this.isFinishing())
                        {
                          RecoveryUI.c(RecoveryUI.this);
                          RecoveryUI.b(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(R.string.recovery_tips_post));
                          RecoveryUI.d(RecoveryUI.this).setText(RecoveryUI.this.getResources().getString(R.string.recovery_btn_restart));
                          RecoveryUI.d(RecoveryUI.this).setOnClickListener(new View.OnClickListener()
                          {
                            public final void onClick(View paramAnonymous4View)
                            {
                              AppMethodBeat.i(202391);
                              RecoveryUI.e(RecoveryUI.this);
                              AppMethodBeat.o(202391);
                            }
                          });
                        }
                        AppMethodBeat.o(202428);
                      }
                    });
                    AppMethodBeat.o(201879);
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
                  AppMethodBeat.i(202256);
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(202256);
                }
              }, 3000L);
              h.ZvG.be(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(202419);
                  RecoveryUI.f(RecoveryUI.this);
                  RecoveryCrash.jL(RecoveryUI.this.getApplication()).hqd().arg();
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(202419);
                }
              });
              h.ZvG.be(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(202561);
                  RecoveryUI.g(RecoveryUI.this);
                  paramAnonymousView.countDown();
                  AppMethodBeat.o(202561);
                }
              });
              AppMethodBeat.o(202283);
            }
          });
          paramBundle = getSupportActionBar();
          if (paramBundle != null) {
            paramBundle.hide();
          }
          hpW();
          this.UOL.setText(getResources().getString(R.string.recovery_logo));
          this.UOM.setText(getResources().getString(R.string.recovery_tips_pre));
          this.CVZ.setText(getResources().getString(R.string.recovery_btn_start));
          this.UON = ((RecoveryCrash.Record)getIntent().getParcelableExtra("extra_crash_record"));
          j.jT(getApplication()).EA(false).hqz().arg();
          AppMethodBeat.o(202346);
          return;
          paramBundle = paramBundle;
          g.w("MicroMsg.recovery.ui", "set portrait mode fail", paramBundle);
        }
      }
      catch (Throwable paramBundle)
      {
        for (;;)
        {
          g.w("MicroMsg.recovery.ui", "setContentView fail, try raw layout", paramBundle);
          setContentView(R.layout.activity_recovery_raw);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(202349);
    super.onDestroy();
    g.i("MicroMsg.recovery.ui", "activity onDestroy, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(202349);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(202347);
    super.onNewIntent(paramIntent);
    g.i("MicroMsg.recovery.ui", "activity onNewIntent, id = ".concat(String.valueOf(this)));
    AppMethodBeat.o(202347);
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