package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.mm.ui.widget.a.a;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class AlertActivity
  extends AppCompatActivity
{
  private static c.a scn;
  private DialogInterface.OnDismissListener rjP;
  private DialogInterface.OnCancelListener uGw;
  
  public static void a(c.a parama)
  {
    scn = parama;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(17170445));
    }
    if (scn != null)
    {
      scn.mContext = this;
      this.rjP = scn.wmT.Oj;
      this.uGw = scn.wmT.Oi;
      scn.a(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          if (AlertActivity.a(AlertActivity.this) != null) {
            AlertActivity.a(AlertActivity.this).onDismiss(paramAnonymousDialogInterface);
          }
          AlertActivity.this.finish();
        }
      });
      scn.e(new AlertActivity.2(this));
      scn.aoP().show();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    scn = null;
  }
  
  protected void onPause()
  {
    overridePendingTransition(0, 0);
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity
 * JD-Core Version:    0.7.0.1
 */