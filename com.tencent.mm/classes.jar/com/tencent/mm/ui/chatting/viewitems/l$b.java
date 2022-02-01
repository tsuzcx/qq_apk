package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l$b
  extends c.a
{
  public static Map<String, WeakReference<b>> PKm;
  ImageView PIn;
  RTChattingEmojiView PKh;
  ImageView PKi;
  ProgressBar PKj;
  ImageView PKk;
  TextView PKl;
  
  static
  {
    AppMethodBeat.i(36923);
    PKm = new HashMap();
    AppMethodBeat.o(36923);
  }
  
  public static void u(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36922);
    if (!PKm.containsKey(paramString))
    {
      Log.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(36922);
      return;
    }
    paramString = (b)((WeakReference)PKm.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36922);
      return;
      paramString.PKj.setVisibility(8);
      paramString.PKl.setVisibility(8);
      paramString.PKk.setVisibility(8);
      AppMethodBeat.o(36922);
      return;
      paramString.PKj.setVisibility(8);
      paramString.PKl.setVisibility(8);
      paramString.PKk.setVisibility(0);
      paramString.PKj.setProgress(paramInt1);
      paramString.PKk.setImageResource(2131232115);
      AppMethodBeat.o(36922);
      return;
      paramString.PKj.setVisibility(0);
      paramString.PKl.setVisibility(8);
      paramString.PKk.setVisibility(8);
      paramString.PKj.setProgress(0);
    }
  }
  
  public final c.a G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PKh = ((RTChattingEmojiView)paramView.findViewById(2131298417));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.PKj = ((ProgressBar)paramView.findViewById(2131298425));
    this.PKk = ((ImageView)paramView.findViewById(2131298555));
    this.PKl = ((TextView)paramView.findViewById(2131298550));
    if (!paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.PIn = ((ImageView)paramView.findViewById(2131298556));
    }
    if (this.PKi != null) {
      ((ViewGroup)this.PKi.getParent()).setBackgroundDrawable(null);
    }
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    AppMethodBeat.o(36921);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.PKh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */