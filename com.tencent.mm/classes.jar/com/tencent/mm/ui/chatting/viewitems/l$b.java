package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l$b
  extends c.a
{
  public static Map<String, WeakReference<b>> Ilg;
  ImageView Ijf;
  RTChattingEmojiView Ilb;
  ImageView Ilc;
  ProgressBar Ild;
  ImageView Ile;
  TextView Ilf;
  
  static
  {
    AppMethodBeat.i(36923);
    Ilg = new HashMap();
    AppMethodBeat.o(36923);
  }
  
  public static void s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36922);
    if (!Ilg.containsKey(paramString))
    {
      ac.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(36922);
      return;
    }
    paramString = (b)((WeakReference)Ilg.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36922);
      return;
      paramString.Ild.setVisibility(8);
      paramString.Ilf.setVisibility(8);
      paramString.Ile.setVisibility(8);
      AppMethodBeat.o(36922);
      return;
      paramString.Ild.setVisibility(8);
      paramString.Ilf.setVisibility(8);
      paramString.Ile.setVisibility(0);
      paramString.Ild.setProgress(paramInt1);
      paramString.Ile.setImageResource(2131232024);
      AppMethodBeat.o(36922);
      return;
      paramString.Ild.setVisibility(0);
      paramString.Ilf.setVisibility(8);
      paramString.Ile.setVisibility(8);
      paramString.Ild.setProgress(0);
    }
  }
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    super.fX(paramView);
    this.fAz = ((TextView)paramView.findViewById(2131298178));
    this.Ilb = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.Ild = ((ProgressBar)paramView.findViewById(2131298082));
    this.Ile = ((ImageView)paramView.findViewById(2131298175));
    this.Ilf = ((TextView)paramView.findViewById(2131298171));
    if (!paramBoolean)
    {
      this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
      this.IhW = ((ImageView)paramView.findViewById(2131298174));
      this.Ijf = ((ImageView)paramView.findViewById(2131298176));
    }
    if (this.Ilc != null) {
      ((ViewGroup)this.Ilc.getParent()).setBackgroundDrawable(null);
    }
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    AppMethodBeat.o(36921);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */