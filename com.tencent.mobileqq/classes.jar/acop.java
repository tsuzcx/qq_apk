import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.gdtad.api.motivevideo.GdtMvAppBtnData;
import com.tencent.gdtad.api.motivevideo.GdtMvAppBtnView;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.1;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.2;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.3;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.4;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.5;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acop
{
  private GdtMvAppBtnView jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView;
  private GdtMvDownloadBtnManager jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private GdtMvAppBtnView jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView;
  private boolean jdField_b_of_type_Boolean = true;
  
  public acop(String paramString, GdtMvAppBtnView paramGdtMvAppBtnView1, GdtMvAppBtnView paramGdtMvAppBtnView2, GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager)
  {
    acqy.a("GdtMvDownloadBtnPresenter", "GdtMvDownloadBtnPresenter: ");
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView = paramGdtMvAppBtnView1;
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView = paramGdtMvAppBtnView2;
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = paramGdtMvDownloadBtnManager;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_source_key", "biz_src_ads");
    AdAppUtil.launch(paramContext, paramString, localBundle);
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if ((paramDownloadInfo == null) || (paramGdtMvAppBtnData == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramGdtMvAppBtnData.packageName)) || (TextUtils.isEmpty(paramGdtMvAppBtnData.mGdtAd_appId))) {}
    while ((!paramDownloadInfo.e.equals(paramGdtMvAppBtnData.packageName)) || (!paramDownloadInfo.c.equals(paramGdtMvAppBtnData.mGdtAd_appId))) {
      return false;
    }
    return true;
  }
  
  private void e(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a(paramGdtMvAppBtnData, 0);
    }
  }
  
  private void f(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) && (paramGdtMvAppBtnData.cState == 4)) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a(paramGdtMvAppBtnData, paramGdtMvAppBtnData.cProgerss);
    }
  }
  
  private void g(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    String str1 = paramGdtMvAppBtnData.packageName;
    String str2 = paramGdtMvAppBtnData.mGdtAd_appId;
    String str3 = paramGdtMvAppBtnData.apkUrlhttp;
    paramGdtMvAppBtnData = paramGdtMvAppBtnData.name;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bivp.k, 5);
    localBundle.putString(bivp.f, str1);
    localBundle.putString(bivp.b, str2);
    localBundle.putString(bivp.j, str3);
    localBundle.putString(bivp.l, paramGdtMvAppBtnData);
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvDownloadBtnPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramGdtMvAppBtnData + ", url:" + str3);
    }
    bise.a(localBundle);
  }
  
  private void h(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.1(this, paramGdtMvAppBtnData));
    }
    while ((paramGdtMvAppBtnData == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || ((paramGdtMvAppBtnData.cState != 3) && (paramGdtMvAppBtnData.cState != 4))) {
      return;
    }
    acqy.b("GdtMvDownloadBtnPresenter", "pauseDownloadUi " + paramGdtMvAppBtnData.packageName);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(anni.a(2131703985));
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(anni.a(2131703982));
    paramGdtMvAppBtnData.cState = 4;
    paramGdtMvAppBtnData.cProgerss = ((int)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a());
    bisa.a().a(paramGdtMvAppBtnData.apkUrlhttp);
  }
  
  private void i(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    c(paramGdtMvAppBtnData);
  }
  
  private void j(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.6(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703986));
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703974));
    paramGdtMvAppBtnData.cState = 2;
  }
  
  public void a(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.3(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703973));
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703984));
    paramGdtMvAppBtnData.cState = 5;
  }
  
  public void a(GdtMvAppBtnData paramGdtMvAppBtnData, int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager == null)
    {
      acqy.d("GdtMvDownloadBtnPresenter", "updatUIByClick mGdtAppDownloadManager == null");
      return;
    }
    if (paramGdtMvAppBtnData == null)
    {
      acqy.d("GdtMvDownloadBtnPresenter", "updatUIByClick cGdtMvAppBtnData == null");
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(anni.a(2131703983));
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(0);
        this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(anni.a(2131703971));
        this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(0);
        if (this.jdField_a_of_type_Boolean) {
          break label132;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI("0%");
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(0);
        this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI("0%");
        this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(0);
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.d();
        break;
        label132:
        bool = false;
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a(paramGdtMvAppBtnData, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.getContext(), paramGdtMvAppBtnData.packageName);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      h(paramGdtMvAppBtnData);
      return;
    case 4: 
      this.jdField_a_of_type_Boolean = true;
      f(paramGdtMvAppBtnData);
      return;
    case 5: 
      g(paramGdtMvAppBtnData);
      return;
    }
    e(paramGdtMvAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      paramGdtMvAppBtnData.cState = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      h(paramGdtMvAppBtnData);
    }
  }
  
  public void a(String paramString1, String paramString2, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramGdtMvAppBtnData)) {
      b(paramGdtMvAppBtnData);
    }
  }
  
  public void b(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.4(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703972));
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703980));
    paramGdtMvAppBtnData.cState = 1;
  }
  
  public void b(GdtMvAppBtnData paramGdtMvAppBtnData, int paramInt)
  {
    acqy.b("GdtMvDownloadBtnPresenter", "updateBtnProgressUI " + paramInt);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.2(this, paramGdtMvAppBtnData, paramInt));
      do
      {
        return;
      } while ((paramGdtMvAppBtnData == null) || (paramGdtMvAppBtnData.cState != 3));
      if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) && (paramInt >= 0))
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(paramInt + "%");
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(paramInt);
      }
    } while ((this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramInt < 0));
    acqy.b("GdtMvDownloadBtnPresenter", "updateBtnProgressUI " + paramInt);
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(paramInt + "%");
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(paramInt);
  }
  
  public void b(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData) {}
  
  public void b(String paramString1, String paramString2, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramGdtMvAppBtnData)) {
      i(paramGdtMvAppBtnData);
    }
  }
  
  public void c(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.5(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(this.jdField_a_of_type_JavaLangString);
    paramGdtMvAppBtnData.cState = 0;
  }
  
  public void c(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      c(paramGdtMvAppBtnData);
    }
  }
  
  public void c(String paramString1, String paramString2, GdtMvAppBtnData paramGdtMvAppBtnData) {}
  
  public void d(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvDownloadBtnPresenter", 2, "onCGdtMvAppBtnDataChanged() called with: gdtMvAppBtnData = [" + paramGdtMvAppBtnData + "]");
    }
    switch (paramGdtMvAppBtnData.cState)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
          {
            this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
            this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703976));
          }
        } while (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null);
        this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
        this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703975));
        return;
        b(paramGdtMvAppBtnData, paramGdtMvAppBtnData.cProgerss);
        return;
        if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
        {
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(paramGdtMvAppBtnData.cProgerss);
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(anni.a(2131703977));
        }
      } while (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null);
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(paramGdtMvAppBtnData.cProgerss);
      this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(anni.a(2131703981));
      return;
      if ((paramGdtMvAppBtnData.cProgerss == 100) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null))
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703978));
      }
    } while ((paramGdtMvAppBtnData.cProgerss != 100) || (this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null));
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.a();
    this.jdField_b_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(anni.a(2131703979));
  }
  
  public void d(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      a(paramGdtMvAppBtnData);
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    acqy.a("GdtMvDownloadBtnPresenter", "onDownloadUpdate: ");
    paramGdtMvAppBtnData.cState = 3;
    b(paramGdtMvAppBtnData, paramDownloadInfo.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acop
 * JD-Core Version:    0.7.0.1
 */