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

public class aabw
  extends aabp
{
  protected asiu a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public aabw(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(aabv paramaabv)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramaabv.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramaabv.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramaabv.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(aabv paramaabv, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramaabv.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramaabv.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public asiu a()
  {
    return this.jdField_a_of_type_Asiu;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, aabn> a()
  {
    return aady.a();
  }
  
  protected void a(aabn paramaabn, JSONObject paramJSONObject, aabm paramaabm)
  {
    aabv localaabv;
    Object localObject2;
    Object localObject1;
    switch (paramaabn.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramaabn.b);
      a(6, paramaabn, paramJSONObject, paramaabm);
      return;
    case 0: 
      a(0, paramaabn, paramJSONObject, paramaabm);
      return;
    case 1: 
      localaabv = aacb.a().a(paramaabn.jdField_a_of_type_JavaLangString);
      if (localaabv == null)
      {
        a(1, paramaabn, paramJSONObject, paramaabm);
        return;
      }
      int i = a(localaabv);
      if (i == 1)
      {
        a(4, paramaabn, paramJSONObject, paramaabm);
        return;
      }
      if (i == 2)
      {
        a(0, paramaabn, paramJSONObject, paramaabm);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131694924);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((asiu)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131694923, new Object[] { localObject1 }), localaabv.b, BaseApplicationImpl.getApplication().getResources().getString(2131720885), new aaby(this, localaabv, paramaabn, paramJSONObject, paramaabm), BaseApplicationImpl.getApplication().getResources().getString(2131720888), new aabz(this, localaabv, paramaabn, paramJSONObject, paramaabm), new aaca(this, localaabv, paramaabn, paramJSONObject, paramaabm));
        return;
        localObject1 = ((asiu)localObject2).b;
        break;
      }
      localObject1 = (aacw)a(aacw.class, false);
      if ((localObject1 != null) && (((aacw)localObject1).a()))
      {
        a(0, paramaabn, paramJSONObject, paramaabm);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramaabn, paramJSONObject, paramaabm);
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
    aacb.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new aabx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabw
 * JD-Core Version:    0.7.0.1
 */