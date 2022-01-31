import android.text.TextUtils;
import com.tencent.mobileqq.ar.arengine.ARResourceDownload;
import com.tencent.mobileqq.ar.arengine.ARResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARResourceDownload.DownloadInfo;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class aadl
  implements INetEngine.INetEngineListener
{
  public aadl(ARResourceDownload paramARResourceDownload, ARResourceDownload.DownloadInfo paramDownloadInfo, ARResourceDownload.ARResourceDownloadCallback paramARResourceDownloadCallback) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((HttpNetReq)paramNetReq).jdField_a_of_type_JavaLangString + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$ARResourceDownloadCallback.a(paramLong1, paramLong2);
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
    }
    synchronized (ARResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload))
    {
      int i;
      if (ARResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload) != null)
      {
        i = 0;
        if (i < ARResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload).size())
        {
          if (!((ARResourceDownload.DownloadInfo)ARResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload).get(i)).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo.jdField_a_of_type_JavaLangString)) {
            break label268;
          }
          ARResourceDownload.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload).remove(i);
        }
      }
      if (paramNetResp.jdField_a_of_type_Int == 0)
      {
        ??? = new File(((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).c);
        String str = PortalUtils.a(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo.b))) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo.jdField_a_of_type_Int != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$ARResourceDownloadCallback.a(false, this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$ARResourceDownloadCallback.a(bool, this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadl
 * JD-Core Version:    0.7.0.1
 */