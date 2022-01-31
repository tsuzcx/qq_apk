package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public class SnsLongMsgUI
  extends MMActivity
{
  private Button oFR;
  
  protected final int getLayoutId()
  {
    return i.g.long_msg_ui;
  }
  
  @TargetApi(17)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitleVisibility(8);
    this.oFR = ((Button)findViewById(i.f.know_btn));
    this.oFR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsLongMsgUI.this, SnsUploadUI.class);
        paramAnonymousView.putExtra("KSnsPostManu", true);
        paramAnonymousView.putExtra("KTouchCameraTime", bk.UX());
        paramAnonymousView.putExtra("sns_comment_type", 1);
        paramAnonymousView.putExtra("Ksnsupload_type", 9);
        SnsLongMsgUI.this.startActivity(paramAnonymousView);
        SnsLongMsgUI.this.finish();
      }
    });
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      paramKeyEvent = new Intent();
      paramKeyEvent.setClass(this, SnsUploadUI.class);
      paramKeyEvent.putExtra("KSnsPostManu", true);
      paramKeyEvent.putExtra("KTouchCameraTime", bk.UX());
      paramKeyEvent.putExtra("sns_comment_type", 1);
      paramKeyEvent.putExtra("Ksnsupload_type", 9);
      startActivity(paramKeyEvent);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsLongMsgUI
 * JD-Core Version:    0.7.0.1
 */