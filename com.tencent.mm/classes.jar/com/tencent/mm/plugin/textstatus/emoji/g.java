package com.tencent.mm.plugin.textstatus.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "typeName", "", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "(Landroid/view/View;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;)V", "getListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "rootView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "subType", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "subTypeTv", "Landroid/widget/TextView;", "getTypeName", "()Ljava/lang/String;", "fillContent", "", "onClick", "v", "onSelect", "select", "", "IAlternativePyViewListener", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.v
  implements View.OnClickListener
{
  private final RelativeLayout Ikt;
  TextView Jpz;
  f TkF;
  private final a TkI;
  private final String typeName;
  
  public g(View paramView, String paramString, a parama)
  {
    super(paramView);
    AppMethodBeat.i(290792);
    this.typeName = paramString;
    this.TkI = parama;
    this.Ikt = ((RelativeLayout)paramView.findViewById(a.e.root));
    paramView = paramView.findViewById(a.e.emoji_subtype_item_tv);
    s.s(paramView, "itemView.findViewById(R.id.emoji_subtype_item_tv)");
    this.Jpz = ((TextView)paramView);
    AppMethodBeat.o(290792);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(290803);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    s.u(paramView, "v");
    localObject = this.TkI;
    if (localObject != null)
    {
      wL(true);
      ((a)localObject).r(KJ(), paramView);
    }
    a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290803);
  }
  
  public final void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(290814);
    if (this.Ikt.isSelected() != paramBoolean) {
      this.Ikt.setSelected(paramBoolean);
    }
    AppMethodBeat.o(290814);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "", "onSubTypeClick", "", "position", "", "itemView", "Landroid/view/View;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void r(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.g
 * JD-Core Version:    0.7.0.1
 */