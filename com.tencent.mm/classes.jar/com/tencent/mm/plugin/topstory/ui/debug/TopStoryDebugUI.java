package com.tencent.mm.plugin.topstory.ui.debug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.ui.MMActivity;

public class TopStoryDebugUI
  extends MMActivity
{
  private TextView tfU;
  
  public int getLayoutId()
  {
    return 2130971006;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1552);
    super.onCreate(paramBundle);
    setMMTitle(2131304328);
    setBackBtn(new TopStoryDebugUI.1(this));
    paramBundle = aa.Ja(1);
    this.tfU = ((TextView)findViewById(2131828508));
    this.tfU.setText(getString(2131304326, new Object[] { String.valueOf(paramBundle.agn()) }));
    findViewById(2131828509).setOnClickListener(new TopStoryDebugUI.2(this, paramBundle));
    findViewById(2131828510).setOnClickListener(new TopStoryDebugUI.3(this, paramBundle));
    findViewById(2131828511).setOnClickListener(new TopStoryDebugUI.4(this));
    AppMethodBeat.o(1552);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI
 * JD-Core Version:    0.7.0.1
 */