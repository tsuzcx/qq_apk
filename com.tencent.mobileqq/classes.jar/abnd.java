import com.tencent.mobileqq.activity.QQSettingMe;
import java.lang.ref.WeakReference;

public class abnd
  implements xga
{
  WeakReference<QQSettingMe> a;
  
  public abnd(QQSettingMe paramQQSettingMe)
  {
    this.a = new WeakReference(paramQQSettingMe);
  }
  
  public int a()
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.a.get();
    if (localQQSettingMe != null) {
      return localQQSettingMe.a();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnd
 * JD-Core Version:    0.7.0.1
 */