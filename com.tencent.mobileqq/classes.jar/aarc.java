import com.tencent.mobileqq.ark.ArkMessageServerLogic.ServerCheckCallback;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aarc
  implements ArkMessageServerLogic.ServerCheckCallback
{
  public aarc(ArkRecommendLogic paramArkRecommendLogic, RecommendCommonMessage paramRecommendCommonMessage, WeakReference paramWeakReference) {}
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      ArkRecommendLogic.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_JavaLangRefWeakReference, 4);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ArkApp.ArkRecommendLogic", 2, "ContextItem is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarc
 * JD-Core Version:    0.7.0.1
 */