package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.app.a.a;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WebViewStubTempUI
  extends MMActivity
  implements a.a, MMActivity.a
{
  private int uZG = 0;
  private boolean uZH = false;
  private Dialog uZI = null;
  
  public static void a(Context paramContext, e parame, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(7229);
    com.tencent.mm.plugin.webview.ui.tools.g.a(b(paramContext, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2).getExtras(), "webview", ".stub.WebViewStubTempUI", parame, null);
    AppMethodBeat.o(7229);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(7226);
    Intent localIntent = new Intent(paramContext, WebViewStubTempUI.class);
    if ((paramContext instanceof Service)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("key_action_code", 2);
    StartActivityForResultTask localStartActivityForResultTask = new StartActivityForResultTask();
    localStartActivityForResultTask.qDY = paramString1;
    localStartActivityForResultTask.uZN = paramString2;
    localStartActivityForResultTask.uZO = paramIntent;
    localStartActivityForResultTask.requestCode = 15;
    localStartActivityForResultTask.uZP = false;
    localStartActivityForResultTask.uZQ = paramInt;
    localIntent.putExtra("key_activity_result_task", localStartActivityForResultTask);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(7226);
  }
  
  public static boolean a(Context paramContext, e parame, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7230);
    if (paramContext == null)
    {
      AppMethodBeat.o(7230);
      return true;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (b.checkSelfPermission(paramContext, str) != 0) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(7230);
      return true;
    }
    paramContext = new Bundle();
    paramContext.putInt("key_action_code", 1);
    paramContext.putStringArray("key_permission_types", (String[])localArrayList.toArray(new String[localArrayList.size()]));
    paramContext.putInt("key_permission_request_code", paramInt1);
    paramContext.putInt("key_binder_id", paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.g.a(paramContext, "webview", ".stub.WebViewStubTempUI", parame, null);
    AppMethodBeat.o(7230);
    return false;
  }
  
  private static Intent b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(7227);
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
    localIntent.putExtra("key_alert_result_receiver", new WebViewStubTempUI.1(ak.fetchFreeHandler(), paramOnClickListener1, paramOnClickListener2));
    AppMethodBeat.o(7227);
    return localIntent;
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(7228);
    paramContext.startActivity(b(paramContext, paramString1, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2));
    AppMethodBeat.o(7228);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(7234);
    if (this.uZH)
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(this.uZG);
      if (localg != null) {
        localg.c(paramInt1, paramInt2, paramIntent);
      }
    }
    finish();
    AppMethodBeat.o(7234);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7231);
    super.onCreate(paramBundle);
    switch (getIntent().getIntExtra("key_action_code", -1))
    {
    default: 
      finish();
      AppMethodBeat.o(7231);
      return;
    case 0: 
      paramBundle = (ResultReceiver)getIntent().getParcelableExtra("key_alert_result_receiver");
      if (paramBundle == null)
      {
        finish();
        AppMethodBeat.o(7231);
        return;
      }
      this.uZI = com.tencent.mm.ui.base.h.a(this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new WebViewStubTempUI.2(this, paramBundle), new WebViewStubTempUI.3(this, paramBundle));
      this.uZI.setOnCancelListener(new WebViewStubTempUI.4(this));
      AppMethodBeat.o(7231);
      return;
    case 1: 
      android.support.v4.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
      AppMethodBeat.o(7231);
      return;
    }
    paramBundle = (StartActivityForResultTask)getIntent().getParcelableExtra("key_activity_result_task");
    this.uZG = paramBundle.uZQ;
    this.uZH = true;
    mmSetOnActivityResultCallback(this);
    d.a(this, paramBundle.qDY, paramBundle.uZN, paramBundle.uZO, paramBundle.requestCode, paramBundle.uZP);
    AppMethodBeat.o(7231);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7232);
    super.onDestroy();
    if (this.uZI != null) {
      this.uZI.dismiss();
    }
    AppMethodBeat.o(7232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(7233);
    int i = getIntent().getIntExtra("key_binder_id", 0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(7233);
      return;
      if (paramArrayOfInt[0] == 0) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(i).c(paramInt, -1, null);
      } else {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(i).c(paramInt, 0, null);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class StartActivityForResultTask
    implements Parcelable
  {
    public static final Parcelable.Creator<StartActivityForResultTask> CREATOR;
    String qDY;
    int requestCode;
    String uZN;
    Intent uZO;
    boolean uZP;
    int uZQ;
    
    static
    {
      AppMethodBeat.i(7225);
      CREATOR = new WebViewStubTempUI.StartActivityForResultTask.1();
      AppMethodBeat.o(7225);
    }
    
    StartActivityForResultTask() {}
    
    StartActivityForResultTask(Parcel paramParcel)
    {
      AppMethodBeat.i(7224);
      this.qDY = paramParcel.readString();
      this.uZN = paramParcel.readString();
      this.uZO = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
      this.requestCode = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.uZP = bool;
        this.uZQ = paramParcel.readInt();
        AppMethodBeat.o(7224);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(7223);
      paramParcel.writeString(this.qDY);
      paramParcel.writeString(this.uZN);
      paramParcel.writeParcelable(this.uZO, paramInt);
      paramParcel.writeInt(this.requestCode);
      if (this.uZP) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.uZQ);
        AppMethodBeat.o(7223);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI
 * JD-Core Version:    0.7.0.1
 */