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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "isPlaying", "", "listeners", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "statusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "statusIcon$delegate", "useOperatePlaying", "addPlayStatusListener", "", "listener", "needPlay", "onPause", "onResume", "removePlayStatusListener", "showPauseStatus", "showPlayStatus", "PlayStatusListener", "plugin-vlog_release"})
public final class r
  implements t
{
  private final f Cfj;
  boolean Cfk;
  ViewGroup gsV;
  boolean lVw;
  public final List<a> listeners;
  private final f scS;
  d tbP;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191764);
    this.gsV = paramViewGroup;
    this.tbP = paramd;
    this.scS = g.O((d.g.a.a)new b(this));
    this.Cfj = g.O((d.g.a.a)new c(this));
    this.lVw = true;
    this.Cfk = this.lVw;
    this.listeners = ((List)new ArrayList());
    exd().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191755);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (this.Cfl.lVw) {
          this.Cfl.exf();
        }
        for (paramAnonymousView = d.c.xUN;; paramAnonymousView = d.c.xUO)
        {
          this.Cfl.Cfk = this.Cfl.lVw;
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", true);
          this.Cfl.tbP.a(paramAnonymousView, (Bundle)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191755);
          return;
          this.Cfl.exe();
        }
      }
    });
    AppMethodBeat.o(191764);
  }
  
  private final WeImageView exd()
  {
    AppMethodBeat.i(191759);
    WeImageView localWeImageView = (WeImageView)this.Cfj.getValue();
    AppMethodBeat.o(191759);
    return localWeImageView;
  }
  
  private final Context getContext()
  {
    AppMethodBeat.i(191758);
    Context localContext = (Context)this.scS.getValue();
    AppMethodBeat.o(191758);
    return localContext;
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final void exe()
  {
    AppMethodBeat.i(191760);
    exd().setImageDrawable(ao.k(getContext(), 2131690445, -1));
    this.lVw = true;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onVideoPlay();
    }
    AppMethodBeat.o(191760);
  }
  
  public final void exf()
  {
    AppMethodBeat.i(191761);
    exd().setImageDrawable(ao.k(getContext(), 2131690459, -1));
    this.lVw = false;
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(191761);
  }
  
  public final boolean exg()
  {
    return this.Cfk;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(191763);
    exf();
    d.b.a(this.tbP, d.c.xUN);
    AppMethodBeat.o(191763);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191765);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191765);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(191762);
    if (this.Cfk)
    {
      exe();
      d.b.a(this.tbP, d.c.xUO);
    }
    AppMethodBeat.o(191762);
  }
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "", "onVideoPause", "", "onVideoPlay", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void onVideoPlay();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Context>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
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