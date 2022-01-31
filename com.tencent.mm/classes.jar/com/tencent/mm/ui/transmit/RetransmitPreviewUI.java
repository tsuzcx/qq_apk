package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cd.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class RetransmitPreviewUI
  extends MMActivity
{
  private TextView lh = null;
  private String text = null;
  
  protected final int getLayoutId()
  {
    return R.i.chatting_item_full_screen;
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle("");
    this.text = getIntent().getStringExtra("Retr_Msg_content");
    this.lh = ((TextView)findViewById(R.h.full_screen_text));
    paramBundle = this.lh;
    g localg = g.csM();
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    paramBundle.setText(localg.a(this.text, this.lh.getTextSize()));
    setBackBtn(new RetransmitPreviewUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.RetransmitPreviewUI
 * JD-Core Version:    0.7.0.1
 */