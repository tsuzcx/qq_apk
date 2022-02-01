package com.tencent.mm.ui;

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
import com.tencent.mm.ui.base.z;
import com.tencent.mm.ui.base.z.a;
import com.tencent.mm.ui.widget.a.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public class AlertActivity
  extends AppCompatActivity
{
  private static e.a GGP;
  private static z.a adug;
  private DialogInterface.OnCancelListener OTa;
  private boolean aduh = false;
  private DialogInterface.OnDismissListener iaY;
  private int scene = 1;
  
  public static void a(z.a parama)
  {
    adug = parama;
  }
  
  public static void a(e.a parama)
  {
    GGP = parama;
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
    this.aduh = getIntent().getBooleanExtra("dialog_show_top", false);
    this.scene = getIntent().getIntExtra("dialog_scene", 1);
    bc.i("MicroMsg.AlertActivity", "show alert, scene:%s", new Object[] { Integer.valueOf(this.scene) });
    Object localObject;
    if (this.scene == 1)
    {
      if (GGP != null)
      {
        GGP.mContext = this;
        this.iaY = GGP.ageh.mOnDismissListener;
        this.OTa = GGP.ageh.mOnCancelListener;
        GGP.c(new DialogInterface.OnDismissListener()
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
        GGP.e(new DialogInterface.OnCancelListener()
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
        paramBundle = GGP.jHH();
        if (this.aduh)
        {
          localObject = paramBundle.getWindow();
          if (localObject != null)
          {
            if (Build.VERSION.SDK_INT < 26) {
              break label260;
            }
            ((Window)localObject).setType(2038);
          }
        }
        for (;;)
        {
          bc.d("MicroMsg.AlertActivity", "show top window not null!!", new Object[0]);
          paramBundle.show();
          if (!paramBundle.isShowing())
          {
            bc.e("MicroMsg.AlertActivity", "show dialog FAILED, finish AlertActivity!", new Object[0]);
            finish();
          }
          AppMethodBeat.o(159083);
          return;
          label260:
          ((Window)localObject).setType(2002);
        }
      }
      bc.e("MicroMsg.AlertActivity", "mBuilder is null, finish AlertActivity!", new Object[0]);
      finish();
      AppMethodBeat.o(159083);
      return;
    }
    if (this.scene == 2)
    {
      if (adug != null)
      {
        adug.mContext = this;
        this.iaY = adug.adUo.iaY;
        adug.b(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(249144);
            bc.i("MicroMsg.AlertActivity", "mTipsBuilder onDismiss", new Object[0]);
            if (AlertActivity.a(AlertActivity.this) != null) {
              AlertActivity.a(AlertActivity.this).onDismiss(paramAnonymousDialogInterface);
            }
            AlertActivity.this.finish();
            AppMethodBeat.o(249144);
          }
        });
        paramBundle = adug;
        localObject = new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(249141);
            if (AlertActivity.b(AlertActivity.this) != null) {
              AlertActivity.b(AlertActivity.this).onCancel(paramAnonymousDialogInterface);
            }
            AlertActivity.this.finish();
            AppMethodBeat.o(249141);
          }
        };
        paramBundle.adUo.mOnCancelListener = ((DialogInterface.OnCancelListener)localObject);
        paramBundle = adug.jmN();
        paramBundle.show();
        if (!paramBundle.isShowing())
        {
          bc.e("MicroMsg.AlertActivity", "show dialog FAILED, finish AlertActivity!", new Object[0]);
          finish();
        }
        AppMethodBeat.o(159083);
        return;
      }
      bc.e("MicroMsg.AlertActivity", "mTipsBuilder is null, finish AlertActivity!", new Object[0]);
      finish();
    }
    AppMethodBeat.o(159083);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(159085);
    super.onDestroy();
    GGP = null;
    adug = null;
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
    AppMethodBeat.i(249752);
    super.onResume();
    if ((GGP == null) && (adug == null))
    {
      bc.e("MicroMsg.AlertActivity", "AlertActivity onResume() with null mBuilder, exiting this transparent proxy activity...", new Object[0]);
      finish();
    }
    AppMethodBeat.o(249752);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity
 * JD-Core Version:    0.7.0.1
 */