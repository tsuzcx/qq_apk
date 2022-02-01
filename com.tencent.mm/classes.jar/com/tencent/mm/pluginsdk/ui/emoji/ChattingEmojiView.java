package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class ChattingEmojiView
  extends EmojiStatusView
{
  protected int Rpd;
  protected int Rpe;
  private String cacheKey;
  private EmojiInfo jHh;
  
  public ChattingEmojiView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ChattingEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104704);
    this.Rpd = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_size);
    this.Rpe = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_min_size);
    setDefaultImageResource(0);
    setGameUseCover(false);
    AppMethodBeat.o(104704);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104705);
    this.jHh = paramEmojiInfo;
    this.cacheKey = String.valueOf(paramLong);
    setImageDrawable(null);
    reload();
    AppMethodBeat.o(104705);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104708);
    super.onMeasure(paramInt1, paramInt2);
    int i;
    int j;
    float f;
    if ((getStatus() != 1) && (this.jHh != null))
    {
      paramInt2 = (int)(this.jHh.field_width * getEmojiDensityScale());
      i = (int)(this.jHh.field_height * getEmojiDensityScale());
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = this.Rpd;
      }
      paramInt2 = i;
      if (i <= 0) {
        paramInt2 = this.Rpd;
      }
      paramInt1 = Math.max(0, paramInt1);
      i = Math.max(0, paramInt2);
      paramInt2 = paramInt1;
      paramInt1 = i;
      i = paramInt2;
      if (paramInt2 <= 0) {
        i = this.Rpd;
      }
      j = paramInt1;
      if (paramInt1 <= 0) {
        j = this.Rpd;
      }
      if (j >= this.Rpe)
      {
        paramInt1 = j;
        paramInt2 = i;
        if (i >= this.Rpe) {}
      }
      else
      {
        if (i >= j) {
          break label281;
        }
        f = this.Rpe / i;
        paramInt2 = this.Rpe;
        paramInt1 = (int)(j * f);
      }
      label178:
      if (paramInt2 <= this.Rpd)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt1 <= this.Rpd) {}
      }
      else
      {
        if (paramInt2 <= paramInt1) {
          break label326;
        }
        f = this.Rpd / paramInt2;
        j = this.Rpd;
        i = (int)(paramInt1 * f);
      }
    }
    for (;;)
    {
      setMeasuredDimension(j, i);
      Log.d("MicroMsg.emoji.ChattingEmojiView", "onMeasure width:%d height:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(104708);
      return;
      paramInt2 = getIntrinsicWidth();
      paramInt1 = getIntrinsicHeight();
      break;
      label281:
      if (j < i)
      {
        f = this.Rpe / j;
        paramInt1 = this.Rpe;
        paramInt2 = (int)(i * f);
        break label178;
      }
      paramInt1 = this.Rpe;
      paramInt2 = this.Rpe;
      break label178;
      label326:
      if (paramInt1 > paramInt2)
      {
        f = this.Rpd / paramInt1;
        i = this.Rpd;
        j = (int)(paramInt2 * f);
      }
      else
      {
        j = this.Rpd;
        i = this.Rpd;
      }
    }
  }
  
  public final void reload()
  {
    AppMethodBeat.i(104706);
    if (this.jHh != null)
    {
      setStatusNotify(0);
      locale = e.jGI;
      e.a(this.jHh, this, this.cacheKey);
      AppMethodBeat.o(104706);
      return;
    }
    e locale = e.jGI;
    e.cD(this);
    AppMethodBeat.o(104706);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104707);
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(104707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */