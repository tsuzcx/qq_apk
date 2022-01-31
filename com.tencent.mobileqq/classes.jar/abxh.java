import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class abxh
  implements AdapterView.OnItemClickListener
{
  public abxh(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_TabClick");
    if (this.a.jdField_a_of_type_JavaUtilList == null) {
      break label21;
    }
    label21:
    while (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
    boolean bool;
    label96:
    Object localObject;
    label159:
    label240:
    String str;
    if ((this.a.jdField_a_of_type_JavaUtilList.size() > EmoticonMainPanel.e) && (((EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(EmoticonMainPanel.e)).jdField_a_of_type_Int == 8))
    {
      bool = true;
      EmoticonMainPanel.f = bool;
      localObject = (EmotionPanelInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramAdapterView = "";
      if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int != 8) {
        break label428;
      }
      paramAdapterView = (ImageView)paramView.findViewById(2131363834);
      bool = false;
      if (paramAdapterView != null)
      {
        if (paramAdapterView.getVisibility() != 0) {
          break label416;
        }
        bool = true;
        paramAdapterView.setVisibility(8);
      }
      paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      paramAdapterView.edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", bool).apply();
      int i = paramAdapterView.getInt("recommendRuleId", -1);
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      if (!bool) {
        break label422;
      }
      paramAdapterView = "1";
      VasWebviewUtil.reportCommercialDrainage(paramView, "ep_mall", "0X8005798", "", 0, 0, 0, "", "", "", paramAdapterView, "", i + "", "", 0, 0, 0, 0);
      paramView = "已选定推荐面板";
      str = "";
      localObject = "";
      paramAdapterView = "0X8005798";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAdapterView)) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", paramAdapterView, 0, 0, (String)localObject, "", str, "");
      }
      if (EmoticonMainPanel.c == paramInt) {
        break;
      }
      EmoticonMainPanel.c = paramInt;
      this.a.d(paramInt);
      if (AppSetting.b) {
        QQAppInterface.f(paramView);
      }
      StartupTracker.a("AIO_EmoticonPanel_TabClick", null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - paramLong));
      return;
      bool = false;
      break label96;
      label416:
      bool = false;
      break label159;
      label422:
      paramAdapterView = "";
      break label240;
      label428:
      if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 9)
      {
        paramAdapterView = "0X8005797";
        paramView = "已选定魔法表情面板";
        str = "";
        localObject = "";
      }
      else if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 4)
      {
        paramAdapterView = "0X8005799";
        this.a.f();
        paramView = "已选定收藏表情面板";
        str = "";
        localObject = "";
      }
      else if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 7)
      {
        paramAdapterView = "0X800579A";
        paramView = "已选定经典表情面板";
        str = "";
        localObject = "";
      }
      else
      {
        if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 6)
        {
          EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          if (localEmoticonPackage != null)
          {
            localObject = localEmoticonPackage.epId;
            if (localEmoticonPackage.status == 2) {}
            for (paramAdapterView = "0X800584E";; paramAdapterView = "0X80059B8")
            {
              str = Integer.toString(this.a.a((String)localObject));
              paramView = "已选定" + localEmoticonPackage.name + "面板";
              if (localEmoticonPackage.status == 2) {
                break label637;
              }
              paramView = paramView + ",未下载";
              break;
            }
            label637:
            continue;
          }
        }
        paramView = "";
        str = "";
        localObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxh
 * JD-Core Version:    0.7.0.1
 */