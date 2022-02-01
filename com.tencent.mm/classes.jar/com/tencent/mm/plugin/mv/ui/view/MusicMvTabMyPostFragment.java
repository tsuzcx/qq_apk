package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyPostFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFeedFrom", "onDestroy", "", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "keyword", "Companion", "plugin-mv_release"})
public final class MusicMvTabMyPostFragment
  extends MusicMvTabFragment
  implements i
{
  public static final a Azp;
  private HashMap _$_findViewCache;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(257714);
    Azp = new a((byte)0);
    AppMethodBeat.o(257714);
  }
  
  public MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(257711);
    AppMethodBeat.o(257711);
  }
  
  public MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257712);
    AppMethodBeat.o(257712);
  }
  
  private MusicMvTabMyPostFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257713);
    g.azz().a(3736, (i)this);
    AppMethodBeat.o(257713);
  }
  
  public final void a(a parama, String paramString)
  {
    AppMethodBeat.i(257709);
    super.a(parama, paramString);
    parama = z.aUg();
    paramString = new bbn();
    paramString.tCE = 93;
    paramString.tyh = 93;
    p.g(parama, "finderUsername");
    parama = new cn(parama, 0L, this.lastBuffer, 0, paramString, 0, 0L);
    g.azz().b((q)parama);
    AppMethodBeat.o(257709);
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(257715);
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
    AppMethodBeat.o(257715);
    return localView1;
  }
  
  public final int getFeedFrom()
  {
    return 4;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257708);
    super.onDestroy();
    g.azz().b(3736, (i)this);
    AppMethodBeat.o(257708);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(257710);
    if (((paramq instanceof cn)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.lastBuffer = ((cn)paramq).getLastBuffer();
      paramString = ((cn)paramq).rr.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(257710);
        throw paramString;
      }
      paramString = (List)((FinderUserPageResponse)paramString).object;
      if (paramString != null)
      {
        paramString = paramString.iterator();
        label233:
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
                localObject = (FinderMedia)j.kt((List)localObject);
                if ((localObject == null) || (((FinderMedia)localObject).mediaType != 2)) {}
              }
            }
            for (paramInt1 = 0;; paramInt1 = 1)
            {
              if (paramInt1 == 0) {
                break label233;
              }
              long l = localFinderObject.id;
              localObject = localFinderObject.objectNonceId;
              if (getFeedIdMap().contains(Long.valueOf(l))) {
                break;
              }
              getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, localFinderObject)));
              break;
            }
          }
        }
        getAdapter().notifyDataSetChanged();
      }
      setHasMore(((cn)paramq).tuG);
    }
    getRlLayout().apT(0);
    paramString = getResultListener();
    if (paramString != null) {
      paramString.hx(1, getAdapter().getItemCount());
    }
    paramString = getAdapter();
    if (paramString != null)
    {
      paramString = Integer.valueOf(paramString.getItemCount());
      if (paramString.intValue() != 0) {
        break label349;
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
        break label367;
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(257710);
      return;
      paramString = null;
      break;
      label349:
      paramString = getEmptyLL();
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
    label367:
    AppMethodBeat.o(257710);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyPostFragment$Companion;", "", "()V", "type", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabMyPostFragment
 * JD-Core Version:    0.7.0.1
 */