import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class aeia
  implements BusinessObserver
{
  aeia(aegy paramaegy) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    int k = 1;
    paramInt = 1;
    int j;
    if (!paramBoolean)
    {
      this.a.B(2131629887);
      j = paramInt;
    }
    for (;;)
    {
      if (j != 0) {
        this.a.bn();
      }
      return;
      j = paramInt;
      if (!paramBoolean) {
        continue;
      }
      int i = k;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        j = paramInt;
        if (paramBundle == null) {
          continue;
        }
        i = k;
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        i = k;
        localFollowResponse.mergeFrom(paramBundle);
        i = k;
        j = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (j == 0)
        {
          i = k;
          ndn.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
          i = k;
          paramBundle = (ajoy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
          if (paramBundle != null)
          {
            i = k;
            paramBundle = paramBundle.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            if (paramBundle != null)
            {
              i = k;
              if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null)
              {
                i = k;
                this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
              }
              i = k;
              this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(paramBundle);
              paramInt = 1;
              break label488;
            }
          }
        }
        label488:
        for (;;)
        {
          i = paramInt;
          this.a.T = true;
          i = paramInt;
          this.a.Y = true;
          i = paramInt;
          this.a.bo();
          j = paramInt;
          i = paramInt;
          if (!this.a.an) {
            break;
          }
          j = paramInt;
          i = paramInt;
          if (aegy.a(this.a) == null) {
            break;
          }
          i = paramInt;
          aegy.b(this.a).d();
          j = paramInt;
          break;
          i = k;
          this.a.D();
          paramInt = 0;
          break label488;
          i = k;
          this.a.D();
          paramInt = 0;
          continue;
          if (j == 58)
          {
            i = k;
            this.a.B(2131629884);
            j = paramInt;
            break;
          }
          if (j == 65)
          {
            i = k;
            this.a.B(2131629857);
            j = paramInt;
            break;
          }
          i = k;
          this.a.B(2131629887);
          j = paramInt;
          break;
        }
      }
      catch (Exception paramBundle)
      {
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeia
 * JD-Core Version:    0.7.0.1
 */