package com.tencent.mm.plugin.taskbar.ui.section.c;

import android.graphics.Bitmap;
import android.widget.ImageView;
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
import com.tencent.mm.protocal.protobuf.dte;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/music/TaskBarSectionOtherViewMusicHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "loadFromUrl", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "musicMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/MusicMultiTaskData;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private final String TAG;
  
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(264312);
    this.TAG = "TaskBarSectionOtherViewMusicHelper";
    AppMethodBeat.o(264312);
  }
  
  private static final void a(a parama, a.b paramb, dte paramdte)
  {
    AppMethodBeat.i(264331);
    s.u(parama, "this$0");
    s.u(paramb, "$viewHolder");
    s.u(paramdte, "$musicMultiTaskData");
    parama.a(paramb, paramdte);
    AppMethodBeat.o(264331);
  }
  
  private static final void a(a.b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(264325);
    s.u(paramb, "$viewHolder");
    s.u(paramBitmap, "$bitmap");
    paramb.Fjt.setImageBitmap(paramBitmap);
    AppMethodBeat.o(264325);
  }
  
  private final void a(a.b paramb, dte paramdte)
  {
    String str = null;
    AppMethodBeat.i(264320);
    paramb.Fjt.setImageDrawable(null);
    Object localObject = paramdte.oPb;
    if (localObject == null)
    {
      localObject = (CharSequence)str;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label111;
      }
    }
    label111:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        str = paramdte.aaYJ;
      }
      if (str != null)
      {
        Log.i(this.TAG, s.X("use url: ", str));
        r.bKe().a(str, paramb.Fjt, e.SQv);
      }
      AppMethodBeat.o(264320);
      return;
      str = ((dtj)localObject).YqP;
      break;
    }
  }
  
  private static final void a(String paramString, a parama, a.b paramb, dte paramdte)
  {
    AppMethodBeat.i(264339);
    s.u(paramString, "$it");
    s.u(parama, "this$0");
    s.u(paramb, "$viewHolder");
    s.u(paramdte, "$musicMultiTaskData");
    Bitmap localBitmap = BitmapUtil.decodeFileWithSample(paramString, 512, 512);
    if (localBitmap == null) {}
    for (paramString = null; paramString == null; paramString = Boolean.valueOf(paramb.Fjt.post(new a..ExternalSyntheticLambda1(paramb, localBitmap))))
    {
      paramb.Fjt.post(new a..ExternalSyntheticLambda0(parama, paramb, paramdte));
      AppMethodBeat.o(264339);
      return;
      Log.i(parama.TAG, s.X("use cover path: ", paramString));
    }
    paramString.booleanValue();
    AppMethodBeat.o(264339);
  }
  
  public final void a(int paramInt, a.b paramb, d paramd)
  {
    Object localObject1 = null;
    AppMethodBeat.i(264364);
    s.u(paramb, "viewHolder");
    s.u(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    dte localdte = new dte();
    for (;;)
    {
      try
      {
        localdte.parseFrom(((MultiTaskInfo)paramd.SUd.get(paramInt)).field_data);
        paramb.SUn.setVisibility(0);
        paramb.Fjt.setImageDrawable(null);
        localObject2 = localdte.oPb;
        if (localObject2 == null)
        {
          if (localObject1 == null) {
            a(paramb, localdte);
          }
          paramb.mll.setText((CharSequence)((MultiTaskInfo)paramd.SUd.get(paramInt)).gkh().title);
          AppMethodBeat.o(264364);
          return;
        }
      }
      finally
      {
        Log.e(this.TAG, "MusicMultiTaskData parse failed");
        AppMethodBeat.o(264364);
        return;
      }
      Object localObject2 = ((dtj)localObject2).oPc;
      if (localObject2 != null)
      {
        localObject1 = localdte.oPb;
        if (localObject1 == null)
        {
          localObject1 = null;
          label176:
          localObject1 = (CharSequence)localObject1;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label250;
          }
        }
        label250:
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (!y.ZC((String)localObject2))) {
            break label256;
          }
          localObject1 = h.ahAA.bo(new a..ExternalSyntheticLambda2((String)localObject2, this, paramb, localdte));
          break;
          localObject1 = ((dtj)localObject1).YqP;
          break label176;
        }
        label256:
        a(paramb, localdte);
        localObject1 = ah.aiuX;
      }
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264381);
    paramMultiTaskInfo = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), d.g.SQp);
    s.s(paramMultiTaskInfo, "getString(MMApplicationC…r_section_subtitle_music)");
    AppMethodBeat.o(264381);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264370);
    s.u(paramMultiTaskInfo, "data");
    int i = d.c.SPB;
    AppMethodBeat.o(264370);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.c.a
 * JD-Core Version:    0.7.0.1
 */