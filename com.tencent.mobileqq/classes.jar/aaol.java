import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCGI.QueryAppInfoByAppNameBatchResult;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import java.util.HashMap;

class aaol
  extends ArkAppCGI.ArkAppCGICallback
{
  aaol(aaok paramaaok) {}
  
  public void a(ArkAppCGI.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, Object paramObject)
  {
    paramObject = (HashMap)paramObject;
    ArkLocalAppMgr.a(this.a.a, paramQueryAppInfoByAppNameBatchResult, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaol
 * JD-Core Version:    0.7.0.1
 */