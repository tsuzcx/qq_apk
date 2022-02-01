package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "retrieverData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverData;)V", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "finalBitmap", "finalCanvas", "finalMatrix", "paint", "Landroid/graphics/Paint;", "retrieverTransform", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "blurBgEnable", "", "calcCenterCropScale", "drawingWidth", "drawingHeight", "videoWidth", "", "videoHeight", "calcCenterCropScale2", "calcfinalScale", "drawWidth", "drawHeight", "destroy", "", "requestBlurBgFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "requestNextFrame", "start", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements b
{
  public static final g.a NZS;
  private final d NZT;
  private Bitmap NZU;
  private Canvas NZV;
  private final Matrix NZW;
  private e NZX;
  private final Bitmap bitmap;
  private final Canvas cxr;
  private final Matrix finalMatrix;
  public Bitmap nEc;
  private final Paint paint;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.b yhM;
  
  static
  {
    AppMethodBeat.i(280003);
    NZS = new g.a((byte)0);
    AppMethodBeat.o(280003);
  }
  
  public g(d paramd)
  {
    AppMethodBeat.i(279985);
    this.NZT = paramd;
    this.paint = new Paint();
    this.finalMatrix = new Matrix();
    this.yhM = new com.tencent.mm.plugin.recordvideo.ui.editor.b(this.NZT.yhJ);
    this.NZW = new Matrix();
    this.NZX = new e();
    Log.i("MicroMsg.StoryFrameRetriever", s.X("create StoryFrameRetriever, ", this.NZT));
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    int m = this.NZT.width;
    int k = this.NZT.height;
    int i;
    Object localObject;
    float[] arrayOfFloat;
    int j;
    label239:
    float f1;
    switch (this.NZT.hYK)
    {
    default: 
      if (this.NZT.videoWidth > this.NZT.videoHeight)
      {
        i = 1;
        paramd = this.NZX;
        localObject = this.NZT.NEA;
        arrayOfFloat = this.NZT.NEB;
        s.u(localObject, "drawingRect");
        paramd.NEA = ((float[])localObject);
        if ((arrayOfFloat != null) && (arrayOfFloat.length == 4)) {
          break label833;
        }
        j = 0;
        if (j != 0)
        {
          s.checkNotNull(arrayOfFloat);
          paramd.NEB = arrayOfFloat;
          f1 = arrayOfFloat[1];
          Log.i("MicroMsg.RetrieverTransform", s.X("topOffset :", Float.valueOf(f1)));
          paramd.NZQ.postTranslate(0.0F, -f1);
        }
        if (!gKT()) {
          break label1050;
        }
        paramd = Bitmap.createBitmap(this.NZT.width, this.NZT.height, Bitmap.Config.ARGB_8888);
        s.s(paramd, "createBitmap(retrieverDa… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        f1 = b(this.NZT.width, this.NZT.height, this.NZT.NEA[2], this.NZT.NEA[3]);
        Log.i("MicroMsg.StoryFrameRetriever", s.X("scale:", Float.valueOf(f1)));
        this.NZW.postScale(f1, f1);
        if ((this.NZT.NZN) && (i != 0) && ((this.NZT.hYK == 90) || (this.NZT.hYK == 270) || (this.NZT.hYK == 180)))
        {
          this.NZU = Bitmap.createBitmap(this.NZT.height, this.NZT.width, Bitmap.Config.ARGB_8888);
          paramd = this.NZU;
          s.checkNotNull(paramd);
          this.NZV = new Canvas(paramd);
          f1 = 360.0F - this.NZT.hYK;
          this.finalMatrix.postRotate(f1);
          if (f1 != 90.0F) {
            break label937;
          }
          i = 1;
          label513:
          if (i == 0) {
            break label943;
          }
          paramd = this.finalMatrix;
          localObject = this.NZV;
          s.checkNotNull(localObject);
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        label546:
        paramd = BitmapUtil.extractThumbNail(this.NZT.NEF, this.NZT.height, this.NZT.width, true);
        if (paramd != null)
        {
          f1 = this.NZT.width / paramd.getWidth();
          float f2 = this.NZT.height / paramd.getHeight();
          if (f1 != 1.0F) {
            break label996;
          }
          i = 1;
          label615:
          if (i != 0)
          {
            if (f2 != 1.0F) {
              break label1002;
            }
            i = n;
            label630:
            if (i != 0) {
              break label1042;
            }
          }
          float f3 = Math.max(f1, f2);
          paramd = BitmapUtil.rotateAndScale(paramd, 0.0F, f3, f3);
          k = paramd.getWidth();
          i = paramd.getHeight();
          if (f1 >= f2) {
            break label1008;
          }
          m = (paramd.getWidth() - this.NZT.width) / 2;
          k = m + this.NZT.width;
          j = 0;
          label701:
          this.nEc = Bitmap.createBitmap(paramd, m, j, k, i);
          label717:
          if ((this.NZT.NZN) && (this.NZT.hYK != 0)) {
            this.nEc = BitmapUtil.rotate(this.nEc, 360.0F - this.NZT.hYK);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.cxr = new Canvas(this.bitmap);
      AppMethodBeat.o(279985);
      return;
      k = this.NZT.width;
      m = this.NZT.height;
      if (this.NZT.videoHeight > this.NZT.videoWidth)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
      break;
      label833:
      if (arrayOfFloat[0] == 0.0F)
      {
        j = 1;
        label845:
        if (j == 0) {
          break label931;
        }
        if (arrayOfFloat[1] != 0.0F) {
          break label913;
        }
        j = 1;
        label862:
        if (j == 0) {
          break label931;
        }
        if (arrayOfFloat[2] != 0.0F) {
          break label919;
        }
        j = 1;
        label879:
        if (j == 0) {
          break label931;
        }
        if (arrayOfFloat[3] != 0.0F) {
          break label925;
        }
      }
      label913:
      label919:
      label925:
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label931;
        }
        j = 0;
        break;
        j = 0;
        break label845;
        j = 0;
        break label862;
        j = 0;
        break label879;
      }
      label931:
      j = 1;
      break label239;
      label937:
      i = 0;
      break label513;
      label943:
      if (f1 == 270.0F) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label994;
        }
        paramd = this.finalMatrix;
        localObject = this.NZV;
        s.checkNotNull(localObject);
        paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
        break;
      }
      label994:
      break label546;
      label996:
      i = 0;
      break label615;
      label1002:
      i = 0;
      break label630;
      label1008:
      j = (paramd.getHeight() - this.NZT.height) / 2;
      i = this.NZT.height + j;
      m = 0;
      break label701;
      label1042:
      this.nEc = paramd;
      break label717;
      label1050:
      if (this.NZT.NZN)
      {
        paramd = Bitmap.createBitmap(m, k, Bitmap.Config.ARGB_8888);
        s.s(paramd, "createBitmap(realWidth, … Bitmap.Config.ARGB_8888)");
        this.bitmap = paramd;
        if ((this.NZT.hYK == 90) || (this.NZT.hYK == 270) || (this.NZT.hYK == 180))
        {
          this.NZU = Bitmap.createBitmap(this.NZT.width, this.NZT.height, Bitmap.Config.ARGB_8888);
          paramd = this.NZU;
          s.checkNotNull(paramd);
          this.NZV = new Canvas(paramd);
          f1 = 360.0F - this.NZT.hYK;
          this.finalMatrix.postRotate(f1);
          if (f1 != 90.0F) {
            break label1283;
          }
          i = 1;
          label1197:
          if (i == 0) {
            break label1289;
          }
          paramd = this.finalMatrix;
          localObject = this.NZV;
          s.checkNotNull(localObject);
          paramd.postTranslate(((Canvas)localObject).getWidth(), 0.0F);
        }
        label1341:
        for (;;)
        {
          f1 = b(m, k, this.NZT.NEA[2], this.NZT.NEA[3]);
          Log.i("MicroMsg.StoryFrameRetriever", s.X("scale:", Float.valueOf(f1)));
          this.NZW.postScale(f1, f1);
          break;
          i = 0;
          break label1197;
          if (f1 == 270.0F) {}
          for (i = i1;; i = 0)
          {
            if (i == 0) {
              break label1341;
            }
            paramd = this.finalMatrix;
            localObject = this.NZV;
            s.checkNotNull(localObject);
            paramd.postTranslate(0.0F, ((Canvas)localObject).getHeight());
            break;
          }
        }
      }
      label1283:
      label1289:
      paramd = Bitmap.createBitmap(Math.min(this.NZT.width, this.NZT.height), Math.max(this.NZT.width, this.NZT.height), Bitmap.Config.ARGB_8888);
      s.s(paramd, "createBitmap(Math.min(re… Bitmap.Config.ARGB_8888)");
      this.bitmap = paramd;
      f1 = b(Math.min(this.NZT.width, this.NZT.height), Math.max(this.NZT.width, this.NZT.height), this.NZT.NEA[2], this.NZT.NEA[3]);
      Log.i("MicroMsg.StoryFrameRetriever", s.X("scale:", Float.valueOf(f1)));
      this.NZW.postScale(f1, f1);
    }
  }
  
  private static float b(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(279995);
    float f = paramInt1 / paramFloat1;
    if (f == paramInt2 / paramFloat2) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(279995);
      return f;
    }
    paramFloat1 = d(paramFloat1, paramFloat2, paramInt1, paramInt2);
    AppMethodBeat.o(279995);
    return paramFloat1;
  }
  
  private static float d(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramInt1 / paramFloat1;
    paramFloat2 = paramInt2 / paramFloat2;
    if (paramInt1 > paramInt2) {}
    do
    {
      return paramFloat1;
      if (paramFloat1 < paramFloat2) {
        return paramFloat2;
      }
    } while (paramFloat1 > paramFloat2);
    return 1.0F;
  }
  
  public final a dEs()
  {
    AppMethodBeat.i(280021);
    if (this.NZT.yhJ.size() == 0)
    {
      AppMethodBeat.o(280021);
      return null;
    }
    int i = this.cxr.save();
    this.cxr.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.cxr.concat(this.NZW);
    Object localObject = this.NZX;
    Canvas localCanvas = this.cxr;
    s.u(localCanvas, "canvas");
    ((e)localObject).NZP = localCanvas.save();
    localCanvas.concat(((e)localObject).NZQ);
    try
    {
      l = this.yhM.a(this.cxr, this.paint);
      localObject = this.NZX;
      localCanvas = this.cxr;
      s.u(localCanvas, "canvas");
      if (((e)localObject).NZP <= 0)
      {
        Log.w("MicroMsg.RetrieverTransform", s.X("canvas restore saveCount: ", Integer.valueOf(((e)localObject).NZP)));
        if (i > 0) {
          break label327;
        }
        Log.w("MicroMsg.StoryFrameRetriever", s.X("canvas restore saveCount: ", Integer.valueOf(i)));
        if ((this.NZV == null) || (this.NZU == null)) {
          break label338;
        }
        localObject = this.NZV;
        if (localObject != null) {
          ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        localObject = this.NZV;
        if (localObject != null) {
          ((Canvas)localObject).save();
        }
        localObject = this.NZV;
        s.checkNotNull(localObject);
        ((Canvas)localObject).drawBitmap(this.bitmap, this.finalMatrix, null);
        localObject = this.NZV;
        if (localObject != null) {
          ((Canvas)localObject).restore();
        }
        localObject = this.NZU;
        s.checkNotNull(localObject);
        localObject = new a((Bitmap)localObject, l);
        AppMethodBeat.o(280021);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        l = 9223372036854775807L;
        continue;
        localCanvas.restoreToCount(localException.NZP);
        continue;
        label327:
        this.cxr.restoreToCount(i);
      }
      label338:
      a locala = new a(this.bitmap, l);
      AppMethodBeat.o(280021);
      return locala;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(280028);
    try
    {
      Iterator localIterator = ((Iterable)this.NZT.yhJ).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).destroy();
      }
      AppMethodBeat.o(280028);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(280028);
      return;
    }
  }
  
  public final boolean gKT()
  {
    AppMethodBeat.i(280006);
    if (((CharSequence)this.NZT.NEF).length() > 0) {}
    for (int i = 1; (i != 0) && (y.ZC(this.NZT.NEF)); i = 0)
    {
      AppMethodBeat.o(280006);
      return true;
    }
    AppMethodBeat.o(280006);
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(280026);
    try
    {
      Iterator localIterator = ((Iterable)this.NZT.yhJ).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)localIterator.next()).init();
      }
      AppMethodBeat.o(280026);
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(280026);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.g
 * JD-Core Version:    0.7.0.1
 */