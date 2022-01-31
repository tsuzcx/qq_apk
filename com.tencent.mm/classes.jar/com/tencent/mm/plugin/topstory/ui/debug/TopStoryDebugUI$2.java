package com.tencent.mm.plugin.topstory.ui.debug;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.vfs.e;

final class TopStoryDebugUI$2
  implements View.OnClickListener
{
  TopStoryDebugUI$2(TopStoryDebugUI paramTopStoryDebugUI, ap paramap) {}
  
  public final void onClick(View paramView)
  {
    paramView = String.format("currentConfigJSMD5: %s\ncurrentFileJSMD5: %s", new Object[] { this.pDP.bZQ(), e.aeY(String.format("%s/%s", new Object[] { this.pDP.aoA(), "dist/build.js" })) });
    TopStoryDebugUI.aK(this.pDO, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.2
 * JD-Core Version:    0.7.0.1
 */