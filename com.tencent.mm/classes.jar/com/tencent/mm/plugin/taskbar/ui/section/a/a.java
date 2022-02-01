package com.tencent.mm.plugin.taskbar.ui.section.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.f;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/file/TaskBarSectionOtherViewFileHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "imageRes", "", "Ljava/lang/Integer;", "getDefaultImageRes", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a
  extends b
{
  private Integer MqZ;
  
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(215621);
    AppMethodBeat.o(215621);
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(int paramInt, a.b paramb, d paramd)
  {
    AppMethodBeat.i(215613);
    p.k(paramb, "viewHolder");
    p.k(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    int i;
    if (((MultiTaskInfo)paramd.MqV.get(paramInt)).field_type == 4)
    {
      i = 1;
      if (i != 0) {
        break label170;
      }
    }
    label170:
    for (Object localObject1 = Integer.valueOf(d.f.float_ball_icon_fav_default);; localObject1 = Integer.valueOf(v.bpJ(((MultiTaskInfo)paramd.MqV.get(paramInt)).fbc().jmx)))
    {
      this.MqZ = ((Integer)localObject1);
      localObject1 = paramb.jMg;
      p.j(localObject1, "viewHolder.title");
      h localh = h.htZ();
      Object localObject2 = paramb.amk;
      p.j(localObject2, "viewHolder.itemView");
      localObject2 = ((View)localObject2).getContext();
      paramd = (CharSequence)((MultiTaskInfo)paramd.MqV.get(paramInt)).fbc().title;
      paramb = paramb.jMg;
      p.j(paramb, "viewHolder.title");
      ((TextView)localObject1).setText((CharSequence)localh.a((Context)localObject2, paramd, paramb.getTextSize()));
      AppMethodBeat.o(215613);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(215618);
    p.k(paramb, "viewHolder");
    paramb.image.setImageBitmap(null);
    AppMethodBeat.o(215618);
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(215615);
    if (paramMultiTaskInfo != null)
    {
      if (paramMultiTaskInfo.field_type == 4)
      {
        paramMultiTaskInfo = com.tencent.mm.ci.a.ba(MMApplicationContext.getContext(), d.g.MmT);
        p.j(paramMultiTaskInfo, "ResourceHelper.getString…ar_section_subtitle_file)");
        AppMethodBeat.o(215615);
        return paramMultiTaskInfo;
      }
      paramMultiTaskInfo = com.tencent.mm.ci.a.ba(MMApplicationContext.getContext(), d.g.MmX);
      p.j(paramMultiTaskInfo, "ResourceHelper.getString…ar_section_subtitle_note)");
      AppMethodBeat.o(215615);
      return paramMultiTaskInfo;
    }
    AppMethodBeat.o(215615);
    return "";
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(215616);
    p.k(paramMultiTaskInfo, "data");
    if (paramMultiTaskInfo.field_type == 4)
    {
      i = d.c.Mmj;
      AppMethodBeat.o(215616);
      return i;
    }
    int i = d.c.Mmm;
    AppMethodBeat.o(215616);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.a.a
 * JD-Core Version:    0.7.0.1
 */