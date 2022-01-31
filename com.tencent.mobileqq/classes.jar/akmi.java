import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class akmi
  implements Runnable
{
  akmi(akmh paramakmh) {}
  
  public void run()
  {
    int k = this.a.a.a(this.a.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
    int m = this.a.a.a(this.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
    int n = this.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    Object localObject = this.a.a.getWindow().getAttributes();
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (k - n > 0)
    {
      i = this.a.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getHeight() / 2;
      ((WindowManager.LayoutParams)localObject).y = (-i);
      this.a.a.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      if (QLog.isColorLevel())
      {
        localObject = (Context)this.a.a.jdField_a_of_type_JavaLangRefSoftReference.get();
        j = 0;
        if (localObject != null) {
          j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
        }
        localStringBuilder = new StringBuilder(128);
        if (localObject != null) {
          break label259;
        }
        localStringBuilder.append("|context is null");
      }
    }
    for (;;)
    {
      localStringBuilder.append("|screenHeight=").append(j).append("|emoSpaceY=").append(k).append("|dialogY=").append(m).append("|dialogHeight=").append(n).append("|moveY=").append(i);
      QLog.d("QQCustomDialogWtihEmoticonInput.meassure", 2, localStringBuilder.toString());
      return;
      i = m + n - k;
      break;
      label259:
      localStringBuilder.append("|context is not null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akmi
 * JD-Core Version:    0.7.0.1
 */