import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasDataBuilderV2;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import java.lang.ref.WeakReference;

public final class aaib
  implements AdVideoCeilingAdapter
{
  public AdError show(AdVideoCeilingAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      aanp.d("GdtVideoCeilingAdapter", "show error");
      return new AdError(4);
    }
    Object localObject = new GdtVideoData();
    ((GdtVideoData)localObject).setUrl(paramParams.videoUrl);
    ((GdtVideoData)localObject).setStartPositionMillis(paramParams.videoStartPositionMillis);
    ((GdtVideoData)localObject).setLoop(paramParams.videoLoop);
    ((GdtVideoData)localObject).setDirectPlay(paramParams.videoPlayForced);
    GdtVideoCeilingData localGdtVideoCeilingData = new GdtVideoCeilingData();
    localGdtVideoCeilingData.setAd((GdtAd)GdtAd.class.cast(paramParams.ad));
    localGdtVideoCeilingData.setWebUrl(paramParams.webUrl);
    localGdtVideoCeilingData.setVideoData((GdtVideoData)localObject);
    switch (paramParams.style)
    {
    default: 
      return new AdError(4);
    case 1: 
      localGdtVideoCeilingData.setStyle(1);
    }
    while (!localGdtVideoCeilingData.isValid())
    {
      aanp.d("GdtVideoCeilingAdapter", "show error");
      return new AdError(4);
      localGdtVideoCeilingData.setStyle(2);
      continue;
      localGdtVideoCeilingData.setStyle(3);
      continue;
      localObject = AdCanvasDataBuilderV2.build((Context)paramParams.activity.get(), paramParams.ad, paramParams.autodownload);
      if ((localObject == null) || (!((AdCanvasData)localObject).isValid()))
      {
        localGdtVideoCeilingData.setStyle(1);
      }
      else
      {
        localGdtVideoCeilingData.setCanvasData((AdCanvasData)localObject);
        localGdtVideoCeilingData.setStyle(4);
      }
    }
    GdtBaseVideoCeilingFragment.a((Activity)paramParams.activity.get(), GdtVideoCeilingFragmentForJS.class, localGdtVideoCeilingData, paramParams.extrasForIntent);
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaib
 * JD-Core Version:    0.7.0.1
 */