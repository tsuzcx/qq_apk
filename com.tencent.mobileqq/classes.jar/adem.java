import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class adem
{
  private adds jdField_a_of_type_Adds = new adds();
  private adej jdField_a_of_type_Adej = new adej();
  private aden jdField_a_of_type_Aden;
  
  public adem(adds paramadds, int paramInt1, List<adek> paramList, int paramInt2)
  {
    if (paramadds == null) {
      return;
    }
    this.jdField_a_of_type_Adds.a(paramadds);
    this.jdField_a_of_type_Adej.b(paramInt1);
    this.jdField_a_of_type_Adej.a(paramInt2);
    this.jdField_a_of_type_Adej.a(paramList);
  }
  
  public adem(adem paramadem)
  {
    this.jdField_a_of_type_Adej.a(paramadem.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Aden == null) {
      return 0;
    }
    return this.jdField_a_of_type_Aden.b();
  }
  
  public adej a()
  {
    return this.jdField_a_of_type_Adej;
  }
  
  public aden a()
  {
    if (this.jdField_a_of_type_Aden != null)
    {
      this.jdField_a_of_type_Aden.a();
      this.jdField_a_of_type_Aden.a(this.jdField_a_of_type_Adej.b());
      this.jdField_a_of_type_Aden.b(this.jdField_a_of_type_Adej.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Aden;
      Rect localRect = this.jdField_a_of_type_Adds.a();
      this.jdField_a_of_type_Aden = new aden(this.jdField_a_of_type_Adej, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aden != null) {
      this.jdField_a_of_type_Aden.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Aden != null) {
      this.jdField_a_of_type_Aden.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Adds.a(), 0L);
    }
    this.jdField_a_of_type_Adej.a();
    this.jdField_a_of_type_Adej.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Adds.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Adds.a();
    adek localadek = this.jdField_a_of_type_Adej.b();
    long l;
    if (localadek != null)
    {
      l = paramLong - localadek.a();
      if (l <= 0L) {
        f = localadek.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aden != null) {
        this.jdField_a_of_type_Aden.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Adej.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Adds.a(l, localadek.a(), localadek.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Aden = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aden != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Aden.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Aden.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aden != null) {
      this.jdField_a_of_type_Aden.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Adej == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Aden != null) {
      return this.jdField_a_of_type_Aden.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Adej == null) {
      return 0;
    }
    return this.jdField_a_of_type_Adej.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adem
 * JD-Core Version:    0.7.0.1
 */