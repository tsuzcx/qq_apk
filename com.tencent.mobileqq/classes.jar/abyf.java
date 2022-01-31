import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class abyf
  implements QueryCallback
{
  public abyf(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, Emoticon paramEmoticon, EmoticonInfo paramEmoticonInfo, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelLinearLayout", 2, "package is null, epId: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    do
    {
      return;
      EmoticonCallback localEmoticonCallback = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
      if (localEmoticonCallback != null) {
        localEmoticonCallback.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.d != 2);
    if ((paramEmoticonPackage.jobType == 0) && (paramEmoticonPackage.subType == 4))
    {
      ReportController.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "3", "");
      return;
    }
    ReportController.b(((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "2", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abyf
 * JD-Core Version:    0.7.0.1
 */