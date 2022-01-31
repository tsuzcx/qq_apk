import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.widget.QQToast;

class afgx
  implements Runnable
{
  afgx(afgw paramafgw, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afgw.a, NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afgw.a), false, false);
      return;
    }
    QQToast.a(this.jdField_a_of_type_Afgw.a.getActivity(), 1, "播放失败", 0).b(this.jdField_a_of_type_Afgw.a.getActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afgw.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Afgw.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.b(this.jdField_a_of_type_Afgw.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgx
 * JD-Core Version:    0.7.0.1
 */