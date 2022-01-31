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

public class aabs
  extends aabl
{
  protected asiw a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public aabs(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(aabr paramaabr)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramaabr.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramaabr.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramaabr.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(aabr paramaabr, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramaabr.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramaabr.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public asiw a()
  {
    return this.jdField_a_of_type_Asiw;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, aabj> a()
  {
    return aadu.a();
  }
  
  protected void a(aabj paramaabj, JSONObject paramJSONObject, aabi paramaabi)
  {
    aabr localaabr;
    Object localObject2;
    Object localObject1;
    switch (paramaabj.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramaabj.b);
      a(6, paramaabj, paramJSONObject, paramaabi);
      return;
    case 0: 
      a(0, paramaabj, paramJSONObject, paramaabi);
      return;
    case 1: 
      localaabr = aabx.a().a(paramaabj.jdField_a_of_type_JavaLangString);
      if (localaabr == null)
      {
        a(1, paramaabj, paramJSONObject, paramaabi);
        return;
      }
      int i = a(localaabr);
      if (i == 1)
      {
        a(4, paramaabj, paramJSONObject, paramaabi);
        return;
      }
      if (i == 2)
      {
        a(0, paramaabj, paramJSONObject, paramaabi);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131694925);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((asiw)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131694924, new Object[] { localObject1 }), localaabr.b, BaseApplicationImpl.getApplication().getResources().getString(2131720896), new aabu(this, localaabr, paramaabj, paramJSONObject, paramaabi), BaseApplicationImpl.getApplication().getResources().getString(2131720899), new aabv(this, localaabr, paramaabj, paramJSONObject, paramaabi), new aabw(this, localaabr, paramaabj, paramJSONObject, paramaabi));
        return;
        localObject1 = ((asiw)localObject2).b;
        break;
      }
      localObject1 = (aacs)a(aacs.class, false);
      if ((localObject1 != null) && (((aacs)localObject1).a()))
      {
        a(0, paramaabj, paramJSONObject, paramaabi);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramaabj, paramJSONObject, paramaabi);
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
    aabx.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new aabt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabs
 * JD-Core Version:    0.7.0.1
 */