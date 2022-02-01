import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;

public class ajmc
  extends ajmf
{
  public MayKnowRecommend a;
  
  public ajmc(MayKnowRecommend paramMayKnowRecommend)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = paramMayKnowRecommend;
    this.jdField_a_of_type_Long = paramMayKnowRecommend.timestamp;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramQQAppInterface = (aobl)paramQQAppInterface.getManager(159);
      if (paramQQAppInterface == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = paramQQAppInterface.a();; bool = false)
    {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getDisplayName(bool);
      this.jdField_a_of_type_JavaLangString = String.format(BaseApplicationImpl.sApplication.getString(2131689654), new Object[] { paramQQAppInterface });
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmc
 * JD-Core Version:    0.7.0.1
 */