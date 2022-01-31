import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

class afll
  implements View.OnClickListener
{
  afll(aflk paramaflk) {}
  
  public void onClick(View paramView)
  {
    localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)aepi.a(paramView);
    if (localMessageForDeviceSingleStruct == null) {}
    do
    {
      return;
      if ((TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaFileName)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 2) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey))) {
        localMessageForDeviceSingleStruct.strMediaFileName = (bflr.d(localMessageForDeviceSingleStruct.strMediaKey) + localMessageForDeviceSingleStruct.strMediaKey.substring(localMessageForDeviceSingleStruct.strMediaKey.lastIndexOf(".")));
      }
      localDeviceInfo = ((ztp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(localMessageForDeviceSingleStruct.senderuin));
    } while (localDeviceInfo == null);
    if (localDeviceInfo.isAdmin == 1) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("title", localMessageForDeviceSingleStruct.strTitle);
        ((JSONObject)localObject).put("digest", localMessageForDeviceSingleStruct.strDigest);
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        paramView = localMessageForDeviceSingleStruct.strMediaPath;
        ((JSONObject)localObject).put("file_path_url", paramView);
        ((JSONObject)localObject).put("thumb_path_url", localMessageForDeviceSingleStruct.strCoverPath);
        ((JSONObject)localObject).put("guide_words", localMessageForDeviceSingleStruct.strGuideWords);
        ((JSONObject)localObject).put("appear_time", localMessageForDeviceSingleStruct.nAppearTime);
        ((JSONObject)localObject).put("data_type", localMessageForDeviceSingleStruct.nDataType);
        ((JSONObject)localObject).put("face", localMessageForDeviceSingleStruct.faceRect);
        ((JSONObject)localObject).put("cover_session_id", localMessageForDeviceSingleStruct.nCoverSessionID);
        ((JSONObject)localObject).put("media_session_id", localMessageForDeviceSingleStruct.nMediaSessionID);
        if (localMessageForDeviceSingleStruct.nCoverChannelType != 1) {
          continue;
        }
        ((JSONObject)localObject).put("cover_key", localMessageForDeviceSingleStruct.strCoverKey);
      }
      catch (JSONException paramView)
      {
        long l;
        int j;
        paramView.printStackTrace();
        paramView = null;
        continue;
        ((JSONObject)localObject).put("cover_url", localMessageForDeviceSingleStruct.strCoverKey);
        continue;
        if (localMessageForDeviceSingleStruct.nMediaChannelType != 3) {
          continue;
        }
        ((JSONObject)localObject).put("media_mini", localMessageForDeviceSingleStruct.strMediaKey);
        ((JSONObject)localObject).put("fkey2", localMessageForDeviceSingleStruct.strCoverKey2);
        continue;
        ((JSONObject)localObject).put("media_url", localMessageForDeviceSingleStruct.strMediaKey);
        continue;
        Object localObject = bdib.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localMessageForDeviceSingleStruct.url);
        if ((localObject == null) || (!"openLightApp".equals(((bdhk)localObject).b)) || (!"url".equals(((bdhk)localObject).c))) {
          continue;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("param_meta_data", paramView);
        aagc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localDeviceInfo, ((bdhk)localObject).b("url_prefix"), localBundle);
        continue;
        if ((i == 0) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.faceRect)) || (!aflk.a(this.a, localMessageForDeviceSingleStruct.faceRect)) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverPath))) {
          continue;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("device_id", localDeviceInfo.din + "");
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        paramView = localMessageForDeviceSingleStruct.strMediaPath;
        ((Intent)localObject).putExtra("filepath", paramView);
        ((Intent)localObject).putExtra("rect", localMessageForDeviceSingleStruct.faceRect);
        ((Intent)localObject).putExtra("from", 0);
        bkce.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.face.FaceRegisterActivity", -1, null, SmartDevicePluginProxyActivity.class);
        continue;
        paramView = localMessageForDeviceSingleStruct.strCoverPath;
        continue;
        if ((bdhb.b(localMessageForDeviceSingleStruct.strMediaPath)) || (!bdin.b(bfbm.a().a()))) {
          continue;
        }
        paramView = this.a.jdField_a_of_type_AndroidContentContext.getString(2131692754);
        localObject = this.a.jdField_a_of_type_AndroidContentContext.getString(2131692756);
        arre.a(this.a.jdField_a_of_type_AndroidContentContext, paramView, (CharSequence)localObject, new aflm(this, localMessageForDeviceSingleStruct));
        continue;
        aflk.a(this.a, localMessageForDeviceSingleStruct);
        continue;
        i = 3;
        continue;
      }
      if (localMessageForDeviceSingleStruct.nMediaChannelType != 1) {
        continue;
      }
      ((JSONObject)localObject).put("media_key", localMessageForDeviceSingleStruct.strMediaKey);
      ((JSONObject)localObject).put("jump_url", localMessageForDeviceSingleStruct.url);
      ((JSONObject)localObject).put("msg_time", localMessageForDeviceSingleStruct.time);
      ((JSONObject)localObject).put("ext", localMessageForDeviceSingleStruct.ext);
      paramView = new JSONObject();
      paramView.put("struct_msg", localObject);
      paramView = paramView.toString();
      if (TextUtils.isEmpty(localMessageForDeviceSingleStruct.url)) {
        continue;
      }
      if ((!localMessageForDeviceSingleStruct.url.startsWith("http://")) && (!localMessageForDeviceSingleStruct.url.startsWith("https://"))) {
        continue;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", localMessageForDeviceSingleStruct.url);
      ((Intent)localObject).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject).putExtra("param_meta_data", paramView);
      bkce.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.lightapp.DeviceWebViewActivity", -1, null, SmartDevicePluginProxyActivity.class);
      if (localMessageForDeviceSingleStruct.nDataType != 2) {
        continue;
      }
      i = 4;
      l = Long.parseLong(localMessageForDeviceSingleStruct.senderuin);
      j = localDeviceInfo.productId;
      aagb.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_ReceiveMsg_Click", i, 0, j);
      return;
      i = 0;
      continue;
      paramView = localMessageForDeviceSingleStruct.strCoverPath;
      continue;
      if (localMessageForDeviceSingleStruct.nCoverChannelType != 3) {
        continue;
      }
      ((JSONObject)localObject).put("cover_mini", localMessageForDeviceSingleStruct.strCoverKey);
      ((JSONObject)localObject).put("ckey2", localMessageForDeviceSingleStruct.strCoverKey2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afll
 * JD-Core Version:    0.7.0.1
 */