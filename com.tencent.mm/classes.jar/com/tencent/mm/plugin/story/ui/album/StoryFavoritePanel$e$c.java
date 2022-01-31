package com.tencent.mm.plugin.story.ui.album;

import a.f.a.b;
import a.f.a.q;
import a.l;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "newStatus", "", "onCheckedChanged"})
final class StoryFavoritePanel$e$c
  implements CompoundButton.OnCheckedChangeListener
{
  StoryFavoritePanel$e$c(StoryFavoritePanel.e parame, int paramInt, RecyclerView.v paramv) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(151146);
    ab.d(StoryFavoritePanel.d(this.sJV.sJT), "setOnCheckedChangeListener ".concat(String.valueOf(paramBoolean)));
    int i;
    if (paramBoolean)
    {
      i = this.sJV.sJT.getMCheckedDatas().size();
      paramCompoundButton = a.c.sFZ;
      if (i < a.c.cEx())
      {
        paramCompoundButton = (Iterable)this.sJV.sJT.getMCheckedDatas();
        if ((!(paramCompoundButton instanceof Collection)) || (!((Collection)paramCompoundButton).isEmpty()))
        {
          paramCompoundButton = paramCompoundButton.iterator();
          if (paramCompoundButton.hasNext()) {
            if (((com.tencent.mm.plugin.story.h.j)paramCompoundButton.next()).field_storyID == ((StoryFavoritePanel.c)this.sJV.sJT.getMDatas().get(this.euX)).szQ.field_storyID)
            {
              i = 1;
              label149:
              if (i == 0) {
                break label280;
              }
              i = 0;
              label155:
              if (i != 0)
              {
                this.sJV.sJT.getMCheckedDatas().add(((StoryFavoritePanel.c)this.sJV.sJT.getMDatas().get(this.euX)).szQ);
                ((StoryFavoritePanel.d)this.sJW).mCA.setVisibility(0);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramCompoundButton = this.sJV.sJT.getMOnCheckItemListener();
      if (paramCompoundButton == null) {
        break label384;
      }
      Object localObject = this.sJV.sJT.getMDatas().get(this.euX);
      a.f.b.j.p(localObject, "mDatas[position]");
      paramCompoundButton.d(localObject, Integer.valueOf(this.euX), Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(151146);
      return;
      i = 0;
      break label149;
      label280:
      break;
      i = 1;
      break label155;
      ((StoryFavoritePanel.d)this.sJW).sJU.setChecked(false);
      h.J(this.sJV.sJT.getContext(), "", this.sJV.sJT.getResources().getString(2131304157));
      AppMethodBeat.o(151146);
      return;
      a.a.j.a((List)this.sJV.sJT.getMCheckedDatas(), (b)new StoryFavoritePanel.e.c.1(this));
      ((StoryFavoritePanel.d)this.sJW).mCA.setVisibility(8);
    }
    label384:
    AppMethodBeat.o(151146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.c
 * JD-Core Version:    0.7.0.1
 */