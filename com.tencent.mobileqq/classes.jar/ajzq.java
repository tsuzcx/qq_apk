import com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class ajzq
  implements agma
{
  private ahqe jdField_a_of_type_Ahqe;
  private akaj jdField_a_of_type_Akaj;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniECommerceExposeDataReportHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  ajzq(akaj paramakaj)
  {
    this.jdField_a_of_type_Akaj = paramakaj;
  }
  
  private ListView a()
  {
    return this.jdField_a_of_type_Akaj.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
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
          this.jdField_a_of_type_Ahqe = new ahqe();
          return;
        } while (this.b);
        this.b = true;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Ahqe.b(this.jdField_a_of_type_Akaj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_Ahqe = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 13, 19, 12 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzq
 * JD-Core Version:    0.7.0.1
 */