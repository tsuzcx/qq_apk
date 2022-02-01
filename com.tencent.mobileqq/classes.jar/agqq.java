import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class agqq
{
  private agpw jdField_a_of_type_Agpw = new agpw();
  private agqn jdField_a_of_type_Agqn = new agqn();
  private agqr jdField_a_of_type_Agqr;
  
  public agqq(agpw paramagpw, int paramInt1, List<agqo> paramList, int paramInt2)
  {
    if (paramagpw == null) {
      return;
    }
    this.jdField_a_of_type_Agpw.a(paramagpw);
    this.jdField_a_of_type_Agqn.b(paramInt1);
    this.jdField_a_of_type_Agqn.a(paramInt2);
    this.jdField_a_of_type_Agqn.a(paramList);
  }
  
  public agqq(agqq paramagqq)
  {
    this.jdField_a_of_type_Agqn.a(paramagqq.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Agqr == null) {
      return 0;
    }
    return this.jdField_a_of_type_Agqr.b();
  }
  
  public agqn a()
  {
    return this.jdField_a_of_type_Agqn;
  }
  
  public agqr a()
  {
    if (this.jdField_a_of_type_Agqr != null)
    {
      this.jdField_a_of_type_Agqr.a();
      this.jdField_a_of_type_Agqr.a(this.jdField_a_of_type_Agqn.b());
      this.jdField_a_of_type_Agqr.b(this.jdField_a_of_type_Agqn.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Agqr;
      Rect localRect = this.jdField_a_of_type_Agpw.a();
      this.jdField_a_of_type_Agqr = new agqr(this.jdField_a_of_type_Agqn, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agqr != null) {
      this.jdField_a_of_type_Agqr.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Agqr != null) {
      this.jdField_a_of_type_Agqr.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Agpw.a(), 0L);
    }
    this.jdField_a_of_type_Agqn.a();
    this.jdField_a_of_type_Agqn.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Agpw.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Agpw.a();
    agqo localagqo = this.jdField_a_of_type_Agqn.b();
    long l;
    if (localagqo != null)
    {
      l = paramLong - localagqo.a();
      if (l <= 0L) {
        f = localagqo.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agqr != null) {
        this.jdField_a_of_type_Agqr.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Agqn.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Agpw.a(l, localagqo.a(), localagqo.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Agqr = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Agqr != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Agqr.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Agqr.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Agqr != null) {
      this.jdField_a_of_type_Agqr.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Agqn == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Agqr != null) {
      return this.jdField_a_of_type_Agqr.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Agqn == null) {
      return 0;
    }
    return this.jdField_a_of_type_Agqn.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqq
 * JD-Core Version:    0.7.0.1
 */