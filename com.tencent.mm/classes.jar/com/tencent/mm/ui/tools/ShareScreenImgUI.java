package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.o;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenImgUI
  extends MMActivity
{
  String filePath;
  private ProgressDialog gtM;
  private MMHandler handler;
  private Intent intent;
  Uri uri;
  
  public ShareScreenImgUI()
  {
    AppMethodBeat.i(39163);
    this.gtM = null;
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
  
  private static int bnM(String paramString)
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
  
  private void gXT()
  {
    AppMethodBeat.i(39166);
    Log.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[] { this.filePath });
    Object localObject = getIntent();
    int i = bnM(((Intent)localObject).resolveType(this));
    if (i == -1)
    {
      Log.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
      finish();
      AppMethodBeat.o(39166);
      return;
    }
    if ((!IntentUtil.getBooleanExtra(getIntent(), "Intro_Switch", false)) && (bg.aVG()) && (!bg.azj()))
    {
      ((Intent)localObject).setData(this.uri);
      ((Intent)localObject).setClass(this, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", this.filePath);
      ((Intent)localObject).putExtra("Retr_Msg_Type", i);
      ((Intent)localObject).putExtra("Retr_Scene", 1);
      ((Intent)localObject).putExtra("Retr_start_where_you_are", false);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39166);
      return;
      if (!Util.isNullOrNil(this.filePath))
      {
        localObject = new Intent(this, ShareImgUI.class);
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new o(this.filePath)));
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).setType("image/*");
        ((Intent)localObject).setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), (Intent)localObject);
      }
      else
      {
        gXU();
      }
    }
  }
  
  private void gXU()
  {
    AppMethodBeat.i(39168);
    Toast.makeText(this, 2131765848, 1).show();
    AppMethodBeat.o(39168);
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
      gXU();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    Log.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
    Object localObject = this.intent.getAction();
    this.uri = this.intent.getData();
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
      gXU();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    if (((String)localObject).equals("android.intent.action.VIEW"))
    {
      Log.i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(localObject)));
      if ((this.uri == null) || (!Util.isUriSafeToBeCopySrc(this.uri)))
      {
        Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
        gXU();
        finish();
        AppMethodBeat.o(39165);
        return;
      }
      getString(2131755998);
      this.gtM = h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      localObject = this.uri;
      this.filePath = Util.getFilePath(this, (Uri)localObject);
      if ((Util.isNullOrNil(this.filePath)) || (!new o(this.filePath).exists()) || ((Build.VERSION.SDK_INT >= 30) && (!new o(this.filePath).canRead()))) {
        this.filePath = e.a(getContentResolver(), (Uri)localObject, 1);
      }
      this.filePath = this.filePath;
      if ((Util.isNullOrNil(this.filePath)) || (!ImgUtil.isImgFile(this.filePath)))
      {
        Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
        gXU();
        finish();
        AppMethodBeat.o(39165);
        return;
      }
      gXT();
      AppMethodBeat.o(39165);
      return;
    }
    Log.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
    gXU();
    finish();
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
    NotifyReceiver.akF();
    initView();
    AppMethodBeat.o(39164);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI
 * JD-Core Version:    0.7.0.1
 */