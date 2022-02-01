import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class agcu
  implements agdi
{
  public static final agdj<agcu> a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private float b;
  private float c;
  private float d;
  
  static
  {
    jdField_a_of_type_Agdj = new agcv();
  }
  
  public agcu()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    float f = this.jdField_a_of_type_Int / 750.0F;
    this.jdField_a_of_type_Float = (12.0F * f);
    this.b = (f * 6.0F);
    this.c = (mvk.a(localBaseApplication, 50.0F) / 1000.0F);
    this.d = (mvk.a(localBaseApplication, 0.4F) / 1000.0F);
  }
  
  public agcu(agdg paramagdg)
  {
    paramagdg.a();
    this.jdField_a_of_type_AndroidGraphicsRect = paramagdg.a();
    this.jdField_a_of_type_Float = paramagdg.a();
    this.b = paramagdg.a();
    this.c = paramagdg.a();
    this.d = paramagdg.a();
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
      paramFloat2 *= mvk.b(localBaseApplication, paramFloat1);
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
  
  public void a(agcu paramagcu)
  {
    this.c = paramagcu.c();
    this.d = paramagcu.d();
    this.jdField_a_of_type_Float = paramagcu.a();
    this.b = paramagcu.b();
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramagcu.a());
  }
  
  public void a(agdg paramagdg, int paramInt)
  {
    paramagdg.a(1);
    paramagdg.a(this.jdField_a_of_type_AndroidGraphicsRect);
    paramagdg.a(this.jdField_a_of_type_Float);
    paramagdg.a(this.b);
    paramagdg.a(this.c);
    paramagdg.a(this.d);
  }
  
  public void a(agdl paramagdl)
  {
    if (paramagdl == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = paramagdl.a();
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        if (j == 1)
        {
          ((agdm)localArrayList.get(0)).c(a());
          return;
        }
        if (j > 1)
        {
          ((agdm)localArrayList.get(0)).c(a());
          paramagdl = (agdm)localArrayList.get(0);
          int i = 1;
          while (i < j)
          {
            agdm localagdm = (agdm)localArrayList.get(i);
            localagdm.c(a(localagdm.a() - paramagdl.a(), paramagdl.a(), paramagdl.b(), localagdm.a(), localagdm.b()));
            i += 1;
            paramagdl = localagdm;
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
 * Qualified Name:     agcu
 * JD-Core Version:    0.7.0.1
 */