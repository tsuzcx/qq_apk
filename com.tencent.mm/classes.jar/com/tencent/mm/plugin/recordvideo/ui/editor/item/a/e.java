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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/EmojiEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class e
  extends a
{
  private d Idh;
  private final String TAG;
  private Bitmap jFB;
  private EmojiInfo jHh;
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(219778);
    this.jHh = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(219778);
  }
  
  public final long PE(long paramLong)
  {
    AppMethodBeat.i(219771);
    Log.d(this.TAG, "request time is " + paramLong + ", curr frame is " + fyS());
    paramLong = super.PE(paramLong);
    AppMethodBeat.o(219771);
    return paramLong;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(219776);
    d locald = this.Idh;
    if (locald == null) {
      p.bGy("decoder");
    }
    locald.destroy();
    AppMethodBeat.o(219776);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(219766);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    if (fyU())
    {
      paramCanvas.save();
      paramCanvas.concat(fyW());
      if (this.jFB != null)
      {
        Bitmap localBitmap = this.jFB;
        if (localBitmap == null) {
          p.iCn();
        }
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(219766);
  }
  
  public final long fyV()
  {
    AppMethodBeat.i(219773);
    d locald = this.Idh;
    if (locald == null) {
      p.bGy("decoder");
    }
    locald.aBh();
    locald = this.Idh;
    if (locald == null) {
      p.bGy("decoder");
    }
    this.jFB = locald.getFrame();
    locald = this.Idh;
    if (locald == null) {
      p.bGy("decoder");
    }
    long l = locald.aBj();
    AppMethodBeat.o(219773);
    return l;
  }
  
  public final void init()
  {
    AppMethodBeat.i(219762);
    Log.d(this.TAG, "filepath is " + this.jHh.ifh());
    this.Idh = MMGIFJNIFactory.Companion.getDecoder(this.jHh);
    AppMethodBeat.o(219762);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(219768);
    super.seekTo(paramLong);
    if (fyU())
    {
      d locald = this.Idh;
      if (locald == null) {
        p.bGy("decoder");
      }
      locald.seekTo(paramLong);
      locald = this.Idh;
      if (locald == null) {
        p.bGy("decoder");
      }
      this.jFB = locald.getFrame();
    }
    AppMethodBeat.o(219768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e
 * JD-Core Version:    0.7.0.1
 */