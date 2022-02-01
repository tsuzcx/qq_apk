package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.Sort3rdAppUI;
import java.util.List;

final class ChattingSendDataToDeviceUI$5
  implements AdapterView.OnItemClickListener
{
  ChattingSendDataToDeviceUI$5(ChattingSendDataToDeviceUI paramChattingSendDataToDeviceUI) {}
  
  public final void onItemClick(final AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34639);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    ae.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == paramAdapterView.getAdapter().getCount() - 1)
    {
      paramView = new Intent(this.JXG, Sort3rdAppUI.class);
      paramView.addFlags(67108864);
      paramView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(this.JXG));
      paramAdapterView = this.JXG;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, paramView.ahE(), "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramAdapterView.startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramAdapterView, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(34639);
      return;
      if ((this.JXG.JSS) && (paramInt == paramAdapterView.getAdapter().getCount() - 2))
      {
        if ((this.JXG.filePath == null) || (this.JXG.fXl == null))
        {
          com.tencent.mm.ui.base.h.cm(this.JXG.getBaseContext(), this.JXG.getString(2131758111));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(34639);
          return;
        }
        com.tencent.mm.pluginsdk.ui.tools.a.b(this.JXG, this.JXG.filePath, this.JXG.fXl.toLowerCase(), 1);
      }
      else if ((paramInt >= 0) && (paramInt < paramAdapterView.getAdapter().getCount() - 1))
      {
        paramAdapterView = (g)ChattingSendDataToDeviceUI.i(this.JXG).get(paramInt);
        if (!com.tencent.mm.pluginsdk.model.app.h.a(this.JXG.getBaseContext(), paramAdapterView))
        {
          com.tencent.mm.ui.base.h.cm(this.JXG.getBaseContext(), this.JXG.getString(2131757304));
          paramAdapterView.field_status = 4;
          ao.dBg().a(paramAdapterView, new String[0]);
          ChattingSendDataToDeviceUI.j(this.JXG);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(34639);
          return;
        }
        com.tencent.mm.ch.a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34638);
            com.tencent.mm.pluginsdk.model.app.h.a(ChattingSendDataToDeviceUI.5.this.JXG.getBaseContext(), paramAdapterView.field_packageName, ChattingSendDataToDeviceUI.5.this.JXG.nTL, paramAdapterView.field_appId, paramAdapterView.field_openId, 0, null, null);
            AppMethodBeat.o(34638);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.5
 * JD-Core Version:    0.7.0.1
 */