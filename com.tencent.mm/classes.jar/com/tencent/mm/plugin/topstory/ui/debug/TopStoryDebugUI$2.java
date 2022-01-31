package com.tencent.mm.plugin.topstory.ui.debug;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.vfs.e;

final class TopStoryDebugUI$2
  implements View.OnClickListener
{
  TopStoryDebugUI$2(TopStoryDebugUI paramTopStoryDebugUI, ao paramao) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1549);
    paramView = String.format("currentConfigJSMD5: %s\ncurrentFileJSMD5: %s", new Object[] { this.tfW.cZL(), e.avP(String.format("%s/%s", new Object[] { this.tfW.aLw(), "dist/build.js" })) });
    TopStoryDebugUI.aU(this.tfV, paramView);
    AppMethodBeat.o(1549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.2
 * JD-Core Version:    0.7.0.1
 */