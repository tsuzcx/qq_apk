package com.tencent.mm.plugin.topstory.ui.debug;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import com.tencent.mm.vfs.i;

public class TopStoryDebugUI
  extends MMActivity
{
  private TextView yMB;
  
  public int getLayoutId()
  {
    return 2131495770;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(125896);
    super.onCreate(paramBundle);
    setMMTitle(2131764464);
    setBackBtn(new w()
    {
      public final void VR()
      {
        AppMethodBeat.i(125893);
        TopStoryDebugUI.this.finish();
        AppMethodBeat.o(125893);
      }
    });
    paramBundle = aa.RZ(1);
    this.yMB = ((TextView)findViewById(2131306292));
    this.yMB.setText(getString(2131764462, new Object[] { String.valueOf(paramBundle.axp()) }));
    findViewById(2131298350).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125894);
        i.cO(paramBundle.eil(), true);
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(125894);
      }
    });
    findViewById(2131303406).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125895);
        try
        {
          paramAnonymousView = i.aMP(b.aih() + "topstory/trace.info");
          TopStoryDebugUI.bh(TopStoryDebugUI.this, paramAnonymousView);
          AppMethodBeat.o(125895);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          AppMethodBeat.o(125895);
        }
      }
    });
    AppMethodBeat.o(125896);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI
 * JD-Core Version:    0.7.0.1
 */