package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public class AlertActivity
  extends AppCompatActivity
{
  private static c.a vTt;
  private DialogInterface.OnDismissListener cHC;
  private DialogInterface.OnCancelListener yTy;
  
  public static void a(c.a parama)
  {
    vTt = parama;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112442);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(17170445));
    }
    if (vTt != null)
    {
      vTt.mContext = this;
      this.cHC = vTt.AGP.NX;
      this.yTy = vTt.AGP.NW;
      vTt.a(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(112440);
          if (AlertActivity.a(AlertActivity.this) != null) {
            AlertActivity.a(AlertActivity.this).onDismiss(paramAnonymousDialogInterface);
          }
          AlertActivity.this.finish();
          AppMethodBeat.o(112440);
        }
      });
      vTt.e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(112441);
          if (AlertActivity.b(AlertActivity.this) != null) {
            AlertActivity.b(AlertActivity.this).onCancel(paramAnonymousDialogInterface);
          }
          AlertActivity.this.finish();
          AppMethodBeat.o(112441);
        }
      });
      vTt.aLZ().show();
    }
    AppMethodBeat.o(112442);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(112444);
    super.onDestroy();
    vTt = null;
    AppMethodBeat.o(112444);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(112443);
    overridePendingTransition(0, 0);
    super.onPause();
    AppMethodBeat.o(112443);
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