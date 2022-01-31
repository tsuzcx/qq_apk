package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.sdk.platformtools.ab;

final class TopStorySettingVisibilityDetailUI$5
  implements k.b
{
  TopStorySettingVisibilityDetailUI$5(TopStorySettingVisibilityDetailUI paramTopStorySettingVisibilityDetailUI) {}
  
  public final boolean iz(int paramInt)
  {
    AppMethodBeat.i(1639);
    if (!this.thh.eeU.LY(paramInt)) {
      ab.d("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onItemLongClick ".concat(String.valueOf(paramInt)));
    }
    AppMethodBeat.o(1639);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.5
 * JD-Core Version:    0.7.0.1
 */