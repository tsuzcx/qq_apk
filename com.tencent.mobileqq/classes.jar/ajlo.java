import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;

public final class ajlo
  implements TroopHomeworkHelper.UploadCallback
{
  HWReciteInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo;
  
  public ajlo(HWReciteItem paramHWReciteItem, HWReciteInfo paramHWReciteInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo = paramHWReciteInfo;
  }
  
  public void a(int paramInt)
  {
    HWReciteItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem).post(new ajlp(this));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HWReciteItem", 2, "upload onComplete " + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g = 3;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HWReciteItem", 2, "onError errorCode = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g = 2;
    HWReciteItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem).post(new ajlq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlo
 * JD-Core Version:    0.7.0.1
 */