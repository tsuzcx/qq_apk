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

public class adak
  extends adad
{
  protected awxt a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public adak(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(adaj paramadaj)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramadaj.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramadaj.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramadaj.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(adaj paramadaj, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramadaj.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramadaj.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public awxt a()
  {
    return this.jdField_a_of_type_Awxt;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, adab> a()
  {
    return adcm.a();
  }
  
  protected void a(adab paramadab, JSONObject paramJSONObject, adaa paramadaa)
  {
    adaj localadaj;
    Object localObject2;
    Object localObject1;
    switch (paramadab.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramadab.b);
      a(6, paramadab, paramJSONObject, paramadaa);
      return;
    case 0: 
      a(0, paramadab, paramJSONObject, paramadaa);
      return;
    case 1: 
      localadaj = adap.a().a(paramadab.jdField_a_of_type_JavaLangString);
      if (localadaj == null)
      {
        a(1, paramadab, paramJSONObject, paramadaa);
        return;
      }
      int i = a(localadaj);
      if (i == 1)
      {
        a(4, paramadab, paramJSONObject, paramadaa);
        return;
      }
      if (i == 2)
      {
        a(0, paramadab, paramJSONObject, paramadaa);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131694474);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((awxt)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131694473, new Object[] { localObject1 }), localadaj.b, BaseApplicationImpl.getApplication().getResources().getString(2131720094), new adam(this, localadaj, paramadab, paramJSONObject, paramadaa), BaseApplicationImpl.getApplication().getResources().getString(2131720104), new adan(this, localadaj, paramadab, paramJSONObject, paramadaa), new adao(this, localadaj, paramadab, paramJSONObject, paramadaa));
        return;
        localObject1 = ((awxt)localObject2).b;
        break;
      }
      localObject1 = (adbk)a(adbk.class, false);
      if ((localObject1 != null) && (((adbk)localObject1).a()))
      {
        a(0, paramadab, paramJSONObject, paramadaa);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramadab, paramJSONObject, paramadaa);
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
    adap.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new adal(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adak
 * JD-Core Version:    0.7.0.1
 */