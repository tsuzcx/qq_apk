import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;

public class akyi
  implements NonMainAppHeadLoader.FaceObserver
{
  public akyi(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void onFaceUpdate(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (WorldCupShareFragment.a(this.a).getCurrentAccountUin().equals(paramString1)) {
      ((ImageView)this.a.getActivity().findViewById(2131375482)).setImageDrawable(new BitmapDrawable(this.a.getResources(), paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyi
 * JD-Core Version:    0.7.0.1
 */