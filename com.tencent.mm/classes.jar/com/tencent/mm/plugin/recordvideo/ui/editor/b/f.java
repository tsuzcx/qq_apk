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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "([F[FLjava/util/List;II)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "destroy", "", "seekFrame", "timeMs", "", "start", "Companion", "plugin-recordvideo_release"})
public final class f
  implements c
{
  public static final a Idv;
  private final Canvas aBC;
  private final Bitmap bitmap;
  private final Paint paint;
  private final List<a> uVd;
  
  static
  {
    AppMethodBeat.i(216457);
    Idv = new a((byte)0);
    AppMethodBeat.o(216457);
  }
  
  public f(float[] paramArrayOfFloat, List<a> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216456);
    this.uVd = paramList;
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    p.j(paramList, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramList;
    this.aBC = new Canvas(this.bitmap);
    this.aBC.translate(-paramArrayOfFloat[0], -paramArrayOfFloat[1]);
    AppMethodBeat.o(216456);
  }
  
  public final Bitmap PG(long paramLong)
  {
    AppMethodBeat.i(216447);
    if (this.uVd.size() == 0)
    {
      AppMethodBeat.o(216447);
      return null;
    }
    this.aBC.drawColor(0, PorterDuff.Mode.MULTIPLY);
    Object localObject = ((Iterable)this.uVd).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      locala.seekTo(paramLong);
      locala.draw(this.aBC, this.paint);
    }
    localObject = this.bitmap;
    AppMethodBeat.o(216447);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(216453);
    try
    {
      Iterator localIterator = ((Iterable)this.uVd).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(216453);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(216453);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(216450);
    try
    {
      Iterator localIterator = ((Iterable)this.uVd).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).init();
      }
      AppMethodBeat.o(216450);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(216450);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.f
 * JD-Core Version:    0.7.0.1
 */