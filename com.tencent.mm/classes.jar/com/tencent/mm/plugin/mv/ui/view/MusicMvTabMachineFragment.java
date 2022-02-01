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
import com.tencent.mm.plugin.mv.model.a.f;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.dba;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMachineFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "totalCnt", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"})
public final class MusicMvTabMachineFragment
  extends MusicMvTabFragment
  implements i
{
  public static final MusicMvTabMachineFragment.a GpT;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  private int zfq;
  
  static
  {
    AppMethodBeat.i(229994);
    GpT = new MusicMvTabMachineFragment.a((byte)0);
    AppMethodBeat.o(229994);
  }
  
  public MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(229984);
    AppMethodBeat.o(229984);
  }
  
  public MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(229988);
    AppMethodBeat.o(229988);
  }
  
  private MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(229991);
    h.aGY().a(6860, (i)this);
    AppMethodBeat.o(229991);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229997);
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
    AppMethodBeat.o(229997);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(229971);
    super.a(parama, getKeyword());
    Log.i("Music.MusicMvTabFragment", "syncBgFinderFeed ".concat(String.valueOf(paramString)));
    if (parama != null)
    {
      parama = getContext();
      p.j(parama, "context");
      parama = new f(parama, this.lastBuffer);
      h.aGY().b((q)parama);
    }
    AppMethodBeat.o(229971);
  }
  
  public final int getFeedFrom()
  {
    return 3;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(229965);
    super.onDestroy();
    h.aGY().b(6860, (i)this);
    AppMethodBeat.o(229965);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(229978);
    Object localObject2 = new StringBuilder("onSceneEnd, type:");
    Object localObject1;
    if (paramq != null)
    {
      localObject1 = Integer.valueOf(paramq.getType());
      Log.i("Music.MusicMvTabFragment", localObject1 + ", errType:" + paramInt1 + ", errcode:" + paramInt2 + ", errMsg:" + paramString);
      if (!(paramq instanceof f)) {
        break label529;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label429;
      }
      paramString = ((f)paramq).GbX;
      if (paramString == null) {
        break label296;
      }
      paramString = paramString.SDI;
      label107:
      this.lastBuffer = paramString;
      paramString = ((f)paramq).GbX;
      if (paramString == null) {
        break label429;
      }
      this.zfq = paramString.object.size();
      localObject1 = paramString.object.iterator();
    }
    label145:
    label296:
    label304:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label306;
      }
      localObject2 = (FinderObject)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        Object localObject3 = ((FinderObject)localObject2).objectDesc;
        if (localObject3 != null)
        {
          localObject3 = ((FinderObjectDesc)localObject3).media;
          if (localObject3 != null)
          {
            localObject3 = (FinderMedia)j.lp((List)localObject3);
            if ((localObject3 == null) || (((FinderMedia)localObject3).mediaType != 2)) {}
          }
        }
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label304;
          }
          long l = ((FinderObject)localObject2).id;
          localObject3 = ((FinderObject)localObject2).objectNonceId;
          if (getFeedIdMap().contains(Long.valueOf(l))) {
            break label145;
          }
          getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject3, (FinderObject)localObject2, (byte)0)));
          break label145;
          localObject1 = null;
          break;
          paramString = null;
          break label107;
        }
      }
    }
    label306:
    getAdapter().notifyDataSetChanged();
    paramq = ((f)paramq).GbX;
    boolean bool;
    if ((paramq == null) || (paramq.xFI != 0))
    {
      bool = true;
      setHasMore(bool);
      paramString = paramString.request_id;
      paramq = getOnSceneEndListener();
      if (paramq != null) {
        paramq.invoke();
      }
      Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderFavFeed " + getDataList().size() + ", hasMore:" + getHasMore() + ", report requestId:" + paramString);
      paramq = m.GcA;
      m.aSF(paramString);
      label429:
      getRlLayout().azs(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.iC(0, getAdapter().getItemCount());
      }
      if (getAdapter().getItemCount() != 0) {
        break label511;
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
        break label529;
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(229978);
      return;
      bool = false;
      break;
      label511:
      paramString = getEmptyLL();
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
    label529:
    AppMethodBeat.o(229978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMachineFragment
 * JD-Core Version:    0.7.0.1
 */