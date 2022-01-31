import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.widget.QQToast;

class aeou
  implements Runnable
{
  aeou(aeot paramaeot, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aeot.a, NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aeot.a), false, false);
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aeot.a.getActivity(), 1, "播放失败", 0).b(this.jdField_a_of_type_Aeot.a.getActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aeot.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aeot.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.b(this.jdField_a_of_type_Aeot.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeou
 * JD-Core Version:    0.7.0.1
 */