package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class aj$e
  extends c.a
{
  View eML;
  ImageView vBN;
  MMNeatTextView vFN;
  ImageView vFO;
  TextView vFP;
  ViewStub vFQ;
  ChattingItemTranslate vFR;
  
  private static boolean cHf()
  {
    try
    {
      String str = com.tencent.mm.m.g.AA().getValue("CellTextViewEnable");
      int i = bk.getInt(str, 1);
      boolean bool = com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uyE, true);
      y.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((1 == i) && (bool)) {
        return true;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.vFN = ((MMNeatTextView)paramView.findViewById(R.h.chatting_content_itv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.eML = paramView.findViewById(R.h.chatting_content_area);
    this.vFQ = ((ViewStub)paramView.findViewById(R.h.translate_item_vs));
    if (paramBoolean)
    {
      this.vFO = ((ImageView)paramView.findViewById(R.h.chatting_bad_msg_icon));
      this.vFP = ((TextView)paramView.findViewById(R.h.chatting_view_full_text));
    }
    for (;;)
    {
      this.vFN.setOnTouchListener(new f(this.vFN, new m(this.vFN.getContext())));
      this.vFN.setIsOpen(cHf());
      this.vFN.setTextCrashListener(new aj.c((byte)0));
      return this;
      this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
      this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.e
 * JD-Core Version:    0.7.0.1
 */