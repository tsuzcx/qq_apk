import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import mqq.manager.Manager;

public class ambg
  implements Manager
{
  private QQAppInterface a;
  
  public ambg(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      throw new NullPointerException("RecentManagerFor3rdPart, app is null");
    }
    this.a = paramQQAppInterface;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.e())
      {
        amnz localamnz = this.a.a().a();
        paramString = localamnz.b(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          localamnz.b(paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      bool1 = bool2;
      if (this.a.e())
      {
        amnz localamnz = this.a.a().a();
        paramString = localamnz.b(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          paramString.lastmsgtime = paramLong;
          localamnz.a(paramString);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if ((this.a != null) && (this.a.e()))
    {
      amnz localamnz = this.a.a().a();
      RecentUser localRecentUser = localamnz.a(paramString1, paramInt);
      localRecentUser.uin = paramString1;
      localRecentUser.setType(paramInt);
      localRecentUser.displayName = paramString2;
      localRecentUser.lastmsgtime = paramLong1;
      localRecentUser.lastmsgdrafttime = paramLong2;
      localamnz.a(localRecentUser);
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambg
 * JD-Core Version:    0.7.0.1
 */