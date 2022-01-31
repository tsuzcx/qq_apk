import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class ajip
{
  private static ajip jdField_a_of_type_Ajip;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private File jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getCacheDir(), "qboss_ad");
  private Map<String, ajin> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static ajip a()
  {
    if (jdField_a_of_type_Ajip == null) {}
    try
    {
      if (jdField_a_of_type_Ajip == null) {
        jdField_a_of_type_Ajip = new ajip();
      }
      return jdField_a_of_type_Ajip;
    }
    finally {}
  }
  
  private void a(ajin paramajin, String paramString, boolean paramBoolean)
  {
    if ((paramajin == null) || (TextUtils.isEmpty(paramString)) || (paramajin.a == null)) {
      return;
    }
    int i = 0;
    label22:
    ajio localajio;
    if (i < paramajin.a.size())
    {
      localajio = (ajio)paramajin.a.valueAt(i);
      if ((localajio != null) && (!TextUtils.isEmpty(localajio.a))) {
        break label73;
      }
    }
    for (;;)
    {
      i += 1;
      break label22;
      break;
      label73:
      if (localajio.a.equalsIgnoreCase(paramString)) {
        localajio.a(paramBoolean);
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
  
  private void b(QQAppInterface paramQQAppInterface, ajin paramajin)
  {
    if ((paramajin == null) || (paramajin.a == null) || (paramajin.a.size() == 0))
    {
      b(paramQQAppInterface);
      return;
    }
    paramQQAppInterface = new ajiq(this, paramQQAppInterface, paramajin, paramajin.a.size());
    int i = 0;
    label47:
    ajio localajio;
    if (i < paramajin.a.size())
    {
      localajio = (ajio)paramajin.a.valueAt(i);
      if ((localajio != null) && (!TextUtils.isEmpty(localajio.a))) {
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
        this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(localajio.a, localajio.c, false, paramQQAppInterface);
      }
    }
  }
  
  public ajin a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QbossADBannerConfigManager", 1, "getQBossADBannerConfig uin is empty. return.");
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (ajin)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    SharedPreferences.Editor localEditor = awzq.a().edit();
    localEditor.putLong("qbossNextRequestTime_" + paramInt, l1);
    localEditor.commit();
    if (QLog.isDevelopLevel()) {
      QLog.i("QbossADBannerConfigManager", 4, "saveQbossNextRequestTime appid = " + paramInt + " nextRequestTime =  " + l1);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ajin paramajin)
  {
    if (paramQQAppInterface == null)
    {
      QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify app is null. return.");
      return;
    }
    String str = paramQQAppInterface.c();
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
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (paramajin == null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilMap.remove(str);
        if (paramajin != null) {
          break;
        }
        QLog.i("QbossADBannerConfigManager", 1, "saveQBossADBannerConfigAndNotify QBossADBannerConfigInfo = null notifyBannerHide");
        b(paramQQAppInterface);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(str, paramajin);
    }
    if (paramajin.b())
    {
      QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist exist , notifyBannerShow ");
      a(paramQQAppInterface);
      return;
    }
    QLog.i("QbossADBannerConfigManager", 1, "checkIsFileExist is not exist , start downloadFile ");
    this.jdField_a_of_type_Boolean = true;
    b(paramQQAppInterface, paramajin);
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
    long l = awzq.a().getLong("qbossNextRequestTime_" + paramInt, 0L);
    return NetConnInfoCenter.getServerTime() > l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajip
 * JD-Core Version:    0.7.0.1
 */