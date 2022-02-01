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
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI
  extends MMActivity
{
  String filePath = null;
  Uri uri = null;
  
  private void fty()
  {
    AppMethodBeat.i(39175);
    Toast.makeText(this, 2131763661, 1).show();
    AppMethodBeat.o(39175);
  }
  
  private void lS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39174);
    Intent localIntent = new Intent();
    if (!bs.isNullOrNil(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
    }
    if (!bs.isNullOrNil(paramString2)) {
      localIntent.putExtra("Kdescription", paramString2);
    }
    if ((az.ayN()) && (!az.afS()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      d.b(this, "sns", ".ui.SnsUploadUI", localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39174);
      return;
      if (!bs.isNullOrNil(paramString1))
      {
        paramString2 = new Intent(this, ShareToTimeLineUI.class);
        paramString2.putExtra("android.intent.extra.STREAM", m.a(getContext(), new com.tencent.mm.vfs.e(paramString1)));
        paramString2.addFlags(32768).addFlags(268435456);
        paramString2.setType("image/*");
        paramString2.setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), paramString2);
      }
      else
      {
        fty();
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
      ac.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
      fty();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    Object localObject = localIntent.getAction();
    this.uri = localIntent.getData();
    if (bs.isNullOrNil((String)localObject))
    {
      ac.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
      fty();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    String str1 = x.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (bs.isNullOrNil(str2))
    {
      fty();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      if ((!str2.contains("heic")) && (!str2.contains("image")))
      {
        fty();
        finish();
        AppMethodBeat.o(39173);
      }
    }
    else if (!str2.contains("image"))
    {
      fty();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    if (((String)localObject).equals("android.intent.action.VIEW"))
    {
      ac.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: ".concat(String.valueOf(localObject)));
      if (!bs.z(this.uri))
      {
        ac.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[] { this.uri });
        fty();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      localObject = this.uri;
      this.filePath = bs.j(this, (Uri)localObject);
      if ((bs.isNullOrNil(this.filePath)) || (!new com.tencent.mm.vfs.e(this.filePath).exists())) {
        this.filePath = com.tencent.mm.pluginsdk.j.e.a(getContentResolver(), (Uri)localObject, 1);
      }
      this.filePath = this.filePath;
      if ((bs.isNullOrNil(this.filePath)) || (!bs.aLL(this.filePath)))
      {
        if (x.getBooleanExtra(localIntent, "Ksnsupload_empty_img", false))
        {
          lS(this.filePath, str1);
          AppMethodBeat.o(39173);
          return;
        }
        fty();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      if (s.aKC(this.filePath))
      {
        lS(this.filePath, str1);
        AppMethodBeat.o(39173);
        return;
      }
      fty();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    ac.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
    fty();
    finish();
    AppMethodBeat.o(39173);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39172);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = x.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      ac.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(39172);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(39172);
      return;
    }
    NotifyReceiver.Us();
    az.agi().a(new bn(new bn.a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */