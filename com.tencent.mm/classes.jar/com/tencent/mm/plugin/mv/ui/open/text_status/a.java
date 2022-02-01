package com.tencent.mm.plugin.mv.ui.open.text_status;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "currentIndex", "", "currentTime", "itemClick", "com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager$itemClick$1;", "lyricLines", "Ljava/util/ArrayList;", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRV", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getLyricRV", "()Landroidx/recyclerview/widget/RecyclerView;", "lyricRV$delegate", "Lkotlin/Lazy;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "getRootView", "()Landroid/view/View;", "onBackPressed", "", "onCreate", "", "onDestroy", "onPause", "onResume", "parseLyric", "lyric", "setCurrentTime", "currentPos", "setSongInfo", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a Mca;
  public final d.a LJz;
  public e LOA;
  private final kotlin.j Mcb;
  public final ArrayList<String> Mcc;
  private final b Mcd;
  private final Context context;
  private int currentIndex;
  private int currentTime;
  final View rootView;
  
  static
  {
    AppMethodBeat.i(286593);
    Mca = new a.a((byte)0);
    AppMethodBeat.o(286593);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(286562);
    this.context = paramContext;
    this.rootView = paramView;
    this.Mcb = k.cm((kotlin.g.a.a)new c(this));
    this.Mcc = new ArrayList();
    this.currentIndex = -1;
    this.Mcd = new b();
    this.LJz = new a..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(286562);
  }
  
  private static final void a(final a parama, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(286575);
    s.u(parama, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramInt1, paramInt2, parama));
    AppMethodBeat.o(286575);
  }
  
  private final RecyclerView gqn()
  {
    AppMethodBeat.i(286568);
    RecyclerView localRecyclerView = (RecyclerView)this.Mcb.getValue();
    AppMethodBeat.o(286568);
    return localRecyclerView;
  }
  
  public final void aPE(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(286640);
    label29:
    Object localObject1;
    label71:
    Object localObject3;
    int k;
    if (paramString != null)
    {
      if (((CharSequence)paramString).length() <= 0) {
        break label295;
      }
      i = 1;
      if (i == 0) {
        break label300;
      }
      if (paramString != null)
      {
        this.Mcc.clear();
        if (paramString != null)
        {
          localObject1 = e.a(paramString, "", "", true, "", false, false);
          if (((e)localObject1).LMm.size() <= 1) {
            break label305;
          }
          this.LOA = ((e)localObject1);
        }
        localObject3 = this.LOA;
        if (localObject3 != null)
        {
          k = ((e)localObject3).LMm.size();
          if (k <= 0) {}
        }
      }
    }
    for (int i = j;; i = j)
    {
      j = i + 1;
      ArrayList localArrayList = this.Mcc;
      Object localObject2 = ((e)localObject3).adz(i).content;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localArrayList.add(localObject1);
      if (j >= k)
      {
        if ((com.tencent.mm.plugin.mv.ui.adapter.a)gqn().getAdapter() == null)
        {
          localObject1 = gqn();
          localObject2 = new com.tencent.mm.plugin.mv.ui.adapter.a((com.tencent.mm.plugin.mv.ui.adapter.a.b)this.Mcd);
          ((com.tencent.mm.plugin.mv.ui.adapter.a)localObject2).hM((List)this.Mcc);
          localObject3 = ah.aiuX;
          ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
        }
        Log.i("MicroMsg.Mv.MusicMvLyric", "setSongInfo, lyric.length:" + paramString.length() + ", lyricLine.size:" + this.Mcc.size() + ", lyricRv-Visisble:" + gqn().getVisibility() + ", lyricRv.alpha:" + gqn().getAlpha());
        AppMethodBeat.o(286640);
        return;
        label295:
        i = 0;
        break;
        label300:
        paramString = null;
        break label29;
        label305:
        localObject1 = null;
        break label71;
      }
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(286610);
    Log.i("MicroMsg.Mv.MusicMvLyric", "onCreate");
    gqn().setLayoutManager((RecyclerView.LayoutManager)new MusicLyricLayoutManager(this.context, (byte)0));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)gqn().getLayoutParams();
    if (localMarginLayoutParams != null) {
      localMarginLayoutParams.topMargin = ((int)(this.context.getResources().getDisplayMetrics().heightPixels * 0.37F - com.tencent.mm.cd.a.fromDPToPix(this.context, 15)));
    }
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().a(this.LJz);
    AppMethodBeat.o(286610);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286627);
    Log.i("MicroMsg.Mv.MusicMvLyric", "onPause");
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().b(this.LJz);
    AppMethodBeat.o(286627);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286619);
    Log.i("MicroMsg.Mv.MusicMvLyric", "onResume");
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().a(this.LJz);
    AppMethodBeat.o(286619);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "onClick", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.mv.ui.adapter.a.b
  {
    public final void dRJ() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(int paramInt1, int paramInt2, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.open.text_status.a
 * JD-Core Version:    0.7.0.1
 */