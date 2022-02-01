import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisAdapter;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListener;
import com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListenerAdapter;
import com.tencent.ad.tangram.canvas.download.AdDownloader;
import com.tencent.ad.tangram.canvas.download.AdDownloaderAdapter;
import com.tencent.ad.tangram.canvas.report.AdReport;
import com.tencent.ad.tangram.canvas.report.AdReportAdapter;
import com.tencent.ad.tangram.canvas.resource.AdResource;
import com.tencent.ad.tangram.canvas.resource.AdResourceAdapter;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.device.AdTAIDAdapter;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.ad.tangram.halfScreen.AdHalfScreen;
import com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.lbs.AdLocationAdapter;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.ad.tangram.util.AdExposureListHolder;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import java.lang.ref.WeakReference;

public final class acim
{
  private static volatile acim jdField_a_of_type_Acim;
  private AdAnalysisAdapter jdField_a_of_type_ComTencentAdTangramAnalysisAdAnalysisAdapter = new abyv();
  private AdCanvasAdapter jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter = new abzb();
  private AdCanvasDownloadListenerAdapter jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter = new abzd();
  private AdDownloaderAdapter jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdDownloaderAdapter = new abze();
  private AdReportAdapter jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter = new abzx();
  private AdResourceAdapter jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter = new abzy();
  private AdTAIDAdapter jdField_a_of_type_ComTencentAdTangramDeviceAdTAIDAdapter = new aciq();
  private AdProgressDialogAdapter jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter = new abzu();
  private AdHalfScreenAdapter jdField_a_of_type_ComTencentAdTangramHalfScreenAdHalfScreenAdapter = new abzf();
  private AdImageViewAdapter jdField_a_of_type_ComTencentAdTangramImageAdImageViewAdapter = new abzn();
  private AdIPCManager.Adapter jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter = new abzg();
  private AdLocationAdapter jdField_a_of_type_ComTencentAdTangramLbsAdLocationAdapter = new abzq();
  private AdLogAdapter jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter = new abzr();
  private AdQQMINIProgramAdapter jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter = new abzv();
  private AdOfflineAdapter jdField_a_of_type_ComTencentAdTangramOfflineAdOfflineAdapter = new abzs();
  private AdProcessManagerAdapter jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter = new abzt();
  private AdThreadManagerAdapter jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter = new abzz();
  private AdToastAdapter jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter = new acaa();
  private AdVersionAdapter jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter = new acab();
  private AdVideoCeilingAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter = new acac();
  private AdVideoSpliceAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter = new acad();
  private AdBrowserAdapter jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter = new abza();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static acim a()
  {
    if (jdField_a_of_type_Acim == null) {}
    try
    {
      if (jdField_a_of_type_Acim == null) {
        jdField_a_of_type_Acim = new acim();
      }
      return jdField_a_of_type_Acim;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    aclb.a().a(paramContext);
  }
  
  private void b(Context paramContext, acin paramacin)
  {
    AdIPCManager.INSTANCE.init(paramContext, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter));
    AdLog.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter));
    AdAnalysis.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramAnalysisAdAnalysisAdapter));
    AdProcessManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter));
    AdThreadManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter));
    AdBrowser.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter));
    AdCanvas.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter));
    AdVideoCeiling.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter));
    AdQQMINIProgram.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter));
    AdVideoSplice.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter));
    AdToast.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter));
    AdProgressDialog.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter));
    AdImageViewBuilder.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramImageAdImageViewAdapter));
    AdDownloader.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdDownloaderAdapter));
    AdReport.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter));
    AdResource.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter));
    AdVersion.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter));
    AdCanvasDownloadListener.setAdapter(this.jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter);
    AdOffline.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramOfflineAdOfflineAdapter));
    AdHalfScreen.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramHalfScreenAdHalfScreenAdapter));
    AdTAID.getInstance().setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDeviceAdTAIDAdapter));
    AdLocationManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramLbsAdLocationAdapter));
  }
  
  private void c(Context paramContext, acin paramacin)
  {
    AdSettingsUtil.INSTANCE.init(paramContext);
  }
  
  private void d(Context paramContext, acin paramacin)
  {
    GdtDeviceInfoHelper.init(paramContext);
  }
  
  private void e(Context paramContext, acin paramacin)
  {
    accc.a().a();
  }
  
  private void f(Context paramContext, acin paramacin)
  {
    AdExposureListHolder.getInstance().init(paramContext);
  }
  
  public AdIPCManager.Adapter a()
  {
    return this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter;
  }
  
  public void a(Context paramContext, acin paramacin)
  {
    acho.b("GdtManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_Boolean = true;
    b(paramContext, paramacin);
    c(paramContext, paramacin);
    d(paramContext, paramacin);
    e(paramContext, paramacin);
    f(paramContext, paramacin);
    a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acim
 * JD-Core Version:    0.7.0.1
 */