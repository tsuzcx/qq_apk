import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class acje
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList(20);
  
  private acje(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    if (this.jdField_a_of_type_JavaUtilList.size() >= 20) {
      b();
    }
  }
  
  void b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (i != 0) {
        localStringBuffer.append("|");
      }
      localStringBuffer.append((String)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    if (ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) != null) {
      ReportController.b(ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment), "dc00898", "", "", "0X8009324", "0X8009324", 0, 0, "", "", localStringBuffer.toString(), "");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acje
 * JD-Core Version:    0.7.0.1
 */