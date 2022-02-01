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

public class algo
{
  public static Bitmap a(agpd paramagpd, int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramagpd == null) || (paramagpd.a() == null) || (paramagpd.a().size() <= 0)) {
      return null;
    }
    float f1;
    float f5;
    float f2;
    float f6;
    label544:
    do
    {
      for (;;)
      {
        float f7;
        try
        {
          int i = paramagpd.a().a().width();
          int j = paramagpd.a().a().height();
          localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          localCanvas = new Canvas(localBitmap);
          localCanvas.drawColor(-1);
          localPaint = new Paint(7);
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setColor(-16777216);
          localPaint.setStrokeWidth(paramFloat);
          localPaint.setStrokeCap(Paint.Cap.ROUND);
          localPaint.setStrokeJoin(Paint.Join.ROUND);
          f1 = i;
          f5 = 0.0F;
          f2 = j;
          f6 = 0.0F;
          localObject1 = paramagpd.a().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((agqn)((Iterator)localObject1).next()).a().iterator();
          f7 = f1;
          f4 = f5;
          f3 = f2;
          paramFloat = f6;
          f6 = paramFloat;
          f2 = f3;
          f5 = f4;
          f1 = f7;
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (agqo)((Iterator)localObject2).next();
          f1 = f7;
          if (((agqo)localObject3).a() < f7) {
            f1 = ((agqo)localObject3).a();
          }
          f2 = f4;
          if (((agqo)localObject3).a() > f4) {
            f2 = ((agqo)localObject3).a();
          }
          f4 = f3;
          if (((agqo)localObject3).b() < f3) {
            f4 = ((agqo)localObject3).b();
          }
          if (((agqo)localObject3).b() <= paramFloat) {
            break label544;
          }
          paramFloat = ((agqo)localObject3).b();
        }
        catch (Throwable paramagpd)
        {
          Bitmap localBitmap;
          Canvas localCanvas;
          Paint localPaint;
          Object localObject1;
          Object localObject2;
          Object localObject3;
          agqn localagqn;
          ArrayList localArrayList;
          paramagpd.printStackTrace();
          return null;
        }
        float f3 = f5 - f1;
        float f4 = f6 - f2;
        paramFloat = Math.max(f3, f4);
        f1 -= (paramFloat - f3) / 2.0F;
        f2 -= (paramFloat - f4) / 2.0F;
        localObject2 = new Path();
        f3 = paramInt1 / paramFloat;
        paramFloat = paramInt2 / paramFloat;
        localObject3 = paramagpd.a().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localagqn = (agqn)((Iterator)localObject3).next();
          paramagpd = localagqn.a();
          if (paramagpd != null)
          {
            ((Path)localObject2).moveTo((paramagpd.a() - f1) * f3, (paramagpd.b() - f2) * paramFloat);
            localArrayList = localagqn.a();
            paramInt1 = 1;
            if (paramInt1 < localagqn.c())
            {
              localObject1 = (agqo)localArrayList.get(paramInt1);
              ((Path)localObject2).quadTo((paramagpd.a() - f1) * f3, (paramagpd.b() - f2) * paramFloat, (((agqo)localObject1).a() - f1) * f3, (((agqo)localObject1).b() - f2) * paramFloat);
              paramInt1 += 1;
              paramagpd = (agpd)localObject1;
            }
          }
        }
        else
        {
          localCanvas.drawPath((Path)localObject2, localPaint);
          return localBitmap;
          f3 = f4;
          f4 = f2;
          f7 = f1;
        }
      }
    } while ((f1 <= f5) && (f2 <= f6));
    return null;
  }
  
  public static void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algo
 * JD-Core Version:    0.7.0.1
 */