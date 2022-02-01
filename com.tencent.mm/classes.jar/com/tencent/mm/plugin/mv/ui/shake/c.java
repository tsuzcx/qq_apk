package com.tencent.mm.plugin.mv.ui.shake;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricManager;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "topMargin", "", "type", "(Landroid/content/Context;Landroid/view/View;II)V", "begin", "getBegin", "()I", "setBegin", "(I)V", "getContext", "()Landroid/content/Context;", "currentIndex", "currentTime", "itemClick", "com/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricManager$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricManager$itemClick$1;", "lyricLines", "Ljava/util/ArrayList;", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRV", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getLyricRV", "()Landroidx/recyclerview/widget/RecyclerView;", "lyricRV$delegate", "Lkotlin/Lazy;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "getRootView", "()Landroid/view/View;", "getTopMargin", "getType", "onBackPressed", "", "onCreate", "", "onDestroy", "onPause", "onResume", "outsideSetCurrentTime", "currentPos", "parseLyric", "lyric", "setCurrentTime", "setSongInfo", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a McQ;
  final d.a LJz;
  e LOA;
  private final b McR;
  private final kotlin.j Mcb;
  final ArrayList<String> Mcc;
  int begin;
  private final int bmv;
  private final Context context;
  private int currentIndex;
  private int currentTime;
  final View rootView;
  private final int type;
  
  static
  {
    AppMethodBeat.i(287394);
    McQ = new c.a((byte)0);
    AppMethodBeat.o(287394);
  }
  
  public c(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287349);
    this.context = paramContext;
    this.rootView = paramView;
    this.bmv = paramInt1;
    this.type = paramInt2;
    this.Mcb = k.cm((a)new c(this));
    this.Mcc = new ArrayList();
    this.currentIndex = -1;
    this.McR = new b();
    this.LJz = new c..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(287349);
  }
  
  private static final void a(final c paramc, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(287371);
    s.u(paramc, "this$0");
    com.tencent.mm.ae.d.uiThread((a)new e(paramInt1, paramInt2, paramc));
    AppMethodBeat.o(287371);
  }
  
  private final void aPF(String paramString)
  {
    AppMethodBeat.i(287364);
    if (paramString != null)
    {
      paramString = e.a(paramString, "", "", true, "", false, false);
      if (paramString.LMm.size() <= 1) {
        break label50;
      }
    }
    for (;;)
    {
      this.LOA = paramString;
      AppMethodBeat.o(287364);
      return;
      label50:
      paramString = null;
    }
  }
  
  private final RecyclerView gqn()
  {
    AppMethodBeat.i(287354);
    RecyclerView localRecyclerView = (RecyclerView)this.Mcb.getValue();
    AppMethodBeat.o(287354);
    return localRecyclerView;
  }
  
  public final void aPE(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(287418);
    int i;
    if (paramString != null)
    {
      if (((CharSequence)paramString).length() <= 0) {
        break label272;
      }
      i = 1;
      if (i == 0) {
        break label277;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        this.Mcc.clear();
        aPF(paramString);
        Object localObject3 = this.LOA;
        Object localObject2;
        Object localObject1;
        if (localObject3 != null)
        {
          int k = ((e)localObject3).LMm.size();
          if (k > 0)
          {
            i = j;
            do
            {
              j = i + 1;
              ArrayList localArrayList = this.Mcc;
              localObject2 = ((e)localObject3).adz(i).content;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localArrayList.add(localObject1);
              i = j;
            } while (j < k);
          }
        }
        if ((b)gqn().getAdapter() == null)
        {
          localObject1 = gqn();
          localObject2 = new b((b.b)this.McR, this.type);
          ((b)localObject2).hM((List)this.Mcc);
          localObject3 = ah.aiuX;
          ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
        }
        Log.i("MicroMsg.Mv.MusicMvLyric", "setSongInfo, lyric.length:" + paramString.length() + ", lyricLine.size:" + this.Mcc.size() + ", lyricRv-Visisble:" + gqn().getVisibility() + ", lyricRv.alpha:" + gqn().getAlpha());
      }
      AppMethodBeat.o(287418);
      return;
      label272:
      i = 0;
      break;
      label277:
      paramString = null;
    }
  }
  
  public final void aeb(final int paramInt)
  {
    AppMethodBeat.i(287422);
    this.begin = paramInt;
    com.tencent.mm.ae.d.uiThread((a)new d(this, paramInt));
    AppMethodBeat.o(287422);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(287409);
    Log.i("MicroMsg.Mv.MusicMvLyric", "onCreate");
    if (this.type == 0) {
      gqn().setLayoutManager((RecyclerView.LayoutManager)new MusicShakeLyricLayoutManager(this.context, (byte)0));
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)gqn().getLayoutParams();
      if (localMarginLayoutParams != null) {
        localMarginLayoutParams.topMargin = this.bmv;
      }
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().a(this.LJz);
      AppMethodBeat.o(287409);
      return;
      gqn().setLayoutManager((RecyclerView.LayoutManager)new MusicBlackLyricLayoutManager(this.context, (byte)0));
      gqn().getRecycledViewPool().bD(0, 0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(287412);
    Log.i("MicroMsg.Mv.MusicMvLyric", "onPause");
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().b(this.LJz);
    AppMethodBeat.o(287412);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricManager$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/shake/MusicShakeLyricAdapter$OnItemClickListener;", "onClick", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.b
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<RecyclerView>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(int paramInt1, int paramInt2, c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.c
 * JD-Core Version:    0.7.0.1
 */