import android.widget.ImageView;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ArithmeticInfo.ArithmeticImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder.ArithmeticImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ajsb
  implements Runnable
{
  ajsb(ajsa paramajsa, ArithmeticInfo.ArithmeticImageInfo paramArithmeticImageInfo) {}
  
  public void run()
  {
    ArithmeticViewHolder.a(this.jdField_a_of_type_Ajsa.a).a();
    ArithmeticViewHolder.ArithmeticImageView localArithmeticImageView = (ArithmeticViewHolder.ArithmeticImageView)ArithmeticViewHolder.a(this.jdField_a_of_type_Ajsa.a).get(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo);
    if (localArithmeticImageView == null) {}
    for (;;)
    {
      return;
      switch (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_Int)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ArithmeticViewHolder", 2, "updateUploadStatus , status = " + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_Int + " ;local path = " + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_JavaLangString);
        return;
        localArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.a, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelArithmeticInfo$ArithmeticImageInfo.jdField_b_of_type_JavaLangString);
        continue;
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
        localArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        continue;
        localArithmeticImageView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
        localArithmeticImageView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsb
 * JD-Core Version:    0.7.0.1
 */