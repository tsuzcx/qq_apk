package com.tencent.mm.plugin.webview.stub;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import androidx.core.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(7)
public class WebViewStubTempUI
  extends MMActivity
  implements a.a, MMActivity.a
{
  private int WRH = 0;
  private boolean WRI = false;
  private Dialog WRJ = null;
  
  public static void a(Context paramContext, f paramf, String paramString1, String paramString2, String paramString3, String paramString4, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(79423);
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
    localIntent.putExtra("key_alert_result_receiver", new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79412);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(79412);
          return;
          paramOnClickListener1.onClick(null, 0);
          AppMethodBeat.o(79412);
          return;
          paramOnClickListener2.onClick(null, 0);
        }
      }
    });
    com.tencent.mm.plugin.webview.ui.tools.f.a(localIntent.getExtras(), "webview", ".stub.WebViewStubTempUI", paramf, null);
    AppMethodBeat.o(79423);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(79420);
    Intent localIntent = new Intent(paramContext, WebViewStubTempUI.class);
    if ((paramContext instanceof Service)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("key_action_code", 2);
    StartActivityForResultTask localStartActivityForResultTask = new StartActivityForResultTask();
    localStartActivityForResultTask.HjZ = paramString1;
    localStartActivityForResultTask.hJP = paramString2;
    localStartActivityForResultTask.WRO = paramIntent;
    localStartActivityForResultTask.hPm = 15;
    localStartActivityForResultTask.WRP = false;
    localStartActivityForResultTask.WRQ = paramInt;
    localIntent.putExtra("key_activity_result_task", localStartActivityForResultTask);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/webview/stub/WebViewStubTempUI", "startActivityForResult", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;IZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/webview/stub/WebViewStubTempUI", "startActivityForResult", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;IZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(79420);
  }
  
  public static boolean a(Context paramContext, f paramf, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79424);
    if (paramContext == null)
    {
      AppMethodBeat.o(79424);
      return true;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (androidx.core.content.a.checkSelfPermission(paramContext, str) != 0) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(79424);
      return true;
    }
    paramContext = new Bundle();
    paramContext.putInt("key_action_code", 1);
    paramContext.putStringArray("key_permission_types", (String[])localArrayList.toArray(new String[localArrayList.size()]));
    paramContext.putInt("key_permission_request_code", paramInt1);
    paramContext.putInt("key_binder_id", paramInt2);
    com.tencent.mm.plugin.webview.ui.tools.f.a(paramContext, "webview", ".stub.WebViewStubTempUI", paramf, null);
    AppMethodBeat.o(79424);
    return false;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(79428);
    if (this.WRI)
    {
      j localj = com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WRH);
      if (localj != null) {
        localj.mmOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    finish();
    AppMethodBeat.o(79428);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(79425);
    super.onCreate(paramBundle);
    switch (getIntent().getIntExtra("key_action_code", -1))
    {
    default: 
      finish();
      AppMethodBeat.o(79425);
      return;
    case 0: 
      paramBundle = (ResultReceiver)getIntent().getParcelableExtra("key_alert_result_receiver");
      if (paramBundle == null)
      {
        finish();
        AppMethodBeat.o(79425);
        return;
      }
      this.WRJ = com.tencent.mm.ui.base.k.a(this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(79413);
          paramBundle.send(0, null);
          WebViewStubTempUI.this.finish();
          AppMethodBeat.o(79413);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(79414);
          paramBundle.send(1, null);
          WebViewStubTempUI.this.finish();
          AppMethodBeat.o(79414);
        }
      });
      this.WRJ.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(79415);
          WebViewStubTempUI.this.finish();
          AppMethodBeat.o(79415);
        }
      });
      AppMethodBeat.o(79425);
      return;
    case 1: 
      androidx.core.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
      AppMethodBeat.o(79425);
      return;
    }
    paramBundle = (StartActivityForResultTask)getIntent().getParcelableExtra("key_activity_result_task");
    this.WRH = paramBundle.WRQ;
    this.WRI = true;
    mmSetOnActivityResultCallback(this);
    c.a(this, paramBundle.HjZ, paramBundle.hJP, paramBundle.WRO, paramBundle.hPm, paramBundle.WRP);
    AppMethodBeat.o(79425);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79426);
    super.onDestroy();
    if (this.WRJ != null) {
      this.WRJ.dismiss();
    }
    AppMethodBeat.o(79426);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79427);
    int i = getIntent().getIntExtra("key_binder_id", 0);
    switch (paramInt)
    {
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(79427);
      return;
      if (paramArrayOfInt[0] == 0) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(i).mmOnActivityResult(paramInt, -1, null);
      } else {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(i).mmOnActivityResult(paramInt, 0, null);
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
    String HjZ;
    Intent WRO;
    boolean WRP;
    int WRQ;
    String hJP;
    int hPm;
    
    static
    {
      AppMethodBeat.i(79419);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(79419);
    }
    
    StartActivityForResultTask() {}
    
    StartActivityForResultTask(Parcel paramParcel)
    {
      AppMethodBeat.i(79418);
      this.HjZ = paramParcel.readString();
      this.hJP = paramParcel.readString();
      this.WRO = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
      this.hPm = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.WRP = bool;
        this.WRQ = paramParcel.readInt();
        AppMethodBeat.o(79418);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(79417);
      paramParcel.writeString(this.HjZ);
      paramParcel.writeString(this.hJP);
      paramParcel.writeParcelable(this.WRO, paramInt);
      paramParcel.writeInt(this.hPm);
      if (this.WRP) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.WRQ);
        AppMethodBeat.o(79417);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI
 * JD-Core Version:    0.7.0.1
 */