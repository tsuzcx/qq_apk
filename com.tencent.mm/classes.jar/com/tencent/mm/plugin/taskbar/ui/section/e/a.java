package com.tencent.mm.plugin.taskbar.ui.section.e;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/webview/TaskBarSectionOtherViewWebViewHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getDefaultImageRes", "", "data", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a
  extends b
{
  private MultiTaskInfo FNi;
  
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(215026);
    AppMethodBeat.o(215026);
  }
  
  public final void a(int paramInt, a.b paramb, d paramd)
  {
    AppMethodBeat.i(215016);
    p.k(paramb, "viewHolder");
    p.k(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    Object localObject = paramd.MqV.get(paramInt);
    if (localObject == null)
    {
      paramb = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.model.MultiTaskInfo");
      AppMethodBeat.o(215016);
      throw paramb;
    }
    this.FNi = ((MultiTaskInfo)localObject);
    paramb = paramb.jMg;
    p.j(paramb, "viewHolder.title");
    paramb.setText((CharSequence)((MultiTaskInfo)paramd.MqV.get(paramInt)).fbc().title);
    AppMethodBeat.o(215016);
  }
  
  public final void a(a.b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(215020);
    p.k(paramb, "viewHolder");
    if (this.FNi == null)
    {
      AppMethodBeat.o(215020);
      return;
    }
    Object localObject3 = new fky();
    try
    {
      localObject1 = this.FNi;
      if (localObject1 == null) {
        break label123;
      }
      localObject1 = ((MultiTaskInfo)localObject1).field_data;
      ((fky)localObject3).parseFrom((byte[])localObject1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("AppBrandDesktopSectionWebViewView", "WebMultiTaskData parse failed");
      }
      AppMethodBeat.o(215020);
      return;
    }
    localObject1 = ((fky)localObject3).coverUrl;
    if (localObject1 == null)
    {
      localObject3 = this.FNi;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((MultiTaskInfo)localObject3).fbc();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((dar)localObject3).TIg;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        q.bml().a((String)localObject1, paramb.image, e.Mnc);
        AppMethodBeat.o(215020);
        return;
        label123:
        localObject1 = null;
        break;
      }
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(215018);
    paramMultiTaskInfo = com.tencent.mm.ci.a.ba(MMApplicationContext.getContext(), d.g.Mna);
    p.j(paramMultiTaskInfo, "ResourceHelper.getString…section_subtitle_webview)");
    AppMethodBeat.o(215018);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(215022);
    p.k(paramMultiTaskInfo, "data");
    int i = d.c.Mmo;
    AppMethodBeat.o(215022);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.e.a
 * JD-Core Version:    0.7.0.1
 */