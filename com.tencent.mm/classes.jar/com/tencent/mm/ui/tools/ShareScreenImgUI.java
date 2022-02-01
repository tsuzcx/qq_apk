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
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.k;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenImgUI
  extends MMActivity
{
  private ProgressDialog fOC;
  String filePath;
  private aq handler;
  private Intent intent;
  Uri uri;
  
  public ShareScreenImgUI()
  {
    AppMethodBeat.i(39163);
    this.fOC = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.handler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(39162);
        ShareScreenImgUI.a(ShareScreenImgUI.this);
        if (bu.isNullOrNil(ShareScreenImgUI.this.filePath))
        {
          ae.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
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
  
  private static int aYH(String paramString)
  {
    AppMethodBeat.i(39167);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
      AppMethodBeat.o(39167);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("image")) || ((Build.VERSION.SDK_INT >= 28) && (paramString.contains("heic"))))
    {
      AppMethodBeat.o(39167);
      return 0;
    }
    ae.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(39167);
    return 3;
  }
  
  private void fOZ()
  {
    AppMethodBeat.i(39166);
    ae.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[] { this.filePath });
    Object localObject = getIntent();
    int i = aYH(((Intent)localObject).resolveType(this));
    if (i == -1)
    {
      ae.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
      finish();
      AppMethodBeat.o(39166);
      return;
    }
    if ((!z.getBooleanExtra(getIntent(), "Intro_Switch", false)) && (bc.aCh()) && (!bc.aiT()))
    {
      ((Intent)localObject).setData(this.uri);
      ((Intent)localObject).setClass(this, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", this.filePath);
      ((Intent)localObject).putExtra("Retr_Msg_Type", i);
      ((Intent)localObject).putExtra("Retr_Scene", 1);
      ((Intent)localObject).putExtra("Retr_start_where_you_are", false);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39166);
      return;
      if (!bu.isNullOrNil(this.filePath))
      {
        localObject = new Intent(this, ShareImgUI.class);
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", o.a(getContext(), new k(this.filePath)));
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).setType("image/*");
        ((Intent)localObject).setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), (Intent)localObject);
      }
      else
      {
        fPa();
      }
    }
  }
  
  private void fPa()
  {
    AppMethodBeat.i(39168);
    Toast.makeText(this, 2131763659, 1).show();
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
      ae.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
      fPa();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    ae.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
    Object localObject = this.intent.getAction();
    this.uri = this.intent.getData();
    if (bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
      fPa();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    if (((String)localObject).equals("android.intent.action.VIEW"))
    {
      ae.i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(localObject)));
      if ((this.uri == null) || (!bu.z(this.uri)))
      {
        ae.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
        fPa();
        finish();
        AppMethodBeat.o(39165);
        return;
      }
      getString(2131755906);
      this.fOC = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      localObject = this.uri;
      this.filePath = bu.k(this, (Uri)localObject);
      if ((bu.isNullOrNil(this.filePath)) || (!new k(this.filePath).exists())) {
        this.filePath = e.a(getContentResolver(), (Uri)localObject, 1);
      }
      this.filePath = this.filePath;
      if ((bu.isNullOrNil(this.filePath)) || (!u.aRF(this.filePath)))
      {
        ae.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
        fPa();
        finish();
        AppMethodBeat.o(39165);
        return;
      }
      fOZ();
      AppMethodBeat.o(39165);
      return;
    }
    ae.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
    fPa();
    finish();
    AppMethodBeat.o(39165);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39164);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = z.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      ae.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(39164);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(39164);
      return;
    }
    NotifyReceiver.WR();
    initView();
    AppMethodBeat.o(39164);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI
 * JD-Core Version:    0.7.0.1
 */