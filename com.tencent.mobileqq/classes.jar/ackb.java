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

public class ackb
  extends acju
{
  protected avro a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public ackb(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(acka paramacka)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramacka.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramacka.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramacka.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(acka paramacka, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramacka.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramacka.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public avro a()
  {
    return this.jdField_a_of_type_Avro;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, acjs> a()
  {
    return acmd.a();
  }
  
  protected void a(acjs paramacjs, JSONObject paramJSONObject, acjr paramacjr)
  {
    acka localacka;
    Object localObject2;
    Object localObject1;
    switch (paramacjs.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramacjs.b);
      a(6, paramacjs, paramJSONObject, paramacjr);
      return;
    case 0: 
      a(0, paramacjs, paramJSONObject, paramacjr);
      return;
    case 1: 
      localacka = ackg.a().a(paramacjs.jdField_a_of_type_JavaLangString);
      if (localacka == null)
      {
        a(1, paramacjs, paramJSONObject, paramacjr);
        return;
      }
      int i = a(localacka);
      if (i == 1)
      {
        a(4, paramacjs, paramJSONObject, paramacjr);
        return;
      }
      if (i == 2)
      {
        a(0, paramacjs, paramJSONObject, paramacjr);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131694276);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((avro)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131694275, new Object[] { localObject1 }), localacka.b, BaseApplicationImpl.getApplication().getResources().getString(2131719641), new ackd(this, localacka, paramacjs, paramJSONObject, paramacjr), BaseApplicationImpl.getApplication().getResources().getString(2131719651), new acke(this, localacka, paramacjs, paramJSONObject, paramacjr), new ackf(this, localacka, paramacjs, paramJSONObject, paramacjr));
        return;
        localObject1 = ((avro)localObject2).b;
        break;
      }
      localObject1 = (aclb)a(aclb.class, false);
      if ((localObject1 != null) && (((aclb)localObject1).a()))
      {
        a(0, paramacjs, paramJSONObject, paramacjr);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramacjs, paramJSONObject, paramacjr);
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
    ackg.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new ackc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackb
 * JD-Core Version:    0.7.0.1
 */