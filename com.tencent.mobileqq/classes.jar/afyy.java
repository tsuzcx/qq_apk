import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;

public class afyy
{
  private VasAvatar a;
  
  public afyy(VasAvatar paramVasAvatar)
  {
    this.a = paramVasAvatar;
  }
  
  private void a(View paramView)
  {
    paramView.setPivotX(0.5F * paramView.getWidth());
    paramView.setPivotY(1.0F * paramView.getHeight());
    paramView = ObjectAnimator.ofFloat(paramView, View.ROTATION, new float[] { 0.0F, -10, 0.0F, 10, 0.0F, -10, 0.0F, 10, 0.0F });
    paramView.setDuration(300L);
    paramView.addListener(new afyz(this));
    paramView.start();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "start() called");
    }
    a(this.a);
    View localView = ((ViewGroup)this.a.getParent()).findViewById(2131364542);
    if ((localView != null) && (localView.isShown())) {
      a(localView);
    }
    axeh.a(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyy
 * JD-Core Version:    0.7.0.1
 */