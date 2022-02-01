package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyLikeFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"})
public final class MusicMvTabMyLikeFragment
  extends MusicMvTabFragment
  implements com.tencent.mm.an.i
{
  public static final MusicMvTabMyLikeFragment.a GpV;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(229190);
    GpV = new MusicMvTabMyLikeFragment.a((byte)0);
    AppMethodBeat.o(229190);
  }
  
  public MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(229183);
    AppMethodBeat.o(229183);
  }
  
  public MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(229185);
    AppMethodBeat.o(229185);
  }
  
  private MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(229188);
    h.aGY().a(3965, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(229188);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229195);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(229195);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(229159);
    super.a(parama, paramString);
    parama = z.bdh();
    p.j(parama, "finderUsername");
    parama = new com.tencent.mm.plugin.mv.model.a.i(parama, this.lastBuffer);
    h.aGY().b((q)parama);
    AppMethodBeat.o(229159);
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
    AppMethodBeat.i(229156);
    super.onDestroy();
    h.aGY().b(3965, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(229156);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(229174);
    if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.i))
    {
      label65:
      label216:
      label218:
      label250:
      boolean bool;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.mv.model.a.i)paramq).Gdv;
        if (paramString != null)
        {
          paramString = paramString.lastBuffer;
          this.lastBuffer = paramString;
          paramString = ((com.tencent.mm.plugin.mv.model.a.i)paramq).Gdv;
          if (paramString != null) {
            paramString = paramString.SGN.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!paramString.hasNext()) {
              break label218;
            }
            FinderObject localFinderObject = (FinderObject)paramString.next();
            if (localFinderObject != null)
            {
              Object localObject = localFinderObject.objectDesc;
              if (localObject != null)
              {
                localObject = ((FinderObjectDesc)localObject).media;
                if (localObject != null)
                {
                  localObject = (FinderMedia)j.lp((List)localObject);
                  if ((localObject == null) || (((FinderMedia)localObject).mediaType != 2)) {}
                }
              }
              for (paramInt1 = 0;; paramInt1 = 1)
              {
                if (paramInt1 == 0) {
                  break label216;
                }
                long l = localFinderObject.id;
                localObject = localFinderObject.objectNonceId;
                if (getFeedIdMap().contains(Long.valueOf(l))) {
                  break label65;
                }
                getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject, (byte)0)));
                break label65;
                paramString = null;
                break;
              }
            }
          }
          getAdapter().notifyDataSetChanged();
          paramString = ((com.tencent.mm.plugin.mv.model.a.i)paramq).Gdv;
          if (paramString == null) {
            break label407;
          }
          paramString = Integer.valueOf(paramString.continueFlag);
          if (paramString != null) {
            break label412;
          }
          bool = true;
          label253:
          setHasMore(bool);
          paramString = getOnSceneEndListener();
          if (paramString != null) {
            paramString.invoke();
          }
          Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderLikeFeed " + getDataList().size() + ", hasMore:" + getHasMore());
        }
      }
      getRlLayout().azs(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.iC(3, getAdapter().getItemCount());
      }
      paramString = getAdapter();
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.getItemCount());
        label365:
        if (paramString.intValue() != 0) {
          break label430;
        }
        paramString = getEmptyLL();
        if (paramString != null) {
          paramString.setVisibility(0);
        }
      }
      for (;;)
      {
        paramString = getLoadingTv();
        if (paramString == null) {
          break label448;
        }
        paramString.setVisibility(8);
        AppMethodBeat.o(229174);
        return;
        label407:
        paramString = null;
        break;
        label412:
        if (paramString.intValue() != 0) {
          break label250;
        }
        bool = false;
        break label253;
        paramString = null;
        break label365;
        label430:
        paramString = getEmptyLL();
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
    }
    label448:
    AppMethodBeat.o(229174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyLikeFragment
 * JD-Core Version:    0.7.0.1
 */