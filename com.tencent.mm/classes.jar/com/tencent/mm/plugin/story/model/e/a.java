package com.tencent.mm.plugin.story.model.e;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.c;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameRetriever;", "drawingRect", "", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", "rotate", "([FLjava/util/List;IIIII)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "getEditorItems", "()Ljava/util/List;", "paint", "Landroid/graphics/Paint;", "calcCenterCropScale", "drawingWidth", "drawingHeight", "destroy", "", "requestNextFrame", "Lcom/tencent/mm/media/mix/FrameInfo;", "start", "plugin-story_release"})
public final class a
  implements d
{
  private final String TAG;
  private final Canvas aVn;
  private final Bitmap bitmap;
  private final List<com.tencent.mm.media.editor.a.b> eVw;
  private final com.tencent.mm.media.f.b luj;
  private final Paint paint;
  private final int rotate;
  private final Matrix syJ;
  private float syK;
  
  public a(float[] paramArrayOfFloat, List<com.tencent.mm.media.editor.a.b> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(109330);
    this.eVw = paramList;
    this.rotate = paramInt5;
    this.TAG = "MicroMsg.StoryFrameRetriever";
    this.paint = new Paint();
    paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    j.p(paramList, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
    this.bitmap = paramList;
    this.aVn = new Canvas(this.bitmap);
    this.luj = new com.tencent.mm.media.f.b(this.eVw);
    this.syJ = new Matrix();
    ab.i(this.TAG, "create StoryFrameRetriever, drawRect:" + Arrays.toString(paramArrayOfFloat) + ", width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + paramInt3 + ", videoHeight:" + paramInt4);
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    this.syJ.postTranslate(-paramArrayOfFloat[2] / 2.0F, -paramArrayOfFloat[3] / 2.0F);
    this.syJ.postRotate(-this.rotate);
    float f1;
    float f3;
    float f4;
    switch (this.rotate)
    {
    default: 
      f1 = Math.max(paramInt1 / paramArrayOfFloat[2], paramInt2 / paramArrayOfFloat[3]);
      ab.i(this.TAG, "scale:".concat(String.valueOf(f1)));
      this.syJ.postScale(f1, f1);
      if ((paramInt3 > 0) && (paramInt4 > 0))
      {
        f3 = paramArrayOfFloat[2];
        f4 = paramArrayOfFloat[3];
        paramInt5 = Math.min(paramInt3, paramInt4);
        paramInt3 = Math.max(paramInt3, paramInt4);
        if (((paramInt5 >= f3) || (paramInt3 >= f4)) && ((paramInt5 <= f3) || (paramInt3 <= f4))) {
          break label681;
        }
        f1 = paramInt5 / paramInt3;
        paramInt4 = (int)f3;
        paramInt3 = (int)(paramInt4 / f1);
      }
      break;
    }
    for (;;)
    {
      float f5 = paramInt4 / paramInt3;
      float f2;
      if (f3 > f4)
      {
        f1 = f3 / f5;
        if (f1 >= f4) {
          break label674;
        }
        f2 = f4 * f5;
        f1 = f4;
      }
      for (;;)
      {
        f5 = paramInt4 / f2;
        float f6 = paramInt3 / f1;
        float f7 = Math.min(f5, f6);
        ab.i(this.TAG, "calcCenterCropScale, drawingSize:[" + f3 + ',' + f4 + "], bitmapSize:[" + paramInt4 + ',' + paramInt3 + "], scaleSize:[" + f2 + ',' + f1 + "], centerCropScale:" + f7 + ", scaleX:" + f5 + ", scaleY:" + f6);
        this.syK = f7;
        this.syJ.postScale(this.syK, this.syK);
        this.syJ.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        AppMethodBeat.o(109330);
        return;
        f1 = Math.max(paramInt2 / paramArrayOfFloat[2], paramInt1 / paramArrayOfFloat[3]);
        break;
        f2 = f4 * f5;
        if (f2 < f3)
        {
          f1 = f3 / f5;
          f2 = f3;
        }
        else
        {
          f1 = f4;
          continue;
          label674:
          f2 = f3;
        }
      }
      label681:
      paramInt4 = paramInt5;
    }
  }
  
  public final c UX()
  {
    AppMethodBeat.i(109327);
    if (this.eVw.size() == 0)
    {
      AppMethodBeat.o(109327);
      return null;
    }
    int i = this.aVn.save();
    this.aVn.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.aVn.concat(this.syJ);
    try
    {
      l = this.luj.a(this.aVn, this.paint);
      if (i <= 0)
      {
        ab.w(this.TAG, "canvas restore saveCount: ".concat(String.valueOf(i)));
        c localc = new c(this.bitmap, l);
        AppMethodBeat.o(109327);
        return localc;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 9223372036854775807L;
        continue;
        this.aVn.restoreToCount(i);
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(109329);
    try
    {
      Iterator localIterator = ((Iterable)this.eVw).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.media.editor.a.b)localIterator.next()).destroy();
      }
      AppMethodBeat.o(109329);
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(109329);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(109328);
    try
    {
      Iterator localIterator = ((Iterable)this.eVw).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.media.editor.a.b)localIterator.next()).init();
      }
      AppMethodBeat.o(109328);
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(109328);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.e.a
 * JD-Core Version:    0.7.0.1
 */