package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class ChattingEmojiView
  extends EmojiStatusView
{
  protected int Kor;
  protected int Kos;
  private String cacheKey;
  private EmojiInfo gWm;
  
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
    this.Kor = paramContext.getResources().getDimensionPixelSize(2131166307);
    this.Kos = paramContext.getResources().getDimensionPixelSize(2131166305);
    setDefaultImageResource(0);
    setGameUseCover(false);
    AppMethodBeat.o(104704);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104705);
    this.gWm = paramEmojiInfo;
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
    if ((getStatus() != 1) && (this.gWm != null))
    {
      paramInt2 = (int)(this.gWm.field_width * getEmojiDensityScale());
      i = (int)(this.gWm.field_height * getEmojiDensityScale());
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = this.Kor;
      }
      paramInt2 = i;
      if (i <= 0) {
        paramInt2 = this.Kor;
      }
      paramInt1 = Math.max(0, paramInt1);
      i = Math.max(0, paramInt2);
      paramInt2 = paramInt1;
      paramInt1 = i;
      i = paramInt2;
      if (paramInt2 <= 0) {
        i = this.Kor;
      }
      j = paramInt1;
      if (paramInt1 <= 0) {
        j = this.Kor;
      }
      if (j >= this.Kos)
      {
        paramInt1 = j;
        paramInt2 = i;
        if (i >= this.Kos) {}
      }
      else
      {
        if (i >= j) {
          break label281;
        }
        f = this.Kos / i;
        paramInt2 = this.Kos;
        paramInt1 = (int)(j * f);
      }
      label178:
      if (paramInt2 <= this.Kor)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt1 <= this.Kor) {}
      }
      else
      {
        if (paramInt2 <= paramInt1) {
          break label326;
        }
        f = this.Kor / paramInt2;
        j = this.Kor;
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
        f = this.Kos / j;
        paramInt1 = this.Kos;
        paramInt2 = (int)(i * f);
        break label178;
      }
      paramInt1 = this.Kos;
      paramInt2 = this.Kos;
      break label178;
      label326:
      if (paramInt1 > paramInt2)
      {
        f = this.Kor / paramInt1;
        i = this.Kor;
        j = (int)(paramInt2 * f);
      }
      else
      {
        j = this.Kor;
        i = this.Kor;
      }
    }
  }
  
  public final void reload()
  {
    AppMethodBeat.i(104706);
    if (this.gWm != null)
    {
      setStatusNotify(0);
      locale = e.gVM;
      e.a(this.gWm, this, this.cacheKey);
      AppMethodBeat.o(104706);
      return;
    }
    e locale = e.gVM;
    e.cl(this);
    AppMethodBeat.o(104706);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(104707);
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(104707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView
 * JD-Core Version:    0.7.0.1
 */