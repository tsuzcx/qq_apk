import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.1;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.2;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class ajmy
  implements aqwi, Manager
{
  protected int a;
  private final ajnh jdField_a_of_type_Ajnh;
  private ajnk jdField_a_of_type_Ajnk = new ajmz(this);
  private final SparseArray<ajmt> jdField_a_of_type_AndroidUtilSparseArray;
  anvi jdField_a_of_type_Anvi = new ajnd(this);
  private aslz jdField_a_of_type_Aslz = new ajnb(this);
  private awza jdField_a_of_type_Awza = new ajnc(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ajna(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final SparseArray<ajne> jdField_b_of_type_AndroidUtilSparseArray;
  private final List<ajnf> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private final List<ajmx> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public ajmy(QQAppInterface paramQQAppInterface)
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Ajnh = new ajnh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajnk);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess();
    paramQQAppInterface.a("confess_config", this);
    paramQQAppInterface.a("extend_friend_config_785", this);
    paramQQAppInterface.a("contact_top_entry_config", this);
    paramQQAppInterface.a("register_invitation_config", this);
    ThreadManager.excute(new CTEntryMng.1(this), 64, null, false);
    if (this.jdField_a_of_type_Awza != null) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(this.jdField_a_of_type_Awza);
    }
  }
  
  public static int a(List<ajmt> paramList)
  {
    int i = 0;
    if ((paramList != null) && (i < paramList.size()))
    {
      ajmt localajmt = (ajmt)paramList.get(i);
      if (localajmt == null) {}
      while (!localajmt.jdField_d_of_type_Boolean)
      {
        i += 1;
        break;
      }
      return 1;
    }
    return -1;
  }
  
  private ajnf a(short paramShort)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (((ajnf)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Short == paramShort) {
        return (ajnf)this.jdField_b_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private String a(SparseArray<ajne> paramSparseArray)
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
          localObject2 = (ajne)paramSparseArray.valueAt(i);
          if ((((ajne)localObject2).jdField_a_of_type_Int > 4) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(((ajne)localObject2).jdField_a_of_type_Int)))) {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "getEntryRedDotStr not save id: " + ((ajne)localObject2).jdField_a_of_type_Int);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((ajne)localObject2).a();
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
  
  private void a(ajnf paramajnf)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramajnf)) {
      this.jdField_b_of_type_JavaUtilList.add(paramajnf);
    }
  }
  
  private void a(SparseArray<ajne> paramSparseArray)
  {
    ThreadManager.excute(new CTEntryMng.2(this, paramSparseArray), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveEntryRedDot");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((ajmy)paramQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).a();
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
    //   7: getfield 283	ajmy:jdField_a_of_type_Boolean	Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: invokespecial 285	ajmy:d	()V
    //   22: aload_0
    //   23: invokespecial 288	ajmy:f	()V
    //   26: aload_0
    //   27: aload_2
    //   28: invokespecial 291	ajmy:b	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 293	ajmy:d	(Z)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 283	ajmy:jdField_a_of_type_Boolean	Z
    //   41: aload_0
    //   42: invokespecial 254	ajmy:b	()V
    //   45: aload_0
    //   46: invokespecial 295	ajmy:c	()V
    //   49: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -37 -> 15
    //   55: ldc 72
    //   57: iconst_2
    //   58: invokestatic 242	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   61: ldc_w 297
    //   64: iconst_3
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_1
    //   71: invokestatic 302	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_2
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: aload_0
    //   82: getfield 80	ajmy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   85: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   88: aastore
    //   89: invokestatic 250	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokestatic 78	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -80 -> 15
    //   98: astore_2
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_2
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	ajmy
    //   0	103	1	paramBoolean	boolean
    //   0	103	2	paramString	String
    //   10	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	98	finally
    //   18	95	98	finally
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
    ((ajmt)???).jdField_a_of_type_Int = i;
    ((ajmt)???).jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", ((ajmt)???).jdField_a_of_type_JavaLangString);
    ((ajmt)???).jdField_c_of_type_JavaLangString = paramJSONObject.optString("AndroidMultiCardsIcon", ((ajmt)???).jdField_c_of_type_JavaLangString);
    ((ajmt)???).jdField_d_of_type_JavaLangString = paramJSONObject.optString("AndroidSingleCardIcon", ((ajmt)???).jdField_d_of_type_JavaLangString);
    ((ajmt)???).jdField_e_of_type_JavaLangString = paramJSONObject.optString("url", ((ajmt)???).jdField_e_of_type_JavaLangString);
    ((ajmt)???).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("showRedDot", ((ajmt)???).jdField_a_of_type_Boolean);
    ((ajmt)???).jdField_b_of_type_Int = paramJSONObject.optInt("redDotVersion", ((ajmt)???).jdField_b_of_type_Int);
    ((ajmt)???).jdField_a_of_type_Short = ((short)paramJSONObject.optInt("switchFlag", ((ajmt)???).jdField_a_of_type_Short));
    switch (((ajmt)???).jdField_a_of_type_Int)
    {
    default: 
      ((ajmt)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajmt)???).jdField_b_of_type_JavaLangString);
      ((ajmt)???).jdField_b_of_type_Boolean = false;
      ((ajmt)???).jdField_c_of_type_Boolean = true;
      b((ajmt)???);
      paramJSONObject = a(((ajmt)???).jdField_a_of_type_Int);
      if (paramJSONObject.jdField_b_of_type_Int != ((ajmt)???).jdField_b_of_type_Int)
      {
        paramJSONObject.jdField_b_of_type_Int = ((ajmt)???).jdField_b_of_type_Int;
        paramJSONObject.jdField_a_of_type_Boolean = ((ajmt)???).jdField_a_of_type_Boolean;
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
        ((ajmt)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajmt)???).jdField_b_of_type_JavaLangString);
        ((ajmt)???).jdField_b_of_type_Boolean = false;
        ((ajmt)???).jdField_a_of_type_Short = -25161;
        break;
        ((ajmt)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajmt)???).jdField_b_of_type_JavaLangString);
        ((ajmt)???).jdField_b_of_type_Boolean = false;
        ((ajmt)???).jdField_e_of_type_JavaLangString = "native";
        ((ajmt)???).jdField_a_of_type_Short = -23324;
        break;
        ((ajmt)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajmt)???).jdField_b_of_type_JavaLangString);
        ((ajmt)???).jdField_b_of_type_Boolean = false;
        ((ajmt)???).jdField_a_of_type_Short = -23323;
        break;
        ((ajmt)???).jdField_b_of_type_Boolean = true;
        ((ajmt)???).jdField_e_of_type_JavaLangString = "native";
        ((ajmt)???).jdField_a_of_type_Short = -23447;
        break;
        ((ajmt)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajmt)???).jdField_b_of_type_JavaLangString);
        ((ajmt)???).jdField_b_of_type_Boolean = false;
        ((ajmt)???).jdField_e_of_type_JavaLangString = "native";
        ((ajmt)???).jdField_a_of_type_Short = -23316;
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
        ajmx localajmx = (ajmx)this.jdField_c_of_type_JavaUtilList.get(i);
        if (localajmx != null) {
          localajmx.a();
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
  
  private void b(ajmt paramajmt)
  {
    if (paramajmt == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramajmt.jdField_a_of_type_Int, paramajmt);
      return;
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: invokeinterface 405 1 0
    //   9: aload_1
    //   10: invokestatic 411	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +327 -> 340
    //   16: new 310	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 413	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 415
    //   29: invokevirtual 419	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   32: ifeq +303 -> 335
    //   35: aload_1
    //   36: ldc_w 415
    //   39: invokevirtual 423	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore 6
    //   44: iconst_0
    //   45: istore_3
    //   46: iconst_0
    //   47: istore_2
    //   48: aload 6
    //   50: ifnull +47 -> 97
    //   53: iload_3
    //   54: aload 6
    //   56: invokevirtual 426	org/json/JSONArray:length	()I
    //   59: if_icmpge +38 -> 97
    //   62: aload_0
    //   63: aload 6
    //   65: iload_3
    //   66: invokevirtual 430	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   69: invokespecial 432	ajmy:a	(Lorg/json/JSONObject;)Z
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
    //   100: ldc_w 434
    //   103: invokevirtual 419	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   106: ifeq +70 -> 176
    //   109: aload_1
    //   110: ldc_w 434
    //   113: invokevirtual 423	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   131: invokevirtual 426	org/json/JSONArray:length	()I
    //   134: if_icmpge +42 -> 176
    //   137: aload_1
    //   138: iload 4
    //   140: invokevirtual 438	org/json/JSONArray:getInt	(I)I
    //   143: istore_3
    //   144: aload_0
    //   145: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   148: iload_3
    //   149: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokeinterface 267 2 0
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
    //   171: invokevirtual 439	org/json/JSONException:printStackTrace	()V
    //   174: iload_2
    //   175: istore_3
    //   176: aload_0
    //   177: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   180: iconst_3
    //   181: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokeinterface 212 2 0
    //   189: ifne +17 -> 206
    //   192: aload_0
    //   193: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   196: iconst_3
    //   197: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokeinterface 267 2 0
    //   205: pop
    //   206: aload_0
    //   207: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   210: iconst_1
    //   211: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 212 2 0
    //   219: ifeq +8 -> 227
    //   222: aload_0
    //   223: iconst_0
    //   224: invokespecial 441	ajmy:e	(Z)V
    //   227: aload_0
    //   228: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   231: iconst_2
    //   232: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokeinterface 212 2 0
    //   240: ifeq +8 -> 248
    //   243: aload_0
    //   244: iconst_0
    //   245: invokespecial 443	ajmy:f	(Z)V
    //   248: aload_0
    //   249: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   252: iconst_3
    //   253: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokeinterface 212 2 0
    //   261: ifeq +8 -> 269
    //   264: aload_0
    //   265: iconst_0
    //   266: invokespecial 259	ajmy:g	(Z)V
    //   269: aload_0
    //   270: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   273: iconst_4
    //   274: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokeinterface 212 2 0
    //   282: ifeq +8 -> 290
    //   285: aload_0
    //   286: iconst_0
    //   287: invokespecial 446	ajmy:h	(Z)V
    //   290: aload_0
    //   291: getfield 100	ajmy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   294: iconst_5
    //   295: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: invokeinterface 212 2 0
    //   303: ifeq +8 -> 311
    //   306: aload_0
    //   307: iconst_0
    //   308: invokevirtual 448	ajmy:c	(Z)V
    //   311: iload_3
    //   312: ifeq +14 -> 326
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 89	ajmy:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   320: invokevirtual 452	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   323: invokespecial 454	ajmy:a	(Landroid/util/SparseArray;)V
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
    //   0	345	0	this	ajmy
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
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_switch", 4).getInt("key_mayknow_connections_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "initConnectionsSwitchLocal " + this.jdField_c_of_type_Int);
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
      a(bhdc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "ct_entry_reddot_info"));
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
    ajmt localajmt;
    boolean bool;
    do
    {
      return;
      localajmt = a(1);
      bool = localajmt.jdField_c_of_type_Boolean;
      aquz localaquz = ((aqvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
      if (TextUtils.isEmpty(localajmt.jdField_a_of_type_JavaLangString)) {
        localajmt.jdField_a_of_type_JavaLangString = anvx.a(2131702120);
      }
      localajmt.jdField_c_of_type_Boolean = localaquz.a();
      b(localajmt);
      if ((bool != localajmt.jdField_c_of_type_Boolean) && (localajmt.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajmt);
      }
    } while (!QLog.isColorLevel());
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", new Object[] { Boolean.valueOf(localajmt.jdField_c_of_type_Boolean), localajmt.jdField_a_of_type_JavaLangString, localajmt.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
  }
  
  private void f()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = bhdc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "ct_entry_user_setting");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          ajnf localajnf = new ajnf();
          localajnf.a(localJSONObject);
          if ((localajnf.jdField_a_of_type_Int != 0) && (localajnf.jdField_a_of_type_Short != 0)) {
            a(localajnf);
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
    ajmt localajmt = a(2);
    boolean bool = localajmt.jdField_c_of_type_Boolean;
    aslo localaslo = (aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    aslx localaslx = localaslo.b();
    if (localaslx != null) {
      localajmt.jdField_c_of_type_Boolean = localaslo.a(localaslx);
    }
    for (localajmt.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localaslo.d());; localajmt.jdField_a_of_type_JavaLangObject = null)
    {
      b(localajmt);
      if ((bool != localajmt.jdField_c_of_type_Boolean) && (localajmt.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajmt);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", new Object[] { Boolean.valueOf(localajmt.jdField_c_of_type_Boolean), localajmt.jdField_a_of_type_JavaLangString, localajmt.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
      return;
      localajmt.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ajmt localajmt = a(3);
    boolean bool3 = localajmt.jdField_c_of_type_Boolean;
    anyb localanyb = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    boolean bool2;
    boolean bool1;
    if (localanyb != null)
    {
      bool2 = localanyb.b("sp_mayknow_entry_list_recommend");
      bool1 = localanyb.b("sp_mayknow_entry_list_head");
    }
    for (;;)
    {
      localajmt.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131698626);
      if ((bool1) && (!bool2)) {}
      for (localajmt.jdField_c_of_type_Boolean = true;; localajmt.jdField_c_of_type_Boolean = false)
      {
        if (localajmt.jdField_a_of_type_JavaLangObject == null) {
          localajmt.jdField_b_of_type_JavaLangString = "";
        }
        if ((paramBoolean) || ((localajmt.jdField_c_of_type_Boolean) && (localajmt.jdField_a_of_type_JavaLangObject == null))) {
          this.jdField_a_of_type_Ajnh.b();
        }
        b(localajmt);
        if ((bool3 != localajmt.jdField_c_of_type_Boolean) && (localajmt.jdField_c_of_type_Boolean) && (paramBoolean)) {
          a(localajmt);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", new Object[] { Boolean.valueOf(localajmt.jdField_c_of_type_Boolean), localajmt.jdField_a_of_type_JavaLangString, localajmt.jdField_b_of_type_JavaLangString, localajmt.jdField_a_of_type_JavaLangObject }));
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
    ajmt localajmt = a(4);
    boolean bool2 = localajmt.jdField_c_of_type_Boolean;
    if (BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localajmt.jdField_c_of_type_Boolean = bool1;
      if ((bool2 != localajmt.jdField_c_of_type_Boolean) && (localajmt.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajmt);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", new Object[] { Boolean.valueOf(localajmt.jdField_c_of_type_Boolean), localajmt.jdField_a_of_type_JavaLangString, localajmt.jdField_b_of_type_JavaLangString, localajmt.jdField_e_of_type_JavaLangString }));
      return;
    }
  }
  
  public ajmt a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      ajmt localajmt = (ajmt)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localajmt;
      if (localajmt == null)
      {
        ??? = new ajmt();
        ((ajmt)???).jdField_a_of_type_Int = paramInt;
        ((ajmt)???).jdField_c_of_type_Boolean = false;
        ((ajmt)???).jdField_e_of_type_Boolean = false;
        ((ajmt)???).jdField_a_of_type_JavaLangObject = null;
      }
      return ???;
    }
  }
  
  public ajne a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
    {
      ajne localajne = (ajne)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localajne;
      if (localajne == null)
      {
        ??? = new ajne();
        ((ajne)???).jdField_a_of_type_Int = paramInt;
      }
      return ???;
    }
  }
  
  public ajnf a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_b_of_type_JavaUtilList.size()) {
      if (((ajnf)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (ajnf localajnf1 = (ajnf)this.jdField_b_of_type_JavaUtilList.get(i);; localajnf1 = null)
    {
      ajnf localajnf2 = localajnf1;
      if (localajnf1 == null)
      {
        localajnf2 = new ajnf();
        localajnf2.jdField_a_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          localajnf2.jdField_a_of_type_Short = 0;
        }
      }
      for (;;)
      {
        localajnf2.b = -32768;
        return localajnf2;
        i += 1;
        break;
        localajnf2.jdField_a_of_type_Short = -25161;
        continue;
        localajnf2.jdField_a_of_type_Short = -23324;
        continue;
        localajnf2.jdField_a_of_type_Short = -23447;
        continue;
        localajnf2.jdField_a_of_type_Short = -23323;
        continue;
        localajnf2.jdField_a_of_type_Short = -23316;
      }
    }
  }
  
  public ajnh a()
  {
    return this.jdField_a_of_type_Ajnh;
  }
  
  public List<ajmt> a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(false, bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "contact_top_entry_config"));
    }
    return c();
  }
  
  public short a(ajmt paramajmt, boolean paramBoolean)
  {
    if (paramajmt == null) {
      return 0;
    }
    paramajmt = a(paramajmt.jdField_a_of_type_Int);
    short s2 = paramajmt.jdField_a_of_type_Short;
    if ((paramBoolean) && (paramajmt.b != 1)) {}
    for (short s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "closeEntry switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(s2), Short.valueOf(s1) }));
      }
      if (s2 != 0) {
        ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(s2, s1);
      }
      return s2;
      if ((paramBoolean) || (paramajmt.b == 0)) {
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
    ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p();
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
      ajng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
      aocj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, "updateRedPoint mRedDotFlag: " + this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void a(ajmt paramajmt)
  {
    if (paramajmt == null) {
      return;
    }
    short[] arrayOfShort = new short[1];
    switch (paramajmt.jdField_a_of_type_Int)
    {
    default: 
      arrayOfShort[0] = paramajmt.jdField_a_of_type_Short;
    }
    for (;;)
    {
      ajnf localajnf = a(paramajmt.jdField_a_of_type_Int);
      localajnf.jdField_a_of_type_Short = arrayOfShort[0];
      a(localajnf);
      ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(arrayOfShort);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", new Object[] { Integer.valueOf(paramajmt.jdField_a_of_type_Int), Short.valueOf(arrayOfShort[0]), paramajmt.jdField_a_of_type_JavaLangString }));
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
  
  public void a(ajmt paramajmt, short paramShort)
  {
    if (paramajmt == null) {
      return;
    }
    ajnf localajnf = a(paramajmt.jdField_a_of_type_Short);
    if ((localajnf != null) && (localajnf.b != paramShort)) {
      localajnf.b = paramShort;
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
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", new Object[] { Integer.valueOf(paramajmt.jdField_a_of_type_Int), Short.valueOf(paramShort), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public void a(ajmx paramajmx)
  {
    if ((paramajmx != null) && (!this.jdField_c_of_type_JavaUtilList.contains(paramajmx))) {
      this.jdField_c_of_type_JavaUtilList.add(paramajmx);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqwh paramaqwh)
  {
    if (paramaqwh != null) {
      a(paramString, paramaqwh.jdField_a_of_type_JavaLangString, paramaqwh.jdField_a_of_type_Int, paramaqwh.jdField_b_of_type_Int);
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
          ajne localajne = new ajne();
          localajne.a((JSONObject)???);
          if (localajne.jdField_a_of_type_Int == 0) {
            break label141;
          }
          synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.put(localajne.jdField_a_of_type_Int, localajne);
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
      QLog.i("CTEntryMng", 4, "updateBindPhoneSwitchInfo needShow:" + paramBoolean1 + " net_gap:" + paramInt + " isNewUser:" + paramBoolean2 + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    bhhr.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).edit().putBoolean("contacts_bind_phone_canshow", paramBoolean1).putInt("contacts_bind_phone_next_gap", paramInt).putBoolean("contacts_bind_phone_is_new_user", paramBoolean2).commit();
    c(false);
    b();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public List<ajmt> b()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      ajmt localajmt = a(3);
      if (localajmt.a())
      {
        localajmt.jdField_e_of_type_Boolean = a(3).a();
        localajmt.jdField_d_of_type_Boolean = false;
        localArrayList.add(localajmt);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryListToShow size:" + localArrayList.size() + "  canBeShown:" + localajmt.jdField_c_of_type_Boolean + "  isUserClose:" + localajmt.jdField_e_of_type_Boolean);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mayknow_connections_switch", 4).edit().putInt("key_mayknow_connections_switch", paramInt).commit();
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
  }
  
  public void b(ajmx paramajmx)
  {
    if (paramajmx != null) {
      this.jdField_c_of_type_JavaUtilList.remove(paramajmx);
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
    anri localanri = (anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramBoolean) {}
    for (;;)
    {
      localanri.a((short)-23204, (short)i);
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
        if ((this.jdField_b_of_type_JavaUtilList.get(i) != null) && (((ajnf)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 3)) {
          bool1 = ((ajnf)this.jdField_b_of_type_JavaUtilList.get(i)).a();
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public List<ajmt> c()
  {
    return new ArrayList();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ajmt localajmt = a(5);
    boolean bool1 = localajmt.jdField_c_of_type_Boolean;
    int i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateFindFriendEntry selfBindState:" + i + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    if ((i == 1) || (i == 2))
    {
      SharedPreferences localSharedPreferences = bhhr.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      boolean bool2 = localSharedPreferences.getBoolean("contacts_bind_phone_canshow", false);
      localajmt.jdField_c_of_type_Boolean = bool2;
      if (bool2) {
        localajmt.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localSharedPreferences.getBoolean("contacts_bind_phone_is_new_user", false));
      }
      if (!localajmt.jdField_e_of_type_Boolean)
      {
        i = localSharedPreferences.getInt("contacts_bind_phone_next_gap", 300);
        long l1 = localSharedPreferences.getLong("contacts_bind_phone_last_time", -1L);
        long l2 = NetConnInfoCenter.getServerTime();
        if (QLog.isDevelopLevel()) {
          QLog.i("CTEntryMng", 4, "updateFindFriendEntry nextGap:" + i + " gap:" + (l2 - l1) + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        }
        if ((l1 < 0L) || (l2 - l1 >= i))
        {
          ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).A();
          localSharedPreferences.edit().putLong("contacts_bind_phone_last_time", l2).commit();
        }
      }
    }
    for (;;)
    {
      b(localajmt);
      if ((bool1 != localajmt.jdField_c_of_type_Boolean) && (localajmt.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajmt);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", new Object[] { Boolean.valueOf(localajmt.jdField_c_of_type_Boolean), localajmt.jdField_a_of_type_JavaLangString, localajmt.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() }));
      return;
      localajmt.jdField_c_of_type_Boolean = false;
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
        ajmt localajmt = (ajmt)localList.get(i);
        switch (localajmt.jdField_a_of_type_Int)
        {
        case 1: 
          arrayOfShort[i] = localajmt.jdField_a_of_type_Short;
          ajnf localajnf = a(localajmt.jdField_a_of_type_Int);
          localajnf.jdField_a_of_type_Short = arrayOfShort[i];
          a(localajnf);
          if (!QLog.isColorLevel()) {
            break label305;
          }
          str = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", new Object[] { str, Integer.valueOf(localajmt.jdField_a_of_type_Int), localajmt.jdField_a_of_type_JavaLangString, Short.valueOf(arrayOfShort[i]) });
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
      ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(arrayOfShort);
      return;
      label305:
      break label311;
      continue;
      label311:
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Ajnh.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.CONTACT_MANAGER)) && (this.jdField_a_of_type_Awza != null)) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this.jdField_a_of_type_Awza);
    }
    this.jdField_a_of_type_Awza = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmy
 * JD-Core Version:    0.7.0.1
 */