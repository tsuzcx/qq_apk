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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aso;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyLikeFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFeedFrom", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"})
public final class MusicMvTabMyLikeFragment
  extends MusicMvTabFragment
  implements i
{
  public static final a Azo;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(257706);
    Azo = new a((byte)0);
    AppMethodBeat.o(257706);
  }
  
  public MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(257703);
    AppMethodBeat.o(257703);
  }
  
  public MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257704);
    AppMethodBeat.o(257704);
  }
  
  private MusicMvTabMyLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257705);
    com.tencent.mm.kernel.g.azz().a(3965, (i)this);
    AppMethodBeat.o(257705);
  }
  
  public final void a(a parama, String paramString)
  {
    AppMethodBeat.i(257701);
    super.a(parama, paramString);
    parama = z.aUg();
    p.g(parama, "finderUsername");
    parama = new com.tencent.mm.plugin.mv.a.a.g(parama, this.lastBuffer);
    com.tencent.mm.kernel.g.azz().b((q)parama);
    AppMethodBeat.o(257701);
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(257707);
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
    AppMethodBeat.o(257707);
    return localView1;
  }
  
  public final int getFeedFrom()
  {
    return 6;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257700);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3965, (i)this);
    AppMethodBeat.o(257700);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(257702);
    if ((paramq instanceof com.tencent.mm.plugin.mv.a.a.g))
    {
      label65:
      label215:
      label217:
      label249:
      boolean bool;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.mv.a.a.g)paramq).AqH;
        if (paramString != null)
        {
          paramString = paramString.lastBuffer;
          this.lastBuffer = paramString;
          paramString = ((com.tencent.mm.plugin.mv.a.a.g)paramq).AqH;
          if (paramString != null) {
            paramString = paramString.LDv.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!paramString.hasNext()) {
              break label217;
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
                  localObject = (FinderMedia)j.kt((List)localObject);
                  if ((localObject == null) || (((FinderMedia)localObject).mediaType != 2)) {}
                }
              }
              for (paramInt1 = 0;; paramInt1 = 1)
              {
                if (paramInt1 == 0) {
                  break label215;
                }
                long l = localFinderObject.id;
                localObject = localFinderObject.objectNonceId;
                if (getFeedIdMap().contains(Long.valueOf(l))) {
                  break label65;
                }
                getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject)));
                break label65;
                paramString = null;
                break;
              }
            }
          }
          getAdapter().notifyDataSetChanged();
          paramString = ((com.tencent.mm.plugin.mv.a.a.g)paramq).AqH;
          if (paramString == null) {
            break label390;
          }
          paramString = Integer.valueOf(paramString.continueFlag);
          if (paramString != null) {
            break label395;
          }
          bool = true;
          label252:
          setHasMore(bool);
          Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderLikeFeed " + getDataList().size() + ", hasMore:" + getHasMore());
        }
      }
      getRlLayout().apT(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.hx(3, getAdapter().getItemCount());
      }
      paramString = getAdapter();
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.getItemCount());
        label348:
        if (paramString.intValue() != 0) {
          break label413;
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
          break label431;
        }
        paramString.setVisibility(8);
        AppMethodBeat.o(257702);
        return;
        label390:
        paramString = null;
        break;
        label395:
        if (paramString.intValue() != 0) {
          break label249;
        }
        bool = false;
        break label252;
        paramString = null;
        break label348;
        label413:
        paramString = getEmptyLL();
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
    }
    label431:
    AppMethodBeat.o(257702);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyLikeFragment$Companion;", "", "()V", "type", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyLikeFragment
 * JD-Core Version:    0.7.0.1
 */