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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.a.a.e;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asa;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "totalCnt", "getFeedFrom", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "songId", "Companion", "plugin-mv_release"})
public final class MusicMvTabMyFavFragment
  extends MusicMvTabFragment
  implements i
{
  public static final a Azn;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  private int uDV;
  
  static
  {
    AppMethodBeat.i(257698);
    Azn = new a((byte)0);
    AppMethodBeat.o(257698);
  }
  
  public MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(257695);
    AppMethodBeat.o(257695);
  }
  
  public MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257696);
    AppMethodBeat.o(257696);
  }
  
  private MusicMvTabMyFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257697);
    g.azz().a(3966, (i)this);
    AppMethodBeat.o(257697);
  }
  
  public final void a(a parama, String paramString)
  {
    AppMethodBeat.i(257693);
    super.a(parama, paramString);
    parama = z.aUg();
    p.g(parama, "finderUsername");
    parama = new e(parama, this.lastBuffer);
    g.azz().b((q)parama);
    AppMethodBeat.o(257693);
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(257699);
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
    AppMethodBeat.o(257699);
    return localView1;
  }
  
  public final int getFeedFrom()
  {
    return 5;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257692);
    super.onDestroy();
    g.azz().b(3966, (i)this);
    AppMethodBeat.o(257692);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(257694);
    if ((paramq instanceof e))
    {
      label73:
      label223:
      label225:
      boolean bool;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramq).AqB;
        if (paramString != null)
        {
          paramString = paramString.lastBuffer;
          this.lastBuffer = paramString;
          paramString = ((e)paramq).AqB;
          if (paramString != null)
          {
            this.uDV = paramString.gAZ;
            paramString = paramString.object.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!paramString.hasNext()) {
              break label225;
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
                  break label223;
                }
                long l = localFinderObject.id;
                localObject = localFinderObject.objectNonceId;
                if (getFeedIdMap().contains(Long.valueOf(l))) {
                  break label73;
                }
                getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject)));
                break label73;
                paramString = null;
                break;
              }
            }
          }
          getAdapter().notifyDataSetChanged();
          paramString = ((e)paramq).AqB;
          if (paramString == null) {
            break label398;
          }
          paramString = Integer.valueOf(paramString.continueFlag);
          if (paramString != null) {
            break label403;
          }
          label257:
          bool = true;
          label260:
          setHasMore(bool);
          Log.i("Music.MusicMvTabFragment", "onSceneEnd GetFinderFavFeed " + getDataList().size() + ", hasMore:" + getHasMore());
        }
      }
      getRlLayout().apT(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.hx(2, getAdapter().getItemCount());
      }
      paramString = getAdapter();
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.getItemCount());
        label356:
        if (paramString.intValue() != 0) {
          break label421;
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
          break label439;
        }
        paramString.setVisibility(8);
        AppMethodBeat.o(257694);
        return;
        label398:
        paramString = null;
        break;
        label403:
        if (paramString.intValue() != 0) {
          break label257;
        }
        bool = false;
        break label260;
        paramString = null;
        break label356;
        label421:
        paramString = getEmptyLL();
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
    }
    label439:
    AppMethodBeat.o(257694);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment$Companion;", "", "()V", "type", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyFavFragment
 * JD-Core Version:    0.7.0.1
 */