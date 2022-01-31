import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agkv
  implements Runnable
{
  public agkv(ScanTorchActivity paramScanTorchActivity, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback, ArVideoResourceInfo paramArVideoResourceInfo) {}
  
  public void run()
  {
    ScanTorchActivity.j(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new agkw(this));
    if (QLog.isColorLevel()) {
      QLog.i("ScanTorchActivity", 2, "onMultiARAnimationInteraction 请点击屏幕进入下一动画片段！");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkv
 * JD-Core Version:    0.7.0.1
 */