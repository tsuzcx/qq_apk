package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;

final class e$3
  implements View.OnClickListener
{
  e$3(e parame) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = bk.a((Boolean)paramView.getTag(), false);
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      paramView.setTag(Boolean.valueOf(bool1));
      if (!bool2) {
        break label105;
      }
      e.j(this.pYP).setVisibility(8);
      Toast.makeText(this.pYP.getActivity(), "stop face detect", 0).show();
    }
    for (;;)
    {
      if ((this.pYP.pWz != null) && (this.pYP.pWz.get() != null)) {
        ((c)this.pYP.pWz.get()).bQS();
      }
      return;
      bool1 = false;
      break;
      label105:
      Toast.makeText(this.pYP.getActivity(), "start face detect", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.3
 * JD-Core Version:    0.7.0.1
 */