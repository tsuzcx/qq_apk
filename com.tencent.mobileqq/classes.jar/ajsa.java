import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo.ArithmeticImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import mqq.os.MqqHandler;

public class ajsa
  implements TroopHomeworkHelper.UploadCallback
{
  private ArithmeticInfo.ArithmeticImageInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo;
  
  public ajsa(ArithmeticViewHolder paramArithmeticViewHolder, ArithmeticInfo.ArithmeticImageInfo paramArithmeticImageInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo = paramArithmeticImageInfo;
  }
  
  private void a(ArithmeticInfo.ArithmeticImageInfo paramArithmeticImageInfo)
  {
    ThreadManager.getUIHandler().post(new ajsb(this, paramArithmeticImageInfo));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_a_of_type_Int = paramInt;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_a_of_type_Int = 100;
    ArithmeticViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder).c(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ArithmeticViewHolder", 2, "update success , url = " + paramString);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_Int = 2;
    a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo);
    QLog.w("ArithmeticViewHolder", 2, "upload error , code = " + paramInt + " ;local path = " + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsa
 * JD-Core Version:    0.7.0.1
 */