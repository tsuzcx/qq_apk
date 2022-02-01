import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter;
import com.tencent.ad.tangram.canvas.AdCanvasAdapter.Params;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings;
import com.tencent.ad.tangram.protocol.gdt_settings.Settings.SettingsForXJ;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import java.lang.ref.WeakReference;

public final class acne
  implements AdCanvasAdapter
{
  public int getQueueLength(WeakReference<Context> paramWeakReference)
  {
    if (paramWeakReference == null) {}
    do
    {
      return -2147483648;
      paramWeakReference = AdSettingsUtil.INSTANCE.getSettingsCache((Context)paramWeakReference.get());
    } while (paramWeakReference == null);
    if ((paramWeakReference.settingsForXJ.canvas) || (paramWeakReference.settingsForXJ.offline)) {
      return paramWeakReference.settingsForXJ.queueLength;
    }
    return -2147483648;
  }
  
  public AdError show(AdCanvasAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      acvc.d("GdtCanvasAdapter", "show error");
      return new AdError(4);
    }
    Object localObject = (GdtAd)GdtAd.class.cast(paramParams.ad);
    localObject = AdCanvasDataBuilderV2.build(((Activity)paramParams.activity.get()).getApplicationContext(), (Ad)localObject, paramParams.autoDownload);
    if ((localObject == null) || (!((AdCanvasData)localObject).isValid()))
    {
      acvc.d("GdtCanvasAdapter", "show error");
      return new AdError(4);
    }
    GdtCanvasBaseFragment.start((Activity)paramParams.activity.get(), GdtCanvasFragmentForJS.class, (AdCanvasData)localObject, paramParams.extrasForIntent);
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acne
 * JD-Core Version:    0.7.0.1
 */