import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class afom
  implements BusinessObserver
{
  public afom(ProfileQiqiLiveController paramProfileQiqiLiveController, String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new Bundle();
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject = str;
    if (paramBoolean) {
      localObject = paramBundle.getByteArray("data");
    }
    try
    {
      paramBundle = new FastAuthorize.AuthorizeResponse();
      paramBundle.mergeFrom((byte[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
      if ((paramBundle.ret.get().equals("0")) && (paramBundle.apk_name.has()))
      {
        if (paramBundle.access_token.has())
        {
          localObject = paramBundle.access_token.get();
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString.replace("$AT$", (CharSequence)localObject);
        }
        if (paramBundle.pay_token.has())
        {
          localObject = paramBundle.pay_token.get();
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString.replace("$PT$", (CharSequence)localObject);
        }
        if (paramBundle.openid.has())
        {
          localObject = paramBundle.openid.get();
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString.replace("$OPID$", (CharSequence)localObject);
        }
        if (paramBundle.pfkey.has())
        {
          localObject = paramBundle.pfkey.get();
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString.replace("$PF$", (CharSequence)localObject);
        }
        if (paramBundle.encrykey.has())
        {
          localObject = paramBundle.encrykey.get();
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString.replace("$ESK$", (CharSequence)localObject);
        }
        localObject = paramBundle.apk_name.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        paramBundle = (Bundle)localObject;
        if (((String)localObject).contains(this.jdField_a_of_type_JavaLangString)) {}
      }
      else
      {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.getClass().getSimpleName(), 4, "start without login state");
        paramBundle = str;
      }
      localObject = paramBundle;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.getClass().getSimpleName(), 2, paramBundle.getMessage());
          localObject = str;
        }
      }
    }
    paramBundle = AppLaucherHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
    }
    AppUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramBundle, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_MqqAppNewIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.jdField_a_of_type_MqqAppNewIntent = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afom
 * JD-Core Version:    0.7.0.1
 */