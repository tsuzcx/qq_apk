package com.tencent.mm.plugin.story.ui.album;

import a.f.a.m;
import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryFavoritePanel$e$b
  implements View.OnClickListener
{
  StoryFavoritePanel$e$b(StoryFavoritePanel.e parame, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110199);
    paramView = this.sJV.sJT.getMOnFavItemClickListener();
    if (paramView != null)
    {
      Object localObject = this.sJV.sJT.getMDatas().get(this.euX);
      j.p(localObject, "mDatas[position]");
      paramView.h(localObject, Integer.valueOf(this.euX));
      AppMethodBeat.o(110199);
      return;
    }
    AppMethodBeat.o(110199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.b
 * JD-Core Version:    0.7.0.1
 */