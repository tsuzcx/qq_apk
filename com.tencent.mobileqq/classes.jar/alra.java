import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LebaHelper.1;
import com.tencent.mobileqq.app.LebaHelper.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.PluginConfig.PluginConfig.GetResourceReq;

public class alra
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  public beik a;
  public QQAppInterface a;
  List<LebaPluginInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List<LebaPluginInfo> b;
  public boolean b;
  List<ResourcePluginListener> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=" + bdbi.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0);
  }
  
  public alra(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
  }
  
  private void a(int paramInt1, List<alrb> paramList, int paramInt2, int paramInt3)
  {
    int j = alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      QLog.i("LebaHelper", 1, String.format("saveLebaGroupInfo, localSeq=%d, seq=%d , groupListSize=%d, layoutType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2) }));
      if ((paramInt1 > 0) && (paramInt1 != j) && (paramList != null))
      {
        alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
        alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
        alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2, paramInt3);
      }
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 8, null, true);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("mobileQQ", 0);
    } while (!localSharedPreferences.getBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true));
    if (QLog.isDevelopLevel()) {
      QLog.d("LebaHelper", 4, "clearLocalDBPlugin.local plugin.");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    try
    {
      List localList = LebaPluginInfo.getAll((awbw)localObject1);
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          if ((localLebaPluginInfo != null) && (localLebaPluginInfo.cDataType == 1)) {
            LebaPluginInfo.remove((awbw)localObject1, localLebaPluginInfo.uiResId);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((awbw)localObject1).a();
      }
    }
    finally
    {
      ((awbw)localObject1).a();
    }
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  private void g()
  {
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    localLebaPluginInfo.strPkgName = "qzone_feedlist";
    localLebaPluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718254);
    localLebaPluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localLebaPluginInfo.sResSubType = 2;
    localLebaPluginInfo.cCanChangeState = 0;
    localLebaPluginInfo.cDataType = 1;
    localLebaPluginInfo.uiResId = 0L;
    localLebaPluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "tab_qzone" });
    localLebaPluginInfo.showInSimpleMode = 1;
    this.jdField_b_of_type_JavaUtilList.add(localLebaPluginInfo);
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	alra:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 60	alra:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 137	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   14: ifne +19 -> 33
    //   17: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 77
    //   25: iconst_2
    //   26: ldc_w 266
    //   29: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload_0
    //   34: getfield 67	alra:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 67	alra:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   44: invokeinterface 269 1 0
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: invokespecial 271	alra:g	()V
    //   55: aload_0
    //   56: invokespecial 273	alra:i	()V
    //   59: aload_0
    //   60: getfield 54	alra:jdField_a_of_type_ArrayOfByte	[B
    //   63: astore_1
    //   64: aload_1
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 65	alra:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   70: invokeinterface 269 1 0
    //   75: aload_0
    //   76: getfield 65	alra:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: aload_0
    //   80: getfield 67	alra:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   83: invokeinterface 277 2 0
    //   88: pop
    //   89: aload_1
    //   90: monitorexit
    //   91: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +37 -> 131
    //   97: ldc 77
    //   99: iconst_2
    //   100: new 20	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 279
    //   110: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 65	alra:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   117: invokeinterface 110 1 0
    //   122: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 284	alra:jdField_b_of_type_Boolean	Z
    //   136: return
    //   137: astore_2
    //   138: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -92 -> 49
    //   144: ldc 77
    //   146: iconst_2
    //   147: aload_2
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: goto -106 -> 49
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   168: goto -113 -> 55
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: aload_2
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	alra
    //   163	10	1	localException1	Exception
    //   137	11	2	localException2	Exception
    //   158	4	2	localObject2	Object
    //   171	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	137	java/lang/Exception
    //   40	49	158	finally
    //   49	51	158	finally
    //   138	155	158	finally
    //   159	161	158	finally
    //   51	55	163	java/lang/Exception
    //   66	91	171	finally
    //   172	174	171	finally
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Map localMap = alrc.a(alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if (localMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "loadServerPlugins, groupMap is null");
      }
      return;
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = LebaPluginInfo.getAll((awbw)???);
    ((awbw)???).a();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localList != null) && (localList.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          alrb localalrb = (alrb)localMap.get(Long.valueOf(localLebaPluginInfo.uiResId));
          if (localalrb == null)
          {
            localStringBuilder.append(",remove ").append(localLebaPluginInfo);
            localList.remove(localLebaPluginInfo);
          }
          else
          {
            localStringBuilder.append(",add ").append(localLebaPluginInfo);
            localLebaPluginInfo.sPriority = alrc.a(localalrb);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
      QLog.i("LebaHelper", 1, "loadServerPlugins data =  " + localStringBuilder);
      return;
      i -= 1;
    }
  }
  
  private void j()
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
  
  public List<LebaPluginInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public PluginConfig.GetResourceReq a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "getLebaPluginInfoReq");
    }
    if (alrc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isAppUpgrade");
      alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (alrh.c())
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isLocaleUpdated");
      alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    }
    try
    {
      ((awbw)localObject).a(LebaPluginInfo.class);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ArrayList localArrayList;
        LebaPluginInfo localLebaPluginInfo2;
        QLog.e("LebaHelper", 1, "getLebaPluginInfoReq exception", localThrowable);
        if (localObject != null) {
          ((awbw)localObject).a();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label322;
      }
      ((awbw)localObject).a();
    }
    if (alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isChangeModel");
      alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
    int k = alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = LebaPluginInfo.getAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager());
    localArrayList = new ArrayList();
    if (localObject != null)
    {
      i = 0;
      if (i < ((List)localObject).size())
      {
        LebaPluginInfo localLebaPluginInfo1 = (LebaPluginInfo)((List)localObject).get(i);
        if ((localLebaPluginInfo1 != null) && (localLebaPluginInfo1.cDataType == 0))
        {
          localLebaPluginInfo2 = new LebaPluginInfo();
          if (k > 0) {
            break label325;
          }
        }
        label322:
        label325:
        for (int j = 0;; j = localLebaPluginInfo1.sResSeq)
        {
          localLebaPluginInfo2.sResSeq = j;
          localLebaPluginInfo2.uiResId = localLebaPluginInfo1.uiResId;
          localArrayList.add(localLebaPluginInfo2);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "" + localLebaPluginInfo1);
          }
          i += 1;
          break;
        }
      }
    }
    if (localList.isEmpty()) {}
    for (int i = 0;; i = k)
    {
      HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "getLebaPluginInfoReq, layoutSeq=" + i + ", lebaPluginInfos.size" + localList.size() + ", tempLebaList.size()=" + ((List)localObject).size());
      }
      return alrc.a(i, localList);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    a(new LebaHelper.1(this));
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramResourcePluginListener)) {
        this.c.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, List<alrb> arg3, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    Object localObject1 = new StringBuilder(" onGetPluginConfig, isSucc= ").append(paramBoolean).append(",layoutSeq=").append(paramInt1).append(",layoutType=").append(paramInt2).append(",pluginType=").append(paramInt3);
    ((StringBuilder)localObject1).append(",groupList=");
    Object localObject2;
    Object localObject3;
    if (??? != null)
    {
      ((StringBuilder)localObject1).append(???.size());
      localObject2 = ???.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (alrb)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((StringBuilder)localObject1).append(((alrb)localObject3).toString());
        }
      }
    }
    ((StringBuilder)localObject1).append(",resultInfos=");
    if (paramList1 != null)
    {
      ((StringBuilder)localObject1).append(paramList1.size());
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LebaPluginInfo)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((StringBuilder)localObject1).append(((LebaPluginInfo)localObject3).toString());
        }
      }
    }
    QLog.i("LebaHelper", 1, ((StringBuilder)localObject1).toString());
    boolean bool2;
    boolean bool1;
    boolean bool5;
    boolean bool3;
    boolean bool4;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = ((awbw)localObject1).a();
      bool2 = false;
      bool1 = false;
      bool5 = false;
      paramBoolean = false;
      bool3 = bool5;
      bool4 = bool2;
    }
    for (;;)
    {
      boolean bool6;
      boolean bool7;
      try
      {
        if (QLog.isColorLevel())
        {
          bool3 = bool5;
          bool4 = bool2;
          QLog.i("LebaHelper", 2, "onGetPluginConfig saveDb start");
        }
        bool3 = bool5;
        bool4 = bool2;
        ((awby)localObject2).a();
        bool3 = bool5;
        bool4 = bool2;
        paramList1 = paramList1.iterator();
        bool3 = paramBoolean;
        bool4 = bool1;
        if (paramList1.hasNext())
        {
          bool3 = paramBoolean;
          bool4 = bool1;
          localObject3 = (LebaPluginInfo)paramList1.next();
          if (localObject3 == null) {
            continue;
          }
          bool3 = paramBoolean;
          bool4 = bool1;
          if (QLog.isColorLevel())
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            QLog.i("LebaHelper", 2, "" + localObject3);
          }
          bool3 = paramBoolean;
          bool4 = bool1;
          if (((LebaPluginInfo)localObject3).sResSubType != 0)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            bool6 = paramBoolean;
            bool7 = bool1;
            if (((LebaPluginInfo)localObject3).sResSubType != 2) {
              break label945;
            }
          }
          bool2 = paramBoolean;
          bool5 = bool1;
          bool3 = paramBoolean;
          bool4 = bool1;
          if (((LebaPluginInfo)localObject3).state == 3)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            LebaPluginInfo.persistOrReplace((awbw)localObject1, (LebaPluginInfo)localObject3);
            bool5 = true;
            bool2 = true;
          }
          bool3 = bool2;
          bool4 = bool5;
          bool6 = bool2;
          bool7 = bool5;
          if (((LebaPluginInfo)localObject3).state != 1) {
            break label945;
          }
          bool3 = bool2;
          bool4 = bool5;
          LebaPluginInfo.persistOrReplace((awbw)localObject1, (LebaPluginInfo)localObject3);
          bool1 = true;
          paramBoolean = bool2;
        }
      }
      catch (Exception paramList1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "An exception was thrown. " + paramList1.toString());
        }
        paramBoolean = false;
        paramList1.printStackTrace();
        ((awby)localObject2).b();
        ((awbw)localObject1).a();
        bool1 = bool4;
        continue;
      }
      finally
      {
        ((awby)localObject2).b();
        ((awbw)localObject1).a();
      }
      try
      {
        if (((LebaPluginInfo)localObject3).state != 2) {
          break label942;
        }
        LebaPluginInfo.remove((awbw)localObject1, ((LebaPluginInfo)localObject3).uiResId);
        bool1 = true;
      }
      catch (Exception paramList1)
      {
        bool3 = paramBoolean;
        bool4 = bool1;
        continue;
        continue;
      }
      bool2 = true;
      bool3 = paramBoolean;
      bool4 = bool1;
      ((awby)localObject2).c();
      ((awby)localObject2).b();
      ((awbw)localObject1).a();
      bool3 = paramBoolean;
      paramBoolean = bool2;
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, String.format("onGetPluginConfig saveDb end, saveDbSuc=%b, isAddNew=%b, isChange=%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
      }
      if (paramBoolean) {
        a(paramInt1, ???, paramInt2, paramInt3);
      }
      h();
      j();
      if (bool3) {
        ((alwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(87)).a(1);
      }
      if (bool1)
      {
        ??? = new ArrayList(this.c).iterator();
        if (!???.hasNext()) {
          break;
        }
        paramList1 = (ResourcePluginListener)???.next();
        if (bool3)
        {
          ResourcePluginListener.a(paramList1, (byte)3, 1);
          continue;
        }
        ResourcePluginListener.a(paramList1, (byte)2, 1);
        continue;
      }
      ??? = this.c;
      paramInt1 = 0;
      try
      {
        while (paramInt1 < this.c.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.c.get(paramInt1), (byte)1, 1);
          paramInt1 += 1;
        }
        return;
      }
      finally {}
      synchronized (this.c)
      {
        this.jdField_a_of_type_Boolean = true;
        paramInt1 = 0;
        while (paramInt1 < this.c.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.c.get(paramInt1), (byte)-1, 1);
          paramInt1 += 1;
        }
        return;
      }
      label942:
      label945:
      bool1 = bool7;
      paramBoolean = bool6;
    }
  }
  
  public boolean a()
  {
    return alrc.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      ((atgf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(128)).a();
      this.jdField_a_of_type_Int += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "checkPluginConfig, mGetPluginConfigFail=" + this.jdField_a_of_type_Boolean + ", mPluginRetryTime=" + this.jdField_a_of_type_Int);
    }
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.c)
    {
      this.c.remove(paramResourcePluginListener);
      return;
    }
  }
  
  public void c()
  {
    if (alrc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.i("LebaHelper", 1, "checkModleAndRefesh getAllPluginList");
      ThreadManager.excute(new LebaHelper.2(this), 160, null, true);
    }
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Beik != null) {
      this.jdField_a_of_type_Beik.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alra
 * JD-Core Version:    0.7.0.1
 */