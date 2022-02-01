package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "([F[FLjava/util/List;II)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "destroy", "", "seekFrame", "timeMs", "", "start", "Companion", "plugin-recordvideo_release"})
public final class f
  implements c
{
  public static final f.a xPN;
  private final Canvas aTq;
  private final Bitmap bitmap;
  private final List<a> pRU;
  private final Paint paint;
  
  static
  {
    AppMethodBeat.i(200815);
    xPN = new f.a((byte)0);
    AppMethodBeat.o(200815);
  }
  
  public f(float[] paramArrayOfFloat, List<a> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200814);
    this.pRU = paramList;
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    p.g(paramList, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramList;
    this.aTq = new Canvas(this.bitmap);
    this.aTq.translate(0.0F, -paramArrayOfFloat[1]);
    AppMethodBeat.o(200814);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(200813);
    try
    {
      Iterator localIterator = ((Iterable)this.pRU).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(200813);
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(200813);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(200812);
    try
    {
      Iterator localIterator = ((Iterable)this.pRU).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).init();
      }
      AppMethodBeat.o(200812);
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(200812);
      return;
    }
  }
  
  public final Bitmap yQ(long paramLong)
  {
    AppMethodBeat.i(200811);
    if (this.pRU.size() == 0)
    {
      AppMethodBeat.o(200811);
      return null;
    }
    this.aTq.drawColor(0, PorterDuff.Mode.MULTIPLY);
    Object localObject = ((Iterable)this.pRU).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      locala.seekTo(paramLong);
      locala.draw(this.aTq, this.paint);
    }
    localObject = this.bitmap;
    AppMethodBeat.o(200811);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.f
 * JD-Core Version:    0.7.0.1
 */