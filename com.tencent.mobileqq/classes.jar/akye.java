import Wallet.JudgeDownloadRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class akye
  implements BusinessObserver
{
  akye(akyd paramakyd, WeakReference paramWeakReference, bhyn parambhyn) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle arg3)
  {
    int i = 60;
    PreloadManager localPreloadManager1;
    label137:
    JudgeDownloadRsp localJudgeDownloadRsp;
    if (paramInt == 1)
    {
      try
      {
        localPreloadManager1 = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!PreloadManager.a(localPreloadManager1))
        {
          if (this.jdField_a_of_type_Bhyn == null) {
            break label622;
          }
          this.jdField_a_of_type_Akyd.a(this.jdField_a_of_type_Bhyn);
          return;
        }
        if (paramBoolean) {
          break label137;
        }
        if (this.jdField_a_of_type_Bhyn != null) {
          this.jdField_a_of_type_Akyd.a(this.jdField_a_of_type_Bhyn);
        }
        localPreloadManager1.c();
        return;
      }
      catch (Throwable ???)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, akyd.a(this.jdField_a_of_type_Akyd) + " startFlowControlReq onReceive exception:" + ???);
        }
        if (this.jdField_a_of_type_Bhyn == null) {
          break label622;
        }
      }
      this.jdField_a_of_type_Akyd.a(this.jdField_a_of_type_Bhyn);
      return;
      localJudgeDownloadRsp = (JudgeDownloadRsp)???.getSerializable("rsp");
      if (localJudgeDownloadRsp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, "onReceive rsp is null:" + localJudgeDownloadRsp);
        }
        if (this.jdField_a_of_type_Bhyn != null) {
          this.jdField_a_of_type_Akyd.a(this.jdField_a_of_type_Bhyn);
        }
        localPreloadManager1.c();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RealTimeFlowControlObj", 2, akyd.a(this.jdField_a_of_type_Akyd) + "FlowControlRsp|" + localJudgeDownloadRsp.iDownloadStatus + "|" + localJudgeDownloadRsp.iSegTime + "|" + localJudgeDownloadRsp.iFailedRetryMax);
      }
    }
    for (;;)
    {
      synchronized (akyd.a(this.jdField_a_of_type_Akyd))
      {
        switch (localJudgeDownloadRsp.iDownloadStatus)
        {
        case 1: 
          akyd.a(this.jdField_a_of_type_Akyd).mDownloadStatus = 2;
          localPreloadFlowControlConfig = akyd.a(this.jdField_a_of_type_Akyd);
          if (localJudgeDownloadRsp.iSegTime > 60) {
            i = localJudgeDownloadRsp.iSegTime;
          }
          localPreloadFlowControlConfig.mNextCanReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          if (localJudgeDownloadRsp.iDownloadStatus != 0) {
            akyd.a(this.jdField_a_of_type_Akyd).mRetryReqTimes = 0;
          }
          akyd.a(this.jdField_a_of_type_Akyd).saveConfig();
          if (localJudgeDownloadRsp.iDownloadStatus != 2) {
            break label586;
          }
          localPreloadManager1.c();
          if (this.jdField_a_of_type_Bhyn == null) {
            break label622;
          }
          this.jdField_a_of_type_Akyd.a(this.jdField_a_of_type_Bhyn);
          return;
          akyd.a(this.jdField_a_of_type_Akyd).mDownloadStatus = 1;
          localPreloadFlowControlConfig = akyd.a(this.jdField_a_of_type_Akyd);
          if (localJudgeDownloadRsp.iFailedRetryMax > 0)
          {
            paramInt = localJudgeDownloadRsp.iFailedRetryMax;
            localPreloadFlowControlConfig.mRetryDownloadTimes = paramInt;
            localPreloadFlowControlConfig = akyd.a(this.jdField_a_of_type_Akyd);
            if (localJudgeDownloadRsp.iSegTime > 60) {
              i = localJudgeDownloadRsp.iSegTime;
            }
            localPreloadFlowControlConfig.mValidDownloadTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          }
          break;
        }
      }
      paramInt = 3;
      continue;
      akyd.a(this.jdField_a_of_type_Akyd).mDownloadStatus = 0;
      PreloadFlowControlConfig localPreloadFlowControlConfig = akyd.a(this.jdField_a_of_type_Akyd);
      if (localJudgeDownloadRsp.iSegTime > 60) {
        i = localJudgeDownloadRsp.iSegTime;
      }
      localPreloadFlowControlConfig.mNextRetryReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
      continue;
      label586:
      if (localJudgeDownloadRsp.iDownloadStatus == 0)
      {
        this.jdField_a_of_type_Akyd.a(localPreloadManager2);
        return;
      }
      if (localJudgeDownloadRsp.iDownloadStatus == 1) {
        this.jdField_a_of_type_Akyd.a(localPreloadManager2);
      }
      label622:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akye
 * JD-Core Version:    0.7.0.1
 */