package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.lang.reflect.Field;

public class RequestFloatWindowPermissionDialog
  extends MMBaseActivity
{
  public static int vMy = 1234;
  private static RequestFloatWindowPermissionDialog.a vMz;
  private c giQ = null;
  
  public static void a(Context paramContext, String paramString, RequestFloatWindowPermissionDialog.a parama)
  {
    AppMethodBeat.i(79445);
    vMz = parama;
    parama = new Intent(paramContext, RequestFloatWindowPermissionDialog.class);
    parama.putExtra("warning_content", paramString);
    parama.addFlags(805306368);
    paramContext.startActivity(parama);
    AppMethodBeat.o(79445);
  }
  
  private void aVD()
  {
    AppMethodBeat.i(79443);
    if (getIntent() == null)
    {
      ab.e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
      AppMethodBeat.o(79443);
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      ab.e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
      AppMethodBeat.o(79443);
      return;
    }
    c.a locala = new c.a(this);
    locala.Rb(2131299997);
    locala.avn(localBundle.getString("warning_content"));
    locala.e(new RequestFloatWindowPermissionDialog.1(this));
    if (com.tencent.mm.compatible.util.d.fv(23)) {}
    for (int i = 2131299996;; i = 2131299995)
    {
      locala.Ri(i).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(79438);
          if (com.tencent.mm.compatible.util.d.fv(23)) {
            try
            {
              if (!bo.isNullOrNil((String)Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class)))
              {
                RequestFloatWindowPermissionDialog.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + ah.getPackageName())), RequestFloatWindowPermissionDialog.vMy);
                AppMethodBeat.o(79438);
                return;
              }
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              ab.e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[] { paramAnonymousDialogInterface.getMessage(), paramAnonymousDialogInterface.getClass().getCanonicalName() });
            }
          }
          paramAnonymousDialogInterface = RequestFloatWindowPermissionDialog.this.getString(2131299998);
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousDialogInterface);
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("vertical_scroll", true);
          com.tencent.mm.bq.d.b(RequestFloatWindowPermissionDialog.this, "webview", ".ui.tools.WebViewUI", localIntent);
          RequestFloatWindowPermissionDialog.this.finish();
          AppMethodBeat.o(79438);
        }
      });
      this.giQ = locala.aLZ();
      this.giQ.setCanceledOnTouchOutside(false);
      this.giQ.show();
      AppMethodBeat.o(79443);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79444);
    if (vMz == null)
    {
      AppMethodBeat.o(79444);
      return;
    }
    if (paramInt1 == vMy)
    {
      if (b.bK(ah.getContext()))
      {
        vMz.a(this);
        AppMethodBeat.o(79444);
        return;
      }
      vMz.b(this);
      AppMethodBeat.o(79444);
      return;
    }
    vMz.b(this);
    AppMethodBeat.o(79444);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79439);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    aVD();
    AppMethodBeat.o(79439);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(79441);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.giQ != null)
    {
      this.giQ.dismiss();
      this.giQ = null;
    }
    aVD();
    AppMethodBeat.o(79441);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(79442);
    super.onPause();
    y.activateBroadcast(false);
    AppMethodBeat.o(79442);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(79440);
    super.onResume();
    y.activateBroadcast(true);
    AppMethodBeat.o(79440);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog
 * JD-Core Version:    0.7.0.1
 */