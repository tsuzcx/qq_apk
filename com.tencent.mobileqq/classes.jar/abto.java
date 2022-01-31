import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abto
  implements AdapterView.OnItemClickListener
{
  abto(abtn paramabtn, int paramInt, absf paramabsf) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_Abtn.a.dismiss();
    long l = paramLong;
    label92:
    int j;
    int i;
    switch (((bdip)paramAdapterView).a.action)
    {
    default: 
      l = paramLong;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      j = (int)l;
      if ((l == 2L) || (l == 3L)) {
        if (!WXShareHelper.a().a()) {
          i = 2131721478;
        }
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        if (i != -1)
        {
          paramAdapterView = BaseApplicationImpl.getContext();
          QQToast.a(paramAdapterView, paramAdapterView.getString(i), 0).b(this.jdField_a_of_type_Int);
          return;
          l = 0L;
          break label92;
          l = 1L;
          break label92;
          l = 3L;
          break label92;
          l = 2L;
          break label92;
          l = 4L;
          break label92;
          if (WXShareHelper.a().b()) {
            break label316;
          }
          i = 2131721479;
          continue;
        }
        paramAdapterView = new JSONObject();
        try
        {
          paramAdapterView.put("selectChanel", j);
          abvm.a(this.jdField_a_of_type_Absf, paramAdapterView);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("DoraemonApi.ShareModule", 2, "onItemClick.chooseChannel: " + paramInt + "," + l);
          return;
        }
        catch (Exception paramAdapterView)
        {
          for (;;)
          {
            paramView = paramAdapterView.getMessage();
            QLog.e("DoraemonApi.ShareModule", 1, "put channel failed!");
            absf localabsf = this.jdField_a_of_type_Absf;
            paramAdapterView = paramView;
            if (paramView == null) {
              paramAdapterView = "";
            }
            abvm.a(localabsf, -1, paramAdapterView);
          }
        }
      }
      label316:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abto
 * JD-Core Version:    0.7.0.1
 */