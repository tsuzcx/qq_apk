package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryFavAlbumUI$c
  implements View.OnClickListener
{
  StoryFavAlbumUI$c(StoryFavAlbumUI paramStoryFavAlbumUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119848);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("Contact_User", StoryFavAlbumUI.a(this.Fzj));
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
    c.b((Context)this.Fzj, "profile", ".ui.ContactInfoUI", paramView);
    a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI.c
 * JD-Core Version:    0.7.0.1
 */