import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;

class abbw
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  static
  {
    if (!ArkLocalAppMgr.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  abbw(abbv paramabbv, String paramString) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo != null))
    {
      ArkLocalAppMgr.a(this.jdField_a_of_type_Abbv.a.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr, this.jdField_a_of_type_Abbv.a.jdField_a_of_type_Abcr, paramInt, paramString, paramAppPathInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramInt == 0)
    {
      if (!jdField_a_of_type_Boolean) {
        throw new AssertionError();
      }
      paramInt = -1;
      paramString = "ret is 0 but path is null";
    }
    for (;;)
    {
      ArkLocalAppMgr.a(this.jdField_a_of_type_Abbv.a.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr, this.jdField_a_of_type_Abbv.a.jdField_a_of_type_Abcr, paramInt, paramString, null, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbw
 * JD-Core Version:    0.7.0.1
 */