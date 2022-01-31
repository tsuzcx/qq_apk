import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.GetAppPathByActionResult;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;
import java.util.ArrayList;

public class abcb
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  public abcb(ArkLocalAppMgr paramArkLocalAppMgr, String paramString, int paramInt, abcv paramabcv) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    paramObject = null;
    if ((paramInt != 0) || (paramAppPathInfo == null) || (paramAppPathInfo.jdField_a_of_type_JavaLangString == null))
    {
      ArkAppCenter.b("ArkApp.ArkLocalAppMgr", String.format("getAppViewByIntent, getAppPathByName fail, ret=%d", new Object[] { Integer.valueOf(paramInt) }));
      paramString = null;
      paramAppPathInfo = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Abcv.d = paramString;
      this.jdField_a_of_type_Abcv.e = paramAppPathInfo;
      this.jdField_a_of_type_Abcv.c = paramObject;
      ArkLocalAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr, this.jdField_a_of_type_Abcv);
      return;
      ArrayList localArrayList = new ArrayList();
      ArkLocalAppMgr.a(paramAppPathInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, localArrayList);
      ArkAppCenter.b("ArkBubbleState", String.format("getAppViewByIntent, getAppPathByName success, ret=%d", new Object[] { Integer.valueOf(2) }));
      if ((localArrayList.isEmpty()) && (this.jdField_a_of_type_Int == 4))
      {
        ArkLocalAppMgr.a(paramAppPathInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 1, localArrayList);
        ArkAppCenter.b("ArkBubbleState", String.format("getAppViewByIntent, getAppPathByName success, ret=%d", new Object[] { Integer.valueOf(1) }));
      }
      if (!localArrayList.isEmpty())
      {
        paramString = paramAppPathInfo.jdField_a_of_type_JavaLangString;
        paramAppPathInfo = ((ArkLocalAppMgr.GetAppPathByActionResult)localArrayList.get(0)).d;
        paramObject = ((ArkLocalAppMgr.GetAppPathByActionResult)localArrayList.get(0)).e;
      }
      else
      {
        paramString = null;
        paramAppPathInfo = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abcb
 * JD-Core Version:    0.7.0.1
 */