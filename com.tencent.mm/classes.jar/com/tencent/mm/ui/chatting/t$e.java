package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.viewitems.bq;

public abstract class t$e
  implements View.OnClickListener
{
  public com.tencent.mm.ui.chatting.e.a PhN;
  
  public t$e(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.PhN = parama;
  }
  
  public abstract void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca);
  
  public final void onClick(View paramView)
  {
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = ((bq)paramView.getTag()).dTX;
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    a(paramView, this.PhN, (ca)localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.e
 * JD-Core Version:    0.7.0.1
 */