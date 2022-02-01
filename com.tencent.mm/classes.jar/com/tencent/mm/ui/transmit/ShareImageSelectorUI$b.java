package com.tencent.mm.ui.transmit;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.MMImageView;

final class ShareImageSelectorUI$b
{
  MMImageView AkD;
  TextView afPH;
  
  public ShareImageSelectorUI$b(ShareImageSelectorUI paramShareImageSelectorUI, View paramView)
  {
    AppMethodBeat.i(39463);
    this.AkD = ((MMImageView)paramView.findViewById(R.h.item_icon));
    this.afPH = ((TextView)paramView.findViewById(R.h.fLJ));
    AppMethodBeat.o(39463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI.b
 * JD-Core Version:    0.7.0.1
 */