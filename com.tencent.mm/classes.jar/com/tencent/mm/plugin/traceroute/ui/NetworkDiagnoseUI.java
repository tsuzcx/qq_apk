package com.tencent.mm.plugin.traceroute.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;

public class NetworkDiagnoseUI
  extends MMActivity
{
  private TextView AmI;
  private int Lbt;
  private final int TRB;
  private int TRC;
  private a TRD;
  private MMProgressBar TRE;
  private MTimerHandler TRF;
  private MMHandler handler;
  
  public NetworkDiagnoseUI()
  {
    AppMethodBeat.i(29717);
    this.TRB = 100;
    this.Lbt = 0;
    this.TRC = 0;
    this.TRF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29706);
        NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, NetworkDiagnoseUI.a(NetworkDiagnoseUI.this) + 1);
        NetworkDiagnoseUI.b(NetworkDiagnoseUI.this, NetworkDiagnoseUI.b(NetworkDiagnoseUI.this));
        if (NetworkDiagnoseUI.b(NetworkDiagnoseUI.this) < 100)
        {
          NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(NetworkDiagnoseUI.b(NetworkDiagnoseUI.this));
          AppMethodBeat.o(29706);
          return true;
        }
        NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(100);
        AppMethodBeat.o(29706);
        return false;
      }
    }, true);
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29707);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(29707);
          return;
          if (NetworkDiagnoseUI.b(NetworkDiagnoseUI.this) < 95) {
            NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(95);
          }
          NetworkDiagnoseUI.d(NetworkDiagnoseUI.this).hPd();
          AppMethodBeat.o(29707);
          return;
          NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
          if (NetworkDiagnoseUI.b(NetworkDiagnoseUI.this) < 95) {
            NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(95);
          }
          NetworkDiagnoseUI.d(NetworkDiagnoseUI.this).hPd();
          AppMethodBeat.o(29707);
          return;
          NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(100);
          NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, false);
          AppMethodBeat.o(29707);
          return;
          NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(100);
          NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, true);
        }
      }
    };
    AppMethodBeat.o(29717);
  }
  
  private void hPi()
  {
    AppMethodBeat.i(29723);
    k.a(this, R.l.gAu, R.l.gEk, R.l.app_yes, R.l.app_no, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(29716);
        NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
        NetworkDiagnoseUI.this.finish();
        AppMethodBeat.o(29716);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(29723);
  }
  
  public int getLayoutId()
  {
    return R.i.gmw;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29719);
    this.AmI = ((TextView)findViewById(R.h.fUR));
    this.TRE = ((MMProgressBar)findViewById(R.h.fFu));
    this.TRE.setOnProgressChangedListener(new NetworkDiagnoseUI.3(this));
    setMMTitle("");
    setBackBtn(new NetworkDiagnoseUI.4(this));
    new MMHandler().postDelayed(new NetworkDiagnoseUI.5(this), 200L);
    AppMethodBeat.o(29719);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29718);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(29718);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29722);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      hPi();
      AppMethodBeat.o(29722);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(29722);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29720);
    this.TRE.setAutoProgress(false);
    super.onPause();
    AppMethodBeat.o(29720);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29721);
    bh.bCz();
    if (!c.isSDCardAvailable())
    {
      aa.j(this, null);
      AppMethodBeat.o(29721);
      return;
    }
    this.TRE.setAutoProgress(true);
    super.onResume();
    AppMethodBeat.o(29721);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI
 * JD-Core Version:    0.7.0.1
 */