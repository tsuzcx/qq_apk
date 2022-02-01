import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class adni
  extends adnb
{
  protected axeh a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public adni(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(adnh paramadnh)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramadnh.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramadnh.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramadnh.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(adnh paramadnh, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramadnh.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramadnh.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public axeh a()
  {
    return this.jdField_a_of_type_Axeh;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, admz> a()
  {
    return adpk.a();
  }
  
  protected void a(admz paramadmz, JSONObject paramJSONObject, admy paramadmy)
  {
    adnh localadnh;
    Object localObject2;
    Object localObject1;
    switch (paramadmz.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramadmz.b);
      a(6, paramadmz, paramJSONObject, paramadmy);
      return;
    case 0: 
      a(0, paramadmz, paramJSONObject, paramadmy);
      return;
    case 1: 
      localadnh = adnn.a().a(paramadmz.jdField_a_of_type_JavaLangString);
      if (localadnh == null)
      {
        a(1, paramadmz, paramJSONObject, paramadmy);
        return;
      }
      int i = a(localadnh);
      if (i == 1)
      {
        a(4, paramadmz, paramJSONObject, paramadmy);
        return;
      }
      if (i == 2)
      {
        a(0, paramadmz, paramJSONObject, paramadmy);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131694173);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((axeh)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131694172, new Object[] { localObject1 }), localadnh.b, BaseApplicationImpl.getApplication().getResources().getString(2131719323), new adnk(this, localadnh, paramadmz, paramJSONObject, paramadmy), BaseApplicationImpl.getApplication().getResources().getString(2131719333), new adnl(this, localadnh, paramadmz, paramJSONObject, paramadmy), new adnm(this, localadnh, paramadmz, paramJSONObject, paramadmy));
        return;
        localObject1 = ((axeh)localObject2).b;
        break;
      }
      localObject1 = (adoi)a(adoi.class, false);
      if ((localObject1 != null) && (((adoi)localObject1).a()))
      {
        a(0, paramadmz, paramJSONObject, paramadmy);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramadmz, paramJSONObject, paramadmy);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  protected void c()
  {
    adnn.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new adnj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adni
 * JD-Core Version:    0.7.0.1
 */