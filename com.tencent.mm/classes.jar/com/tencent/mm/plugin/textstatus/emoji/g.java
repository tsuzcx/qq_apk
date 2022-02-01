package com.tencent.mm.plugin.textstatus.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "typeName", "", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Landroid/view/View;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "subType", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "subTypeTv", "Landroid/widget/TextView;", "getTypeName", "()Ljava/lang/String;", "fillContent", "", "onClick", "v", "onSelect", "select", "", "IAlternativePyViewListener", "plugin-textstatus_release"})
public final class g
  extends RecyclerView.v
  implements View.OnClickListener
{
  private final RelativeLayout DtO;
  TextView Dwt;
  f MAX;
  private final a MBc;
  private final String typeName;
  
  public g(View paramView, String paramString, a parama)
  {
    super(paramView);
    AppMethodBeat.i(233074);
    this.typeName = paramString;
    this.MBc = parama;
    this.DtO = ((RelativeLayout)paramView.findViewById(b.e.root));
    paramView = paramView.findViewById(b.e.emoji_subtype_item_tv);
    p.j(paramView, "itemView.findViewById(R.id.emoji_subtype_item_tv)");
    this.Dwt = ((TextView)paramView);
    AppMethodBeat.o(233074);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(233069);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    p.k(paramView, "v");
    localObject = this.MBc;
    if (localObject != null)
    {
      sF(true);
      ((a)localObject).k(md(), paramView);
    }
    a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(233069);
  }
  
  public final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(233072);
    RelativeLayout localRelativeLayout = this.DtO;
    p.j(localRelativeLayout, "rootView");
    if (localRelativeLayout.isSelected() != paramBoolean)
    {
      localRelativeLayout = this.DtO;
      p.j(localRelativeLayout, "rootView");
      localRelativeLayout.setSelected(paramBoolean);
    }
    AppMethodBeat.o(233072);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "", "onSubTypeClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-textstatus_release"})
  public static abstract interface a
  {
    public abstract void k(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.g
 * JD-Core Version:    0.7.0.1
 */