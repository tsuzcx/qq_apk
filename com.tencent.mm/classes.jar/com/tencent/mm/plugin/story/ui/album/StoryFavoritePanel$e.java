package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.c.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-story_release"})
public final class StoryFavoritePanel$e
  extends RecyclerView.a<RecyclerView.v>
{
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(110200);
    a.f.b.j.q(paramViewGroup, "parent");
    if (paramInt == StoryFavoritePanel.a(this.sJT))
    {
      paramViewGroup = w.hM(this.sJT.getContext()).inflate(2130970912, paramViewGroup, false);
      localStoryFavoritePanel = this.sJT;
      a.f.b.j.p(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.f(localStoryFavoritePanel, paramViewGroup);
      AppMethodBeat.o(110200);
      return paramViewGroup;
    }
    if (paramInt == StoryFavoritePanel.b(this.sJT))
    {
      localStoryFavoritePanel = this.sJT;
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970921, paramViewGroup, false);
      a.f.b.j.p(paramViewGroup, "LayoutInflater.from(pare…ng_layout, parent, false)");
      paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.b(localStoryFavoritePanel, paramViewGroup);
      AppMethodBeat.o(110200);
      return paramViewGroup;
    }
    if (paramInt == StoryFavoritePanel.c(this.sJT))
    {
      localStoryFavoritePanel = this.sJT;
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970915, paramViewGroup, false);
      a.f.b.j.p(paramViewGroup, "LayoutInflater.from(pare…lect_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.d(localStoryFavoritePanel, paramViewGroup);
      AppMethodBeat.o(110200);
      return paramViewGroup;
    }
    paramViewGroup = w.hM(this.sJT.getContext()).inflate(2130970913, paramViewGroup, false);
    StoryFavoritePanel localStoryFavoritePanel = this.sJT;
    a.f.b.j.p(paramViewGroup, "itemView");
    paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.g(localStoryFavoritePanel, paramViewGroup);
    AppMethodBeat.o(110200);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(110203);
    a.f.b.j.q(paramv, "holder");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramv instanceof StoryFavoritePanel.f))
    {
      localObject1 = ((StoryFavoritePanel.f)paramv).iTH;
      localObject2 = this.sJT.getContext();
      localObject3 = this.sJT.getContext();
      a.f.b.j.p(localObject3, "context");
      ((ImageView)localObject1).setImageDrawable(aj.g((Context)localObject2, 2131231475, ((Context)localObject3).getResources().getColor(2131690546)));
      paramv.aku.setOnClickListener((View.OnClickListener)new StoryFavoritePanel.e.a(this, paramInt));
      AppMethodBeat.o(110203);
      return;
    }
    label202:
    az localaz;
    if ((paramv instanceof StoryFavoritePanel.g))
    {
      paramv.aku.setOnClickListener((View.OnClickListener)new StoryFavoritePanel.e.b(this, paramInt));
      localObject1 = ((StoryFavoritePanel.c)this.sJT.getMDatas().get(paramInt)).szQ;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.story.h.j)localObject1).cEY();
        if (localObject1 != null)
        {
          localObject1 = ((cic)localObject1).xSK;
          if (localObject1 == null) {
            break label839;
          }
          localObject2 = ((chb)localObject1).wOa;
          a.f.b.j.p(localObject2, "obj.MediaObjList");
          if (((Collection)localObject2).isEmpty()) {
            break label338;
          }
          if (i == 0) {
            break label839;
          }
          localObject2 = com.tencent.mm.plugin.story.model.j.svi;
          localObject2 = j.b.cAK();
          localObject1 = ((chb)localObject1).wOa.get(0);
          a.f.b.j.p(localObject1, "obj.MediaObjList[0]");
          localObject3 = (chl)localObject1;
          localObject1 = ((StoryFavoritePanel.c)this.sJT.getMDatas().get(paramInt)).szQ;
          if (localObject1 == null) {
            break label343;
          }
        }
      }
      label338:
      label343:
      for (localObject1 = ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName;; localObject1 = null)
      {
        localaz = az.yNY;
        a.f.b.j.p(localaz, "FROM_SCENE.storyalbum");
        localObject1 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject3, (String)localObject1, localaz);
        paramv = ((StoryFavoritePanel.g)paramv).sJg;
        localObject3 = com.tencent.mm.plugin.story.model.j.svi;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, paramv, j.b.a(a.syb));
        AppMethodBeat.o(110203);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label202;
      }
    }
    else if ((paramv instanceof StoryFavoritePanel.d))
    {
      localObject1 = (Iterable)this.sJT.getMCheckedDatas();
      label447:
      boolean bool;
      if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
      {
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          if (((com.tencent.mm.plugin.story.h.j)((Iterator)localObject1).next()).field_storyID == ((StoryFavoritePanel.c)this.sJT.getMDatas().get(paramInt)).szQ.field_storyID)
          {
            i = 1;
            if (i == 0) {
              break label742;
            }
            bool = true;
            label454:
            if (!bool) {
              break label750;
            }
            ((StoryFavoritePanel.d)paramv).mCA.setVisibility(0);
            label470:
            ((StoryFavoritePanel.d)paramv).sJU.setOnCheckedChangeListener(null);
            ((StoryFavoritePanel.d)paramv).sJU.setChecked(bool);
            ((StoryFavoritePanel.d)paramv).sJU.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new StoryFavoritePanel.e.c(this, paramInt, paramv));
            ((StoryFavoritePanel.d)paramv).jYu.setOnClickListener((View.OnClickListener)new StoryFavoritePanel.e.d(paramv));
            ((StoryFavoritePanel.d)paramv).sJg.setOnClickListener((View.OnClickListener)new StoryFavoritePanel.e.e(this, paramInt));
            localObject2 = ((StoryFavoritePanel.c)this.sJT.getMDatas().get(paramInt)).szQ.cEY().xSK;
            if (localObject2 == null) {
              break label839;
            }
            localObject1 = ((chb)localObject2).wOa;
            a.f.b.j.p(localObject1, "obj.MediaObjList");
            if (((Collection)localObject1).isEmpty()) {
              break label765;
            }
          }
        }
      }
      label742:
      label750:
      label765:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label839;
        }
        localObject1 = com.tencent.mm.plugin.story.model.j.svi;
        localObject1 = j.b.cAK();
        localObject2 = ((chb)localObject2).wOa.get(0);
        a.f.b.j.p(localObject2, "obj.MediaObjList[0]");
        localObject2 = (chl)localObject2;
        localObject3 = ((StoryFavoritePanel.c)this.sJT.getMDatas().get(paramInt)).szQ.field_userName;
        localaz = az.yNY;
        a.f.b.j.p(localaz, "FROM_SCENE.storyalbum");
        localObject2 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, localaz);
        paramv = ((StoryFavoritePanel.d)paramv).sJg;
        localObject3 = com.tencent.mm.plugin.story.model.j.svi;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, paramv, j.b.a(a.syb));
        AppMethodBeat.o(110203);
        return;
        i = 0;
        break label447;
        break;
        bool = false;
        break label454;
        ((StoryFavoritePanel.d)paramv).mCA.setVisibility(8);
        break label470;
      }
    }
    else if ((paramv instanceof StoryFavoritePanel.b))
    {
      if (this.sJT.getMIsAll())
      {
        ((StoryFavoritePanel.b)paramv).sIY.setVisibility(8);
        ((StoryFavoritePanel.b)paramv).sIZ.setVisibility(0);
        AppMethodBeat.o(110203);
        return;
      }
      ((StoryFavoritePanel.b)paramv).sIY.setVisibility(0);
      ((StoryFavoritePanel.b)paramv).sIZ.setVisibility(8);
    }
    label839:
    AppMethodBeat.o(110203);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110202);
    int i = this.sJT.getMDatas().size();
    AppMethodBeat.o(110202);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(110201);
    paramInt = ((StoryFavoritePanel.c)this.sJT.getMDatas().get(paramInt)).type;
    AppMethodBeat.o(110201);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e
 * JD-Core Version:    0.7.0.1
 */