package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isPlaying", "", "listeners", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "statusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "statusIcon$delegate", "useOperatePlaying", "addPlayStatusListener", "", "listener", "needPlay", "onPause", "onResume", "removePlayStatusListener", "reset", "showPauseStatus", "showPlayStatus", "syncOperatePlaying", "PlayStatusListener", "plugin-vlog_release"})
public final class u
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  d APl;
  private final f NvO;
  public boolean NvP;
  public boolean fGh;
  private final List<a> listeners;
  ViewGroup parent;
  private final f xwp;
  
  public u(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(245374);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.xwp = g.ar((kotlin.g.a.a)new b(this));
    this.NvO = g.ar((kotlin.g.a.a)new c(this));
    this.fGh = true;
    this.NvP = this.fGh;
    this.listeners = ((List)new ArrayList());
    gvB().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(224396);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if (u.a(this.NvQ)) {
          this.NvQ.gvD();
        }
        for (paramAnonymousView = d.c.HSf;; paramAnonymousView = d.c.HSg)
        {
          u.a(this.NvQ, u.a(this.NvQ));
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", true);
          this.NvQ.APl.a(paramAnonymousView, (Bundle)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(224396);
          return;
          this.NvQ.gvC();
        }
      }
    });
    AppMethodBeat.o(245374);
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(245361);
    Context localContext = (Context)this.xwp.getValue();
    AppMethodBeat.o(245361);
    return localContext;
  }
  
  private final WeImageView gvB()
  {
    AppMethodBeat.i(245363);
    WeImageView localWeImageView = (WeImageView)this.NvO.getValue();
    AppMethodBeat.o(245363);
    return localWeImageView;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(245369);
    p.k(parama, "listener");
    this.listeners.add(parama);
    AppMethodBeat.o(245369);
  }
  
  public final void gvC()
  {
    AppMethodBeat.i(245365);
    gvB().setImageDrawable(au.o(getContext(), a.h.icons_filled_pause, -1));
    this.fGh = true;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPlay();
    }
    AppMethodBeat.o(245365);
  }
  
  public final void gvD()
  {
    AppMethodBeat.i(245366);
    gvB().setImageDrawable(au.o(getContext(), a.h.icons_filled_play, -1));
    this.fGh = false;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPause();
    }
    AppMethodBeat.o(245366);
  }
  
  public final void gvE()
  {
    this.NvP = this.fGh;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245372);
    super.onPause();
    gvD();
    d.b.a(this.APl, d.c.HSf);
    AppMethodBeat.o(245372);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245370);
    super.onResume();
    if (this.NvP)
    {
      gvC();
      d.b.a(this.APl, d.c.HSg);
    }
    AppMethodBeat.o(245370);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(245373);
    super.reset();
    gvC();
    AppMethodBeat.o(245373);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "", "onVideoPause", "", "onVideoPlay", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Context>
  {
    b(u paramu)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    c(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.u
 * JD-Core Version:    0.7.0.1
 */