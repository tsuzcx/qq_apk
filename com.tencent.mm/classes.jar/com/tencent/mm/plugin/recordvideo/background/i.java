package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.b;
import com.tencent.mm.media.g.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/SimpleFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameSeeker;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "width", "", "height", "(Ljava/util/List;II)V", "TAG", "", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "destroy", "", "seekFrame", "timeMs", "", "start", "plugin-recordvideo_release"})
public final class i
  implements f
{
  private final String TAG;
  private final Bitmap bitmap;
  private final Canvas btq;
  private final List<b> grO;
  private final Paint paint;
  
  public i(List<b> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204072);
    this.grO = paramList;
    this.TAG = "MicroMsg.SimpleFrameRetriever";
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    k.g(paramList, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramList;
    this.btq = new Canvas(this.bitmap);
    AppMethodBeat.o(204072);
  }
  
  public final Bitmap Bk(long paramLong)
  {
    AppMethodBeat.i(204069);
    if (this.grO.size() == 0)
    {
      AppMethodBeat.o(204069);
      return null;
    }
    int i = this.btq.save();
    this.btq.drawColor(0, PorterDuff.Mode.MULTIPLY);
    Object localObject = ((Iterable)this.grO).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      localb.seekTo(paramLong);
      localb.draw(this.btq, this.paint);
    }
    if (i <= 0) {
      ad.w(this.TAG, "canvas restore saveCount: ".concat(String.valueOf(i)));
    }
    for (;;)
    {
      localObject = this.bitmap;
      AppMethodBeat.o(204069);
      return localObject;
      this.btq.restoreToCount(i);
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(204071);
    try
    {
      Iterator localIterator = ((Iterable)this.grO).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).destroy();
      }
      AppMethodBeat.o(204071);
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(204071);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(204070);
    try
    {
      Iterator localIterator = ((Iterable)this.grO).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).init();
      }
      AppMethodBeat.o(204070);
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(204070);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.i
 * JD-Core Version:    0.7.0.1
 */