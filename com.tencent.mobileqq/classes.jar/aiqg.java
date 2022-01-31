import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.HttpDownloaderParams;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public final class aiqg
  implements INetEngine.INetEngineListener
{
  long jdField_a_of_type_Long = 0L;
  
  public aiqg(URLDrawableHandler paramURLDrawableHandler, String paramString, HttpDownloaderParams paramHttpDownloaderParams) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " structMsgCover onUpdateProgeress totalLen = " + paramLong2 + " curOffset = " + paramLong1);
    }
    this.jdField_a_of_type_Long = paramLong2;
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, " structMsgCover download onResp result fileSize = " + this.jdField_a_of_type_Long + " file.path = " + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c + " resp.result = " + paramNetResp.jdField_a_of_type_Int);
    }
    if (paramNetResp.jdField_a_of_type_Int == 3) {
      return;
    }
    boolean bool1;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadSucceed(this.jdField_a_of_type_Long);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        HttpDownloader.a(bool1, new URL(this.jdField_a_of_type_JavaLangString), null, true, paramNetResp.c, paramNetResp.e, null, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloaderParams);
        return;
      }
      catch (Exception paramNetResp)
      {
        return;
      }
      bool2 = false;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramNetResp.jdField_a_of_type_Int);
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqg
 * JD-Core Version:    0.7.0.1
 */