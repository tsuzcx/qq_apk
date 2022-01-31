import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.PtvGuideUploader;
import com.tencent.mobileqq.transfile.PtvGuideUploader.IPtvGuidUpCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

public class aiqo
  implements ITransactionCallback
{
  public aiqo(PtvGuideUploader paramPtvGuideUploader, String paramString) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader)) + "ms");
    }
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("serverip", paramHashMap.get("ip"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_bdhSrv", paramHashMap.get("ip"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_bdhPort", paramHashMap.get("port"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("X-piccachetime", paramArrayOfByte);
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_BdhTrans", str1);
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_segspercnt", str2);
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_conf_segSize", str3);
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_conf_segNum", str4);
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_conf_connNum", str5);
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_fin_lost", str6);
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_retry_code", paramHashMap.get("param_retry_code"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_ip_index", paramHashMap.get("param_ip_index"));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, true);
    }
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, paramInt);
    PtvGuideUploader.c(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, "sessionKey or sigSession is null");
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).a(paramInt, PtvGuideUploader.b(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader));
    PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, false);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, paramArrayOfByte);
          PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).c(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      PtvGuideUploader.b(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader)) + "ms transInfo:" + PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader));
      }
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("serverip", paramHashMap.get("ip"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_bdhSrv", paramHashMap.get("ip"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_bdhPort", paramHashMap.get("port"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("X-piccachetime", String.valueOf(PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).mTransReport.timeCost_Cache));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_BdhTrans", PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_segspercnt", paramArrayOfByte);
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_conf_segSize", str1);
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_conf_segNum", str2);
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_conf_connNum", str3);
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_fin_lost", str4);
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_retry_code", paramHashMap.get("param_retry_code"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_ip_index", paramHashMap.get("param_ip_index"));
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      FileUtils.d(this.jdField_a_of_type_JavaLangString);
      PtvGuideUploader.a(this.jdField_a_of_type_ComTencentMobileqqTransfilePtvGuideUploader, true);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PtvGuideUploader", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> onTransStart()");
    }
  }
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqo
 * JD-Core Version:    0.7.0.1
 */