package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.b;
import com.tencent.mm.media.g.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/SimpleFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameSeeker;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "width", "", "height", "(Ljava/util/List;II)V", "TAG", "", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "destroy", "", "seekFrame", "timeMs", "", "start", "plugin-recordvideo_release"})
public final class c
  implements e
{
  private final String TAG;
  private final Bitmap bitmap;
  private final Canvas brp;
  private final List<b> gSw;
  private final Paint paint;
  
  public c(List<b> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199261);
    this.gSw = paramList;
    this.TAG = "MicroMsg.SimpleFrameRetriever";
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    k.g(paramList, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramList;
    this.brp = new Canvas(this.bitmap);
    AppMethodBeat.o(199261);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(199260);
    try
    {
      Iterator localIterator = ((Iterable)this.gSw).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).destroy();
      }
      AppMethodBeat.o(199260);
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(199260);
      return;
    }
  }
  
  public final Bitmap pr(long paramLong)
  {
    AppMethodBeat.i(199258);
    if (this.gSw.size() == 0)
    {
      AppMethodBeat.o(199258);
      return null;
    }
    int i = this.brp.save();
    this.brp.drawColor(0, PorterDuff.Mode.MULTIPLY);
    Object localObject = ((Iterable)this.gSw).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.seekTo(paramLong);
      localb.draw(this.brp, this.paint);
    }
    if (i <= 0) {
      ac.w(this.TAG, "canvas restore saveCount: ".concat(String.valueOf(i)));
    }
    for (;;)
    {
      localObject = this.bitmap;
      AppMethodBeat.o(199258);
      return localObject;
      this.brp.restoreToCount(i);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(199259);
    try
    {
      Iterator localIterator = ((Iterable)this.gSw).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).init();
      }
      AppMethodBeat.o(199259);
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(199259);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c
 * JD-Core Version:    0.7.0.1
 */