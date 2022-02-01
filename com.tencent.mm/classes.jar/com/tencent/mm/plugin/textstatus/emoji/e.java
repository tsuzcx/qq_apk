package com.tencent.mm.plugin.textstatus.emoji;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.proto.bm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;)V", "emojiData", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiData;", "emojiTv", "Landroid/widget/TextView;", "mListener", "rootView", "Landroid/widget/RelativeLayout;", "fillContent", "", "onClick", "v", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.v
  implements View.OnClickListener
{
  private RelativeLayout Ikt;
  TextView Jpo;
  bm TkG;
  private final a TkH;
  
  public e(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(290767);
    View localView = paramView.findViewById(a.e.root);
    s.s(localView, "itemView.findViewById(R.id.root)");
    this.Ikt = ((RelativeLayout)localView);
    paramView = paramView.findViewById(a.e.emoji_text);
    s.s(paramView, "itemView.findViewById(R.id.emoji_text)");
    this.Jpo = ((TextView)paramView);
    this.TkH = parama;
    this.Ikt.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(290767);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(290786);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = this.TkG;
    a locala;
    if (paramView == null)
    {
      paramView = null;
      Log.d("WxIme.ImeEmojiGridAdapter", s.X("onClick ", paramView));
      locala = this.TkH;
      if (locala != null)
      {
        paramView = this.TkG;
        if (paramView != null) {
          break label110;
        }
        paramView = "";
      }
    }
    for (;;)
    {
      locala.bdQ(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290786);
      return;
      paramView = paramView.Trr;
      break;
      label110:
      localObject = paramView.content;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.emoji.e
 * JD-Core Version:    0.7.0.1
 */