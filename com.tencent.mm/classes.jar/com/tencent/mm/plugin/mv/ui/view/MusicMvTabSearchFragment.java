package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "continueFlag", "finderPullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "requestId", "", "searchOffset", "getFeedFrom", "getType", "initSearch", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "keyword", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "Companion", "plugin-mv_release"})
public final class MusicMvTabSearchFragment
  extends MusicMvTabFragment
  implements i
{
  public static final MusicMvTabSearchFragment.a GpZ;
  private int GpX;
  private int GpY;
  private HashMap _$_findViewCache;
  private int continueFlag;
  private String fIY;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(232688);
    GpZ = new MusicMvTabSearchFragment.a((byte)0);
    AppMethodBeat.o(232688);
  }
  
  public MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(232681);
    AppMethodBeat.o(232681);
  }
  
  public MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(232683);
    AppMethodBeat.o(232683);
  }
  
  private MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(232685);
    h.aGY().a(3820, (i)this);
    AppMethodBeat.o(232685);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(232692);
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
    AppMethodBeat.o(232692);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(232670);
    super.a(parama, paramString);
    if (this.fIY == null) {
      this.fIY = UUID.randomUUID().toString();
    }
    String str = this.fIY;
    if (str != null)
    {
      if (paramString != null)
      {
        int i;
        if (((CharSequence)paramString).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label138;
          }
        }
        label138:
        for (parama = paramString;; parama = null)
        {
          if (parama == null) {
            break label143;
          }
          paramString = new bid();
          paramString.xkX = 93;
          h.aGY().b((q)new cj(parama, this.GpX, str, this.lastBuffer, 12, paramString, null, null, 448));
          paramString = m.GcA;
          m.jm(parama, "");
          AppMethodBeat.o(232670);
          return;
          i = 0;
          break;
        }
      }
      label143:
      AppMethodBeat.o(232670);
      return;
    }
    AppMethodBeat.o(232670);
  }
  
  public final void aSM(String paramString)
  {
    AppMethodBeat.i(232665);
    getRlLayout().setHasBottomMore(true);
    Object localObject = getLoadingTv();
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = getRlLayout().getLoadMoreFooter();
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = getRlLayout().getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(a.g.load_more_footer_tip_tv);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
    }
    this.fIY = UUID.randomUUID().toString();
    this.lastBuffer = null;
    this.GpX = 0;
    getDataList().clear();
    a(null, paramString);
    AppMethodBeat.o(232665);
  }
  
  public final int getFeedFrom()
  {
    return 7;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232659);
    super.onDestroy();
    h.aGY().b(3820, (i)this);
    AppMethodBeat.o(232659);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(232675);
    if ((paramq instanceof cj))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.lastBuffer = ((cj)paramq).xea.xHE;
        this.GpY = 2;
        paramString = ((cj)paramq).xea;
        this.GpX = paramString.offset;
        this.continueFlag = paramString.continueFlag;
        if (this.continueFlag != 0) {}
        for (boolean bool = true;; bool = false)
        {
          setHasMore(bool);
          paramString = paramString.wHI.iterator();
          while (paramString.hasNext())
          {
            paramq = (FinderObject)paramString.next();
            if (paramq != null)
            {
              long l = paramq.id;
              String str = paramq.objectNonceId;
              if (!getFeedIdMap().contains(Long.valueOf(l))) {
                getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, str, paramq, (byte)0)));
              }
            }
          }
        }
        getAdapter().notifyDataSetChanged();
        paramString = getOnSceneEndListener();
        if (paramString != null) {
          paramString.invoke();
        }
        Log.i("Music.MusicMvTabFragment", "onSceneEnd BGFinderFeed " + getDataList().size());
      }
      getRlLayout().azs(0);
      paramString = getResultListener();
      if (paramString != null)
      {
        paramString.iC(4, getAdapter().getItemCount());
        AppMethodBeat.o(232675);
        return;
      }
    }
    AppMethodBeat.o(232675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabSearchFragment
 * JD-Core Version:    0.7.0.1
 */