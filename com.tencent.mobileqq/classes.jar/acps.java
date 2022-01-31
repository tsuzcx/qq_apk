import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.ResourceDownloaderListener;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class acps
  implements HttpEngineTask.IHttpEngineTask
{
  public acps(ExtendFriendResourceDownloader paramExtendFriendResourceDownloader) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).a, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    int i = 1;
    Object localObject = ((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramNetResp.jdField_a_of_type_Int) }));
    }
    switch (paramNetResp.jdField_a_of_type_Int)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (ExtendFriendResourceDownloader.a(this.a) != null) {
        ExtendFriendResourceDownloader.a(this.a).a((String)localObject, paramNetResp.jdField_a_of_type_Long);
      }
      paramNetResp = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      boolean bool2 = ExtendFriendResourceDownloader.a(this.a, paramNetResp.c, ExtendFriendResourceDownloader.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(ExtendFriendResourceDownloader.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = ExtendFriendResourceDownloader.b(this.a, paramNetResp.c, ExtendFriendResourceDownloader.a());
        boolean bool3 = ExtendFriendResourceDownloader.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (ExtendFriendResourceDownloader.a(this.a) != null)
        {
          paramNetResp = ExtendFriendResourceDownloader.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            paramNetResp.a(bool1);
          }
        }
        else
        {
          paramNetResp = ExtendFriendReport.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          paramNetResp.b(bool1, i);
        }
      }
      for (;;)
      {
        ExtendFriendReport.a().a(bool2, 0);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label277;
        i = 0;
        break label282;
        if (QLog.isColorLevel()) {
          QLog.e("ExtendFriendResourceDownloader", 2, "onResp ResultOk file check invalid.");
        }
        ExtendFriendResourceDownloader.a(this.a, paramNetResp.c);
        if (ExtendFriendResourceDownloader.a(this.a) != null) {
          ExtendFriendResourceDownloader.a(this.a).a(false);
        }
      }
    } while (ExtendFriendResourceDownloader.a(this.a) == null);
    ExtendFriendResourceDownloader.a(this.a).a((String)localObject, -1L);
  }
  
  public void a(HttpEngineTask paramHttpEngineTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramHttpEngineTask.a.a }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acps
 * JD-Core Version:    0.7.0.1
 */