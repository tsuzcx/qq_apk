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
  private ViewGroup iux;
  private MMEmojiView wad;
  private ProgressBar wae;
  
  public PopEmojiView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(62481);
    init(paramContext);
    AppMethodBeat.o(62481);
  }
  
  public PopEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62482);
    init(paramContext);
    AppMethodBeat.o(62482);
  }
  
  public PopEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62483);
    init(paramContext);
    AppMethodBeat.o(62483);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(62484);
    this.iux = ((ViewGroup)inflate(getContext(), 2130970433, null));
    this.wad = ((MMEmojiView)this.iux.findViewById(2131820629));
    this.wad.setIsMaxSizeLimit(true);
    this.wad.setMaxSize(paramContext.getResources().getDimensionPixelSize(2131428398) - paramContext.getResources().getDimensionPixelSize(2131427792) * 3);
    this.wae = ((ProgressBar)this.iux.findViewById(2131821404));
    addView(this.iux, -1, -1);
    AppMethodBeat.o(62484);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62486);
    if (this.wad != null) {
      this.wad.a(paramEmojiInfo, "");
    }
    AppMethodBeat.o(62486);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(62487);
    if ((this.wad != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.wad.getEmojiDensity());
      this.wad.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(62487);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(62485);
    if (this.wad != null) {
      this.wad.setImageResource(paramInt);
    }
    AppMethodBeat.o(62485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView
 * JD-Core Version:    0.7.0.1
 */