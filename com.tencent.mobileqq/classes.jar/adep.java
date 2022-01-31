import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class adep
{
  private addv jdField_a_of_type_Addv = new addv();
  private adem jdField_a_of_type_Adem = new adem();
  private adeq jdField_a_of_type_Adeq;
  
  public adep(addv paramaddv, int paramInt1, List<aden> paramList, int paramInt2)
  {
    if (paramaddv == null) {
      return;
    }
    this.jdField_a_of_type_Addv.a(paramaddv);
    this.jdField_a_of_type_Adem.b(paramInt1);
    this.jdField_a_of_type_Adem.a(paramInt2);
    this.jdField_a_of_type_Adem.a(paramList);
  }
  
  public adep(adep paramadep)
  {
    this.jdField_a_of_type_Adem.a(paramadep.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Adeq == null) {
      return 0;
    }
    return this.jdField_a_of_type_Adeq.b();
  }
  
  public adem a()
  {
    return this.jdField_a_of_type_Adem;
  }
  
  public adeq a()
  {
    if (this.jdField_a_of_type_Adeq != null)
    {
      this.jdField_a_of_type_Adeq.a();
      this.jdField_a_of_type_Adeq.a(this.jdField_a_of_type_Adem.b());
      this.jdField_a_of_type_Adeq.b(this.jdField_a_of_type_Adem.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Adeq;
      Rect localRect = this.jdField_a_of_type_Addv.a();
      this.jdField_a_of_type_Adeq = new adeq(this.jdField_a_of_type_Adem, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Adeq != null) {
      this.jdField_a_of_type_Adeq.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Adeq != null) {
      this.jdField_a_of_type_Adeq.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Addv.a(), 0L);
    }
    this.jdField_a_of_type_Adem.a();
    this.jdField_a_of_type_Adem.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Addv.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Addv.a();
    aden localaden = this.jdField_a_of_type_Adem.b();
    long l;
    if (localaden != null)
    {
      l = paramLong - localaden.a();
      if (l <= 0L) {
        f = localaden.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adeq != null) {
        this.jdField_a_of_type_Adeq.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Adem.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Addv.a(l, localaden.a(), localaden.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Adeq = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Adeq != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Adeq.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Adeq.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Adeq != null) {
      this.jdField_a_of_type_Adeq.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Adem == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Adeq != null) {
      return this.jdField_a_of_type_Adeq.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Adem == null) {
      return 0;
    }
    return this.jdField_a_of_type_Adem.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adep
 * JD-Core Version:    0.7.0.1
 */