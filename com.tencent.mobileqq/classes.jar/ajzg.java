import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class ajzg
  implements View.OnClickListener
{
  public ajzg(SendHbMainFragment paramSendHbMainFragment, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    if (bkvx.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbMainFragment.openUrl(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzg
 * JD-Core Version:    0.7.0.1
 */