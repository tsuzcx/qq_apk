import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public final class aedy
  implements Runnable
{
  public aedy(String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    String str = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      str = ((QQAppInterface)localObject).getCurrentAccountUin();
    }
    localObject = new HashMap();
    if (this.jdField_a_of_type_JavaLangString != null) {
      ((HashMap)localObject).put("activity", this.jdField_a_of_type_JavaLangString);
    }
    if (this.b != null) {
      ((HashMap)localObject).put("detail", this.b);
    }
    ((HashMap)localObject).put("type", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(str, "BadTokenHooker", false, 0L, 0L, (HashMap)localObject, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedy
 * JD-Core Version:    0.7.0.1
 */