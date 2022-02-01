package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l$b
  extends c.a
{
  public static Map<String, WeakReference<b>> KbE;
  ImageView JZD;
  ImageView KbA;
  ProgressBar KbB;
  ImageView KbC;
  TextView KbD;
  RTChattingEmojiView Kbz;
  
  static
  {
    AppMethodBeat.i(36923);
    KbE = new HashMap();
    AppMethodBeat.o(36923);
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36922);
    if (!KbE.containsKey(paramString))
    {
      ad.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(36922);
      return;
    }
    paramString = (b)((WeakReference)KbE.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36922);
      return;
      paramString.KbB.setVisibility(8);
      paramString.KbD.setVisibility(8);
      paramString.KbC.setVisibility(8);
      AppMethodBeat.o(36922);
      return;
      paramString.KbB.setVisibility(8);
      paramString.KbD.setVisibility(8);
      paramString.KbC.setVisibility(0);
      paramString.KbB.setProgress(paramInt1);
      paramString.KbC.setImageResource(2131232024);
      AppMethodBeat.o(36922);
      return;
      paramString.KbB.setVisibility(0);
      paramString.KbD.setVisibility(8);
      paramString.KbC.setVisibility(8);
      paramString.KbB.setProgress(0);
    }
  }
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    super.gn(paramView);
    this.fTP = ((TextView)paramView.findViewById(2131298178));
    this.Kbz = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.KbB = ((ProgressBar)paramView.findViewById(2131298082));
    this.KbC = ((ImageView)paramView.findViewById(2131298175));
    this.KbD = ((TextView)paramView.findViewById(2131298171));
    if (!paramBoolean)
    {
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.JZD = ((ImageView)paramView.findViewById(2131298176));
    }
    if (this.KbA != null) {
      ((ViewGroup)this.KbA.getParent()).setBackgroundDrawable(null);
    }
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    AppMethodBeat.o(36921);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */