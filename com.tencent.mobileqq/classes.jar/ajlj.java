import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;
import tencent.im.PluginConfig.PluginConfig.GetResourceReqInfo;

public class ajlj
{
  public static int a(int paramInt)
  {
    return paramInt / 1000;
  }
  
  public static int a(ajli paramajli)
  {
    if (paramajli == null) {
      return 0;
    }
    return paramajli.jdField_a_of_type_Int * 1000 + paramajli.b;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.getPreferences().getInt("sp_key_leba_group_seq", 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("LebaHelper", 2, "getLebaGroup, seq=" + j);
    return j;
  }
  
  /* Error */
  public static List<ajli> a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 39
    //   8: iconst_2
    //   9: ldc 69
    //   11: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 74	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 75	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 23	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   26: ldc 77
    //   28: ldc 79
    //   30: invokeinterface 83 3 0
    //   35: astore_0
    //   36: new 85	org/json/JSONArray
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 88	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: iconst_0
    //   46: istore_1
    //   47: iload_1
    //   48: aload_0
    //   49: invokevirtual 92	org/json/JSONArray:length	()I
    //   52: if_icmpge +126 -> 178
    //   55: aload_0
    //   56: iload_1
    //   57: invokevirtual 96	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   60: astore 4
    //   62: aload 4
    //   64: invokevirtual 102	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   67: astore 5
    //   69: aload 5
    //   71: ifnull +150 -> 221
    //   74: new 10	ajli
    //   77: dup
    //   78: invokespecial 103	ajli:<init>	()V
    //   81: astore 6
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: aload 5
    //   88: invokevirtual 92	org/json/JSONArray:length	()I
    //   91: if_icmpge +89 -> 180
    //   94: aload 5
    //   96: iload_2
    //   97: invokevirtual 106	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   100: astore 7
    //   102: ldc 108
    //   104: aload 7
    //   106: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   109: ifeq +18 -> 127
    //   112: aload 6
    //   114: aload 4
    //   116: aload 7
    //   118: invokevirtual 118	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   121: putfield 121	ajli:jdField_a_of_type_Long	J
    //   124: goto +104 -> 228
    //   127: ldc 123
    //   129: aload 7
    //   131: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +18 -> 152
    //   137: aload 6
    //   139: aload 4
    //   141: aload 7
    //   143: invokevirtual 126	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   146: putfield 13	ajli:jdField_a_of_type_Int	I
    //   149: goto +79 -> 228
    //   152: ldc 128
    //   154: aload 7
    //   156: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: ifeq +69 -> 228
    //   162: aload 6
    //   164: aload 4
    //   166: aload 7
    //   168: invokevirtual 126	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   171: putfield 16	ajli:b	I
    //   174: goto +54 -> 228
    //   177: astore_0
    //   178: aload_3
    //   179: areturn
    //   180: aload_3
    //   181: aload 6
    //   183: invokeinterface 133 2 0
    //   188: pop
    //   189: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +29 -> 221
    //   195: ldc 39
    //   197: iconst_2
    //   198: new 41	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   205: ldc 79
    //   207: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 6
    //   212: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: istore_1
    //   225: goto -178 -> 47
    //   228: iload_2
    //   229: iconst_1
    //   230: iadd
    //   231: istore_2
    //   232: goto -147 -> 85
    //   235: astore 7
    //   237: goto -9 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramQQAppInterface	QQAppInterface
    //   46	179	1	i	int
    //   84	148	2	j	int
    //   21	160	3	localArrayList	ArrayList
    //   60	105	4	localJSONObject	JSONObject
    //   67	28	5	localJSONArray	JSONArray
    //   81	130	6	localajli	ajli
    //   100	67	7	str	String
    //   235	1	7	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	45	177	org/json/JSONException
    //   47	69	177	org/json/JSONException
    //   74	83	177	org/json/JSONException
    //   85	102	177	org/json/JSONException
    //   102	124	177	org/json/JSONException
    //   127	149	177	org/json/JSONException
    //   152	174	177	org/json/JSONException
    //   180	221	177	org/json/JSONException
    //   102	124	235	java/lang/Exception
    //   127	149	235	java/lang/Exception
    //   152	174	235	java/lang/Exception
  }
  
  public static Map<Long, ajli> a(List<ajli> paramList)
  {
    if (paramList == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ajli localajli = (ajli)paramList.next();
      if (localajli != null) {
        localHashMap.put(Long.valueOf(localajli.jdField_a_of_type_Long), localajli);
      }
    }
    return localHashMap;
  }
  
