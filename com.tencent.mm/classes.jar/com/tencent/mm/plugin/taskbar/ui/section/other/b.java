package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.f;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.d.a;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "shouldLoadSnapshot", "", "Callback", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
{
  public static final b.b SUq = new b.b((byte)0);
  private final a SUr;
  
  public b(a parama)
  {
    this.SUr = parama;
  }
  
  private static final void a(int paramInt, MultiTaskInfo paramMultiTaskInfo, a.b paramb, b paramb1, String paramString, View paramView, Bitmap paramBitmap, Object[] paramArrayOfObject)
  {
    s.u(paramMultiTaskInfo, "$data");
    s.u(paramb, "$it");
    s.u(paramb1, "this$0");
    Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "load snapshots done " + paramInt + ' ' + paramMultiTaskInfo.field_id + ' ' + paramBitmap);
    paramb.Fjt.post(new b..ExternalSyntheticLambda2(paramBitmap, paramb, paramMultiTaskInfo, paramb1));
  }
  
  private static final void a(Bitmap paramBitmap, a.b paramb, MultiTaskInfo paramMultiTaskInfo, b paramb1)
  {
    s.u(paramb, "$it");
    s.u(paramMultiTaskInfo, "$data");
    s.u(paramb1, "this$0");
    if (paramBitmap != null)
    {
      paramb.Fjt.setImageBitmap(paramBitmap);
      return;
    }
    Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", s.X("loadFallbackImage[bitmap is null] ", paramMultiTaskInfo.field_id));
    paramb1.a(paramb);
  }
  
  private static final void a(b paramb, a.b paramb1, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramb1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramb1, "$viewHolder");
    paramb.SUr.removeItem(paramb1.KJ());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public void a(int paramInt, a.b paramb, d paramd)
  {
    s.u(paramb, "viewHolder");
    s.u(paramd, "viewModel");
    paramd = (MultiTaskInfo)paramd.SUd.get(paramInt);
    Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "onBind " + paramInt + ' ' + paramd.gkh().title + ' ' + paramd.field_type + ' ' + paramd.field_id);
    paramb.uCY.setText((CharSequence)p(paramd));
    paramb.SUo.setVisibility(8);
    paramb.SUp.setVisibility(8);
    paramb.RfJ.setVisibility(8);
    paramb.SUn.setVisibility(0);
    paramb.SUn.setImageResource(q(paramd));
    paramb.Fjt.setImageDrawable(null);
    paramb.Fjt.setBackground(null);
    s.u(paramd, "data");
    Object localObject = d.SUa;
    s.u(paramd, "<this>");
    if (d.a.aoe(paramd.field_type))
    {
      localObject = f.SQy;
      s.u(paramd, "multiTaskInfo");
      localObject = paramd.field_id;
      s.s(localObject, "multiTaskInfo.field_id");
      localObject = f.aNP((String)localObject);
      if (y.ZC((String)localObject))
      {
        Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "load snapshots " + paramd.field_id + ' ' + (String)localObject);
        r.bKe().a((String)localObject, paramb.Fjt, e.SQw, new b..ExternalSyntheticLambda1(paramInt, paramd, paramb, this));
      }
    }
    for (;;)
    {
      paramb.nkq.setOnClickListener(new b..ExternalSyntheticLambda0(this, paramb));
      return;
      Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", s.X("loadFallbackImage[file not exist] ", paramd.field_id));
      a(paramb);
      continue;
      Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", s.X("loadFallbackImage[disabled] ", paramd.field_id));
      a(paramb);
    }
  }
  
  public void a(a.b paramb)
  {
    s.u(paramb, "viewHolder");
  }
  
  public abstract String p(MultiTaskInfo paramMultiTaskInfo);
  
  public abstract int q(MultiTaskInfo paramMultiTaskInfo);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "", "removeItem", "", "pos", "", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void removeItem(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.other.b
 * JD-Core Version:    0.7.0.1
 */