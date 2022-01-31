import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendController.AttachAppHolder;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.statistics.ArkAppReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.List;

public class aaqq
  implements DialogInterface.OnClickListener
{
  public aaqq(ArkRecommendController paramArkRecommendController, QQCustomDialog paramQQCustomDialog, boolean paramBoolean1, ArkAiAppPanel paramArkAiAppPanel, List paramList, int paramInt1, boolean paramBoolean2, Context paramContext1, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, RecommendCommonMessage paramRecommendCommonMessage, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, ArkRecommendController.AttachAppHolder paramAttachAppHolder, boolean paramBoolean3, int paramInt2, Context paramContext2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener, this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder, this.c, this.jdField_b_of_type_Int);
      ArkAppReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "__global__", "ArkAlertDialogConfirm", 0L, 0L, 0L, 0L, 0L, "", "");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      ArkRecommendController.a(this.jdField_b_of_type_AndroidContentContext, "open", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ArkAppCenter.b("ArkDialog", String.format("PositiveButton click failed, err=%s", new Object[] { paramDialogInterface.getMessage() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqq
 * JD-Core Version:    0.7.0.1
 */