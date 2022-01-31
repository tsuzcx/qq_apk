import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ims.QQProtectRisks.QQProtectRisksResponse;
import com.tencent.ims.QQProtectRisks.RiskInfo;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.RiskInfoItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ablt
  extends mxm
{
  public ablt(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 1;
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginInfoActivity.AccDevSec", 2, "request risks info,onResult error=" + paramInt + " data=" + paramArrayOfByte);
      }
      i = 0;
    }
    paramInt = i;
    if (i != 0) {}
    for (;;)
    {
      try
      {
        localObject = new QQProtectRisks.QQProtectRisksResponse();
        ((QQProtectRisks.QQProtectRisksResponse)localObject).mergeFrom(paramArrayOfByte);
        paramInt = 0;
        if (((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_sec_cmd.has()) {
          paramInt = ((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_sec_cmd.get();
        }
        if (paramInt == 1)
        {
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).str_no_risk_text.has())
          {
            paramArrayOfByte = ((QQProtectRisks.QQProtectRisksResponse)localObject).str_no_risk_text.get();
            if (!TextUtils.isEmpty(paramArrayOfByte)) {
              LoginInfoActivity.a(this.a, paramArrayOfByte);
            }
          }
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_tip_text.has())
          {
            paramArrayOfByte = ((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_tip_text.get();
            if (!TextUtils.isEmpty(paramArrayOfByte)) {
              LoginInfoActivity.b(this.a, paramArrayOfByte + "　");
            }
          }
          if ((((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.has()) && (!((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.isEmpty()))
          {
            paramInt = 0;
            if (paramInt < ((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.size())
            {
              new QQProtectRisks.RiskInfo();
              paramArrayOfByte = (QQProtectRisks.RiskInfo)((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.get(paramInt);
              if ((paramArrayOfByte.uint32_item_type.has()) && (paramArrayOfByte.uint32_item_type.get() == 1)) {
                break label906;
              }
              paramBundle = new RiskInfoItem();
              paramBundle.jdField_a_of_type_JavaLangString = paramArrayOfByte.str_left_text.get();
              paramBundle.d = paramArrayOfByte.str_jump_target.get();
              if ((TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramBundle.d))) {
                break label906;
              }
              paramBundle.jdField_b_of_type_JavaLangString = paramArrayOfByte.str_right_text.get();
              paramBundle.c = paramArrayOfByte.str_desc_text.get();
              paramBundle.jdField_a_of_type_Int = paramArrayOfByte.uint32_click_report_id.get();
              if (paramArrayOfByte.uint32_item_id.has()) {
                paramBundle.jdField_b_of_type_Int = paramArrayOfByte.uint32_item_id.get();
              }
              if (paramArrayOfByte.str_right_text_open.has()) {
                paramBundle.e = paramArrayOfByte.str_right_text_open.get();
              }
              if (!LoginInfoActivity.c(this.a)) {
                LoginInfoActivity.a(this.a).add(paramBundle);
              }
              QLog.d("LoginInfoActivity.AccDevSec", 1, String.format("%s, %s, %s, %s, %d, %d, %s", new Object[] { paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_b_of_type_JavaLangString, paramBundle.c, paramBundle.d, Integer.valueOf(paramBundle.jdField_a_of_type_Int), Integer.valueOf(paramBundle.jdField_b_of_type_Int), paramBundle.e }));
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        Object localObject;
        QLog.d("LoginInfoActivity.AccDevSec", 1, "error protobuf content");
        paramInt = 0;
        if ((LoginInfoActivity.a(this.a) != null) && (!LoginInfoActivity.a(this.a).isEmpty()))
        {
          if (TextUtils.isEmpty(LoginInfoActivity.a(this.a)))
          {
            paramArrayOfByte = ((RiskInfoItem)LoginInfoActivity.a(this.a).get(0)).jdField_a_of_type_JavaLangString;
            i = LoginInfoActivity.a(this.a).size();
            paramBundle = this.a.getString(2131717245);
            LoginInfoActivity.b(this.a, String.format(paramBundle, new Object[] { paramArrayOfByte, Integer.valueOf(i) }));
          }
          paramArrayOfByte = LoginInfoActivity.a(this.a);
          bool = false;
          if (paramInt == 0) {
            paramArrayOfByte = this.a.getString(2131717247);
          }
          LoginInfoActivity.b(this.a, bool);
          paramBundle = LoginInfoActivity.a(this.a).obtainMessage(20170211);
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("bSafe", bool);
          ((Bundle)localObject).putString("TipText", paramArrayOfByte);
          paramBundle.setData((Bundle)localObject);
          LoginInfoActivity.a(this.a).sendMessageDelayed(paramBundle, 2000L);
          return;
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_qpim_switches.has())
          {
            paramInt = ((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_qpim_switches.get();
            LoginInfoActivity.b(this.a, paramInt);
          }
          long l = 3600L;
          paramArrayOfByte = "";
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_cache_time.has()) {
            l = ((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_cache_time.get();
          }
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_exist.has()) {
            paramArrayOfByte = ((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_exist.get();
          }
          paramBundle = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte))
          {
            paramBundle = paramArrayOfByte;
            if (((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.has())
            {
              paramBundle = paramArrayOfByte;
              if (!((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.isEmpty()) {
                paramBundle = this.a.getString(2131699385);
              }
            }
          }
          LoginInfoActivity.a(this.a, l, paramBundle);
          paramInt = i;
          continue;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = i;
        continue;
        if (TextUtils.isEmpty(LoginInfoActivity.b(this.a))) {
          LoginInfoActivity.a(this.a, this.a.getString(2131717248));
        }
        paramArrayOfByte = LoginInfoActivity.b(this.a);
        boolean bool = true;
        continue;
      }
      label906:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablt
 * JD-Core Version:    0.7.0.1
 */