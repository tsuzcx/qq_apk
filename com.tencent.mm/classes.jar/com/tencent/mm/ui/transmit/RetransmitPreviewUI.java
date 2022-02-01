package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.smiley.u;
import com.tencent.mm.ui.MMActivity;

public class RetransmitPreviewUI
  extends MMActivity
{
  private TextView sQ = null;
  private String text = null;
  
  public int getLayoutId()
  {
    return R.i.ggm;
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
    this.sQ = ((TextView)findViewById(R.h.fIW));
    this.sQ.setText(u.iVt().a(getContext(), this.text, this.sQ.getTextSize()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.RetransmitPreviewUI
 * JD-Core Version:    0.7.0.1
 */