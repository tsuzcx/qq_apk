import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.gdtad.views.image.GdtGifImageView;
import java.lang.ref.WeakReference;

public class abzn
  implements AdImageViewAdapter
{
  public View buildImageView(AdImageViewAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      WeakReference localWeakReference = new WeakReference(new abzo(this, paramParams));
      return new GdtGifImageView((Context)paramParams.context.get(), paramParams.url, paramParams.gaussianUrl, localWeakReference, paramParams.isOnlyLoadGaussianUrl);
    }
    return null;
  }
  
  public void buildImageView(AdImageViewAdapter.Params paramParams, View paramView)
  {
    if ((paramView != null) && (paramParams != null) && (paramParams.isValid()))
    {
      WeakReference localWeakReference = new WeakReference(new abzp(this, paramParams));
      ((GdtGifImageView)paramView).a(paramParams.url, localWeakReference);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzn
 * JD-Core Version:    0.7.0.1
 */