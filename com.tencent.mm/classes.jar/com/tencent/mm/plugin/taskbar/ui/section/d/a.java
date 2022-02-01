package com.tencent.mm.plugin.taskbar.ui.section.d;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/video/TaskBarSectionOtherViewVideoHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "onBindViewHolder", "", "pos", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.other.b
{
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(214755);
    AppMethodBeat.o(214755);
  }
  
  public final void a(int paramInt, a.b paramb, com.tencent.mm.plugin.taskbar.ui.section.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(214747);
    p.k(paramb, "viewHolder");
    p.k(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    Object localObject1 = new cwl();
    Context localContext;
    Object localObject2;
    try
    {
      ((cwl)localObject1).parseFrom(((MultiTaskInfo)paramd.MqV.get(paramInt)).field_data);
      if (((cwl)localObject1).TFk.isEmpty())
      {
        AppMethodBeat.o(214747);
        return;
      }
    }
    catch (Throwable paramd)
    {
      for (;;)
      {
        Log.e("AppBrandDesktopSectionVideoView", "MegaVideoFloatBallInfo parse fail", new Object[] { paramd });
      }
      paramd = paramb.amk;
      p.j(paramd, "viewHolder.itemView");
      localContext = paramd.getContext();
      localObject2 = (FinderObject)((cwl)localObject1).TFk.get(0);
      paramd = ((FinderObject)localObject2).contact;
      if (paramd == null) {
        break label444;
      }
    }
    paramd = paramd.nickname;
    if (paramd != null)
    {
      paramd = (CharSequence)paramd;
      if (paramd.length() <= 0) {
        break label456;
      }
      paramInt = i;
      label161:
      localObject1 = paramd;
      if (paramInt != 0)
      {
        paramd = com.tencent.mm.pluginsdk.ui.span.l.c(localContext, (CharSequence)(paramd + com.tencent.mm.ci.a.ba(localContext, d.g.MmZ)));
        p.j(paramd, "MMSpanManager.spanForSmi…subtitle_video_suffix)}\")");
        localObject1 = (CharSequence)paramd;
      }
      paramd = paramb.jMg;
      p.j(paramd, "viewHolder.title");
      paramd.setText((CharSequence)localObject1);
      if (localObject2 == null) {
        break label461;
      }
      paramd = ((FinderObject)localObject2).objectDesc;
      if (paramd == null) {
        break label461;
      }
      paramd = paramd.media;
      if (paramd == null) {
        break label461;
      }
      localObject1 = (FinderMedia)paramd.getFirst();
      label264:
      if (localObject1 != null)
      {
        localObject2 = ((FinderMedia)localObject1).coverUrl;
        paramd = (com.tencent.mm.plugin.taskbar.ui.section.d)localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        paramd = "";
      }
      p.j(paramd, "finderMedia?.coverUrl ?: \"\"");
      if (localObject1 == null) {
        break label467;
      }
      localObject2 = ((FinderMedia)localObject1).thumbUrl;
      label305:
      if (localObject1 == null) {
        break label473;
      }
      localObject1 = ((FinderMedia)localObject1).thumb_url_token;
      label317:
      localObject1 = p.I((String)localObject2, Util.nullAsNil((String)localObject1));
      if (Util.isNullOrNil(paramd)) {
        break label479;
      }
    }
    for (;;)
    {
      localObject1 = paramb.image;
      ((ImageView)localObject1).setImageBitmap(null);
      localObject2 = t.ztT;
      paramd = t.dJe().bQ(new x(paramd, u.Aly)).a((com.tencent.mm.loader.f.d)new com.tencent.mm.loader.e.d(null, null, 3));
      localObject2 = t.ztT;
      paramd = paramd.a(t.a(t.a.ztU));
      p.j(localObject1, "it");
      paramd.c((ImageView)localObject1);
      paramb = paramb.KGj;
      p.j(paramb, "viewHolder.playBtn");
      paramb.setVisibility(0);
      AppMethodBeat.o(214747);
      return;
      label444:
      paramd = (CharSequence)"";
      break;
      label456:
      paramInt = 0;
      break label161;
      label461:
      localObject1 = null;
      break label264;
      label467:
      localObject2 = null;
      break label305;
      label473:
      localObject1 = null;
      break label317;
      label479:
      paramd = (com.tencent.mm.plugin.taskbar.ui.section.d)localObject1;
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214750);
    paramMultiTaskInfo = com.tencent.mm.ci.a.ba(MMApplicationContext.getContext(), d.g.MmY);
    p.j(paramMultiTaskInfo, "ResourceHelper.getString…r_section_subtitle_video)");
    AppMethodBeat.o(214750);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214752);
    p.k(paramMultiTaskInfo, "data");
    int i = d.c.Mmn;
    AppMethodBeat.o(214752);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.d.a
 * JD-Core Version:    0.7.0.1
 */