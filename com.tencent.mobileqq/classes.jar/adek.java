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

public class adek
  extends aded
{
  protected awlp a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public adek(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(adej paramadej)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramadej.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramadej.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramadej.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(adej paramadej, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramadej.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramadej.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public awlp a()
  {
    return this.jdField_a_of_type_Awlp;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, adeb> a()
  {
    return adgm.a();
  }
  
  protected void a(adeb paramadeb, JSONObject paramJSONObject, adea paramadea)
  {
    adej localadej;
    Object localObject2;
    Object localObject1;
    switch (paramadeb.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramadeb.b);
      a(6, paramadeb, paramJSONObject, paramadea);
      return;
    case 0: 
      a(0, paramadeb, paramJSONObject, paramadea);
      return;
    case 1: 
      localadej = adep.a().a(paramadeb.jdField_a_of_type_JavaLangString);
      if (localadej == null)
      {
        a(1, paramadeb, paramJSONObject, paramadea);
        return;
      }
      int i = a(localadej);
      if (i == 1)
      {
        a(4, paramadeb, paramJSONObject, paramadea);
        return;
      }
      if (i == 2)
      {
        a(0, paramadeb, paramJSONObject, paramadea);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131694155);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((awlp)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131694154, new Object[] { localObject1 }), localadej.b, BaseApplicationImpl.getApplication().getResources().getString(2131719153), new adem(this, localadej, paramadeb, paramJSONObject, paramadea), BaseApplicationImpl.getApplication().getResources().getString(2131719163), new aden(this, localadej, paramadeb, paramJSONObject, paramadea), new adeo(this, localadej, paramadeb, paramJSONObject, paramadea));
        return;
        localObject1 = ((awlp)localObject2).b;
        break;
      }
      localObject1 = (adfk)a(adfk.class, false);
      if ((localObject1 != null) && (((adfk)localObject1).a()))
      {
        a(0, paramadeb, paramJSONObject, paramadea);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramadeb, paramJSONObject, paramadea);
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
    adep.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new adel(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adek
 * JD-Core Version:    0.7.0.1
 */