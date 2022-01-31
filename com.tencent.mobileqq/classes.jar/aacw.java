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

public class aacw
  extends aabq
{
  public static final String a;
  protected aacz a;
  protected aada a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + aacw.class.getSimpleName();
  }
  
  public static Bundle a()
  {
    Object localObject1 = tsu.a();
    Object localObject2 = (ajxn)((QQAppInterface)localObject1).getManager(51);
    Object localObject3 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    localObject2 = ((ajxn)localObject2).b((String)localObject3);
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
  
  private void a(JSONObject paramJSONObject, aabm paramaabm)
  {
    if (aaet.a())
    {
      paramJSONObject = a();
      if (paramJSONObject != null)
      {
        aaet.a(paramaabm, aabo.a(paramJSONObject));
        return;
      }
      aaet.a(paramaabm, 1, "get user info error, try again");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestUserInfo", 2, "not main process, send to main process");
    }
    aabs.a(1, null, new aacx(this, paramaabm));
  }
  
  private void b(JSONObject paramJSONObject, aabm paramaabm)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestAppFriends", 2, "url params = " + paramJSONObject);
    }
    paramJSONObject = new Oidb_0xb6e.ReqBody();
    paramJSONObject.appid.set(Integer.valueOf(this.jdField_a_of_type_Aabp.jdField_a_of_type_JavaLangString).intValue());
    paramJSONObject.openid.set(this.jdField_a_of_type_Aacz.jdField_a_of_type_JavaLangString);
    paramJSONObject.openkey.set(this.jdField_a_of_type_Aacz.b);
    paramJSONObject.platform.set("openmobile_android");
    mxi.a(BaseApplicationImpl.getApplication().getRuntime(), new aacy(this, paramaabm), paramJSONObject.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  public aacz a()
  {
    return this.jdField_a_of_type_Aacz;
  }
  
  protected void a(aacz paramaacz)
  {
    this.jdField_a_of_type_Aacz = paramaacz;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Aacz != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aacz.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aacz.b));
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabm paramaabm)
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
          if ((!a()) || (aaeo.a)) {
            break;
          }
          aaet.a(paramaabm, this.jdField_a_of_type_Aacz.a());
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Aacz.toString());
        return true;
        if (this.jdField_a_of_type_Aada == null) {
          this.jdField_a_of_type_Aada = new aada(this.jdField_a_of_type_Aabp, this);
        }
        this.jdField_a_of_type_Aada.a(paramJSONObject, paramaabm, false);
        return true;
        if (!a()) {
          break;
        }
        aaet.a(paramaabm, this.jdField_a_of_type_Aacz.a());
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Aacz.toString());
      return true;
      if (this.jdField_a_of_type_Aada == null) {
        this.jdField_a_of_type_Aada = new aada(this.jdField_a_of_type_Aabp, this);
      }
      this.jdField_a_of_type_Aada.a(paramJSONObject, paramaabm, true);
      return true;
    case 10: 
      if (!a())
      {
        aaet.a(paramaabm, 5);
        return true;
      }
      a(paramJSONObject, paramaabm);
      return true;
    }
    if (!a())
    {
      aaet.a(paramaabm, 5);
      return true;
    }
    b(paramJSONObject, paramaabm);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aacz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacw
 * JD-Core Version:    0.7.0.1
 */