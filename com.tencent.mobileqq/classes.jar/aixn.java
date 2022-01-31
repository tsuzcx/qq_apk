import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.io.File;

public class aixn
  implements Runnable
{
  public aixn(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.s();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.s = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setText("视频合成失败");
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setTextColor(-65536);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b.setOnClickListener(new aixo(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.s = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setText("");
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setCompoundDrawablesWithIntrinsicBounds(2130844803, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.I = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a.a = new File(this.jdField_a_of_type_JavaLangString).length();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b.setOnClickListener(new aixp(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(TroopBarPublishActivity.c(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixn
 * JD-Core Version:    0.7.0.1
 */