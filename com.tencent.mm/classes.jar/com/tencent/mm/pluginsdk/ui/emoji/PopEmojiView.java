package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class PopEmojiView
  extends LinearLayout
{
  private ProgressBar YlA;
  private MMEmojiView Ylz;
  private ViewGroup tth;
  
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
    this.tth = ((ViewGroup)inflate(getContext(), a.h.preview_emoji, null));
    this.Ylz = ((MMEmojiView)this.tth.findViewById(a.g.image));
    this.Ylz.setIsMaxSizeLimit(true);
    this.Ylz.setMaxSize(paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_size) - paramContext.getResources().getDimensionPixelSize(a.e.MiddlePadding) * 3);
    this.YlA = ((ProgressBar)this.tth.findViewById(a.g.progress));
    addView(this.tth, -1, -1);
    AppMethodBeat.o(104718);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104720);
    if (this.Ylz != null) {
      this.Ylz.b(paramEmojiInfo, "");
    }
    AppMethodBeat.o(104720);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104721);
    if ((this.Ylz != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.Ylz.getEmojiDensity());
      this.Ylz.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104721);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104719);
    if (this.Ylz != null) {
      this.Ylz.setImageResource(paramInt);
    }
    AppMethodBeat.o(104719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView
 * JD-Core Version:    0.7.0.1
 */