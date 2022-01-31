import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class adlo
  implements Runnable
{
  public adlo(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "asyncUploadImageAndSendToBuddy running...");
    }
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.a.k) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null))) {
        if ((this.a.b == 65520L) || (this.a.b())) {
          break label107;
        }
      }
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "asyncUploadImageAndSendToBuddy sleeping...");
        }
        Thread.sleep(1000L);
        if (QLog.isDevelopLevel()) {
          QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "asyncUploadImageAndSendToBuddy awake.");
        }
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        label107:
        Object localObject1;
        Object localObject2;
        String str1;
        String str2;
        String str3;
        Object localObject3;
        long l;
        return;
      }
    }
    if ((!this.a.k) || (TextUtils.isEmpty(this.a.i)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkBaseOption", 2, "-->asyncUploadImageAndSendToBuddy--skey not ready");
      }
      this.a.x();
      this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adlp(this));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      localObject1 = this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      localObject2 = Share.a(this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
      if ((((GetAppInfoProto.AndroidInfo)localObject1).sourceUrl != null) && (this.a.b != Long.parseLong("1103584836"))) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", ((GetAppInfoProto.AndroidInfo)localObject1).sourceUrl.get());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)localObject2);
      }
      if (((GetAppInfoProto.AndroidInfo)localObject1).messagetail != null) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", ((GetAppInfoProto.AndroidInfo)localObject1).messagetail.get());
      }
      if (((GetAppInfoProto.AndroidInfo)localObject1).packName != null) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", ((GetAppInfoProto.AndroidInfo)localObject1).packName.get());
      }
    }
    str1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
    str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
    localObject3 = new HashMap();
    if ((!TextUtils.isEmpty(str2)) && (str2.length() > 150)) {
      ((HashMap)localObject3).put("targetUrl", str2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((HashMap)localObject3).put("sourceUrl", localObject2);
    }
    if (!TextUtils.isEmpty(str3)) {
      ((HashMap)localObject3).put("sourceIcon", str3);
    }
    localObject2 = new ImageInfo();
    ((ImageInfo)localObject2).h = str1;
    ((ImageInfo)localObject2).c = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
    localObject2 = StructMsgForImageShare.scaleLocalImage(this.a.jdField_a_of_type_AndroidAppActivity, (ImageInfo)localObject2, (String)localObject1, this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    if (localObject2 == null)
    {
      localObject2 = new CompressInfo((String)localObject1, 0);
      CompressOperator.b((CompressInfo)localObject2);
      if (((CompressInfo)localObject2).jdField_e_of_type_JavaLangString != null)
      {
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("struct_share_key_thumb_height", ((CompressInfo)localObject2).jdField_e_of_type_Int);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("struct_share_key_thumb_width", ((CompressInfo)localObject2).d);
      }
      this.a.jdField_a_of_type_AndroidOsBundle.putString("image_url", (String)localObject1);
      this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url_remote");
      this.a.jdField_a_of_type_AndroidOsBundle.remove("title");
      this.a.jdField_a_of_type_AndroidOsBundle.remove("desc");
      this.a.jdField_a_of_type_AndroidOsBundle.remove("detail_url");
      l = System.currentTimeMillis();
      localObject1 = new Bundle();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "52");
      ((Bundle)localObject2).putString("intext_3", "0");
      ((Bundle)localObject2).putString("stringext_1", str2);
      ReportCenter.a().a((Bundle)localObject2, "", str1, false);
      localObject2 = HttpUtil.a(BaseApplication.getContext(), str1, this.a.i, 1, (HashMap)localObject3, (Bundle)localObject1);
      l = System.currentTimeMillis() - l;
      if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0) || (!((String)((HashMap)localObject2).get(((HashMap)localObject2).keySet().iterator().next())).contains("url.cn"))) {
        break label1272;
      }
    }
    label1258:
    label1272:
    for (i = 0;; i = 1)
    {
      if (QLog.isColorLevel())
      {
        localObject3 = "batchUrlExchange for IMAGE_SHARE, isFailed = " + i + ", cost = " + l;
        if ((i != 1) && (l <= 3000L)) {
          break label1258;
        }
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject3);
      }
      for (;;)
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("report_type", "102");
        ((Bundle)localObject3).putString("act_type", "12");
        ((Bundle)localObject3).putString("intext_3", "0");
        ((Bundle)localObject3).putString("intext_1", "" + i);
        ((Bundle)localObject3).putString("intext_2", "" + ((Bundle)localObject1).getInt("retcode", 0));
        ((Bundle)localObject3).putString("intext_5", "" + l);
        if (i == 1) {
          ((Bundle)localObject3).putString("stringext_1", str2);
        }
        ReportCenter.a().a((Bundle)localObject3, "", str1, false);
        if (localObject2 != null)
        {
          if (((HashMap)localObject2).containsKey("imageUrl"))
          {
            this.a.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)((HashMap)localObject2).get("imageUrl"));
            this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url");
          }
          if (((HashMap)localObject2).containsKey("audioUrl")) {
            this.a.jdField_a_of_type_AndroidOsBundle.putString("audio_url", (String)((HashMap)localObject2).get("audioUrl"));
          }
          if (((HashMap)localObject2).containsKey("targetUrl")) {
            this.a.jdField_a_of_type_AndroidOsBundle.putString("detail_url", (String)((HashMap)localObject2).get("targetUrl"));
          }
          if (((HashMap)localObject2).containsKey("sourceUrl")) {
            this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", (String)((HashMap)localObject2).get("sourceUrl"));
          }
          if (((HashMap)localObject2).containsKey("sourceIcon")) {
            this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)((HashMap)localObject2).get("sourceIcon"));
          }
        }
        this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new adlq(this));
        return;
        localObject1 = localObject2;
        break;
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlo
 * JD-Core Version:    0.7.0.1
 */