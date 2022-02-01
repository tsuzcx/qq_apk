package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isPlaying", "", "listeners", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "statusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "statusIcon$delegate", "useOperatePlaying", "addPlayStatusListener", "", "listener", "needPlay", "onPause", "onResume", "removePlayStatusListener", "reset", "showPauseStatus", "showPlayStatus", "syncOperatePlaying", "PlayStatusListener", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final j ATU;
  private final j Ujb;
  public boolean Ujc;
  public boolean hLy;
  private final List<a> listeners;
  ViewGroup parent;
  
  public t(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282449);
    this.parent = paramViewGroup;
    this.ATU = k.cm((kotlin.g.a.a)new b(this));
    this.Ujb = k.cm((kotlin.g.a.a)new c(this));
    this.hLy = true;
    this.Ujc = this.hLy;
    this.listeners = ((List)new ArrayList());
    hTq().setOnClickListener(new t..ExternalSyntheticLambda0(this, parama));
    AppMethodBeat.o(282449);
  }
  
  private static final void a(t paramt, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, View paramView)
  {
    AppMethodBeat.i(282473);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramt);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramt, "this$0");
    s.u(parama, "$status");
    if (paramt.hLy) {
      paramt.hTs();
    }
    for (paramView = a.c.NOL;; paramView = a.c.NOM)
    {
      paramt.Ujc = paramt.hLy;
      paramt = new Bundle();
      paramt.putBoolean("PARAM_1_BOOLEAN", true);
      parama.a(paramView, paramt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282473);
      return;
      paramt.hTr();
    }
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(282457);
    Context localContext = (Context)this.ATU.getValue();
    AppMethodBeat.o(282457);
    return localContext;
  }
  
  private final WeImageView hTq()
  {
    AppMethodBeat.i(282463);
    WeImageView localWeImageView = (WeImageView)this.Ujb.getValue();
    AppMethodBeat.o(282463);
    return localWeImageView;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(282530);
    s.u(parama, "listener");
    this.listeners.add(parama);
    AppMethodBeat.o(282530);
  }
  
  public final void hTr()
  {
    AppMethodBeat.i(282501);
    hTq().setImageDrawable(bb.m(getContext(), a.h.icons_filled_pause, -1));
    this.hLy = true;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPlay();
    }
    AppMethodBeat.o(282501);
  }
  
  public final void hTs()
  {
    AppMethodBeat.i(282513);
    hTq().setImageDrawable(bb.m(getContext(), a.h.icons_filled_play, -1));
    this.hLy = false;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPause();
    }
    AppMethodBeat.o(282513);
  }
  
  public final void hTt()
  {
    this.Ujc = this.hLy;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(282547);
    super.onPause();
    hTs();
    a.b.a(this.GrC, a.c.NOL);
    AppMethodBeat.o(282547);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(282538);
    super.onResume();
    if (this.Ujc)
    {
      hTr();
      a.b.a(this.GrC, a.c.NOM);
    }
    AppMethodBeat.o(282538);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282554);
    super.reset();
    hTr();
    AppMethodBeat.o(282554);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "", "onVideoPause", "", "onVideoPlay", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Context>
  {
    b(t paramt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    c(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.t
 * JD-Core Version:    0.7.0.1
 */