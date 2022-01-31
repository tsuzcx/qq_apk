import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.2;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;

public class aiza
  implements View.OnClickListener
{
  public aiza(CmGameLoadingView.2 param2) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.a.this$0.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.a.this$0.setProgressViewVisibility(true);
    if (this.a.jdField_a_of_type_Aiwi != null) {
      this.a.jdField_a_of_type_Aiwi.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess)) {
      ApolloGameUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiza
 * JD-Core Version:    0.7.0.1
 */