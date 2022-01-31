import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import java.lang.ref.WeakReference;

public class abog
  implements Runnable
{
  public abog(RecommendCommonMessage paramRecommendCommonMessage, WeakReference paramWeakReference) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null) {
      localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abog
 * JD-Core Version:    0.7.0.1
 */