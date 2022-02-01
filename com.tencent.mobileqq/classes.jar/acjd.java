import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter;
import com.tencent.ad.tangram.halfScreen.AdHalfScreenAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtBaseHalfScreenFragmentForJs;
import com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment;
import java.lang.ref.WeakReference;

public class acjd
  implements AdHalfScreenAdapter
{
  public AdError show(AdHalfScreenAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      acqy.d("GdtHalfScreenAdapter", "show error");
      return new AdError(4);
    }
    Object localObject = null;
    if (paramParams.style == 2)
    {
      AdCanvasData localAdCanvasData = AdCanvasDataBuilderV2.build((Context)paramParams.activity.get(), paramParams.ad, paramParams.autodownload);
      if (localAdCanvasData != null)
      {
        localObject = localAdCanvasData;
        if (localAdCanvasData.isValid()) {}
      }
      else
      {
        return new AdError(4);
      }
    }
    GdtBaseHalfScreenFragment.a((Activity)paramParams.activity.get(), GdtBaseHalfScreenFragmentForJs.class, paramParams.ad, localObject, paramParams.webUrl, paramParams.style, paramParams.extrasForIntent);
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjd
 * JD-Core Version:    0.7.0.1
 */