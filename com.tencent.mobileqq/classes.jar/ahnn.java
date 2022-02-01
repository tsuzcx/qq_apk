import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;

public class ahnn
  extends ProtocolDownloader.Adapter
{
  public static final String a;
  public Handler a;
  public EntityManager a;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "keyword_emotion/");
  }
  
  public ahnn()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getEntityManagerFactory().createEntityManager();
    }
    Looper localLooper = ThreadManager.getFileThreadLooper();
    if (localLooper != null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localLooper);
    }
  }
  
  public static String a(ahmw paramahmw)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramahmw.b())) {
      str = paramahmw.b();
    }
    while (TextUtils.isEmpty(paramahmw.a())) {
      return str;
    }
    return paramahmw.a();
  }
  
  public static boolean a(String paramString)
  {
    return ahns.a(paramString).exists();
  }
  
  public File a(String paramString, File paramFile, URLDrawableHandler paramURLDrawableHandler)
  {
    long l = System.currentTimeMillis();
    DownloadParams localDownloadParams = new DownloadParams();
    localDownloadParams.url = new URL(paramString);
    localDownloadParams.urlStr = paramString;
    String str1 = paramFile.getPath();
    String str2;
    if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecDrawableDownLoader", 2, "keyword emotion download: " + paramString + " -> " + str1);
      }
      str2 = str1 + ".tmp";
      localObject = new File(str2);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramURLDrawableHandler.publishProgress(0);
    }
    for (;;)
    {
      try
      {
        localObject = new FileOutputStream(str2);
        if (paramURLDrawableHandler == null) {
          break label276;
        }
      }
      catch (Exception paramURLDrawableHandler)
      {
        try
        {
          new HttpDownloader().downloadImage((OutputStream)localObject, localDownloadParams, paramURLDrawableHandler);
          ((FileOutputStream)localObject).close();
          paramURLDrawableHandler = new File(str2);
          if (!paramURLDrawableHandler.renameTo(paramFile))
          {
            FileUtils.copyFile(paramURLDrawableHandler, paramFile);
            paramURLDrawableHandler.delete();
          }
          l = System.currentTimeMillis() - l;
          paramURLDrawableHandler = new HashMap();
          paramURLDrawableHandler.put("sticker_url", paramString);
          if ((!paramFile.exists()) || (paramFile.length() <= 0L)) {
            break;
          }
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgDownload", true, l, 0L, paramURLDrawableHandler, "");
          return paramFile;
        }
        catch (Exception paramURLDrawableHandler)
        {
          for (;;)
          {
            paramURLDrawableHandler = (URLDrawableHandler)localObject;
          }
        }
        paramURLDrawableHandler = paramURLDrawableHandler;
        paramURLDrawableHandler = null;
      }
      paramURLDrawableHandler.close();
      label276:
      new File(str2).delete();
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgDownload", false, l, 0L, null, "");
    paramFile.delete();
    QLog.e("StickerRecDrawableDownLoader", 1, "downloadImage|file not exist or empty. filepath=" + str1);
    throw new IOException("File not Found. url: " + localDownloadParams.url);
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    try
    {
      paramDownloadParams = a((ahnm)paramDownloadParams.mExtraInfo);
      return a(paramDownloadParams);
    }
    catch (Exception paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return false;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = a((ahmw)paramDownloadParams.mExtraInfo);
    QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile");
    File localFile1 = ahns.a(paramDownloadParams);
    if ((localFile1.exists()) && (localFile1.length() > 0L))
    {
      QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile file.exists()");
      return localFile1;
    }
    localFile1.getParentFile().mkdirs();
    if ((bftf.a()) && (bftf.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bftf.b());
    }
    File localFile2 = new File(jdField_a_of_type_JavaLangString);
    if (!localFile2.exists()) {
      localFile2.mkdir();
    }
    return a(paramDownloadParams, localFile1, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahnn
 * JD-Core Version:    0.7.0.1
 */