package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class k$b
  extends c.a
{
  public static Map<String, WeakReference<b>> zTX;
  ProgressBar pNd;
  ImageView zSm;
  RTChattingEmojiView zTS;
  ImageView zTT;
  ProgressBar zTU;
  ImageView zTV;
  TextView zTW;
  
  static
  {
    AppMethodBeat.i(32939);
    zTX = new HashMap();
    AppMethodBeat.o(32939);
  }
  
  public static void v(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32938);
    if (!zTX.containsKey(paramString))
    {
      ab.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(32938);
      return;
    }
    paramString = (b)((WeakReference)zTX.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(32938);
      return;
      paramString.zTU.setVisibility(8);
      paramString.zTW.setVisibility(8);
      paramString.zTV.setVisibility(8);
      AppMethodBeat.o(32938);
      return;
      paramString.zTU.setVisibility(8);
      paramString.zTW.setVisibility(8);
      paramString.zTV.setVisibility(0);
      paramString.zTU.setProgress(paramInt1);
      paramString.zTV.setImageResource(2130838613);
      AppMethodBeat.o(32938);
      return;
      paramString.zTU.setVisibility(0);
      paramString.zTW.setVisibility(8);
      paramString.zTV.setVisibility(8);
      paramString.zTU.setProgress(0);
    }
  }
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(32937);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zTS = ((RTChattingEmojiView)paramView.findViewById(2131822642));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.zTU = ((ProgressBar)paramView.findViewById(2131822643));
    this.zTV = ((ImageView)paramView.findViewById(2131822645));
    this.zTW = ((TextView)paramView.findViewById(2131822644));
    if (!paramBoolean)
    {
      this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
      this.zRC = ((ImageView)paramView.findViewById(2131822695));
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
    }
    if (this.zTT != null) {
      ((ViewGroup)this.zTT.getParent()).setBackgroundDrawable(null);
    }
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    AppMethodBeat.o(32937);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.b
 * JD-Core Version:    0.7.0.1
 */