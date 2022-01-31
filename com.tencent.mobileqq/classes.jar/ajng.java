import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class ajng
{
  public static int a;
  public static boolean a;
  private static int c;
  private Matrix a;
  private int jdField_b_of_type_Int = 90;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public ajng()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private static int a()
  {
    if (c == 0)
    {
      c = (int)BaseApplicationImpl.getApplication().getResources().getDimension(2131297910);
      return c;
    }
    return c;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public Rect a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    int i = Float.valueOf(a() * paramFloat3).intValue();
    paramInt1 = a((int)paramFloat1 - i / 2, 0, paramInt1 - i);
    paramInt2 = a((int)paramFloat2 - i / 2, 0, paramInt2 - i);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1) {}
    do
    {
      return;
      jdField_a_of_type_Int = (paramInt + 45) / 90 * 90;
    } while ((jdField_a_of_type_Int >= 0) || (!QLog.isColorLevel()));
    QLog.i("NewFlowCameraOperator", 2, "[onOrientationChanged] origi: " + paramInt + " new:" + jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    anwv.a(this.jdField_b_of_type_AndroidGraphicsMatrix, jdField_a_of_type_Boolean, this.jdField_b_of_type_Int, paramInt3, paramInt4, paramInt1, paramInt2);
    this.jdField_b_of_type_AndroidGraphicsMatrix.invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajng
 * JD-Core Version:    0.7.0.1
 */