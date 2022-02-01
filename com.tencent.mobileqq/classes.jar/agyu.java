import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.24.1;

public class agyu
  implements agyb
{
  agyu(agyh paramagyh) {}
  
  public void a(int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.a.a().findViewById(2131367376);
      if (localView != null) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          localView.setVisibility(0);
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(300L);
          localView.startAnimation(localAlphaAnimation);
          localView.postDelayed(new AIOGalleryScene.24.1(this, localView), 8000L);
          return;
          if (1 != paramInt) {
            break;
          }
        } while ((this.a.jdField_a_of_type_Bbwb == null) || (((agyh.J(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)agyh.K(this.a)).b)) || (this.a.c));
        this.a.c(null);
        return;
        if (2 != paramInt) {
          break;
        }
        this.a.a(null);
      } while ((this.a.jdField_a_of_type_Bbwb == null) || (((agyh.L(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)agyh.M(this.a)).b)) || (this.a.c));
      this.a.jdField_a_of_type_Bbwb.b(this.a.jdField_a_of_type_Agzn.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      return;
    } while (3 != paramInt);
    this.a.jdField_a_of_type_Agzn.a().jdField_a_of_type_Ahan.i = true;
    this.a.e.setText("");
    this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyu
 * JD-Core Version:    0.7.0.1
 */