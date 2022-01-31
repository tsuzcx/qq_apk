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

public class ajde
{
  public static Bitmap a(aezq paramaezq, int paramInt1, int paramInt2)
  {
    if ((paramaezq == null) || (paramaezq.a() == null) || (paramaezq.a().size() <= 0)) {
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
          int i = paramaezq.a().a().width();
          int j = paramaezq.a().a().height();
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
          localObject1 = paramaezq.a().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((afba)((Iterator)localObject1).next()).a().iterator();
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
          localObject3 = (afbb)((Iterator)localObject2).next();
          f2 = f8;
          if (((afbb)localObject3).a() < f8) {
            f2 = ((afbb)localObject3).a();
          }
          f3 = f5;
          if (((afbb)localObject3).a() > f5) {
            f3 = ((afbb)localObject3).a();
          }
          f5 = f4;
          if (((afbb)localObject3).b() < f4) {
            f5 = ((afbb)localObject3).b();
          }
          if (((afbb)localObject3).b() <= f1) {
            break label548;
          }
          f1 = ((afbb)localObject3).b();
        }
        catch (Throwable paramaezq)
        {
          Bitmap localBitmap;
          Canvas localCanvas;
          Paint localPaint;
          Object localObject1;
          Object localObject2;
          float f1;
          Object localObject3;
          afba localafba;
          ArrayList localArrayList;
          paramaezq.printStackTrace();
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
        localObject3 = paramaezq.a().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localafba = (afba)((Iterator)localObject3).next();
          paramaezq = localafba.a();
          if (paramaezq != null)
          {
            ((Path)localObject2).moveTo((paramaezq.a() - f2) * f4, (paramaezq.b() - f3) * f1);
            localArrayList = localafba.a();
            paramInt1 = 1;
            if (paramInt1 < localafba.c())
            {
              localObject1 = (afbb)localArrayList.get(paramInt1);
              ((Path)localObject2).quadTo((paramaezq.a() - f2) * f4, (paramaezq.b() - f3) * f1, (((afbb)localObject1).a() - f2) * f4, (((afbb)localObject1).b() - f3) * f1);
              paramInt1 += 1;
              paramaezq = (aezq)localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajde
 * JD-Core Version:    0.7.0.1
 */