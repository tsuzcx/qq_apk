import android.graphics.drawable.Animatable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.contact.newfriend.connections.TriangleView;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.doutu.DuiButtonImageView;

public class adjt
  extends acju
{
  public long a;
  public FrameLayout a;
  public ImageView a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public anla a;
  public BreathAnimationLayout a;
  public PttAudioPlayView a;
  public PttAudioWaveView a;
  public TriangleView a;
  EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  DuiButtonImageView jdField_a_of_type_ComTencentMobileqqDoutuDuiButtonImageView;
  public boolean a;
  ImageView b;
  public RelativeLayout b;
  public boolean b;
  ImageView c;
  ImageView d;
  public int e = -1;
  public ImageView e;
  public ImageView f;
  ImageView g;
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioPlayView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.b();
    }
    if ((this.g != null) && ((this.g.getDrawable() instanceof Animatable))) {
      ((Animatable)this.g.getDrawable()).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjt
 * JD-Core Version:    0.7.0.1
 */