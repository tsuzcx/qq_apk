import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ark.ArkAiBubbleView;
import com.tencent.qphone.base.util.QLog;

public class aakx
  implements View.OnClickListener
{
  public aakx(ArkAiBubbleView paramArkAiBubbleView, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiBubbleView.a.removeCallbacks(ArkAiBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiBubbleView));
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiBubbleView.a.clearAnimation();
    ArkAiBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiBubbleView).run();
    if (QLog.isColorLevel()) {
      QLog.i("ark.ai", 2, String.format("ArkRecommendLogic.activate: %h", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiBubbleView }));
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakx
 * JD-Core Version:    0.7.0.1
 */