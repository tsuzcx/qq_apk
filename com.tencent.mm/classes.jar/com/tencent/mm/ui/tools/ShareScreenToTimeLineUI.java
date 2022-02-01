package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.by.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.m.e;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.q;

@a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI
  extends MMActivity
{
  String filePath = null;
  Uri uri = null;
  
  private void hYi()
  {
    AppMethodBeat.i(39175);
    Toast.makeText(this, R.l.eTv, 1).show();
    AppMethodBeat.o(39175);
  }
  
  private void og(String paramString1, String paramString2)
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
    if ((bh.beJ()) && (!bh.aGE()))
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
        paramString2.putExtra("android.intent.extra.STREAM", FileProviderHelper.getUriForFile(getContext(), new q(paramString1)));
        paramString2.addFlags(32768).addFlags(268435456);
        paramString2.setType("image/*");
        paramString2.setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), paramString2);
      }
      else
      {
        hYi();
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
      hYi();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    Object localObject = localIntent.getAction();
    this.uri = localIntent.getData();
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
      hYi();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    String str1 = IntentUtil.getStringExtra(localIntent, "Kdescription");
    String str2 = getIntent().resolveType(this);
    if (Util.isNullOrNil(str2))
    {
      hYi();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      if ((!str2.contains("heic")) && (!str2.contains("image")))
      {
        hYi();
        finish();
        AppMethodBeat.o(39173);
      }
    }
    else if (!str2.contains("image"))
    {
      hYi();
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
        hYi();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      localObject = this.uri;
      this.filePath = Util.getFilePath(this, (Uri)localObject);
      if ((Util.isNullOrNil(this.filePath)) || (!new q(this.filePath).ifE())) {
        this.filePath = e.a(getContentResolver(), (Uri)localObject, 1);
      }
      this.filePath = this.filePath;
      if ((Util.isNullOrNil(this.filePath)) || (!new q(this.filePath).ifE()) || ((Build.VERSION.SDK_INT >= 30) && (!new q(this.filePath).ifC()))) {
        this.filePath = e.a(getContentResolver(), this.uri, 2);
      }
      if ((Util.isNullOrNil(this.filePath)) || (!Util.isImageFilename(this.filePath)))
      {
        if (IntentUtil.getBooleanExtra(localIntent, "Ksnsupload_empty_img", false))
        {
          og(this.filePath, str1);
          AppMethodBeat.o(39173);
          return;
        }
        hYi();
        finish();
        AppMethodBeat.o(39173);
        return;
      }
      if (ImgUtil.isImgFile(this.filePath))
      {
        og(this.filePath, str1);
        AppMethodBeat.o(39173);
        return;
      }
      hYi();
      finish();
      AppMethodBeat.o(39173);
      return;
    }
    Log.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
    hYi();
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
    NotifyReceiver.aqB();
    bh.aGY().a(new bv(new bv.a()
    {
      public final void a(g paramAnonymousg) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */