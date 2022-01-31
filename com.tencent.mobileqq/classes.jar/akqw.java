import android.app.Activity;
import android.content.Context;
import android.util.Size;
import com.huawei.hiar.ARCamera;
import com.huawei.hiar.ARCameraConfig;
import com.huawei.hiar.ARFrame;
import com.huawei.hiar.ARPose;
import com.huawei.hiar.ARSession;
import com.huawei.hiar.ARTrackable.TrackingState;
import com.huawei.hiar.ARWorldTrackingConfig;
import com.huawei.hiar.exceptions.ARUnSupportedConfigurationException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class akqw
  implements akqs
{
  public static final float[] a;
  private int jdField_a_of_type_Int;
  private akqq jdField_a_of_type_Akqq;
  private ARSession jdField_a_of_type_ComHuaweiHiarARSession;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private int c = 30;
  private int d = -1;
  private int e = 36197;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  }
  
  private void d()
  {
    if (this.d == -1)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfFloat.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
      this.jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfFloat.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_b_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
      this.jdField_b_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
      this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
    }
  }
  
  private void e()
  {
    this.d = -1;
    this.jdField_a_of_type_JavaNioFloatBuffer = null;
    this.jdField_b_of_type_JavaNioFloatBuffer = null;
  }
  
  public Size a()
  {
    QLog.d("HuaweiArCoreBridge", 1, "getARCoreCameraTextureSize");
    if (this.jdField_a_of_type_ComHuaweiHiarARSession != null) {
      return this.jdField_a_of_type_ComHuaweiHiarARSession.getCameraConfig().GetTextureDimensions();
    }
    return null;
  }
  
  public FloatBuffer a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComHuaweiHiarARSession == null) || (this.jdField_a_of_type_Akqq == null))
    {
      paramArrayOfFloat1 = new StringBuilder().append("getARCoreDataByCameraTexture has null ");
      if (this.jdField_a_of_type_ComHuaweiHiarARSession == null)
      {
        bool1 = true;
        paramArrayOfFloat1 = paramArrayOfFloat1.append(bool1).append("|");
        if (this.jdField_a_of_type_Akqq != null) {
          break label92;
        }
      }
      label92:
      for (bool1 = bool2;; bool1 = false)
      {
        QLog.e("HuaweiArCoreBridge", 2, bool1);
        return null;
        bool1 = false;
        break;
      }
    }
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length < 4))
    {
      paramArrayOfFloat2 = new StringBuilder().append("getARCoreDataByCameraTexture rotationQuaternion has error ");
      if (paramArrayOfFloat1 == null) {}
      for (;;)
      {
        QLog.e("HuaweiArCoreBridge", 2, bool1);
        return null;
        bool1 = false;
      }
    }
    if ((paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length < 3))
    {
      paramArrayOfFloat1 = new StringBuilder().append("getARCoreDataByCameraTexture movedata has error ");
      if (paramArrayOfFloat2 == null) {}
      for (bool1 = bool3;; bool1 = false)
      {
        QLog.e("HuaweiArCoreBridge", 2, bool1);
        return null;
      }
    }
    if (this.jdField_a_of_type_JavaNioFloatBuffer == null) {
      d();
    }
    this.d = paramInt;
    this.jdField_a_of_type_ComHuaweiHiarARSession.setCameraTextureName(this.d);
    System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_ComHuaweiHiarARSession.update();
    Object localObject1 = ((ARFrame)localObject2).getCamera();
    System.currentTimeMillis();
    if (((ARFrame)localObject2).hasDisplayGeometryChanged()) {
      ((ARFrame)localObject2).transformDisplayUvCoords(this.jdField_a_of_type_JavaNioFloatBuffer, this.jdField_b_of_type_JavaNioFloatBuffer);
    }
    if (((ARCamera)localObject1).getTrackingState() == ARTrackable.TrackingState.PAUSED)
    {
      QLog.d("HuaweiArCoreBridge", 2, "getARCoreDataByCameraTexture return false camera.getTrackingState() = " + ((ARCamera)localObject1).getTrackingState());
      return null;
    }
    localObject2 = new float[3];
    float[] arrayOfFloat = new float[4];
    localObject1 = ((ARCamera)localObject1).getDisplayOrientedPose();
    ((ARPose)localObject1).getRotationQuaternion(arrayOfFloat, 0);
    float f1 = ((ARPose)localObject1).tx();
    float f2 = ((ARPose)localObject1).ty();
    localObject2[0] = (((ARPose)localObject1).tz() * this.c);
    localObject2[1] = (this.c * f2);
    localObject2[2] = (-f1 * this.c);
    paramArrayOfFloat1[0] = arrayOfFloat[0];
    paramArrayOfFloat1[1] = arrayOfFloat[1];
    paramArrayOfFloat1[2] = arrayOfFloat[2];
    paramArrayOfFloat1[3] = arrayOfFloat[3];
    paramArrayOfFloat2[0] = localObject2[0];
    paramArrayOfFloat2[1] = localObject2[1];
    paramArrayOfFloat2[2] = localObject2[2];
    return this.jdField_b_of_type_JavaNioFloatBuffer;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComHuaweiHiarARSession != null)
    {
      this.jdField_a_of_type_ComHuaweiHiarARSession.stop();
      this.jdField_a_of_type_Akqq.b();
      this.jdField_a_of_type_ComHuaweiHiarARSession = null;
      this.jdField_a_of_type_Akqq = null;
      this.jdField_a_of_type_Boolean = false;
      QLog.d("HuaweiArCoreBridge", 2, "onDestory");
    }
    e();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Akqq == null) {
      this.jdField_a_of_type_Akqq = new akqq(BaseApplicationImpl.getContext());
    }
    this.jdField_a_of_type_Akqq.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComHuaweiHiarARSession != null) && (this.jdField_a_of_type_Boolean);
  }
  
  public boolean a(Context paramContext)
  {
    if ((paramContext == null) || (this.jdField_a_of_type_ComHuaweiHiarARSession != null)) {
      return false;
    }
    if (this.jdField_a_of_type_ComHuaweiHiarARSession == null)
    {
      if (!akqu.b((Activity)paramContext)) {
        break label151;
      }
      try
      {
        this.jdField_a_of_type_ComHuaweiHiarARSession = new ARSession(paramContext);
        paramContext = new ARWorldTrackingConfig(this.jdField_a_of_type_ComHuaweiHiarARSession);
        this.jdField_a_of_type_ComHuaweiHiarARSession.configure(paramContext);
        if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0)) {
          this.jdField_a_of_type_ComHuaweiHiarARSession.setDisplayGeometry(0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
        paramContext = null;
        str = null;
      }
      catch (ARUnSupportedConfigurationException paramContext)
      {
        for (;;)
        {
          str = "The configuration is not supported by the device!";
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          String str = "exception throwed";
        }
      }
      if (str == null) {
        break label151;
      }
      QLog.e("HuaweiArCoreBridge", 2, "onCreate hasException msg = message", paramContext);
      if (this.jdField_a_of_type_ComHuaweiHiarARSession != null)
      {
        this.jdField_a_of_type_ComHuaweiHiarARSession.stop();
        this.jdField_a_of_type_ComHuaweiHiarARSession = null;
        this.jdField_a_of_type_Akqq = null;
      }
      return false;
    }
    return false;
    label151:
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComHuaweiHiarARSession != null)
    {
      this.jdField_a_of_type_ComHuaweiHiarARSession.pause();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Akqq.b();
      QLog.d("HuaweiArCoreBridge", 2, "onPause");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComHuaweiHiarARSession != null)
    {
      this.jdField_a_of_type_ComHuaweiHiarARSession.resume();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Akqq.a();
      QLog.d("HuaweiArCoreBridge", 2, "onPause");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akqw
 * JD-Core Version:    0.7.0.1
 */