import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import mqq.manager.Manager;

public class akgl
  implements Manager
{
  private aukn a;
  
  public akgl(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public ShortVideoUpInfo a(String paramString)
  {
    return (ShortVideoUpInfo)this.a.a(ShortVideoUpInfo.class, paramString);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if (paramString != null) {
      bool = this.a.b(paramString);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgl
 * JD-Core Version:    0.7.0.1
 */