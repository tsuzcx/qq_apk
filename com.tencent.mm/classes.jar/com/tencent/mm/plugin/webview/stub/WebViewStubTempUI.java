package com.tencent.mm.plugin.webview.stub;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.a.a;
import android.support.v4.content.b;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WebViewStubTempUI
  extends MMActivity
  implements a.a, MMActivity.a
{
  private int rkm = 0;
  private boolean rkn = false;
  private Dialog rko = null;
  
  public static void a(Context paramContext, e parame, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    Intent localIntent = new Intent(paramContext, WebViewStubTempUI.class);
    if ((paramContext instanceof Service)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("key_action_code", 0);
    localIntent.putExtra("key_alert_cancelable", false);
    localIntent.putExtra("key_alert_message", paramString1);
    localIntent.putExtra("key_alert_title", paramString2);
    localIntent.putExtra("key_alert_yes", paramString3);
    localIntent.putExtra("key_alert_no", paramString4);
    localIntent.putExtra("key_alert_result_receiver", new WebViewStubTempUI.1(ah.fetchFreeHandler(), paramOnClickListener1, paramOnClickListener2));
    com.tencent.mm.plugin.webview.ui.tools.e.a(localIntent.getExtras(), "webview", ".stub.WebViewStubTempUI", parame, null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, WebViewStubTempUI.class);
    if ((paramContext instanceof Service)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("key_action_code", 2);
    WebViewStubTempUI.StartActivityForResultTask localStartActivityForResultTask = new WebViewStubTempUI.StartActivityForResultTask();
    localStartActivityForResultTask.nQb = paramString1;
    localStartActivityForResultTask.rkt = paramString2;
    localStartActivityForResultTask.rku = paramIntent;
    localStartActivityForResultTask.bQU = 15;
    localStartActivityForResultTask.rkv = false;
    localStartActivityForResultTask.rhg = paramInt;
    localIntent.putExtra("key_activity_result_task", localStartActivityForResultTask);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a(Context paramContext, e parame, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {}
    ArrayList localArrayList;
    do
    {
      return true;
      localArrayList = new ArrayList();
      int i = 0;
      while (i <= 0)
      {
        String str = paramArrayOfString[0];
        if (b.checkSelfPermission(paramContext, str) != 0) {
          localArrayList.add(str);
        }
        i += 1;
      }
    } while (localArrayList.size() == 0);
    paramContext = new Bundle();
    paramContext.putInt("key_action_code", 1);
    paramContext.putStringArray("key_permission_types", (String[])localArrayList.toArray(new String[localArrayList.size()]));
    paramContext.putInt("key_permission_request_code", paramInt1);
    paramContext.putInt("key_binder_id", paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.e.a(paramContext, "webview", ".stub.WebViewStubTempUI", parame, null);
    return false;
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.rkn)
    {
      g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(this.rkm);
      if (localg != null) {
        localg.c(paramInt1, paramInt2, paramIntent);
      }
    }
    finish();
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    switch (getIntent().getIntExtra("key_action_code", -1))
    {
    default: 
      finish();
      return;
    case 0: 
      paramBundle = (ResultReceiver)getIntent().getParcelableExtra("key_alert_result_receiver");
      if (paramBundle == null)
      {
        finish();
        return;
      }
      this.rko = com.tencent.mm.ui.base.h.a(this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new WebViewStubTempUI.2(this, paramBundle), new WebViewStubTempUI.3(this, paramBundle));
      this.rko.setOnCancelListener(new WebViewStubTempUI.4(this));
      return;
    case 1: 
      android.support.v4.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
      return;
    }
    paramBundle = (WebViewStubTempUI.StartActivityForResultTask)getIntent().getParcelableExtra("key_activity_result_task");
    this.rkm = paramBundle.rhg;
    this.rkn = true;
    this.gJb = this;
    d.a(this, paramBundle.nQb, paramBundle.rkt, paramBundle.rku, paramBundle.bQU, paramBundle.rkv);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.rko != null) {
      this.rko.dismiss();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = getIntent().getIntExtra("key_binder_id", 0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      finish();
      return;
      if (paramArrayOfInt[0] == 0) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(i).c(paramInt, -1, null);
      } else {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(i).c(paramInt, 0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI
 * JD-Core Version:    0.7.0.1
 */