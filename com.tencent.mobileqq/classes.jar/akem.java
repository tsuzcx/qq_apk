import com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class akem
  implements agin
{
  private ahpg jdField_a_of_type_Ahpg;
  private akfg jdField_a_of_type_Akfg;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniECommerceExposeDataReportHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  akem(akfg paramakfg)
  {
    this.jdField_a_of_type_Akfg = paramakfg;
  }
  
  private ListView a()
  {
    return this.jdField_a_of_type_Akfg.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 4: 
    case 6: 
    case 20: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Ahpg = new ahpg();
          return;
        } while (this.b);
        this.b = true;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Ahpg.b(this.jdField_a_of_type_Akfg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Ahpg = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public int[] a()
  {
    return new int[] { 4, 6, 14, 20, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akem
 * JD-Core Version:    0.7.0.1
 */