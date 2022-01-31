package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class k$b
  extends c.a
{
  public static Map<String, WeakReference<b>> vCU = new HashMap();
  ProgressBar nhQ;
  ImageView vBN;
  RTChattingEmojiView vCP;
  ImageView vCQ;
  ProgressBar vCR;
  ImageView vCS;
  TextView vCT;
  
  public static void l(String paramString, int paramInt1, int paramInt2)
  {
    if (!vCU.containsKey(paramString)) {
      y.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
    }
    do
    {
      return;
      paramString = (b)((WeakReference)vCU.get(paramString)).get();
    } while (paramString == null);
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      paramString.vCR.setVisibility(0);
      paramString.vCT.setVisibility(8);
      paramString.vCS.setVisibility(8);
      paramString.vCR.setProgress(0);
      return;
    case 1: 
      paramString.vCR.setVisibility(8);
      paramString.vCT.setVisibility(8);
      paramString.vCS.setVisibility(8);
      return;
    }
    paramString.vCR.setVisibility(8);
    paramString.vCT.setVisibility(8);
    paramString.vCS.setVisibility(0);
    paramString.vCR.setProgress(paramInt1);
    paramString.vCS.setImageResource(R.g.emoji_download_failed_btn);
  }
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vCP = ((RTChattingEmojiView)paramView.findViewById(R.h.chatting_content_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.vCR = ((ProgressBar)paramView.findViewById(R.h.chatting_download_progress));
    this.vCS = ((ImageView)paramView.findViewById(R.h.chatting_status_btn));
    this.vCT = ((TextView)paramView.findViewById(R.h.chatting_size_iv));
    if (!paramBoolean)
    {
      this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
      this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
      this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    if (this.vCQ != null) {
      ((ViewGroup)this.vCQ.getParent()).setBackgroundDrawable(null);
    }
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.b
 * JD-Core Version:    0.7.0.1
 */