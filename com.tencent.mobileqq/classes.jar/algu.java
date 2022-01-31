import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class algu
  extends ClickableSpan
{
  public algu(String paramString, int paramInt, long paramLong, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int k = 0;
    int i = 0;
    paramView = MobileQQ.sMobileQQ.waitAppRuntime(null);
    int j = k;
    Object localObject1;
    if (paramView != null)
    {
      paramView = (QQMessageFacade)paramView.getManager(19);
      j = k;
      if (paramView != null)
      {
        paramView = paramView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        if (paramView == null) {
          return;
        }
        localObject1 = paramView.getExtInfoFromExtStr("sens_msg_attr");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    label105:
    label363:
    label368:
    for (;;)
    {
      boolean bool;
      try
      {
        j = Integer.parseInt((String)localObject1);
        i = j;
      }
      catch (Exception localException)
      {
        Object localObject3;
        String str1;
        String str2;
        localException.printStackTrace();
        continue;
      }
      paramView = paramView.getExtInfoFromExtStr("sens_msg_need_mask");
      j = i;
      Object localObject2;
      if (!TextUtils.isEmpty(paramView))
      {
        bool = Boolean.parseBoolean(paramView);
        if ((this.jdField_a_of_type_Boolean) || (!bool)) {
          break label356;
        }
        paramView = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "Action", 1, i);
        if (paramView == null) {
          break;
        }
        localObject1 = paramView.keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = paramView.getBundle((String)((Iterator)localObject1).next());
          if ((localObject3 == null) || (((Bundle)localObject3).getString("Type").compareToIgnoreCase("showAlert") != 0)) {
            continue;
          }
          localObject2 = ((Bundle)localObject3).getString("AlertTitle");
          str1 = ((Bundle)localObject3).getString("AlertText");
          str2 = ((Bundle)localObject3).getString("AlertOtherBtnText");
          localObject3 = ((Bundle)localObject3).getString("AlertCancelBtnText");
          MQPSensitiveMsgUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, (String)localObject2, str1, str2, (String)localObject3);
          continue;
        }
        break;
        if (!this.jdField_a_of_type_ComTencentImsBankcode_info$BankcodeCtrlInfo.bankcode_elems.has()) {
          continue;
        }
        Iterator localIterator = this.jdField_a_of_type_ComTencentImsBankcode_info$BankcodeCtrlInfo.bankcode_elems.get().iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label368;
        }
        localObject2 = (bankcode_info.BankcodeElem)localIterator.next();
        if (!((bankcode_info.BankcodeElem)localObject2).bankcode_attr.has()) {
          break label363;
        }
      }
      for (j = ((bankcode_info.BankcodeElem)localObject2).bankcode_attr.get();; j = 0)
      {
        if (j > i) {}
        for (;;)
        {
          i = j;
          break label298;
          bool = true;
          i = j;
          break label105;
          break;
          j = i;
        }
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(true);
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algu
 * JD-Core Version:    0.7.0.1
 */