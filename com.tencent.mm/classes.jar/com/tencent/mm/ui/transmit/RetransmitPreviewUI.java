package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.g;
import com.tencent.mm.ui.MMActivity;

public class RetransmitPreviewUI
  extends MMActivity
{
  private TextView Wf = null;
  private String text = null;
  
  public int getLayoutId()
  {
    return 2131493465;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39321);
    finish();
    AppMethodBeat.o(39321);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39320);
    super.onCreate(paramBundle);
    setMMTitle("");
    this.text = getIntent().getStringExtra("Retr_Msg_content");
    this.Wf = ((TextView)findViewById(2131300329));
    paramBundle = this.Wf;
    g localg = g.fqZ();
    getContext();
    paramBundle.setText(localg.b(this.text, this.Wf.getTextSize()));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39319);
        RetransmitPreviewUI.this.finish();
        AppMethodBeat.o(39319);
        return true;
      }
    });
    AppMethodBeat.o(39320);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39322);
    super.onDestroy();
    AppMethodBeat.o(39322);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.RetransmitPreviewUI
 * JD-Core Version:    0.7.0.1
 */