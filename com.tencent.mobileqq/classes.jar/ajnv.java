import android.os.Handler;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class ajnv
  implements INetEngine.INetEngineListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  
  public ajnv(BeginnerGuideDownloadManager paramBeginnerGuideDownloadManager, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener Dowloading " + paramLong1 + "/" + paramLong2 + " " + 100L * paramLong1 / paramLong2);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp: " + paramNetResp.jdField_a_of_type_Int + ", desc: " + paramNetResp.jdField_a_of_type_JavaLangString);
    }
    if (paramNetResp.jdField_a_of_type_Int == 3) {
      return;
    }
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      paramNetResp = BeginnerGuideDownloadManager.a(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
      if (BeginnerGuideDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigBeginnerGuideDownloadManager).equalsIgnoreCase(paramNetResp))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success");
        }
        BeginnerGuideDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigBeginnerGuideDownloadManager, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success, md5 check failed");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1112);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp error");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnv
 * JD-Core Version:    0.7.0.1
 */