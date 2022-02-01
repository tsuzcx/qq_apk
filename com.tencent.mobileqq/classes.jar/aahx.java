import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.2;
import com.tencent.biz.troopgift.AIOGiftPanelContainer.2.1.1.1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class aahx
  extends bhyn
{
  aahx(aahw paramaahw, long paramLong, String paramString, int paramInt) {}
  
  public void onDone(bhyo parambhyo)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftPanel.time", 2, "onDone, time=" + (l - this.jdField_a_of_type_Long) + ", total=" + (l - this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Long));
    }
    if (parambhyo.jdField_a_of_type_Int == 0) {
      localObject = parambhyo.a().getString("filePath");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        Object localObject;
        parambhyo = new File((String)localObject);
        String str = FileUtils.readFileToString(parambhyo);
        if (QLog.isColorLevel()) {
          QLog.d("AIOGiftPanelContainer", 2, "onDone() content =  " + str + ", filePath = " + (String)localObject);
        }
        if (!TextUtils.isEmpty(str))
        {
          localObject = new aail(new JSONObject(str), this.jdField_a_of_type_JavaLangString);
          ((aail)localObject).a(this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_Aail = ((aail)localObject);
          this.jdField_a_of_type_Aahw.jdField_a_of_type_Bgko.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.jdField_a_of_type_Int);
          this.jdField_a_of_type_Aahw.jdField_a_of_type_Bgko.a(false);
          if (!this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.isFinishing()) {
            this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.jdField_a_of_type_AndroidOsHandler.post(new AIOGiftPanelContainer.2.1.1.1(this));
          }
          parambhyo.deleteOnExit();
        }
        aahv.a(this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0, true);
        this.jdField_a_of_type_Aahw.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer$2.this$0.a(0);
        return;
      }
      catch (IOException parambhyo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambhyo));
        return;
      }
      catch (JSONException parambhyo)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AIOGiftPanelContainer", 2, QLog.getStackTraceString(parambhyo));
        return;
      }
    }
    QLog.d("AIOGiftPanelContainer", 2, "onError() time =  " + (System.currentTimeMillis() - this.jdField_a_of_type_Aahw.jdField_a_of_type_Long) + ", errorCode = " + parambhyo.jdField_a_of_type_Int);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahx
 * JD-Core Version:    0.7.0.1
 */