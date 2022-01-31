import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import com.tencent.mobileqq.widget.TipsBar;

public class aiyo
  implements View.OnClickListener
{
  public aiyo(SendHbMainFragment paramSendHbMainFragment, TipsBar paramTipsBar, SharedPreferences paramSharedPreferences, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("red_packet_bulletin", this.jdField_a_of_type_Int).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyo
 * JD-Core Version:    0.7.0.1
 */