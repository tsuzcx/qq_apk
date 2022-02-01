package com.tencent.mm.plugin.taskbar.ui.section.e;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/webview/TaskBarSectionOtherViewWebViewHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getDefaultImageRes", "", "data", "getSubtitle", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private MultiTaskInfo LIj;
  private final String TAG;
  
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(264260);
    this.TAG = "TaskBarSectionOtherViewWebViewHelper";
    AppMethodBeat.o(264260);
  }
  
  public final void a(int paramInt, a.b paramb, d paramd)
  {
    AppMethodBeat.i(264268);
    s.u(paramb, "viewHolder");
    s.u(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    this.LIj = ((MultiTaskInfo)paramd.SUd.get(paramInt));
    paramb.mll.setText((CharSequence)((MultiTaskInfo)paramd.SUd.get(paramInt)).gkh().title);
    AppMethodBeat.o(264268);
  }
  
  public final void a(a.b paramb)
  {
    localObject4 = null;
    AppMethodBeat.i(264284);
    s.u(paramb, "viewHolder");
    if (this.LIj == null)
    {
      AppMethodBeat.o(264284);
      return;
    }
    localObject5 = new ghm();
    for (;;)
    {
      try
      {
        localObject1 = this.LIj;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        ((ghm)localObject5).parseFrom((byte[])localObject1);
      }
      finally
      {
        Object localObject1;
        Log.e(this.TAG, "WebMultiTaskData parse failed");
        continue;
        localObject5 = localObject2.gkh();
        Object localObject3 = localObject4;
        if (localObject5 == null) {
          continue;
        }
        localObject3 = ((drz)localObject5).aaXP;
        continue;
        continue;
      }
      localObject1 = ((ghm)localObject5).coverUrl;
      if (localObject1 != null) {
        continue;
      }
      localObject1 = this.LIj;
      if (localObject1 != null) {
        continue;
      }
      localObject1 = localObject4;
      if (localObject1 != null) {
        r.bKe().a((String)localObject1, paramb.Fjt, e.SQv);
      }
      AppMethodBeat.o(264284);
      return;
      localObject1 = ((MultiTaskInfo)localObject1).field_data;
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264275);
    paramMultiTaskInfo = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), d.g.SQt);
    s.s(paramMultiTaskInfo, "getString(MMApplicationC…section_subtitle_webview)");
    AppMethodBeat.o(264275);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264289);
    s.u(paramMultiTaskInfo, "data");
    int i = d.c.SPE;
    AppMethodBeat.o(264289);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.e.a
 * JD-Core Version:    0.7.0.1
 */