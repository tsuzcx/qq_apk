package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "([F[FLjava/util/List;II)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "destroy", "", "seekFrame", "timeMs", "", "start", "Companion", "plugin-recordvideo_release"})
public final class f
  implements c
{
  public static final f.a CgF;
  private final Canvas aTi;
  private final Bitmap bitmap;
  private final Paint paint;
  private final List<a> rpx;
  
  static
  {
    AppMethodBeat.i(237914);
    CgF = new f.a((byte)0);
    AppMethodBeat.o(237914);
  }
  
  public f(float[] paramArrayOfFloat, List<a> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237913);
    this.rpx = paramList;
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    p.g(paramList, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramList;
    this.aTi = new Canvas(this.bitmap);
    this.aTi.translate(0.0F, -paramArrayOfFloat[1]);
    AppMethodBeat.o(237913);
  }
  
  public final Bitmap Im(long paramLong)
  {
    AppMethodBeat.i(237910);
    if (this.rpx.size() == 0)
    {
      AppMethodBeat.o(237910);
      return null;
    }
    this.aTi.drawColor(0, PorterDuff.Mode.MULTIPLY);
    Object localObject = ((Iterable)this.rpx).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      locala.seekTo(paramLong);
      locala.draw(this.aTi, this.paint);
    }
    localObject = this.bitmap;
    AppMethodBeat.o(237910);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(237912);
    try
    {
      Iterator localIterator = ((Iterable)this.rpx).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(237912);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(237912);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(237911);
    try
    {
      Iterator localIterator = ((Iterable)this.rpx).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).init();
      }
      AppMethodBeat.o(237911);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(237911);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.f
 * JD-Core Version:    0.7.0.1
 */