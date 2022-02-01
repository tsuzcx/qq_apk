package com.tencent.mm.plugin.ringtone.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.b.d;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "()V", "onRingtoneIconClick", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConverter$OnRingtoneItemClick;", "getOnRingtoneIconClick", "()Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConverter$OnRingtoneItemClick;", "setOnRingtoneIconClick", "(Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConverter$OnRingtoneItemClick;)V", "applyRingtonePlay", "", "itemView", "Landroid/view/View;", "play", "", "ringback", "getLayoutId", "", "initFromCache", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "initUserLayout", "onBindViewHolder", "exclusive", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "OnRingtoneItemClick", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f<c>
{
  public a OBZ;
  
  private static void a(View paramView, boolean paramBoolean, c paramc)
  {
    AppMethodBeat.i(273021);
    boolean bool = paramc.OBU;
    paramc = (MMAnimateView)paramView.findViewById(b.c.ringtone_animator_iv);
    if (paramc != null) {
      paramc.setImageDrawable(bb.m(paramView.getContext(), b.e.icons_filled_ringing, paramView.getContext().getResources().getColor(b.a.FG_0)));
    }
    Object localObject = paramView.findViewById(b.c.ringtone_play_iv);
    s.s(localObject, "itemView.findViewById(R.id.ringtone_play_iv)");
    localObject = new com.tencent.mm.plugin.ringtone.widget.d((WeImageView)localObject, paramView.getContext());
    if (!bool)
    {
      if (paramc != null) {
        paramc.stop();
      }
      if (paramBoolean)
      {
        if (paramc != null) {
          paramc.setImageFilePath(com.tencent.mm.plugin.ringtone.c.BL(true));
        }
        if (paramc != null) {
          paramc.start();
        }
        ((com.tencent.mm.plugin.ringtone.widget.d)localObject).gPh();
        AppMethodBeat.o(273021);
        return;
      }
      if (paramc != null) {
        paramc.setImageDrawable(bb.m(paramView.getContext(), b.e.icons_filled_ringing, paramView.getContext().getResources().getColor(b.a.FG_0)));
      }
      if (paramc != null) {
        paramc.clearAnimation();
      }
      ((com.tencent.mm.plugin.ringtone.widget.d)localObject).gPi();
    }
    AppMethodBeat.o(273021);
  }
  
  private static final void a(d paramd, c paramc, j paramj, View paramView)
  {
    AppMethodBeat.i(273026);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramc);
    localb.cH(paramj);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/ringtone/data/ExclusiveConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(paramc, "$ringback");
    s.u(paramj, "$holder");
    paramd = paramd.OBZ;
    if (paramd != null) {
      paramd.b(paramc, paramj);
    }
    a.a(new Object(), "com/tencent/mm/plugin/ringtone/data/ExclusiveConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273026);
  }
  
  private static final void b(d paramd, c paramc, j paramj, View paramView)
  {
    AppMethodBeat.i(273035);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramd);
    localb.cH(paramc);
    localb.cH(paramj);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/ringtone/data/ExclusiveConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    s.u(paramc, "$ringback");
    s.u(paramj, "$holder");
    paramd = paramd.OBZ;
    if (paramd != null) {
      paramd.a(paramc, paramj);
    }
    a.a(new Object(), "com/tencent/mm/plugin/ringtone/data/ExclusiveConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273035);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(273065);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(273065);
  }
  
  public final int getLayoutId()
  {
    return b.d.settings_exclusive_ringtone_ui;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConverter$OnRingtoneItemClick;", "", "onRingtoneControlClick", "", "ringback", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onRingtoneMoreOpClick", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(c paramc, j paramj);
    
    public abstract void b(c paramc, j paramj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.b.d
 * JD-Core Version:    0.7.0.1
 */