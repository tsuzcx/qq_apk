package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;

final class ContactInfoUI$1
  implements PullDownListView.IPullDownCallback
{
  ContactInfoUI$1(ContactInfoUI paramContactInfoUI) {}
  
  public final void MJ(int paramInt)
  {
    AppMethodBeat.i(26966);
    if (ContactInfoUI.a(this.wQs) != null) {
      ContactInfoUI.a(this.wQs).RY(paramInt);
    }
    AppMethodBeat.o(26966);
  }
  
  public final void MK(int paramInt)
  {
    AppMethodBeat.i(26967);
    if (ContactInfoUI.a(this.wQs) != null) {
      ContactInfoUI.a(this.wQs).RZ(paramInt);
    }
    AppMethodBeat.o(26967);
  }
  
  public final void ML(int paramInt) {}
  
  public final void dAA()
  {
    AppMethodBeat.i(26962);
    if (ContactInfoUI.a(this.wQs) != null) {
      ContactInfoUI.a(this.wQs).egG();
    }
    AppMethodBeat.o(26962);
  }
  
  public final void dAB()
  {
    AppMethodBeat.i(26963);
    if (ContactInfoUI.a(this.wQs) != null) {
      ContactInfoUI.a(this.wQs).egH();
    }
    AppMethodBeat.o(26963);
  }
  
  public final void dAC()
  {
    AppMethodBeat.i(26964);
    ad.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
    ContactInfoUI.d(this.wQs).egM();
    AppMethodBeat.o(26964);
  }
  
  public final void dAD()
  {
    AppMethodBeat.i(26965);
    ContactInfoUI.d(this.wQs).egN();
    AppMethodBeat.o(26965);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(26961);
    if (ContactInfoUI.a(this.wQs) != null)
    {
      ad.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
      ContactInfoUI.a(this.wQs).sg(true);
      this.wQs.showTitleView();
      ContactInfoUI.c(this.wQs);
    }
    AppMethodBeat.o(26961);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(26960);
    if (ContactInfoUI.a(this.wQs) != null)
    {
      ad.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
      ContactInfoUI.a(this.wQs).ak(paramBoolean, true);
      this.wQs.hideTitleView();
      ContactInfoUI.b(this.wQs);
    }
    AppMethodBeat.o(26960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.1
 * JD-Core Version:    0.7.0.1
 */