import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aklu
  implements HttpWebCgiAsyncTask.Callback
{
  public aklu(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null) {
          try
          {
            paramJSONObject = (JSONObject)paramJSONObject.get("data");
            if (paramJSONObject != null)
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("key");
              if (paramJSONObject != null)
              {
                paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                paramBundle = (String)paramJSONObject.get("retMsg");
                if (paramInt != 0) {
                  break label336;
                }
                if (this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null)
                {
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.a);
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131428661));
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131428662, new Object[] { this.a.d }), this.a);
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a);
                }
                if (!this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()) {
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
                }
                ReportController.b(this.a.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
                if (QLog.isColorLevel())
                {
                  QLog.i("BindGroupConfirmActivity", 2, "bindGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                  return;
                }
              }
            }
          }
          catch (Exception paramJSONObject)
          {
            BindGroupConfirmActivity.a(this.a, this.a.getActivity().getResources().getString(2131433671));
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupConfirmActivity", 2, "bindGroup onResult " + paramJSONObject.toString());
    return;
    label336:
    paramJSONObject = this.a.getActivity().getResources().getString(2131433671);
    switch (paramInt)
    {
    }
    for (;;)
    {
      BindGroupConfirmActivity.a(this.a, paramJSONObject);
      break;
      paramJSONObject = this.a.getActivity().getResources().getString(2131433674);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131433675);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131433677);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aklu
 * JD-Core Version:    0.7.0.1
 */