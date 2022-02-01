import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class acgu
  implements View.OnClickListener
{
  public acgu(GdtInterstitialFragmentForJS paramGdtInterstitialFragmentForJS, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a = 1;
    GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).b = GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getActivity());
    String str;
    if (GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS) == null)
    {
      str = "ad is not loaded";
      Toast.makeText(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getActivity().getApplicationContext(), "ad is not loaded", 0).show();
    }
    for (;;)
    {
      Toast.makeText(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getActivity().getApplicationContext(), str, 0).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS) == null)
      {
        str = "ad is loading";
      }
      else if (GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a() != 0)
      {
        str = GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a();
      }
      else
      {
        GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a(this.jdField_a_of_type_OrgJsonJSONObject);
        if (GdtInterstitialFragmentForJS.a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS).a(this.jdField_a_of_type_ComTencentGdtadJsbridgeGdtInterstitialFragmentForJS.getActivity())) {
          str = "正在打开插屏";
        } else {
          str = "打开插屏错误";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgu
 * JD-Core Version:    0.7.0.1
 */