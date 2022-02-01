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

public class alaa
{
  public static Bitmap a(agcb paramagcb, int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramagcb == null) || (paramagcb.a() == null) || (paramagcb.a().size() <= 0)) {
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
          int i = paramagcb.a().a().width();
          int j = paramagcb.a().a().height();
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
          localObject1 = paramagcb.a().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = ((agdl)((Iterator)localObject1).next()).a().iterator();
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
          localObject3 = (agdm)((Iterator)localObject2).next();
          f1 = f7;
          if (((agdm)localObject3).a() < f7) {
            f1 = ((agdm)localObject3).a();
          }
          f2 = f4;
          if (((agdm)localObject3).a() > f4) {
            f2 = ((agdm)localObject3).a();
          }
          f4 = f3;
          if (((agdm)localObject3).b() < f3) {
            f4 = ((agdm)localObject3).b();
          }
          if (((agdm)localObject3).b() <= paramFloat) {
            break label544;
          }
          paramFloat = ((agdm)localObject3).b();
        }
        catch (Throwable paramagcb)
        {
          Bitmap localBitmap;
          Canvas localCanvas;
          Paint localPaint;
          Object localObject1;
          Object localObject2;
          Object localObject3;
          agdl localagdl;
          ArrayList localArrayList;
          paramagcb.printStackTrace();
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
        localObject3 = paramagcb.a().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localagdl = (agdl)((Iterator)localObject3).next();
          paramagcb = localagdl.a();
          if (paramagcb != null)
          {
            ((Path)localObject2).moveTo((paramagcb.a() - f1) * f3, (paramagcb.b() - f2) * paramFloat);
            localArrayList = localagdl.a();
            paramInt1 = 1;
            if (paramInt1 < localagdl.c())
            {
              localObject1 = (agdm)localArrayList.get(paramInt1);
              ((Path)localObject2).quadTo((paramagcb.a() - f1) * f3, (paramagcb.b() - f2) * paramFloat, (((agdm)localObject1).a() - f1) * f3, (((agdm)localObject1).b() - f2) * paramFloat);
              paramInt1 += 1;
              paramagcb = (agcb)localObject1;
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
 * Qualified Name:     alaa
 * JD-Core Version:    0.7.0.1
 */