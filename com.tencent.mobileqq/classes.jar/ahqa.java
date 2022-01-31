import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;

public class ahqa
  implements Runnable
{
  public ahqa(CameraCaptureView paramCameraCaptureView, SurfaceTexture paramSurfaceTexture) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	ahqa:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   4: getfield 25	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   7: astore_1
    //   8: aload_1
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 15	ahqa:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   14: invokevirtual 30	android/graphics/SurfaceTexture:updateTexImage	()V
    //   17: aload_1
    //   18: monitorexit
    //   19: aload_0
    //   20: getfield 13	ahqa:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   23: invokevirtual 33	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:requestRender	()V
    //   26: return
    //   27: astore_2
    //   28: aload_1
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    //   32: astore_1
    //   33: ldc 35
    //   35: iconst_2
    //   36: aload_1
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokestatic 41	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: getfield 13	ahqa:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   48: invokestatic 44	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:a	(Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;)Z
    //   51: ifne -25 -> 26
    //   54: aload_1
    //   55: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/utils/ShortVideoExceptionReporter:a	(Ljava/lang/Throwable;)V
    //   58: aload_0
    //   59: getfield 13	ahqa:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   62: iconst_1
    //   63: invokestatic 53	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:b	(Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;Z)Z
    //   66: pop
    //   67: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ahqa
    //   32	23	1	localException	java.lang.Exception
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	27	finally
    //   28	30	27	finally
    //   0	10	32	java/lang/Exception
    //   19	26	32	java/lang/Exception
    //   30	32	32	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahqa
 * JD-Core Version:    0.7.0.1
 */