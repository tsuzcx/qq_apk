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
  
  public final void Ji(int paramInt)
  {
    AppMethodBeat.i(26966);
    if (ContactInfoUI.a(this.uAr) != null) {
      ContactInfoUI.a(this.uAr).Oj(paramInt);
    }
    AppMethodBeat.o(26966);
  }
  
  public final void Jj(int paramInt)
  {
    AppMethodBeat.i(26967);
    if (ContactInfoUI.a(this.uAr) != null) {
      ContactInfoUI.a(this.uAr).Ok(paramInt);
    }
    AppMethodBeat.o(26967);
  }
  
  public final void Jk(int paramInt) {}
  
  public final void dcp()
  {
    AppMethodBeat.i(26962);
    if (ContactInfoUI.a(this.uAr) != null) {
      ContactInfoUI.a(this.uAr).dFR();
    }
    AppMethodBeat.o(26962);
  }
  
  public final void dcq()
  {
    AppMethodBeat.i(26963);
    if (ContactInfoUI.a(this.uAr) != null) {
      ContactInfoUI.a(this.uAr).dFS();
    }
    AppMethodBeat.o(26963);
  }
  
  public final void dcr()
  {
    AppMethodBeat.i(26964);
    ad.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
    ContactInfoUI.d(this.uAr).dFX();
    AppMethodBeat.o(26964);
  }
  
  public final void dcs()
  {
    AppMethodBeat.i(26965);
    ContactInfoUI.d(this.uAr).dFY();
    AppMethodBeat.o(26965);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(26961);
    if (ContactInfoUI.a(this.uAr) != null)
    {
      ad.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
      ContactInfoUI.a(this.uAr).qC(true);
      this.uAr.showTitleView();
      ContactInfoUI.c(this.uAr);
    }
    AppMethodBeat.o(26961);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(26960);
    if (ContactInfoUI.a(this.uAr) != null)
    {
      ad.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
      ContactInfoUI.a(this.uAr).ad(paramBoolean, true);
      this.uAr.hideTitleView();
      ContactInfoUI.b(this.uAr);
    }
    AppMethodBeat.o(26960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.1
 * JD-Core Version:    0.7.0.1
 */