import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class akyg
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<akyf> jdField_a_of_type_JavaUtilList;
  
  public akyg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static akyg a(QQAppInterface paramQQAppInterface)
  {
    return (akyg)paramQQAppInterface.getManager(281);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface != null) {
      a(paramQQAppInterface).a(paramInt);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface != null) {
      a(paramQQAppInterface).b(paramInt);
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((akyf)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(akyf paramakyf)
  {
    if (paramakyf == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramakyf)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramakyf);
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((akyf)localIterator.next()).b(paramInt);
    }
  }
  
  public void b(akyf paramakyf)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramakyf);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyg
 * JD-Core Version:    0.7.0.1
 */