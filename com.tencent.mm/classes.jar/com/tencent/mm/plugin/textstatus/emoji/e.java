package com.tencent.mm.plugin.textstatus.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.proto.ap;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "emojiData", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiData;", "emojiTv", "Landroid/widget/TextView;", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "fillContent", "", "onClick", "v", "plugin-textstatus_release"})
public final class e
  extends RecyclerView.v
  implements View.OnClickListener
{
  private RelativeLayout DtO;
  TextView Dwi;
  ap MBa;
  private final a MBb;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(236719);
    View localView = paramView.findViewById(b.e.root);
    p.j(localView, "itemView.findViewById(R.id.root)");
    this.DtO = ((RelativeLayout)localView);
    paramView = paramView.findViewById(b.e.emoji_text);
    p.j(paramView, "itemView.findViewById(R.id.emoji_text)");
    this.Dwi = ((TextView)paramView);
    this.MBb = parama;
    this.DtO.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(236719);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236716);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = new StringBuilder("onClick ");
    paramView = this.MBa;
    if (paramView != null) {}
    for (paramView = paramView.MGH;; paramView = null)
    {
      Log.d("WxIme.ImeEmojiGridAdapter", paramView);
      a locala = this.MBb;
      if (locala != null)
      {
        paramView = this.MBa;
        if (paramView != null)
        {
          localObject = paramView.content;
          paramView = (View)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramView = "";
        }
        locala.beq(paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236716);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.e
 * JD-Core Version:    0.7.0.1
 */