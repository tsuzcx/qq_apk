package com.tencent.mm.plugin.taskbar.ui.section.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/live/TaskBarSectionOtherViewLiveHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "onBindViewHolder", "", "pos", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.other.b
{
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(215655);
    AppMethodBeat.o(215655);
  }
  
  public final void a(int paramInt, a.b paramb, com.tencent.mm.plugin.taskbar.ui.section.d paramd)
  {
    AppMethodBeat.i(215651);
    p.k(paramb, "viewHolder");
    p.k(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    Object localObject2 = new bbf();
    FinderObject localFinderObject;
    try
    {
      ((bbf)localObject2).parseFrom(((MultiTaskInfo)paramd.MqV.get(paramInt)).field_data);
      if (((bbf)localObject2).xcx == null)
      {
        AppMethodBeat.o(215651);
        return;
      }
    }
    catch (Throwable paramd)
    {
      for (;;)
      {
        Log.e("MicroMsg.TaskBarSectionLiveView", "FinderLiveMultiTaskData parse fail", new Object[] { paramd });
      }
      paramd = paramb.amk;
      p.j(paramd, "viewHolder.itemView");
      localObject1 = paramd.getContext();
      localFinderObject = ((bbf)localObject2).xcx;
      if (localFinderObject == null) {
        p.iCn();
      }
      paramd = localFinderObject.contact;
      if (paramd == null) {
        break label509;
      }
    }
    paramd = paramd.nickname;
    if (paramd != null)
    {
      paramd = (CharSequence)paramd;
      if (paramd.length() <= 0) {
        break label518;
      }
      paramInt = 1;
      label155:
      if (paramInt == 0) {
        break label621;
      }
      paramd = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)(paramd + com.tencent.mm.ci.a.ba((Context)localObject1, d.g.MmV)));
      p.j(paramd, "MMSpanManager.spanForSmi…_subtitle_live_suffix)}\")");
    }
    label294:
    label306:
    label621:
    for (Object localObject1 = (CharSequence)paramd;; localObject1 = paramd)
    {
      paramd = paramb.jMg;
      p.j(paramd, "viewHolder.title");
      paramd.setText((CharSequence)localObject1);
      paramd = localFinderObject.objectDesc;
      label253:
      Object localObject3;
      if (paramd != null)
      {
        paramd = paramd.media;
        if (paramd != null)
        {
          localObject2 = (FinderMedia)j.lp((List)paramd);
          if (localObject2 != null)
          {
            localObject3 = ((FinderMedia)localObject2).coverUrl;
            paramd = (com.tencent.mm.plugin.taskbar.ui.section.d)localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            paramd = "";
          }
          p.j(paramd, "firstMedia?.coverUrl ?: \"\"");
          if (localObject2 == null) {
            break label529;
          }
          localObject3 = ((FinderMedia)localObject2).thumbUrl;
          if (localObject2 == null) {
            break label535;
          }
          localObject2 = ((FinderMedia)localObject2).thumb_url_token;
          localObject2 = p.I((String)localObject3, Util.nullAsNil((String)localObject2));
          if (!Util.isNullOrNil(paramd)) {
            localObject2 = paramd;
          }
          paramb.image.setImageBitmap(null);
          paramd = t.ztT;
          paramd = t.dJe().bQ(new x((String)localObject2, u.Aly)).a((com.tencent.mm.loader.f.d)new com.tencent.mm.loader.e.d(null, null, 3));
          localObject3 = t.ztT;
          paramd = paramd.a(t.a(t.a.ztU));
          localObject3 = paramb.image;
          p.j(localObject3, "viewHolder.image");
          paramd.c((ImageView)localObject3);
          paramd = localFinderObject.liveInfo;
          if (paramd == null) {
            break label541;
          }
        }
      }
      for (paramInt = paramd.liveStatus;; paramInt = 2)
      {
        Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "onBind live " + paramInt + ' ' + (CharSequence)localObject1);
        if (paramInt != 1) {
          break label546;
        }
        paramd = paramb.Mrm;
        p.j(paramd, "viewHolder.liveWidget");
        paramd.setVisibility(0);
        paramb = paramb.Mrn;
        p.j(paramb, "viewHolder.liveEndWidget");
        paramb.setVisibility(8);
        AppMethodBeat.o(215651);
        return;
        label509:
        paramd = (CharSequence)"";
        break;
        paramInt = 0;
        break label155;
        localObject2 = null;
        break label253;
        localObject3 = null;
        break label294;
        localObject2 = null;
        break label306;
      }
      paramd = paramb.Mrm;
      p.j(paramd, "viewHolder.liveWidget");
      paramd.setVisibility(8);
      paramd = paramb.Mrn;
      p.j(paramd, "viewHolder.liveEndWidget");
      paramd.setVisibility(0);
      paramd = h.ag(ak.class);
      p.j(paramd, "MMKernel.plugin(IPluginFinder::class.java)");
      ((ak)paramd).getFinderUtilApi().f(paramb.image, (String)localObject2);
      AppMethodBeat.o(215651);
      return;
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(215652);
    paramMultiTaskInfo = com.tencent.mm.ci.a.ba(MMApplicationContext.getContext(), d.g.MmU);
    p.j(paramMultiTaskInfo, "ResourceHelper.getString…ar_section_subtitle_live)");
    AppMethodBeat.o(215652);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(215654);
    p.k(paramMultiTaskInfo, "data");
    int i = d.c.Mmk;
    AppMethodBeat.o(215654);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.b.a
 * JD-Core Version:    0.7.0.1
 */