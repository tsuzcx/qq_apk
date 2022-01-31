package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class ChattingEmojiView
  extends EmojiStatusView
{
  private String cacheKey;
  private EmojiInfo evH;
  protected int vZY;
  protected int vZZ;
  
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
    AppMethodBeat.i(62470);
    this.vZY = paramContext.getResources().getDimensionPixelSize(2131428398);
    this.vZZ = paramContext.getResources().getDimensionPixelSize(2131428396);
    setDefaultImageResource(0);
    AppMethodBeat.o(62470);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(62471);
    this.evH = paramEmojiInfo;
    this.cacheKey = String.valueOf(paramLong);
    setImageDrawable(null);
    reload();
    AppMethodBeat.o(62471);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62474);
    super.onMeasure(paramInt1, paramInt2);
    int i;
    int j;
    float f;
    if ((getStatus() != 1) && (this.evH != null))
    {
      paramInt2 = (int)(this.evH.field_width * getEmojiDensityScale());
      i = (int)(this.evH.field_height * getEmojiDensityScale());
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = this.vZY;
      }
      paramInt2 = i;
      if (i <= 0) {
        paramInt2 = this.vZY;
      }
      paramInt1 = Math.max(0, paramInt1);
      i = Math.max(0, paramInt2);
      paramInt2 = paramInt1;
      paramInt1 = i;
      i = paramInt2;
      if (paramInt2 <= 0) {
        i = this.vZY;
      }
      j = paramInt1;
      if (paramInt1 <= 0) {
        j = this.vZY;
      }
      if (j >= this.vZZ)
      {
        paramInt1 = j;
        paramInt2 = i;
        if (i >= this.vZZ) {}
      }
      else
      {
        if (i >= j) {
          break label254;
        }
        f = this.vZZ / i;
        paramInt2 = this.vZZ;
        paramInt1 = (int)(j * f);
      }
      label178:
      if (paramInt2 <= this.vZY)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt1 <= this.vZY) {}
      }
      else
      {
        if (paramInt2 <= paramInt1) {
          break label299;
        }
        f = this.vZY / paramInt2;
        j = this.vZY;
        i = (int)(paramInt1 * f);
      }
    }
    for (;;)
    {
      setMeasuredDimension(j, i);
      AppMethodBeat.o(62474);
      return;
      paramInt2 = getIntrinsicWidth();
      paramInt1 = getIntrinsicHeight();
      break;
      label254:
      if (j < i)
      {
        f = this.vZZ / j;
        paramInt1 = this.vZZ;
        paramInt2 = (int)(i * f);
        break label178;
      }
      paramInt1 = this.vZZ;
      paramInt2 = this.vZZ;
      break label178;
      label299:
      if (paramInt1 > paramInt2)
      {
        f = this.vZY / paramInt1;
        i = this.vZY;
        j = (int)(paramInt2 * f);
      }
      else
      {
        j = this.vZY;
        i = this.vZY;
      }
    }
  }
  
  public final void reload()
  {
    AppMethodBeat.i(62472);
    if (this.evH != null)
    {
      setStatusNotify(0);
      locala = a.evk;
      a.a(this.evH, this, this.cacheKey);
      AppMethodBeat.o(62472);
      return;
    }
    a locala = a.evk;
    a.ck(this);
    AppMethodBeat.o(62472);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(62473);
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(62473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */