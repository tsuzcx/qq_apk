package com.tencent.mm.plugin.taskbar.ui.section.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/video/TaskBarSectionOtherViewVideoHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "onBindViewHolder", "", "pos", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.other.b
{
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(264217);
    AppMethodBeat.o(264217);
  }
  
  public final void a(int paramInt, a.b paramb, com.tencent.mm.plugin.taskbar.ui.section.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(264237);
    kotlin.g.b.s.u(paramb, "viewHolder");
    kotlin.g.b.s.u(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    Object localObject1 = new dnq();
    Context localContext;
    Object localObject2;
    try
    {
      ((dnq)localObject1).parseFrom(((MultiTaskInfo)paramd.SUd.get(paramInt)).field_data);
      if (((dnq)localObject1).aaUQ.isEmpty())
      {
        AppMethodBeat.o(264237);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("TaskBarSectionOtherViewVideoHelper", "MegaVideoFloatBallInfo parse fail", new Object[] { paramd });
      }
      localContext = paramb.caK.getContext();
      localObject2 = (FinderObject)((dnq)localObject1).aaUQ.get(0);
      paramd = ((FinderObject)localObject2).contact;
      if (paramd != null) {
        break label370;
      }
    }
    paramd = null;
    if (paramd == null)
    {
      paramd = (CharSequence)"";
      label142:
      if (paramd.length() <= 0) {
        break label386;
      }
      paramInt = i;
      label154:
      localObject1 = paramd;
      if (paramInt != 0)
      {
        paramd = com.tencent.mm.pluginsdk.ui.span.p.b(localContext, (CharSequence)(paramd + com.tencent.mm.cd.a.bt(localContext, d.g.SQs)));
        kotlin.g.b.s.s(paramd, "spanForSmiley(context,\n …subtitle_video_suffix)}\")");
        localObject1 = (CharSequence)paramd;
      }
      paramb.mll.setText((CharSequence)localObject1);
      if (localObject2 != null) {
        break label391;
      }
      localObject1 = null;
      label224:
      if (localObject1 != null) {
        break label434;
      }
      paramd = "";
      label232:
      if (localObject1 != null) {
        break label455;
      }
      localObject2 = null;
      label240:
      if (localObject1 != null) {
        break label465;
      }
    }
    label386:
    label391:
    label434:
    label455:
    label465:
    for (localObject1 = null;; localObject1 = ((FinderMedia)localObject1).thumb_url_token)
    {
      localObject1 = kotlin.g.b.s.X((String)localObject2, Util.nullAsNil((String)localObject1));
      if (!Util.isNullOrNil(paramd)) {
        localObject1 = paramd;
      }
      paramd = paramb.Fjt;
      paramd.setImageBitmap(null);
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKY)).a((com.tencent.mm.loader.e.d)new com.tencent.mm.loader.d.d(null, null, 3));
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = ((com.tencent.mm.loader.b)localObject1).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      kotlin.g.b.s.s(paramd, "it");
      ((com.tencent.mm.loader.b)localObject1).d(paramd);
      paramb.RfJ.setVisibility(0);
      AppMethodBeat.o(264237);
      return;
      label370:
      paramd = paramd.nickname;
      break;
      paramd = (CharSequence)paramd;
      break label142;
      paramInt = 0;
      break label154;
      paramd = ((FinderObject)localObject2).objectDesc;
      if (paramd == null)
      {
        localObject1 = null;
        break label224;
      }
      paramd = paramd.media;
      if (paramd == null)
      {
        localObject1 = null;
        break label224;
      }
      localObject1 = (FinderMedia)paramd.getFirst();
      break label224;
      localObject2 = ((FinderMedia)localObject1).coverUrl;
      paramd = (com.tencent.mm.plugin.taskbar.ui.section.d)localObject2;
      if (localObject2 != null) {
        break label232;
      }
      paramd = "";
      break label232;
      localObject2 = ((FinderMedia)localObject1).thumbUrl;
      break label240;
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264247);
    paramMultiTaskInfo = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), d.g.SQr);
    kotlin.g.b.s.s(paramMultiTaskInfo, "getString(MMApplicationC…r_section_subtitle_video)");
    AppMethodBeat.o(264247);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264254);
    kotlin.g.b.s.u(paramMultiTaskInfo, "data");
    int i = d.c.SPD;
    AppMethodBeat.o(264254);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.d.a
 * JD-Core Version:    0.7.0.1
 */