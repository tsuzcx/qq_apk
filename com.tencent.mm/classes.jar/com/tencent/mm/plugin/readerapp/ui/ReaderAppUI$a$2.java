package com.tencent.mm.plugin.readerapp.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ReaderAppUI$a$2
  implements e.a
{
  ReaderAppUI$a$2(ReaderAppUI.a parama, boolean paramBoolean, ReaderAppUI.a.b paramb) {}
  
  public final void onFinish()
  {
    AppMethodBeat.i(76823);
    if (!this.pUo)
    {
      this.pUp.pUs.setTextColor(this.pUn.pUg.getContext().getResources().getColor(2131690709));
      this.pUp.pUs.setBackgroundResource(2130837928);
    }
    this.pUp.pUt.setVisibility(0);
    AppMethodBeat.o(76823);
  }
  
  public final void onStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.2
 * JD-Core Version:    0.7.0.1
 */