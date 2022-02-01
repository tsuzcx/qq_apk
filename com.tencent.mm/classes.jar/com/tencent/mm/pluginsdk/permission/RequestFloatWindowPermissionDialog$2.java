package com.tencent.mm.pluginsdk.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;

final class RequestFloatWindowPermissionDialog$2
  implements DialogInterface.OnClickListener
{
  RequestFloatWindowPermissionDialog$2(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(151878);
    if (d.rb(23)) {
      try
      {
        if (!Util.isNullOrNil((String)Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class)))
        {
          this.XUD.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + MMApplicationContext.getPackageName())), RequestFloatWindowPermissionDialog.HoH);
          AppMethodBeat.o(151878);
          return;
        }
      }
      catch (Exception paramDialogInterface)
      {
        Log.e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[] { paramDialogInterface.getMessage(), paramDialogInterface.getClass().getCanonicalName() });
      }
    }
    paramDialogInterface = this.XUD.getString(c.h.floating_window_permission_url);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramDialogInterface);
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    c.b(this.XUD, "webview", ".ui.tools.WebViewUI", localIntent);
    this.XUD.finish();
    AppMethodBeat.o(151878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.2
 * JD-Core Version:    0.7.0.1
 */