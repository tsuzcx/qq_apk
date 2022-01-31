package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.plugin.l.a.f;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class PopEmojiView
  extends LinearLayout
{
  private ViewGroup gVj;
  private MMEmojiView shL;
  private ProgressBar shM;
  
  public PopEmojiView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PopEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PopEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.gVj = ((ViewGroup)inflate(getContext(), a.f.preview_emoji, null));
    this.shL = ((MMEmojiView)this.gVj.findViewById(a.e.image));
    this.shL.setIsMaxSizeLimit(true);
    this.shL.setMaxSize(paramContext.getResources().getDimensionPixelSize(a.c.emoji_view_image_size) - paramContext.getResources().getDimensionPixelSize(a.c.MiddlePadding) * 3);
    this.shM = ((ProgressBar)this.gVj.findViewById(a.e.progress));
    addView(this.gVj, -1, -1);
  }
  
  public void setEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    if (this.shL != null) {
      this.shL.a(paramEmojiInfo, "");
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if ((this.shL != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.setDensity(this.shL.getEmojiDensity());
      this.shL.setImageBitmap(paramBitmap);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.shL != null) {
      this.shL.setImageResource(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView
 * JD-Core Version:    0.7.0.1
 */