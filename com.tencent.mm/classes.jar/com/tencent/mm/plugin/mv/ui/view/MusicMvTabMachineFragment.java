package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.a.a.d;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.csb;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMachineFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "totalCnt", "getFeedFrom", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"})
public final class MusicMvTabMachineFragment
  extends MusicMvTabFragment
  implements i
{
  public static final a Azm;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  private int uDV;
  
  static
  {
    AppMethodBeat.i(257690);
    Azm = new a((byte)0);
    AppMethodBeat.o(257690);
  }
  
  public MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(257687);
    AppMethodBeat.o(257687);
  }
  
  public MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257688);
    AppMethodBeat.o(257688);
  }
  
  private MusicMvTabMachineFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257689);
    g.azz().a(6860, (i)this);
    AppMethodBeat.o(257689);
  }
  
  public final void a(a parama, String paramString)
  {
    AppMethodBeat.i(257685);
    super.a(parama, getKeyword());
    Log.i("Music.MusicMvTabFragment", "syncBgFinderFeed ".concat(String.valueOf(paramString)));
    if (parama != null)
    {
      parama = getContext();
      p.g(parama, "context");
      parama = new d(parama, this.lastBuffer);
      g.azz().b((q)parama);
    }
    AppMethodBeat.o(257685);
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(257691);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(2131305082));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(2131305082);
      this._$_findViewCache.put(Integer.valueOf(2131305082), localView1);
    }
    AppMethodBeat.o(257691);
    return localView1;
  }
  
  public final int getFeedFrom()
  {
    return 3;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257684);
    super.onDestroy();
    g.azz().b(6860, (i)this);
    AppMethodBeat.o(257684);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(257686);
    Object localObject2 = new StringBuilder("onSceneEnd, type:");
    Object localObject1;
    if (paramq != null)
    {
      localObject1 = Integer.valueOf(paramq.getType());
      Log.i("Music.MusicMvTabFragment", localObject1 + ", errType:" + paramInt1 + ", errcode:" + paramInt2 + ", errMsg:" + paramString);
      if (!(paramq instanceof d)) {
        break label509;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label409;
      }
      paramString = ((d)paramq).Aqj;
      if (paramString == null) {
        break label295;
      }
      paramString = paramString.LDs;
      label107:
      this.lastBuffer = paramString;
      paramString = ((d)paramq).Aqj;
      if (paramString == null) {
        break label409;
      }
      this.uDV = paramString.object.size();
      localObject1 = paramString.object.iterator();
    }
    label145:
    label295:
    label303:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label305;
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
            localObject3 = (FinderMedia)j.kt((List)localObject3);
            if ((localObject3 == null) || (((FinderMedia)localObject3).mediaType != 2)) {}
          }
        }
        for (paramInt1 = 0;; paramInt1 = 1)
        {
          if (paramInt1 == 0) {
            break label303;
          }
          long l = ((FinderObject)localObject2).id;
          localObject3 = ((FinderObject)localObject2).objectNonceId;
          if (getFeedIdMap().contains(Long.valueOf(l))) {
            break label145;
          }
          getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject3, (FinderObject)localObject2)));
          break label145;
          localObject1 = null;
          break;
          paramString = null;
          break label107;
        }
      }
    }
    label305:
    getAdapter().notifyDataSetChanged();
    paramq = ((d)paramq).Aqj;
    boolean bool;
    if ((paramq == null) || (paramq.tUC != 0))
    {
      bool = true;
      setHasMore(bool);
      paramString = paramString.request_id;
      Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderFavFeed " + getDataList().size() + ", hasMore:" + getHasMore() + ", report requestId:" + paramString);
      paramq = com.tencent.mm.plugin.mv.a.l.Uqz;
      com.tencent.mm.plugin.mv.a.l.bxc(paramString);
      label409:
      getRlLayout().apT(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.hx(0, getAdapter().getItemCount());
      }
      if (getAdapter().getItemCount() != 0) {
        break label491;
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
        break label509;
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(257686);
      return;
      bool = false;
      break;
      label491:
      paramString = getEmptyLL();
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
    label509:
    AppMethodBeat.o(257686);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMachineFragment$Companion;", "", "()V", "type", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMachineFragment
 * JD-Core Version:    0.7.0.1
 */