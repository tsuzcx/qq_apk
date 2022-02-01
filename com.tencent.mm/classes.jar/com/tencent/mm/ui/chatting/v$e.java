package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.viewitems.bz;

public abstract class v$e
  implements View.OnClickListener
{
  public com.tencent.mm.ui.chatting.d.a aeiK;
  
  public v$e(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.aeiK = parama;
  }
  
  public abstract void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc);
  
  public final void onClick(View paramView)
  {
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = ((bz)paramView.getTag()).hTm;
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    a(paramView, this.aeiK, (cc)localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.e
 * JD-Core Version:    0.7.0.1
 */