import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity;
import com.tencent.mobileqq.activity.TroopRobotPickerActivity.RobotPickerData;
import com.tencent.mobileqq.conditionsearch.CountrySelectActivity;

public class aedk
  implements View.OnClickListener
{
  public aedk(TroopRobotPickerActivity paramTroopRobotPickerActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, CountrySelectActivity.class);
    paramView.putExtra("key_country_code", this.a.a.mLocationCountyCode);
    paramView.putExtra("key_no_limit_allow", true);
    this.a.startActivityForResult(paramView, 111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedk
 * JD-Core Version:    0.7.0.1
 */