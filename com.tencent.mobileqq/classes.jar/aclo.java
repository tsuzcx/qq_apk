import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aclo
  extends acjv
{
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private static HashSet<WeakReference<aclo>> jdField_a_of_type_JavaUtilHashSet;
  private static boolean jdField_a_of_type_Boolean;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<aclo> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, acjr> jdField_a_of_type_JavaUtilHashMap;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  private static void d()
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_AndroidContentBroadcastReceiver = new aclp();
  }
  
  protected String a()
  {
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_Acju.jdField_a_of_type_Int + "_" + this.jdField_a_of_type_Acju.jdField_a_of_type_JavaLangString + ".virtual_host");
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  /* Error */
  protected void a(android.content.Context paramContext, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_2
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_2
    //   11: ldc 67
    //   13: iconst_1
    //   14: invokevirtual 73	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   17: ifeq -8 -> 9
    //   20: aload_2
    //   21: ldc 75
    //   23: invokevirtual 79	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +14 -> 42
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 81	aclo:b	()Ljava/lang/String;
    //   36: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne -30 -> 9
    //   42: aload_2
    //   43: ldc 89
    //   45: invokevirtual 79	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 6
    //   50: aload 6
    //   52: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne -46 -> 9
    //   58: aload_2
    //   59: ldc 97
    //   61: invokevirtual 79	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +180 -> 246
    //   69: new 99	org/json/JSONObject
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 102	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 104
    //   81: invokevirtual 108	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   84: astore 7
    //   86: aload 7
    //   88: ifnull -79 -> 9
    //   91: aload_2
    //   92: ldc 110
    //   94: invokevirtual 79	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 8
    //   99: aload 5
    //   101: astore_2
    //   102: aload 8
    //   104: ifnull +13 -> 117
    //   107: new 99	org/json/JSONObject
    //   110: dup
    //   111: aload 8
    //   113: invokespecial 102	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   116: astore_2
    //   117: aload_0
    //   118: invokevirtual 112	aclo:a	()Ljava/lang/String;
    //   121: astore 8
    //   123: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +63 -> 189
    //   129: aload_0
    //   130: invokevirtual 121	java/lang/Object:toString	()Ljava/lang/String;
    //   133: astore 9
    //   135: aload_1
    //   136: ifnull +92 -> 228
    //   139: aload_1
    //   140: invokevirtual 122	org/json/JSONObject:toString	()Ljava/lang/String;
    //   143: astore 5
    //   145: ldc 124
    //   147: iconst_2
    //   148: ldc 126
    //   150: iconst_5
    //   151: anewarray 120	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 9
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: aload 6
    //   163: aastore
    //   164: dup
    //   165: iconst_2
    //   166: aload 5
    //   168: aastore
    //   169: dup
    //   170: iconst_3
    //   171: ldc 128
    //   173: aload 7
    //   175: invokestatic 132	android/text/TextUtils:join	(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: iconst_4
    //   181: aload_2
    //   182: aastore
    //   183: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 7
    //   191: invokevirtual 145	java/util/ArrayList:size	()I
    //   194: istore 4
    //   196: iload_3
    //   197: iload 4
    //   199: if_icmpge -190 -> 9
    //   202: aload 7
    //   204: iload_3
    //   205: invokevirtual 149	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   208: checkcast 83	java/lang/String
    //   211: aload 8
    //   213: invokestatic 154	nko:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   216: ifeq +19 -> 235
    //   219: aload_0
    //   220: aload 6
    //   222: aload_1
    //   223: aload_2
    //   224: invokevirtual 157	aclo:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   227: return
    //   228: ldc 159
    //   230: astore 5
    //   232: goto -87 -> 145
    //   235: iload_3
    //   236: iconst_1
    //   237: iadd
    //   238: istore_3
    //   239: goto -43 -> 196
    //   242: astore_1
    //   243: return
    //   244: astore_1
    //   245: return
    //   246: aconst_null
    //   247: astore_1
    //   248: goto -170 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	aclo
    //   0	251	1	paramContext	android.content.Context
    //   0	251	2	paramIntent	Intent
    //   4	235	3	i	int
    //   194	6	4	j	int
    //   1	230	5	str1	String
    //   48	173	6	str2	String
    //   84	119	7	localArrayList	ArrayList
    //   97	115	8	str3	String
    //   133	24	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   107	117	242	org/json/JSONException
    //   69	78	244	org/json/JSONException
  }
  
  protected void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    acjr localacjr;
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      localacjr = null;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      if (localacjr != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("event", paramString);
        localJSONObject.put("data", paramJSONObject1);
        localJSONObject.put("source", paramJSONObject2);
        acmy.b(localacjr, localJSONObject);
        return;
        localacjr = (acjr)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.e("DoraemonOpenAPI.event", 1, paramString.getMessage(), paramString);
        }
      }
    }
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull acjr paramacjr)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramString = paramJSONObject.optString("event", "");
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
        }
        acmy.a(paramacjr, -1, "event name is required");
      }
      break;
    }
    String str1;
    label239:
    JSONObject localJSONObject;
    for (;;)
    {
      return true;
      c();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramacjr);
      acmy.a(paramacjr, acjt.a);
      continue;
      paramString = paramJSONObject.optString("event", "");
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
        }
        acmy.a(paramacjr, -1, "event name is required");
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        }
        acmy.a(paramacjr, acjt.a);
        continue;
        try
        {
          str1 = paramJSONObject.optString("event");
          if (!TextUtils.isEmpty(str1)) {
            break label239;
          }
          if (QLog.isColorLevel()) {
            QLog.w("DoraemonOpenAPI.event", 2, "event name is required");
          }
          acmy.a(paramacjr, -1, "event name is required");
        }
        catch (Throwable paramString)
        {
          QLog.e("DoraemonOpenAPI.event", 1, paramString.getMessage(), paramString);
          acmy.a(paramacjr, -3, paramString.getMessage());
        }
        continue;
        localJSONObject = paramJSONObject.optJSONObject("data");
        if (localJSONObject == null) {
          break label663;
        }
        paramString = localJSONObject.toString();
        label258:
        if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 460800L)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("DoraemonOpenAPI.event", 2, "param data is over size");
        }
        acmy.a(paramacjr, -2, "param data is over size");
      }
    }
    paramString = paramJSONObject.optJSONObject("options");
    int j = 1;
    boolean bool1 = true;
    paramJSONObject = new ArrayList();
    boolean bool2;
    boolean bool3;
    int i;
    if (paramString != null)
    {
      bool2 = paramString.optBoolean("echo", true);
      bool3 = paramString.optBoolean("broadcast", true);
      paramString = paramString.optJSONArray("domains");
      bool1 = bool3;
      j = bool2;
      if (paramString != null)
      {
        paramInt = 0;
        i = paramString.length();
      }
    }
    for (;;)
    {
      bool1 = bool3;
      j = bool2;
      Object localObject;
      if (paramInt < i)
      {
        localObject = paramString.optString(paramInt);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.add(localObject);
        }
      }
      else
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("appid", this.jdField_a_of_type_Acju.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject).put("appType", this.jdField_a_of_type_Acju.jdField_a_of_type_Int);
        if (paramJSONObject.size() == 0) {
          paramJSONObject.add(a());
        }
        Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        localIntent.putExtra("broadcast", bool1);
        localIntent.putExtra("unique", b());
        localIntent.putExtra("event", str1);
        if (localJSONObject != null) {
          localIntent.putExtra("data", localJSONObject.toString());
        }
        localIntent.putStringArrayListExtra("domains", paramJSONObject);
        localIntent.putExtra("source", ((JSONObject)localObject).toString());
        String str2;
        if (QLog.isColorLevel())
        {
          str2 = toString();
          if (localJSONObject == null) {
            break label657;
          }
        }
        label657:
        for (paramString = localJSONObject.toString();; paramString = "NULL")
        {
          QLog.d("DoraemonOpenAPI.event", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", new Object[] { str2, str1, paramString, TextUtils.join(",", paramJSONObject), localObject }));
          BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
          if (j != 0) {
            a(str1, localJSONObject, (JSONObject)localObject);
          }
          acmy.a(paramacjr, acjt.a);
          break;
        }
        label663:
        paramString = "";
        break label258;
      }
      paramInt += 1;
    }
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)));
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
      if (jdField_a_of_type_JavaUtilHashSet.size() == 0)
      {
        jdField_a_of_type_Boolean = false;
        BaseApplicationImpl.getApplication().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      d();
    }
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaLangRefWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclo
 * JD-Core Version:    0.7.0.1
 */