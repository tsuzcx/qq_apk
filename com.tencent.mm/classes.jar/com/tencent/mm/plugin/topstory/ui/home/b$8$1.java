package com.tencent.mm.plugin.topstory.ui.home;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.d.b;
import com.tencent.mm.plugin.topstory.ui.webview.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

final class b$8$1
  implements Runnable
{
  b$8$1(b.8 param8, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(1585);
    if (this.val$bitmap != null) {
      this.tgJ.tgF.tgP.setImageBitmap(this.val$bitmap);
    }
    for (;;)
    {
      this.tgJ.tgF.tgP.setVisibility(0);
      ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", new Object[] { Integer.valueOf(this.tgJ.tgF.tgO.getWidth()), Integer.valueOf(this.tgJ.tgF.tgO.getHeight()), Integer.valueOf(this.tgJ.tgF.tgP.getWidth()), Integer.valueOf(this.tgJ.tgF.tgP.getHeight()) });
      if (this.tgJ.tgw.tgn.getParent() != null)
      {
        ((ViewGroup)this.tgJ.tgw.tgn.getParent()).removeView(this.tgJ.tgw.tgn);
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + this.tgJ.tgG);
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ((b.a)this.tgJ.tgw.rQS.get(this.tgJ.tgw.stw)).tgO.addView(this.tgJ.tgw.tgn, localLayoutParams);
      ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.tgJ.tgw.stw);
      this.tgJ.tgw.tgd.k(this.tgJ.tgH.tfL, this.tgJ.tgH.tfM, this.tgJ.tgH.tfN, this.tgJ.tgI);
      AppMethodBeat.o(1585);
      return;
      this.tgJ.tgF.tgP.setImageDrawable(this.tgJ.tgw.tfZ.getResources().getDrawable(2131689498));
      this.tgJ.tgF.tgQ = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.8.1
 * JD-Core Version:    0.7.0.1
 */