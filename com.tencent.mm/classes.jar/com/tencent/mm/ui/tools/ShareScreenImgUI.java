package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.mm.R.l;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.File;

@a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenImgUI
  extends MMActivity
{
  private ProgressDialog dnm = null;
  String filePath = null;
  private ah handler = new ShareScreenImgUI.1(this);
  private Intent intent = null;
  Uri uri = null;
  
  private void cIO()
  {
    Toast.makeText(this, R.l.shareimg_get_res_fail, 1).show();
  }
  
  private void cJk()
  {
    y.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[] { this.filePath });
    Intent localIntent = getIntent();
    String str = localIntent.resolveType(this);
    int i;
    if ((str == null) || (str.length() == 0))
    {
      y.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
      i = -1;
    }
    while (i == -1)
    {
      y.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
      finish();
      return;
      str = str.toLowerCase();
      if ((str.contains("image")) || ((Build.VERSION.SDK_INT >= 28) && (str.contains("heic"))))
      {
        i = 0;
      }
      else
      {
        y.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
        i = 3;
      }
    }
    if ((!t.a(getIntent(), "Intro_Switch", false)) && (au.Hz()) && (!au.CW()))
    {
      localIntent.setData(this.uri);
      localIntent.setClass(this, MsgRetransmitUI.class);
      localIntent.putExtra("Retr_File_Name", this.filePath);
      localIntent.putExtra("Retr_Msg_Type", i);
      localIntent.putExtra("Retr_Scene", 1);
      localIntent.putExtra("Retr_start_where_you_are", false);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      finish();
      return;
      if (!bk.bl(this.filePath))
      {
        localIntent = new Intent(this, ShareImgUI.class);
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
        localIntent.addFlags(67108864);
        localIntent.setType("image/*");
        localIntent.setAction("android.intent.action.SEND");
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), localIntent);
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
    this.intent = getIntent();
    if (this.intent == null)
    {
      y.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
      cIO();
      finish();
      return;
    }
    y.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
    String str = this.intent.getAction();
    this.uri = this.intent.getData();
    if (bk.bl(str))
    {
      y.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
      cIO();
      finish();
      return;
    }
    if (str.equals("android.intent.action.VIEW"))
    {
      y.i("MicroMsg.ShareScreenImgUI", "send signal: " + str);
      if ((this.uri == null) || (!bk.m(this.uri)))
      {
        y.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
        cIO();
        finish();
        return;
      }
      getString(R.l.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new ShareScreenImgUI.2(this));
      this.filePath = bk.h(this, this.uri);
      if (!bk.bl(this.filePath))
      {
        str = this.filePath;
        MMBitmapFactory.DecodeResultLogger localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
        boolean bool = o.a(str, localDecodeResultLogger);
        if ((!bool) && (localDecodeResultLogger.getDecodeResult() >= 2000))
        {
          str = MMBitmapFactory.KVStatHelper.getKVStatString(str, 3, localDecodeResultLogger);
          com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, str);
        }
        if (bool) {}
      }
      else
      {
        y.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
        cIO();
        finish();
        return;
      }
      cJk();
      return;
    }
    y.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
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
      y.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = " + i);
      finish();
      return;
    case 1: 
      finish();
      return;
    }
    NotifyReceiver.vY();
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI
 * JD-Core Version:    0.7.0.1
 */