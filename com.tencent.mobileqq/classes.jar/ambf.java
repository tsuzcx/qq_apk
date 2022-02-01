import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;

@TargetApi(9)
public class ambf
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  public static final float[] a;
  public static boolean b;
  public static final float[] b;
  private static final int c;
  public static boolean c;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  public aztz a;
  public ByteBuffer a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  int jdField_b_of_type_Int;
  public ByteBuffer b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[1];
  public ByteBuffer c;
  private int d;
  public boolean d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
    jdField_c_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 4 + jdField_b_of_type_ArrayOfFloat.length * 4;
    jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_c_of_type_Int * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    int i = jdField_a_of_type_JavaNioFloatBuffer.capacity();
    jdField_a_of_type_JavaNioFloatBuffer.limit(i);
    jdField_a_of_type_JavaNioFloatBuffer.position(0);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_b_of_type_ArrayOfFloat);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknow error";
    case 0: 
      return "GL_NO_ERROR";
    case 1280: 
      return "GL_INVALID_ENUM";
    case 1281: 
      return "GL_INVALID_VALUE";
    case 1282: 
      return "GL_INVALID_OPERATION";
    case 1285: 
      return "GL_OUT_OF_MEMORY";
    }
    return "GL_INVALID_FRAMEBUFFER_OPERATION";
  }
  
  private void a()
  {
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    this.jdField_d_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerY");
    this.e = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerU");
    this.f = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerV");
    this.g = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "position");
    this.h = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "textureCoordinateIn");
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aztz.a.put("percent1", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "percent1")));
      this.jdField_a_of_type_Aztz.a.put("percent2", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "percent2")));
      this.jdField_a_of_type_Aztz.a.put("percent3", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "percent3")));
      this.jdField_a_of_type_Aztz.a.put("percent4", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "percent4")));
      this.jdField_a_of_type_Aztz.a.put("percent5", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "percent5")));
      this.jdField_a_of_type_Aztz.a.put("percent6", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "percent6")));
      this.jdField_a_of_type_Aztz.a.put("percent7", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "percent7")));
      this.jdField_a_of_type_Aztz.a.put("quality", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "quality")));
      this.jdField_a_of_type_Aztz.a.put("add_red", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "add_red")));
      this.jdField_a_of_type_Aztz.a.put("red_m", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "red_m")));
      this.jdField_a_of_type_Aztz.a.put("green_m", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "green_m")));
      this.jdField_a_of_type_Aztz.a.put("blue_m", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "blue_m")));
      this.jdField_a_of_type_Aztz.a.put("inputImageTexture2", Integer.valueOf(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "inputImageTexture2")));
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845279);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2;
        QLog.i("GLSurfaceUtil", 2, "decode hongbao filter mask oom!");
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new int[1];
      GLES20.glGenTextures(1, (int[])localObject2, 0);
      GLES20.glBindTexture(3553, localObject2[0]);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLUtils.texImage2D(3553, 0, localObject1, 0);
      this.jdField_b_of_type_Int = localObject2[0];
      GLES20.glBindTexture(3553, 0);
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLSurfaceUtil", 2, paramString);
    }
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glGenBuffers(1, paramArrayOfInt, 0);
    GLES20.glBindBuffer(34962, paramArrayOfInt[0]);
    GLES20.glBufferData(34962, jdField_c_of_type_Int, jdField_a_of_type_JavaNioFloatBuffer, 35044);
    GLES20.glVertexAttribPointer(paramInt1, 2, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 0, jdField_a_of_type_ArrayOfFloat.length * 4);
    GLES20.glEnableVertexAttribArray(paramInt2);
  }
  
  private void b()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[1]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[2]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 * 3 / 2;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ImageFormat.getBitsPerPixel(paramInt1);
    float f1 = paramInt1 * 1.0F / 8.0F;
    a("handleMessage:byteBufferProcessFrame:[getBufferSize]bitpixel=" + paramInt1 + " byteNum=" + f1);
    return (int)(paramInt2 * paramInt3 * f1);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        int i = a(paramInt1, paramInt4, paramInt5);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= i)) {
          break label332;
        }
        bool1 = true;
        boolean bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramArrayOfByte.length == a(paramInt4, paramInt5)) {
            bool2 = false;
          }
        }
        if (bool2)
        {
          a("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=" + bool2 + " mPreviewWidth=" + paramInt4 + " mPreviewWidth" + paramInt4 + " mVideoFormat=" + paramInt1);
          a("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=" + bool2 + " totalSize=" + i + " data.length=" + paramArrayOfByte.length);
          return -1;
        }
        if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (!this.jdField_d_of_type_Boolean)) {
          jdField_c_of_type_Boolean = false;
        }
      }
      catch (UnsatisfiedLinkError paramArrayOfByte)
      {
        paramInt1 = 0;
        continue;
        a("handleMessage:byteBufferProcessFrame:panelY=" + this.jdField_a_of_type_JavaNioByteBuffer);
        return paramInt1;
      }
      try
      {
        CameraGLSurfaceView.initTotalBufferSize(paramInt4, paramInt5, paramInt1);
        jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_JavaNioByteBuffer = null;
        this.jdField_b_of_type_JavaNioByteBuffer = null;
        this.jdField_c_of_type_JavaNioByteBuffer = null;
        a(paramInt2, paramInt3);
        this.jdField_d_of_type_Boolean = true;
        paramInt1 = CameraGLSurfaceView.processVideoFrame(paramArrayOfByte, paramInt4, paramInt5, paramInt1, paramInt6, false, this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_b_of_type_JavaNioByteBuffer, this.jdField_c_of_type_JavaNioByteBuffer, jdField_b_of_type_Boolean);
        if (this.jdField_a_of_type_JavaNioByteBuffer != null)
        {
          this.jdField_a_of_type_JavaNioByteBuffer.position(0);
          this.jdField_b_of_type_JavaNioByteBuffer.position(0);
          this.jdField_c_of_type_JavaNioByteBuffer.position(0);
          return paramInt1;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        jdField_c_of_type_Boolean = false;
        continue;
      }
      label332:
      boolean bool1 = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (this.jdField_a_of_type_JavaNioByteBuffer.capacity() < i)) {
      this.jdField_a_of_type_JavaNioByteBuffer = ambg.a(0, i);
    }
    i = 0 + i;
    paramInt1 = paramInt1 / 2 * (paramInt2 / 2);
    if ((this.jdField_b_of_type_JavaNioByteBuffer == null) || (this.jdField_b_of_type_JavaNioByteBuffer.capacity() < paramInt1)) {
      this.jdField_b_of_type_JavaNioByteBuffer = ambg.a(i, paramInt1);
    }
    if ((this.jdField_c_of_type_JavaNioByteBuffer == null) || (this.jdField_c_of_type_JavaNioByteBuffer.capacity() < paramInt1)) {
      this.jdField_c_of_type_JavaNioByteBuffer = ambg.a(i + paramInt1, paramInt1);
    }
  }
  
  public boolean a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aztz = new aztz();
    }
    for (this.jdField_a_of_type_Int = ambh.a("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;\nvarying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform float percent1;\nuniform float percent2;\nuniform float percent3;\nuniform float percent4;\nuniform float percent5;\nuniform float percent6;\nuniform float percent7;\nuniform sampler2D inputImageTexture2;\nuniform float quality;\nuniform float add_red;\nuniform float red_m;\nuniform float green_m;\nuniform float blue_m;\nfloat percent_value(float min_percent, float percent)\n{\nfloat result_percent = 0.0;\nif(percent > 0.0)\nresult_percent = min(min_percent, percent);\nelse\nresult_percent = max(min_percent - 1.0, percent);\nreturn result_percent;\n}\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfloat r = rgb.r;\nfloat g = rgb.g;\nfloat b = rgb.b;\nfloat max_c = max(r, max(g, b));\nfloat min_c = min(r, min(g, b));\nfloat median = r + g + b - max_c - min_c;\nfloat amount = max_c - median;\nfloat amount2 = median - min_c;\nfloat min_percent_r = 1.0 - r;\nfloat min_percent_g = 1.0 - g;\nfloat min_percent_b = 1.0 - b;\nfloat p;\nfloat gray = dot(rgb, vec3(0.299, 0.587, 0.114));\nfloat tmp_r = r;\nfloat tmp_g = g;\nfloat tmp_b = b;\nif(tmp_r == max_c) //red\n{\nfloat tmp_percent7 = percent7 * (1.0 - gray);\np = percent_value(min_percent_r, percent1 + tmp_percent7);\nr = r + amount * p;\np = percent_value(min_percent_g, percent4 + tmp_percent7);\ng = g + amount * p;\np = percent_value(min_percent_b, percent6 + tmp_percent7);\nb = b + amount * p;\n}\nif(tmp_b == max_c) //blue\n{\np = percent_value(min_percent_r, percent3);\nr = r + amount * p;\n}\nif(tmp_b == min_c) //yellow\n{\np = percent_value(min_percent_b, percent2);\nb = b + amount2 * p;\np = percent_value(min_percent_g, percent5);\ng = g + amount2 * p;\n}\nlowp vec4 color;\ncolor = vec4(r, g, b, 1.0);\ncolor *= quality;\nlowp vec4 newColor;\nnewColor = color;\nif(newColor.r > newColor.g && newColor.r > newColor.b)\n{\nnewColor.r *= 1.0 - red_m * add_red;\nnewColor.g *= 1.0 - green_m * add_red;\nnewColor.b *= 1.0 - blue_m * add_red;\n}\nnewColor.r = texture2D(inputImageTexture2, vec2(newColor.r,0.5)).r;\nnewColor.g = texture2D(inputImageTexture2, vec2(newColor.g,0.5)).g;\nnewColor.b = texture2D(inputImageTexture2, vec2(newColor.b,0.5)).b;\nnewColor.a = 1.0;\ngl_FragColor = newColor;\n}\n"); this.jdField_a_of_type_Int == 0; this.jdField_a_of_type_Int = ambh.a())
    {
      CameraGLSurfaceView.a("GLVideoHelper.createShaderProgram: mGLProgram=" + this.jdField_a_of_type_Int);
      return false;
    }
    a();
    a(this.jdField_b_of_type_ArrayOfInt, this.g, this.h);
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    b();
    return true;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3)
  {
    GLES20.glActiveTexture(33984);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, null);
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6409, 5121, paramByteBuffer1);
    GLES20.glUniform1i(this.jdField_d_of_type_Int, 0);
    GLES20.glActiveTexture(33985);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, null);
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1 / 2, paramInt2 / 2, 6409, 5121, paramByteBuffer2);
    GLES20.glUniform1i(this.e, 1);
    GLES20.glActiveTexture(33986);
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, null);
      bool = true;
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1 / 2, paramInt2 / 2, 6409, 5121, paramByteBuffer3);
    GLES20.glUniform1i(this.f, 2);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aztz.a(aztz.jdField_c_of_type_Int);
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, this.jdField_b_of_type_Int);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "inputImageTexture2"), 3);
    }
    GLES20.glDrawArrays(6, 0, 4);
    paramInt1 = GLES20.glGetError();
    if (paramInt1 != 0) {
      a("glDrawFrame:err=" + paramInt1 + " errname=" + a(paramInt1));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambf
 * JD-Core Version:    0.7.0.1
 */