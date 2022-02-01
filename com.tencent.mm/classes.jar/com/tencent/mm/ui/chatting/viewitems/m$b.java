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
  public static Map<String, WeakReference<b>> XfM;
  ImageView XdI;
  RTChattingEmojiView XfH;
  ImageView XfI;
  ProgressBar XfJ;
  ImageView XfK;
  TextView XfL;
  
  static
  {
    AppMethodBeat.i(36923);
    XfM = new HashMap();
    AppMethodBeat.o(36923);
  }
  
  public static void v(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36922);
    if (!XfM.containsKey(paramString))
    {
      Log.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
      AppMethodBeat.o(36922);
      return;
    }
    paramString = (b)((WeakReference)XfM.get(paramString)).get();
    if (paramString != null) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36922);
      return;
      paramString.XfJ.setVisibility(8);
      paramString.XfL.setVisibility(8);
      paramString.XfK.setVisibility(8);
      AppMethodBeat.o(36922);
      return;
      paramString.XfJ.setVisibility(8);
      paramString.XfL.setVisibility(8);
      paramString.XfK.setVisibility(0);
      paramString.XfJ.setProgress(paramInt1);
      paramString.XfK.setImageResource(R.g.emoji_download_failed_btn);
      AppMethodBeat.o(36922);
      return;
      paramString.XfJ.setVisibility(0);
      paramString.XfL.setVisibility(8);
      paramString.XfK.setVisibility(8);
      paramString.XfJ.setProgress(0);
    }
  }
  
  public final c.a J(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36921);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.XfH = ((RTChattingEmojiView)paramView.findViewById(R.h.dxe));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.XfJ = ((ProgressBar)paramView.findViewById(R.h.dxm));
    this.XfK = ((ImageView)paramView.findViewById(R.h.dzq));
    this.XfL = ((TextView)paramView.findViewById(R.h.dzj));
    if (!paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    if (this.XfI != null) {
      ((ViewGroup)this.XfI.getParent()).setBackgroundDrawable(null);
    }
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    AppMethodBeat.o(36921);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.XfH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */