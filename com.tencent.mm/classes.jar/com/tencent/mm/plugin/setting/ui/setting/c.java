package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "iRingtoneChooseCallback", "Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;", "(Landroid/view/View;Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;)V", "composition", "Lcom/tencent/mm/config/MessageRingtone;", "compositionStateIv", "Landroid/widget/ImageView;", "compositionTv", "Landroid/widget/TextView;", "getIRingtoneChooseCallback", "()Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;", "fillContent", "", "onClick", "v", "onSelect", "select", "", "IRingtoneChooseCallback", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
  implements View.OnClickListener
{
  TextView Jqy;
  g PpA;
  final a Ppy;
  ImageView Ppz;
  
  public c(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(298705);
    this.Ppy = parama;
    parama = paramView.findViewById(b.f.item_tv);
    s.s(parama, "itemView.findViewById(R.id.item_tv)");
    this.Jqy = ((TextView)parama);
    parama = paramView.findViewById(b.f.state_icon);
    s.s(parama, "itemView.findViewById(R.id.state_icon)");
    this.Ppz = ((ImageView)parama);
    paramView.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(298705);
  }
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(298713);
    Object localObject2 = new b();
    ((b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).aYj());
    localObject2 = new StringBuilder("onClick ");
    paramView = this.PpA;
    if (paramView == null)
    {
      paramView = null;
      localObject2 = ((StringBuilder)localObject2).append(paramView).append(", ");
      paramView = this.PpA;
      if (paramView != null) {
        break label149;
      }
    }
    label149:
    for (paramView = localObject1;; paramView = paramView.name)
    {
      Log.i("MicroMsg.SettingMessageRingtoneUI", paramView);
      paramView = this.PpA;
      if (paramView != null) {
        this.Ppy.a(paramView);
      }
      this.Ppy.notifyDataSetChanged();
      a.a(this, "com/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(298713);
      return;
      paramView = Integer.valueOf(paramView.index);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/RingtoneViewHolder$IRingtoneChooseCallback;", "", "isSelect", "", "composition", "Lcom/tencent/mm/config/MessageRingtone;", "notifyDataSetChanged", "", "onChoose", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(g paramg);
    
    public abstract boolean b(g paramg);
    
    public abstract void notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.c
 * JD-Core Version:    0.7.0.1
 */