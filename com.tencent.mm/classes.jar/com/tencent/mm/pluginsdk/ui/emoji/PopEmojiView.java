package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class PopEmojiView
  extends LinearLayout
{
  private MMEmojiView ChD;
  private ProgressBar ChE;
  private ViewGroup kWT;
  
  public PopEmojiView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(104715);
    init(paramContext);
    AppMethodBeat.o(104715);
  }
  
  public PopEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104716);
    init(paramContext);
    AppMethodBeat.o(104716);
  }
  
  public PopEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104717);
    init(paramContext);
    AppMethodBeat.o(104717);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(104718);
    this.kWT = ((ViewGroup)inflate(getContext(), 2131495106, null));
    this.ChD = ((MMEmojiView)this.kWT.findViewById(2131300914));
    this.ChD.setIsMaxSizeLimit(true);
    this.ChD.setMaxSize(paramContext.getResources().getDimensionPixelSize(2131166264) - paramContext.getResources().getDimensionPixelSize(2131165500) * 3);
    this.ChE = ((ProgressBar)this.kWT.findViewById(2131303515));
    addView(this.kWT, -1, -1);
    AppMethodBeat.o(104718);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104720);
    if (this.ChD != null) {
      this.ChD.a(paramEmojiInfo, "");
    }
    AppMethodBeat.o(104720);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104721);
    if ((this.ChD != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.ChD.getEmojiDensity());
      this.ChD.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104721);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104719);
    if (this.ChD != null) {
      this.ChD.setImageResource(paramInt);
    }
    AppMethodBeat.o(104719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView
 * JD-Core Version:    0.7.0.1
 */