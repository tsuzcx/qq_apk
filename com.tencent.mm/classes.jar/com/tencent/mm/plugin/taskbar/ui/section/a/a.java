package com.tencent.mm.plugin.taskbar.ui.section.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.f;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.smiley.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/file/TaskBarSectionOtherViewFileHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "imageRes", "", "Ljava/lang/Integer;", "getDefaultImageRes", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private Integer SUf;
  
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(264222);
    AppMethodBeat.o(264222);
  }
  
  public final void a(int paramInt, a.b paramb, d paramd)
  {
    AppMethodBeat.i(264234);
    s.u(paramb, "viewHolder");
    s.u(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    int i;
    if (((MultiTaskInfo)paramd.SUd.get(paramInt)).field_type == 4)
    {
      i = 1;
      if (i != 0) {
        break label130;
      }
    }
    label130:
    for (Integer localInteger = Integer.valueOf(d.f.float_ball_icon_fav_default);; localInteger = Integer.valueOf(x.bpA(((MultiTaskInfo)paramd.SUd.get(paramInt)).gkh().lPJ)))
    {
      this.SUf = localInteger;
      paramb.mll.setText((CharSequence)u.iVt().a(paramb.caK.getContext(), (CharSequence)((MultiTaskInfo)paramd.SUd.get(paramInt)).gkh().title, paramb.mll.getTextSize()));
      AppMethodBeat.o(264234);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(264261);
    s.u(paramb, "viewHolder");
    paramb.Fjt.setImageBitmap(null);
    AppMethodBeat.o(264261);
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264245);
    if (paramMultiTaskInfo != null)
    {
      if (paramMultiTaskInfo.field_type == 4)
      {
        paramMultiTaskInfo = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), d.g.SQm);
        s.s(paramMultiTaskInfo, "getString(MMApplicationC…ar_section_subtitle_file)");
        AppMethodBeat.o(264245);
        return paramMultiTaskInfo;
      }
      paramMultiTaskInfo = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), d.g.SQq);
      s.s(paramMultiTaskInfo, "getString(MMApplicationC…ar_section_subtitle_note)");
      AppMethodBeat.o(264245);
      return paramMultiTaskInfo;
    }
    AppMethodBeat.o(264245);
    return "";
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264251);
    s.u(paramMultiTaskInfo, "data");
    if (paramMultiTaskInfo.field_type == 4)
    {
      i = d.c.SPz;
      AppMethodBeat.o(264251);
      return i;
    }
    int i = d.c.SPC;
    AppMethodBeat.o(264251);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.a.a
 * JD-Core Version:    0.7.0.1
 */