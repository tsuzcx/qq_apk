import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class afmk
{
  private aflq jdField_a_of_type_Aflq = new aflq();
  private afmh jdField_a_of_type_Afmh = new afmh();
  private afml jdField_a_of_type_Afml;
  
  public afmk(aflq paramaflq, int paramInt1, List<afmi> paramList, int paramInt2)
  {
    if (paramaflq == null) {
      return;
    }
    this.jdField_a_of_type_Aflq.a(paramaflq);
    this.jdField_a_of_type_Afmh.b(paramInt1);
    this.jdField_a_of_type_Afmh.a(paramInt2);
    this.jdField_a_of_type_Afmh.a(paramList);
  }
  
  public afmk(afmk paramafmk)
  {
    this.jdField_a_of_type_Afmh.a(paramafmk.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Afml == null) {
      return 0;
    }
    return this.jdField_a_of_type_Afml.b();
  }
  
  public afmh a()
  {
    return this.jdField_a_of_type_Afmh;
  }
  
  public afml a()
  {
    if (this.jdField_a_of_type_Afml != null)
    {
      this.jdField_a_of_type_Afml.a();
      this.jdField_a_of_type_Afml.a(this.jdField_a_of_type_Afmh.b());
      this.jdField_a_of_type_Afml.b(this.jdField_a_of_type_Afmh.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Afml;
      Rect localRect = this.jdField_a_of_type_Aflq.a();
      this.jdField_a_of_type_Afml = new afml(this.jdField_a_of_type_Afmh, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afml != null) {
      this.jdField_a_of_type_Afml.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Afml != null) {
      this.jdField_a_of_type_Afml.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Aflq.a(), 0L);
    }
    this.jdField_a_of_type_Afmh.a();
    this.jdField_a_of_type_Afmh.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Aflq.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Aflq.a();
    afmi localafmi = this.jdField_a_of_type_Afmh.b();
    long l;
    if (localafmi != null)
    {
      l = paramLong - localafmi.a();
      if (l <= 0L) {
        f = localafmi.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Afml != null) {
        this.jdField_a_of_type_Afml.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Afmh.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Aflq.a(l, localafmi.a(), localafmi.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Afml = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Afml != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Afml.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Afml.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Afml != null) {
      this.jdField_a_of_type_Afml.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Afmh == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Afml != null) {
      return this.jdField_a_of_type_Afml.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Afmh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Afmh.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmk
 * JD-Core Version:    0.7.0.1
 */