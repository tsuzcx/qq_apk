package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class ChattingEmojiView
  extends EmojiStatusView
{
  protected int FeY;
  protected int FeZ;
  private String cacheKey;
  private EmojiInfo gjb;
  
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
    this.FeY = paramContext.getResources().getDimensionPixelSize(2131166264);
    this.FeZ = paramContext.getResources().getDimensionPixelSize(2131166262);
    setDefaultImageResource(0);
    setGameUseCover(false);
    AppMethodBeat.o(104704);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104705);
    this.gjb = paramEmojiInfo;
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
    if ((getStatus() != 1) && (this.gjb != null))
    {
      paramInt2 = (int)(this.gjb.field_width * getEmojiDensityScale());
      i = (int)(this.gjb.field_height * getEmojiDensityScale());
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = this.FeY;
      }
      paramInt2 = i;
      if (i <= 0) {
        paramInt2 = this.FeY;
      }
      paramInt1 = Math.max(0, paramInt1);
      i = Math.max(0, paramInt2);
      paramInt2 = paramInt1;
      paramInt1 = i;
      i = paramInt2;
      if (paramInt2 <= 0) {
        i = this.FeY;
      }
      j = paramInt1;
      if (paramInt1 <= 0) {
        j = this.FeY;
      }
      if (j >= this.FeZ)
      {
        paramInt1 = j;
        paramInt2 = i;
        if (i >= this.FeZ) {}
      }
      else
      {
        if (i >= j) {
          break label281;
        }
        f = this.FeZ / i;
        paramInt2 = this.FeZ;
        paramInt1 = (int)(j * f);
      }
      label178:
      if (paramInt2 <= this.FeY)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt1 <= this.FeY) {}
      }
      else
      {
        if (paramInt2 <= paramInt1) {
          break label326;
        }
        f = this.FeY / paramInt2;
        j = this.FeY;
        i = (int)(paramInt1 * f);
      }
    }
    for (;;)
    {
      setMeasuredDimension(j, i);
      ad.d("MicroMsg.emoji.ChattingEmojiView", "onMeasure width:%d height:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(104708);
      return;
      paramInt2 = getIntrinsicWidth();
      paramInt1 = getIntrinsicHeight();
      break;
      label281:
      if (j < i)
      {
        f = this.FeZ / j;
        paramInt1 = this.FeZ;
        paramInt2 = (int)(i * f);
        break label178;
      }
      paramInt1 = this.FeZ;
      paramInt2 = this.FeZ;
      break label178;
      label326:
      if (paramInt1 > paramInt2)
      {
        f = this.FeY / paramInt1;
        i = this.FeY;
        j = (int)(paramInt2 * f);
      }
      else
      {
        j = this.FeY;
        i = this.FeY;
      }
    }
  }
  
  public final void reload()
  {
    AppMethodBeat.i(104706);
    if (this.gjb != null)
    {
      setStatusNotify(0);
      locale = e.giz;
      e.a(this.gjb, this, this.cacheKey);
      AppMethodBeat.o(104706);
      return;
    }
    e locale = e.giz;
    e.cv(this);
    AppMethodBeat.o(104706);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104707);
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(104707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */