import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.widget.QQToast;

class afca
  implements Runnable
{
  afca(afbz paramafbz, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afbz.a, NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afbz.a), false, false);
      return;
    }
    QQToast.a(this.jdField_a_of_type_Afbz.a.getActivity(), 1, "播放失败", 0).b(this.jdField_a_of_type_Afbz.a.getActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afbz.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afbz.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.b(this.jdField_a_of_type_Afbz.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afca
 * JD-Core Version:    0.7.0.1
 */