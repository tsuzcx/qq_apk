import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;

class adnt
  implements View.OnClickListener
{
  adnt(adnq paramadnq, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_Adnq.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Adnq.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnt
 * JD-Core Version:    0.7.0.1
 */