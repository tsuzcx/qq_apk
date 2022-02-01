import com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class akkz
  implements agvc
{
  private ahzs jdField_a_of_type_Ahzs;
  private aklt jdField_a_of_type_Aklt;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniECommerceExposeDataReportHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  akkz(aklt paramaklt)
  {
    this.jdField_a_of_type_Aklt = paramaklt;
  }
  
  private ListView a()
  {
    return this.jdField_a_of_type_Aklt.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
    case 5: 
    case 19: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Ahzs = new ahzs();
          return;
        } while (this.b);
        this.b = true;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Ahzs.b(this.jdField_a_of_type_Aklt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Ahzs = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 13, 19, 12 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkz
 * JD-Core Version:    0.7.0.1
 */