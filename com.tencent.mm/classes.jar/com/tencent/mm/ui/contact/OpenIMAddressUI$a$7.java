package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.y;

final class OpenIMAddressUI$a$7
  implements Runnable
{
  OpenIMAddressUI$a$7(OpenIMAddressUI.a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
    View localView = this.vMP.findViewById(R.h.loading_tips_area);
    if (localView != null)
    {
      localView.setVisibility(8);
      localView.startAnimation(AnimationUtils.loadAnimation(this.vMP.getContext(), R.a.fast_faded_out));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.a.7
 * JD-Core Version:    0.7.0.1
 */