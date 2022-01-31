package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import java.lang.reflect.Field;

public class RequestFloatWindowPermissionDialog
  extends MMBaseActivity
{
  public static int rVD = 1234;
  private static RequestFloatWindowPermissionDialog.a rVE;
  private c eQV = null;
  
  private void UF()
  {
    if (getIntent() == null)
    {
      y.e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      y.e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
      return;
    }
    c.a locala = new c.a(this);
    locala.Ip(a.h.float_window_permission_alert_title);
    locala.aeA(localBundle.getString("warning_content"));
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        RequestFloatWindowPermissionDialog.this.finish();
      }
    });
    if (com.tencent.mm.compatible.util.d.gF(23)) {}
    for (int i = a.h.float_window_permission_alert_ok_M;; i = a.h.float_window_permission_alert_ok)
    {
      locala.Is(i).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (com.tencent.mm.compatible.util.d.gF(23)) {
            try
            {
              if (!bk.bl((String)Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class)))
              {
                RequestFloatWindowPermissionDialog.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + ae.getPackageName())), RequestFloatWindowPermissionDialog.rVD);
                return;
              }
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              y.e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[] { paramAnonymousDialogInterface.getMessage(), paramAnonymousDialogInterface.getClass().getCanonicalName() });
            }
          }
          paramAnonymousDialogInterface = RequestFloatWindowPermissionDialog.this.getString(a.h.floating_window_permission_url);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousDialogInterface);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("vertical_scroll", true);
          com.tencent.mm.br.d.b(RequestFloatWindowPermissionDialog.this, "webview", ".ui.tools.WebViewUI", localIntent);
          RequestFloatWindowPermissionDialog.this.finish();
        }
      });
      this.eQV = locala.aoP();
      this.eQV.setCanceledOnTouchOutside(false);
      this.eQV.show();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, RequestFloatWindowPermissionDialog.a parama)
  {
    rVE = parama;
    parama = new Intent(paramContext, RequestFloatWindowPermissionDialog.class);
    parama.putExtra("warning_content", paramString);
    parama.addFlags(805306368);
    paramContext.startActivity(parama);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (rVE == null) {
      return;
    }
    if (paramInt1 == rVD)
    {
      if (b.bg(ae.getContext()))
      {
        rVE.a(this);
        return;
      }
      rVE.b(this);
      return;
    }
    rVE.b(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    UF();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.eQV != null)
    {
      this.eQV.dismiss();
      this.eQV = null;
    }
    UF();
  }
  
  protected void onPause()
  {
    super.onPause();
    x.b(false, null);
  }
  
  protected void onResume()
  {
    super.onResume();
    x.b(true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog
 * JD-Core Version:    0.7.0.1
 */