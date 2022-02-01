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
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.MMProgressBar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;

public class NetworkDiagnoseUI
  extends MMActivity
{
  private final int Gsd;
  private int Gse;
  private a Gsf;
  private MMProgressBar Gsg;
  private MTimerHandler Gsh;
  private MMHandler handler;
  private TextView tjP;
  private int zAY;
  
  public NetworkDiagnoseUI()
  {
    AppMethodBeat.i(29717);
    this.Gsd = 100;
    this.zAY = 0;
    this.Gse = 0;
    this.Gsh = new MTimerHandler(new MTimerHandler.CallBack()
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
          NetworkDiagnoseUI.d(NetworkDiagnoseUI.this).fAb();
          AppMethodBeat.o(29707);
          return;
          NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
          if (NetworkDiagnoseUI.b(NetworkDiagnoseUI.this) < 95) {
            NetworkDiagnoseUI.c(NetworkDiagnoseUI.this).setProgress(95);
          }
          NetworkDiagnoseUI.d(NetworkDiagnoseUI.this).fAb();
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
  
  private void fAg()
  {
    AppMethodBeat.i(29723);
    h.a(this, 2131757779, 2131758305, 2131756033, 2131755917, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    return 2131495842;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29719);
    this.tjP = ((TextView)findViewById(2131306956));
    this.Gsg = ((MMProgressBar)findViewById(2131299611));
    this.Gsg.setOnProgressChangedListener(new MMProgressBar.a()
    {
      public final void acg(int paramAnonymousInt)
      {
        AppMethodBeat.i(29708);
        if (paramAnonymousInt < 5)
        {
          NetworkDiagnoseUI.f(NetworkDiagnoseUI.this).setText(NetworkDiagnoseUI.this.getString(2131757802));
          AppMethodBeat.o(29708);
          return;
        }
        if ((paramAnonymousInt >= 5) && (paramAnonymousInt < 95))
        {
          NetworkDiagnoseUI.f(NetworkDiagnoseUI.this).setText(NetworkDiagnoseUI.this.getString(2131761450));
          AppMethodBeat.o(29708);
          return;
        }
        NetworkDiagnoseUI.f(NetworkDiagnoseUI.this).setText(NetworkDiagnoseUI.this.getString(2131766952));
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
    new MMHandler().postDelayed(new Runnable()
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
      fAg();
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
    this.Gsg.setAutoProgress(false);
    super.onPause();
    AppMethodBeat.o(29720);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29721);
    bg.aVF();
    if (!c.isSDCardAvailable())
    {
      u.g(this, null);
      AppMethodBeat.o(29721);
      return;
    }
    this.Gsg.setAutoProgress(true);
    super.onResume();
    AppMethodBeat.o(29721);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI
 * JD-Core Version:    0.7.0.1
 */