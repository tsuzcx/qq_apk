package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ChattingSendDataToDeviceUI$1
  implements View.OnClickListener
{
  ChattingSendDataToDeviceUI$1(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34634);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.JCP.onBackPressed();
    a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.1
 * JD-Core Version:    0.7.0.1
 */