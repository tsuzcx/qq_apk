package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/StoryFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameRetriever;", "drawingRect", "", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", "rotate", "isForMix", "", "blurBgPath", "", "([FLjava/util/List;IIIIIZLjava/lang/String;)V", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "finalBitmap", "finalCanvas", "finalMatrix", "paint", "Landroid/graphics/Paint;", "blurBgEnable", "calcCenterCropScale", "drawingWidth", "drawingHeight", "calcCenterCropScale2", "calcfinalScale", "drawWidth", "drawHeight", "destroy", "", "requestBlurBgFrame", "Lcom/tencent/mm/media/mix/FrameInfo;", "requestNextFrame", "start", "Companion", "plugin-recordvideo_release"})
public final class d
  implements com.tencent.mm.media.g.d
{
  public static final d.a wmn;
  private final Bitmap bitmap;
  private final Canvas brp;
  private final int duc;
  private final List<com.tencent.mm.media.editor.a.b> gSw;
  Bitmap gVM;
  private final Paint paint;
  private final com.tencent.mm.media.g.b pow;
  private Bitmap wmi;
  private Canvas wmj;
  private final Matrix wmk;
  private final Matrix wml;
  private String wmm;
  
  static
  {
    AppMethodBeat.i(75174);
    wmn = new d.a((byte)0);
    AppMethodBeat.o(75174);
  }
  
  public d(float[] paramArrayOfFloat, List<com.tencent.mm.media.editor.a.b> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(75172);
    this.gSw = paramList;
    this.duc = paramInt5;
    this.wmm = paramString;
    this.paint = new Paint();
    this.wmk = new Matrix();
    this.pow = new com.tencent.mm.media.g.b(this.gSw);
    this.wml = new Matrix();
    ac.i("MicroMsg.StoryFrameRetriever", "create StoryFrameRetriever, drawRect:" + Arrays.toString(paramArrayOfFloat) + ", width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + paramInt3 + ", videoHeight:" + paramInt4 + ", rotate:" + this.duc);
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    float f1;
    label425:
    int i;
    switch (this.duc)
    {
    default: 
      if (paramInt3 > paramInt4)
      {
        paramInt3 = 1;
        paramInt4 = paramInt2;
        paramInt5 = paramInt1;
        if (!dug()) {
          break label732;
        }
        paramList = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        k.g(paramList, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramList;
        f1 = a(paramInt1, paramInt2, paramArrayOfFloat[2], paramArrayOfFloat[3]);
        ac.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
        this.wml.postScale(f1, f1);
        if ((paramBoolean) && (paramInt3 != 0) && ((this.duc == 90) || (this.duc == 270) || (this.duc == 180)))
        {
          this.wmi = Bitmap.createBitmap(paramInt2, paramInt1, Bitmap.Config.ARGB_8888);
          this.wmj = new Canvas(this.wmi);
          f1 = 360.0F - this.duc;
          this.wmk.postRotate(f1);
          if (f1 != 90.0F) {
            break label660;
          }
          paramArrayOfFloat = this.wmk;
          paramList = this.wmj;
          if (paramList == null) {
            k.fOy();
          }
          paramArrayOfFloat.postTranslate(paramList.getWidth(), 0.0F);
        }
        paramArrayOfFloat = f.e(this.wmm, paramInt2, paramInt1, true);
        if (paramArrayOfFloat != null)
        {
          f1 = paramInt1 / paramArrayOfFloat.getWidth();
          float f2 = paramInt2 / paramArrayOfFloat.getHeight();
          if ((f1 == 1.0F) && (f2 == 1.0F)) {
            break label724;
          }
          float f3 = Math.max(f1, f2);
          paramArrayOfFloat = f.b(paramArrayOfFloat, 0.0F, f3, f3);
          paramInt4 = 0;
          paramInt3 = 0;
          k.g(paramArrayOfFloat, "scaledBitmap");
          i = paramArrayOfFloat.getWidth();
          paramInt5 = paramArrayOfFloat.getHeight();
          if (f1 >= f2) {
            break label700;
          }
          paramInt4 = (paramArrayOfFloat.getWidth() - paramInt1) / 2;
          paramInt2 = paramInt4 + paramInt1;
          paramInt1 = paramInt5;
          label547:
          this.gVM = Bitmap.createBitmap(paramArrayOfFloat, paramInt4, paramInt3, paramInt2, paramInt1);
          label562:
          if ((paramBoolean) && (this.duc != 0)) {
            this.gVM = f.a(this.gVM, 360.0F - this.duc);
          }
        }
      }
      break;
    }
    for (;;)
    {
      this.brp = new Canvas(this.bitmap);
      AppMethodBeat.o(75172);
      return;
      if (paramInt4 > paramInt3)
      {
        paramInt3 = 1;
        paramInt4 = paramInt1;
        paramInt5 = paramInt2;
        break;
      }
      paramInt3 = 0;
      paramInt4 = paramInt1;
      paramInt5 = paramInt2;
      break;
      paramInt3 = 0;
      paramInt4 = paramInt2;
      paramInt5 = paramInt1;
      break;
      label660:
      if (f1 != 270.0F) {
        break label425;
      }
      paramArrayOfFloat = this.wmk;
      paramList = this.wmj;
      if (paramList == null) {
        k.fOy();
      }
      paramArrayOfFloat.postTranslate(0.0F, paramList.getHeight());
      break label425;
      label700:
      paramInt3 = (paramArrayOfFloat.getHeight() - paramInt2) / 2;
      paramInt1 = paramInt3 + paramInt2;
      paramInt2 = i;
      break label547;
      label724:
      this.gVM = paramArrayOfFloat;
      break label562;
      label732:
      if (paramBoolean)
      {
        paramList = Bitmap.createBitmap(paramInt5, paramInt4, Bitmap.Config.ARGB_8888);
        k.g(paramList, "Bitmap.createBitmap(real… Bitmap.Config.ARGB_8888)");
        this.bitmap = paramList;
        if ((this.duc == 90) || (this.duc == 270) || (this.duc == 180))
        {
          this.wmi = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          this.wmj = new Canvas(this.wmi);
          f1 = 360.0F - this.duc;
          this.wmk.postRotate(f1);
          if (f1 != 90.0F) {
            break label921;
          }
          paramList = this.wmk;
          paramString = this.wmj;
          if (paramString == null) {
            k.fOy();
          }
          paramList.postTranslate(paramString.getWidth(), 0.0F);
        }
        for (;;)
        {
          f1 = a(paramInt5, paramInt4, paramArrayOfFloat[2], paramArrayOfFloat[3]);
          ac.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
          this.wml.postScale(f1, f1);
          break;
          if (f1 == 270.0F)
          {
            paramList = this.wmk;
            paramString = this.wmj;
            if (paramString == null) {
              k.fOy();
            }
            paramList.postTranslate(0.0F, paramString.getHeight());
          }
        }
      }
      label921:
      paramList = Bitmap.createBitmap(Math.min(paramInt1, paramInt2), Math.max(paramInt1, paramInt2), Bitmap.Config.ARGB_8888);
      k.g(paramList, "Bitmap.createBitmap(Math… Bitmap.Config.ARGB_8888)");
      this.bitmap = paramList;
      f1 = a(Math.min(paramInt1, paramInt2), Math.max(paramInt1, paramInt2), paramArrayOfFloat[2], paramArrayOfFloat[3]);
      ac.i("MicroMsg.StoryFrameRetriever", "scale:".concat(String.valueOf(f1)));
      this.wml.postScale(f1, f1);
    }
  }
  
  private static float a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75167);
    float f = paramInt1 / paramFloat1;
    if (f == paramInt2 / paramFloat2)
    {
      AppMethodBeat.o(75167);
      return f;
    }
    f = paramInt1 / paramFloat1;
    paramFloat2 = paramInt2 / paramFloat2;
    if (paramInt1 > paramInt2) {
      paramFloat1 = f;
    }
    for (;;)
    {
      AppMethodBeat.o(75167);
      return paramFloat1;
      if (f < paramFloat2)
      {
        paramFloat1 = paramFloat2;
      }
      else
      {
        paramFloat1 = f;
        if (f <= paramFloat2) {
          paramFloat1 = 1.0F;
        }
      }
    }
  }
  
  public final c aqZ()
  {
    AppMethodBeat.i(75169);
    if (this.gSw.size() == 0)
    {
      AppMethodBeat.o(75169);
      return null;
    }
    int i = this.brp.save();
    this.brp.drawColor(0, PorterDuff.Mode.MULTIPLY);
    this.brp.concat(this.wml);
    try
    {
      l = this.pow.a(this.brp, this.paint);
      if (i <= 0)
      {
        ac.w("MicroMsg.StoryFrameRetriever", "canvas restore saveCount: ".concat(String.valueOf(i)));
        if ((this.wmj == null) || (this.wmi == null)) {
          break label241;
        }
        Object localObject = this.wmj;
        if (localObject != null) {
          ((Canvas)localObject).drawColor(0, PorterDuff.Mode.MULTIPLY);
        }
        localObject = this.wmj;
        if (localObject != null) {
          ((Canvas)localObject).save();
        }
        localObject = this.wmj;
        if (localObject == null) {
          k.fOy();
        }
        ((Canvas)localObject).drawBitmap(this.bitmap, this.wmk, null);
        localObject = this.wmj;
        if (localObject != null) {
          ((Canvas)localObject).restore();
        }
        localObject = this.wmi;
        if (localObject == null) {
          k.fOy();
        }
        localObject = new c((Bitmap)localObject, l);
        AppMethodBeat.o(75169);
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
        this.brp.restoreToCount(i);
      }
      label241:
      c localc = new c(this.bitmap, l);
      AppMethodBeat.o(75169);
      return localc;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(75171);
    try
    {
      Iterator localIterator = ((Iterable)this.gSw).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.media.editor.a.b)localIterator.next()).destroy();
      }
      AppMethodBeat.o(75171);
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "destroy error", new Object[0]);
      AppMethodBeat.o(75171);
      return;
    }
  }
  
  final boolean dug()
  {
    AppMethodBeat.i(75168);
    if (((CharSequence)this.wmm).length() > 0) {}
    for (int i = 1; (i != 0) && (i.eA(this.wmm)); i = 0)
    {
      AppMethodBeat.o(75168);
      return true;
    }
    AppMethodBeat.o(75168);
    return false;
  }
  
  public final void start()
  {
    AppMethodBeat.i(75170);
    try
    {
      Iterator localIterator = ((Iterable)this.gSw).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.media.editor.a.b)localIterator.next()).init();
      }
      AppMethodBeat.o(75170);
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.StoryFrameRetriever", (Throwable)localException, "start error", new Object[0]);
      AppMethodBeat.o(75170);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.d
 * JD-Core Version:    0.7.0.1
 */