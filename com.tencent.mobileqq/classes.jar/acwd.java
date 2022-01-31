import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public final class acwd
  implements aptw
{
  public acwd(ArrayList paramArrayList, Context paramContext, int paramInt, QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Uri)localIterator.next();
      localObject = aqcc.a(this.jdField_a_of_type_AndroidContentContext, (Uri)localObject);
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.jdField_a_of_type_JavaLangString);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwd
 * JD-Core Version:    0.7.0.1
 */