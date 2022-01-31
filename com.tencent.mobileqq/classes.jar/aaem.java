import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManager;
import com.tencent.mobileqq.ar.arengine.ARCamera;
import com.tencent.mobileqq.arcard.ARCardCameraRecordFragment;
import com.tencent.qphone.base.util.QLog;

public class aaem
  implements Runnable
{
  public aaem(ARCardCameraRecordFragment paramARCardCameraRecordFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if ((ARCardCameraRecordFragment.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment) != 3) || (this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment.a == null))
    {
      QLog.i("ARCardCameraRecordFragment", 2, "cancel to close camera. next mCurCameraState = " + ARCardCameraRecordFragment.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment));
      return;
    }
    if ((ARCardCameraRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment) != null) && (this.jdField_a_of_type_Boolean)) {
      ARCardCameraRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment).c();
    }
    if (ARCardCameraRecordFragment.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment)) {
      this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment.a.a();
    }
    ARCardCameraRecordFragment.b(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment, false);
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment.a.a();
    if (ARCardCameraRecordFragment.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment) != 3)
    {
      QLog.i("ARCardCameraRecordFragment", 2, "cancel to close camera. next mCurCameraState = " + ARCardCameraRecordFragment.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment));
      return;
    }
    ARCardCameraRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment, 0);
    ARCardCameraRecordFragment.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment, false);
    QLog.i("ARCardCameraRecordFragment", 2, "closeCamera successfully. mCurCameraState = " + ARCardCameraRecordFragment.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaem
 * JD-Core Version:    0.7.0.1
 */