import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class aflq
  implements afme
{
  public static final afmf<aflq> a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_Afmf = new aflr();
  }
  
  public aflq()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    float f = this.jdField_a_of_type_Int / 750.0F;
    this.jdField_a_of_type_Float = (12.0F * f);
    this.b = (f * 6.0F);
    this.c = (mum.a(localBaseApplication, 50.0F) / 1000.0F);
    this.d = (mum.a(localBaseApplication, 0.4F) / 1000.0F);
  }
  
  public aflq(afmc paramafmc)
  {
    paramafmc.a();
    this.jdField_a_of_type_AndroidGraphicsRect = paramafmc.a();
    this.jdField_a_of_type_Float = paramafmc.a();
    this.b = paramafmc.a();
    this.c = paramafmc.a();
    this.d = paramafmc.a();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = (float)paramLong / 1000.0F;
    paramFloat1 = (float)Math.sqrt((paramFloat3 - paramFloat1) * (paramFloat3 - paramFloat1) + (paramFloat4 - paramFloat2) * (paramFloat4 - paramFloat2));
    if (paramFloat1 <= 0.0F)
    {
      paramFloat1 = a();
      return paramFloat1;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramFloat2 = f / paramFloat1;
    if (this.jdField_a_of_type_AndroidGraphicsRect.width() > 0) {}
    for (paramFloat1 = this.jdField_a_of_type_AndroidGraphicsRect.width();; paramFloat1 = this.jdField_a_of_type_Int)
    {
      paramFloat2 *= mum.b(localBaseApplication, paramFloat1);
      paramFloat3 = c();
      paramFloat4 = d();
      f = b();
      paramFloat1 = a();
      if (paramFloat2 > paramFloat3) {
        break;
      }
      if (paramFloat2 >= paramFloat4) {
        break label139;
      }
      return f;
    }
    label139:
    return (paramFloat2 - paramFloat4) * (a() - f) / (paramFloat3 - paramFloat4) + f;
  }
  
  public Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
  }
  
  public void a(aflq paramaflq)
  {
    this.c = paramaflq.c();
    this.d = paramaflq.d();
    this.jdField_a_of_type_Float = paramaflq.a();
    this.b = paramaflq.b();
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramaflq.a());
  }
  
  public void a(afmc paramafmc, int paramInt)
  {
    paramafmc.a(1);
    paramafmc.a(this.jdField_a_of_type_AndroidGraphicsRect);
    paramafmc.a(this.jdField_a_of_type_Float);
    paramafmc.a(this.b);
    paramafmc.a(this.c);
    paramafmc.a(this.d);
  }
  
  public void a(afmh paramafmh)
  {
    if (paramafmh == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = paramafmh.a();
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        if (j == 1)
        {
          ((afmi)localArrayList.get(0)).c(a());
          return;
        }
        if (j > 1)
        {
          ((afmi)localArrayList.get(0)).c(a());
          paramafmh = (afmi)localArrayList.get(0);
          int i = 1;
          while (i < j)
          {
            afmi localafmi = (afmi)localArrayList.get(i);
            localafmi.c(a(localafmi.a() - paramafmh.a(), paramafmh.a(), paramafmh.b(), localafmi.a(), localafmi.b()));
            i += 1;
            paramafmh = localafmi;
          }
        }
      }
    }
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void c(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public void d(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflq
 * JD-Core Version:    0.7.0.1
 */