package com.tencent.mm.plugin.story.ui.album;

import a.l;
import a.y;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.e.b.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<a.e>
{
  static final String TAG = "MicroMsg.StoryAlbumAdapter";
  public static final a.a sIV;
  ArrayList<c> mItemList;
  private final String sIL;
  private final String sIM;
  private final int sIN;
  private final int sIO;
  private ArrayList<com.tencent.mm.plugin.story.h.j> sIP;
  private final int sIQ;
  private int sIR;
  boolean sIS;
  a.f.a.b<? super h, y> sIT;
  a.f.a.a<y> sIU;
  private final int seb;
  boolean sek;
  
  static
  {
    AppMethodBeat.i(110156);
    sIV = new a.a((byte)0);
    TAG = "MicroMsg.StoryAlbumAdapter";
    AppMethodBeat.o(110156);
  }
  
  public a()
  {
    AppMethodBeat.i(110155);
    this.sIL = "loadingMore";
    this.sIM = "favorite";
    this.seb = 1;
    this.sIO = 2;
    this.mItemList = new ArrayList();
    this.sIP = new ArrayList();
    b.a locala = com.tencent.mm.plugin.story.e.b.ssx;
    this.sIQ = new GregorianCalendar().get(1);
    AppMethodBeat.o(110155);
  }
  
  public final void dI(List<c> paramList)
  {
    AppMethodBeat.i(110151);
    a.f.b.j.q(paramList, "datas");
    ab.i(TAG, "updateDatas");
    this.mItemList.clear();
    if ((com.tencent.mm.plugin.story.c.a.a.srz.czq()) && (!this.sIS))
    {
      this.mItemList.add(new c(this.sIM, null, 2));
      ab.i(TAG, "updateDatas add fav");
    }
    this.mItemList.addAll((Collection)paramList);
    Iterator localIterator = ((Iterable)this.mItemList).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = this.sIR;
      this.sIR = (localc.sJd.size() + i);
    }
    if (!paramList.isEmpty()) {
      this.mItemList.add(new c(this.sIL, null, 2));
    }
    notifyDataSetChanged();
    AppMethodBeat.o(110151);
  }
  
  public final int f(com.tencent.mm.plugin.story.h.j paramj)
  {
    AppMethodBeat.i(110154);
    a.f.b.j.q(paramj, "storyInfo");
    ab.d(TAG, "storyLocalId=" + (int)paramj.systemRowid);
    int k = ((Collection)this.mItemList).size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Iterator localIterator = ((c)this.mItemList.get(i)).sJd.iterator();
      while (localIterator.hasNext())
      {
        if ((int)((h)localIterator.next()).szQ.systemRowid == (int)paramj.systemRowid)
        {
          ab.d(TAG, "findPositionInGallery index=%s", new Object[] { Integer.valueOf(j) });
          AppMethodBeat.o(110154);
          return j;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(110154);
    return j;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110150);
    int i = this.mItemList.size();
    AppMethodBeat.o(110150);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(110149);
    if (bo.isEqual(((c)this.mItemList.get(paramInt)).label, this.sIL))
    {
      paramInt = this.seb;
      AppMethodBeat.o(110149);
      return paramInt;
    }
    if (bo.isEqual(((c)this.mItemList.get(paramInt)).label, this.sIM))
    {
      paramInt = this.sIO;
      AppMethodBeat.o(110149);
      return paramInt;
    }
    paramInt = this.sIN;
    AppMethodBeat.o(110149);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a
 * JD-Core Version:    0.7.0.1
 */