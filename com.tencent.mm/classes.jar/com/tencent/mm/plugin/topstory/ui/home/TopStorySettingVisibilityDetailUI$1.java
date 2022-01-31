package com.tencent.mm.plugin.topstory.ui.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import java.util.Iterator;
import java.util.List;

final class TopStorySettingVisibilityDetailUI$1
  implements DialogInterface.OnClickListener
{
  TopStorySettingVisibilityDetailUI$1(TopStorySettingVisibilityDetailUI paramTopStorySettingVisibilityDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(1635);
    paramDialogInterface = this.thh.thf.iterator();
    while (paramDialogInterface.hasNext())
    {
      String str = (String)paramDialogInterface.next();
      this.thh.lbK.remove(str);
    }
    if (this.thh.eeU != null)
    {
      this.thh.eeU.cg(this.thh.lbK);
      this.thh.eeU.notifyChanged();
    }
    this.thh.thf.clear();
    TopStorySettingVisibilityDetailUI.a(this.thh);
    this.thh.updateTitle();
    AppMethodBeat.o(1635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStorySettingVisibilityDetailUI.1
 * JD-Core Version:    0.7.0.1
 */