package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.f;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.d.a;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFallbackImage", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "shouldLoadSnapshot", "", "Callback", "Companion", "plugin-taskbar_release"})
public abstract class b
{
  public static final b.b Mrp = new b.b((byte)0);
  final a Mro;
  
  public b(a parama)
  {
    this.Mro = parama;
  }
  
  public void a(final int paramInt, final a.b paramb, final d paramd)
  {
    p.k(paramb, "viewHolder");
    p.k(paramd, "viewModel");
    MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)paramd.MqV.get(paramInt);
    Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "onBind " + paramInt + ' ' + localMultiTaskInfo.fbc().title + ' ' + localMultiTaskInfo.field_type + ' ' + localMultiTaskInfo.field_id);
    Object localObject = paramb.rsy;
    p.j(localObject, "it.subTitle");
    ((TextView)localObject).setText((CharSequence)p(localMultiTaskInfo));
    localObject = paramb.Mrm;
    p.j(localObject, "it.liveWidget");
    ((View)localObject).setVisibility(8);
    localObject = paramb.Mrn;
    p.j(localObject, "it.liveEndWidget");
    ((View)localObject).setVisibility(8);
    localObject = paramb.KGj;
    p.j(localObject, "it.playBtn");
    ((ImageView)localObject).setVisibility(8);
    localObject = paramb.Mrl;
    p.j(localObject, "it.defaultImage");
    ((ImageView)localObject).setVisibility(0);
    paramb.Mrl.setImageResource(q(localMultiTaskInfo));
    paramb.image.setImageDrawable(null);
    localObject = paramb.image;
    p.j(localObject, "it.image");
    ((ImageView)localObject).setBackground(null);
    p.k(localMultiTaskInfo, "data");
    localObject = d.MqY;
    p.k(localMultiTaskInfo, "$this$shouldLoadSnapshot");
    if (d.a.ajc(localMultiTaskInfo.field_type))
    {
      localObject = f.Mnf;
      p.k(localMultiTaskInfo, "multiTaskInfo");
      localObject = localMultiTaskInfo.field_id;
      p.j(localObject, "multiTaskInfo.field_id");
      localObject = f.aQX((String)localObject);
      if (u.agG((String)localObject))
      {
        Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "load snapshots " + localMultiTaskInfo.field_id + ' ' + (String)localObject);
        q.bml().a((String)localObject, paramb.image, e.Mnd, (k)new c(localMultiTaskInfo, paramb, this, paramd, paramInt, paramb));
      }
    }
    for (;;)
    {
      paramb.kHA.setOnClickListener((View.OnClickListener)new d(this, paramd, paramInt, paramb));
      return;
      Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "loadFallbackImage[file not exist] " + localMultiTaskInfo.field_id);
      a(paramb);
      continue;
      Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "loadFallbackImage[disabled] " + localMultiTaskInfo.field_id);
      a(paramb);
    }
  }
  
  public void a(a.b paramb)
  {
    p.k(paramb, "viewHolder");
  }
  
  public abstract String p(MultiTaskInfo paramMultiTaskInfo);
  
  public abstract int q(MultiTaskInfo paramMultiTaskInfo);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "", "removeItem", "", "pos", "", "plugin-taskbar_release"})
  public static abstract interface a
  {
    public abstract void removeItem(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "extraObj", "", "", "onImageLoadComplete", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V", "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$1$1"})
  static final class c
    implements k
  {
    c(MultiTaskInfo paramMultiTaskInfo, a.b paramb1, b paramb, d paramd, int paramInt, a.b paramb2) {}
    
    public final void a(String paramString, View paramView, final Bitmap paramBitmap, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(214664);
      Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "load snapshots done " + paramInt + ' ' + this.Mrq.field_id + ' ' + paramBitmap);
      paramb.image.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215326);
          if (paramBitmap != null)
          {
            this.Mru.Mrr.image.setImageBitmap(paramBitmap);
            AppMethodBeat.o(215326);
            return;
          }
          Log.i("MicroMsg.TaskBarSectionOtherViewBaseHelper", "loadFallbackImage[bitmap is null] " + this.Mru.Mrq.field_id);
          this.Mru.Mrs.a(this.Mru.Mrr);
          AppMethodBeat.o(215326);
        }
      });
      AppMethodBeat.o(214664);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$1$2"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb, d paramd, int paramInt, a.b paramb1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(214205);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Mrs.Mro.removeItem(paramb.md());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(214205);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.other.b
 * JD-Core Version:    0.7.0.1
 */