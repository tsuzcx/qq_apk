package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
{
  private ChatFooterCustom JUU;
  private FrameLayout JUV;
  private View.OnClickListener km;
  private LinearLayout pVM;
  
  public i(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34385);
    this.km = new i.1(this);
    this.JUU = paramChatFooterCustom;
    AppMethodBeat.o(34385);
  }
  
  public final void fCL()
  {
    AppMethodBeat.i(34386);
    ae.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
    this.JUU.setVisibility(8);
    this.JUU.findViewById(2131298098).setVisibility(8);
    this.JUU.findViewById(2131298092).setVisibility(8);
    this.pVM = ((LinearLayout)this.JUU.findViewById(2131298093));
    this.pVM.setWeightSum(1.0F);
    this.JUV = ((FrameLayout)this.pVM.getChildAt(0));
    this.JUV.setVisibility(0);
    this.JUV.setOnClickListener(this.km);
    ((TextView)this.JUV.findViewById(2131298095)).setText(2131758142);
    this.JUV.findViewById(2131298094).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.pVM.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i
 * JD-Core Version:    0.7.0.1
 */