package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/EmojiEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private d NZD;
  private final String TAG;
  private Bitmap mfo;
  private EmojiInfo mgK;
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(280399);
    this.mgK = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(280399);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(280432);
    d locald2 = this.NZD;
    d locald1 = locald2;
    if (locald2 == null)
    {
      s.bIx("decoder");
      locald1 = null;
    }
    locald1.destroy();
    AppMethodBeat.o(280432);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(280415);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    if (gKH())
    {
      paramCanvas.save();
      paramCanvas.concat(getMatrix());
      if (this.mfo != null)
      {
        Bitmap localBitmap = this.mfo;
        s.checkNotNull(localBitmap);
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(280415);
  }
  
  public final long gKI()
  {
    Object localObject2 = null;
    AppMethodBeat.i(280428);
    d locald = this.NZD;
    Object localObject1 = locald;
    if (locald == null)
    {
      s.bIx("decoder");
      localObject1 = null;
    }
    ((d)localObject1).aUe();
    locald = this.NZD;
    localObject1 = locald;
    if (locald == null)
    {
      s.bIx("decoder");
      localObject1 = null;
    }
    this.mfo = ((d)localObject1).getFrame();
    localObject1 = this.NZD;
    if (localObject1 == null)
    {
      s.bIx("decoder");
      localObject1 = localObject2;
    }
    for (;;)
    {
      long l = ((d)localObject1).aUg();
      AppMethodBeat.o(280428);
      return l;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(280408);
    Log.d(this.TAG, s.X("filepath is ", this.mgK.kMn()));
    this.NZD = MMGIFJNIFactory.Companion.getDecoder(this.mgK);
    AppMethodBeat.o(280408);
  }
  
  public final void seekTo(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(280420);
    super.seekTo(paramLong);
    Object localObject1;
    if (gKH())
    {
      d locald = this.NZD;
      localObject1 = locald;
      if (locald == null)
      {
        s.bIx("decoder");
        localObject1 = null;
      }
      ((d)localObject1).seekTo(paramLong);
      localObject1 = this.NZD;
      if (localObject1 != null) {
        break label81;
      }
      s.bIx("decoder");
      localObject1 = localObject2;
    }
    label81:
    for (;;)
    {
      this.mfo = ((d)localObject1).getFrame();
      AppMethodBeat.o(280420);
      return;
    }
  }
  
  public final long tE(long paramLong)
  {
    AppMethodBeat.i(280423);
    Log.d(this.TAG, "request time is " + paramLong + ", curr frame is " + gKF());
    paramLong = super.tE(paramLong);
    AppMethodBeat.o(280423);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e
 * JD-Core Version:    0.7.0.1
 */