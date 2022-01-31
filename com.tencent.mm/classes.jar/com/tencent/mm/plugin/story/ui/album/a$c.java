package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.e.c;
import com.tencent.mm.plugin.story.h.a.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.o.a;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
public final class a$c
  extends a.e
{
  private ViewGroup sIY;
  private ImageView sIZ;
  
  public a$c(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(110144);
    paramView = localObject.findViewById(2131822311);
    a.f.b.j.p(paramView, "view.findViewById(R.id.loading_more_state)");
    this.sIY = ((ViewGroup)paramView);
    paramView = localObject.findViewById(2131828246);
    a.f.b.j.p(paramView, "view.findViewById(R.id.album_is_all_view)");
    this.sIZ = ((ImageView)paramView);
    AppMethodBeat.o(110144);
  }
  
  public final void Ge(int paramInt)
  {
    AppMethodBeat.i(110143);
    if (a.d(this.sIW))
    {
      this.sIY.setVisibility(8);
      this.sIZ.setVisibility(0);
      AppMethodBeat.o(110143);
      return;
    }
    a.e(this.sIW);
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    if (j.b.cAL().rif <= 0)
    {
      localObject = c.ssB;
      localObject = ah.getContext().getSharedPreferences(ah.dsP(), 0);
      String str = c.czP();
      a.a locala = com.tencent.mm.plugin.story.h.a.sFV;
      ((SharedPreferences)localObject).getInt(str, com.tencent.mm.plugin.story.h.a.cDS());
    }
    this.sIY.setVisibility(0);
    this.sIZ.setVisibility(8);
    AppMethodBeat.o(110143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a.c
 * JD-Core Version:    0.7.0.1
 */