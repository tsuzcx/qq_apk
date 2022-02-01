package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mv.model.a.l;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyLikeFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvTabMyLikeFragment
  extends MusicMvTabFragment
  implements com.tencent.mm.am.h
{
  public static final MusicMvTabMyLikeFragment.a MjW;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(287262);
    MjW = new MusicMvTabMyLikeFragment.a((byte)0);
    AppMethodBeat.o(287262);
  }
  
  public MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287243);
    AppMethodBeat.o(287243);
  }
  
  public MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287250);
    AppMethodBeat.o(287250);
  }
  
  private MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287255);
    com.tencent.mm.kernel.h.aZW().a(3965, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287255);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(287276);
    super.a(parama, paramString);
    parama = z.bAW();
    kotlin.g.b.s.s(parama, "finderUsername");
    parama = new l(parama, this.lastBuffer);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)parama, 0);
    AppMethodBeat.o(287276);
  }
  
  public final int getFeedFrom()
  {
    return 6;
  }
  
  public final int getType()
  {
    return 4;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287270);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3965, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287270);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(287290);
    if ((paramp instanceof l)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((l)paramp).LZi;
        if (paramString == null)
        {
          paramString = null;
          this.lastBuffer = paramString;
          paramString = ((l)paramp).LZi;
          if (paramString == null) {
            break label319;
          }
          paramString = paramString.ZJE.iterator();
        }
      }
    }
    label62:
    label319:
    label454:
    label457:
    for (;;)
    {
      FinderObject localFinderObject;
      Object localObject;
      if (paramString.hasNext())
      {
        localFinderObject = (FinderObject)paramString.next();
        if (localFinderObject == null) {
          continue;
        }
        localObject = com.tencent.mm.plugin.mv.ui.a.Maz;
        com.tencent.mm.plugin.mv.ui.a.R(localFinderObject);
        localObject = localFinderObject.objectDesc;
        if (localObject == null) {
          break label454;
        }
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject == null) {
          break label454;
        }
        localObject = (FinderMedia)kotlin.a.p.oL((List)localObject);
        if ((localObject == null) || (((FinderMedia)localObject).mediaType != 2)) {
          break label454;
        }
      }
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        if (paramInt1 == 0) {
          break label457;
        }
        long l = localFinderObject.id;
        localObject = localFinderObject.objectNonceId;
        if (getFeedIdMap().contains(Long.valueOf(l))) {
          break label62;
        }
        getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject, (byte)0)));
        break label62;
        paramString = paramString.lastBuffer;
        break;
        getAdapter().bZE.notifyChanged();
        paramString = ((l)paramp).LZi;
        label252:
        boolean bool;
        if (paramString == null)
        {
          paramString = null;
          if (paramString != null) {
            break label418;
          }
          bool = true;
          label255:
          setHasMore(bool);
          paramString = getOnSceneEndListener();
          if (paramString != null) {
            paramString.invoke();
          }
          Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderLikeFeed " + getDataList().size() + ", hasMore:" + getHasMore());
          getRlLayout().aFW(0);
          paramString = getResultListener();
          if (paramString != null) {
            paramString.kg(3, getAdapter().getItemCount());
          }
          paramString = getAdapter();
          if ((paramString == null) || (paramString.getItemCount() != 0)) {
            break label431;
          }
          paramInt1 = 1;
          label368:
          if (paramInt1 == 0) {
            break label436;
          }
          paramString = getEmptyLL();
          if (paramString != null) {
            paramString.setVisibility(0);
          }
        }
        for (;;)
        {
          paramString = getLoadingTv();
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          AppMethodBeat.o(287290);
          return;
          paramString = Integer.valueOf(paramString.continueFlag);
          break;
          if (paramString.intValue() != 0) {
            break label252;
          }
          bool = false;
          break label255;
          paramInt1 = 0;
          break label368;
          paramString = getEmptyLL();
          if (paramString != null) {
            paramString.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyLikeFragment
 * JD-Core Version:    0.7.0.1
 */