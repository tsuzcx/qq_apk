import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.1;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.2;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ahuf
  implements aojz, Manager
{
  protected int a;
  private final ahse jdField_a_of_type_Ahse;
  private ahsh jdField_a_of_type_Ahsh = new ahug(this);
  private alpq jdField_a_of_type_Alpq = new ahuh(this);
  altm jdField_a_of_type_Altm = new ahuk(this);
  private final SparseArray<ahua> jdField_a_of_type_AndroidUtilSparseArray;
  private aqbl jdField_a_of_type_Aqbl = new ahui(this);
  private aufw jdField_a_of_type_Aufw = new ahuj(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final SparseArray<ahul> jdField_b_of_type_AndroidUtilSparseArray;
  private final List<ahum> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private final List<ahue> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public ahuf(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "CTEntryMng create");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(5);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList(5));
    this.jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList(5));
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList(5));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqbl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_Ahse = new ahse(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahsh);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramQQAppInterface.a("confess_config", this);
    paramQQAppInterface.a("extend_friend_config_785", this);
    paramQQAppInterface.a("contact_top_entry_config", this);
    paramQQAppInterface.a("register_invitation_config", this);
    ThreadManager.excute(new CTEntryMng.1(this), 64, null, false);
    if (this.jdField_a_of_type_Aufw != null) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this.jdField_a_of_type_Aufw);
    }
  }
  
  public static int a(List<ahua> paramList)
  {
    int i = 0;
    if ((paramList != null) && (i < paramList.size()))
    {
      ahua localahua = (ahua)paramList.get(i);
      if (localahua == null) {}
      while (!localahua.jdField_d_of_type_Boolean)
      {
        i += 1;
        break;
      }
      return 1;
    }
    return -1;
  }
  
  private ahum a(short paramShort)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (((ahum)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Short == paramShort) {
        return (ahum)this.jdField_b_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private String a(SparseArray<ahul> paramSparseArray)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramSparseArray != null)
    {
      localObject1 = localObject2;
      if (paramSparseArray.size() > 0)
      {
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramSparseArray.size())
        {
          localObject2 = (ahul)paramSparseArray.valueAt(i);
          if ((((ahul)localObject2).jdField_a_of_type_Int > 4) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(((ahul)localObject2).jdField_a_of_type_Int)))) {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "getEntryRedDotStr not save id: " + ((ahul)localObject2).jdField_a_of_type_Int);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((ahul)localObject2).a();
            if (localObject2 != null) {
              ((JSONArray)localObject1).put(localObject2);
            }
          }
        }
        localObject1 = ((JSONArray)localObject1).toString();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = Locale.getDefault();
      if (paramSparseArray != null) {
        break label194;
      }
    }
    label194:
    for (int i = 0;; i = paramSparseArray.size())
    {
      QLog.i("CTEntryMng", 2, String.format((Locale)localObject2, "getEntryRedDotStr size: %s, str: %s", new Object[] { Integer.valueOf(i), localObject1 }));
      return localObject1;
    }
  }
  
  private void a(ahum paramahum)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramahum)) {
      this.jdField_b_of_type_JavaUtilList.add(paramahum);
    }
  }
  
  private void a(SparseArray<ahul> paramSparseArray)
  {
    ThreadManager.excute(new CTEntryMng.2(this, paramSparseArray), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveEntryRedDot");
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifne +15 -> 18
    //   6: aload_0
    //   7: getfield 273	ahuf:jdField_a_of_type_Boolean	Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: invokespecial 275	ahuf:d	()V
    //   22: aload_0
    //   23: invokespecial 277	ahuf:f	()V
    //   26: aload_0
    //   27: aload_2
    //   28: invokespecial 280	ahuf:b	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 282	ahuf:d	(Z)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 273	ahuf:jdField_a_of_type_Boolean	Z
    //   41: aload_0
    //   42: invokespecial 249	ahuf:b	()V
    //   45: aload_0
    //   46: invokespecial 284	ahuf:c	()V
    //   49: aload_0
    //   50: invokevirtual 286	ahuf:a	()V
    //   53: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq -41 -> 15
    //   59: ldc 73
    //   61: iconst_2
    //   62: invokestatic 237	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   65: ldc_w 288
    //   68: iconst_3
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: iload_1
    //   75: invokestatic 293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: dup
    //   84: iconst_2
    //   85: aload_0
    //   86: getfield 81	ahuf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 245	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokestatic 79	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: goto -84 -> 15
    //   102: astore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	ahuf
    //   0	107	1	paramBoolean	boolean
    //   0	107	2	paramString	String
    //   10	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	102	finally
    //   18	99	102	finally
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {}
    int i;
    do
    {
      return false;
      i = paramJSONObject.optInt("id", 0);
    } while (i == 0);
    ??? = a(i);
    ((ahua)???).jdField_a_of_type_Int = i;
    ((ahua)???).jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", ((ahua)???).jdField_a_of_type_JavaLangString);
    ((ahua)???).jdField_c_of_type_JavaLangString = paramJSONObject.optString("AndroidMultiCardsIcon", ((ahua)???).jdField_c_of_type_JavaLangString);
    ((ahua)???).jdField_d_of_type_JavaLangString = paramJSONObject.optString("AndroidSingleCardIcon", ((ahua)???).jdField_d_of_type_JavaLangString);
    ((ahua)???).jdField_e_of_type_JavaLangString = paramJSONObject.optString("url", ((ahua)???).jdField_e_of_type_JavaLangString);
    ((ahua)???).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("showRedDot", ((ahua)???).jdField_a_of_type_Boolean);
    ((ahua)???).jdField_b_of_type_Int = paramJSONObject.optInt("redDotVersion", ((ahua)???).jdField_b_of_type_Int);
    ((ahua)???).jdField_a_of_type_Short = ((short)paramJSONObject.optInt("switchFlag", ((ahua)???).jdField_a_of_type_Short));
    switch (((ahua)???).jdField_a_of_type_Int)
    {
    default: 
      ((ahua)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ahua)???).jdField_b_of_type_JavaLangString);
      ((ahua)???).jdField_b_of_type_Boolean = false;
      ((ahua)???).jdField_c_of_type_Boolean = true;
      b((ahua)???);
      paramJSONObject = a(((ahua)???).jdField_a_of_type_Int);
      if (paramJSONObject.jdField_b_of_type_Int != ((ahua)???).jdField_b_of_type_Int)
      {
        paramJSONObject.jdField_b_of_type_Int = ((ahua)???).jdField_b_of_type_Int;
        paramJSONObject.jdField_a_of_type_Boolean = ((ahua)???).jdField_a_of_type_Boolean;
        paramJSONObject.jdField_b_of_type_Boolean = false;
        paramJSONObject.jdField_a_of_type_Long = 0L;
      }
      break;
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
      {
        this.jdField_b_of_type_AndroidUtilSparseArray.put(paramJSONObject.jdField_a_of_type_Int, paramJSONObject);
        return bool;
        ((ahua)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ahua)???).jdField_b_of_type_JavaLangString);
        ((ahua)???).jdField_b_of_type_Boolean = false;
        ((ahua)???).jdField_a_of_type_Short = -25161;
        break;
        ((ahua)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ahua)???).jdField_b_of_type_JavaLangString);
        ((ahua)???).jdField_b_of_type_Boolean = false;
        ((ahua)???).jdField_e_of_type_JavaLangString = "native";
        ((ahua)???).jdField_a_of_type_Short = -23324;
        break;
        ((ahua)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ahua)???).jdField_b_of_type_JavaLangString);
        ((ahua)???).jdField_b_of_type_Boolean = false;
        ((ahua)???).jdField_a_of_type_Short = -23323;
        break;
        ((ahua)???).jdField_b_of_type_Boolean = true;
        ((ahua)???).jdField_e_of_type_JavaLangString = "native";
        ((ahua)???).jdField_a_of_type_Short = -23447;
        break;
        ((ahua)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ahua)???).jdField_b_of_type_JavaLangString);
        ((ahua)???).jdField_b_of_type_Boolean = false;
        ((ahua)???).jdField_e_of_type_JavaLangString = "native";
        ((ahua)???).jdField_a_of_type_Short = -23316;
      }
      bool = false;
    }
  }
  
  private void b()
  {
    int i = 0;
    try
    {
      while (i < this.jdField_c_of_type_JavaUtilList.size())
      {
        ahue localahue = (ahue)this.jdField_c_of_type_JavaUtilList.get(i);
        if (localahue != null) {
          localahue.a();
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "notifyEntryUpdated [isEntryUIInit: %s, redDotFlag: %s]", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      if (!this.jdField_e_of_type_Boolean) {
        a(a(b()));
      }
    }
  }
  
  private void b(ahua paramahua)
  {
    if (paramahua == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramahua.jdField_a_of_type_Int, paramahua);
      return;
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: invokeinterface 395 1 0
    //   9: aload_1
    //   10: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +327 -> 340
    //   16: new 300	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 403	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 405
    //   29: invokevirtual 409	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   32: ifeq +303 -> 335
    //   35: aload_1
    //   36: ldc_w 405
    //   39: invokevirtual 413	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore 6
    //   44: iconst_0
    //   45: istore_3
    //   46: iconst_0
    //   47: istore_2
    //   48: aload 6
    //   50: ifnull +47 -> 97
    //   53: iload_3
    //   54: aload 6
    //   56: invokevirtual 416	org/json/JSONArray:length	()I
    //   59: if_icmpge +38 -> 97
    //   62: aload_0
    //   63: aload 6
    //   65: iload_3
    //   66: invokevirtual 420	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   69: invokespecial 422	ahuf:a	(Lorg/json/JSONObject;)Z
    //   72: istore 5
    //   74: iload 5
    //   76: ifne +7 -> 83
    //   79: iload_2
    //   80: ifeq +12 -> 92
    //   83: iconst_1
    //   84: istore_2
    //   85: iload_3
    //   86: iconst_1
    //   87: iadd
    //   88: istore_3
    //   89: goto -41 -> 48
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -9 -> 85
    //   97: iload_2
    //   98: istore_3
    //   99: aload_1
    //   100: ldc_w 424
    //   103: invokevirtual 409	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   106: ifeq +70 -> 176
    //   109: aload_1
    //   110: ldc_w 424
    //   113: invokevirtual 413	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   116: astore_1
    //   117: iconst_0
    //   118: istore 4
    //   120: iload_2
    //   121: istore_3
    //   122: aload_1
    //   123: ifnull +53 -> 176
    //   126: iload_2
    //   127: istore_3
    //   128: iload 4
    //   130: aload_1
    //   131: invokevirtual 416	org/json/JSONArray:length	()I
    //   134: if_icmpge +42 -> 176
    //   137: aload_1
    //   138: iload 4
    //   140: invokevirtual 428	org/json/JSONArray:getInt	(I)I
    //   143: istore_3
    //   144: aload_0
    //   145: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   148: iload_3
    //   149: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokeinterface 262 2 0
    //   157: pop
    //   158: iload 4
    //   160: iconst_1
    //   161: iadd
    //   162: istore 4
    //   164: goto -44 -> 120
    //   167: astore_1
    //   168: iconst_0
    //   169: istore_2
    //   170: aload_1
    //   171: invokevirtual 429	org/json/JSONException:printStackTrace	()V
    //   174: iload_2
    //   175: istore_3
    //   176: aload_0
    //   177: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   180: iconst_3
    //   181: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokeinterface 207 2 0
    //   189: ifne +17 -> 206
    //   192: aload_0
    //   193: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   196: iconst_3
    //   197: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokeinterface 262 2 0
    //   205: pop
    //   206: aload_0
    //   207: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   210: iconst_1
    //   211: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 207 2 0
    //   219: ifeq +8 -> 227
    //   222: aload_0
    //   223: iconst_0
    //   224: invokespecial 431	ahuf:e	(Z)V
    //   227: aload_0
    //   228: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   231: iconst_2
    //   232: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokeinterface 207 2 0
    //   240: ifeq +8 -> 248
    //   243: aload_0
    //   244: iconst_0
    //   245: invokespecial 433	ahuf:f	(Z)V
    //   248: aload_0
    //   249: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   252: iconst_3
    //   253: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokeinterface 207 2 0
    //   261: ifeq +8 -> 269
    //   264: aload_0
    //   265: iconst_0
    //   266: invokespecial 254	ahuf:g	(Z)V
    //   269: aload_0
    //   270: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   273: iconst_4
    //   274: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokeinterface 207 2 0
    //   282: ifeq +8 -> 290
    //   285: aload_0
    //   286: iconst_0
    //   287: invokespecial 436	ahuf:h	(Z)V
    //   290: aload_0
    //   291: getfield 101	ahuf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   294: iconst_5
    //   295: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: invokeinterface 207 2 0
    //   303: ifeq +8 -> 311
    //   306: aload_0
    //   307: iconst_0
    //   308: invokevirtual 438	ahuf:c	(Z)V
    //   311: iload_3
    //   312: ifeq +14 -> 326
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 90	ahuf:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   320: invokevirtual 442	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   323: invokespecial 444	ahuf:a	(Landroid/util/SparseArray;)V
    //   326: return
    //   327: astore_1
    //   328: goto -158 -> 170
    //   331: astore_1
    //   332: goto -162 -> 170
    //   335: iconst_0
    //   336: istore_2
    //   337: goto -240 -> 97
    //   340: iconst_0
    //   341: istore_3
    //   342: goto -166 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	ahuf
    //   0	345	1	paramString	String
    //   47	290	2	i	int
    //   45	297	3	j	int
    //   118	45	4	k	int
    //   72	3	5	bool	boolean
    //   42	22	6	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   16	44	167	org/json/JSONException
    //   53	74	327	org/json/JSONException
    //   99	117	331	org/json/JSONException
    //   128	158	331	org/json/JSONException
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.f)
      {
        this.f = true;
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_switch", 0).getInt("key_mayknow_connections_switch", 0);
        if (QLog.isColorLevel()) {
          QLog.i("CTEntryMng", 2, "initConnectionsSwitchLocal " + this.jdField_c_of_type_Int);
        }
      }
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
    {
      this.jdField_b_of_type_AndroidUtilSparseArray.clear();
      a(bdga.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ct_entry_reddot_info"));
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "initEntryRedDot");
      }
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  private void e()
  {
    ThreadManager.excute(new CTEntryMng.3(this), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveUserSetting");
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {}
    ahua localahua;
    boolean bool;
    do
    {
      return;
      localahua = a(1);
      bool = localahua.jdField_c_of_type_Boolean;
      aoiq localaoiq = ((aoiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a();
      if (TextUtils.isEmpty(localahua.jdField_a_of_type_JavaLangString)) {
        localahua.jdField_a_of_type_JavaLangString = alud.a(2131703020);
      }
      localahua.jdField_c_of_type_Boolean = localaoiq.a();
      b(localahua);
      if ((bool != localahua.jdField_c_of_type_Boolean) && (localahua.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localahua);
      }
    } while (!QLog.isColorLevel());
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", new Object[] { Boolean.valueOf(localahua.jdField_c_of_type_Boolean), localahua.jdField_a_of_type_JavaLangString, localahua.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
  }
  
  private void f()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = bdga.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ct_entry_user_setting");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          ahum localahum = new ahum();
          localahum.a(localJSONObject);
          if ((localahum.jdField_a_of_type_Int != 0) && (localahum.jdField_a_of_type_Short != 0)) {
            a(localahum);
          }
          i += 1;
        }
        this.jdField_c_of_type_Boolean = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ahua localahua = a(2);
    boolean bool = localahua.jdField_c_of_type_Boolean;
    aqbg localaqbg = (aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
    aqbj localaqbj = localaqbg.b();
    if (localaqbj != null) {
      localahua.jdField_c_of_type_Boolean = localaqbg.a(localaqbj);
    }
    for (localahua.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localaqbg.c());; localahua.jdField_a_of_type_JavaLangObject = null)
    {
      b(localahua);
      if ((bool != localahua.jdField_c_of_type_Boolean) && (localahua.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localahua);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", new Object[] { Boolean.valueOf(localahua.jdField_c_of_type_Boolean), localahua.jdField_a_of_type_JavaLangString, localahua.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
      return;
      localahua.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ahua localahua = a(3);
    boolean bool3 = localahua.jdField_c_of_type_Boolean;
    alwd localalwd = (alwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    boolean bool2;
    boolean bool1;
    if (localalwd != null)
    {
      bool2 = localalwd.b("sp_mayknow_entry_list_recommend");
      bool1 = localalwd.b("sp_mayknow_entry_list_head");
    }
    for (;;)
    {
      localahua.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131699478);
      if ((bool1) && (!bool2)) {}
      for (localahua.jdField_c_of_type_Boolean = true;; localahua.jdField_c_of_type_Boolean = false)
      {
        if (localahua.jdField_a_of_type_JavaLangObject == null) {
          localahua.jdField_b_of_type_JavaLangString = "";
        }
        if ((paramBoolean) || ((localahua.jdField_c_of_type_Boolean) && (localahua.jdField_a_of_type_JavaLangObject == null))) {
          this.jdField_a_of_type_Ahse.b();
        }
        b(localahua);
        if ((bool3 != localahua.jdField_c_of_type_Boolean) && (localahua.jdField_c_of_type_Boolean) && (paramBoolean)) {
          a(localahua);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", new Object[] { Boolean.valueOf(localahua.jdField_c_of_type_Boolean), localahua.jdField_a_of_type_JavaLangString, localahua.jdField_b_of_type_JavaLangString, localahua.jdField_a_of_type_JavaLangObject }));
        return;
      }
      bool1 = true;
      bool2 = false;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ahua localahua = a(4);
    boolean bool2 = localahua.jdField_c_of_type_Boolean;
    if (BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localahua.jdField_c_of_type_Boolean = bool1;
      if ((bool2 != localahua.jdField_c_of_type_Boolean) && (localahua.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localahua);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", new Object[] { Boolean.valueOf(localahua.jdField_c_of_type_Boolean), localahua.jdField_a_of_type_JavaLangString, localahua.jdField_b_of_type_JavaLangString, localahua.jdField_e_of_type_JavaLangString }));
      return;
    }
  }
  
  public ahse a()
  {
    return this.jdField_a_of_type_Ahse;
  }
  
  public ahua a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      ahua localahua = (ahua)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localahua;
      if (localahua == null)
      {
        ??? = new ahua();
        ((ahua)???).jdField_a_of_type_Int = paramInt;
        ((ahua)???).jdField_c_of_type_Boolean = false;
        ((ahua)???).jdField_e_of_type_Boolean = false;
        ((ahua)???).jdField_a_of_type_JavaLangObject = null;
      }
      return ???;
    }
  }
  
  public ahul a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
    {
      ahul localahul = (ahul)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localahul;
      if (localahul == null)
      {
        ??? = new ahul();
        ((ahul)???).jdField_a_of_type_Int = paramInt;
      }
      return ???;
    }
  }
  
  public ahum a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_b_of_type_JavaUtilList.size()) {
      if (((ahum)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (ahum localahum1 = (ahum)this.jdField_b_of_type_JavaUtilList.get(i);; localahum1 = null)
    {
      ahum localahum2 = localahum1;
      if (localahum1 == null)
      {
        localahum2 = new ahum();
        localahum2.jdField_a_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          localahum2.jdField_a_of_type_Short = 0;
        }
      }
      for (;;)
      {
        localahum2.b = -32768;
        return localahum2;
        i += 1;
        break;
        localahum2.jdField_a_of_type_Short = -25161;
        continue;
        localahum2.jdField_a_of_type_Short = -23324;
        continue;
        localahum2.jdField_a_of_type_Short = -23447;
        continue;
        localahum2.jdField_a_of_type_Short = -23323;
        continue;
        localahum2.jdField_a_of_type_Short = -23316;
      }
    }
  }
  
  public List<ahua> a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(false, bdne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "contact_top_entry_config"));
    }
    return c();
  }
  
  public short a(ahua paramahua, boolean paramBoolean)
  {
    if (paramahua == null) {
      return 0;
    }
    paramahua = a(paramahua.jdField_a_of_type_Int);
    short s2 = paramahua.jdField_a_of_type_Short;
    if ((paramBoolean) && (paramahua.b != 1)) {}
    for (short s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "closeEntry switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(s2), Short.valueOf(s1) }));
      }
      if (s2 != 0) {
        ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(s2, s1);
      }
      return s2;
      if ((paramBoolean) || (paramahua.b == 0)) {
        break;
      }
    }
    if (paramBoolean) {}
    for (s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "closeEntry, caution something wrong!");
      }
      break;
    }
  }
  
  public void a()
  {
    ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).r();
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1) {}
    for (paramInt = i;; paramInt = 0)
    {
      ahux.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
      ambm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, "updateRedPoint mRedDotFlag: " + this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void a(ahua paramahua)
  {
    if (paramahua == null) {
      return;
    }
    short[] arrayOfShort = new short[1];
    switch (paramahua.jdField_a_of_type_Int)
    {
    default: 
      arrayOfShort[0] = paramahua.jdField_a_of_type_Short;
    }
    for (;;)
    {
      ahum localahum = a(paramahua.jdField_a_of_type_Int);
      localahum.jdField_a_of_type_Short = arrayOfShort[0];
      a(localahum);
      ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(arrayOfShort);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", new Object[] { Integer.valueOf(paramahua.jdField_a_of_type_Int), Short.valueOf(arrayOfShort[0]), paramahua.jdField_a_of_type_JavaLangString }));
      return;
      arrayOfShort[0] = -25161;
      continue;
      arrayOfShort[0] = -23324;
      continue;
      arrayOfShort[0] = -23447;
      continue;
      arrayOfShort[0] = -23323;
      continue;
      arrayOfShort[0] = -23316;
    }
  }
  
  public void a(ahua paramahua, short paramShort)
  {
    if (paramahua == null) {
      return;
    }
    ahum localahum = a(paramahua.jdField_a_of_type_Short);
    if ((localahum != null) && (localahum.b != paramShort)) {
      localahum.b = paramShort;
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        e();
        b();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", new Object[] { Integer.valueOf(paramahua.jdField_a_of_type_Int), Short.valueOf(paramShort), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public void a(ahue paramahue)
  {
    if ((paramahue != null) && (!this.jdField_c_of_type_JavaUtilList.contains(paramahue))) {
      this.jdField_c_of_type_JavaUtilList.add(paramahue);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aojy paramaojy)
  {
    if (paramaojy != null) {
      a(paramString, paramaojy.jdField_a_of_type_JavaLangString, paramaojy.jdField_a_of_type_Int, paramaojy.jdField_b_of_type_Int);
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        i = 0;
        if (i < localJSONArray.length())
        {
          ??? = localJSONArray.getJSONObject(i);
          ahul localahul = new ahul();
          localahul.a((JSONObject)???);
          if (localahul.jdField_a_of_type_Int == 0) {
            break label141;
          }
          synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.put(localahul.jdField_a_of_type_Int, localahul);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "parseEntryRedDot size: %s, str: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_AndroidUtilSparseArray.size()), paramString }));
      return;
      label141:
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onConfigUpdatedFromServer tag: %s, localVersion: %s, version: %s, value: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    if ("confess_config".equals(paramString1)) {
      e(true);
    }
    do
    {
      return;
      if ("extend_friend_config_785".equals(paramString1))
      {
        f(true);
        return;
      }
      if ("register_invitation_config".equals(paramString1))
      {
        h(true);
        return;
      }
    } while (!"contact_top_entry_config".equals(paramString1));
    a(true, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "setEntryUIInit  " + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateBindPhoneSwitchInfo needShow:" + paramBoolean1 + " net_gap:" + paramInt + " isNewUser:" + paramBoolean2 + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    bdne.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).edit().putBoolean("contacts_bind_phone_canshow", paramBoolean1).putInt("contacts_bind_phone_next_gap", paramInt).putBoolean("contacts_bind_phone_is_new_user", paramBoolean2).commit();
    c(false);
    b();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public List<ahua> b()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      ahua localahua = a(3);
      if (localahua.a())
      {
        localahua.jdField_e_of_type_Boolean = a(3).a();
        localahua.jdField_d_of_type_Boolean = false;
        localArrayList.add(localahua);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryListToShow size:" + localArrayList.size() + "  canBeShown:" + localahua.jdField_c_of_type_Boolean + "  isUserClose:" + localahua.jdField_e_of_type_Boolean);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("CTEntryMng", 1, "getEntryListToShow error:" + localException.getMessage());
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveConnectionsSwitchToLocal " + paramInt);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_switch", 0).edit().putInt("key_mayknow_connections_switch", paramInt).commit();
      this.jdField_c_of_type_Int = paramInt;
      this.f = true;
      return;
    }
  }
  
  public void b(ahue paramahue)
  {
    if (paramahue != null) {
      this.jdField_c_of_type_JavaUtilList.remove(paramahue);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "setConnectionsSwitch " + paramBoolean);
    }
    if (!c()) {}
    for (boolean bool = true; bool == paramBoolean; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "setConnectionsSwitch no need to set");
      }
      return;
    }
    alpk localalpk = (alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
    if (paramBoolean) {}
    for (;;)
    {
      localalpk.a((short)-23204, (short)i);
      return;
      i = 0;
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if ((this.jdField_b_of_type_JavaUtilList.get(i) != null) && (((ahum)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 3)) {
          bool1 = ((ahum)this.jdField_b_of_type_JavaUtilList.get(i)).a();
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public List<ahua> c()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      ahua localahua = a(3);
      localahua.jdField_e_of_type_Boolean = a(3).a();
      localArrayList.add(localahua);
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryListForSetting size:" + localArrayList.size() + "  canBeShown:" + localahua.jdField_c_of_type_Boolean + "  isUserClose:" + localahua.jdField_e_of_type_Boolean);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localArrayList;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ahua localahua = a(5);
    boolean bool1 = localahua.jdField_c_of_type_Boolean;
    int i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateFindFriendEntry selfBindState:" + i + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    if ((i == 1) || (i == 2))
    {
      SharedPreferences localSharedPreferences = bdne.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      boolean bool2 = localSharedPreferences.getBoolean("contacts_bind_phone_canshow", false);
      localahua.jdField_c_of_type_Boolean = bool2;
      if (bool2) {
        localahua.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localSharedPreferences.getBoolean("contacts_bind_phone_is_new_user", false));
      }
      if (!localahua.jdField_e_of_type_Boolean)
      {
        i = localSharedPreferences.getInt("contacts_bind_phone_next_gap", 300);
        long l1 = localSharedPreferences.getLong("contacts_bind_phone_last_time", -1L);
        long l2 = NetConnInfoCenter.getServerTime();
        if (QLog.isDevelopLevel()) {
          QLog.i("CTEntryMng", 4, "updateFindFriendEntry nextGap:" + i + " gap:" + (l2 - l1) + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        }
        if ((l1 < 0L) || (l2 - l1 >= i))
        {
          ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).C();
          localSharedPreferences.edit().putLong("contacts_bind_phone_last_time", l2).commit();
        }
      }
    }
    for (;;)
    {
      b(localahua);
      if ((bool1 != localahua.jdField_c_of_type_Boolean) && (localahua.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localahua);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", new Object[] { Boolean.valueOf(localahua.jdField_c_of_type_Boolean), localahua.jdField_a_of_type_JavaLangString, localahua.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() }));
      return;
      localahua.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean c()
  {
    c();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_c_of_type_Int == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_b_of_type_Int > 20))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryUserSettingFromServer fromConfig to many times!");
      }
      return;
    }
    if (paramBoolean) {
      this.jdField_b_of_type_Int += 1;
    }
    String str = "";
    for (;;)
    {
      short[] arrayOfShort;
      int i;
      try
      {
        List localList = c();
        if (localList.size() <= 0) {
          break;
        }
        arrayOfShort = new short[localList.size()];
        i = 0;
        if (i >= localList.size()) {
          break label257;
        }
        ahua localahua = (ahua)localList.get(i);
        switch (localahua.jdField_a_of_type_Int)
        {
        case 1: 
          arrayOfShort[i] = localahua.jdField_a_of_type_Short;
          ahum localahum = a(localahua.jdField_a_of_type_Int);
          localahum.jdField_a_of_type_Short = arrayOfShort[i];
          a(localahum);
          if (!QLog.isColorLevel()) {
            break label303;
          }
          str = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", new Object[] { str, Integer.valueOf(localahua.jdField_a_of_type_Int), localahua.jdField_a_of_type_JavaLangString, Short.valueOf(arrayOfShort[i]) });
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      arrayOfShort[i] = -25161;
      continue;
      arrayOfShort[i] = -23324;
      continue;
      label257:
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer log: %s", new Object[] { localThrowable }));
      }
      ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(arrayOfShort);
      return;
      label303:
      break label309;
      continue;
      label309:
      i += 1;
      continue;
      arrayOfShort[i] = -23447;
      continue;
      arrayOfShort[i] = -23323;
      continue;
      arrayOfShort[i] = -23316;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this);
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_Ahse.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)) && (this.jdField_a_of_type_Aufw != null)) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Aufw);
    }
    this.jdField_a_of_type_Aufw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuf
 * JD-Core Version:    0.7.0.1
 */