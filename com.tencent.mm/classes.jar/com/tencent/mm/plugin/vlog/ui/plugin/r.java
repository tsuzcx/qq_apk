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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isPlaying", "", "listeners", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "statusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "statusIcon$delegate", "useOperatePlaying", "addPlayStatusListener", "", "listener", "needPlay", "onPause", "onResume", "removePlayStatusListener", "showPauseStatus", "showPlayStatus", "PlayStatusListener", "plugin-vlog_release"})
public final class r
  implements t
{
  private final f BNK;
  boolean BNL;
  ViewGroup gqv;
  boolean lQV;
  public final List<a> listeners;
  private final f rUo;
  d sQE;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(196305);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    this.rUo = g.O((d.g.a.a)new b(this));
    this.BNK = g.O((d.g.a.a)new c(this));
    this.lQV = true;
    this.BNL = this.lQV;
    this.listeners = ((List)new ArrayList());
    etw().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196296);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (this.BNM.lQV) {
          this.BNM.ety();
        }
        for (paramAnonymousView = d.c.xES;; paramAnonymousView = d.c.xET)
        {
          this.BNM.BNL = this.BNM.lQV;
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", true);
          this.BNM.sQE.a(paramAnonymousView, (Bundle)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196296);
          return;
          this.BNM.etx();
        }
      }
    });
    AppMethodBeat.o(196305);
  }
  
  private final WeImageView etw()
  {
    AppMethodBeat.i(196300);
    WeImageView localWeImageView = (WeImageView)this.BNK.getValue();
    AppMethodBeat.o(196300);
    return localWeImageView;
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(196299);
    Context localContext = (Context)this.rUo.getValue();
    AppMethodBeat.o(196299);
    return localContext;
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void etx()
  {
    AppMethodBeat.i(196301);
    etw().setImageDrawable(ao.k(getContext(), 2131690445, -1));
    this.lQV = true;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPlay();
    }
    AppMethodBeat.o(196301);
  }
  
  public final void ety()
  {
    AppMethodBeat.i(196302);
    etw().setImageDrawable(ao.k(getContext(), 2131690459, -1));
    this.lQV = false;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(196302);
  }
  
  public final boolean etz()
  {
    return this.BNL;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(196304);
    ety();
    d.b.a(this.sQE, d.c.xES);
    AppMethodBeat.o(196304);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196306);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196306);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(196303);
    if (this.BNL)
    {
      etx();
      d.b.a(this.sQE, d.c.xET);
    }
    AppMethodBeat.o(196303);
  }
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "", "onVideoPause", "", "onVideoPlay", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void onVideoPlay();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Context>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<WeImageView>
  {
    c(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.r
 * JD-Core Version:    0.7.0.1
 */