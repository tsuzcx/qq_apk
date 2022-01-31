import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class actw
{
  private actc jdField_a_of_type_Actc = new actc();
  private actt jdField_a_of_type_Actt = new actt();
  private actx jdField_a_of_type_Actx;
  
  public actw(actc paramactc, int paramInt1, List<actu> paramList, int paramInt2)
  {
    if (paramactc == null) {
      return;
    }
    this.jdField_a_of_type_Actc.a(paramactc);
    this.jdField_a_of_type_Actt.b(paramInt1);
    this.jdField_a_of_type_Actt.a(paramInt2);
    this.jdField_a_of_type_Actt.a(paramList);
  }
  
  public actw(actw paramactw)
  {
    this.jdField_a_of_type_Actt.a(paramactw.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Actx == null) {
      return 0;
    }
    return this.jdField_a_of_type_Actx.b();
  }
  
  public actt a()
  {
    return this.jdField_a_of_type_Actt;
  }
  
  public actx a()
  {
    if (this.jdField_a_of_type_Actx != null)
    {
      this.jdField_a_of_type_Actx.a();
      this.jdField_a_of_type_Actx.a(this.jdField_a_of_type_Actt.b());
      this.jdField_a_of_type_Actx.b(this.jdField_a_of_type_Actt.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Actx;
      Rect localRect = this.jdField_a_of_type_Actc.a();
      this.jdField_a_of_type_Actx = new actx(this.jdField_a_of_type_Actt, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Actx != null) {
      this.jdField_a_of_type_Actx.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Actx != null) {
      this.jdField_a_of_type_Actx.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Actc.a(), 0L);
    }
    this.jdField_a_of_type_Actt.a();
    this.jdField_a_of_type_Actt.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Actc.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Actc.a();
    actu localactu = this.jdField_a_of_type_Actt.b();
    long l;
    if (localactu != null)
    {
      l = paramLong - localactu.a();
      if (l <= 0L) {
        f = localactu.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Actx != null) {
        this.jdField_a_of_type_Actx.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Actt.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Actc.a(l, localactu.a(), localactu.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Actx = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Actx != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Actx.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Actx.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Actx != null) {
      this.jdField_a_of_type_Actx.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Actt == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Actx != null) {
      return this.jdField_a_of_type_Actx.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Actt == null) {
      return 0;
    }
    return this.jdField_a_of_type_Actt.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     actw
 * JD-Core Version:    0.7.0.1
 */