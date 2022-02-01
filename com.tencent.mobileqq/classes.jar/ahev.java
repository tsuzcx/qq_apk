import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ahev
  implements ViewTreeObserver.OnPreDrawListener
{
  ahev(ahek paramahek, ahex paramahex) {}
  
  public boolean onPreDraw()
  {
    ahek.a(this.jdField_a_of_type_Ahek).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Ahex.b == 1)
    {
      ahek.a(this.jdField_a_of_type_Ahek).setBackgroundDrawable(new aqwx(Color.parseColor("#1fa4fc"), 5.0F, AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahek.mContext.getResources()), AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahek.mContext.getResources())));
      ahek.b(this.jdField_a_of_type_Ahek).setBackgroundDrawable(new aqwx(Color.parseColor("#1fa4fc"), 5.0F, ahek.b(this.jdField_a_of_type_Ahek).getMeasuredWidth(), ahek.b(this.jdField_a_of_type_Ahek).getMeasuredHeight()));
      ahek.a(this.jdField_a_of_type_Ahek).setImageResource(2130839247);
    }
    for (;;)
    {
      ahek.a(this.jdField_a_of_type_Ahek).setBackgroundDrawable(new aqwx(Color.parseColor("#b2b5bd"), 5.0F, ahek.a(this.jdField_a_of_type_Ahek).getMeasuredWidth(), ahek.a(this.jdField_a_of_type_Ahek).getMeasuredHeight()));
      ahek.c(this.jdField_a_of_type_Ahek).setBackgroundDrawable(new aqwx(Color.parseColor("#b2b5bd"), 5.0F, ahek.c(this.jdField_a_of_type_Ahek).getMeasuredWidth(), ahek.c(this.jdField_a_of_type_Ahek).getMeasuredHeight()));
      return true;
      ahek.a(this.jdField_a_of_type_Ahek).setBackgroundDrawable(new aqwx(Color.parseColor("#ff5fb5"), 5.0F, AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahek.mContext.getResources()), AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahek.mContext.getResources())));
      ahek.b(this.jdField_a_of_type_Ahek).setBackgroundDrawable(new aqwx(Color.parseColor("#ff5fb5"), 5.0F, ahek.b(this.jdField_a_of_type_Ahek).getMeasuredWidth(), ahek.b(this.jdField_a_of_type_Ahek).getMeasuredHeight()));
      ahek.a(this.jdField_a_of_type_Ahek).setImageResource(2130839246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahev
 * JD-Core Version:    0.7.0.1
 */