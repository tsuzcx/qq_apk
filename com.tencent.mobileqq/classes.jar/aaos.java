import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisAdapter;
import com.tencent.ad.tangram.ark.AdArkAdapter;
import com.tencent.ad.tangram.ark.AdArkView;
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
import com.tencent.ad.tangram.device.AdImei;
import com.tencent.ad.tangram.device.AdImeiAdapter;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Adapter;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import java.lang.ref.WeakReference;

public final class aaos
{
  private static volatile aaos jdField_a_of_type_Aaos;
  private AdAnalysisAdapter jdField_a_of_type_ComTencentAdTangramAnalysisAdAnalysisAdapter = new aahd();
  private AdArkAdapter jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter = new aahe();
  private AdCanvasAdapter jdField_a_of_type_ComTencentAdTangramCanvasAdCanvasAdapter = new aahj();
  private AdCanvasDownloadListenerAdapter jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter = new aahl();
  private AdDownloaderAdapter jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdDownloaderAdapter = new aahm();
  private AdReportAdapter jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter = new aahw();
  private AdResourceAdapter jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter = new aahx();
  private AdImeiAdapter jdField_a_of_type_ComTencentAdTangramDeviceAdImeiAdapter = new aahn();
  private AdProgressDialogAdapter jdField_a_of_type_ComTencentAdTangramDialogAdProgressDialogAdapter = new aaht();
  private AdImageViewAdapter jdField_a_of_type_ComTencentAdTangramImageAdImageViewAdapter = new aahp();
  private AdIPCManager.Adapter jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter = new aaho();
  private AdLogAdapter jdField_a_of_type_ComTencentAdTangramLogAdLogAdapter = new aahr();
  private AdQQMINIProgramAdapter jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter = new aahu();
  private AdProcessManagerAdapter jdField_a_of_type_ComTencentAdTangramProcessAdProcessManagerAdapter = new aahs();
  private AdThreadManagerAdapter jdField_a_of_type_ComTencentAdTangramThreadAdThreadManagerAdapter = new aahy();
  private AdToastAdapter jdField_a_of_type_ComTencentAdTangramToastAdToastAdapter = new aahz();
  private AdVersionAdapter jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter = new aaia();
  private AdVideoCeilingAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoCeilingAdapter = new aaib();
  private AdVideoSpliceAdapter jdField_a_of_type_ComTencentAdTangramVideoceilingAdVideoSpliceAdapter = new aaic();
  private AdBrowserAdapter jdField_a_of_type_ComTencentAdTangramWebAdBrowserAdapter = new aahi();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static aaos a()
  {
    if (jdField_a_of_type_Aaos == null) {}
    try
    {
      if (jdField_a_of_type_Aaos == null) {
        jdField_a_of_type_Aaos = new aaos();
      }
      return jdField_a_of_type_Aaos;
    }
    finally {}
  }
  
  private void b(Context paramContext, aaot paramaaot)
  {
    AdIPCManager.INSTANCE.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Adapter));
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
    AdArkView.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter));
    AdReport.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasReportAdReportAdapter));
    AdResource.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramCanvasResourceAdResourceAdapter));
    AdImei.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramDeviceAdImeiAdapter));
    AdVersion.setAdapter(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramVersionAdVersionAdapter));
    AdCanvasDownloadListener.setAdapter(this.jdField_a_of_type_ComTencentAdTangramCanvasDownloadAdCanvasDownloadListenerAdapter);
  }
  
  private void c(Context paramContext, aaot paramaaot)
  {
    AdAnalysis.INSTANCE.init(paramContext);
  }
  
  private void d(Context paramContext, aaot paramaaot)
  {
    aama.a().a(paramContext);
  }
  
  private void e(Context paramContext, aaot paramaaot)
  {
    aaoo.a(paramContext);
  }
  
  private void f(Context paramContext, aaot paramaaot)
  {
    aakb.a().a();
  }
  
  public void a(Context paramContext, aaot paramaaot)
  {
    aanp.b("GdtManager", String.format("init %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
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
    b(paramContext, paramaaot);
    c(paramContext, paramaaot);
    d(paramContext, paramaaot);
    e(paramContext, paramaaot);
    f(paramContext, paramaaot);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaos
 * JD-Core Version:    0.7.0.1
 */