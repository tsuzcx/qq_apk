import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;

public class afia
  extends baqn
{
  public static final String a(int paramInt)
  {
    return aliu.d + paramInt + "/panelGif.gif";
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof Integer)))
    {
      paramDownloadParams = (Integer)paramDownloadParams.tag;
      paramOutputStream = new File(a(paramDownloadParams.intValue()));
      if (paramOutputStream.exists())
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.length());
        }
        return paramOutputStream;
      }
      paramOutputStream.getParentFile().mkdirs();
      if ((BaseApplicationImpl.sApplication != null) && (!bdin.g(BaseApplicationImpl.sApplication)) && (paramURLDrawableHandler != null)) {
        paramURLDrawableHandler.onFileDownloadFailed(0);
      }
      paramDownloadParams = new beae("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramDownloadParams + "/preview.gif", paramOutputStream);
      paramDownloadParams.b = 1;
      paramDownloadParams.p = false;
      if (beag.a(paramDownloadParams, null) == 0)
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.length());
        }
        return paramOutputStream;
      }
    }
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadFailed(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afia
 * JD-Core Version:    0.7.0.1
 */