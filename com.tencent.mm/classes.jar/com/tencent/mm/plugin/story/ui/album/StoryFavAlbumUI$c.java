package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryFavAlbumUI$c
  implements View.OnClickListener
{
  StoryFavAlbumUI$c(StoryFavAlbumUI paramStoryFavAlbumUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119848);
    paramView = new Intent();
    paramView.putExtra("Contact_User", StoryFavAlbumUI.a(this.zFw));
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
    d.b((Context)this.zFw, "profile", ".ui.ContactInfoUI", paramView);
    AppMethodBeat.o(119848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI.c
 * JD-Core Version:    0.7.0.1
 */