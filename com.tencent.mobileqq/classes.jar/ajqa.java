import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ajqa
{
  private static int jdField_a_of_type_Int = -1;
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public static final float[] a;
  private static final FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  public static final float[] b;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private float c;
  private float d;
  private float e;
  private float f = 1.0F;
  private float g = 1.0F;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    jdField_a_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(jdField_a_of_type_ArrayOfFloat);
    jdField_b_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(jdField_b_of_type_ArrayOfFloat);
  }
  
  public ajqa(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      e();
    }
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static Bitmap a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F)) {
      return null;
    }
    int i = (int)paramFloat1;
    int j = (int)paramFloat2;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i + 1, j + 1, Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      new Canvas(localBitmap).drawPaint(localPaint);
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.e("ItemBase", 2, "createcache exception:" + localException);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ItemBase", 2, "createcache OOM:");
    }
    return null;
  }
  
  public static void a(RenderBuffer paramRenderBuffer, int paramInt, float paramFloat1, float paramFloat2, RectF paramRectF, float paramFloat3, float paramFloat4)
  {
    if ((paramRenderBuffer == null) || (paramInt <= 0)) {}
    int j;
    int k;
    do
    {
      return;
      j = paramRenderBuffer.getWidth();
      k = paramRenderBuffer.getHeight();
    } while ((k <= 0) || (j <= 0));
    b("onDrawFrame start");
    int i = a();
    float f2;
    float f1;
    if (paramRectF != null)
    {
      f2 = paramRectF.width();
      f1 = paramRectF.height();
    }
    for (;;)
    {
      paramRenderBuffer = new float[16];
      Matrix.setIdentityM(paramRenderBuffer, 0);
      if (paramRectF != null)
      {
        Matrix.translateM(paramRenderBuffer, 0, paramRectF.left / paramFloat1, paramRectF.top / paramFloat2, 0.0F);
        Matrix.scaleM(paramRenderBuffer, 0, f2 / paramFloat1, f1 / paramFloat2, 0.0F);
      }
      paramRectF = new float[16];
      Matrix.setIdentityM(paramRectF, 0);
      Matrix.translateM(paramRectF, 0, (2.0F * paramFloat3 + f2) / j - 1.0F, (2.0F * paramFloat4 + f1) / k - 1.0F, 0.0F);
      Matrix.scaleM(paramRectF, 0, f2 / j, f1 / k, 1.0F);
      GLES20.glUseProgram(i);
      b("glUseProgram");
      j = GLES20.glGetAttribLocation(i, "aPosition");
      k = GLES20.glGetAttribLocation(i, "aTextureCoord");
      int m = GLES20.glGetUniformLocation(i, "uMVPMatrix");
      i = GLES20.glGetUniformLocation(i, "uTextureMatrix");
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
      b("glVertexAttribPointer aPosition");
      GLES20.glEnableVertexAttribArray(j);
      b("glEnableVertexAttribArray mPositionHandle");
      GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, jdField_b_of_type_JavaNioFloatBuffer);
      b("glVertexAttribPointer mTextureHandle");
      GLES20.glEnableVertexAttribArray(k);
      b("glEnableVertexAttribArray mTextureHandle");
      GLES20.glUniformMatrix4fv(m, 1, false, paramRectF, 0);
      GLES20.glUniformMatrix4fv(i, 1, false, paramRenderBuffer, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      GLES20.glDrawArrays(5, 0, 4);
      b("glDrawArrays");
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, 0);
      return;
      f1 = paramFloat2;
      f2 = paramFloat1;
    }
  }
  
  public static void b(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      QLog.e("ItemBase", 2, paramString + ": glError " + i);
    }
  }
  
  public static void e()
  {
    try
    {
      if (jdField_a_of_type_Int > 0) {
        break label56;
      }
      jdField_a_of_type_Int = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
      if (jdField_a_of_type_Int == 0) {
        throw new RuntimeException("ItemBase: failed to creating program ");
      }
    }
    finally {}
    if (QLog.isColorLevel()) {
      QLog.d("ItemBase", 2, "initOpenGL, program OK");
    }
    label56:
    int i = 0;
    if (jdField_a_of_type_Int > 0) {
      i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ItemBase", 2, "supportOpenGL, current refcount: " + i);
    }
  }
  
  public static void f()
  {
    try
    {
      int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      if ((i <= 0) && (jdField_a_of_type_Int > 0))
      {
        GLES20.glDeleteProgram(jdField_a_of_type_Int);
        jdField_a_of_type_Int = -1;
        if (QLog.isColorLevel()) {
          QLog.d("ItemBase", 2, "program deleted. ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ItemBase", 2, "unInitOpenGL, current refcount: " + i);
      }
      return;
    }
    finally {}
  }
  
  public float a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException();
    case 6: 
      return this.jdField_a_of_type_Float;
    case 7: 
      return this.jdField_b_of_type_Float;
    case 4: 
      return this.d;
    case 3: 
      return this.c;
    case 5: 
      return this.e;
    case 8: 
      return this.f;
    }
    return this.g;
  }
  
  public long a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException();
    case 2: 
      return this.jdField_b_of_type_Long;
    }
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float -= this.e;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.jdField_a_of_type_Float = paramFloat;
      return;
    case 7: 
      this.jdField_b_of_type_Float = paramFloat;
      return;
    case 4: 
      this.d = paramFloat;
      return;
    case 3: 
      this.c = paramFloat;
      return;
    case 5: 
      this.e = paramFloat;
      return;
    case 8: 
      this.f = paramFloat;
      return;
    }
    this.g = paramFloat;
  }
  
  public void a(RenderBuffer paramRenderBuffer) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    e();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqa
 * JD-Core Version:    0.7.0.1
 */