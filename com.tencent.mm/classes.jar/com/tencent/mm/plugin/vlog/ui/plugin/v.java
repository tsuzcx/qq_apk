package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isPlaying", "", "listeners", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "statusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "statusIcon$delegate", "useOperatePlaying", "addPlayStatusListener", "", "listener", "needPlay", "onPause", "onResume", "removePlayStatusListener", "showPauseStatus", "showPlayStatus", "syncOperatePlaying", "PlayStatusListener", "plugin-vlog_release"})
public final class v
  implements t
{
  private final f GIa;
  public boolean GIb;
  boolean gVd;
  private final List<a> listeners;
  ViewGroup parent;
  private final f tMy;
  d wgr;
  
  public v(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191429);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    this.tMy = g.ah((kotlin.g.a.a)new b(this));
    this.GIa = g.ah((kotlin.g.a.a)new c(this));
    this.gVd = true;
    this.GIb = this.gVd;
    this.listeners = ((List)new ArrayList());
    fDD().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191419);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (this.GIc.gVd) {
          this.GIc.fDF();
        }
        for (paramAnonymousView = d.c.BVr;; paramAnonymousView = d.c.BVs)
        {
          this.GIc.GIb = this.GIc.gVd;
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", true);
          this.GIc.wgr.a(paramAnonymousView, (Bundle)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191419);
          return;
          this.GIc.fDE();
        }
      }
    });
    AppMethodBeat.o(191429);
  }
  
  private final WeImageView fDD()
  {
    AppMethodBeat.i(191423);
    WeImageView localWeImageView = (WeImageView)this.GIa.getValue();
    AppMethodBeat.o(191423);
    return localWeImageView;
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(191422);
    Context localContext = (Context)this.tMy.getValue();
    AppMethodBeat.o(191422);
    return localContext;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(191426);
    p.h(parama, "listener");
    this.listeners.add(parama);
    AppMethodBeat.o(191426);
  }
  
  public final void aSs() {}
  
  public final void fDE()
  {
    AppMethodBeat.i(191424);
    fDD().setImageDrawable(ar.m(getContext(), 2131690631, -1));
    this.gVd = true;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPlay();
    }
    AppMethodBeat.o(191424);
  }
  
  public final void fDF()
  {
    AppMethodBeat.i(191425);
    fDD().setImageDrawable(ar.m(getContext(), 2131690647, -1));
    this.gVd = false;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPause();
    }
    AppMethodBeat.o(191425);
  }
  
  public final void fDG()
  {
    this.GIb = this.gVd;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(191428);
    fDF();
    d.b.a(this.wgr, d.c.BVr);
    AppMethodBeat.o(191428);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191430);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191430);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(191427);
    if (this.GIb)
    {
      fDE();
      d.b.a(this.wgr, d.c.BVs);
    }
    AppMethodBeat.o(191427);
  }
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "", "onVideoPause", "", "onVideoPlay", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Context>
  {
    b(v paramv)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    c(v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.v
 * JD-Core Version:    0.7.0.1
 */