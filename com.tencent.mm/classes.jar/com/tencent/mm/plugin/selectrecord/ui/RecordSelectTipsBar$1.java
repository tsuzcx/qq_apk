package com.tencent.mm.plugin.selectrecord.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class RecordSelectTipsBar$1
  implements View.OnClickListener
{
  RecordSelectTipsBar$1(RecordSelectTipsBar paramRecordSelectTipsBar) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(255281);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicroMsg.recordSelect.RecordSelectTipsBar", "clear all select record");
    if (RecordSelectTipsBar.a(this.JcZ) != null)
    {
      paramView = com.tencent.mm.plugin.selectrecord.b.a.fFx();
      paramView.Jcx += 1;
      RecordSelectTipsBar.a(this.JcZ).fFF();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(255281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar.1
 * JD-Core Version:    0.7.0.1
 */