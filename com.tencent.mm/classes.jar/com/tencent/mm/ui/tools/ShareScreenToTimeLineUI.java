package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.h;
import java.io.File;

@a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI
  extends MMActivity
{
  String filePath = null;
  Uri uri = null;
  
  private void cIO()
  {
    Toast.makeText(this, R.l.shareimg_to_timeline_get_res_fail, 1).show();
  }
  
  private void gz(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (!bk.bl(paramString1))
    {
      localIntent.putExtra("sns_kemdia_path", paramString1);
      localIntent.putExtra("KFilterId", -1);
    }
    if (!bk.bl(paramString2)) {
      localIntent.putExtra(e.h.uHV, paramString2);
    }
    if ((au.Hz()) && (!au.CW()))
    {
      localIntent.putExtra("K_go_to_SnsTimeLineUI", true);
      d.b(this, "sns", ".ui.SnsUploadUI", localIntent);
    }
    for (;;)
    {
      finish();
      return;
      if (!bk.bl(paramString1))
      {
        paramString2 = new Intent(this, ShareToTimeLineUI.class);
        paramString2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString1)));
        paramString2.addFlags(32768).addFlags(268435456);
        paramString2.setType("image/*");
        paramString2.setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), paramString2);
      }
      else
      {
        cIO();
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initView()
  {
    Object localObject1 = getIntent();
    if (localObject1 == null)
    {
      y.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
      cIO();
      finish();
      return;
    }
    Object localObject2 = ((Intent)localObject1).getAction();
    this.uri = ((Intent)localObject1).getData();
    if (bk.bl((String)localObject2))
    {
      y.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
      cIO();
      finish();
      return;
    }
    String str1 = t.j((Intent)localObject1, e.h.uHV);
    String str2 = getIntent().resolveType(this);
    if (bk.bl(str2))
    {
      cIO();
      finish();
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      if ((!str2.contains("heic")) && (!str2.contains("image")))
      {
        cIO();
        finish();
      }
    }
    else if (!str2.contains("image"))
    {
      cIO();
      finish();
      return;
    }
    if (((String)localObject2).equals("android.intent.action.VIEW"))
    {
      y.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: " + (String)localObject2);
      if (!bk.m(this.uri))
      {
        y.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[] { this.uri });
        cIO();
        finish();
        return;
      }
      this.filePath = bk.h(this, this.uri);
      if ((bk.bl(this.filePath)) || (!bk.aae(this.filePath)))
      {
        if (t.a((Intent)localObject1, "Ksnsupload_empty_img", false))
        {
          gz(this.filePath, str1);
          return;
        }
        cIO();
        finish();
        return;
      }
      localObject1 = this.filePath;
      localObject2 = new MMBitmapFactory.DecodeResultLogger();
      boolean bool = o.a((String)localObject1, (MMBitmapFactory.DecodeResultLogger)localObject2);
      if ((!bool) && (((MMBitmapFactory.DecodeResultLogger)localObject2).getDecodeResult() >= 2000))
      {
        localObject1 = MMBitmapFactory.KVStatHelper.getKVStatString(localObject1, 4, (MMBitmapFactory.DecodeResultLogger)localObject2);
        h.nFQ.aC(12712, (String)localObject1);
      }
      if (bool)
      {
        gz(this.filePath, str1);
        return;
      }
      cIO();
      finish();
      return;
    }
    y.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
    cIO();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = t.a(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      y.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = " + i);
      finish();
      return;
    case 1: 
      finish();
      return;
    }
    NotifyReceiver.vY();
    au.Dk().a(new bi(new ShareScreenToTimeLineUI.1(this)), 0);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenToTimeLineUI
 * JD-Core Version:    0.7.0.1
 */