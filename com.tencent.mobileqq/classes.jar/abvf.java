import com.tencent.mobileqq.ark.ArkLocalAppMgr.GetAppPathByActionResult;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByActionCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.IGetAppInfosByContextCallback;
import java.util.ArrayList;
import java.util.Iterator;

public final class abvf
  implements ArkLocalAppMgr.IGetAppPathByActionCallback
{
  public abvf(String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void a(Object paramObject, ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ArkLocalAppMgr.GetAppPathByActionResult localGetAppPathByActionResult = (ArkLocalAppMgr.GetAppPathByActionResult)paramArrayList.next();
      if ((localGetAppPathByActionResult.a == 0) && (localGetAppPathByActionResult.c != null))
      {
        RecommendCommonMessage.ArkMsgAppInfo localArkMsgAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
        localArkMsgAppInfo.appName = localGetAppPathByActionResult.b;
        localArkMsgAppInfo.appPath = localGetAppPathByActionResult.c;
        localArkMsgAppInfo.appView = localGetAppPathByActionResult.d;
        localArkMsgAppInfo.keyword = this.jdField_a_of_type_JavaLangString;
        localArkMsgAppInfo.equalInputText = this.jdField_a_of_type_Boolean;
        localArkMsgAppInfo.meta = this.b;
        localArrayList.add(localArkMsgAppInfo);
      }
    }
    if ((paramObject != null) && ((paramObject instanceof RecommendCommonMessage.IGetAppInfosByContextCallback))) {
      ((RecommendCommonMessage.IGetAppInfosByContextCallback)paramObject).a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvf
 * JD-Core Version:    0.7.0.1
 */