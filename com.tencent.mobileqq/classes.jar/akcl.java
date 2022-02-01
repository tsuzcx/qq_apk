import Wallet.JudgeDownloadRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class akcl
  implements BusinessObserver
{
  akcl(akck paramakck, WeakReference paramWeakReference, bgod parambgod) {}
  
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
          if (this.jdField_a_of_type_Bgod == null) {
            break label622;
          }
          this.jdField_a_of_type_Akck.a(this.jdField_a_of_type_Bgod);
          return;
        }
        if (paramBoolean) {
          break label137;
        }
        if (this.jdField_a_of_type_Bgod != null) {
          this.jdField_a_of_type_Akck.a(this.jdField_a_of_type_Bgod);
        }
        localPreloadManager1.c();
        return;
      }
      catch (Throwable ???)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, akck.a(this.jdField_a_of_type_Akck) + " startFlowControlReq onReceive exception:" + ???);
        }
        if (this.jdField_a_of_type_Bgod == null) {
          break label622;
        }
      }
      this.jdField_a_of_type_Akck.a(this.jdField_a_of_type_Bgod);
      return;
      localJudgeDownloadRsp = (JudgeDownloadRsp)???.getSerializable("rsp");
      if (localJudgeDownloadRsp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, "onReceive rsp is null:" + localJudgeDownloadRsp);
        }
        if (this.jdField_a_of_type_Bgod != null) {
          this.jdField_a_of_type_Akck.a(this.jdField_a_of_type_Bgod);
        }
        localPreloadManager1.c();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RealTimeFlowControlObj", 2, akck.a(this.jdField_a_of_type_Akck) + "FlowControlRsp|" + localJudgeDownloadRsp.iDownloadStatus + "|" + localJudgeDownloadRsp.iSegTime + "|" + localJudgeDownloadRsp.iFailedRetryMax);
      }
    }
    for (;;)
    {
      synchronized (akck.a(this.jdField_a_of_type_Akck))
      {
        switch (localJudgeDownloadRsp.iDownloadStatus)
        {
        case 1: 
          akck.a(this.jdField_a_of_type_Akck).mDownloadStatus = 2;
          localPreloadFlowControlConfig = akck.a(this.jdField_a_of_type_Akck);
          if (localJudgeDownloadRsp.iSegTime > 60) {
            i = localJudgeDownloadRsp.iSegTime;
          }
          localPreloadFlowControlConfig.mNextCanReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
          if (localJudgeDownloadRsp.iDownloadStatus != 0) {
            akck.a(this.jdField_a_of_type_Akck).mRetryReqTimes = 0;
          }
          akck.a(this.jdField_a_of_type_Akck).saveConfig();
          if (localJudgeDownloadRsp.iDownloadStatus != 2) {
            break label586;
          }
          localPreloadManager1.c();
          if (this.jdField_a_of_type_Bgod == null) {
            break label622;
          }
          this.jdField_a_of_type_Akck.a(this.jdField_a_of_type_Bgod);
          return;
          akck.a(this.jdField_a_of_type_Akck).mDownloadStatus = 1;
          localPreloadFlowControlConfig = akck.a(this.jdField_a_of_type_Akck);
          if (localJudgeDownloadRsp.iFailedRetryMax > 0)
          {
            paramInt = localJudgeDownloadRsp.iFailedRetryMax;
            localPreloadFlowControlConfig.mRetryDownloadTimes = paramInt;
            localPreloadFlowControlConfig = akck.a(this.jdField_a_of_type_Akck);
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
      akck.a(this.jdField_a_of_type_Akck).mDownloadStatus = 0;
      PreloadFlowControlConfig localPreloadFlowControlConfig = akck.a(this.jdField_a_of_type_Akck);
      if (localJudgeDownloadRsp.iSegTime > 60) {
        i = localJudgeDownloadRsp.iSegTime;
      }
      localPreloadFlowControlConfig.mNextRetryReqTime = (i * 1000 + NetConnInfoCenter.getServerTimeMillis());
      continue;
      label586:
      if (localJudgeDownloadRsp.iDownloadStatus == 0)
      {
        this.jdField_a_of_type_Akck.a(localPreloadManager2);
        return;
      }
      if (localJudgeDownloadRsp.iDownloadStatus == 1) {
        this.jdField_a_of_type_Akck.a(localPreloadManager2);
      }
      label622:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcl
 * JD-Core Version:    0.7.0.1
 */