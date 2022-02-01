package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;

final class ContactInfoUI$1
  implements PullDownListView.IPullDownCallback
{
  ContactInfoUI$1(ContactInfoUI paramContactInfoUI) {}
  
  public final void Np(int paramInt)
  {
    AppMethodBeat.i(26966);
    if (ContactInfoUI.a(this.xgj) != null) {
      ContactInfoUI.a(this.xgj).SF(paramInt);
    }
    AppMethodBeat.o(26966);
  }
  
  public final void Nq(int paramInt)
  {
    AppMethodBeat.i(26967);
    if (ContactInfoUI.a(this.xgj) != null) {
      ContactInfoUI.a(this.xgj).SG(paramInt);
    }
    AppMethodBeat.o(26967);
  }
  
  public final void Nr(int paramInt) {}
  
  public final void dDR()
  {
    AppMethodBeat.i(26962);
    if (ContactInfoUI.a(this.xgj) != null) {
      ContactInfoUI.a(this.xgj).eko();
    }
    AppMethodBeat.o(26962);
  }
  
  public final void dDS()
  {
    AppMethodBeat.i(26963);
    if (ContactInfoUI.a(this.xgj) != null) {
      ContactInfoUI.a(this.xgj).ekp();
    }
    AppMethodBeat.o(26963);
  }
  
  public final void dDT()
  {
    AppMethodBeat.i(26964);
    ae.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
    ContactInfoUI.d(this.xgj).eku();
    AppMethodBeat.o(26964);
  }
  
  public final void dDU()
  {
    AppMethodBeat.i(26965);
    ContactInfoUI.d(this.xgj).ekv();
    AppMethodBeat.o(26965);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(26961);
    if (ContactInfoUI.a(this.xgj) != null)
    {
      ae.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
      ContactInfoUI.a(this.xgj).sn(true);
      this.xgj.showTitleView();
      ContactInfoUI.c(this.xgj);
    }
    AppMethodBeat.o(26961);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(26960);
    if (ContactInfoUI.a(this.xgj) != null)
    {
      ae.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
      ContactInfoUI.a(this.xgj).aj(paramBoolean, true);
      this.xgj.hideTitleView();
      ContactInfoUI.b(this.xgj);
    }
    AppMethodBeat.o(26960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.1
 * JD-Core Version:    0.7.0.1
 */