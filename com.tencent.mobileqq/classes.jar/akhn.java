import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class akhn
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<akhm> jdField_a_of_type_JavaUtilList;
  
  public akhn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static akhn a(QQAppInterface paramQQAppInterface)
  {
    return (akhn)paramQQAppInterface.getManager(281);
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
      ((akhm)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(akhm paramakhm)
  {
    if (paramakhm == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramakhm)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramakhm);
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((akhm)localIterator.next()).b(paramInt);
    }
  }
  
  public void b(akhm paramakhm)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramakhm);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhn
 * JD-Core Version:    0.7.0.1
 */