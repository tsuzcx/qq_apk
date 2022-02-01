package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;

final class ContactInfoUI$1
  implements PullDownListView.IPullDownCallback
{
  ContactInfoUI$1(ContactInfoUI paramContactInfoUI) {}
  
  public final void UC(int paramInt)
  {
    AppMethodBeat.i(26966);
    if (ContactInfoUI.a(this.BdV) != null) {
      ContactInfoUI.a(this.BdV).aaB(paramInt);
    }
    AppMethodBeat.o(26966);
  }
  
  public final void UD(int paramInt)
  {
    AppMethodBeat.i(26967);
    if (ContactInfoUI.a(this.BdV) != null) {
      ContactInfoUI.a(this.BdV).aaC(paramInt);
    }
    AppMethodBeat.o(26967);
  }
  
  public final void UE(int paramInt) {}
  
  public final void eEk()
  {
    AppMethodBeat.i(26962);
    if (ContactInfoUI.a(this.BdV) != null) {
      ContactInfoUI.a(this.BdV).fmO();
    }
    AppMethodBeat.o(26962);
  }
  
  public final void eEl()
  {
    AppMethodBeat.i(26963);
    if (ContactInfoUI.a(this.BdV) != null) {
      ContactInfoUI.a(this.BdV).fmP();
    }
    AppMethodBeat.o(26963);
  }
  
  public final void eEm()
  {
    AppMethodBeat.i(26964);
    Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
    ContactInfoUI.d(this.BdV).fmV();
    AppMethodBeat.o(26964);
  }
  
  public final void eEn()
  {
    AppMethodBeat.i(26965);
    ContactInfoUI.d(this.BdV).fmW();
    AppMethodBeat.o(26965);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(26961);
    if (ContactInfoUI.a(this.BdV) != null)
    {
      Log.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
      ContactInfoUI.a(this.BdV).vI(true);
      this.BdV.showTitleView();
      ContactInfoUI.c(this.BdV);
    }
    AppMethodBeat.o(26961);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(26960);
    if (ContactInfoUI.a(this.BdV) != null)
    {
      Log.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
      ContactInfoUI.a(this.BdV).ar(paramBoolean, true);
      this.BdV.hideTitleView();
      ContactInfoUI.b(this.BdV);
    }
    AppMethodBeat.o(26960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.1
 * JD-Core Version:    0.7.0.1
 */