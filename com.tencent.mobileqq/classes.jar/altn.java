import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class altn
{
  java.lang.ref.WeakReference<QQAppInterface> a;
  
  public altn(QQAppInterface paramQQAppInterface)
  {
    this.a = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, ajtg paramajtg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.SSO", "requestArkAppList, app is null, return false");
      return false;
    }
    return ((altg)localQQAppInterface.a(95)).a(paramString, paramInt1, paramInt2, paramajtg);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, ajtg paramajtg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.SSO", "sendAppMsg, app is null, return false");
      return false;
    }
    return ((altg)localQQAppInterface.a(95)).a(paramString1, paramString2, paramInt1, paramInt2, paramajtg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altn
 * JD-Core Version:    0.7.0.1
 */