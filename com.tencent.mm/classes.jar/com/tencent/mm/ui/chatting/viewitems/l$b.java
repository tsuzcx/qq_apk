package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l$b
  extends c.a
{
  public static Map<String, WeakReference<b>> KxW;
  ImageView KvW;
  RTChattingEmojiView KxR;
  ImageView KxS;
  ProgressBar KxT;
  ImageView KxU;
  TextView KxV;
  
  static
  {
    AppMethodBeat.i(36923);
    KxW = new HashMap();
    AppMethodBeat.o(36923);
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36922);
    if (!KxW.containsKey(paramString))
    {
      ae.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(36922);
      return;
    }
    paramString = (b)((WeakReference)KxW.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36922);
      return;
      paramString.KxT.setVisibility(8);
      paramString.KxV.setVisibility(8);
      paramString.KxU.setVisibility(8);
      AppMethodBeat.o(36922);
      return;
      paramString.KxT.setVisibility(8);
      paramString.KxV.setVisibility(8);
      paramString.KxU.setVisibility(0);
      paramString.KxT.setProgress(paramInt1);
      paramString.KxU.setImageResource(2131232024);
      AppMethodBeat.o(36922);
      return;
      paramString.KxT.setVisibility(0);
      paramString.KxV.setVisibility(8);
      paramString.KxU.setVisibility(8);
      paramString.KxT.setProgress(0);
    }
  }
  
  public final c.a E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    super.gs(paramView);
    this.fVV = ((TextView)paramView.findViewById(2131298178));
    this.KxR = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.KxT = ((ProgressBar)paramView.findViewById(2131298082));
    this.KxU = ((ImageView)paramView.findViewById(2131298175));
    this.KxV = ((TextView)paramView.findViewById(2131298171));
    if (!paramBoolean)
    {
      this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
      this.KuL = ((ImageView)paramView.findViewById(2131298174));
      this.KvW = ((ImageView)paramView.findViewById(2131298176));
    }
    if (this.KxS != null) {
      ((ViewGroup)this.KxS.getParent()).setBackgroundDrawable(null);
    }
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    AppMethodBeat.o(36921);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */