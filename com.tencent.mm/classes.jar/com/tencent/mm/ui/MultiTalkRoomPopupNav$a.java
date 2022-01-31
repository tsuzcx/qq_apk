package com.tencent.mm.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiTalkRoomPopupNav$a
{
  private Button mlV;
  TextView titleView;
  LinearLayout zdQ;
  
  private MultiTalkRoomPopupNav$a(MultiTalkRoomPopupNav paramMultiTalkRoomPopupNav, boolean paramBoolean)
  {
    AppMethodBeat.i(29772);
    this.mlV = ((Button)paramMultiTalkRoomPopupNav.findViewById(2131826438));
    this.titleView = ((TextView)paramMultiTalkRoomPopupNav.findViewById(2131826434));
    this.zdQ = ((LinearLayout)paramMultiTalkRoomPopupNav.findViewById(2131826433));
    if (paramBoolean)
    {
      this.zdQ.setBackgroundResource(2130839747);
      this.mlV.setTextColor(paramMultiTalkRoomPopupNav.getResources().getColor(2131690300));
      AppMethodBeat.o(29772);
      return;
    }
    this.zdQ.setBackgroundResource(2130839739);
    this.mlV.setTextColor(paramMultiTalkRoomPopupNav.getResources().getColor(2131689819));
    AppMethodBeat.o(29772);
  }
  
  final void close()
  {
    AppMethodBeat.i(29773);
    this.zdQ.setVisibility(8);
    AppMethodBeat.o(29773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav.a
 * JD-Core Version:    0.7.0.1
 */