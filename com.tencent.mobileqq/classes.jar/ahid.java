import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.new_year_2014.Unisso.UniSsoServerRsp;
import tencent.im.new_year_2020.newyear_report.NYReportRsp;

public class ahid
  implements BusinessObserver
{
  public ahid(SpringHbReportManager paramSpringHbReportManager, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_report_SpringHbReportManager", 2, "[reportlistener] onReceive:type:" + paramInt + ",isSucc:" + paramBoolean + ",reqSeq:" + this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      try
      {
        SpringHbReportManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalReportSpringHbReportManager, this.jdField_a_of_type_Long);
        Object localObject = paramBundle.getByteArray("data");
        if ((localObject == null) || (!paramBoolean)) {
          break;
        }
        paramBundle = new Unisso.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject);
        long l = paramBundle.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("springHb_report_SpringHbReportManager", 1, new Object[] { "[reportlistener] unissoRes=", Long.valueOf(l) });
        }
        localObject = new newyear_report.NYReportRsp();
        ((newyear_report.NYReportRsp)localObject).mergeFrom(paramBundle.rspdata.get().toByteArray());
        paramInt = ((newyear_report.NYReportRsp)localObject).ret.get();
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("springHb_report_SpringHbReportManager", 2, "[reportlistener] onreceive success:" + localObject);
          }
          if (paramInt == 110002)
          {
            SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalReportSpringHbReportManager, true);
            SpringHbReportManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalReportSpringHbReportManager, this.jdField_a_of_type_Long, paramInt);
            paramInt = ((newyear_report.NYReportRsp)localObject).batchSize.get();
            SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalReportSpringHbReportManager, paramInt);
            paramInt = ((newyear_report.NYReportRsp)localObject).reportLevel.get();
            SpringHbReportManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalReportSpringHbReportManager, paramInt);
            paramInt = ((newyear_report.NYReportRsp)localObject).reportLevelTime.get();
            SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalReportSpringHbReportManager, paramInt);
          }
        }
        else
        {
          QLog.e("springHb_report_SpringHbReportManager", 1, "[reportlistener] onreceive fail:" + localObject);
          continue;
        }
        SpringHbReportManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalReportSpringHbReportManager, false);
      }
      catch (Throwable paramBundle)
      {
        paramBundle.printStackTrace();
        QLog.e("springHb_report_SpringHbReportManager", 1, "[reportlistener] onreceive fail exception:" + paramBundle.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahid
 * JD-Core Version:    0.7.0.1
 */