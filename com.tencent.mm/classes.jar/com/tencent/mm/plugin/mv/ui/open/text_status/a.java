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
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.mv.ui.adapter.MusicLyricLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "currentIndex", "", "currentTime", "itemClick", "com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager$itemClick$1;", "lyricLines", "Ljava/util/ArrayList;", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "lyricRV", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getLyricRV", "()Landroidx/recyclerview/widget/RecyclerView;", "lyricRV$delegate", "Lkotlin/Lazy;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "getRootView", "()Landroid/view/View;", "onBackPressed", "", "onCreate", "", "onDestroy", "onPause", "onResume", "parseLyric", "lyric", "setCurrentTime", "currentPos", "setSongInfo", "Companion", "plugin-mv_release"})
public final class a
{
  public static final a.a GgT;
  public final d.a FOE;
  public e FTB;
  private final f GgQ;
  public final ArrayList<String> GgR;
  private final b GgS;
  private final Context context;
  private int currentIndex;
  private int currentTime;
  final View oFW;
  
  static
  {
    AppMethodBeat.i(226049);
    GgT = new a.a((byte)0);
    AppMethodBeat.o(226049);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(226048);
    this.context = paramContext;
    this.oFW = paramView;
    this.GgQ = g.ar((kotlin.g.a.a)new c(this));
    this.GgR = new ArrayList();
    this.currentIndex = -1;
    this.GgS = new b();
    this.FOE = ((d.a)new d(this));
    AppMethodBeat.o(226048);
  }
  
  private final RecyclerView fgH()
  {
    AppMethodBeat.i(226036);
    RecyclerView localRecyclerView = (RecyclerView)this.GgQ.getValue();
    AppMethodBeat.o(226036);
    return localRecyclerView;
  }
  
  public final void aSK(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(226043);
    if (paramString != null)
    {
      int i;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label157;
        }
        label29:
        if (paramString == null) {
          break label349;
        }
        this.GgR.clear();
        if (paramString != null)
        {
          localObject1 = e.a(paramString, "", "", true, "", false, false);
          p.j(localObject1, "obj");
          if (((e)localObject1).feO() <= 1) {
            break label162;
          }
        }
      }
      Object localObject2;
      for (;;)
      {
        this.FTB = ((e)localObject1);
        e locale = this.FTB;
        if (locale == null) {
          break label168;
        }
        int k = locale.feO();
        i = j;
        while (i < k)
        {
          ArrayList localArrayList = this.GgR;
          localObject2 = locale.Zm(i).content;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localArrayList.add(localObject1);
          i += 1;
        }
        i = 0;
        break;
        label157:
        paramString = null;
        break label29;
        label162:
        localObject1 = null;
      }
      label168:
      Object localObject1 = fgH();
      p.j(localObject1, "lyricRV");
      if ((com.tencent.mm.plugin.mv.ui.adapter.a)((RecyclerView)localObject1).getAdapter() == null)
      {
        localObject1 = fgH();
        p.j(localObject1, "lyricRV");
        localObject2 = new com.tencent.mm.plugin.mv.ui.adapter.a((com.tencent.mm.plugin.mv.ui.adapter.a.b)this.GgS);
        ((com.tencent.mm.plugin.mv.ui.adapter.a)localObject2).gg((List)this.GgR);
        ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      }
      paramString = new StringBuilder("setSongInfo, lyric.length:").append(paramString.length()).append(", lyricLine.size:").append(this.GgR.size()).append(", lyricRv-Visisble:");
      localObject1 = fgH();
      p.j(localObject1, "lyricRV");
      paramString = paramString.append(((RecyclerView)localObject1).getVisibility()).append(", lyricRv.alpha:");
      localObject1 = fgH();
      p.j(localObject1, "lyricRV");
      Log.i("MicroMsg.Mv.MusicMvLyric", ((RecyclerView)localObject1).getAlpha());
      AppMethodBeat.o(226043);
      return;
    }
    label349:
    AppMethodBeat.o(226043);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(293125);
    Log.i("MicroMsg.Mv.MusicMvLyric", "onCreate");
    Object localObject = fgH();
    p.j(localObject, "lyricRV");
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new MusicLyricLayoutManager(this.context, (byte)0));
    localObject = fgH();
    p.j(localObject, "lyricRV");
    localObject = (ViewGroup.MarginLayoutParams)((RecyclerView)localObject).getLayoutParams();
    if (localObject != null)
    {
      Resources localResources = this.context.getResources();
      p.j(localResources, "context.resources");
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(localResources.getDisplayMetrics().heightPixels * 0.37F - com.tencent.mm.ci.a.fromDPToPix(this.context, 15)));
    }
    localObject = k.fet();
    p.j(localObject, "MusicPlayerManager.Instance()");
    ((k)localObject).feg().a(this.FOE);
    AppMethodBeat.o(293125);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/open/text_status/MusicMvLyricManager$itemClick$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "onClick", "", "position", "", "plugin-mv_release"})
  public static final class b
    implements com.tencent.mm.plugin.mv.ui.adapter.a.b
  {
    public final void dkT() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class d
    implements d.a
  {
    d(a parama) {}
    
    public final void fK(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(229501);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(229501);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.open.text_status.a
 * JD-Core Version:    0.7.0.1
 */