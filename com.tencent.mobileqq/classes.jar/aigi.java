import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aigi
  implements INetEngine.INetEngineListener
{
  aigi(aigh paramaigh, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      GestureMgrAppDownload.a(i / this.jdField_a_of_type_Aigh.jdField_a_of_type_Int + this.jdField_a_of_type_Aigh.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
    if (this.jdField_a_of_type_Aigh.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_Aigh.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.jdField_a_of_type_JavaLangString, Integer.valueOf(paramNetResp.jdField_a_of_type_Int), Integer.valueOf(paramNetResp.c), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      paramNetResp = new File(localHttpNetReq.c);
      if (paramNetResp.exists())
      {
        try
        {
          String str = paramNetResp.getParent();
          FileUtils.a(localHttpNetReq.c, str, false);
          GestureMgrAppDownload.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          GestureMgrAppDownload.a(-1);
          this.jdField_a_of_type_Aigh.jdField_a_of_type_Boolean = false;
          return;
        }
        paramNetResp.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        GestureMgrAppDownload.a(100 / this.jdField_a_of_type_Aigh.jdField_a_of_type_Int + this.jdField_a_of_type_Aigh.b);
        paramNetResp = this.jdField_a_of_type_Aigh;
        paramNetResp.b += 100 / this.jdField_a_of_type_Aigh.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_Aigh.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_Aigh.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aigi
 * JD-Core Version:    0.7.0.1
 */