import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class aldg
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<aldf> jdField_a_of_type_JavaUtilList;
  
  public aldg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static aldg a(QQAppInterface paramQQAppInterface)
  {
    return (aldg)paramQQAppInterface.getManager(QQManagerFactory.BANNER_LISTENER_MANAGER);
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
      ((aldf)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(aldf paramaldf)
  {
    if (paramaldf == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramaldf)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaldf);
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aldf)localIterator.next()).b(paramInt);
    }
  }
  
  public void b(aldf paramaldf)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramaldf);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aldg
 * JD-Core Version:    0.7.0.1
 */