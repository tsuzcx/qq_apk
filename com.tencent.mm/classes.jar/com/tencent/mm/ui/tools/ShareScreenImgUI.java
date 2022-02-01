package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.u;

@com.tencent.mm.ui.base.a(3)
public class ShareScreenImgUI
  extends MMActivity
{
  String filePath;
  private MMHandler handler;
  private Intent intent;
  private ProgressDialog lzP;
  Uri uri;
  
  public ShareScreenImgUI()
  {
    AppMethodBeat.i(39163);
    this.lzP = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.handler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(39162);
        ShareScreenImgUI.a(ShareScreenImgUI.this);
        if (Util.isNullOrNil(ShareScreenImgUI.this.filePath))
        {
          Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
          ShareScreenImgUI.b(ShareScreenImgUI.this);
          ShareScreenImgUI.this.finish();
          AppMethodBeat.o(39162);
          return;
        }
        ShareScreenImgUI.c(ShareScreenImgUI.this);
        AppMethodBeat.o(39162);
      }
    };
    AppMethodBeat.o(39163);
  }
  
  private void bCD(String paramString)
  {
    AppMethodBeat.i(250982);
    if (paramString.equals("android.intent.action.VIEW"))
    {
      Log.i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(paramString)));
      if ((this.uri == null) || (!Util.isUriSafeToBeCopySrc(this.uri)))
      {
        Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
        jDo();
        finish();
        AppMethodBeat.o(250982);
        return;
      }
      fpM();
      this.filePath = t(this.uri);
      if ((Util.isNullOrNil(this.filePath)) || (!ImgUtil.isImgFile(this.filePath)))
      {
        Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
        jDo();
        finish();
        AppMethodBeat.o(250982);
        return;
      }
      jDn();
      l.kK(3, 11);
      AppMethodBeat.o(250982);
      return;
    }
    Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
    jDo();
    finish();
    AppMethodBeat.o(250982);
  }
  
  private static int bCu(String paramString)
  {
    AppMethodBeat.i(39167);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
      AppMethodBeat.o(39167);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("image")) || ((Build.VERSION.SDK_INT >= 28) && (paramString.contains("heic"))))
    {
      AppMethodBeat.o(39167);
      return 0;
    }
    Log.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(39167);
    return 3;
  }
  
  private void fpM()
  {
    AppMethodBeat.i(250998);
    getString(R.l.app_tip);
    this.lzP = k.a(this, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(250998);
  }
  
  private void jDn()
  {
    AppMethodBeat.i(39166);
    Log.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[] { this.filePath });
    Object localObject = getIntent();
    int i = bCu(((Intent)localObject).resolveType(this));
    if (i == -1)
    {
      Log.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
      finish();
      AppMethodBeat.o(39166);
      return;
    }
    if ((!IntentUtil.getBooleanExtra(getIntent(), "Intro_Switch", false)) && (bh.bCA()) && (!bh.aZG()))
    {
      ((Intent)localObject).setData(this.uri);
      ((Intent)localObject).setClass(this, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", this.filePath);
      ((Intent)localObject).putExtra("Retr_Msg_Type", i);
      ((Intent)localObject).putExtra("Retr_Scene", 1);
      if ((this.filePath != null) && (Build.VERSION.SDK_INT >= 28) && (this.filePath.endsWith(".heic"))) {
        ((Intent)localObject).putExtra("Retr_Compress_Type", 1);
      }
      ((Intent)localObject).putExtra("Retr_start_where_you_are", false);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39166);
      return;
      if (!Util.isNullOrNil(this.filePath))
      {
        localObject = new Intent(this, ShareImgUI.class);
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new u(this.filePath)));
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).setType("image/*");
        ((Intent)localObject).setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), (Intent)localObject);
      }
      else
      {
        jDo();
      }
    }
  }
  
  private void jDo()
  {
    AppMethodBeat.i(39168);
    Toast.makeText(this, R.l.gWk, 1).show();
    AppMethodBeat.o(39168);
  }
  
  private String t(Uri paramUri)
  {
    AppMethodBeat.i(250989);
    this.filePath = Util.getFilePath(this, paramUri);
    if ((Util.isNullOrNil(this.filePath)) || (!new u(this.filePath).jKS()) || ((Build.VERSION.SDK_INT >= 30) && (!new u(this.filePath).jKQ()))) {
      this.filePath = e.a(getContentResolver(), paramUri, 1);
    }
    paramUri = this.filePath;
    AppMethodBeat.o(250989);
    return paramUri;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39165);
    this.intent = getIntent();
    if (this.intent == null)
    {
      Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
      jDo();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    Log.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
    String str1 = this.intent.getAction();
    this.uri = this.intent.getData();
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
      jDo();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    getString(R.l.permission_tips_title);
    String str2 = getString(R.l.gallery_permission_msg);
    boolean bool = b.a(this, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str2);
    Log.i("MicroMsg.ShareScreenImgUI", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      bCD(str1);
    }
    AppMethodBeat.o(39165);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39164);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(39164);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(39164);
      return;
    }
    NotifyReceiver.aKz();
    initView();
    AppMethodBeat.o(39164);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251028);
    if (paramArrayOfInt.length <= 0)
    {
      Log.i("MicroMsg.ShareScreenImgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(251028);
      return;
    }
    Log.i("MicroMsg.ShareScreenImgUI", "onRequestPermissionsResult requestCode[%d], grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251028);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        if (this.intent == null) {
          this.intent = getIntent();
        }
        if ((this.intent != null) && (this.intent.getAction() != null))
        {
          bCD(this.intent.getAction());
          AppMethodBeat.o(251028);
        }
      }
      else
      {
        k.a(this, getString(R.l.permission_gallery_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.gallery_cancel), false, new ShareScreenImgUI..ExternalSyntheticLambda0(this), new ShareScreenImgUI..ExternalSyntheticLambda1(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI
 * JD-Core Version:    0.7.0.1
 */