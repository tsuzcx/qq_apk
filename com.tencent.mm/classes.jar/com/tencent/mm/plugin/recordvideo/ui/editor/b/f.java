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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "drawingRect", "", "validRect", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "width", "", "height", "([F[FLjava/util/List;II)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "destroy", "", "seekFrame", "timeMs", "", "start", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements c
{
  public static final f.a NZR;
  private final Bitmap bitmap;
  private final Canvas cxr;
  private final Paint paint;
  private final List<a> yhJ;
  
  static
  {
    AppMethodBeat.i(279974);
    NZR = new f.a((byte)0);
    AppMethodBeat.o(279974);
  }
  
  public f(float[] paramArrayOfFloat, List<a> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(279970);
    this.yhJ = paramList;
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    s.s(paramList, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramList;
    this.cxr = new Canvas(this.bitmap);
    this.cxr.translate(-paramArrayOfFloat[0], -paramArrayOfFloat[1]);
    AppMethodBeat.o(279970);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(279996);
    try
    {
      Iterator localIterator = ((Iterable)this.yhJ).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(279996);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(279996);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(279991);
    try
    {
      Iterator localIterator = ((Iterable)this.yhJ).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).init();
      }
      AppMethodBeat.o(279991);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SimpleFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(279991);
      return;
    }
  }
  
  public final Bitmap tG(long paramLong)
  {
    AppMethodBeat.i(279982);
    if (this.yhJ.size() == 0)
    {
      AppMethodBeat.o(279982);
      return null;
    }
    this.cxr.drawColor(0, PorterDuff.Mode.MULTIPLY);
    Object localObject = ((Iterable)this.yhJ).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      locala.seekTo(paramLong);
      locala.draw(this.cxr, this.paint);
    }
    localObject = this.bitmap;
    AppMethodBeat.o(279982);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.f
 * JD-Core Version:    0.7.0.1
 */