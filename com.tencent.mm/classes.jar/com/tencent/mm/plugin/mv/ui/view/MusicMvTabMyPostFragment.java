package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyPostFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFeedFrom", "getType", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "keyword", "Companion", "plugin-mv_release"})
public final class MusicMvTabMyPostFragment
  extends MusicMvTabFragment
  implements i
{
  public static final MusicMvTabMyPostFragment.a GpW;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(235972);
    GpW = new MusicMvTabMyPostFragment.a((byte)0);
    AppMethodBeat.o(235972);
  }
  
  public MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(235968);
    AppMethodBeat.o(235968);
  }
  
  public MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(235969);
    AppMethodBeat.o(235969);
  }
  
  private MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(235970);
    h.aGY().a(3736, (i)this);
    AppMethodBeat.o(235970);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(235973);
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
    AppMethodBeat.o(235973);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(235962);
    super.a(parama, paramString);
    parama = z.bdh();
    paramString = new bid();
    paramString.xkX = 93;
    paramString.fGo = 93;
    p.j(parama, "finderUsername");
    parama = new cr(parama, 0L, this.lastBuffer, 0, paramString, 0, 0L);
    h.aGY().b((q)parama);
    AppMethodBeat.o(235962);
  }
  
  public final int getFeedFrom()
  {
    return 4;
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(235958);
    super.onDestroy();
    h.aGY().b(3736, (i)this);
    AppMethodBeat.o(235958);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(235964);
    if (((paramq instanceof cr)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.lastBuffer = ((cr)paramq).getLastBuffer();
      paramString = ((cr)paramq).rr.bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(235964);
        throw paramString;
      }
      paramString = (List)((FinderUserPageResponse)paramString).object;
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
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
              if (localFinderObject.privateFlag == 1) {
                paramInt1 = 0;
              }
              if (paramInt1 == 0) {
                break;
              }
              long l = localFinderObject.id;
              localObject = localFinderObject.objectNonceId;
              if (getFeedIdMap().contains(Long.valueOf(l))) {
                break;
              }
              getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject, (byte)0)));
              break;
            }
          }
        }
        getAdapter().notifyDataSetChanged();
        paramString = getOnSceneEndListener();
        if (paramString != null) {
          paramString.invoke();
        }
      }
      setHasMore(((cr)paramq).xcp);
    }
    getRlLayout().azs(0);
    paramString = getResultListener();
    if (paramString != null) {
      paramString.iC(1, getAdapter().getItemCount());
    }
    paramString = getAdapter();
    if (paramString != null)
    {
      paramString = Integer.valueOf(paramString.getItemCount());
      if (paramString.intValue() != 0) {
        break label377;
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
        break label395;
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(235964);
      return;
      paramString = null;
      break;
      label377:
      paramString = getEmptyLL();
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
    label395:
    AppMethodBeat.o(235964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyPostFragment
 * JD-Core Version:    0.7.0.1
 */