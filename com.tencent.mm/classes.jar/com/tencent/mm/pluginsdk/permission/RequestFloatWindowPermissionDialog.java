package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.util.a;

public class RequestFloatWindowPermissionDialog
  extends MMBaseActivity
{
  public static int JXZ = 1234;
  private static a JYa;
  private com.tencent.mm.ui.widget.a.d jzT = null;
  
  public static void a(Context paramContext, String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(151885);
    a(paramContext, paramString1, parama, true, paramString2);
    AppMethodBeat.o(151885);
  }
  
  public static void a(Context paramContext, String paramString1, a parama, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(151886);
    JYa = parama;
    parama = new Intent(paramContext, RequestFloatWindowPermissionDialog.class);
    parama.putExtra("warning_content", paramString1);
    if (paramBoolean) {
      parama.addFlags(805306368);
    }
    a.a(paramContext, parama, paramString1, RequestFloatWindowPermissionDialog.class.getCanonicalName(), paramString2);
    AppMethodBeat.o(151886);
  }
  
  private void cjQ()
  {
    AppMethodBeat.i(151883);
    if (getIntent() == null)
    {
      Log.e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
      AppMethodBeat.o(151883);
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      Log.e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
      AppMethodBeat.o(151883);
      return;
    }
    d.a locala = new d.a(this);
    locala.aoO(2131760778);
    locala.boo(localBundle.getString("warning_content"));
    locala.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151877);
        if (RequestFloatWindowPermissionDialog.gnn() != null)
        {
          RequestFloatWindowPermissionDialog.gnn().onResultCancel(RequestFloatWindowPermissionDialog.this);
          RequestFloatWindowPermissionDialog.gno();
        }
        RequestFloatWindowPermissionDialog.this.finish();
        AppMethodBeat.o(151877);
      }
    });
    if (com.tencent.mm.compatible.util.d.oD(23)) {}
    for (int i = 2131760777;; i = 2131760776)
    {
      locala.aoV(i).c(new RequestFloatWindowPermissionDialog.2(this));
      this.jzT = locala.hbn();
      this.jzT.setCanceledOnTouchOutside(false);
      this.jzT.show();
      AppMethodBeat.o(151883);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151884);
    if (JYa == null)
    {
      finish();
      AppMethodBeat.o(151884);
      return;
    }
    if (paramInt1 == JXZ) {
      if (b.cx(MMApplicationContext.getContext())) {
        JYa.onResultAllow(this);
      }
    }
    for (;;)
    {
      JYa = null;
      finish();
      AppMethodBeat.o(151884);
      return;
      JYa.onResultRefuse(this);
      continue;
      JYa.onResultRefuse(this);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151879);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    cjQ();
    AppMethodBeat.o(151879);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(151881);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.jzT != null)
    {
      this.jzT.dismiss();
      this.jzT = null;
    }
    cjQ();
    AppMethodBeat.o(151881);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(151882);
    super.onPause();
    aa.activateBroadcast(false);
    AppMethodBeat.o(151882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(151880);
    super.onResume();
    aa.activateBroadcast(true);
    AppMethodBeat.o(151880);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void onResultAllow(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog);
    
    public abstract void onResultCancel(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog);
    
    public abstract void onResultRefuse(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog
 * JD-Core Version:    0.7.0.1
 */