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

public class abxe
  extends abwx
{
  protected auef a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public abxe(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(abxd paramabxd)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramabxd.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramabxd.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramabxd.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(abxd paramabxd, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramabxd.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramabxd.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public auef a()
  {
    return this.jdField_a_of_type_Auef;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, abwv> a()
  {
    return abzg.a();
  }
  
  protected void a(abwv paramabwv, JSONObject paramJSONObject, abwu paramabwu)
  {
    abxd localabxd;
    Object localObject2;
    Object localObject1;
    switch (paramabwv.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramabwv.b);
      a(6, paramabwv, paramJSONObject, paramabwu);
      return;
    case 0: 
      a(0, paramabwv, paramJSONObject, paramabwu);
      return;
    case 1: 
      localabxd = abxj.a().a(paramabwv.jdField_a_of_type_JavaLangString);
      if (localabxd == null)
      {
        a(1, paramabwv, paramJSONObject, paramabwu);
        return;
      }
      int i = a(localabxd);
      if (i == 1)
      {
        a(4, paramabwv, paramJSONObject, paramabwu);
        return;
      }
      if (i == 2)
      {
        a(0, paramabwv, paramJSONObject, paramabwu);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131695084);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((auef)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131695083, new Object[] { localObject1 }), localabxd.b, BaseApplicationImpl.getApplication().getResources().getString(2131721454), new abxg(this, localabxd, paramabwv, paramJSONObject, paramabwu), BaseApplicationImpl.getApplication().getResources().getString(2131721463), new abxh(this, localabxd, paramabwv, paramJSONObject, paramabwu), new abxi(this, localabxd, paramabwv, paramJSONObject, paramabwu));
        return;
        localObject1 = ((auef)localObject2).b;
        break;
      }
      localObject1 = (abye)a(abye.class, false);
      if ((localObject1 != null) && (((abye)localObject1).a()))
      {
        a(0, paramabwv, paramJSONObject, paramabwu);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramabwv, paramJSONObject, paramabwu);
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
    abxj.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new abxf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxe
 * JD-Core Version:    0.7.0.1
 */