package com.tencent.mm.plugin.topstory.ui.debug;

import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.vfs.y;

public class TopStoryDebugUI
  extends MMActivity
{
  private TextView TJy;
  
  public int getLayoutId()
  {
    return c.e.top_story_debug_ui;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(125896);
    super.onCreate(paramBundle);
    setMMTitle(c.g.top_story_debug_title);
    setBackBtn(new ad()
    {
      public final void d(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(271673);
        TopStoryDebugUI.this.finish();
        AppMethodBeat.o(271673);
      }
    });
    paramBundle = aj.asW(1);
    this.TJy = ((TextView)findViewById(c.d.version_tv));
    this.TJy.setText(getString(c.g.top_story_debug_h5_verison, new Object[] { String.valueOf(paramBundle.bIG()) }));
    findViewById(c.d.clear_template_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125894);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        y.ew(paramBundle.iqp(), true);
        paramAnonymousView = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "onClick", "(Landroid/view/View;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramAnonymousView.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "onClick", "(Landroid/view/View;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125894);
      }
    });
    findViewById(c.d.print_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125895);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/topstory/ui/debug/TopStoryDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        try
        {
          paramAnonymousView = y.bEn(com.tencent.mm.loader.i.b.bmz() + "topstory/trace.info");
          TopStoryDebugUI.cc(TopStoryDebugUI.this, paramAnonymousView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI
 * JD-Core Version:    0.7.0.1
 */