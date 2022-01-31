import com.tencent.mobileqq.ark.ArkLocalAppMgr.GetAppPathByActionResult;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByActionCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.IGetAppInfosByContextListCallback;
import java.util.ArrayList;
import java.util.Iterator;

public final class acdd
  implements ArkLocalAppMgr.IGetAppPathByActionCallback
{
  public acdd(String paramString1, boolean paramBoolean, String paramString2) {}
  
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
    paramObject = (RecommendCommonMessage.IGetAppInfosByContextListCallback)paramObject;
    paramObject.mAppList.addAll(localArrayList);
    int i = paramObject.mCount - 1;
    paramObject.mCount = i;
    if (i == 0) {
      paramObject.onGetAppInfos(paramObject.mAppList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acdd
 * JD-Core Version:    0.7.0.1
 */