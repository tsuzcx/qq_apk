import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper.OnPlayMediaStatusListener;
import com.tencent.qphone.base.util.QLog;

public class alfr
  implements Runnable
{
  public alfr(ARWorldCupMediaPlayerWrapper paramARWorldCupMediaPlayerWrapper, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper)) {}
    for (;;)
    {
      return;
      try
      {
        ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper);
        ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper);
        if ((ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper) != null) && (ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper) != null))
        {
          ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).b();
          ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).a())
          {
            ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).a();
            GreetingYUVProgram localGreetingYUVProgram = ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper);
            ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper);
            localGreetingYUVProgram.a(GreetingYUVProgram.f);
          }
          ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).a(ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper)[0], ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper)[1], ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).b();
          ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).c();
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
          if ((ARWorldCupMediaPlayerWrapper.b(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper) == 2L) && (ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper) != null))
          {
            ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).a(ARWorldCupMediaPlayerWrapper.b(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper), 0, ARWorldCupMediaPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper).a());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.i("ARWorldCupMediaPlayerWrapper", 1, "drawSoftFrame render error happen");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfr
 * JD-Core Version:    0.7.0.1
 */