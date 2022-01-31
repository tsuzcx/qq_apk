import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.ar.config.WorldCupReport;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class aarc
  implements ResDownloadManager.IResDownloadListener
{
  int jdField_a_of_type_Int = 0;
  final long jdField_a_of_type_Long = AudioHelper.a();
  long jdField_b_of_type_Long = System.currentTimeMillis();
  
  public aarc(WorldCupMgr paramWorldCupMgr, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt == 100) || (paramInt == 0) || (Math.abs(paramInt - this.jdField_a_of_type_Int) >= 10)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_b_of_type_Long >= 1000L) {
        bool2 = true;
      }
      if ((QLog.isDevelopLevel()) && ((bool2) || (bool1))) {
        QLog.w(this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a, 1, "onDownloadUpdate, md5[" + paramString2 + "], index[" + this.jdField_b_of_type_Int + "], curPercent[" + paramInt + "], lastPercent[" + this.jdField_a_of_type_Int + "], needNotify[" + bool1 + "], needNotify2[" + bool2 + "]");
      }
      if (bool1) {
        this.jdField_a_of_type_Int = paramInt;
      }
      if (bool2) {
        this.jdField_b_of_type_Long = l;
      }
      if ((bool1) || (bool2)) {
        this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b(this.jdField_b_of_type_Int, paramInt);
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject instanceof aaqx))
    {
      paramString1 = (aaqx)paramObject;
      paramString1.jdField_c_of_type_Long = System.currentTimeMillis();
      paramString1.jdField_c_of_type_Boolean = false;
      QLog.w(this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a, 1, "onDownloadFinish, md5[" + paramString2 + "], errCode[" + paramInt + "], path[" + paramString3 + "], zipItem[" + paramString1 + "], request[" + paramString1.jdField_a_of_type_Long + "], Begin[" + paramString1.jdField_b_of_type_Long + "], End[" + paramString1.jdField_c_of_type_Long + "], 调度耗时[" + (paramString1.jdField_b_of_type_Long - paramString1.jdField_a_of_type_Long) + "], 下载耗时[" + (paramString1.jdField_c_of_type_Long - paramString1.jdField_b_of_type_Long) + "], fromPreCover[" + paramString1.jdField_c_of_type_Int + "], seq[" + this.jdField_a_of_type_Long + "], Uin[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "]");
      if (paramString1.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener == this) {
        paramString1.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener = null;
      }
      if (paramInt != 0) {
        break label345;
      }
      WorldCupConfigInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString1.jdField_a_of_type_Int, paramString1.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b(paramString1.jdField_a_of_type_Int, 100);
      int i = paramString1.jdField_a_of_type_Int;
      if (paramInt != 0) {
        break label333;
      }
      bool1 = true;
      if (paramString1.jdField_c_of_type_Int != 1) {
        break label339;
      }
      label270:
      WorldCupReport.a(i, bool1, bool2, paramString1.jdField_b_of_type_Boolean, paramString1.jdField_c_of_type_Long - paramString1.jdField_b_of_type_Long);
      paramString1.jdField_c_of_type_Int = -1;
    }
    for (;;)
    {
      if ((paramString1.jdField_a_of_type_Boolean) || (paramString1.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.jdField_b_of_type_Boolean, paramString1.jdField_a_of_type_Int + 1);
      }
      return;
      label333:
      bool1 = false;
      break;
      label339:
      bool2 = false;
      break label270;
      label345:
      if (paramInt == 100) {
        this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b(paramString1.jdField_a_of_type_Int, 100);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.b(paramString1.jdField_a_of_type_Int, -1);
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    QLog.w(this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupMgr.a, 1, "ZipItem.finalize, index[" + this.jdField_b_of_type_Int + "], seq[" + this.jdField_a_of_type_Long + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarc
 * JD-Core Version:    0.7.0.1
 */