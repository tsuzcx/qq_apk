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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/EmojiEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class e
  extends a
{
  private final String TAG;
  private Bitmap gUK;
  private d gUS;
  private EmojiInfo gWm;
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(237864);
    this.gWm = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(237864);
  }
  
  public final long Ik(long paramLong)
  {
    AppMethodBeat.i(237861);
    Log.d(this.TAG, "request time is " + paramLong + ", curr frame is " + this.rpy);
    paramLong = super.Ik(paramLong);
    AppMethodBeat.o(237861);
    return paramLong;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(237863);
    d locald = this.gUS;
    if (locald == null) {
      p.btv("decoder");
    }
    locald.destroy();
    AppMethodBeat.o(237863);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(237859);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (eMu())
    {
      paramCanvas.save();
      paramCanvas.concat(this.gT);
      if (this.gUK != null)
      {
        Bitmap localBitmap = this.gUK;
        if (localBitmap == null) {
          p.hyc();
        }
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(237859);
  }
  
  public final long eMv()
  {
    AppMethodBeat.i(237862);
    d locald = this.gUS;
    if (locald == null) {
      p.btv("decoder");
    }
    locald.auo();
    locald = this.gUS;
    if (locald == null) {
      p.btv("decoder");
    }
    this.gUK = locald.getFrame();
    locald = this.gUS;
    if (locald == null) {
      p.btv("decoder");
    }
    long l = locald.auq();
    AppMethodBeat.o(237862);
    return l;
  }
  
  public final void init()
  {
    AppMethodBeat.i(237858);
    Log.d(this.TAG, "filepath is " + this.gWm.hRM());
    this.gUS = MMGIFJNIFactory.Companion.getDecoder(this.gWm);
    AppMethodBeat.o(237858);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(237860);
    super.seekTo(paramLong);
    if (eMu())
    {
      d locald = this.gUS;
      if (locald == null) {
        p.btv("decoder");
      }
      locald.seekTo(paramLong);
      locald = this.gUS;
      if (locald == null) {
        p.btv("decoder");
      }
      this.gUK = locald.getFrame();
    }
    AppMethodBeat.o(237860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e
 * JD-Core Version:    0.7.0.1
 */