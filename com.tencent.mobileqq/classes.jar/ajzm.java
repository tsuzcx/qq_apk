import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LebaHelper.1;
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

public class ajzm
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  public bcjj a;
  public QQAppInterface a;
  List<LebaPluginInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List<LebaPluginInfo> b;
  public boolean b;
  List<ResourcePluginListener> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=" + bbco.encodeToString("https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&from=dongtai&target=hot&_nav_txtclr=000000&_wwv=265&sonic=1".getBytes(), 0);
  }
  
  public ajzm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
  }
  
  private void a(int paramInt1, List<ajzn> paramList, int paramInt2)
  {
    int j = ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      QLog.i("LebaHelper", 1, String.format("saveLebaGroupInfo, localSeq=%d, seq=%d , groupListSize=%d, layoutType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2) }));
      if ((paramInt1 > 0) && (paramInt1 != j) && (paramList != null))
      {
        ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
        ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
        ajzo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2);
      }
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 8, null, true);
  }
  
  private void e()
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
      List localList = LebaPluginInfo.getAll((aukp)localObject1);
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          if ((localLebaPluginInfo != null) && (localLebaPluginInfo.cDataType == 1)) {
            LebaPluginInfo.remove((aukp)localObject1, localLebaPluginInfo.uiResId);
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
        ((aukp)localObject1).a();
      }
    }
    finally
    {
      ((aukp)localObject1).a();
    }
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  private void f()
  {
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    localLebaPluginInfo.strPkgName = "qzone_feedlist";
    localLebaPluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131717881);
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
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	ajzm:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 60	ajzm:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 135	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   14: ifne +19 -> 33
    //   17: invokestatic 262	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 77
    //   25: iconst_2
    //   26: ldc_w 264
    //   29: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload_0
    //   34: getfield 67	ajzm:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 67	ajzm:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   44: invokeinterface 267 1 0
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: invokespecial 269	ajzm:f	()V
    //   55: aload_0
    //   56: invokespecial 272	ajzm:h	()V
    //   59: aload_0
    //   60: getfield 54	ajzm:jdField_a_of_type_ArrayOfByte	[B
    //   63: astore_1
    //   64: aload_1
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 65	ajzm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   70: invokeinterface 267 1 0
    //   75: aload_0
    //   76: getfield 65	ajzm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: aload_0
    //   80: getfield 67	ajzm:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   83: invokeinterface 276 2 0
    //   88: pop
    //   89: aload_1
    //   90: monitorexit
    //   91: invokestatic 262	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +37 -> 131
    //   97: ldc 77
    //   99: iconst_2
    //   100: new 20	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 278
    //   110: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 65	ajzm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   117: invokeinterface 109 1 0
    //   122: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 283	ajzm:jdField_b_of_type_Boolean	Z
    //   136: return
    //   137: astore_2
    //   138: invokestatic 262	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -92 -> 49
    //   144: ldc 77
    //   146: iconst_2
    //   147: aload_2
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: goto -106 -> 49
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   168: goto -113 -> 55
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: aload_2
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	ajzm
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
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Map localMap = ajzo.a(ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if (localMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "loadServerPlugins, groupMap is null");
      }
      return;
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = LebaPluginInfo.getAll((aukp)???);
    ((aukp)???).a();
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
          ajzn localajzn = (ajzn)localMap.get(Long.valueOf(localLebaPluginInfo.uiResId));
          if (localajzn == null)
          {
            localStringBuilder.append(",remove ").append(localLebaPluginInfo);
            localList.remove(localLebaPluginInfo);
          }
          else
          {
            localStringBuilder.append(",add ").append(localLebaPluginInfo);
            localLebaPluginInfo.sPriority = ajzo.a(localajzn);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
      QLog.i("LebaHelper", 1, "loadServerPlugins data =  " + localStringBuilder);
      return;
      i -= 1;
    }
  }
  
  private void i()
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
    if (ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isAppUpgrade");
      ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (ajzt.c())
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isLocaleUpdated");
      ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    }
    try
    {
      ((aukp)localObject).a(LebaPluginInfo.class);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ArrayList localArrayList;
        LebaPluginInfo localLebaPluginInfo2;
        QLog.e("LebaHelper", 1, "getLebaPluginInfoReq exception", localThrowable);
        if (localObject != null) {
          ((aukp)localObject).a();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label295;
      }
      ((aukp)localObject).a();
    }
    int k = ajzo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
            break label298;
          }
        }
        label295:
        label298:
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
      return ajzo.a(i, localList);
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
  
  public void a(boolean paramBoolean, int paramInt1, List<ajzn> arg3, List<LebaPluginInfo> paramList1, int paramInt2)
  {
    Object localObject1 = new StringBuilder(" onGetPluginConfig, isSucc= ").append(paramBoolean).append(",layoutSeq=").append(paramInt1).append(",layoutType=").append(paramInt2);
    ((StringBuilder)localObject1).append(",groupList=");
    Object localObject2;
    Object localObject3;
    if (??? != null)
    {
      ((StringBuilder)localObject1).append(???.size());
      localObject2 = ???.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ajzn)((Iterator)localObject2).next();
        if (localObject3 != null) {
          ((StringBuilder)localObject1).append(((ajzn)localObject3).toString());
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
      localObject2 = ((aukp)localObject1).a();
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
        ((aukr)localObject2).a();
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
              break label932;
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
            LebaPluginInfo.persistOrReplace((aukp)localObject1, (LebaPluginInfo)localObject3);
            bool5 = true;
            bool2 = true;
          }
          bool3 = bool2;
          bool4 = bool5;
          bool6 = bool2;
          bool7 = bool5;
          if (((LebaPluginInfo)localObject3).state != 1) {
            break label932;
          }
          bool3 = bool2;
          bool4 = bool5;
          LebaPluginInfo.persistOrReplace((aukp)localObject1, (LebaPluginInfo)localObject3);
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
        ((aukr)localObject2).b();
        ((aukp)localObject1).a();
        bool1 = bool4;
        continue;
      }
      finally
      {
        ((aukr)localObject2).b();
        ((aukp)localObject1).a();
      }
      try
      {
        if (((LebaPluginInfo)localObject3).state != 2) {
          break label929;
        }
        LebaPluginInfo.remove((aukp)localObject1, ((LebaPluginInfo)localObject3).uiResId);
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
      ((aukr)localObject2).c();
      ((aukr)localObject2).b();
      ((aukp)localObject1).a();
      bool3 = paramBoolean;
      paramBoolean = bool2;
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, String.format("onGetPluginConfig saveDb end, saveDbSuc=%b, isAddNew=%b, isChange=%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
      }
      if (paramBoolean) {
        a(paramInt1, ???, paramInt2);
      }
      g();
      i();
      if (bool3) {
        ((akfh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(87)).a(1);
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
      label929:
      label932:
      bool1 = bool7;
      paramBoolean = bool6;
    }
  }
  
  public boolean a()
  {
    return ajzo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      ((arpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(128)).a();
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
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bcjj != null) {
      this.jdField_a_of_type_Bcjj.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzm
 * JD-Core Version:    0.7.0.1
 */