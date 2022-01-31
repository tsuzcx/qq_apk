import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import java.util.ArrayList;

class aedh
  extends ajhi
{
  aedh(aede paramaede) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((i != -1) && (paramBoolean))
    {
      if (((Boolean)paramObject.get(i + 1)).booleanValue()) {
        this.a.b(false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        paramObject = ((ajhh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((paramObject != null) && (paramObject.discussionName != null))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramObject.discussionName;
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramObject.uin, this.a.e);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      paramString = ((ajhh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(paramString);
      if ((paramString != null) && (paramString.discussionName != null))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.discussionName;
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramString.uin, this.a.e);
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      this.a.H();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedh
 * JD-Core Version:    0.7.0.1
 */