package com.tencent.mm.plugin.traceroute.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.MMProgressBar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

public class NetworkDiagnoseUI
  extends MMActivity
{
  private MMProgressBar BAa;
  private av BAb;
  private final int BzX;
  private int BzY;
  private a BzZ;
  private ap handler;
  private TextView rBT;
  private int vUu;
  
  public NetworkDiagnoseUI()
  {
    AppMethodBeat.i(29717);
    this.BzX = 100;
    this.vUu = 0;
    this.BzY = 0;
    this.BAb = new av(new av.a()
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
    this.handler = new ap()
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
          NetworkDiagnoseUI.d(NetworkDiagnoseUI.this).erb();
          AppMethodBeat.o(29707);
          return;
          NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
          if (NetworkDiagnoseUI.b(NetworkDiagnoseUI.this) < 95) {
            NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(95);
          }
          NetworkDiagnoseUI.d(NetworkDiagnoseUI.this).erb();
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
  
  private void erg()
  {
    AppMethodBeat.i(29723);
    h.a(this, 2131757552, 2131758045, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    return 2131495012;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29719);
    this.rBT = ((TextView)findViewById(2131304090));
    this.BAa = ((MMProgressBar)findViewById(2131299091));
    this.BAa.setOnProgressChangedListener(new MMProgressBar.a()
    {
      public final void Tj(int paramAnonymousInt)
      {
        AppMethodBeat.i(29708);
        if (paramAnonymousInt < 5)
        {
          NetworkDiagnoseUI.f(NetworkDiagnoseUI.this).setText(NetworkDiagnoseUI.this.getString(2131757575));
          AppMethodBeat.o(29708);
          return;
        }
        if ((paramAnonymousInt >= 5) && (paramAnonymousInt < 95))
        {
          NetworkDiagnoseUI.f(NetworkDiagnoseUI.this).setText(NetworkDiagnoseUI.this.getString(2131760072));
          AppMethodBeat.o(29708);
          return;
        }
        NetworkDiagnoseUI.f(NetworkDiagnoseUI.this).setText(NetworkDiagnoseUI.this.getString(2131764594));
        AppMethodBeat.o(29708);
      }
    });
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29709);
        NetworkDiagnoseUI.g(NetworkDiagnoseUI.this);
        AppMethodBeat.o(29709);
        return true;
      }
    });
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29710);
        NetworkDiagnoseUI.h(NetworkDiagnoseUI.this);
        AppMethodBeat.o(29710);
      }
    }, 200L);
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
      erg();
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
    this.BAa.setAutoProgress(false);
    super.onPause();
    AppMethodBeat.o(29720);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29721);
    ba.aBQ();
    if (!c.isSDCardAvailable())
    {
      t.g(this, null);
      AppMethodBeat.o(29721);
      return;
    }
    this.BAa.setAutoProgress(true);
    super.onResume();
    AppMethodBeat.o(29721);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI
 * JD-Core Version:    0.7.0.1
 */