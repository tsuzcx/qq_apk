import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class adke
  implements View.OnClickListener
{
  public adke(ForwardBaseOption paramForwardBaseOption, String paramString) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
    paramView = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getParcelable("FORWARD_MSG_FOR_PIC");
    Object localObject;
    if ((paramView instanceof MessageForPic))
    {
      paramView = (MessageForPic)paramView;
      int j = 1;
      localObject = new File(paramView.path);
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (((File)localObject).exists())
        {
          i = j;
          if (((File)localObject).length() == paramView.size) {
            i = 0;
          }
        }
      }
      if (i == 0) {
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, paramView.path, this.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      do
      {
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800514B", "0X800514B", 0, 0, "", "", "", "");
        if (NetworkUtil.a(BaseApplication.getContext()) == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: none network");
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidAppActivity, "目前没有网络，请稍后再试!", 1000).b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgressBarVisibility(0);
        localObject = PicBusiManager.a(6, 1536, 1);
        ((PicReq)localObject).a(paramView, paramView.getPicDownloadInfo());
        ((PicReq)localObject).a(new adkf(this, paramView));
        PicBusiManager.a((PicReq)localObject, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        if (!(paramView instanceof AIOImageData)) {
          break;
        }
        paramView = (AIOImageData)paramView;
        if (paramView.a(4))
        {
          localObject = paramView.a(4);
          if (localObject != null)
          {
            ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, ((File)localObject).getAbsolutePath(), this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        if (paramView.a(2))
        {
          paramView = paramView.a(2);
          if (paramView != null)
          {
            ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, paramView.getAbsolutePath(), this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: image does not exist");
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      if (paramView != null)
      {
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, paramView, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: from QZone");
        }
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.jdField_a_of_type_AndroidOsBundle.putBoolean("FORWARD_IS_QZONE_SHARE", true);
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.b, this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "Edit Forward Image: Unknown source");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adke
 * JD-Core Version:    0.7.0.1
 */