package com.tencent.mm.plugin.topstory.ui.debug;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.x;
import com.tencent.mm.vfs.i;

public class TopStoryDebugUI
  extends MMActivity
{
  private TextView Bse;
  
  public int getLayoutId()
  {
    return 2131495770;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(125896);
    super.onCreate(paramBundle);
    setMMTitle(2131764464);
    setBackBtn(new x()
    {
      public final void Zi()
      {
        AppMethodBeat.i(125893);
        TopStoryDebugUI.this.finish();
        AppMethodBeat.o(125893);
      }
    });
    paramBundle = ad.Wc(1);
    this.Bse = ((TextView)findViewById(2131306292));
    this.Bse.setText(getString(2131764462, new Object[] { String.valueOf(paramBundle.aHm()) }));
    findViewById(2131298350).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125894);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        i.cZ(paramBundle.eMw(), true);
        paramAnonymousView = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "onClick", "(Landroid/view/View;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramAnonymousView.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "onClick", "(Landroid/view/View;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125894);
      }
    });
    findViewById(2131303406).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125895);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        try
        {
          paramAnonymousView = i.aYq(com.tencent.mm.loader.j.b.arU() + "topstory/trace.info");
          TopStoryDebugUI.bl(TopStoryDebugUI.this, paramAnonymousView);
          label67:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(125895);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          break label67;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI
 * JD-Core Version:    0.7.0.1
 */