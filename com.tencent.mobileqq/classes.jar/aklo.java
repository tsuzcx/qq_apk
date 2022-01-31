import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import java.nio.FloatBuffer;

public class aklo
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(jdField_a_of_type_ArrayOfFloat);
  public static float[] a;
  private static final FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(jdField_b_of_type_ArrayOfFloat);
  public static final float[] b;
  protected int a;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private final String jdField_b_of_type_JavaLangString;
  public int c = 3553;
  protected int d = 101;
  private int e;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public aklo()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public aklo(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = 3553;
    this.d = 101;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      SLog.e("GPUBaseFilter", new RuntimeException("Unable to locate '" + paramString + "' in program"));
    }
  }
  
  public static void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      SLog.e("GPUBaseFilter", new RuntimeException(paramString + ": glError " + i));
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.e = GlUtil.createProgram(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if (this.e == 0) {
      SLog.e("GPUBaseFilter", new RuntimeException("failed creating program " + getClass().getSimpleName()));
    }
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a("onDrawFrame start");
    int m = a();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glUseProgram(m);
    a("glUseProgram");
    int i = GLES20.glGetAttribLocation(m, "aPosition");
    a(i, "aPosition");
    int j = GLES20.glGetAttribLocation(m, "aTextureCoord");
    a(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(m, "uMVPMatrix");
    a(k, "uMVPMatrix");
    m = GLES20.glGetUniformLocation(m, "uTextureMatrix");
    a(m, "uTextureMatrix");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    a("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, jdField_b_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    a("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, paramInt);
    e();
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, 0);
  }
  
  protected void b() {}
  
  public void c()
  {
    SLog.d("GPUBaseFilter", "destroy");
    this.jdField_a_of_type_Boolean = false;
    GLES20.glDeleteProgram(this.e);
    this.e = 0;
    d();
  }
  
  protected void d() {}
  
  protected void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aklo
 * JD-Core Version:    0.7.0.1
 */