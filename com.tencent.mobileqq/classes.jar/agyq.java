import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;

public class agyq
  extends ProtocolDownloader.Adapter
{
  public static final String a;
  public Handler a;
  public awgf a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bdzf.a(alof.aX + "keyword_emotion/");
  }
  
  public agyq()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      this.jdField_a_of_type_Awgf = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getEntityManagerFactory().createEntityManager();
    }
    Looper localLooper = ThreadManager.getFileThreadLooper();
    if (localLooper != null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(localLooper);
    }
  }
  
  public static String a(agyp paramagyp)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramagyp.e())) {
      str = paramagyp.e();
    }
    while (TextUtils.isEmpty(paramagyp.a())) {
      return str;
    }
    return paramagyp.a();
  }
  
  public static boolean a(String paramString)
  {
    return agyv.a(paramString).exists();
  }
  
  public File a(String paramString, File paramFile, URLDrawableHandler paramURLDrawableHandler)
  {
    long l = System.currentTimeMillis();
    DownloadParams localDownloadParams = new DownloadParams();
    localDownloadParams.url = new URL(paramString);
    localDownloadParams.urlStr = paramString;
    String str1 = paramFile.getPath();
    String str2;
    if (bdin.g(BaseApplicationImpl.getContext()))
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
          new batt().a((OutputStream)localObject, localDownloadParams, paramURLDrawableHandler);
          ((FileOutputStream)localObject).close();
          paramURLDrawableHandler = new File(str2);
          if (!paramURLDrawableHandler.renameTo(paramFile))
          {
            bdhb.a(paramURLDrawableHandler, paramFile);
            paramURLDrawableHandler.delete();
          }
          l = System.currentTimeMillis() - l;
          paramURLDrawableHandler = new HashMap();
          paramURLDrawableHandler.put("sticker_url", paramString);
          if ((!paramFile.exists()) || (paramFile.length() <= 0L)) {
            break;
          }
          azri.a(BaseApplication.getContext()).a(null, "StickerRecImgDownload", true, l, 0L, paramURLDrawableHandler, "");
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
    azri.a(BaseApplication.getContext()).a(null, "StickerRecImgDownload", false, l, 0L, null, "");
    paramFile.delete();
    QLog.e("StickerRecDrawableDownLoader", 1, "downloadImage|file not exist or empty. filepath=" + str1);
    throw new IOException("File not Found. url: " + localDownloadParams.url);
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    try
    {
      paramDownloadParams = a((agyp)paramDownloadParams.mExtraInfo);
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
    paramDownloadParams = a((agyp)paramDownloadParams.mExtraInfo);
    QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile");
    File localFile1 = agyv.a(paramDownloadParams);
    if ((localFile1.exists()) && (localFile1.length() > 0L))
    {
      QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile file.exists()");
      return localFile1;
    }
    localFile1.getParentFile().mkdirs();
    if ((bdeu.a()) && (bdeu.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bdeu.b());
    }
    File localFile2 = new File(jdField_a_of_type_JavaLangString);
    if (!localFile2.exists()) {
      localFile2.mkdir();
    }
    return a(paramDownloadParams, localFile1, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyq
 * JD-Core Version:    0.7.0.1
 */