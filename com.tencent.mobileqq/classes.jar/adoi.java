import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody;

public class adoi
  extends adnc
{
  public static final String a;
  protected adol a;
  protected adom a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + adoi.class.getSimpleName();
  }
  
  public static Bundle a()
  {
    Object localObject1 = xiz.a();
    Object localObject2 = (anyw)((QQAppInterface)localObject1).getManager(51);
    Object localObject3 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    localObject2 = ((anyw)localObject2).b((String)localObject3);
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
  
  private void a(JSONObject paramJSONObject, admy paramadmy)
  {
    if (adqf.a())
    {
      paramJSONObject = a();
      if (paramJSONObject != null)
      {
        adqf.a(paramadmy, adna.a(paramJSONObject));
        return;
      }
      adqf.a(paramadmy, 1, "get user info error, try again");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestUserInfo", 2, "not main process, send to main process");
    }
    adne.a(1, null, new adoj(this, paramadmy));
  }
  
  private void b(JSONObject paramJSONObject, admy paramadmy)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestAppFriends", 2, "url params = " + paramJSONObject);
    }
    paramJSONObject = new Oidb_0xb6e.ReqBody();
    paramJSONObject.appid.set(Integer.valueOf(this.jdField_a_of_type_Adnb.jdField_a_of_type_JavaLangString).intValue());
    paramJSONObject.openid.set(this.jdField_a_of_type_Adol.jdField_a_of_type_JavaLangString);
    paramJSONObject.openkey.set(this.jdField_a_of_type_Adol.b);
    paramJSONObject.platform.set("openmobile_android");
    nkm.a(BaseApplicationImpl.getApplication().getRuntime(), new adok(this, paramadmy), paramJSONObject.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  public adol a()
  {
    return this.jdField_a_of_type_Adol;
  }
  
  protected void a(adol paramadol)
  {
    this.jdField_a_of_type_Adol = paramadol;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Adol != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Adol.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Adol.b));
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull admy paramadmy)
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
          if ((!a()) || (adqa.a)) {
            break;
          }
          adqf.a(paramadmy, this.jdField_a_of_type_Adol.a());
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Adol.toString());
        return true;
        if (this.jdField_a_of_type_Adom == null) {
          this.jdField_a_of_type_Adom = new adom(this.jdField_a_of_type_Adnb, this);
        }
        this.jdField_a_of_type_Adom.a(paramJSONObject, paramadmy, false);
        return true;
        if (!a()) {
          break;
        }
        adqf.a(paramadmy, this.jdField_a_of_type_Adol.a());
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Adol.toString());
      return true;
      if (this.jdField_a_of_type_Adom == null) {
        this.jdField_a_of_type_Adom = new adom(this.jdField_a_of_type_Adnb, this);
      }
      this.jdField_a_of_type_Adom.a(paramJSONObject, paramadmy, true);
      return true;
    case 10: 
      if (!a())
      {
        adqf.a(paramadmy, 5);
        return true;
      }
      a(paramJSONObject, paramadmy);
      return true;
    }
    if (!a())
    {
      adqf.a(paramadmy, 5);
      return true;
    }
    b(paramJSONObject, paramadmy);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Adol = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adoi
 * JD-Core Version:    0.7.0.1
 */