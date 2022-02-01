package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.aa.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineLoadingPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "context", "Landroid/content/Context;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "hideLoading", "", "showLoading", "res", "", "(Ljava/lang/Integer;)V", "plugin-vlog_release"})
public final class i
  extends a
{
  private d APl;
  private final String TAG;
  Context context;
  private s oTk;
  
  public i(Context paramContext, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(226123);
    this.context = paramContext;
    this.APl = paramd;
    this.TAG = "MicroMsg.TimelineLoadingPlugin";
    AppMethodBeat.o(226123);
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(226122);
    Log.i(this.TAG, "hideLoading: ");
    com.tencent.e.h.ZvG.bc((Runnable)new a(this));
    AppMethodBeat.o(226122);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(232179);
      s locals = i.b(this.NEu);
      if (locals != null) {
        locals.dismiss();
      }
      i.a(this.NEu, null);
      AppMethodBeat.o(232179);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(i parami, aa.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(238010);
      i.a(this.NEu, com.tencent.mm.ui.base.h.a(this.NEu.context, (String)this.NEv.aaBC, false, null));
      AppMethodBeat.o(238010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.i
 * JD-Core Version:    0.7.0.1
 */