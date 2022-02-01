import Wallet.JudgeDownloadReq;
import Wallet.ResInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class akyd
  extends akwz
{
  bhyn jdField_a_of_type_Bhyn;
  DownloadParam jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam;
  private PreloadFlowControlConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig;
  private String jdField_a_of_type_JavaLangString;
  
  public akyd(DownloadParam paramDownloadParam, bhyn parambhyn)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam = paramDownloadParam;
    this.jdField_a_of_type_Bhyn = parambhyn;
  }
  
  private void a(bhyn parambhyn, String paramString)
  {
    if (parambhyn == null) {
      return;
    }
    paramString = new bhyo(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, new File(paramString));
    paramString.a = 0;
    parambhyn.onDoneFile(paramString);
  }
  
  public bhyn a(long paramLong, bhyn parambhyn, PreloadManager paramPreloadManager, int paramInt)
  {
    return new akyf(this, paramInt, new WeakReference(paramPreloadManager), parambhyn, paramLong);
  }
  
  public ArrayList<ResInfo> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ResInfo localResInfo = new ResInfo();
    try
    {
      localResInfo.sResId = this.jdField_a_of_type_JavaLangString;
      localResInfo.iSize = paramInt;
      localArrayList.add(localResInfo);
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(JudgeDownloadReq paramJudgeDownloadReq, PreloadManager paramPreloadManager, bhyn parambhyn)
  {
    akra.a(paramJudgeDownloadReq, new akye(this, new WeakReference(paramPreloadManager), parambhyn), 1);
  }
  
  public void a(bhyn parambhyn)
  {
    if (parambhyn == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url;
    localObject = new bhyo((String)localObject, new File(PreloadManager.b((String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos)));
    ((bhyo)localObject).a = -5;
    parambhyn.onDoneFile((bhyo)localObject);
  }
  
  public void a(PreloadManager paramPreloadManager)
  {
    ??? = PreloadManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.isForceUnzip, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
    if (PreloadManager.a((ResourceInfo)???, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam))
    {
      if (this.jdField_a_of_type_Bhyn != null) {
        a(this.jdField_a_of_type_Bhyn, ((ResourceInfo)???).filePath);
      }
      paramPreloadManager.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig == null)
    {
      this.jdField_a_of_type_JavaLangString = paramPreloadManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.url);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig = PreloadFlowControlConfig.getFlowControlConfig(this.jdField_a_of_type_JavaLangString, paramPreloadManager.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "handleFlowConfig:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mDownloadStatus);
    }
    long l1 = paramPreloadManager.a.getLongAccountUin();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig)
      {
        switch (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mDownloadStatus)
        {
        case -1: 
          paramPreloadManager.c();
          return;
        }
      }
      a(JudgeDownloadReq.createReq(a(0), l1, 0), paramPreloadManager, this.jdField_a_of_type_Bhyn);
      continue;
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "STATUS_NOW_DOWNLOAD|" + l2 + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mValidDownloadTime);
      }
      if (l2 < this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mValidDownloadTime)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "begin download");
        }
        paramPreloadManager = a(l1, this.jdField_a_of_type_Bhyn, paramPreloadManager, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mRetryDownloadTimes);
        akwp.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam, paramPreloadManager, null);
      }
      else
      {
        a(JudgeDownloadReq.createReq(a(0), l1, 0), paramPreloadManager, this.jdField_a_of_type_Bhyn);
        continue;
        l2 = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + " STATUS_NOT_DOWNLOAD|" + l2 + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextCanReqTime);
        }
        if (l2 > this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextCanReqTime)
        {
          a(JudgeDownloadReq.createReq(a(0), l1, 0), paramPreloadManager, this.jdField_a_of_type_Bhyn);
        }
        else
        {
          paramPreloadManager.c();
          if (this.jdField_a_of_type_Bhyn != null)
          {
            a(this.jdField_a_of_type_Bhyn);
            continue;
            l2 = NetConnInfoCenter.getServerTimeMillis();
            long l3 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextRetryReqTime - l2;
            if (QLog.isColorLevel()) {
              QLog.d("RealTimeFlowControlObj", 2, this.jdField_a_of_type_JavaLangString + "STATUS_WAIT_TO_REQ|" + l2 + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextRetryReqTime + "|" + l3);
            }
            if (l3 <= 0L)
            {
              ArrayList localArrayList = a(0);
              PreloadFlowControlConfig localPreloadFlowControlConfig = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig;
              int i = localPreloadFlowControlConfig.mRetryReqTimes + 1;
              localPreloadFlowControlConfig.mRetryReqTimes = i;
              a(JudgeDownloadReq.createReq(localArrayList, l1, i), paramPreloadManager, this.jdField_a_of_type_Bhyn);
            }
            else
            {
              paramPreloadManager.c();
              if (this.jdField_a_of_type_Bhyn != null) {
                a(this.jdField_a_of_type_Bhyn);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyd
 * JD-Core Version:    0.7.0.1
 */