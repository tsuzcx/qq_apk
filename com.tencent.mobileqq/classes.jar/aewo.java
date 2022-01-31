import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class aewo
{
  private aevu jdField_a_of_type_Aevu = new aevu();
  private aewl jdField_a_of_type_Aewl = new aewl();
  private aewp jdField_a_of_type_Aewp;
  
  public aewo(aevu paramaevu, int paramInt1, List<aewm> paramList, int paramInt2)
  {
    if (paramaevu == null) {
      return;
    }
    this.jdField_a_of_type_Aevu.a(paramaevu);
    this.jdField_a_of_type_Aewl.b(paramInt1);
    this.jdField_a_of_type_Aewl.a(paramInt2);
    this.jdField_a_of_type_Aewl.a(paramList);
  }
  
  public aewo(aewo paramaewo)
  {
    this.jdField_a_of_type_Aewl.a(paramaewo.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aewp == null) {
      return 0;
    }
    return this.jdField_a_of_type_Aewp.b();
  }
  
  public aewl a()
  {
    return this.jdField_a_of_type_Aewl;
  }
  
  public aewp a()
  {
    if (this.jdField_a_of_type_Aewp != null)
    {
      this.jdField_a_of_type_Aewp.a();
      this.jdField_a_of_type_Aewp.a(this.jdField_a_of_type_Aewl.b());
      this.jdField_a_of_type_Aewp.b(this.jdField_a_of_type_Aewl.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Aewp;
      Rect localRect = this.jdField_a_of_type_Aevu.a();
      this.jdField_a_of_type_Aewp = new aewp(this.jdField_a_of_type_Aewl, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aewp != null) {
      this.jdField_a_of_type_Aewp.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Aewp != null) {
      this.jdField_a_of_type_Aewp.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Aevu.a(), 0L);
    }
    this.jdField_a_of_type_Aewl.a();
    this.jdField_a_of_type_Aewl.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Aevu.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Aevu.a();
    aewm localaewm = this.jdField_a_of_type_Aewl.b();
    long l;
    if (localaewm != null)
    {
      l = paramLong - localaewm.a();
      if (l <= 0L) {
        f = localaewm.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aewp != null) {
        this.jdField_a_of_type_Aewp.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Aewl.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Aevu.a(l, localaewm.a(), localaewm.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Aewp = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aewp != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Aewp.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Aewp.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aewp != null) {
      this.jdField_a_of_type_Aewp.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Aewl == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Aewp != null) {
      return this.jdField_a_of_type_Aewp.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Aewl == null) {
      return 0;
    }
    return this.jdField_a_of_type_Aewl.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewo
 * JD-Core Version:    0.7.0.1
 */