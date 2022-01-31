import com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class aggf
  implements adih
{
  private adgd jdField_a_of_type_Adgd;
  private aggy jdField_a_of_type_Aggy;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniECommerceExposeDataReportHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  aggf(aggy paramaggy)
  {
    this.jdField_a_of_type_Aggy = paramaggy;
  }
  
  private ListView a()
  {
    return this.jdField_a_of_type_Aggy.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
    case 4: 
    case 17: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Adgd = new adgd();
          return;
        } while (this.b);
        this.b = true;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Adgd.b(this.jdField_a_of_type_Aggy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Adgd = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public int[] a()
  {
    return new int[] { 2, 4, 11, 17, 10 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggf
 * JD-Core Version:    0.7.0.1
 */