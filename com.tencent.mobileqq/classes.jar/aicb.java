import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class aicb
  implements BusinessObserver
{
  public aicb(AppLaucherHelper paramAppLaucherHelper, long paramLong, String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AppLaucherHelper", 2, "t=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 2, "onReceive");
    }
    new Bundle();
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    if (paramBoolean)
    {
      Object localObject2 = paramBundle.getByteArray("data");
      try
      {
        paramBundle = new FastAuthorize.AuthorizeResponse();
        paramBundle.mergeFrom((byte[])localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ret=").append(paramBundle.ret.get()).append(", ");
          ((StringBuilder)localObject2).append("msg=").append(paramBundle.msg.get()).append(", ");
          ((StringBuilder)localObject2).append("access_token=").append(paramBundle.access_token.get()).append(", ");
          ((StringBuilder)localObject2).append("expires_in=").append(paramBundle.expires_in.get()).append(", ");
          ((StringBuilder)localObject2).append("openid=").append(paramBundle.openid.get()).append(", ");
          ((StringBuilder)localObject2).append("pay_token=").append(paramBundle.pay_token.get()).append(", ");
          ((StringBuilder)localObject2).append("pf=").append(paramBundle.pf.get()).append(", ");
          ((StringBuilder)localObject2).append("pfkey=").append(paramBundle.pfkey.get()).append(", ");
          ((StringBuilder)localObject2).append("encrykey=").append(paramBundle.encrykey.get()).append(", ");
          ((StringBuilder)localObject2).append("apk_name=").append(paramBundle.apk_name.get()).append(", ");
          QLog.d("AppLaucherHelper", 2, "FastAuthorize.AuthorizeResponse=[" + ((StringBuilder)localObject2).toString() + "]");
        }
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_JavaLangString);
        if ((!paramBundle.ret.get().equals("0")) || (!paramBundle.apk_name.has())) {
          break label1163;
        }
        if (paramBundle.access_token.has())
        {
          localObject2 = paramBundle.access_token.get();
          this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$AT$", (CharSequence)localObject2);
        }
        if (paramBundle.pay_token.has())
        {
          localObject2 = paramBundle.pay_token.get();
          this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$PT$", (CharSequence)localObject2);
        }
        if (paramBundle.openid.has())
        {
          localObject2 = paramBundle.openid.get();
          this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$OPID$", (CharSequence)localObject2);
        }
        for (;;)
        {
          if (paramBundle.pfkey.has())
          {
            localObject2 = paramBundle.pfkey.get();
            this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$PF$", (CharSequence)localObject2);
          }
          if (paramBundle.encrykey.has())
          {
            localObject2 = paramBundle.encrykey.get();
            this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString.replace("$ESK$", (CharSequence)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 2, "mParams=" + this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString);
          }
          paramBundle = paramBundle.apk_name.get();
          if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.contains(this.jdField_a_of_type_JavaLangString))) {
            break;
          }
          AppLaucherHelper.jdField_a_of_type_Boolean = false;
          QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 2, "cant't start app pkg invalide");
          return;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ret=").append(paramBundle.ret.get()).append(", ");
          ((StringBuilder)localObject2).append("msg=").append(paramBundle.msg.get()).append(", ");
          ((StringBuilder)localObject2).append("access_token=").append(paramBundle.access_token.get()).append(", ");
          ((StringBuilder)localObject2).append("expires_in=").append(paramBundle.expires_in.get()).append(", ");
          ((StringBuilder)localObject2).append("openid=").append(paramBundle.openid.get()).append(", ");
          ((StringBuilder)localObject2).append("pay_token=").append(paramBundle.pay_token.get()).append(", ");
          ((StringBuilder)localObject2).append("pf=").append(paramBundle.pf.get()).append(", ");
          ((StringBuilder)localObject2).append("pfkey=").append(paramBundle.pfkey.get()).append(", ");
          ((StringBuilder)localObject2).append("encrykey=").append(paramBundle.encrykey.get()).append(", ");
          ((StringBuilder)localObject2).append("apk_name=").append(paramBundle.apk_name.get()).append(", ");
          QLog.d("AppLaucherHelper", 1, "FastAuthorize.AuthorizeResponse=[" + ((StringBuilder)localObject2).toString() + "]");
        }
        localObject1 = paramBundle;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        paramBundle = (Bundle)localObject1;
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 2, localInvalidProtocolBufferMicroException1.getMessage());
          localObject1 = paramBundle;
        }
        for (;;)
        {
          paramBundle = AppLaucherHelper.a(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
          }
          AppUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, paramBundle, this.jdField_a_of_type_Int);
          AppLaucherHelper.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_MqqAppNewIntent == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
          this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.jdField_a_of_type_MqqAppNewIntent = null;
          return;
          try
          {
            QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 4, "pkg=" + paramBundle);
            localObject1 = paramBundle;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2) {}
        }
      }
      label1163:
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqServiceGamecenterAppLaucherHelper.getClass().getSimpleName(), 4, "start without login state");
    }
    for (;;)
    {
      break;
      QLog.e("AppLaucherHelper", 1, "FastAuthorize.AuthorizeRequest failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aicb
 * JD-Core Version:    0.7.0.1
 */