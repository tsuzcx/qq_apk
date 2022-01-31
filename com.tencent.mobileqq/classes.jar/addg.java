import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment.NearbyWebViewBuilder;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class addg
  extends NearbyProcObserver
{
  public addg(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    }
    this.a.l();
    this.a.m();
  }
  
  protected void a(int paramInt, String paramString)
  {
    QLog.i("NearbyHybridFragment", 1, "onUploadSucc() called with: type = [" + paramInt + "], jsParam = [" + paramString + "]");
    if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject = (NearbyDataManager)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(209);
        if ((localObject != null) && (((NearbyDataManager)localObject).a() != null))
        {
          paramInt = ((NearbyDataManager)localObject).a().uint32_gender.get();
          paramString.put("gender", paramInt + 1);
          localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
          String str = ((SharedPreferences)localObject).getString("nearby_now_publish_success_js_callback", "");
          if (!TextUtils.isEmpty(str))
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a != null)) {
              this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a.a(str, new String[] { paramString.toString() });
            }
            paramString = ((SharedPreferences)localObject).edit();
            paramString.putString("nearby_now_publish_success_js_param", "");
            paramString.remove("nearby_now_publish_success_js_param").commit();
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("NearbyHybridFragment", 1, paramString, new Object[0]);
        return;
      }
      paramInt = 0;
    }
  }
  
  protected void a(int paramInt, String paramString, Bitmap paramBitmap)
  {
    if ((this.a.d != null) && (this.a.d.equals(paramString)) && (paramBitmap != null) && (this.a.b != null) && (this.a.b.getVisibility() == 0)) {
      this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramBitmap);
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    QLog.i("NearbyHybridFragment", 1, "onUploadFailed() called with: type = [" + paramInt + "], jsParam = [" + paramString + "]");
    if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      paramString = new JSONObject(paramString);
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
      String str = localSharedPreferences.getString("nearby_now_publish_failed_js_callback", "");
      if (!TextUtils.isEmpty(str))
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder != null) && (this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.a.a(str, new String[] { paramString.toString() });
        }
        paramString = localSharedPreferences.edit();
        paramString.putString("nearby_now_publish_success_js_param", "");
        paramString.remove("nearby_now_publish_success_js_param").commit();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyHybridFragment", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     addg
 * JD-Core Version:    0.7.0.1
 */