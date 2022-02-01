package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class AlertActivity
  extends AppCompatActivity
{
  private static d.a RfU;
  private DialogInterface.OnCancelListener IOJ;
  private boolean VPZ = false;
  private DialogInterface.OnDismissListener fVb;
  
  public static void a(d.a parama)
  {
    RfU = parama;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159083);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(17170445));
    }
    this.VPZ = getIntent().getBooleanExtra("dialog_show_top", false);
    Window localWindow;
    if (RfU != null)
    {
      RfU.mContext = this;
      this.fVb = RfU.Ymv.ft;
      this.IOJ = RfU.Ymv.fs;
      RfU.a(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(159081);
          if (AlertActivity.a(AlertActivity.this) != null) {
            AlertActivity.a(AlertActivity.this).onDismiss(paramAnonymousDialogInterface);
          }
          AlertActivity.this.finish();
          AppMethodBeat.o(159081);
        }
      });
      RfU.f(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(159082);
          if (AlertActivity.b(AlertActivity.this) != null) {
            AlertActivity.b(AlertActivity.this).onCancel(paramAnonymousDialogInterface);
          }
          AlertActivity.this.finish();
          AppMethodBeat.o(159082);
        }
      });
      paramBundle = RfU.icu();
      if (this.VPZ)
      {
        localWindow = paramBundle.getWindow();
        if (localWindow != null)
        {
          if (Build.VERSION.SDK_INT < 26) {
            break label217;
          }
          localWindow.setType(2038);
        }
      }
    }
    for (;;)
    {
      av.d("MicroMsg.AlertActivity", "show top window not null!!", new Object[0]);
      paramBundle.show();
      if (!paramBundle.isShowing())
      {
        av.e("MicroMsg.AlertActivity", "show dialog FAILED, finish AlertActivity!", new Object[0]);
        finish();
      }
      AppMethodBeat.o(159083);
      return;
      label217:
      localWindow.setType(2002);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(159085);
    super.onDestroy();
    RfU = null;
    AppMethodBeat.o(159085);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(159084);
    overridePendingTransition(0, 0);
    super.onPause();
    AppMethodBeat.o(159084);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(252005);
    super.onResume();
    if (RfU == null)
    {
      av.e("MicroMsg.AlertActivity", "AlertActivity onResume() with null mBuilder, exiting this transparent proxy activity...", new Object[0]);
      finish();
    }
    AppMethodBeat.o(252005);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity
 * JD-Core Version:    0.7.0.1
 */