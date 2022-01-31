package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class j$1$1
  implements Runnable
{
  j$1$1(j.1 param1) {}
  
  public final void run()
  {
    if (this.vUN.vUM.vUL != null)
    {
      this.vUN.vUM.vUL.setVisibility(8);
      this.vUN.vUM.vUL.removeAllViews();
    }
    a locala = e.a(this.vUN.val$context, e.a.vUw, null);
    Object localObject = locala;
    if (locala == null) {
      localObject = e.a(this.vUN.val$context, e.a.vUq, null);
    }
    if ((localObject != null) && (((a)localObject).getView() != null))
    {
      y.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
      this.vUN.vUM.vUL.setVisibility(0);
      localObject = ((a)localObject).getView();
      this.vUN.vUM.vUL.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j.1.1
 * JD-Core Version:    0.7.0.1
 */