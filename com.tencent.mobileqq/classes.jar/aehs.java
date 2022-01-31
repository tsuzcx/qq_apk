import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.leba.LebaTitleBar;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;

public class aehs
  implements Runnable
{
  public aehs(LebaTitleBar paramLebaTitleBar, HotWordSearchEntryDataModel paramHotWordSearchEntryDataModel) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a();
    LebaTitleBar.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaTitleBar).runOnUiThread(new aeht(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehs
 * JD-Core Version:    0.7.0.1
 */