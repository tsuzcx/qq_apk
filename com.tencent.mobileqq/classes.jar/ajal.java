import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.manager.Manager;

public class ajal
  implements Manager
{
  public QQAppInterface a;
  public List<ApolloActionRecentData> a;
  public List<ApolloActionRecentData> b = Collections.synchronizedList(new ArrayList());
  
  public ajal(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = aiyu.a(paramQQAppInterface, "recent_c2c");
    this.b = aiyu.a(paramQQAppInterface, "recent_troop");
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    }
    if (this.b == null) {
      this.b = Collections.synchronizedList(new ArrayList());
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() > 8)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(i - 8, this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.b.size() > 8)
    {
      i = this.b.size();
      this.b = this.b.subList(i - 8, this.b.size());
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajal
 * JD-Core Version:    0.7.0.1
 */