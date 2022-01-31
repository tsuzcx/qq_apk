package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.y;

final class AddressUI$a$11
  implements Runnable
{
  AddressUI$a$11(AddressUI.a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.AddressUI", "post to first init finish");
    View localView = this.vJs.findViewById(R.h.loading_tips_area);
    if (localView != null)
    {
      localView.setVisibility(8);
      localView.startAnimation(AnimationUtils.loadAnimation(this.vJs.getContext(), R.a.fast_faded_out));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.11
 * JD-Core Version:    0.7.0.1
 */