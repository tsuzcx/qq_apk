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
  private MMEmojiView Kow;
  private ProgressBar Kox;
  private ViewGroup nmW;
  
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
    this.nmW = ((ViewGroup)inflate(getContext(), 2131495949, null));
    this.Kow = ((MMEmojiView)this.nmW.findViewById(2131302526));
    this.Kow.setIsMaxSizeLimit(true);
    this.Kow.setMaxSize(paramContext.getResources().getDimensionPixelSize(2131166307) - paramContext.getResources().getDimensionPixelSize(2131165518) * 3);
    this.Kox = ((ProgressBar)this.nmW.findViewById(2131306281));
    addView(this.nmW, -1, -1);
    AppMethodBeat.o(104718);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104720);
    if (this.Kow != null) {
      this.Kow.b(paramEmojiInfo, "");
    }
    AppMethodBeat.o(104720);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104721);
    if ((this.Kow != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.Kow.getEmojiDensity());
      this.Kow.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(104721);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104719);
    if (this.Kow != null) {
      this.Kow.setImageResource(paramInt);
    }
    AppMethodBeat.o(104719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView
 * JD-Core Version:    0.7.0.1
 */