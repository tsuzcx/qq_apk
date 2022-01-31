import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;

public class ahen
{
  public static Bitmap a(addc paramaddc, int paramInt1, int paramInt2)
  {
    if ((paramaddc == null) || (paramaddc.a() == null) || (paramaddc.a().size() <= 0)) {
      return null;
    }
    float f2;
    float f6;
    float f3;
    float f7;
    label548:
    do
    {
      for (;;)
      {
        float f8;
        try
        {
          int i = paramaddc.a().a().width();
          int j = paramaddc.a().a().height();
          localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          localCanvas = new Canvas(localBitmap);
          localCanvas.drawColor(-1);
          localPaint = new Paint(7);
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setColor(-16777216);
          localPaint.setStrokeWidth(paramInt1 / 16.0F);
          localPaint.setStrokeCap(Paint.Cap.ROUND);
          localPaint.setStrokeJoin(Paint.Join.ROUND);
          f2 = i;
          f6 = 0.0F;
          f3 = j;
          f7 = 0.0F;
          localObject1 = paramaddc.a().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((adem)((Iterator)localObject1).next()).a().iterator();
          f8 = f2;
          f5 = f6;
          f4 = f3;
          f1 = f7;
          f7 = f1;
          f3 = f4;
          f6 = f5;
          f2 = f8;
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (aden)((Iterator)localObject2).next();
          f2 = f8;
          if (((aden)localObject3).a() < f8) {
            f2 = ((aden)localObject3).a();
          }
          f3 = f5;
          if (((aden)localObject3).a() > f5) {
            f3 = ((aden)localObject3).a();
          }
          f5 = f4;
          if (((aden)localObject3).b() < f4) {
            f5 = ((aden)localObject3).b();
          }
          if (((aden)localObject3).b() <= f1) {
            break label548;
          }
          f1 = ((aden)localObject3).b();
        }
        catch (Throwable paramaddc)
        {
          Bitmap localBitmap;
          Canvas localCanvas;
          Paint localPaint;
          Object localObject1;
          Object localObject2;
          float f1;
          Object localObject3;
          adem localadem;
          ArrayList localArrayList;
          paramaddc.printStackTrace();
          return null;
        }
        float f4 = f6 - f2;
        float f5 = f7 - f3;
        f1 = Math.max(f4, f5);
        f2 -= (f1 - f4) / 2.0F;
        f3 -= (f1 - f5) / 2.0F;
        localObject2 = new Path();
        f4 = paramInt1 / f1;
        f1 = paramInt2 / f1;
        localObject3 = paramaddc.a().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localadem = (adem)((Iterator)localObject3).next();
          paramaddc = localadem.a();
          if (paramaddc != null)
          {
            ((Path)localObject2).moveTo((paramaddc.a() - f2) * f4, (paramaddc.b() - f3) * f1);
            localArrayList = localadem.a();
            paramInt1 = 1;
            if (paramInt1 < localadem.c())
            {
              localObject1 = (aden)localArrayList.get(paramInt1);
              ((Path)localObject2).quadTo((paramaddc.a() - f2) * f4, (paramaddc.b() - f3) * f1, (((aden)localObject1).a() - f2) * f4, (((aden)localObject1).b() - f3) * f1);
              paramInt1 += 1;
              paramaddc = (addc)localObject1;
            }
          }
        }
        else
        {
          localCanvas.drawPath((Path)localObject2, localPaint);
          return localBitmap;
          f4 = f5;
          f5 = f3;
          f8 = f2;
        }
      }
    } while ((f2 <= f6) && (f3 <= f7));
    return null;
  }
  
  public static void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahen
 * JD-Core Version:    0.7.0.1
 */