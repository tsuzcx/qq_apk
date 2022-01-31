import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public final class aesc
  implements arrh
{
  public aesc(ArrayList paramArrayList, Context paramContext, int paramInt, QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Uri)localIterator.next();
      localObject = arzt.a(this.jdField_a_of_type_AndroidContentContext, (Uri)localObject);
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.jdField_a_of_type_JavaLangString);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesc
 * JD-Core Version:    0.7.0.1
 */