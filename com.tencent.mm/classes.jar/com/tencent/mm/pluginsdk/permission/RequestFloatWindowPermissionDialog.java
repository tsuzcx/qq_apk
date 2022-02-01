package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.util.a;
import java.lang.reflect.Field;

public class RequestFloatWindowPermissionDialog
  extends MMBaseActivity
{
  public static int Fhh = 1234;
  private static a Fhi;
  private com.tencent.mm.ui.widget.a.d iNf = null;
  
  public static void a(Context paramContext, String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(151885);
    a(paramContext, paramString1, parama, true, paramString2);
    AppMethodBeat.o(151885);
  }
  
  public static void a(Context paramContext, String paramString1, a parama, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(151886);
    Fhi = parama;
    parama = new Intent(paramContext, RequestFloatWindowPermissionDialog.class);
    parama.putExtra("warning_content", paramString1);
    if (paramBoolean) {
      parama.addFlags(805306368);
    }
    a.a(paramContext, parama, paramString1, RequestFloatWindowPermissionDialog.class.getCanonicalName(), paramString2);
    AppMethodBeat.o(151886);
  }
  
  private void bMX()
  {
    AppMethodBeat.i(151883);
    if (getIntent() == null)
    {
      ae.e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
      AppMethodBeat.o(151883);
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      ae.e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
      AppMethodBeat.o(151883);
      return;
    }
    d.a locala = new d.a(this);
    locala.afN(2131759463);
    locala.aZi(localBundle.getString("warning_content"));
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151877);
        if (RequestFloatWindowPermissionDialog.fec() != null)
        {
          RequestFloatWindowPermissionDialog.fec().c(RequestFloatWindowPermissionDialog.this);
          RequestFloatWindowPermissionDialog.fed();
        }
        RequestFloatWindowPermissionDialog.this.finish();
        AppMethodBeat.o(151877);
      }
    });
    if (com.tencent.mm.compatible.util.d.lA(23)) {}
    for (int i = 2131759462;; i = 2131759461)
    {
      locala.afU(i).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(151878);
          if (com.tencent.mm.compatible.util.d.lA(23)) {
            try
            {
              if (!bu.isNullOrNil((String)Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class)))
              {
                RequestFloatWindowPermissionDialog.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + ak.getPackageName())), RequestFloatWindowPermissionDialog.Fhh);
                AppMethodBeat.o(151878);
                return;
              }
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              ae.e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[] { paramAnonymousDialogInterface.getMessage(), paramAnonymousDialogInterface.getClass().getCanonicalName() });
            }
          }
          paramAnonymousDialogInterface = RequestFloatWindowPermissionDialog.this.getString(2131759464);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousDialogInterface);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("vertical_scroll", true);
          com.tencent.mm.br.d.b(RequestFloatWindowPermissionDialog.this, "webview", ".ui.tools.WebViewUI", localIntent);
          RequestFloatWindowPermissionDialog.this.finish();
          AppMethodBeat.o(151878);
        }
      });
      this.iNf = locala.fQv();
      this.iNf.setCanceledOnTouchOutside(false);
      this.iNf.show();
      AppMethodBeat.o(151883);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151884);
    if (Fhi == null)
    {
      finish();
      AppMethodBeat.o(151884);
      return;
    }
    if (paramInt1 == Fhh) {
      if (b.cc(ak.getContext())) {
        Fhi.a(this);
      }
    }
    for (;;)
    {
      Fhi = null;
      finish();
      AppMethodBeat.o(151884);
      return;
      Fhi.b(this);
      continue;
      Fhi.b(this);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151879);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    bMX();
    AppMethodBeat.o(151879);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(151881);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.iNf != null)
    {
      this.iNf.dismiss();
      this.iNf = null;
    }
    bMX();
    AppMethodBeat.o(151881);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(151882);
    super.onPause();
    y.activateBroadcast(false);
    AppMethodBeat.o(151882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(151880);
    super.onResume();
    y.activateBroadcast(true);
    AppMethodBeat.o(151880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog);
    
    public abstract void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog);
    
    public abstract void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog
 * JD-Core Version:    0.7.0.1
 */