package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import junit.framework.Assert;

public class AlertActivity
  extends AppCompatActivity
{
  private static d.a Kfg;
  private DialogInterface.OnCancelListener CJj;
  private boolean OwV = false;
  private DialogInterface.OnDismissListener ebe;
  
  public static void a(d.a parama)
  {
    Kfg = parama;
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
    this.OwV = getIntent().getBooleanExtra("dialog_show_top", false);
    Assert.assertNotNull(Kfg);
    Window localWindow;
    if (Kfg != null)
    {
      Kfg.mContext = this;
      this.ebe = Kfg.QNF.XZ;
      this.CJj = Kfg.QNF.XY;
      Kfg.a(new DialogInterface.OnDismissListener()
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
      Kfg.f(new DialogInterface.OnCancelListener()
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
      paramBundle = Kfg.hbn();
      if (this.OwV)
      {
        localWindow = paramBundle.getWindow();
        if (localWindow != null)
        {
          if (Build.VERSION.SDK_INT < 26) {
            break label223;
          }
          localWindow.setType(2038);
        }
      }
    }
    for (;;)
    {
      as.d("MicroMsg.AlertActivity", "show top window not null!!", new Object[0]);
      paramBundle.show();
      if (!paramBundle.isShowing())
      {
        as.e("MicroMsg.AlertActivity", "show dialog FAILED, finish AlertActivity!", new Object[0]);
        finish();
      }
      AppMethodBeat.o(159083);
      return;
      label223:
      localWindow.setType(2002);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(159085);
    super.onDestroy();
    Kfg = null;
    AppMethodBeat.o(159085);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(159084);
    overridePendingTransition(0, 0);
    super.onPause();
    AppMethodBeat.o(159084);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity
 * JD-Core Version:    0.7.0.1
 */