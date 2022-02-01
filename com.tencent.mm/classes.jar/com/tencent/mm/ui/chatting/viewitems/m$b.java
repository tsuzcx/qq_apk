package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class m$b
  extends c.a
{
  public static Map<String, WeakReference<b>> aePO;
  ImageView aeNG;
  RTChattingEmojiView aePJ;
  ImageView aePK;
  ProgressBar aePL;
  ImageView aePM;
  TextView aePN;
  
  static
  {
    AppMethodBeat.i(36923);
    aePO = new HashMap();
    AppMethodBeat.o(36923);
  }
  
  public static void y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36922);
    if (!aePO.containsKey(paramString))
    {
      Log.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(36922);
      return;
    }
    paramString = (b)((WeakReference)aePO.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36922);
      return;
      paramString.aePL.setVisibility(8);
      paramString.aePN.setVisibility(8);
      paramString.aePM.setVisibility(8);
      AppMethodBeat.o(36922);
      return;
      paramString.aePL.setVisibility(8);
      paramString.aePN.setVisibility(8);
      paramString.aePM.setVisibility(0);
      paramString.aePL.setProgress(paramInt1);
      paramString.aePM.setImageResource(R.g.emoji_download_failed_btn);
      AppMethodBeat.o(36922);
      return;
      paramString.aePL.setVisibility(0);
      paramString.aePN.setVisibility(8);
      paramString.aePM.setVisibility(8);
      paramString.aePL.setProgress(0);
    }
  }
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aePJ = ((RTChattingEmojiView)paramView.findViewById(R.h.fxz));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.aePL = ((ProgressBar)paramView.findViewById(R.h.fxH));
    this.aePM = ((ImageView)paramView.findViewById(R.h.fAk));
    this.aePN = ((TextView)paramView.findViewById(R.h.fAd));
    if (!paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    if (this.aePK != null) {
      ((ViewGroup)this.aePK.getParent()).setBackgroundDrawable(null);
    }
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    AppMethodBeat.o(36921);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.aePJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */