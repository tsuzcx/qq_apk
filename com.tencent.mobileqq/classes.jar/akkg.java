import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class akkg
{
  private static akkg jdField_a_of_type_Akkg;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private File jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getCacheDir(), "qboss_ad");
  private Map<String, akke> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static akkg a()
  {
    if (jdField_a_of_type_Akkg == null) {}
    try
    {
      if (jdField_a_of_type_Akkg == null) {
        jdField_a_of_type_Akkg = new akkg();
      }
      return jdField_a_of_type_Akkg;
    }
    finally {}
  }
  
  private void a(akke paramakke, String paramString, boolean paramBoolean)
  {
    if ((paramakke == null) || (TextUtils.isEmpty(paramString)) || (paramakke.a == null)) {
      return;
    }
    int i = 0;
    label22:
    akkf localakkf;
    if (i < paramakke.a.size())
    {
      localakkf = (akkf)paramakke.a.valueAt(i);
      if ((localakkf != null) && (!TextUtils.isEmpty(localakkf.a))) {
        break label73;
      }
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label73:
      if (localakkf.a.equalsIgnoreCase(paramString)) {
        localakkf.a(paramBoolean);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "notifyBannerShow");
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.sendEmptyMessage(1062);
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "handle is null.");
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "notifyBannerHide");
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.sendEmptyMessage(1063);
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "handle is null.");
  }
  
  private void b(QQAppInterface paramQQAppInterface, akke paramakke)
  {
    if ((paramakke == null) || (paramakke.a == null) || (paramakke.a.size() == 0))
    {
      b(paramQQAppInterface);
      return;
    }
    paramQQAppInterface = new akkh(this, paramQQAppInterface, paramakke, paramakke.a.size());
    int i = 0;
    label47:
    akkf localakkf;
    if (i < paramakke.a.size())
    {
      localakkf = (akkf)paramakke.a.valueAt(i);
      if ((localakkf != null) && (!TextUtils.isEmpty(localakkf.a))) {
        break label94;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label94:
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader != null) {
        this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localakkf.a, localakkf.c, false, paramQQAppInterface);
      }
    }
  }
  
  public akke a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QbossADBannerConfigManager", 1, "getQBossADBannerConfig uin is empty. return.");
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      ??? = bkzh.a(BaseApplicationImpl.getContext(), paramString);
      String str = bkzh.a(paramString);
      if (!TextUtils.isEmpty(str))
      {
        Object localObject2 = ((SharedPreferences)???).getString("splash_union_banner_type_" + str, "-1");
        localObject2 = akke.a(new TianShuAccess.AdItem(), (String)localObject2);
        ((akke)localObject2).a((SharedPreferences)???, str);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject2);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (akke)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + File.separator + Utils.Crc64String(paramString) + paramString.substring(paramString.lastIndexOf("."));
  }
  
  public void a(long paramLong)
  {
    a(paramLong, 2741);
    a(paramLong, 2742);
  }
  
  public void a(long paramLong, int paramInt)
  {
    long l2 = NetConnInfoCenter.getServerTime();
    long l1 = paramLong;
    if (paramLong > l2 + 86400L)
    {
      paramLong = l2 + 86400L;
      l1 = paramLong;
      if (QLog.isDevelopLevel())
      {
        QLog.i("QbossADBannerConfigManager", 4, "saveQbossNextRequestTime nextRequestTime upper limit 24 " + paramLong);
        l1 = paramLong;
      }
    }
    SharedPreferences.Editor localEditor = azid.a().edit();
    localEditor.putLong("qbossNextRequestTime_" + paramInt, l1);
    localEditor.commit();
    if (QLog.isDevelopLevel()) {
      QLog.i("QbossADBannerConfigManager", 4, "saveQbossNextRequestTime appid = " + paramInt + " nextRequestTime =  " + l1);
    }
  }
  
  public void a(akke paramakke, String paramString)
  {
    localMap = this.jdField_a_of_type_JavaUtilMap;
    if (paramakke == null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramakke);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, akke paramakke)
  {
    if (paramQQAppInterface == null)
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify app is null. return.");
      return;
    }
    String str = paramQQAppInterface.getCurrentUin();
    if (TextUtils.isEmpty(str))
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify uin is empty. return.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify mIsDownloading = " + this.jdField_a_of_type_Boolean + " multi banner show");
      return;
    }
    a(paramakke, str);
    a(paramQQAppInterface, paramakke, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, akke paramakke, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (paramakke == null)
      {
        QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify QBossADBannerConfigInfo = null notifyBannerHide");
        b(paramQQAppInterface);
        return;
      }
      if (!paramakke.b()) {
        break;
      }
    } while (!paramBoolean);
    QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist exist , notifyBannerShow ");
    a(paramQQAppInterface);
    return;
    QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist is not exist , start downloadFile ");
    this.jdField_a_of_type_Boolean = true;
    b(paramQQAppInterface, paramakke);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QbossADBannerConfigManager", 1, "removeQBossADBannerConfig uin is empty. return.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    long l = azid.a().getLong("qbossNextRequestTime_" + paramInt, 0L);
    return NetConnInfoCenter.getServerTime() > l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkg
 * JD-Core Version:    0.7.0.1
 */