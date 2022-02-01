package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class ChattingEmojiView
  extends EmojiStatusView
{
  protected int Ylu;
  protected int Ylv;
  private EmojiInfo mgK;
  private String mgR;
  
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
    this.Ylu = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_size);
    this.Ylv = paramContext.getResources().getDimensionPixelSize(a.e.emoji_view_image_min_size);
    setDefaultImageResource(0);
    setGameUseCover(false);
    AppMethodBeat.o(104704);
  }
  
  public final void a(EmojiInfo paramEmojiInfo, long paramLong)
  {
    AppMethodBeat.i(104705);
    this.mgK = paramEmojiInfo;
    this.mgR = String.valueOf(paramLong);
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
    if ((getStatus() != 1) && (this.mgK != null))
    {
      paramInt2 = (int)(this.mgK.field_width * getEmojiDensityScale());
      i = (int)(this.mgK.field_height * getEmojiDensityScale());
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = this.Ylu;
      }
      paramInt2 = i;
      if (i <= 0) {
        paramInt2 = this.Ylu;
      }
      paramInt1 = Math.max(0, paramInt1);
      i = Math.max(0, paramInt2);
      paramInt2 = paramInt1;
      paramInt1 = i;
      i = paramInt2;
      if (paramInt2 <= 0) {
        i = this.Ylu;
      }
      j = paramInt1;
      if (paramInt1 <= 0) {
        j = this.Ylu;
      }
      if (j >= this.Ylv)
      {
        paramInt1 = j;
        paramInt2 = i;
        if (i >= this.Ylv) {}
      }
      else
      {
        if (i >= j) {
          break label281;
        }
        f = this.Ylv / i;
        paramInt2 = this.Ylv;
        paramInt1 = (int)(j * f);
      }
      label178:
      if (paramInt2 <= this.Ylu)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt1 <= this.Ylu) {}
      }
      else
      {
        if (paramInt2 <= paramInt1) {
          break label326;
        }
        f = this.Ylu / paramInt2;
        j = this.Ylu;
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
        f = this.Ylv / j;
        paramInt1 = this.Ylv;
        paramInt2 = (int)(i * f);
        break label178;
      }
      paramInt1 = this.Ylv;
      paramInt2 = this.Ylv;
      break label178;
      label326:
      if (paramInt1 > paramInt2)
      {
        f = this.Ylu / paramInt1;
        i = this.Ylu;
        j = (int)(paramInt2 * f);
      }
      else
      {
        j = this.Ylu;
        i = this.Ylu;
      }
    }
  }
  
  public final void reload()
  {
    AppMethodBeat.i(104706);
    if (this.mgK != null)
    {
      setStatusNotify(0);
      locale = e.mgl;
      e.a(this.mgK, this, this.mgR);
      AppMethodBeat.o(104706);
      return;
    }
    e locale = e.mgl;
    e.cX(this);
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