package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class ak$2
  implements View.OnClickListener
{
  ak$2(ak paramak) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38599);
    if (!e.cN(this.rLM.videoPath))
    {
      ab.i("MicroMsg.SightWidget", "click videopath is not exist " + this.rLM.videoPath);
      AppMethodBeat.o(38599);
      return;
    }
    if (this.rLM.rLL != null)
    {
      this.rLM.rLL.dismiss();
      this.rLM.rLL = null;
    }
    this.rLM.rLL = new c(this.rLM.cmc);
    paramView = this.rLM.rLL;
    String str1 = this.rLM.videoPath;
    String str2 = this.rLM.thumbPath;
    paramView.eNO = str1;
    paramView.imagePath = str2;
    paramView = this.rLM.rLL;
    paramView.cKC = 0;
    paramView.qTq = 0;
    paramView.mwo = 1;
    this.rLM.rLL.show();
    AppMethodBeat.o(38599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.2
 * JD-Core Version:    0.7.0.1
 */