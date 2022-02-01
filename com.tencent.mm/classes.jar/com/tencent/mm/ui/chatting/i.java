package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  private ChatFooterCustom Pgh;
  private FrameLayout Pgi;
  private View.OnClickListener ko;
  private LinearLayout rmL;
  
  public i(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34385);
    this.ko = new i.1(this);
    this.Pgh = paramChatFooterCustom;
    AppMethodBeat.o(34385);
  }
  
  public final void gKK()
  {
    AppMethodBeat.i(34386);
    Log.i("MicroMsg.ChattingDownloaderFooterHandler", "initFooter");
    this.Pgh.setVisibility(8);
    this.Pgh.findViewById(2131298443).setVisibility(8);
    this.Pgh.findViewById(2131298437).setVisibility(8);
    this.rmL = ((LinearLayout)this.Pgh.findViewById(2131298438));
    this.rmL.setWeightSum(1.0F);
    this.Pgi = ((FrameLayout)this.rmL.getChildAt(0));
    this.Pgi.setVisibility(0);
    this.Pgi.setOnClickListener(this.ko);
    ((TextView)this.Pgi.findViewById(2131298440)).setText(2131758415);
    this.Pgi.findViewById(2131298439).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.rmL.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i
 * JD-Core Version:    0.7.0.1
 */