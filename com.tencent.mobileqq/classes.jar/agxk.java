import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class agxk
  implements Handler.Callback, Manager
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ajwh jdField_a_of_type_Ajwh;
  private ajwk jdField_a_of_type_Ajwk;
  private akie jdField_a_of_type_Akie;
  private akif jdField_a_of_type_Akif = new agxl(this);
  private babk jdField_a_of_type_Babk;
  private begr jdField_a_of_type_Begr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private volatile boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public agxk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajwh = new ajwh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Ajwh.a();
    this.jdField_a_of_type_Akie = ((akie)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(148));
    this.jdField_a_of_type_Ajwk = new ajwk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ajwh);
    this.jdField_a_of_type_Babk = new babk(ThreadManagerV2.getSubThreadLooper(), this);
    this.jdField_a_of_type_Babk.sendEmptyMessage(1);
    this.jdField_a_of_type_Long = a();
    this.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akif);
    b();
  }
  
  private SharedPreferences a()
  {
    SharedPreferences localSharedPreferences = null;
    try
    {
      QQAppInterface localQQAppInterface = a();
      if (localQQAppInterface != null) {
        localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("AppletsFolderManager" + localQQAppInterface.getCurrentAccountUin(), 0);
      }
      return localSharedPreferences;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AppletsFolderManager", 2, "getSharedPreferences error!: ", localThrowable);
    }
    return null;
  }
  
  private QQAppInterface a()
  {
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = BaseApplicationImpl.getApplication();
      if (localObject2 == null) {
        break label69;
      }
      localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
      if (!(localObject2 instanceof QQAppInterface)) {
        break label69;
      }
      localObject2 = (QQAppInterface)localObject2;
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AppletsFolderManager", 2, "getQQAppInterface error!: ", localThrowable);
        Object localObject3 = localObject1;
      }
    }
    localObject2 = localObject1;
    if (localObject2 == null) {
      QLog.e("AppletsFolderManager", 2, "getQQAppInterface error: return null!");
    }
    return localObject2;
  }
  
  /* Error */
  public static com.tencent.mobileqq.applets.data.AppletInfo a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 164	java/io/ObjectInputStream
    //   3: dup
    //   4: new 166	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 169	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: invokespecial 172	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 176	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_1
    //   24: astore_0
    //   25: aload_2
    //   26: instanceof 178
    //   29: ifeq +27 -> 56
    //   32: aload_1
    //   33: astore_0
    //   34: aload_2
    //   35: checkcast 178	com/tencent/mobileqq/applets/data/AppletInfo
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 181	java/io/ObjectInputStream:close	()V
    //   47: aload_2
    //   48: areturn
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   54: aload_2
    //   55: areturn
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 181	java/io/ObjectInputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   71: goto -7 -> 64
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: aload_2
    //   80: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 181	java/io/ObjectInputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: invokevirtual 185	java/lang/ClassNotFoundException:printStackTrace	()V
    //   110: aload_1
    //   111: ifnull -20 -> 91
    //   114: aload_1
    //   115: invokevirtual 181	java/io/ObjectInputStream:close	()V
    //   118: goto -27 -> 91
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   126: goto -35 -> 91
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 181	java/io/ObjectInputStream:close	()V
    //   140: aload_1
    //   141: athrow
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_1
    //   151: goto -19 -> 132
    //   154: astore_2
    //   155: goto -51 -> 104
    //   158: astore_2
    //   159: goto -82 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramArrayOfByte	byte[]
    //   15	100	1	localObjectInputStream	java.io.ObjectInputStream
    //   129	12	1	localObject1	Object
    //   150	1	1	localObject2	Object
    //   22	33	2	localObject3	Object
    //   74	6	2	localIOException1	java.io.IOException
    //   101	6	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   154	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   158	1	2	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/io/IOException
    //   60	64	66	java/io/IOException
    //   0	16	74	java/io/IOException
    //   87	91	93	java/io/IOException
    //   0	16	101	java/lang/ClassNotFoundException
    //   114	118	121	java/io/IOException
    //   0	16	129	finally
    //   136	140	142	java/io/IOException
    //   18	23	150	finally
    //   25	32	150	finally
    //   34	39	150	finally
    //   79	83	150	finally
    //   106	110	150	finally
    //   18	23	154	java/lang/ClassNotFoundException
    //   25	32	154	java/lang/ClassNotFoundException
    //   34	39	154	java/lang/ClassNotFoundException
    //   18	23	158	java/io/IOException
    //   25	32	158	java/io/IOException
    //   34	39	158	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(com.tencent.mobileqq.applets.data.AppletInfo paramAppletInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: new 192	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 193	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_3
    //   20: new 195	java/io/ObjectOutputStream
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 198	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 202	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload_2
    //   37: astore_1
    //   38: aload_3
    //   39: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload_2
    //   46: ifnull -36 -> 10
    //   49: aload_2
    //   50: invokevirtual 207	java/io/ObjectOutputStream:close	()V
    //   53: aload_0
    //   54: areturn
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   71: aload 4
    //   73: astore_1
    //   74: aload_0
    //   75: ifnull -65 -> 10
    //   78: aload_0
    //   79: invokevirtual 207	java/io/ObjectOutputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 207	java/io/ObjectOutputStream:close	()V
    //   102: aload_0
    //   103: athrow
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   109: goto -7 -> 102
    //   112: astore_0
    //   113: goto -19 -> 94
    //   116: astore_3
    //   117: aload_2
    //   118: astore_0
    //   119: goto -54 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramAppletInfo	com.tencent.mobileqq.applets.data.AppletInfo
    //   9	36	1	localObject1	Object
    //   55	2	1	localIOException1	java.io.IOException
    //   66	33	1	localObject2	Object
    //   104	2	1	localIOException2	java.io.IOException
    //   28	90	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   19	20	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   62	6	3	localIOException3	java.io.IOException
    //   116	1	3	localIOException4	java.io.IOException
    //   1	71	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	53	55	java/io/IOException
    //   12	29	62	java/io/IOException
    //   78	82	84	java/io/IOException
    //   12	29	91	finally
    //   98	102	104	java/io/IOException
    //   31	36	112	finally
    //   38	43	112	finally
    //   67	71	112	finally
    //   31	36	116	java/io/IOException
    //   38	43	116	java/io/IOException
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    int j = 1;
    int i = j;
    String str;
    if (paramMessage != null)
    {
      str = paramMessage.getExtInfoFromExtStr(awav.x);
      if (TextUtils.isEmpty(str)) {
        break label61;
      }
    }
    label61:
    for (i = Integer.valueOf(str).intValue();; i = 1)
    {
      if (paramMessage.time < this.jdField_a_of_type_Long)
      {
        i = j;
        if (this.jdField_a_of_type_Boolean) {
          i = 2;
        }
        return i;
      }
      return i;
    }
  }
  
  public int a(QQMessageFacade.Message paramMessage, RecentUser paramRecentUser)
  {
    int j = 1;
    int i = j;
    if (paramMessage != null)
    {
      paramMessage = paramMessage.getExtInfoFromExtStr(awav.x);
      if (TextUtils.isEmpty(paramMessage)) {
        break label65;
      }
    }
    label65:
    for (i = Integer.valueOf(paramMessage).intValue();; i = 1)
    {
      if ((paramRecentUser != null) && (paramRecentUser.lastmsgtime < this.jdField_a_of_type_Long))
      {
        i = j;
        if (this.jdField_a_of_type_Boolean) {
          i = 2;
        }
        return i;
      }
      return i;
    }
  }
  
  public long a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return 0L;
    }
    this.jdField_a_of_type_Long = localSharedPreferences.getLong("applets_setting_main_switch_time", 0L);
    return this.jdField_a_of_type_Long;
  }
  
  public AppletsAccountInfo a(String paramString)
  {
    paramString = this.jdField_a_of_type_Ajwk.a(paramString);
    if ((paramString != null) && (paramString.appInfoDetail != null)) {
      paramString.appInfo = a(paramString.appInfoDetail);
    }
    return paramString;
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_main_des", "");
  }
  
  public Set<String> a()
  {
    Object localObject1 = null;
    Object localObject2 = a();
    if (localObject2 == null) {}
    do
    {
      return localObject1;
      localObject2 = ((SharedPreferences)localObject2).getStringSet("applets_app_list_unreceive_msg_appids", null);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("AppletsFolderManager", 2, "getAppletsSettingUnReceiveMsgAppids: " + localObject2);
    return localObject2;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Ajwk.c();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_b_of_type_Long = paramLong;
    localSharedPreferences.edit().putLong("applets_detail_last_request_time", paramLong).apply();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.runOnUiThread(new AppletsFolderManager.2(this, paramContext, paramString1, paramString2));
  }
  
  public void a(AppletsAccountInfo paramAppletsAccountInfo)
  {
    if (paramAppletsAccountInfo != null)
    {
      paramAppletsAccountInfo.appInfoDetail = a(paramAppletsAccountInfo.appInfo);
      this.jdField_a_of_type_Ajwk.a(paramAppletsAccountInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletsFolderManager", 2, "putAppletAccountInfo: " + paramAppletsAccountInfo);
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    if (paramRecentUser != null)
    {
      paramRecentUser = paramRecentUser.uin;
      this.jdField_a_of_type_Babk.obtainMessage(3, 0, 0, paramRecentUser).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_main_des", paramString).apply();
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    localSharedPreferences.edit().putString("applets_detail_request_answer", paramString).putInt("applets_detail_request_duration", this.jdField_a_of_type_Int).apply();
  }
  
  public void a(Set<String> paramSet)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {}
    for (;;)
    {
      return;
      if ((paramSet == null) || (paramSet.size() < 1)) {
        localSharedPreferences.edit().remove("applets_app_list_unreceive_msg_appids").apply();
      }
      while (QLog.isColorLevel())
      {
        QLog.i("AppletsFolderManager", 2, "updateAppletsSettingUnReceiveMsgAppids: " + paramSet);
        return;
        localSharedPreferences.edit().putStringSet("applets_app_list_unreceive_msg_appids", paramSet).apply();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    this.jdField_a_of_type_Boolean = paramBoolean;
    localSharedPreferences.edit().putBoolean("applets_setting_main_switch", paramBoolean).putLong("applets_setting_main_switch_time", NetConnInfoCenter.getServerTime()).apply();
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return false;
    }
    this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("applets_setting_main_switch", false);
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_app_list_des", "");
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("applets_detail_request_answer", "");
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("applets_detail_request_duration", 0);
    this.jdField_b_of_type_Long = localSharedPreferences.getLong("applets_detail_last_request_time", 0L);
  }
  
  public void b(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_app_list_des", paramString).apply();
  }
  
  public String c()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_main_title", "");
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Set localSet = a();
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    if (QLog.isColorLevel()) {
      QLog.i("AppletsFolderManager", 2, "addAppletsSettingUnReceiveMsgAppid: " + paramString);
    }
    ((Set)localObject).add(paramString);
    a((Set)localObject);
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Set localSet;
    do
    {
      do
      {
        return;
        localSet = a();
      } while ((localSet == null) || (localSet.size() < 1));
      if (QLog.isColorLevel()) {
        QLog.i("AppletsFolderManager", 2, "removeAppletsSettingUnReceiveMsgAppid: " + paramString);
      }
    } while (!localSet.remove(paramString));
    a(localSet);
  }
  
  public void e(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_main_title", paramString).apply();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      a();
      return true;
      paramMessage = ((List)paramMessage.obj).iterator();
      while (paramMessage.hasNext()) {
        a((AppletsAccountInfo)paramMessage.next());
      }
      paramMessage = (String)paramMessage.obj;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Ajwk.c();
        this.jdField_b_of_type_Boolean = true;
      }
    } while ((a(paramMessage) != null) && (this.jdField_b_of_type_Long + this.jdField_a_of_type_Int > NetConnInfoCenter.getServerTime()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramMessage));
    this.jdField_a_of_type_Akie.a(localArrayList);
    a(NetConnInfoCenter.getServerTime());
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsFolderManager", 2, "onDestroy.");
    }
    this.jdField_a_of_type_Babk.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Ajwh != null) {
      this.jdField_a_of_type_Ajwh.onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akif);
    }
    if (this.jdField_a_of_type_Ajwk != null) {
      this.jdField_a_of_type_Ajwk.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agxk
 * JD-Core Version:    0.7.0.1
 */