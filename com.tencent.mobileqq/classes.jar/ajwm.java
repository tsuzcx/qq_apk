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

public class ajwm
  implements aqzu, Manager
{
  protected int a;
  private final ajwv jdField_a_of_type_Ajwv;
  private ajwy jdField_a_of_type_Ajwy = new ajwn(this);
  private final SparseArray<ajwh> jdField_a_of_type_AndroidUtilSparseArray;
  private anuw jdField_a_of_type_Anuw = new ajwo(this);
  anyu jdField_a_of_type_Anyu = new ajwr(this);
  private asvt jdField_a_of_type_Asvt = new ajwp(this);
  private axfs jdField_a_of_type_Axfs = new ajwq(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final SparseArray<ajws> jdField_b_of_type_AndroidUtilSparseArray;
  private final List<ajwt> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private final List<ajwl> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public ajwm(QQAppInterface paramQQAppInterface)
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asvt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_Ajwv = new ajwv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajwy);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    paramQQAppInterface.a("confess_config", this);
    paramQQAppInterface.a("extend_friend_config_785", this);
    paramQQAppInterface.a("contact_top_entry_config", this);
    paramQQAppInterface.a("register_invitation_config", this);
    ThreadManager.excute(new CTEntryMng.1(this), 64, null, false);
    if (this.jdField_a_of_type_Axfs != null) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a(this.jdField_a_of_type_Axfs);
    }
  }
  
  public static int a(List<ajwh> paramList)
  {
    int i = 0;
    if ((paramList != null) && (i < paramList.size()))
    {
      ajwh localajwh = (ajwh)paramList.get(i);
      if (localajwh == null) {}
      while (!localajwh.jdField_d_of_type_Boolean)
      {
        i += 1;
        break;
      }
      return 1;
    }
    return -1;
  }
  
  private ajwt a(short paramShort)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (((ajwt)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Short == paramShort) {
        return (ajwt)this.jdField_b_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private String a(SparseArray<ajws> paramSparseArray)
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
          localObject2 = (ajws)paramSparseArray.valueAt(i);
          if ((((ajws)localObject2).jdField_a_of_type_Int > 4) && (!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(((ajws)localObject2).jdField_a_of_type_Int)))) {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "getEntryRedDotStr not save id: " + ((ajws)localObject2).jdField_a_of_type_Int);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((ajws)localObject2).a();
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
  
  private void a(ajwt paramajwt)
  {
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramajwt)) {
      this.jdField_b_of_type_JavaUtilList.add(paramajwt);
    }
  }
  
  private void a(SparseArray<ajws> paramSparseArray)
  {
    ThreadManager.excute(new CTEntryMng.2(this, paramSparseArray), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveEntryRedDot");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((ajwm)paramQQAppInterface.getManager(295)).a();
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
    //   7: getfield 274	ajwm:jdField_a_of_type_Boolean	Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: invokespecial 276	ajwm:d	()V
    //   22: aload_0
    //   23: invokespecial 279	ajwm:f	()V
    //   26: aload_0
    //   27: aload_2
    //   28: invokespecial 282	ajwm:b	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 284	ajwm:d	(Z)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 274	ajwm:jdField_a_of_type_Boolean	Z
    //   41: aload_0
    //   42: invokespecial 248	ajwm:b	()V
    //   45: aload_0
    //   46: invokespecial 286	ajwm:c	()V
    //   49: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -37 -> 15
    //   55: ldc 72
    //   57: iconst_2
    //   58: invokestatic 236	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   61: ldc_w 288
    //   64: iconst_3
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_1
    //   71: invokestatic 293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload_2
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: aload_0
    //   82: getfield 80	ajwm:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   85: invokevirtual 295	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   88: aastore
    //   89: invokestatic 244	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokestatic 78	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -80 -> 15
    //   98: astore_2
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_2
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	ajwm
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
    ((ajwh)???).jdField_a_of_type_Int = i;
    ((ajwh)???).jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", ((ajwh)???).jdField_a_of_type_JavaLangString);
    ((ajwh)???).jdField_c_of_type_JavaLangString = paramJSONObject.optString("AndroidMultiCardsIcon", ((ajwh)???).jdField_c_of_type_JavaLangString);
    ((ajwh)???).jdField_d_of_type_JavaLangString = paramJSONObject.optString("AndroidSingleCardIcon", ((ajwh)???).jdField_d_of_type_JavaLangString);
    ((ajwh)???).jdField_e_of_type_JavaLangString = paramJSONObject.optString("url", ((ajwh)???).jdField_e_of_type_JavaLangString);
    ((ajwh)???).jdField_a_of_type_Boolean = paramJSONObject.optBoolean("showRedDot", ((ajwh)???).jdField_a_of_type_Boolean);
    ((ajwh)???).jdField_b_of_type_Int = paramJSONObject.optInt("redDotVersion", ((ajwh)???).jdField_b_of_type_Int);
    ((ajwh)???).jdField_a_of_type_Short = ((short)paramJSONObject.optInt("switchFlag", ((ajwh)???).jdField_a_of_type_Short));
    switch (((ajwh)???).jdField_a_of_type_Int)
    {
    default: 
      ((ajwh)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajwh)???).jdField_b_of_type_JavaLangString);
      ((ajwh)???).jdField_b_of_type_Boolean = false;
      ((ajwh)???).jdField_c_of_type_Boolean = true;
      b((ajwh)???);
      paramJSONObject = a(((ajwh)???).jdField_a_of_type_Int);
      if (paramJSONObject.jdField_b_of_type_Int != ((ajwh)???).jdField_b_of_type_Int)
      {
        paramJSONObject.jdField_b_of_type_Int = ((ajwh)???).jdField_b_of_type_Int;
        paramJSONObject.jdField_a_of_type_Boolean = ((ajwh)???).jdField_a_of_type_Boolean;
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
        ((ajwh)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajwh)???).jdField_b_of_type_JavaLangString);
        ((ajwh)???).jdField_b_of_type_Boolean = false;
        ((ajwh)???).jdField_a_of_type_Short = -25161;
        break;
        ((ajwh)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajwh)???).jdField_b_of_type_JavaLangString);
        ((ajwh)???).jdField_b_of_type_Boolean = false;
        ((ajwh)???).jdField_e_of_type_JavaLangString = "native";
        ((ajwh)???).jdField_a_of_type_Short = -23324;
        break;
        ((ajwh)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajwh)???).jdField_b_of_type_JavaLangString);
        ((ajwh)???).jdField_b_of_type_Boolean = false;
        ((ajwh)???).jdField_a_of_type_Short = -23323;
        break;
        ((ajwh)???).jdField_b_of_type_Boolean = true;
        ((ajwh)???).jdField_e_of_type_JavaLangString = "native";
        ((ajwh)???).jdField_a_of_type_Short = -23447;
        break;
        ((ajwh)???).jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", ((ajwh)???).jdField_b_of_type_JavaLangString);
        ((ajwh)???).jdField_b_of_type_Boolean = false;
        ((ajwh)???).jdField_e_of_type_JavaLangString = "native";
        ((ajwh)???).jdField_a_of_type_Short = -23316;
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
        ajwl localajwl = (ajwl)this.jdField_c_of_type_JavaUtilList.get(i);
        if (localajwl != null) {
          localajwl.a();
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
  
  private void b(ajwh paramajwh)
  {
    if (paramajwh == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramajwh.jdField_a_of_type_Int, paramajwh);
      return;
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
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
    //   69: invokespecial 422	ajwm:a	(Lorg/json/JSONObject;)Z
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
    //   145: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   148: iload_3
    //   149: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokeinterface 261 2 0
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
    //   177: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   180: iconst_3
    //   181: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokeinterface 206 2 0
    //   189: ifne +17 -> 206
    //   192: aload_0
    //   193: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   196: iconst_3
    //   197: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokeinterface 261 2 0
    //   205: pop
    //   206: aload_0
    //   207: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   210: iconst_1
    //   211: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 206 2 0
    //   219: ifeq +8 -> 227
    //   222: aload_0
    //   223: iconst_0
    //   224: invokespecial 431	ajwm:e	(Z)V
    //   227: aload_0
    //   228: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   231: iconst_2
    //   232: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokeinterface 206 2 0
    //   240: ifeq +8 -> 248
    //   243: aload_0
    //   244: iconst_0
    //   245: invokespecial 433	ajwm:f	(Z)V
    //   248: aload_0
    //   249: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   252: iconst_3
    //   253: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokeinterface 206 2 0
    //   261: ifeq +8 -> 269
    //   264: aload_0
    //   265: iconst_0
    //   266: invokespecial 253	ajwm:g	(Z)V
    //   269: aload_0
    //   270: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   273: iconst_4
    //   274: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokeinterface 206 2 0
    //   282: ifeq +8 -> 290
    //   285: aload_0
    //   286: iconst_0
    //   287: invokespecial 436	ajwm:h	(Z)V
    //   290: aload_0
    //   291: getfield 100	ajwm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   294: iconst_5
    //   295: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: invokeinterface 206 2 0
    //   303: ifeq +8 -> 311
    //   306: aload_0
    //   307: iconst_0
    //   308: invokevirtual 438	ajwm:c	(Z)V
    //   311: iload_3
    //   312: ifeq +14 -> 326
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 89	ajwm:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   320: invokevirtual 442	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   323: invokespecial 444	ajwm:a	(Landroid/util/SparseArray;)V
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
    //   0	345	0	this	ajwm
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
      a(bhle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ct_entry_reddot_info"));
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
    ajwh localajwh;
    boolean bool;
    do
    {
      return;
      localajwh = a(1);
      bool = localajwh.jdField_c_of_type_Boolean;
      aqyl localaqyl = ((aqyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a();
      if (TextUtils.isEmpty(localajwh.jdField_a_of_type_JavaLangString)) {
        localajwh.jdField_a_of_type_JavaLangString = anzj.a(2131701534);
      }
      localajwh.jdField_c_of_type_Boolean = localaqyl.a();
      b(localajwh);
      if ((bool != localajwh.jdField_c_of_type_Boolean) && (localajwh.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajwh);
      }
    } while (!QLog.isColorLevel());
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", new Object[] { Boolean.valueOf(localajwh.jdField_c_of_type_Boolean), localajwh.jdField_a_of_type_JavaLangString, localajwh.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
  }
  
  private void f()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = bhle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ct_entry_user_setting");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          ajwt localajwt = new ajwt();
          localajwt.a(localJSONObject);
          if ((localajwt.jdField_a_of_type_Int != 0) && (localajwt.jdField_a_of_type_Short != 0)) {
            a(localajwt);
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
    ajwh localajwh = a(2);
    boolean bool = localajwh.jdField_c_of_type_Boolean;
    asvi localasvi = (asvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
    asvr localasvr = localasvi.b();
    if (localasvr != null) {
      localajwh.jdField_c_of_type_Boolean = localasvi.a(localasvr);
    }
    for (localajwh.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localasvi.d());; localajwh.jdField_a_of_type_JavaLangObject = null)
    {
      b(localajwh);
      if ((bool != localajwh.jdField_c_of_type_Boolean) && (localajwh.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajwh);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", new Object[] { Boolean.valueOf(localajwh.jdField_c_of_type_Boolean), localajwh.jdField_a_of_type_JavaLangString, localajwh.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool) }));
      return;
      localajwh.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ajwh localajwh = a(3);
    boolean bool3 = localajwh.jdField_c_of_type_Boolean;
    aobl localaobl = (aobl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    boolean bool2;
    boolean bool1;
    if (localaobl != null)
    {
      bool2 = localaobl.b("sp_mayknow_entry_list_recommend");
      bool1 = localaobl.b("sp_mayknow_entry_list_head");
    }
    for (;;)
    {
      localajwh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131698165);
      if ((bool1) && (!bool2)) {}
      for (localajwh.jdField_c_of_type_Boolean = true;; localajwh.jdField_c_of_type_Boolean = false)
      {
        if (localajwh.jdField_a_of_type_JavaLangObject == null) {
          localajwh.jdField_b_of_type_JavaLangString = "";
        }
        if ((paramBoolean) || ((localajwh.jdField_c_of_type_Boolean) && (localajwh.jdField_a_of_type_JavaLangObject == null))) {
          this.jdField_a_of_type_Ajwv.b();
        }
        b(localajwh);
        if ((bool3 != localajwh.jdField_c_of_type_Boolean) && (localajwh.jdField_c_of_type_Boolean) && (paramBoolean)) {
          a(localajwh);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", new Object[] { Boolean.valueOf(localajwh.jdField_c_of_type_Boolean), localajwh.jdField_a_of_type_JavaLangString, localajwh.jdField_b_of_type_JavaLangString, localajwh.jdField_a_of_type_JavaLangObject }));
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
    ajwh localajwh = a(4);
    boolean bool2 = localajwh.jdField_c_of_type_Boolean;
    if (BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localajwh.jdField_c_of_type_Boolean = bool1;
      if ((bool2 != localajwh.jdField_c_of_type_Boolean) && (localajwh.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajwh);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", new Object[] { Boolean.valueOf(localajwh.jdField_c_of_type_Boolean), localajwh.jdField_a_of_type_JavaLangString, localajwh.jdField_b_of_type_JavaLangString, localajwh.jdField_e_of_type_JavaLangString }));
      return;
    }
  }
  
  public ajwh a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      ajwh localajwh = (ajwh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localajwh;
      if (localajwh == null)
      {
        ??? = new ajwh();
        ((ajwh)???).jdField_a_of_type_Int = paramInt;
        ((ajwh)???).jdField_c_of_type_Boolean = false;
        ((ajwh)???).jdField_e_of_type_Boolean = false;
        ((ajwh)???).jdField_a_of_type_JavaLangObject = null;
      }
      return ???;
    }
  }
  
  public ajws a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
    {
      ajws localajws = (ajws)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
      ??? = localajws;
      if (localajws == null)
      {
        ??? = new ajws();
        ((ajws)???).jdField_a_of_type_Int = paramInt;
      }
      return ???;
    }
  }
  
  public ajwt a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_b_of_type_JavaUtilList.size()) {
      if (((ajwt)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int != paramInt) {}
    }
    for (ajwt localajwt1 = (ajwt)this.jdField_b_of_type_JavaUtilList.get(i);; localajwt1 = null)
    {
      ajwt localajwt2 = localajwt1;
      if (localajwt1 == null)
      {
        localajwt2 = new ajwt();
        localajwt2.jdField_a_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          localajwt2.jdField_a_of_type_Short = 0;
        }
      }
      for (;;)
      {
        localajwt2.b = -32768;
        return localajwt2;
        i += 1;
        break;
        localajwt2.jdField_a_of_type_Short = -25161;
        continue;
        localajwt2.jdField_a_of_type_Short = -23324;
        continue;
        localajwt2.jdField_a_of_type_Short = -23447;
        continue;
        localajwt2.jdField_a_of_type_Short = -23323;
        continue;
        localajwt2.jdField_a_of_type_Short = -23316;
      }
    }
  }
  
  public ajwv a()
  {
    return this.jdField_a_of_type_Ajwv;
  }
  
  public List<ajwh> a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(false, bhsi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "contact_top_entry_config"));
    }
    return c();
  }
  
  public short a(ajwh paramajwh, boolean paramBoolean)
  {
    if (paramajwh == null) {
      return 0;
    }
    paramajwh = a(paramajwh.jdField_a_of_type_Int);
    short s2 = paramajwh.jdField_a_of_type_Short;
    if ((paramBoolean) && (paramajwh.b != 1)) {}
    for (short s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "closeEntry switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(s2), Short.valueOf(s1) }));
      }
      if (s2 != 0) {
        ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(s2, s1);
      }
      return s2;
      if ((paramBoolean) || (paramajwh.b == 0)) {
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
    ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).p();
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
      ajwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
      aogf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, "updateRedPoint mRedDotFlag: " + this.jdField_a_of_type_Int);
      return;
    }
  }
  
  public void a(ajwh paramajwh)
  {
    if (paramajwh == null) {
      return;
    }
    short[] arrayOfShort = new short[1];
    switch (paramajwh.jdField_a_of_type_Int)
    {
    default: 
      arrayOfShort[0] = paramajwh.jdField_a_of_type_Short;
    }
    for (;;)
    {
      ajwt localajwt = a(paramajwh.jdField_a_of_type_Int);
      localajwt.jdField_a_of_type_Short = arrayOfShort[0];
      a(localajwt);
      ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(arrayOfShort);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", new Object[] { Integer.valueOf(paramajwh.jdField_a_of_type_Int), Short.valueOf(arrayOfShort[0]), paramajwh.jdField_a_of_type_JavaLangString }));
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
  
  public void a(ajwh paramajwh, short paramShort)
  {
    if (paramajwh == null) {
      return;
    }
    ajwt localajwt = a(paramajwh.jdField_a_of_type_Short);
    if ((localajwt != null) && (localajwt.b != paramShort)) {
      localajwt.b = paramShort;
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
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", new Object[] { Integer.valueOf(paramajwh.jdField_a_of_type_Int), Short.valueOf(paramShort), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public void a(ajwl paramajwl)
  {
    if ((paramajwl != null) && (!this.jdField_c_of_type_JavaUtilList.contains(paramajwl))) {
      this.jdField_c_of_type_JavaUtilList.add(paramajwl);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aqzt paramaqzt)
  {
    if (paramaqzt != null) {
      a(paramString, paramaqzt.jdField_a_of_type_JavaLangString, paramaqzt.jdField_a_of_type_Int, paramaqzt.jdField_b_of_type_Int);
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
          ajws localajws = new ajws();
          localajws.a((JSONObject)???);
          if (localajws.jdField_a_of_type_Int == 0) {
            break label141;
          }
          synchronized (this.jdField_b_of_type_AndroidUtilSparseArray)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.put(localajws.jdField_a_of_type_Int, localajws);
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
    bhsi.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).edit().putBoolean("contacts_bind_phone_canshow", paramBoolean1).putInt("contacts_bind_phone_next_gap", paramInt).putBoolean("contacts_bind_phone_is_new_user", paramBoolean2).commit();
    c(false);
    b();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public List<ajwh> b()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      ajwh localajwh = a(3);
      if (localajwh.a())
      {
        localajwh.jdField_e_of_type_Boolean = a(3).a();
        localajwh.jdField_d_of_type_Boolean = false;
        localArrayList.add(localajwh);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryListToShow size:" + localArrayList.size() + "  canBeShown:" + localajwh.jdField_c_of_type_Boolean + "  isUserClose:" + localajwh.jdField_e_of_type_Boolean);
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
  
  public void b(ajwl paramajwl)
  {
    if (paramajwl != null) {
      this.jdField_c_of_type_JavaUtilList.remove(paramajwl);
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
    anum localanum = (anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
    if (paramBoolean) {}
    for (;;)
    {
      localanum.a((short)-23204, (short)i);
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
        if ((this.jdField_b_of_type_JavaUtilList.get(i) != null) && (((ajwt)this.jdField_b_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == 3)) {
          bool1 = ((ajwt)this.jdField_b_of_type_JavaUtilList.get(i)).a();
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public List<ajwh> c()
  {
    return new ArrayList();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    ajwh localajwh = a(5);
    boolean bool1 = localajwh.jdField_c_of_type_Boolean;
    int i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateFindFriendEntry selfBindState:" + i + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    if ((i == 1) || (i == 2))
    {
      SharedPreferences localSharedPreferences = bhsi.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      boolean bool2 = localSharedPreferences.getBoolean("contacts_bind_phone_canshow", false);
      localajwh.jdField_c_of_type_Boolean = bool2;
      if (bool2) {
        localajwh.jdField_a_of_type_JavaLangObject = Boolean.valueOf(localSharedPreferences.getBoolean("contacts_bind_phone_is_new_user", false));
      }
      if (!localajwh.jdField_e_of_type_Boolean)
      {
        i = localSharedPreferences.getInt("contacts_bind_phone_next_gap", 300);
        long l1 = localSharedPreferences.getLong("contacts_bind_phone_last_time", -1L);
        long l2 = NetConnInfoCenter.getServerTime();
        if (QLog.isDevelopLevel()) {
          QLog.i("CTEntryMng", 4, "updateFindFriendEntry nextGap:" + i + " gap:" + (l2 - l1) + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        }
        if ((l1 < 0L) || (l2 - l1 >= i))
        {
          ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).A();
          localSharedPreferences.edit().putLong("contacts_bind_phone_last_time", l2).commit();
        }
      }
    }
    for (;;)
    {
      b(localajwh);
      if ((bool1 != localajwh.jdField_c_of_type_Boolean) && (localajwh.jdField_c_of_type_Boolean) && (paramBoolean)) {
        a(localajwh);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", new Object[] { Boolean.valueOf(localajwh.jdField_c_of_type_Boolean), localajwh.jdField_a_of_type_JavaLangString, localajwh.jdField_b_of_type_JavaLangString, Boolean.valueOf(bool1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() }));
      return;
      localajwh.jdField_c_of_type_Boolean = false;
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
        ajwh localajwh = (ajwh)localList.get(i);
        switch (localajwh.jdField_a_of_type_Int)
        {
        case 1: 
          arrayOfShort[i] = localajwh.jdField_a_of_type_Short;
          ajwt localajwt = a(localajwh.jdField_a_of_type_Int);
          localajwt.jdField_a_of_type_Short = arrayOfShort[i];
          a(localajwt);
          if (!QLog.isColorLevel()) {
            break label303;
          }
          str = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", new Object[] { str, Integer.valueOf(localajwh.jdField_a_of_type_Int), localajwh.jdField_a_of_type_JavaLangString, Short.valueOf(arrayOfShort[i]) });
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
      ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(arrayOfShort);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asvt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_Ajwv.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)) && (this.jdField_a_of_type_Axfs != null)) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).b(this.jdField_a_of_type_Axfs);
    }
    this.jdField_a_of_type_Axfs = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwm
 * JD-Core Version:    0.7.0.1
 */