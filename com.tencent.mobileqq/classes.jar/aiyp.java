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

public class aiyp
{
  public static Bitmap a(aevb paramaevb, int paramInt1, int paramInt2)
  {
    if ((paramaevb == null) || (paramaevb.a() == null) || (paramaevb.a().size() <= 0)) {
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
          int i = paramaevb.a().a().width();
          int j = paramaevb.a().a().height();
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
          localObject1 = paramaevb.a().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((aewl)((Iterator)localObject1).next()).a().iterator();
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
          localObject3 = (aewm)((Iterator)localObject2).next();
          f2 = f8;
          if (((aewm)localObject3).a() < f8) {
            f2 = ((aewm)localObject3).a();
          }
          f3 = f5;
          if (((aewm)localObject3).a() > f5) {
            f3 = ((aewm)localObject3).a();
          }
          f5 = f4;
          if (((aewm)localObject3).b() < f4) {
            f5 = ((aewm)localObject3).b();
          }
          if (((aewm)localObject3).b() <= f1) {
            break label548;
          }
          f1 = ((aewm)localObject3).b();
        }
        catch (Throwable paramaevb)
        {
          Bitmap localBitmap;
          Canvas localCanvas;
          Paint localPaint;
          Object localObject1;
          Object localObject2;
          float f1;
          Object localObject3;
          aewl localaewl;
          ArrayList localArrayList;
          paramaevb.printStackTrace();
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
        localObject3 = paramaevb.a().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localaewl = (aewl)((Iterator)localObject3).next();
          paramaevb = localaewl.a();
          if (paramaevb != null)
          {
            ((Path)localObject2).moveTo((paramaevb.a() - f2) * f4, (paramaevb.b() - f3) * f1);
            localArrayList = localaewl.a();
            paramInt1 = 1;
            if (paramInt1 < localaewl.c())
            {
              localObject1 = (aewm)localArrayList.get(paramInt1);
              ((Path)localObject2).quadTo((paramaevb.a() - f2) * f4, (paramaevb.b() - f3) * f1, (((aewm)localObject1).a() - f2) * f4, (((aewm)localObject1).b() - f3) * f1);
              paramInt1 += 1;
              paramaevb = (aevb)localObject1;
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
 * Qualified Name:     aiyp
 * JD-Core Version:    0.7.0.1
 */