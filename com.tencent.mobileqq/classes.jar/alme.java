import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.Comparator;

public class alme
  implements Comparator<almg>
{
  private int a(almg paramalmg)
  {
    if ((a(paramalmg) == 0L) || (paramalmg.jdField_a_of_type_Int == 4)) {
      return paramalmg.jdField_a_of_type_Int + 3;
    }
    return paramalmg.jdField_a_of_type_Int;
  }
  
  private long a(almg paramalmg)
  {
    if ((paramalmg.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo)) {
      return ((TroopInfo)paramalmg.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    if ((paramalmg.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramalmg.jdField_a_of_type_ComTencentMobileqqPersistenceEntity).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(almg paramalmg1, almg paramalmg2)
  {
    if ((paramalmg1 == null) && (paramalmg2 == null)) {
      return 0;
    }
    if (paramalmg1 == null) {
      return -1;
    }
    if (paramalmg2 == null) {
      return 1;
    }
    if (a(paramalmg1) == a(paramalmg2)) {
      return (int)(a(paramalmg2) - a(paramalmg1));
    }
    return a(paramalmg1) - a(paramalmg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alme
 * JD-Core Version:    0.7.0.1
 */