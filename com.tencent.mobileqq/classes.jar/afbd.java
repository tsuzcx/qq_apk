import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class afbd
{
  private afaj jdField_a_of_type_Afaj = new afaj();
  private afba jdField_a_of_type_Afba = new afba();
  private afbe jdField_a_of_type_Afbe;
  
  public afbd(afaj paramafaj, int paramInt1, List<afbb> paramList, int paramInt2)
  {
    if (paramafaj == null) {
      return;
    }
    this.jdField_a_of_type_Afaj.a(paramafaj);
    this.jdField_a_of_type_Afba.b(paramInt1);
    this.jdField_a_of_type_Afba.a(paramInt2);
    this.jdField_a_of_type_Afba.a(paramList);
  }
  
  public afbd(afbd paramafbd)
  {
    this.jdField_a_of_type_Afba.a(paramafbd.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Afbe == null) {
      return 0;
    }
    return this.jdField_a_of_type_Afbe.b();
  }
  
  public afba a()
  {
    return this.jdField_a_of_type_Afba;
  }
  
  public afbe a()
  {
    if (this.jdField_a_of_type_Afbe != null)
    {
      this.jdField_a_of_type_Afbe.a();
      this.jdField_a_of_type_Afbe.a(this.jdField_a_of_type_Afba.b());
      this.jdField_a_of_type_Afbe.b(this.jdField_a_of_type_Afba.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Afbe;
      Rect localRect = this.jdField_a_of_type_Afaj.a();
      this.jdField_a_of_type_Afbe = new afbe(this.jdField_a_of_type_Afba, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afbe != null) {
      this.jdField_a_of_type_Afbe.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Afbe != null) {
      this.jdField_a_of_type_Afbe.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Afaj.a(), 0L);
    }
    this.jdField_a_of_type_Afba.a();
    this.jdField_a_of_type_Afba.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Afaj.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Afaj.a();
    afbb localafbb = this.jdField_a_of_type_Afba.b();
    long l;
    if (localafbb != null)
    {
      l = paramLong - localafbb.a();
      if (l <= 0L) {
        f = localafbb.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Afbe != null) {
        this.jdField_a_of_type_Afbe.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Afba.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Afaj.a(l, localafbb.a(), localafbb.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Afbe = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Afbe != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Afbe.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Afbe.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Afbe != null) {
      this.jdField_a_of_type_Afbe.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Afba == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Afbe != null) {
      return this.jdField_a_of_type_Afbe.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Afba == null) {
      return 0;
    }
    return this.jdField_a_of_type_Afba.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbd
 * JD-Core Version:    0.7.0.1
 */