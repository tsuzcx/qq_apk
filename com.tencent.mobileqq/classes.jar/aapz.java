import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiBubbleView;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.widget.XEditTextEx;
import java.util.List;

public class aapz
  implements View.OnClickListener
{
  public aapz(ArkRecommendController paramArkRecommendController) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    QQAppInterface localQQAppInterface;
    int i;
    ArkAiInfo localArkAiInfo;
    if ((paramView instanceof ArkAiBubbleView))
    {
      paramView = (ArkAiBubbleView)paramView;
      if (!paramView.c)
      {
        this.a.a(paramView.jdField_a_of_type_JavaUtilList, paramView.jdField_a_of_type_JavaUtilList.indexOf(paramView.jdField_a_of_type_ComTencentMobileqqArkArkAiInfo));
        List localList = paramView.a();
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        i = 0;
        if (i >= localList.size()) {
          break label274;
        }
        localArkAiInfo = (ArkAiInfo)localList.get(i);
        ArkAppDataReport.h(null, localArkAiInfo.jdField_a_of_type_JavaLangString, localArkAiInfo.g, localArkAiInfo.jdField_b_of_type_Int);
        if (localArkAiInfo.jdField_a_of_type_Int != 0)
        {
          ArkAppDataReport.j(localQQAppInterface, localArkAiInfo.jdField_a_of_type_JavaLangString, localArkAiInfo.h, localArkAiInfo.jdField_a_of_type_Int);
          if (4 == localArkAiInfo.jdField_a_of_type_Int) {
            ArkAppDataReport.j(localQQAppInterface, localArkAiInfo.jdField_a_of_type_JavaLangString, localArkAiInfo.h, 1);
          }
        }
        if (i == 0)
        {
          if ((ArkRecommendController.a(this.a) == null) || (ArkRecommendController.a(this.a).a == null)) {
            break label275;
          }
          paramView = ArkRecommendController.a(this.a).a.getText();
          if (paramView != null) {
            break label247;
          }
          paramView = null;
        }
      }
    }
    for (;;)
    {
      ((ArkAppHandler)localQQAppInterface.a(95)).a(100, 1, 2, null, null, localArkAiInfo.jdField_a_of_type_JavaLangString, localArkAiInfo.jdField_b_of_type_JavaLangString, paramView, 0, 0);
      i += 1;
      break;
      label247:
      paramView = paramView.toString();
      continue;
      this.a.h();
      ArkAppDataReport.c((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
      label274:
      return;
      label275:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapz
 * JD-Core Version:    0.7.0.1
 */