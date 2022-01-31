import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.io.File;

public class ajcq
  implements Runnable
{
  public ajcq(TroopBarPublishActivity paramTroopBarPublishActivity, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.s();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.s = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setText("视频合成失败");
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setTextColor(-65536);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b.setOnClickListener(new ajcr(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.s = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setText("");
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.g.setCompoundDrawablesWithIntrinsicBounds(2130844878, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.I = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a.a = new File(this.jdField_a_of_type_JavaLangString).length();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.b.setOnClickListener(new ajcs(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity.a(TroopBarPublishActivity.c(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishActivity), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcq
 * JD-Core Version:    0.7.0.1
 */