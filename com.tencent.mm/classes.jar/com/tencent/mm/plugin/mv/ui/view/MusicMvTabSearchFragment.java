package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "continueFlag", "finderPullType", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "requestId", "", "searchOffset", "getFeedFrom", "getType", "initSearch", "", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "keyword", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "syncGetFeeds", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvTabSearchFragment
  extends MusicMvTabFragment
  implements com.tencent.mm.am.h
{
  public static final MusicMvTabSearchFragment.a MjY;
  private int MjZ;
  private int Mka;
  private int continueFlag;
  private String hOG;
  private b lastBuffer;
  
  static
  {
    AppMethodBeat.i(287202);
    MjY = new MusicMvTabSearchFragment.a((byte)0);
    AppMethodBeat.o(287202);
  }
  
  public MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287189);
    AppMethodBeat.o(287189);
  }
  
  public MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287193);
    AppMethodBeat.o(287193);
  }
  
  private MusicMvTabSearchFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(287199);
    com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287199);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    AppMethodBeat.i(287216);
    super.a(parama, paramString);
    if (this.hOG == null) {
      this.hOG = UUID.randomUUID().toString();
    }
    String str = this.hOG;
    int i;
    if ((str != null) && (paramString != null))
    {
      if (((CharSequence)paramString).length() <= 0) {
        break label134;
      }
      i = 1;
      if (i == 0) {
        break label139;
      }
    }
    label134:
    label139:
    for (parama = paramString;; parama = null)
    {
      if (parama != null)
      {
        paramString = new bui();
        paramString.AJo = 93;
        com.tencent.mm.kernel.h.aZW().a((p)new dk(parama, this.MjZ, str, this.lastBuffer, 12, paramString, null, null, 448), 0);
        paramString = m.LYc;
        m.kB(parama, "");
      }
      AppMethodBeat.o(287216);
      return;
      i = 0;
      break;
    }
  }
  
  public final void aPI(String paramString)
  {
    AppMethodBeat.i(287210);
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
    if (localObject == null) {}
    for (localObject = null;; localObject = (TextView)((View)localObject).findViewById(a.g.load_more_footer_tip_tv))
    {
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      this.hOG = UUID.randomUUID().toString();
      this.lastBuffer = null;
      this.MjZ = 0;
      getDataList().clear();
      a(null, paramString);
      AppMethodBeat.o(287210);
      return;
    }
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
    AppMethodBeat.i(287206);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(287206);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(287222);
    if ((paramp instanceof dk))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.lastBuffer = ((dk)paramp).ADk.BgS;
        this.Mka = 2;
        paramString = ((dk)paramp).ADk;
        this.MjZ = paramString.offset;
        this.continueFlag = paramString.continueFlag;
        if (this.continueFlag != 0) {}
        for (boolean bool = true;; bool = false)
        {
          setHasMore(bool);
          paramString = paramString.AdW.iterator();
          while (paramString.hasNext())
          {
            paramp = (FinderObject)paramString.next();
            if (paramp != null)
            {
              Object localObject = com.tencent.mm.plugin.mv.ui.a.Maz;
              com.tencent.mm.plugin.mv.ui.a.R(paramp);
              long l = paramp.id;
              localObject = paramp.objectNonceId;
              if (!getFeedIdMap().contains(Long.valueOf(l))) {
                getDataList().add(new MusicMvTabFragment.d(new MusicMvTabFragment.f(l, (String)localObject, paramp, (byte)0)));
              }
            }
          }
        }
        getAdapter().bZE.notifyChanged();
        paramString = getOnSceneEndListener();
        if (paramString != null) {
          paramString.invoke();
        }
        Log.i("Music.MusicMvTabFragment", kotlin.g.b.s.X("onSceneEnd BGFinderFeed ", Integer.valueOf(getDataList().size())));
      }
      getRlLayout().aFW(0);
      paramString = getResultListener();
      if (paramString != null) {
        paramString.kg(4, getAdapter().getItemCount());
      }
    }
    AppMethodBeat.o(287222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabSearchFragment
 * JD-Core Version:    0.7.0.1
 */