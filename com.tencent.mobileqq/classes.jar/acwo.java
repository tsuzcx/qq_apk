import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class acwo
  extends ShapeDrawable.ShaderFactory
{
  acwo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfInt) {}
  
  public Shader resize(int paramInt1, int paramInt2)
  {
    return new LinearGradient(paramInt1 * this.jdField_a_of_type_Float, paramInt2 * this.b, paramInt1 * this.c, paramInt2 * this.d, this.jdField_a_of_type_ArrayOfInt, null, Shader.TileMode.CLAMP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwo
 * JD-Core Version:    0.7.0.1
 */