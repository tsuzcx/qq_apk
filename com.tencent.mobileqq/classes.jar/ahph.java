import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.qphone.base.util.QLog;

public class ahph
  extends ahpj
{
  public ahph(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "get video download finish,vid=" + paramString1);
    }
    if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      paramString1 = ((wte)wth.a(5)).a(paramString1);
      if (paramString1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQStoryItemBuilder", 2, "get video download finish, storyVideoItem == null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_Ahpk, this.jdField_a_of_type_Long, paramString1, false);
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQStoryItemBuilder", 2, "Download video failed,vid=" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_Ahpk, this.jdField_a_of_type_Long);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQStoryItemBuilder", 2, "Download video onPause,vid=" + paramString1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_Ahpk, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahph
 * JD-Core Version:    0.7.0.1
 */