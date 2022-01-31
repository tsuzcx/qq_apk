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

public class agry
{
  public static Bitmap a(acsj paramacsj, int paramInt1, int paramInt2)
  {
    if ((paramacsj == null) || (paramacsj.a() == null) || (paramacsj.a().size() <= 0)) {
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
          int i = paramacsj.a().a().width();
          int j = paramacsj.a().a().height();
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
          localObject1 = paramacsj.a().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((actt)((Iterator)localObject1).next()).a().iterator();
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
          localObject3 = (actu)((Iterator)localObject2).next();
          f2 = f8;
          if (((actu)localObject3).a() < f8) {
            f2 = ((actu)localObject3).a();
          }
          f3 = f5;
          if (((actu)localObject3).a() > f5) {
            f3 = ((actu)localObject3).a();
          }
          f5 = f4;
          if (((actu)localObject3).b() < f4) {
            f5 = ((actu)localObject3).b();
          }
          if (((actu)localObject3).b() <= f1) {
            break label548;
          }
          f1 = ((actu)localObject3).b();
        }
        catch (Throwable paramacsj)
        {
          Bitmap localBitmap;
          Canvas localCanvas;
          Paint localPaint;
          Object localObject1;
          Object localObject2;
          float f1;
          Object localObject3;
          actt localactt;
          ArrayList localArrayList;
          paramacsj.printStackTrace();
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
        localObject3 = paramacsj.a().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localactt = (actt)((Iterator)localObject3).next();
          paramacsj = localactt.a();
          if (paramacsj != null)
          {
            ((Path)localObject2).moveTo((paramacsj.a() - f2) * f4, (paramacsj.b() - f3) * f1);
            localArrayList = localactt.a();
            paramInt1 = 1;
            if (paramInt1 < localactt.c())
            {
              localObject1 = (actu)localArrayList.get(paramInt1);
              ((Path)localObject2).quadTo((paramacsj.a() - f2) * f4, (paramacsj.b() - f3) * f1, (((actu)localObject1).a() - f2) * f4, (((actu)localObject1).b() - f3) * f1);
              paramInt1 += 1;
              paramacsj = (acsj)localObject1;
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
 * Qualified Name:     agry
 * JD-Core Version:    0.7.0.1
 */