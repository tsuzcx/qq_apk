import android.graphics.Canvas;
import android.graphics.Rect;
import java.util.List;

public class agdo
{
  private agcu jdField_a_of_type_Agcu = new agcu();
  private agdl jdField_a_of_type_Agdl = new agdl();
  private agdp jdField_a_of_type_Agdp;
  
  public agdo(agcu paramagcu, int paramInt1, List<agdm> paramList, int paramInt2)
  {
    if (paramagcu == null) {
      return;
    }
    this.jdField_a_of_type_Agcu.a(paramagcu);
    this.jdField_a_of_type_Agdl.b(paramInt1);
    this.jdField_a_of_type_Agdl.a(paramInt2);
    this.jdField_a_of_type_Agdl.a(paramList);
  }
  
  public agdo(agdo paramagdo)
  {
    this.jdField_a_of_type_Agdl.a(paramagdo.a());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Agdp == null) {
      return 0;
    }
    return this.jdField_a_of_type_Agdp.b();
  }
  
  public agdl a()
  {
    return this.jdField_a_of_type_Agdl;
  }
  
  public agdp a()
  {
    if (this.jdField_a_of_type_Agdp != null)
    {
      this.jdField_a_of_type_Agdp.a();
      this.jdField_a_of_type_Agdp.a(this.jdField_a_of_type_Agdl.b());
      this.jdField_a_of_type_Agdp.b(this.jdField_a_of_type_Agdl.a());
    }
    for (;;)
    {
      return this.jdField_a_of_type_Agdp;
      Rect localRect = this.jdField_a_of_type_Agcu.a();
      this.jdField_a_of_type_Agdp = new agdp(this.jdField_a_of_type_Agdl, localRect.width(), localRect.height(), -1, -1, 10, 15, 1.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agdp != null) {
      this.jdField_a_of_type_Agdp.b(-1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Agdp != null) {
      this.jdField_a_of_type_Agdp.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Agcu.a(), 0L);
    }
    this.jdField_a_of_type_Agdl.a();
    this.jdField_a_of_type_Agdl.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Agcu.a(), 0L);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    float f = this.jdField_a_of_type_Agcu.a();
    agdm localagdm = this.jdField_a_of_type_Agdl.b();
    long l;
    if (localagdm != null)
    {
      l = paramLong - localagdm.a();
      if (l <= 0L) {
        f = localagdm.c();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Agdp != null) {
        this.jdField_a_of_type_Agdp.b(paramFloat1, paramFloat2, f, paramLong);
      }
      this.jdField_a_of_type_Agdl.a(paramFloat1, paramFloat2, f, paramLong);
      return;
      f = this.jdField_a_of_type_Agcu.a(l, localagdm.a(), localagdm.b(), paramFloat1, paramFloat2);
      continue;
      this.jdField_a_of_type_Agdp = null;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Agdp != null) && (paramCanvas != null))
    {
      if (paramBoolean)
      {
        int i = paramCanvas.getWidth();
        int j = paramCanvas.getHeight();
        this.jdField_a_of_type_Agdp.a(0, 0, i, j);
      }
      this.jdField_a_of_type_Agdp.a(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Agdp != null) {
      this.jdField_a_of_type_Agdp.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Agdl == null) {
      return false;
    }
    a();
    return true;
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Agdp != null) {
      return this.jdField_a_of_type_Agdp.a(paramCanvas, paramInt1, paramInt2);
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Agdl == null) {
      return 0;
    }
    return this.jdField_a_of_type_Agdl.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdo
 * JD-Core Version:    0.7.0.1
 */