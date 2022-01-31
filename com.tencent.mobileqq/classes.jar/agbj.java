import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.profile.VipProfileCardDownLoadInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

class agbj
  extends DownloadListener
{
  agbj(agbi paramagbi, Context paramContext, AppInterface paramAppInterface) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.b.set(0);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, String.format("Resource progress task:", new Object[] { paramDownloadTask.toString() }));
    }
    try
    {
      ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).f = Integer.valueOf(paramDownloadTask.jdField_a_of_type_Int);
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger)
      {
        Object localObject1;
        int i;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Agbi.c))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCardWebviewPlugin", 2, "bg downloaded, start to download hero pic");
          }
          localObject1 = new File(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agbi.c));
          localObject1 = new DownloadTask(this.jdField_a_of_type_Agbi.c, (File)localObject1);
          ((DownloadTask)localObject1).f = "profileCardDownload";
          ((DownloadTask)localObject1).e = "VIP_profilecard";
          i = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          if (i != 0)
          {
            QLog.e("ProfileCardWebviewPlugin", 1, "download hero pic fail code = " + i + " url = " + this.jdField_a_of_type_Agbi.c);
            this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.callJs(this.jdField_a_of_type_Agbi.b, new String[] { "{'result':-1,'progress':75}" });
          }
          if ((i == 0) && (QLog.isColorLevel())) {
            QLog.i("ProfileCardWebviewPlugin", 2, "download hero pic=" + this.jdField_a_of_type_Agbi.c + " successfully.");
          }
          ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(75);
          if (this.jdField_a_of_type_Agbi.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.callJs(this.jdField_a_of_type_Agbi.b, new String[] { "{'result':1,'progress':75}" });
          }
        }
        Object localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCardWebviewPlugin", 2, "bg downloaded, start to download dynamicZip");
          }
          localObject1 = ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString);
          localObject2 = new File((String)localObject1);
          localObject2 = new DownloadTask(this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString, (File)localObject2);
          ((DownloadTask)localObject2).f = "profileCardDownload";
          ((DownloadTask)localObject2).e = "VIP_profilecard";
          i = DownloaderFactory.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          if (i != 0) {
            QLog.e("ProfileCardWebviewPlugin", 1, "download dynamic BG fail code = " + i + " url = " + this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString);
          }
          if (i == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCardWebviewPlugin", 2, "start unzip dynamic background=" + this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString);
            }
            FileUtils.a((String)localObject1, ProfileCardUtil.c(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()) + "." + ProfileCardUtil.c(this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString), false);
            FileUtils.d((String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.i("ProfileCardWebviewPlugin", 2, "unzip dynamic background=" + this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString + "successfully");
            }
          }
          ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(100);
        }
        if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger)
        {
          ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.c;
          localObject1 = ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_d_of_type_JavaLangString;
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("result", paramDownloadTask.jdField_a_of_type_Int);
          ((JSONObject)localObject2).put("message", "onHttpEnd");
          if (this.jdField_a_of_type_Agbi.jdField_a_of_type_Boolean) {
            ((JSONObject)localObject2).put("progress", 100);
          }
          this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.a((String)localObject1, ((JSONObject)localObject2).toString());
        }
      }
      this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.a();
      return;
    }
    catch (Exception paramDownloadTask)
    {
      paramDownloadTask.printStackTrace();
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)paramDownloadTask.jdField_a_of_type_Float;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaLangString)) {
      i = (int)(paramDownloadTask.jdField_a_of_type_Float * 0.5D);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCardWebviewPlugin", 2, String.format("Resource progress task:", new Object[] { paramDownloadTask.toString() }));
      }
      try
      {
        ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).e = Integer.valueOf(i);
        if (this.jdField_a_of_type_Agbi.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.callJs(this.jdField_a_of_type_Agbi.b, new String[] { "{'result':1,'progress':" + i + "}" });
        }
        if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger) {
          ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.b;
        }
        return;
      }
      catch (Exception paramDownloadTask)
      {
        paramDownloadTask.printStackTrace();
        return;
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, String.format("Resource start download task: %s", new Object[] { paramDownloadTask.toString() }));
    }
    if ((this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) != null) && (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g != VipProfileCardDownLoadInfo.jdField_d_of_type_JavaLangInteger)) {
      ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Agbi.jdField_a_of_type_ComTencentMobileqqProfileProfileCardWebviewPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.b;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbj
 * JD-Core Version:    0.7.0.1
 */