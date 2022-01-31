import com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class aiix
  implements affa
{
  private afcs jdField_a_of_type_Afcs;
  private aijq jdField_a_of_type_Aijq;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniECommerceExposeDataReportHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  aiix(aijq paramaijq)
  {
    this.jdField_a_of_type_Aijq = paramaijq;
  }
  
  private ListView a()
  {
    return this.jdField_a_of_type_Aijq.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
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
          this.jdField_a_of_type_Afcs = new afcs();
          return;
        } while (this.b);
        this.b = true;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Afcs.b(this.jdField_a_of_type_Aijq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Afcs = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public int[] a()
  {
    return new int[] { 2, 4, 11, 17, 10 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiix
 * JD-Core Version:    0.7.0.1
 */