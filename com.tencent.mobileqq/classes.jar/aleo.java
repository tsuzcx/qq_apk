import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.transfile.FileDownloadFailedException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

public class aleo
  extends bame
{
  private BitmapFactory.Options a;
  protected BaseApplicationImpl a;
  
  public aleo(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inScreenDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int j;
    if (paramDownloadParams != null)
    {
      paramOutputStream = paramDownloadParams.getHeader("apollo_tasks");
      if (paramOutputStream != null)
      {
        j = Integer.parseInt(paramOutputStream.getValue());
        paramURLDrawableHandler = paramDownloadParams.getHeader("apollo_uin");
        paramOutputStream = "";
        if (paramURLDrawableHandler != null) {
          paramOutputStream = paramURLDrawableHandler.getValue();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null) {
          break label460;
        }
        paramOutputStream = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
        if (paramOutputStream != null) {
          break label234;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDownloader", 2, "downloadImage app is null");
        }
        throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
      }
      catch (Throwable paramOutputStream)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDownloader", 2, "exception:" + paramOutputStream.getMessage());
        }
        paramOutputStream = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT <= 10) {
          break label228;
        }
      }
      int i = 4;
      label150:
      String str = paramOutputStream.getSharedPreferences("Last_Login", i).getString("uin", "");
      if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {}
      for (paramURLDrawableHandler = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(str);; paramURLDrawableHandler = null)
      {
        paramOutputStream = paramURLDrawableHandler;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloDownloader", 2, "a second time: uin->" + str);
        paramOutputStream = paramURLDrawableHandler;
        break;
        label228:
        i = 0;
        break label150;
        label234:
        paramOutputStream = (akji)paramOutputStream.getManager(153);
        if (paramOutputStream != null)
        {
          if (j == 0)
          {
            paramDownloadParams = (ApolloActionPackage)paramDownloadParams.tag;
            if (paramDownloadParams != null) {}
          }
          do
          {
            return null;
            if (paramOutputStream.b(paramDownloadParams))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloDownloader", 2, "packageTab is exist pid=" + paramDownloadParams.packageId);
              }
              return paramOutputStream.a(paramDownloadParams);
            }
            if (paramOutputStream.a(paramDownloadParams)) {
              return paramOutputStream.a(paramDownloadParams);
            }
            throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
            paramDownloadParams = (ApolloActionData)paramDownloadParams.tag;
          } while (paramDownloadParams == null);
          if (paramOutputStream.b(paramDownloadParams, j))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloDownloader", 2, "actionRes is exist aid=" + paramDownloadParams.actionId);
            }
            return paramOutputStream.a(paramDownloadParams, j);
          }
          if (paramOutputStream.a(paramDownloadParams, j)) {
            return paramOutputStream.a(paramDownloadParams, j);
          }
          throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        }
        return new File(aljq.aX);
      }
      label460:
      paramOutputStream = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aleo
 * JD-Core Version:    0.7.0.1
 */