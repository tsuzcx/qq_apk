package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;

final class AppAttachFileListUI$2
  implements AdapterView.OnItemClickListener
{
  AppAttachFileListUI$2(AppAttachFileListUI paramAppAttachFileListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34182);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    paramView = new Intent();
    paramView.setClassName(this.PdK, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    paramView.putExtra("app_msg_id", ((AppAttachFileListUI.c)AppAttachFileListUI.a(this.PdK).get(paramInt)).dTX.field_msgId);
    paramView.setFlags(67108864);
    paramAdapterView = this.PdK;
    paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.axQ(), "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramAdapterView.startActivity((Intent)paramView.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachFileListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(34182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachFileListUI.2
 * JD-Core Version:    0.7.0.1
 */