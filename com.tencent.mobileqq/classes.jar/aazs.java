import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;

public class aazs
  implements View.OnClickListener
{
  public aazs(ARGridMapViewDialog paramARGridMapViewDialog, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.a, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.a.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aazs
 * JD-Core Version:    0.7.0.1
 */