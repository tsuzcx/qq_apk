import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class adbk
  implements BusinessObserver
{
  public adbk(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    for (;;)
    {
      synchronized (ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject)
      {
        this.a.j = false;
        if (paramBoolean) {}
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            localObject1 = new GetAppInfoProto.GetAppinfoResponse();
            ((GetAppInfoProto.GetAppinfoResponse)localObject1).mergeFrom(paramBundle);
            this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse = ((GetAppInfoProto.GetAppinfoResponse)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "get appinfo time = " + (System.currentTimeMillis() - this.a.c));
            }
            if ((this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
            {
              paramBundle = this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
              localObject1 = Share.a(this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)localObject1);
              }
              localObject1 = Share.a(this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 100);
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon_big", (String)localObject1);
              }
              if ((paramBundle.sourceUrl.has()) && (this.a.b != Long.parseLong("1103584836"))) {
                this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", paramBundle.sourceUrl.get());
              }
              if (paramBundle.messagetail.has()) {
                this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", paramBundle.messagetail.get());
              }
              if (paramBundle.packName.has()) {
                this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", paramBundle.packName.get());
              }
              if (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
              {
                this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceIcon = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
                this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
                if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName)) {
                  this.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.a.jdField_a_of_type_AndroidOsBundle.getString("app_name");
                }
              }
              this.a.jdField_a_of_type_AndroidOsBundle.putByte("struct_share_key_app_info_status", (byte)1);
              ForwardSdkBaseOption.a(this.a);
            }
          }
        }
        catch (Exception paramBundle)
        {
          Object localObject1;
          QQCustomDialog localQQCustomDialog;
          StringBuilder localStringBuilder;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramBundle.getMessage());
          continue;
        }
        this.a.t();
        if ((this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.ret.get() != 0) && ((this.a instanceof ForwardSdkShareOption)))
        {
          localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("app_name");
          localQQCustomDialog = DialogUtil.b(this.a.jdField_a_of_type_AndroidAppActivity, 230).setTitle(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131435572));
          if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.msg.get()))
          {
            paramBundle = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131435573);
            localQQCustomDialog = localQQCustomDialog.setMessageWithUrl(paramBundle).setPositiveButton(2131430133, new adbm(this));
            localStringBuilder = new StringBuilder().append(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131433681));
            paramBundle = (Bundle)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramBundle = "";
            }
            paramBundle = localQQCustomDialog.setNegativeButton(paramBundle, new adbl(this));
            paramBundle.setCancelable(false);
            paramBundle.show();
          }
        }
        else
        {
          ForwardSdkBaseOption.jdField_a_of_type_JavaLangObject.notify();
          return;
        }
      }
      paramBundle = this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.msg.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adbk
 * JD-Core Version:    0.7.0.1
 */