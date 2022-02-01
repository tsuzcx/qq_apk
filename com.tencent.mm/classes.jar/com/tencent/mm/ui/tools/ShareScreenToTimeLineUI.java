package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.u;

@a(3)
public class ShareScreenToTimeLineUI
  extends MMActivity
{
  String filePath = null;
  Uri uri = null;
  
  private void jCS()
  {
    AppMethodBeat.i(39175);
    Toast.makeText(this, R.l.gWm, 1).show();
    AppMethodBeat.o(39175);
  }
  
  private void qe(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39174);
    Intent localIntent = new Intent();
    if (!Util.isNullOrNil(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
    }
    if (!Util.isNullOrNil(paramString2)) {
      localIntent.putExtra("Kdescription", paramString2);
    }
    if ((bh.bCA()) && (!bh.aZG()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      c.b(this, "sns", ".ui.SnsUploadUI", localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(39174);
      return;
      if (!Util.isNullOrNil(paramString1))
      {
        paramString2 = new Intent(this, ShareToTimeLineUI.class);
        paramString2.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new u(paramString1)));
        paramString2.addFlags(32768).addFlags(268435456);
        paramString2.setType("image/*");
        paramString2.setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), paramString2);
      }
      else
      {
        jCS();
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
      Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
      jCS();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    Object localObject = localIntent.getAction();
    this.uri = localIntent.getData();
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
      jCS();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    String str1 = IntentUtil.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (Util.isNullOrNil(str2))
    {
      jCS();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      if ((!str2.contains("heic")) && (!str2.contains("image")))
      {
        jCS();
        finish();
        AppMethodBeat.o(39173);
      }
    }
    else if (!str2.contains("image"))
    {
      jCS();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    if (((String)localObject).equals("android.intent.action.VIEW"))
    {
      Log.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: ".concat(String.valueOf(localObject)));
      if (!Util.isUriSafeToBeCopySrc(this.uri))
      {
        Log.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[] { this.uri });
        jCS();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      localObject = this.uri;
      this.filePath = Util.getFilePath(this, (Uri)localObject);
      if ((Util.isNullOrNil(this.filePath)) || (!new u(this.filePath).jKS())) {
        this.filePath = e.a(getContentResolver(), (Uri)localObject, 1);
      }
      this.filePath = this.filePath;
      if ((Util.isNullOrNil(this.filePath)) || (!new u(this.filePath).jKS()) || ((Build.VERSION.SDK_INT >= 30) && (!new u(this.filePath).jKQ()))) {
        this.filePath = e.a(getContentResolver(), this.uri, 2);
      }
      if ((Util.isNullOrNil(this.filePath)) || (!Util.isImageFilename(this.filePath)))
      {
        if (IntentUtil.getBooleanExtra(localIntent, "Ksnsupload_empty_img", false))
        {
          qe(this.filePath, str1);
          AppMethodBeat.o(39173);
          return;
        }
        jCS();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      if (ImgUtil.isImgFile(this.filePath))
      {
        qe(this.filePath, str1);
        AppMethodBeat.o(39173);
        return;
      }
      jCS();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
    jCS();
    finish();
    AppMethodBeat.o(39173);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39172);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = IntentUtil.getIntExtra(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(39172);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(39172);
      return;
    }
    NotifyReceiver.aKz();
    bh.aZW().a(new bw(new bw.a()
    {
      public final void b(g paramAnonymousg) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */