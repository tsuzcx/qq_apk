package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.File;

@a(3)
@JgClassChecked(author=12, fComment="checked", lastDate="20141031", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class ShareScreenImgUI
  extends MMActivity
{
  private ProgressDialog eeN;
  String filePath;
  private ak handler;
  private Intent intent;
  Uri uri;
  
  public ShareScreenImgUI()
  {
    AppMethodBeat.i(34967);
    this.eeN = null;
    this.intent = null;
    this.filePath = null;
    this.uri = null;
    this.handler = new ShareScreenImgUI.1(this);
    AppMethodBeat.o(34967);
  }
  
  private static int auN(String paramString)
  {
    AppMethodBeat.i(34971);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
      AppMethodBeat.o(34971);
      return -1;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("image")) || ((Build.VERSION.SDK_INT >= 28) && (paramString.contains("heic"))))
    {
      AppMethodBeat.o(34971);
      return 0;
    }
    ab.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
    AppMethodBeat.o(34971);
    return 3;
  }
  
  private void dNZ()
  {
    AppMethodBeat.i(34970);
    ab.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", new Object[] { this.filePath });
    Intent localIntent = getIntent();
    int i = auN(localIntent.resolveType(this));
    if (i == -1)
    {
      ab.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
      finish();
      AppMethodBeat.o(34970);
      return;
    }
    if ((!w.a(getIntent(), "Intro_Switch", false)) && (aw.aaB()) && (!aw.QP()))
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
      AppMethodBeat.o(34970);
      return;
      if (!bo.isNullOrNil(this.filePath))
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
        dOa();
      }
    }
  }
  
  private void dOa()
  {
    AppMethodBeat.i(34972);
    Toast.makeText(this, 2131303677, 1).show();
    AppMethodBeat.o(34972);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34969);
    this.intent = getIntent();
    if (this.intent == null)
    {
      ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
      dOa();
      finish();
      AppMethodBeat.o(34969);
      return;
    }
    ab.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
    String str = this.intent.getAction();
    this.uri = this.intent.getData();
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
      dOa();
      finish();
      AppMethodBeat.o(34969);
      return;
    }
    if (str.equals("android.intent.action.VIEW"))
    {
      ab.i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(str)));
      if ((this.uri == null) || (!bo.o(this.uri)))
      {
        ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", new Object[] { this.uri });
        dOa();
        finish();
        AppMethodBeat.o(34969);
        return;
      }
      getString(2131297087);
      this.eeN = h.b(this, getString(2131297112), true, new ShareScreenImgUI.2(this));
      this.filePath = bo.h(this, this.uri);
      if ((bo.isNullOrNil(this.filePath)) || (!r.aoX(this.filePath)))
      {
        ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
        dOa();
        finish();
        AppMethodBeat.o(34969);
        return;
      }
      dNZ();
      AppMethodBeat.o(34969);
      return;
    }
    ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
    dOa();
    finish();
    AppMethodBeat.o(34969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34968);
    super.onCreate(paramBundle);
    setMMTitle("");
    int i = w.a(getIntent(), "wizard_activity_result_code", 0);
    switch (i)
    {
    default: 
      ab.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(i)));
      finish();
      AppMethodBeat.o(34968);
      return;
    case 1: 
      finish();
      AppMethodBeat.o(34968);
      return;
    }
    NotifyReceiver.In();
    initView();
    AppMethodBeat.o(34968);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShareScreenImgUI
 * JD-Core Version:    0.7.0.1
 */