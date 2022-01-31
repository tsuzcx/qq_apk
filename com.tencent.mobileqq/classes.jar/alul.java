import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ark.ark.Application;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class alul
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private String jdField_c_of_type_JavaLangString;
  private ConcurrentHashMap<String, String> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private String jdField_d_of_type_JavaLangString;
  private ConcurrentHashMap<String, String> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private String e;
  
  public alul()
  {
    this.mPluginNameSpace = "lightapp";
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ArkPlugin", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
    }
    for (;;)
    {
      return;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Object localObject2;
      Object localObject3;
      try
      {
        paramString = new JSONObject(paramString);
        localObject1 = paramString.optJSONObject("web-view-jump-web-config");
        paramString = paramString.optJSONObject("web-view-open-app-config");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            Object localObject4 = ((JSONObject)localObject1).get((String)localObject3);
            if (((localObject4 instanceof String)) && (localObject4 != null)) {
              this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject3, (String)localObject4);
            }
          }
        }
        if (paramString == null) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkPlugin", 1, String.format("decodeArkH5Config, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
        return;
      }
      Object localObject1 = paramString.keys();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = paramString.get((String)localObject2);
        if (((localObject3 instanceof String)) && (localObject3 != null)) {
          this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, (String)localObject3);
        }
      }
    }
  }
  
  Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      try
      {
        ArkAppCenter.b(true);
        Object localObject = this.mRuntime.a();
        if (localObject == null) {
          continue;
        }
        localObject = ((WebViewFragment)localObject).getArguments();
        if (localObject == null) {
          continue;
        }
        localObject = ((Intent)((Bundle)localObject).getParcelable("intent")).getExtras();
        if (localObject == null) {
          continue;
        }
        this.e = ((Bundle)localObject).getString("h5_ark_app_name");
        this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("h5_ark_app_path");
        this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("h5_ark_app_des");
        b(((Bundle)localObject).getString("h5_ark_check_config"));
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ArkPlugin", 1, String.format("setupArkEnvironment error, err=%s", new Object[] { localException.getMessage() }));
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    TextView localTextView1;
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(BaseActivity.sTopActivity, 2131755791);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558906);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365150);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365146);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365135);
      TextView localTextView4 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365141);
      localTextView1.setText(2131720260);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView2.setText(paramString);
      }
      localTextView4.setText(2131720896);
      localTextView4.setOnClickListener(new alum(this));
      localTextView3.setOnClickListener(new alun(this));
      localTextView3.setText(2131690596);
    }
    do
    {
      return;
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365146);
    } while (TextUtils.isEmpty(paramString));
    localTextView1.setText(paramString);
  }
  
  protected boolean a(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return true;
        localObject1 = a(paramString);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(this.jdField_b_of_type_JavaLangString))
      {
        localObject1 = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_b_of_type_JavaLangString);
        if (localObject1 != null)
        {
          if (((Integer)localObject1).intValue() == 1) {
            return false;
          }
          if (((Integer)localObject1).intValue() == 0)
          {
            b();
            return true;
          }
        }
      }
      a();
      localObject1 = null;
      localObject2 = this.mRuntime.a();
      if (localObject2 != null) {
        localObject1 = ((WebViewFragment)localObject2).d();
      }
      localObject1 = a((String)localObject1);
      if (a(this.jdField_b_of_type_JavaLangString, (String)localObject1))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(1));
        return false;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
    } while ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()));
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      for (localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator(); ((Iterator)localObject1).hasNext(); localObject1 = (String)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2))
      {
        label207:
        localObject2 = (String)((Iterator)localObject1).next();
        if ((TextUtils.isEmpty(this.e)) || (!((String)localObject2).equals(this.e))) {
          break label207;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      boolean bool;
      if (((String)localObject1).equals("allow")) {
        bool = false;
      }
      for (;;)
      {
        label281:
        paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject1 = this.jdField_b_of_type_JavaLangString;
        if (bool) {}
        for (i = j;; i = 1)
        {
          paramString.put(localObject1, Integer.valueOf(i));
          return bool;
          if (((String)localObject1).equals("ask"))
          {
            if ((i == 0) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
            {
              localObject1 = ark.Application.Create(this.e, this.jdField_c_of_type_JavaLangString);
              if ((localObject1 != null) && (!TextUtils.isEmpty(paramString)))
              {
                bool = ((ark.Application)localObject1).CheckUrlLegality(paramString);
                ((ark.Application)localObject1).Release();
                if (bool)
                {
                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(1));
                  return false;
                }
              }
            }
            paramString = this.mRuntime.a();
            if ((paramString == null) || (paramString.isFinishing())) {
              break;
            }
            a(paramString.getString(2131690234));
            this.jdField_a_of_type_AndroidAppDialog.show();
            return true;
          }
          if (!((String)localObject1).equals("forbidden")) {
            break label464;
          }
          b();
          bool = true;
          break label281;
        }
        label464:
        bool = false;
      }
      localObject1 = "ask";
    }
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        int i = paramString1.lastIndexOf(paramString2);
        bool1 = bool2;
        if (i >= 0)
        {
          bool1 = bool2;
          if (i == paramString1.length() - paramString2.length()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected void b()
  {
    if (this.mRuntime == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    bcql.a(localActivity, ajya.a(2131700718), 0).a();
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    boolean bool = false;
    if (paramLong == 16L) {
      bool = a(paramString);
    }
    return bool;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alul
 * JD-Core Version:    0.7.0.1
 */