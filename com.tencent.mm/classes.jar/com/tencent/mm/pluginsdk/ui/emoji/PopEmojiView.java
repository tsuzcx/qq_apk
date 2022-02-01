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
  private MMEmojiView Ffd;
  private ProgressBar Ffe;
  private ViewGroup lYb;
  
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
    this.lYb = ((ViewGroup)inflate(getContext(), 2131495106, null));
    this.Ffd = ((MMEmojiView)this.lYb.findViewById(2131300914));
    this.Ffd.setIsMaxSizeLimit(true);
    this.Ffd.setMaxSize(paramContext.getResources().getDimensionPixelSize(2131166264) - paramContext.getResources().getDimensionPixelSize(2131165500) * 3);
    this.Ffe = ((ProgressBar)this.lYb.findViewById(2131303515));
    addView(this.lYb, -1, -1);
    AppMethodBeat.o(104718);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104720);
    if (this.Ffd != null) {
      this.Ffd.a(paramEmojiInfo, "");
    }
    AppMethodBeat.o(104720);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104721);
    if ((this.Ffd != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.Ffd.getEmojiDensity());
      this.Ffd.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104721);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104719);
    if (this.Ffd != null) {
      this.Ffd.setImageResource(paramInt);
    }
    AppMethodBeat.o(104719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView
 * JD-Core Version:    0.7.0.1
 */