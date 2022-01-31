package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.l;
import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class g
{
  static final String TAG = "MicroMsg.Gallery.GalleryController";
  public static final g.a sBI = new g.a((byte)0);
  
  public void FL(int paramInt) {}
  
  public void FP(int paramInt) {}
  
  public void FQ(int paramInt) {}
  
  public void cCl() {}
  
  public void cCm() {}
  
  public void ccL() {}
  
  public void destroy() {}
  
  public void gb(int paramInt1, int paramInt2) {}
  
  public void gc(int paramInt1, int paramInt2) {}
  
  public void n(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void o(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void pause() {}
  
  public void resume() {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class a$a
    extends c.a
  {
    a$a(List paramList1, List paramList2) {}
    
    public final boolean F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(109582);
      if (((com.tencent.mm.plugin.story.model.d.g)this.sBJ.get(paramInt1)).cJA == ((com.tencent.mm.plugin.story.model.d.g)this.sBK.get(paramInt2)).cJA)
      {
        AppMethodBeat.o(109582);
        return true;
      }
      AppMethodBeat.o(109582);
      return false;
    }
    
    public final boolean G(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(109583);
      boolean bool = j.e((com.tencent.mm.plugin.story.model.d.g)this.sBJ.get(paramInt1), (com.tencent.mm.plugin.story.model.d.g)this.sBK.get(paramInt2));
      AppMethodBeat.o(109583);
      return bool;
    }
    
    public final int fv()
    {
      AppMethodBeat.i(109580);
      int i = this.sBJ.size();
      AppMethodBeat.o(109580);
      return i;
    }
    
    public final int fw()
    {
      AppMethodBeat.i(109581);
      int i = this.sBK.size();
      AppMethodBeat.o(109581);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g
 * JD-Core Version:    0.7.0.1
 */