package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenImgUI
  extends MMActivity
{
  private ProgressDialog fMu;
  String filePath;
  private ap handler;
  private Intent intent;
  Uri uri;
  
  public ShareScreenImgUI()
  {
    AppMethodBeat.i(39163);
    this.fMu = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.handler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(39162);
        ShareScreenImgUI.a(ShareScreenImgUI.this);
        if (bt.isNullOrNil(ShareScreenImgUI.this.filePath))
        {
          ad.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
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
  
  private static int aXg(String paramString)
  {
    AppMethodBeat.i(39167);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
      AppMethodBeat.o(39167);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("image")) || ((Build.VERSION.SDK_INT >= 28) && (paramString.contains("heic"))))
    {
      AppMethodBeat.o(39167);
      return 0;
    }
    ad.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(39167);
    return 3;
  }
  
  private void fKI()
  {
    AppMethodBeat.i(39166);
    ad.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[] { this.filePath });
    Object localObject = getIntent();
    int i = aXg(((Intent)localObject).resolveType(this));
    if (i == -1)
    {
      ad.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
      finish();
      AppMethodBeat.o(39166);
      return;
    }
    if ((!y.getBooleanExtra(getIntent(), "Intro_Switch", false)) && (ba.aBR()) && (!ba.aiE()))
    {
      ((Intent)localObject).setData(this.uri);
      ((Intent)localObject).setClass(this, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", this.filePath);
      ((Intent)localObject).putExtra("Retr_Msg_Type", i);
      ((Intent)localObject).putExtra("Retr_Scene", 1);
      ((Intent)localObject).putExtra("Retr_start_where_you_are", false);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ShareScreenImgUI", "deal", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39166);
      return;
      if (!bt.isNullOrNil(this.filePath))
      {
        localObject = new Intent(this, ShareImgUI.class);
        ((Intent)localObject).putExtra("android.intent.extra.STREAM", n.a(getContext(), new com.tencent.mm.vfs.e(this.filePath)));
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).setType("image/*");
        ((Intent)localObject).setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), (Intent)localObject);
      }
      else
      {
        fKJ();
      }
    }
  }
  
  private void fKJ()
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
      ad.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
      fKJ();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    ad.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
    Object localObject = this.intent.getAction();
    this.uri = this.intent.getData();
    if (bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
      fKJ();
      finish();
      AppMethodBeat.o(39165);
      return;
    }
    if (((String)localObject).equals("android.intent.action.VIEW"))
    {
      ad.i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(localObject)));
      if ((this.uri == null) || (!bt.z(this.uri)))
      {
        ad.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
        fKJ();
        finish();
        AppMethodBeat.o(39165);
        return;
      }
      getString(2131755906);
      this.fMu = h.b(this, getString(2131755936), true, new ShareScreenImgUI.2(this));
      localObject = this.uri;
      this.filePath = bt.k(this, (Uri)localObject);
      if ((bt.isNullOrNil(this.filePath)) || (!new com.tencent.mm.vfs.e(this.filePath).exists())) {
        this.filePath = com.tencent.mm.pluginsdk.l.e.a(getContentResolver(), (Uri)localObject, 1);
      }
      this.filePath = this.filePath;
      if ((bt.isNullOrNil(this.filePath)) || (!t.aQi(this.filePath)))
      {
        ad.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
        fKJ();
        finish();
        AppMethodBeat.o(39165);
        return;
      }
      fKI();
      AppMethodBeat.o(39165);
      return;
    }
    ad.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
    fKJ();
    finish();
    AppMethodBeat.o(39165);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39164);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = y.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      ad.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(39164);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(39164);
      return;
    }
    NotifyReceiver.WJ();
    initView();
    AppMethodBeat.o(39164);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI
 * JD-Core Version:    0.7.0.1
 */