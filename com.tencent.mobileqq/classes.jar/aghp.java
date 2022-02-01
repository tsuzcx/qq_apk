import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class aghp
{
  private aggv jdField_a_of_type_Aggv = new aggv();
  private aghm jdField_a_of_type_Aghm = new aghm();
  private aghq jdField_a_of_type_Aghq;
  
  public aghp(aggv paramaggv, int paramInt1, List<aghn> paramList, int paramInt2)
  {
    if (paramaggv == null) {
      return;
    }
    this.jdField_a_of_type_Aggv.a(paramaggv);
    this.jdField_a_of_type_Aghm.b(paramInt1);
    this.jdField_a_of_type_Aghm.a(paramInt2);
    this.jdField_a_of_type_Aghm.a(paramList);
  }
  
  public aghp(aghp paramaghp)
  {
    this.jdField_a_of_type_Aghm.a(paramaghp.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aghq == null) {
      return 0;
    }
    return this.jdField_a_of_type_Aghq.b();
  }
  
  public aghm a()
  {
    return this.jdField_a_of_type_Aghm;
  }
  
  public aghq a()
  {
    if (this.jdField_a_of_type_Aghq != null)
    {
      this.jdField_a_of_type_Aghq.a();
      this.jdField_a_of_type_Aghq.a(this.jdField_a_of_type_Aghm.b());
      this.jdField_a_of_type_Aghq.b(this.jdField_a_of_type_Aghm.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Aghq;
      Rect localRect = this.jdField_a_of_type_Aggv.a();
      this.jdField_a_of_type_Aghq = new aghq(this.jdField_a_of_type_Aghm, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aghq != null) {
      this.jdField_a_of_type_Aghq.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Aghq != null) {
      this.jdField_a_of_type_Aghq.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Aggv.a(), 0L);
    }
    this.jdField_a_of_type_Aghm.a();
    this.jdField_a_of_type_Aghm.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Aggv.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Aggv.a();
    aghn localaghn = this.jdField_a_of_type_Aghm.b();
    long l;
    if (localaghn != null)
    {
      l = paramLong - localaghn.a();
      if (l <= 0L) {
        f = localaghn.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aghq != null) {
        this.jdField_a_of_type_Aghq.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Aghm.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Aggv.a(l, localaghn.a(), localaghn.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Aghq = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aghq != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Aghq.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Aghq.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aghq != null) {
      this.jdField_a_of_type_Aghq.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Aghm == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Aghq != null) {
      return this.jdField_a_of_type_Aghq.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Aghm == null) {
      return 0;
    }
    return this.jdField_a_of_type_Aghm.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghp
 * JD-Core Version:    0.7.0.1
 */