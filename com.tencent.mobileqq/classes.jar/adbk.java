import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody;

public class adbk
  extends adae
{
  public static final String a;
  protected adbn a;
  protected adbo a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + adbk.class.getSimpleName();
  }
  
  public static Bundle a()
  {
    int i = 1;
    Object localObject1 = wzk.a();
    Object localObject2 = (anvk)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject3 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    localObject2 = ((anvk)localObject2).b((String)localObject3);
    String str1;
    if (localObject2 != null)
    {
      str1 = ((Card)localObject2).strNick;
      if (((Card)localObject2).shGender != 0) {}
    }
    for (;;)
    {
      String str2 = ((Card)localObject2).strCity;
      String str3 = ((Card)localObject2).strProvince;
      String str4 = ((Card)localObject2).strCountry;
      localObject2 = "";
      localObject3 = ((QQAppInterface)localObject1).getQQHeadSettingFromDB((String)localObject3);
      if ((localObject3 != null) && (!TextUtils.isEmpty(((Setting)localObject3).url))) {
        localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getQQHeadDownload().getQQHeandDownLoadUrl(((Setting)localObject3).url, ((Setting)localObject3).bFaceFlags, ((Setting)localObject3).bUsrType, 0));
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
          break label274;
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
      label274:
      i = 0;
    }
  }
  
  private void a(JSONObject paramJSONObject, adaa paramadaa)
  {
    if (addh.a())
    {
      paramJSONObject = a();
      if (paramJSONObject != null)
      {
        addh.a(paramadaa, adac.a(paramJSONObject));
        return;
      }
      addh.a(paramadaa, 1, "get user info error, try again");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestUserInfo", 2, "not main process, send to main process");
    }
    adag.a(1, null, new adbl(this, paramadaa));
  }
  
  private void b(JSONObject paramJSONObject, adaa paramadaa)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestAppFriends", 2, "url params = " + paramJSONObject);
    }
    paramJSONObject = new Oidb_0xb6e.ReqBody();
    paramJSONObject.appid.set(Integer.valueOf(this.jdField_a_of_type_Adad.jdField_a_of_type_JavaLangString).intValue());
    paramJSONObject.openid.set(this.jdField_a_of_type_Adbn.jdField_a_of_type_JavaLangString);
    paramJSONObject.openkey.set(this.jdField_a_of_type_Adbn.b);
    paramJSONObject.platform.set("openmobile_android");
    ntb.a(BaseApplicationImpl.getApplication().getRuntime(), new adbm(this, paramadaa), paramJSONObject.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  public adbn a()
  {
    return this.jdField_a_of_type_Adbn;
  }
  
  protected void a(adbn paramadbn)
  {
    this.jdField_a_of_type_Adbn = paramadbn;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Adbn != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Adbn.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Adbn.b));
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
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
          if ((!a()) || (addc.a)) {
            break;
          }
          addh.a(paramadaa, this.jdField_a_of_type_Adbn.a());
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Adbn.toString());
        return true;
        if (this.jdField_a_of_type_Adbo == null) {
          this.jdField_a_of_type_Adbo = new adbo(this.jdField_a_of_type_Adad, this);
        }
        this.jdField_a_of_type_Adbo.a(paramJSONObject, paramadaa, false);
        return true;
        if (!a()) {
          break;
        }
        addh.a(paramadaa, this.jdField_a_of_type_Adbn.a());
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Adbn.toString());
      return true;
      if (this.jdField_a_of_type_Adbo == null) {
        this.jdField_a_of_type_Adbo = new adbo(this.jdField_a_of_type_Adad, this);
      }
      this.jdField_a_of_type_Adbo.a(paramJSONObject, paramadaa, true);
      return true;
    case 10: 
      if (!a())
      {
        addh.a(paramadaa, 5);
        return true;
      }
      a(paramJSONObject, paramadaa);
      return true;
    }
    if (!a())
    {
      addh.a(paramadaa, 5);
      return true;
    }
    b(paramJSONObject, paramadaa);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Adbn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbk
 * JD-Core Version:    0.7.0.1
 */