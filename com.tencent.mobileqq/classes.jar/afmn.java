import android.graphics.Matrix;
import android.graphics.Path;

public class afmn
  implements afme
{
  public static final afmf<afmn> a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private float b;
  
  static
  {
    jdField_a_of_type_Afmf = new afmo();
  }
  
  public afmn(afmc paramafmc)
  {
    paramafmc.a();
    this.jdField_a_of_type_Float = paramafmc.a();
    this.jdField_a_of_type_Long = paramafmc.a();
    this.jdField_a_of_type_Int = paramafmc.a();
    this.b = paramafmc.a();
  }
  
  public afmn(Path paramPath)
  {
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Path a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPath;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(afmc paramafmc, int paramInt)
  {
    paramafmc.a(1);
    paramafmc.a(this.jdField_a_of_type_Float);
    paramafmc.a(this.jdField_a_of_type_Long);
    paramafmc.a(this.jdField_a_of_type_Int);
    paramafmc.a(this.b);
  }
  
  public void a(afmn paramafmn)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramafmn.jdField_a_of_type_AndroidGraphicsPath);
      this.b += paramafmn.b;
    }
  }
  
  public void a(Path paramPath)
  {
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void c(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      return;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, paramFloat);
    Path localPath = new Path();
    localPath.addPath(this.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
    this.jdField_a_of_type_AndroidGraphicsPath = localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmn
 * JD-Core Version:    0.7.0.1
 */