import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.AppFriendsInfo;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.RspBody;

class adfm
  extends niv
{
  adfm(adfk paramadfk, adea paramadea) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(adfk.jdField_a_of_type_JavaLangString, 2, "onResult appid=" + adfk.a(this.jdField_a_of_type_Adfk).jdField_a_of_type_JavaLangString + ", openid=" + this.jdField_a_of_type_Adfk.jdField_a_of_type_Adfn.jdField_a_of_type_JavaLangString + ", openkey=" + this.jdField_a_of_type_Adfk.jdField_a_of_type_Adfn.b + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      adhh.a(this.jdField_a_of_type_Adea, paramInt, "getappfriends result error, try again");
      return;
    }
    paramBundle = new Oidb_0xb6e.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramBundle;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      JSONArray localJSONArray;
      for (;;)
      {
        paramArrayOfByte = null;
        paramBundle.printStackTrace();
      }
      try
      {
        paramBundle.put("appfriends", localJSONArray);
        adhh.a(this.jdField_a_of_type_Adea, paramBundle);
        return;
      }
      catch (JSONException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(adfk.jdField_a_of_type_JavaLangString, 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
          }
        }
      }
      adhh.a(this.jdField_a_of_type_Adea, -1, "parse result error, try again");
    }
    if (paramArrayOfByte != null)
    {
      paramBundle = new JSONObject();
      localJSONArray = new JSONArray();
      paramArrayOfByte = paramArrayOfByte.rpt_friends_info.get().iterator();
      while (paramArrayOfByte.hasNext())
      {
        Object localObject = (Oidb_0xb6e.AppFriendsInfo)paramArrayOfByte.next();
        String str1 = ((Oidb_0xb6e.AppFriendsInfo)localObject).openid.get();
        String str2 = ((Oidb_0xb6e.AppFriendsInfo)localObject).nick.get().toStringUtf8();
        localObject = ((Oidb_0xb6e.AppFriendsInfo)localObject).figure_url_qq.get();
        if (!TextUtils.isEmpty(str1))
        {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("openid", str1.toUpperCase());
            localJSONObject.put("nickName", str2);
            localJSONObject.put("avatarUrl", localObject);
            localJSONArray.put(localJSONObject);
          }
          catch (JSONException localJSONException) {}
          if (QLog.isColorLevel()) {
            QLog.e(adfk.jdField_a_of_type_JavaLangString, 2, localJSONException.getMessage(), localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfm
 * JD-Core Version:    0.7.0.1
 */