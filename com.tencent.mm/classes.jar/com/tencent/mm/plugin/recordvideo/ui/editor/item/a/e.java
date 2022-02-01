package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/EmojiEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class e
  extends a
{
  private final String TAG;
  private Bitmap gkx;
  private EmojiInfo glt;
  private d yfr;
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(207023);
    this.glt = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(207023);
  }
  
  public final long dLx()
  {
    AppMethodBeat.i(207021);
    d locald = this.yfr;
    if (locald == null) {
      p.bdF("decoder");
    }
    locald.aeG();
    locald = this.yfr;
    if (locald == null) {
      p.bdF("decoder");
    }
    this.gkx = locald.aeH();
    locald = this.yfr;
    if (locald == null) {
      p.bdF("decoder");
    }
    long l = locald.aeJ();
    AppMethodBeat.o(207021);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(207022);
    d locald = this.yfr;
    if (locald == null) {
      p.bdF("decoder");
    }
    locald.destroy();
    AppMethodBeat.o(207022);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(207018);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (dLw())
    {
      paramCanvas.save();
      paramCanvas.concat(this.gR);
      if (this.gkx != null)
      {
        Bitmap localBitmap = this.gkx;
        if (localBitmap == null) {
          p.gkB();
        }
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(207018);
  }
  
  public final void init()
  {
    AppMethodBeat.i(207017);
    ae.d(this.TAG, "filepath is " + this.glt.fSQ());
    this.yfr = MMGIFJNIFactory.Companion.getDecoder(this.glt);
    AppMethodBeat.o(207017);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(207019);
    super.seekTo(paramLong);
    if (dLw())
    {
      d locald = this.yfr;
      if (locald == null) {
        p.bdF("decoder");
      }
      locald.seekTo(paramLong);
      locald = this.yfr;
      if (locald == null) {
        p.bdF("decoder");
      }
      this.gkx = locald.aeH();
    }
    AppMethodBeat.o(207019);
  }
  
  public final long zm(long paramLong)
  {
    AppMethodBeat.i(207020);
    ae.d(this.TAG, "request time is " + paramLong + ", curr frame is " + this.pYA);
    paramLong = super.zm(paramLong);
    AppMethodBeat.o(207020);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e
 * JD-Core Version:    0.7.0.1
 */