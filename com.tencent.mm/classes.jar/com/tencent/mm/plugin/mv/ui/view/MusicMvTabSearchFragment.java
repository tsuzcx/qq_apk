package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "continueFlag", "finderPullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "requestId", "", "searchOffset", "getFeedFrom", "initSearch", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "keyword", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "Companion", "plugin-mv_release"})
public final class MusicMvTabSearchFragment
  extends MusicMvTabFragment
  implements i
{
  public static final a Azs;
  private int Azq;
  private int Azr;
  private HashMap _$_findViewCache;
  private int continueFlag;
  private String dPI;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(257723);
    Azs = new a((byte)0);
    AppMethodBeat.o(257723);
  }
  
  public MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(257720);
    AppMethodBeat.o(257720);
  }
  
  public MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257721);
    AppMethodBeat.o(257721);
  }
  
  private MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(257722);
    g.azz().a(3820, (i)this);
    AppMethodBeat.o(257722);
  }
  
  public final void a(a parama, String paramString)
  {
    AppMethodBeat.i(257718);
    super.a(parama, paramString);
    if (this.dPI == null) {
      this.dPI = UUID.randomUUID().toString();
    }
    String str = this.dPI;
    if (str != null)
    {
      if (paramString != null)
      {
        int i;
        if (((CharSequence)paramString).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label135;
          }
        }
        label135:
        for (parama = paramString;; parama = null)
        {
          if (parama == null) {
            break label140;
          }
          paramString = new bbn();
          paramString.tCE = 93;
          g.azz().b((q)new cf(parama, this.Azq, str, this.lastBuffer, 12, paramString, 64));
          paramString = com.tencent.mm.plugin.mv.a.l.Uqz;
          com.tencent.mm.plugin.mv.a.l.cC(parama, "");
          AppMethodBeat.o(257718);
          return;
          i = 0;
          break;
        }
      }
      label140:
      AppMethodBeat.o(257718);
      return;
    }
    AppMethodBeat.o(257718);
  }
  
  public final void aIs(String paramString)
  {
    AppMethodBeat.i(257717);
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
      localObject = (TextView)((View)localObject).findViewById(2131303685);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
    }
    this.dPI = UUID.randomUUID().toString();
    this.lastBuffer = null;
    this.Azq = 0;
    getDataList().clear();
    a(null, paramString);
    AppMethodBeat.o(257717);
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(257724);
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
    AppMethodBeat.o(257724);
    return localView1;
  }
  
  public final int getFeedFrom()
  {
    return 7;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257716);
    super.onDestroy();
    g.azz().b(3820, (i)this);
    AppMethodBeat.o(257716);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(257719);
    if ((paramq instanceof cf))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.lastBuffer = ((cf)paramq).twl.tVM;
        this.Azr = 2;
        paramString = ((cf)paramq).twl;
        this.Azq = paramString.offset;
        this.continueFlag = paramString.continueFlag;
        if (this.continueFlag != 0) {}
        for (boolean bool = true;; bool = false)
        {
          setHasMore(bool);
          paramString = paramString.tbD.iterator();
          while (paramString.hasNext())
          {
            paramq = (FinderObject)paramString.next();
            if (paramq != null)
            {
              long l = paramq.id;
              String str = paramq.objectNonceId;
              if (!getFeedIdMap().contains(Long.valueOf(l))) {
                getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, str, paramq)));
              }
            }
          }
        }
        getAdapter().notifyDataSetChanged();
        Log.i("Music.MusicMvTabFragment", "onSceneEnd BGFinderFeed " + getDataList().size());
      }
      getRlLayout().apT(0);
      paramString = getResultListener();
      if (paramString != null)
      {
        paramString.hx(4, getAdapter().getItemCount());
        AppMethodBeat.o(257719);
        return;
      }
    }
    AppMethodBeat.o(257719);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment$Companion;", "", "()V", "type", "", "plugin-mv_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabSearchFragment
 * JD-Core Version:    0.7.0.1
 */