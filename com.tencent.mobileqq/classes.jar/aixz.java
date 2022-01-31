import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class aixz
  implements BusinessObserver
{
  public aixz(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.c(false);
    this.a.rightViewText.setEnabled(true);
    TroopBarPublishActivity localTroopBarPublishActivity = this.a;
    this.a.getString(2131430308);
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label807;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          break label266;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.a.getString(2131430309, new Object[] { Integer.valueOf(paramInt) });
        }
        if (this.a.jdField_d_of_type_Int == 2) {
          ReportController.b(null, "dc00899", "Grp_talk", "", "pub_talk", "pub_fail", 0, 0, "", "" + paramInt, TroopBarPublishActivity.a(this.a), "");
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Object localObject;
          label224:
          StringBuffer localStringBuffer;
          label266:
          paramBundle = this.a.getString(2131430309, new Object[] { Integer.valueOf(9992) });
          continue;
          localStringBuffer.append("7");
          continue;
          localStringBuffer.append("8");
          continue;
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.c;
          continue;
          paramBundle = this.a.E;
        }
      }
      QQToast.a(localTroopBarPublishActivity, 1, paramBundle, 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label859;
      }
      paramBundle = "0";
      TroopBarUtils.a("pub_page", "fail", paramBundle, "4", TroopBarPublishActivity.a(this.a), "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
      return;
      localObject = paramBundle.getJSONObject("result");
      localStringBuffer = new StringBuffer();
      if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localStringBuffer.append("0");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        localStringBuffer.append("1");
      }
      if (!TextUtils.isEmpty(TroopBarUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqTribeViewTEditText))) {
        localStringBuffer.append("2");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        localStringBuffer.append("5");
      }
      if (this.a.h) {
        if (!TextUtils.isEmpty(TroopBarUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText)))
        {
          localStringBuffer.append("6");
          if (!TextUtils.isEmpty(this.a.E)) {
            break label772;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
            break label758;
          }
          paramBundle = "0";
          if ((this.a.jdField_b_of_type_AndroidWidgetTextView == null) || (this.a.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
            break label879;
          }
        }
      }
    }
    label772:
    label783:
    label807:
    label859:
    label879:
    for (paramInt = 2;; paramInt = 1)
    {
      ReportController.b(null, "P_CliOper", "Grp_tribe", "", "pub_page", "suc", paramInt, 0, paramBundle, this.a.c, localStringBuffer.toString(), "");
      this.a.e = true;
      ((JSONObject)localObject).optString("pid");
      paramBundle = ((JSONObject)localObject).optString("bid");
      if ((this.a.jdField_d_of_type_Boolean) && (this.a.jdField_a_of_type_OrgJsonJSONObject != null))
      {
        this.a.getIntent().getStringExtra("pkg_name");
        this.a.jdField_a_of_type_OrgJsonJSONObject.optString("share_app_name");
        this.a.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id");
        if (TextUtils.isEmpty(paramBundle)) {
          break label783;
        }
      }
      for (;;)
      {
        TroopBarShareUtils.a(this.a.app, "share_suc", paramBundle);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTribeVideoInfo != null) {
          this.a.t();
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem != null) && (!TroopBarPublishActivity.b(this.a).equals("###...^_^###"))) {
          ReportController.b(null, "dc00899", "Grp_tribe", "", "pub_page", "sus_prefixpub", 0, 0, this.a.r, "", "", "");
        }
        paramBundle = new Intent();
        paramBundle.putExtra("result", ((JSONObject)localObject).toString());
        this.a.setResult(-1, paramBundle);
        this.a.finish();
        return;
        label758:
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null)
        {
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.c;
          continue;
          paramBundle = this.a.getString(2131430309, new Object[] { Integer.valueOf(9991) });
          break;
          paramBundle = this.a.getString(2131430309, new Object[] { Integer.valueOf(9992) });
          break;
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.c;
          break label224;
        }
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixz
 * JD-Core Version:    0.7.0.1
 */