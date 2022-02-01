package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;

final class ContactInfoUI$1
  implements PullDownListView.IPullDownCallback
{
  ContactInfoUI$1(ContactInfoUI paramContactInfoUI) {}
  
  public final void Lh(int paramInt)
  {
    AppMethodBeat.i(26966);
    if (ContactInfoUI.a(this.vJk) != null) {
      ContactInfoUI.a(this.vJk).Qp(paramInt);
    }
    AppMethodBeat.o(26966);
  }
  
  public final void Li(int paramInt)
  {
    AppMethodBeat.i(26967);
    if (ContactInfoUI.a(this.vJk) != null) {
      ContactInfoUI.a(this.vJk).Qq(paramInt);
    }
    AppMethodBeat.o(26967);
  }
  
  public final void Lj(int paramInt) {}
  
  public final void dpX()
  {
    AppMethodBeat.i(26962);
    if (ContactInfoUI.a(this.vJk) != null) {
      ContactInfoUI.a(this.vJk).dUs();
    }
    AppMethodBeat.o(26962);
  }
  
  public final void dpY()
  {
    AppMethodBeat.i(26963);
    if (ContactInfoUI.a(this.vJk) != null) {
      ContactInfoUI.a(this.vJk).dUt();
    }
    AppMethodBeat.o(26963);
  }
  
  public final void dpZ()
  {
    AppMethodBeat.i(26964);
    ac.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
    ContactInfoUI.d(this.vJk).dUy();
    AppMethodBeat.o(26964);
  }
  
  public final void dqa()
  {
    AppMethodBeat.i(26965);
    ContactInfoUI.d(this.vJk).dUz();
    AppMethodBeat.o(26965);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(26961);
    if (ContactInfoUI.a(this.vJk) != null)
    {
      ac.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
      ContactInfoUI.a(this.vJk).rA(true);
      this.vJk.showTitleView();
      ContactInfoUI.c(this.vJk);
    }
    AppMethodBeat.o(26961);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(26960);
    if (ContactInfoUI.a(this.vJk) != null)
    {
      ac.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
      ContactInfoUI.a(this.vJk).ag(paramBoolean, true);
      this.vJk.hideTitleView();
      ContactInfoUI.b(this.vJk);
    }
    AppMethodBeat.o(26960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.1
 * JD-Core Version:    0.7.0.1
 */