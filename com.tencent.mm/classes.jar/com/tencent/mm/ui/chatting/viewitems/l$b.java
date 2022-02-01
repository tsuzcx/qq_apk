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
  public static Map<String, WeakReference<b>> GLj;
  ImageView GJi;
  RTChattingEmojiView GLe;
  ImageView GLf;
  ProgressBar GLg;
  ImageView GLh;
  TextView GLi;
  ProgressBar uPp;
  
  static
  {
    AppMethodBeat.i(36923);
    GLj = new HashMap();
    AppMethodBeat.o(36923);
  }
  
  public static void t(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36922);
    if (!GLj.containsKey(paramString))
    {
      ad.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(36922);
      return;
    }
    paramString = (b)((WeakReference)GLj.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36922);
      return;
      paramString.GLg.setVisibility(8);
      paramString.GLi.setVisibility(8);
      paramString.GLh.setVisibility(8);
      AppMethodBeat.o(36922);
      return;
      paramString.GLg.setVisibility(8);
      paramString.GLi.setVisibility(8);
      paramString.GLh.setVisibility(0);
      paramString.GLg.setProgress(paramInt1);
      paramString.GLh.setImageResource(2131232024);
      AppMethodBeat.o(36922);
      return;
      paramString.GLg.setVisibility(0);
      paramString.GLi.setVisibility(8);
      paramString.GLh.setVisibility(8);
      paramString.GLg.setProgress(0);
    }
  }
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    super.fK(paramView);
    this.fwS = ((TextView)paramView.findViewById(2131298178));
    this.GLe = ((RTChattingEmojiView)paramView.findViewById(2131298074));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.GLg = ((ProgressBar)paramView.findViewById(2131298082));
    this.GLh = ((ImageView)paramView.findViewById(2131298175));
    this.GLi = ((TextView)paramView.findViewById(2131298171));
    if (!paramBoolean)
    {
      this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.GJi = ((ImageView)paramView.findViewById(2131298176));
    }
    if (this.GLf != null) {
      ((ViewGroup)this.GLf.getParent()).setBackgroundDrawable(null);
    }
    this.wet = ((TextView)paramView.findViewById(2131298185));
    AppMethodBeat.o(36921);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */