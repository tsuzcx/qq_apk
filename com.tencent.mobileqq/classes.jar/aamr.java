import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoSpliceAdapter.Params;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class aamr
  implements AdVideoSpliceAdapter
{
  public AdError show(AdVideoSpliceAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      aase.d("GdtVideoSpliceAdapter", "show error");
      return new AdError(4);
    }
    aase.b("GdtVideoSpliceAdapter", "show");
    new TransitionContext(paramParams).b();
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamr
 * JD-Core Version:    0.7.0.1
 */