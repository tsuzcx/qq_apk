import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class aljv
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<alju> jdField_a_of_type_JavaUtilList;
  
  public aljv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static aljv a(QQAppInterface paramQQAppInterface)
  {
    return (aljv)paramQQAppInterface.getManager(281);
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
      ((alju)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(alju paramalju)
  {
    if (paramalju == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramalju)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramalju);
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((alju)localIterator.next()).b(paramInt);
    }
  }
  
  public void b(alju paramalju)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramalju);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljv
 * JD-Core Version:    0.7.0.1
 */