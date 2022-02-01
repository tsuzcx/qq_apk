import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.24.1;

public class ahrv
  implements ahrc
{
  ahrv(ahri paramahri) {}
  
  public void a(int paramInt)
  {
    View localView;
    if (paramInt == 0)
    {
      localView = this.a.a().findViewById(2131367500);
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
        } while ((this.a.jdField_a_of_type_Bdcw == null) || (((ahri.J(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)ahri.K(this.a)).b)) || (this.a.c));
        this.a.c(null);
        return;
        if (2 != paramInt) {
          break;
        }
        this.a.a(null);
      } while ((this.a.jdField_a_of_type_Bdcw == null) || (((ahri.L(this.a) instanceof AIOGalleryActivity)) && (((AIOGalleryActivity)ahri.M(this.a)).b)) || (this.a.c));
      this.a.jdField_a_of_type_Bdcw.b(this.a.jdField_a_of_type_Ahsn.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      return;
    } while (3 != paramInt);
    this.a.jdField_a_of_type_Ahsn.a().jdField_a_of_type_Ahtn.i = true;
    this.a.e.setText("");
    this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrv
 * JD-Core Version:    0.7.0.1
 */