import com.tencent.mobileqq.doutu.DoutuEmotionAdapter;
import com.tencent.mobileqq.doutu.DoutuManager;
import java.util.List;

public class abyj
  implements Runnable
{
  public abyj(DoutuManager paramDoutuManager, boolean paramBoolean1, List paramList, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.a != null)
    {
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList.size() < 0)) {
        break label52;
      }
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.a.a(this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_Long);
    }
    label52:
    while (!this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.a.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyj
 * JD-Core Version:    0.7.0.1
 */