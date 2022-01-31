import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody;

public class aacs
  extends aabm
{
  public static final String a;
  protected aacv a;
  protected aacw a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + aacs.class.getSimpleName();
  }
  
  public static Bundle a()
  {
    Object localObject1 = tsr.a();
    Object localObject2 = (ajxl)((QQAppInterface)localObject1).getManager(51);
    Object localObject3 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    localObject2 = ((ajxl)localObject2).b((String)localObject3);
    String str1;
    int i;
    if (localObject2 != null)
    {
      str1 = ((Card)localObject2).strNick;
      if (((Card)localObject2).shGender == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      String str2 = ((Card)localObject2).strCity;
      String str3 = ((Card)localObject2).strProvince;
      String str4 = ((Card)localObject2).strCountry;
      localObject2 = "";
      localObject3 = ((QQAppInterface)localObject1).c((String)localObject3);
      if ((localObject3 != null) && (!TextUtils.isEmpty(((Setting)localObject3).url))) {
        localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)((QQAppInterface)localObject1).a(1)).a().a(((Setting)localObject3).url, ((Setting)localObject3).bFaceFlags, ((Setting)localObject3).bUsrType, 0));
      }
      for (;;)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("nickName", str1);
        ((Bundle)localObject2).putInt("gender", i);
        ((Bundle)localObject2).putString("avatarUrl", (String)localObject1);
        ((Bundle)localObject2).putString("city", str2);
        ((Bundle)localObject2).putString("province", str3);
        ((Bundle)localObject2).putString("country", str4);
        if (QLog.isDevelopLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString + ".getUserInfoDirectly", 2, ((Bundle)localObject2).toString());
        }
        return localObject2;
        if (((Card)localObject2).shGender != 1) {
          break label271;
        }
        i = 2;
        break;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString + ".getUserInfoDirectly", 2, "getUserInfo QQHeadSetting is empty");
          localObject1 = localObject2;
        }
      }
      return null;
      label271:
      i = 0;
    }
  }
  
  private void a(JSONObject paramJSONObject, aabi paramaabi)
  {
    if (aaep.a())
    {
      paramJSONObject = a();
      if (paramJSONObject != null)
      {
        aaep.a(paramaabi, aabk.a(paramJSONObject));
        return;
      }
      aaep.a(paramaabi, 1, "get user info error, try again");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestUserInfo", 2, "not main process, send to main process");
    }
    aabo.a(1, null, new aact(this, paramaabi));
  }
  
  private void b(JSONObject paramJSONObject, aabi paramaabi)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestAppFriends", 2, "url params = " + paramJSONObject);
    }
    paramJSONObject = new Oidb_0xb6e.ReqBody();
    paramJSONObject.appid.set(Integer.valueOf(this.jdField_a_of_type_Aabl.jdField_a_of_type_JavaLangString).intValue());
    paramJSONObject.openid.set(this.jdField_a_of_type_Aacv.jdField_a_of_type_JavaLangString);
    paramJSONObject.openkey.set(this.jdField_a_of_type_Aacv.b);
    paramJSONObject.platform.set("openmobile_android");
    mxf.a(BaseApplicationImpl.getApplication().getRuntime(), new aacu(this, paramaabi), paramJSONObject.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  public aacv a()
  {
    return this.jdField_a_of_type_Aacv;
  }
  
  protected void a(aacv paramaacv)
  {
    this.jdField_a_of_type_Aacv = paramaacv;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Aacv != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aacv.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aacv.b));
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabi paramaabi)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    case 17: 
    case 18: 
      do
      {
        do
        {
          return bool;
          if ((!a()) || (aaek.a)) {
            break;
          }
          aaep.a(paramaabi, this.jdField_a_of_type_Aacv.a());
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Aacv.toString());
        return true;
        if (this.jdField_a_of_type_Aacw == null) {
          this.jdField_a_of_type_Aacw = new aacw(this.jdField_a_of_type_Aabl, this);
        }
        this.jdField_a_of_type_Aacw.a(paramJSONObject, paramaabi, false);
        return true;
        if (!a()) {
          break;
        }
        aaep.a(paramaabi, this.jdField_a_of_type_Aacv.a());
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Aacv.toString());
      return true;
      if (this.jdField_a_of_type_Aacw == null) {
        this.jdField_a_of_type_Aacw = new aacw(this.jdField_a_of_type_Aabl, this);
      }
      this.jdField_a_of_type_Aacw.a(paramJSONObject, paramaabi, true);
      return true;
    case 10: 
      if (!a())
      {
        aaep.a(paramaabi, 5);
        return true;
      }
      a(paramJSONObject, paramaabi);
      return true;
    }
    if (!a())
    {
      aaep.a(paramaabi, 5);
      return true;
    }
    b(paramJSONObject, paramaabi);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aacv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacs
 * JD-Core Version:    0.7.0.1
 */