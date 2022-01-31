package com.tencent.mm.plugin.topstory.ui.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.h;
import java.util.Iterator;
import java.util.Set;

final class TopStorySettingVisibilityDetailUI$7
  implements DialogInterface.OnCancelListener
{
  TopStorySettingVisibilityDetailUI$7(TopStorySettingVisibilityDetailUI paramTopStorySettingVisibilityDetailUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(1644);
    paramDialogInterface = TopStorySettingVisibilityDetailUI.d(this.thh).iterator();
    while (paramDialogInterface.hasNext())
    {
      h localh = (h)paramDialogInterface.next();
      g.RK().eHt.a(localh);
    }
    AppMethodBeat.o(1644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.7
 * JD-Core Version:    0.7.0.1
 */