package com.tencent.mm.plugin.taskbar.ui.section.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/live/TaskBarSectionOtherViewLiveHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "onBindViewHolder", "", "pos", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.other.b
{
  private final String TAG;
  
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(264214);
    this.TAG = "TaskBarSectionOtherViewLiveHelper";
    AppMethodBeat.o(264214);
  }
  
  public final void a(int paramInt, a.b paramb, com.tencent.mm.plugin.taskbar.ui.section.d paramd)
  {
    AppMethodBeat.i(264239);
    kotlin.g.b.s.u(paramb, "viewHolder");
    kotlin.g.b.s.u(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    Object localObject2 = new bkg();
    Object localObject1;
    FinderObject localFinderObject;
    try
    {
      ((bkg)localObject2).parseFrom(((MultiTaskInfo)paramd.SUd.get(paramInt)).field_data);
      if (((bkg)localObject2).ABJ == null)
      {
        AppMethodBeat.o(264239);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e(this.TAG, "FinderLiveMultiTaskData parse fail", new Object[] { paramd });
      }
      localObject1 = paramb.caK.getContext();
      localFinderObject = ((bkg)localObject2).ABJ;
      kotlin.g.b.s.checkNotNull(localFinderObject);
      kotlin.g.b.s.s(localFinderObject, "data.finderObject!!");
      paramd = localFinderObject.contact;
      if (paramd != null) {
        break label433;
      }
    }
    paramd = null;
    if (paramd == null)
    {
      paramd = (CharSequence)"";
      label140:
      if (paramd.length() <= 0) {
        break label449;
      }
      paramInt = 1;
      label151:
      if (paramInt == 0) {
        break label587;
      }
      paramd = com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject1, (CharSequence)(paramd + com.tencent.mm.cd.a.bt((Context)localObject1, d.g.SQo)));
      kotlin.g.b.s.s(paramd, "spanForSmiley(context,\n …_subtitle_live_suffix)}\")");
    }
    label266:
    label433:
    label449:
    label587:
    for (localObject2 = (CharSequence)paramd;; localObject2 = paramd)
    {
      paramb.mll.setText((CharSequence)localObject2);
      paramd = localFinderObject.objectDesc;
      label223:
      label231:
      Object localObject3;
      if (paramd == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label484;
        }
        paramd = "";
        if (localObject1 != null) {
          break label505;
        }
        localObject3 = null;
        label239:
        if (localObject1 != null) {
          break label515;
        }
        localObject1 = null;
        label247:
        localObject1 = kotlin.g.b.s.X((String)localObject3, Util.nullAsNil((String)localObject1));
        if (Util.isNullOrNil(paramd)) {
          break label525;
        }
        paramb.Fjt.setImageBitmap(null);
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s(paramd, v.FKY)).a((com.tencent.mm.loader.e.d)new com.tencent.mm.loader.d.d(null, null, 3));
        localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = ((com.tencent.mm.loader.b)localObject1).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        localObject3 = paramb.Fjt;
        kotlin.g.b.s.s(localObject3, "viewHolder.image");
        ((com.tencent.mm.loader.b)localObject1).d((ImageView)localObject3);
        localObject1 = localFinderObject.liveInfo;
        if (localObject1 != null) {
          break label531;
        }
      }
      for (paramInt = 2;; paramInt = ((bip)localObject1).liveStatus)
      {
        Log.i(this.TAG, "onBind live " + paramInt + ' ' + localObject2);
        if (paramInt != 1) {
          break label540;
        }
        paramb.SUo.setVisibility(0);
        paramb.SUp.setVisibility(8);
        AppMethodBeat.o(264239);
        return;
        paramd = paramd.nickname;
        break;
        paramd = (CharSequence)paramd;
        break label140;
        paramInt = 0;
        break label151;
        paramd = paramd.media;
        if (paramd == null)
        {
          localObject1 = null;
          break label223;
        }
        localObject1 = (FinderMedia)kotlin.a.p.oL((List)paramd);
        break label223;
        label484:
        localObject3 = ((FinderMedia)localObject1).coverUrl;
        paramd = (com.tencent.mm.plugin.taskbar.ui.section.d)localObject3;
        if (localObject3 != null) {
          break label231;
        }
        paramd = "";
        break label231;
        label505:
        localObject3 = ((FinderMedia)localObject1).thumbUrl;
        break label239;
        localObject1 = ((FinderMedia)localObject1).thumb_url_token;
        break label247;
        paramd = (com.tencent.mm.plugin.taskbar.ui.section.d)localObject1;
        break label266;
      }
      paramb.SUo.setVisibility(8);
      paramb.SUp.setVisibility(0);
      ((cn)h.az(cn.class)).getFinderUtilApi().a(paramb.Fjt, paramd);
      AppMethodBeat.o(264239);
      return;
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264248);
    paramMultiTaskInfo = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), d.g.SQn);
    kotlin.g.b.s.s(paramMultiTaskInfo, "getString(MMApplicationC…ar_section_subtitle_live)");
    AppMethodBeat.o(264248);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264256);
    kotlin.g.b.s.u(paramMultiTaskInfo, "data");
    int i = d.c.SPA;
    AppMethodBeat.o(264256);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.b.a
 * JD-Core Version:    0.7.0.1
 */