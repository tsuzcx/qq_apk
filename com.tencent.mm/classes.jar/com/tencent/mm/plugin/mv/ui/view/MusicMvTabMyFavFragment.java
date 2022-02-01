package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mv.model.a.g;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aub;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "totalCnt", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"})
public final class MusicMvTabMyFavFragment
  extends MusicMvTabFragment
  implements i
{
  public static final MusicMvTabMyFavFragment.a GpU;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  private int zfq;
  
  static
  {
    AppMethodBeat.i(225833);
    GpU = new MusicMvTabMyFavFragment.a((byte)0);
    AppMethodBeat.o(225833);
  }
  
  public MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(225827);
    AppMethodBeat.o(225827);
  }
  
  public MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(225829);
    AppMethodBeat.o(225829);
  }
  
  private MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(225831);
    h.aGY().a(3966, (i)this);
    AppMethodBeat.o(225831);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(225835);
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
    AppMethodBeat.o(225835);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(225820);
    super.a(parama, paramString);
    parama = z.bdh();
    p.j(parama, "finderUsername");
    parama = new g(parama, this.lastBuffer);
    h.aGY().b((q)parama);
    AppMethodBeat.o(225820);
  }
  
  public final int getFeedFrom()
  {
    return 5;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(225817);
    super.onDestroy();
    h.aGY().b(3966, (i)this);
    AppMethodBeat.o(225817);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(225823);
    if ((paramq instanceof g))
    {
      label73:
      label224:
      label226:
      boolean bool;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((g)paramq).Gdq;
        if (paramString != null)
        {
          paramString = paramString.lastBuffer;
          this.lastBuffer = paramString;
          paramString = ((g)paramq).Gdq;
          if (paramString != null)
          {
            this.zfq = paramString.jlf;
            paramString = paramString.object.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!paramString.hasNext()) {
              break label226;
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
                  break label224;
                }
                long l = localFinderObject.id;
                localObject = localFinderObject.objectNonceId;
                if (getFeedIdMap().contains(Long.valueOf(l))) {
                  break label73;
                }
                getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject, (byte)0)));
                break label73;
                paramString = null;
                break;
              }
            }
          }
          getAdapter().notifyDataSetChanged();
          paramString = ((g)paramq).Gdq;
          if (paramString == null) {
            break label415;
          }
          paramString = Integer.valueOf(paramString.continueFlag);
          if (paramString != null) {
            break label420;
          }
          label258:
          bool = true;
          label261:
          setHasMore(bool);
          paramString = getOnSceneEndListener();
          if (paramString != null) {
            paramString.invoke();
          }
          Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderFavFeed " + getDataList().size() + ", hasMore:" + getHasMore());
        }
      }
      getRlLayout().azs(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.iC(2, getAdapter().getItemCount());
      }
      paramString = getAdapter();
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.getItemCount());
        label373:
        if (paramString.intValue() != 0) {
          break label438;
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
          break label456;
        }
        paramString.setVisibility(8);
        AppMethodBeat.o(225823);
        return;
        label415:
        paramString = null;
        break;
        label420:
        if (paramString.intValue() != 0) {
          break label258;
        }
        bool = false;
        break label261;
        paramString = null;
        break label373;
        label438:
        paramString = getEmptyLL();
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
    }
    label456:
    AppMethodBeat.o(225823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyFavFragment
 * JD-Core Version:    0.7.0.1
 */