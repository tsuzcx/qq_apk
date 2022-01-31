package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;

final class ContactInfoUI$1
  implements PullDownListView.IPullDownCallback
{
  ContactInfoUI$1(ContactInfoUI paramContactInfoUI) {}
  
  public final void Bv(int paramInt)
  {
    AppMethodBeat.i(23346);
    if (ContactInfoUI.a(this.pyI) != null) {
      ContactInfoUI.a(this.pyI).Fy(paramInt);
    }
    AppMethodBeat.o(23346);
  }
  
  public final void Bw(int paramInt)
  {
    AppMethodBeat.i(23347);
    if (ContactInfoUI.a(this.pyI) != null) {
      ContactInfoUI.a(this.pyI).Fz(paramInt);
    }
    AppMethodBeat.o(23347);
  }
  
  public final void Bx(int paramInt) {}
  
  public final void cbY()
  {
    AppMethodBeat.i(23342);
    if (ContactInfoUI.a(this.pyI) != null) {
      ContactInfoUI.a(this.pyI).czg();
    }
    AppMethodBeat.o(23342);
  }
  
  public final void cbZ()
  {
    AppMethodBeat.i(23343);
    if (ContactInfoUI.a(this.pyI) != null) {
      ContactInfoUI.a(this.pyI).czh();
    }
    AppMethodBeat.o(23343);
  }
  
  public final void cca()
  {
    AppMethodBeat.i(23344);
    ab.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
    ContactInfoUI.d(this.pyI).czi();
    AppMethodBeat.o(23344);
  }
  
  public final void ccb()
  {
    AppMethodBeat.i(23345);
    ContactInfoUI.d(this.pyI).czj();
    AppMethodBeat.o(23345);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(23341);
    if (ContactInfoUI.a(this.pyI) != null)
    {
      ab.i("MicroMsg.ContactInfoUI", "story_cat onPostClose");
      ContactInfoUI.a(this.pyI).lN(true);
      this.pyI.showTitleView();
      ContactInfoUI.c(this.pyI);
    }
    AppMethodBeat.o(23341);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(23340);
    if (ContactInfoUI.a(this.pyI) != null)
    {
      ab.i("MicroMsg.ContactInfoUI", "story_cat onPostOpen");
      ContactInfoUI.a(this.pyI).K(paramBoolean, true);
      this.pyI.hideTitleView();
      ContactInfoUI.b(this.pyI);
    }
    AppMethodBeat.o(23340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.1
 * JD-Core Version:    0.7.0.1
 */