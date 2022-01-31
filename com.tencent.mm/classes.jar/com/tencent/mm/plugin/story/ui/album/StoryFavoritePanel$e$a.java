package com.tencent.mm.plugin.story.ui.album;

import a.f.a.b;
import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryFavoritePanel$e$a
  implements View.OnClickListener
{
  StoryFavoritePanel$e$a(StoryFavoritePanel.e parame, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110198);
    paramView = this.sJV.sJT.getMOnAddItemClickListener();
    if (paramView != null)
    {
      Object localObject = this.sJV.sJT.getMDatas().get(this.euX);
      j.p(localObject, "mDatas[position]");
      paramView.S(localObject);
      AppMethodBeat.o(110198);
      return;
    }
    AppMethodBeat.o(110198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.a
 * JD-Core Version:    0.7.0.1
 */