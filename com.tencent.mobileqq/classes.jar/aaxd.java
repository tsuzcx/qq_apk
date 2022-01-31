import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendController.AttachAppHolder;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.IGetAppInfosByContextCallback;
import java.util.ArrayList;
import java.util.LinkedList;

public class aaxd
  implements RecommendCommonMessage.IGetAppInfosByContextCallback
{
  public aaxd(ArkRecommendController paramArkRecommendController, int[] paramArrayOfInt, int paramInt1, int paramInt2, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkRecommendController.AttachAppHolder paramAttachAppHolder, RecommendCommonMessage.ArkContextInfo paramArkContextInfo, RecommendCommonMessage paramRecommendCommonMessage, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void a(ArrayList paramArrayList)
  {
    int k = 0;
    int m = Math.min(paramArrayList.size(), ArkRecommendController.jdField_b_of_type_Int);
    this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = m;
    int j = 0;
    int n;
    for (int i = 0; j < this.jdField_a_of_type_Int; i = n + i)
    {
      n = this.jdField_a_of_type_ArrayOfInt[j];
      j += 1;
    }
    if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a() - i - this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]);
      if (this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] + i <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.a.setVisibility(8);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.a.setVisibility(0);
      j = 0;
      if (j < m)
      {
        RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = (RecommendCommonMessage.ArkMsgAppInfo)paramArrayList.get(j);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.contextAppInfoList.contains(localArkMsgAppInfo)) {
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkContextInfo.contextAppInfoList.add(localArkMsgAppInfo);
        }
        ArkAdapterItemForTextMsg localArkAdapterItemForTextMsg = (ArkAdapterItemForTextMsg)this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.b(i + j);
        if (localArkAdapterItemForTextMsg == null)
        {
          localArkAdapterItemForTextMsg = new ArkAdapterItemForTextMsg();
          localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = localArkMsgAppInfo;
          localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
          localArkAdapterItemForTextMsg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localArkAdapterItemForTextMsg.jdField_b_of_type_Int = j;
          this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(localArkAdapterItemForTextMsg);
        }
        for (;;)
        {
          j += 1;
          break;
          localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = localArkMsgAppInfo;
          localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
          localArkAdapterItemForTextMsg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localArkAdapterItemForTextMsg.jdField_b_of_type_Int = j;
          this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.b(i + j, localArkAdapterItemForTextMsg);
        }
      }
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 1) && (this.jdField_a_of_type_Boolean))
      {
        j = 0;
        i = k;
        while (i < this.c)
        {
          j += this.jdField_a_of_type_ArrayOfInt[i];
          i += 1;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.a.setRestoreX((j + 1) * (BaseChatItemLayout.d + this.d) + this.e - (BaseChatItemLayout.c - this.f));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.a.setRestoreX(j * (BaseChatItemLayout.d + this.d) + this.d + this.e - this.f);
        return;
      }
    } while (this.c != -2);
    this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.a.setRestoreX(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxd
 * JD-Core Version:    0.7.0.1
 */