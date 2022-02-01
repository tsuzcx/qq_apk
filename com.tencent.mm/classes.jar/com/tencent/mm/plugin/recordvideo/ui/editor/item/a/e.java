package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/EmojiEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class e
  extends a
{
  private final String TAG;
  private Bitmap gif;
  private EmojiInfo gjb;
  private d xPy;
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(200765);
    this.gjb = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(200765);
  }
  
  public final long dIg()
  {
    AppMethodBeat.i(200763);
    d locald = this.xPy;
    if (locald == null) {
      p.bcb("decoder");
    }
    locald.aeu();
    locald = this.xPy;
    if (locald == null) {
      p.bcb("decoder");
    }
    this.gif = locald.aev();
    locald = this.xPy;
    if (locald == null) {
      p.bcb("decoder");
    }
    long l = locald.aex();
    AppMethodBeat.o(200763);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(200764);
    d locald = this.xPy;
    if (locald == null) {
      p.bcb("decoder");
    }
    locald.destroy();
    AppMethodBeat.o(200764);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(200760);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (dIf())
    {
      paramCanvas.save();
      paramCanvas.concat(this.gR);
      if (this.gif != null)
      {
        Bitmap localBitmap = this.gif;
        if (localBitmap == null) {
          p.gfZ();
        }
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
      }
      paramCanvas.restore();
    }
    AppMethodBeat.o(200760);
  }
  
  public final void init()
  {
    AppMethodBeat.i(200759);
    ad.d(this.TAG, "filepath is " + this.gjb.gzQ());
    this.xPy = MMGIFJNIFactory.Companion.getDecoder(this.gjb);
    AppMethodBeat.o(200759);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(200761);
    super.seekTo(paramLong);
    if (dIf())
    {
      d locald = this.xPy;
      if (locald == null) {
        p.bcb("decoder");
      }
      locald.seekTo(paramLong);
      locald = this.xPy;
      if (locald == null) {
        p.bcb("decoder");
      }
      this.gif = locald.aev();
    }
    AppMethodBeat.o(200761);
  }
  
  public final long yO(long paramLong)
  {
    AppMethodBeat.i(200762);
    ad.d(this.TAG, "request time is " + paramLong + ", curr frame is " + this.pRV);
    paramLong = super.yO(paramLong);
    AppMethodBeat.o(200762);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e
 * JD-Core Version:    0.7.0.1
 */