  public static PluginConfig.GetResourceReq a(int paramInt, List<LebaPluginInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramList.next();
        if (localLebaPluginInfo != null)
        {
          PluginConfig.GetResourceReqInfo localGetResourceReqInfo = new PluginConfig.GetResourceReqInfo();
          localGetResourceReqInfo.res_id.set((int)localLebaPluginInfo.uiResId);
          localGetResourceReqInfo.res_seq.set(localLebaPluginInfo.sResSeq);
          localArrayList.add(localGetResourceReqInfo);
        }
      }
    }
    paramList = new PluginConfig.GetResourceReq();
    paramList.plugin_type.set(4000);
    paramList.plugin_layout_seq.set(paramInt);
    paramList.reqinfo_list.set(localArrayList);
    return paramList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("sp_key_leba_upgrade_info", "4370");
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, String.format("update version, buildNum[%s]", new Object[] { "4370" }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "saveLebaGroupSeq，seq=" + paramInt);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("sp_key_leba_group_seq", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ajli> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "saveGroupInfo");
    }
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          ajli localajli = (ajli)paramList.next();
          if (localajli == null) {
            continue;
          }
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("uiResId", localajli.jdField_a_of_type_Long);
            localJSONObject.put("groudId", localajli.jdField_a_of_type_Int);
            localJSONObject.put("index", localajli.b);
            localJSONArray.put(localJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("LebaHelper", 2, "" + localajli);
            }
          }
          catch (JSONException paramList)
          {
            QLog.e("LebaHelper", 1, "saveGroupInfo, exp=", paramList);
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
      paramQQAppInterface.putString("sp_key_leba_group_info", localJSONArray.toString());
      paramQQAppInterface.commit();
    } while (!QLog.isColorLevel());
    QLog.i("LebaHelper", 2, "saveGroupInfo, result=" + true);
  }
  
  public static void a(List<amnq> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramList.size());
    localLinkedHashSet.addAll(paramList);
    paramList.clear();
    paramList.addAll(localLinkedHashSet);
  }
  
  public static void a(List<amnq> paramList1, List<amnq> paramList2)
  {
    Collections.sort(paramList2, new ajlk());
    paramList2 = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (paramList2.hasNext())
    {
      amnq localamnq1 = (amnq)paramList2.next();
      amnq localamnq2;
      if (a(localamnq1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority) != j)
      {
        localamnq2 = new amnq();
        if (paramList1.size() > 0) {
          if (i < 2)
          {
            ((amnq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
            label101:
            localamnq2.jdField_a_of_type_JavaLangString = "empty_normal";
            label109:
            paramList1.add(localamnq2);
            j = a(localamnq1.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.sPriority);
            localamnq1.jdField_a_of_type_Int = 1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        paramList1.add(localamnq1);
        break;
        ((amnq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
        break label101;
        localamnq2.jdField_a_of_type_JavaLangString = "empty_normal";
        break label109;
        i += 1;
        localamnq1.jdField_a_of_type_Int = 3;
      }
    }
    if (paramList1.size() > 0)
    {
      if (i < 2) {
        ((amnq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    ((amnq)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public static boolean a(amnq paramamnq)
  {
    if ((paramamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cDataType == 1) && (!TextUtils.isEmpty(paramamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
      return "qzone_feedlist".equals(paramamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().getString("sp_key_leba_upgrade_info", "");
    if (!"4370".equals(paramQQAppInterface)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, String.format("update version isAppUpgrade[%b], preBuildNum[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), paramQQAppInterface, "4370" }));
      }
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (7720L == paramLong)
      {
        int i = baig.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
        paramQQAppInterface = (anoe)paramQQAppInterface.getManager(264);
        if ((i == 1) && (paramQQAppInterface.b())) {}
        for (boolean bool = false;; bool = true) {
          return bool;
        }
      }
      if (7759L != paramLong) {
        break;
      }
      paramQQAppInterface = ((alxy)paramQQAppInterface.getManager(269)).a();
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.i < 1));
    return false;
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    boolean bool;
    if (paramBoolean)
    {
      paramQQAppInterface = (LebaPluginInfo)paramMap.get(Long.valueOf(paramLong));
      if ((paramQQAppInterface != null) && ((paramQQAppInterface == null) || (paramQQAppInterface.showInSimpleMode != 0))) {
        break label111;
      }
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "needShowRedDot, id=" + paramLong + ", isSimpleMode=" + paramBoolean + ", needShow=" + bool);
      }
      return bool;
      if (!afqa.a().a(paramQQAppInterface, paramLong)) {
        bool = false;
      } else {
        label111:
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajlj
 * JD-Core Version:    0.7.0.1
 */