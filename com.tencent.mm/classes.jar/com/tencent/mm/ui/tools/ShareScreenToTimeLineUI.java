package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.k;

@a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI
  extends MMActivity
{
  String filePath = null;
  Uri uri = null;
  
  private void fOD()
  {
    AppMethodBeat.i(39175);
    Toast.makeText(this, 2131763661, 1).show();
    AppMethodBeat.o(39175);
  }
  
  private void my(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39174);
    Intent localIntent = new Intent();
    if (!bu.isNullOrNil(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
    }
    if (!bu.isNullOrNil(paramString2)) {
      localIntent.putExtra("Kdescription", paramString2);
    }
    if ((bc.aCh()) && (!bc.aiT()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      d.b(this, "sns", ".ui.SnsUploadUI", localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39174);
      return;
      if (!bu.isNullOrNil(paramString1))
      {
        paramString2 = new Intent(this, ShareToTimeLineUI.class);
        paramString2.putExtra("android.intent.extra.STREAM", o.a(getContext(), new k(paramString1)));
        paramString2.addFlags(32768).addFlags(268435456);
        paramString2.setType("image/*");
        paramString2.setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), paramString2);
      }
      else
      {
        fOD();
      }
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39173);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      ae.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
      fOD();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    Object localObject = localIntent.getAction();
    this.uri = localIntent.getData();
    if (bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
      fOD();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    String str1 = z.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (bu.isNullOrNil(str2))
    {
      fOD();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      if ((!str2.contains("heic")) && (!str2.contains("image")))
      {
        fOD();
        finish();
        AppMethodBeat.o(39173);
      }
    }
    else if (!str2.contains("image"))
    {
      fOD();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    if (((String)localObject).equals("android.intent.action.VIEW"))
    {
      ae.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: ".concat(String.valueOf(localObject)));
      if (!bu.z(this.uri))
      {
        ae.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[] { this.uri });
        fOD();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      localObject = this.uri;
      this.filePath = bu.k(this, (Uri)localObject);
      if ((bu.isNullOrNil(this.filePath)) || (!new k(this.filePath).exists())) {
        this.filePath = com.tencent.mm.pluginsdk.l.e.a(getContentResolver(), (Uri)localObject, 1);
      }
      this.filePath = this.filePath;
      if ((bu.isNullOrNil(this.filePath)) || (!bu.aSP(this.filePath)))
      {
        if (z.getBooleanExtra(localIntent, "Ksnsupload_empty_img", false))
        {
          my(this.filePath, str1);
          AppMethodBeat.o(39173);
          return;
        }
        fOD();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      if (u.aRF(this.filePath))
      {
        my(this.filePath, str1);
        AppMethodBeat.o(39173);
        return;
      }
      fOD();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    ae.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
    fOD();
    finish();
    AppMethodBeat.o(39173);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39172);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = z.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      ae.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(39172);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(39172);
      return;
    }
    NotifyReceiver.WR();
    bc.ajj().a(new bq(new bq.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse) {}
    }), 0);
    initView();
    AppMethodBeat.o(39172);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */