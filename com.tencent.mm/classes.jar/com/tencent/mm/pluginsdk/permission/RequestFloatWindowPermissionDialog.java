package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.util.a;
import java.util.ArrayList;
import java.util.Iterator;

public class RequestFloatWindowPermissionDialog
  extends MMBaseActivity
{
  public static int HoH;
  private static a XUB;
  private static ArrayList<a> XUC;
  private e pjp = null;
  
  static
  {
    AppMethodBeat.i(244643);
    HoH = 1234;
    XUC = new ArrayList();
    AppMethodBeat.o(244643);
  }
  
  public static void a(Context paramContext, String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(151885);
    a(paramContext, paramString1, new b(parama), true, paramString2);
    AppMethodBeat.o(151885);
  }
  
  public static void a(Context paramContext, String paramString1, a parama, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(151886);
    a(paramContext, paramString1, new b(parama), paramBoolean, false, paramString2);
    AppMethodBeat.o(151886);
  }
  
  public static void a(Context paramContext, String paramString1, a parama, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    AppMethodBeat.i(244636);
    XUB = new b(parama);
    parama = new Intent(paramContext, RequestFloatWindowPermissionDialog.class);
    parama.putExtra("warning_content", paramString1);
    if (paramBoolean1) {
      parama.addFlags(805306368);
    }
    a.a(paramContext, parama, paramString1, RequestFloatWindowPermissionDialog.class.getCanonicalName(), paramBoolean2, paramString2);
    AppMethodBeat.o(244636);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(244592);
    if (!XUC.contains(parama)) {
      XUC.add(parama);
    }
    AppMethodBeat.o(244592);
  }
  
  private void cZS()
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
    e.a locala = new e.a(this);
    locala.aEK(c.h.float_window_permission_alert_title);
    locala.bDw(localBundle.getString("warning_content"));
    locala.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(151877);
        if (RequestFloatWindowPermissionDialog.iIU() != null)
        {
          RequestFloatWindowPermissionDialog.iIU().c(RequestFloatWindowPermissionDialog.this);
          RequestFloatWindowPermissionDialog.iIV();
        }
        RequestFloatWindowPermissionDialog.this.finish();
        AppMethodBeat.o(151877);
      }
    });
    if (d.rb(23)) {}
    for (int i = c.h.float_window_permission_alert_ok_M;; i = c.h.float_window_permission_alert_ok)
    {
      locala.aER(i).c(new RequestFloatWindowPermissionDialog.2(this));
      this.pjp = locala.jHH();
      this.pjp.setCanceledOnTouchOutside(false);
      this.pjp.show();
      AppMethodBeat.o(151883);
      return;
    }
  }
  
  public static void d(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(244605);
    Iterator localIterator = XUC.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramRequestFloatWindowPermissionDialog);
    }
    AppMethodBeat.o(244605);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151884);
    if (XUB == null)
    {
      finish();
      AppMethodBeat.o(151884);
      return;
    }
    if (paramInt1 == HoH) {
      if (b.dh(MMApplicationContext.getContext())) {
        XUB.a(this);
      }
    }
    for (;;)
    {
      XUB = null;
      finish();
      AppMethodBeat.o(151884);
      return;
      XUB.b(this);
      continue;
      XUB.b(this);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151879);
    super.onCreate(paramBundle);
    cZS();
    AppMethodBeat.o(151879);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(151881);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (this.pjp != null)
    {
      this.pjp.dismiss();
      this.pjp = null;
    }
    cZS();
    AppMethodBeat.o(151881);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(151882);
    super.onPause();
    ag.activateBroadcast(false);
    AppMethodBeat.o(151882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(151880);
    super.onResume();
    ag.activateBroadcast(true);
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
  
  static final class b
    implements RequestFloatWindowPermissionDialog.a
  {
    RequestFloatWindowPermissionDialog.a XUE;
    
    b(RequestFloatWindowPermissionDialog.a parama)
    {
      this.XUE = parama;
    }
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(244591);
      RequestFloatWindowPermissionDialog.d(paramRequestFloatWindowPermissionDialog);
      this.XUE.a(paramRequestFloatWindowPermissionDialog);
      AppMethodBeat.o(244591);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(244598);
      RequestFloatWindowPermissionDialog.d(paramRequestFloatWindowPermissionDialog);
      this.XUE.b(paramRequestFloatWindowPermissionDialog);
      AppMethodBeat.o(244598);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(244604);
      RequestFloatWindowPermissionDialog.d(paramRequestFloatWindowPermissionDialog);
      this.XUE.c(paramRequestFloatWindowPermissionDialog);
      AppMethodBeat.o(244604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog
 * JD-Core Version:    0.7.0.1
 */