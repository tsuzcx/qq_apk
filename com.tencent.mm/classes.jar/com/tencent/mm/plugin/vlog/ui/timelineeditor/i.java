package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.h;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineLoadingPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "context", "Landroid/content/Context;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "hideLoading", "", "showLoading", "res", "", "(Ljava/lang/Integer;)V", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final String TAG;
  private Context context;
  private w rYw;
  
  public i(Context paramContext, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282236);
    this.context = paramContext;
    this.TAG = "MicroMsg.TimelineLoadingPlugin";
    AppMethodBeat.o(282236);
  }
  
  private static final void a(i parami, ah.f paramf)
  {
    AppMethodBeat.i(282252);
    s.u(parami, "this$0");
    s.u(paramf, "$tipStr");
    parami.rYw = k.a(parami.context, (String)paramf.aqH, false, null);
    AppMethodBeat.o(282252);
  }
  
  private static final void b(i parami)
  {
    AppMethodBeat.i(282261);
    s.u(parami, "this$0");
    w localw = parami.rYw;
    if (localw != null) {
      localw.dismiss();
    }
    parami.rYw = null;
    AppMethodBeat.o(282261);
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(282287);
    Log.i(this.TAG, "hideLoading: ");
    h.ahAA.bk(new i..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(282287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.i
 * JD-Core Version:    0.7.0.1
 */