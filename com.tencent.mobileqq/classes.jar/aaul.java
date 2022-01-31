import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;

public class aaul
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  public aaul(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.a != null))
    {
      ArkAppCenter.a(paramAppPathInfo.a, new aaum(this));
      paramString = ArkAppCenter.b(paramAppPathInfo.a);
      ArkAppCenter.a().postToMainThread(new aaun(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaul
 * JD-Core Version:    0.7.0.1
 */