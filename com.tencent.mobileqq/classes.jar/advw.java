import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment.NearbyWebViewBuilder;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.OnActionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class advw
  implements OverCoverFrameLayout.OnActionListener
{
  public advw(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public boolean a()
  {
    return this.a.jdField_a_of_type_ComTencentBizUiRefreshView.b();
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyHybridFragment", 2, "status =" + paramInt1 + ",direction =" + paramInt2 + ",height =" + paramInt3);
    }
    String str = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).getString("nearby_view_change_callback", "");
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(str)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("status", paramInt1);
      localJSONObject.put("direction", paramInt2);
      localJSONObject.put("height", paramInt3);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a.a(str, new String[] { localJSONObject.toString() });
      }
      return false;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("NearbyHybridFragment", 2, localJSONException, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advw
 * JD-Core Version:    0.7.0.1
 */