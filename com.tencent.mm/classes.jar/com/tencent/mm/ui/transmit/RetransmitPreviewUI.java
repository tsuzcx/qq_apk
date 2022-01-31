package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.ui.MMActivity;

public class RetransmitPreviewUI
  extends MMActivity
{
  private TextView md = null;
  private String text = null;
  
  public int getLayoutId()
  {
    return 2130969092;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(35122);
    finish();
    AppMethodBeat.o(35122);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35121);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.text = getIntent().getStringExtra("Retr_Msg_content");
    this.md = ((TextView)findViewById(2131822701));
    paramBundle = this.md;
    g localg = g.dvk();
    getContext();
    paramBundle.setText(localg.b(this.text, this.md.getTextSize()));
    setBackBtn(new RetransmitPreviewUI.1(this));
    AppMethodBeat.o(35121);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35123);
    super.onDestroy();
    AppMethodBeat.o(35123);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.RetransmitPreviewUI
 * JD-Core Version:    0.7.0.1
 */