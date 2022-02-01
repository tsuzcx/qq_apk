import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ahzn
  implements ViewTreeObserver.OnPreDrawListener
{
  ahzn(ahzc paramahzc, ahzp paramahzp) {}
  
  public boolean onPreDraw()
  {
    ahzc.a(this.jdField_a_of_type_Ahzc).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Ahzp.b == 1)
    {
      ahzc.a(this.jdField_a_of_type_Ahzc).setBackgroundDrawable(new asbh(Color.parseColor("#1fa4fc"), 5.0F, AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahzc.mContext.getResources()), AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahzc.mContext.getResources())));
      ahzc.b(this.jdField_a_of_type_Ahzc).setBackgroundDrawable(new asbh(Color.parseColor("#1fa4fc"), 5.0F, ahzc.b(this.jdField_a_of_type_Ahzc).getMeasuredWidth(), ahzc.b(this.jdField_a_of_type_Ahzc).getMeasuredHeight()));
      ahzc.a(this.jdField_a_of_type_Ahzc).setImageResource(2130839268);
    }
    for (;;)
    {
      ahzc.a(this.jdField_a_of_type_Ahzc).setBackgroundDrawable(new asbh(Color.parseColor("#b2b5bd"), 5.0F, ahzc.a(this.jdField_a_of_type_Ahzc).getMeasuredWidth(), ahzc.a(this.jdField_a_of_type_Ahzc).getMeasuredHeight()));
      ahzc.c(this.jdField_a_of_type_Ahzc).setBackgroundDrawable(new asbh(Color.parseColor("#b2b5bd"), 5.0F, ahzc.c(this.jdField_a_of_type_Ahzc).getMeasuredWidth(), ahzc.c(this.jdField_a_of_type_Ahzc).getMeasuredHeight()));
      return true;
      ahzc.a(this.jdField_a_of_type_Ahzc).setBackgroundDrawable(new asbh(Color.parseColor("#ff5fb5"), 5.0F, AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahzc.mContext.getResources()), AIOUtils.dp2px(14.0F, this.jdField_a_of_type_Ahzc.mContext.getResources())));
      ahzc.b(this.jdField_a_of_type_Ahzc).setBackgroundDrawable(new asbh(Color.parseColor("#ff5fb5"), 5.0F, ahzc.b(this.jdField_a_of_type_Ahzc).getMeasuredWidth(), ahzc.b(this.jdField_a_of_type_Ahzc).getMeasuredHeight()));
      ahzc.a(this.jdField_a_of_type_Ahzc).setImageResource(2130839267);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzn
 * JD-Core Version:    0.7.0.1
 */