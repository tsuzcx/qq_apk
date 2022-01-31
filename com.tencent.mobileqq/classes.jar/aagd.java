import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.arcard.ARGreetingCardListManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aagd
  implements Runnable
{
  public aagd(AREngine paramAREngine, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    if (((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a())) && ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.c())) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null))
    {
      localObject = AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine);
      if (!this.jdField_a_of_type_Boolean) {
        break label174;
      }
    }
    label174:
    for (int i = 4;; i = 5)
    {
      ((AREngineCallback)localObject).a(1, i);
      if (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null)
      {
        AREngine.b(AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine));
        AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, null);
      }
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      QLog.i("AREngine_AREngine", 1, "onARMarkerAllDownloadComplete. download resource failed.");
      QLog.i("AREngine_AREngine", 1, "processCloudMarkerRecogResult end.");
      AREngine.c(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, false);
      AREngine.c(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine);
      ThreadManager.getUIHandler().post(new aage(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a()) {
      if ((AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null)) {
        AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).a(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 10, 0, null);
      }
    }
    for (;;)
    {
      AREngine.c(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, false);
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.b = null;
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.c()) {
        break;
      }
      if ((AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2))
      {
        ARGreetingCardListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 0);
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.a;
    String str = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.a.c;
    if ((!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()) && (AREngine.h(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)))
    {
      if ((AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine)) && (AREngine.e(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) == 2) && (AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine) != null)) {
        AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine).a(1L, new ARTarget(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo));
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f()) {
        break label595;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f()) {
        ARVideoRecordUIControllerImpl.a().a(1);
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(1L);
      AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, 1L, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, 0, 0.0F, 0.0F, 0.0F);
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
        AREngine.d(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, false);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a((String)localObject, str, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        AREngine.a(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, 0L);
        AREngine.b(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, 0L);
      }
      QLog.i("AREngine_AREngine", 1, "processCloudMarkerRecogResult end. isNeedInternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f() + ", isNeedExternalRender = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g() + ", isNeedWaitUserOperation = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h());
      break;
      label595:
      if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.h()) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g())
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine.a(1L);
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.j()) {
            AREngine.d(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine, true);
          }
        }
      }
      else {
        AREngine.c(this.jdField_a_of_type_ComTencentMobileqqArArengineAREngine);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aagd
 * JD-Core Version:    0.7.0.1
 */