import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class ajzk
  implements ajvb
{
  public ajzk(ThemeHbFragment paramThemeHbFragment) {}
  
  public void a()
  {
    ThemeHbFragment.a(this.a, null);
  }
  
  public void a(Object paramObject)
  {
    if (ThemeHbFragment.a(this.a) == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back context is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeHbFragment", 2, "setImageBgProcess download back drawable = " + paramObject);
      }
    } while (!(paramObject instanceof Drawable));
    if (QLog.isColorLevel()) {
      QLog.i("ThemeHbFragment", 2, "setImageBgProcess image set...");
    }
    ThemeHbFragment.a(this.a).post(new ThemeHbFragment.2.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzk
 * JD-Core Version:    0.7.0.1
 */