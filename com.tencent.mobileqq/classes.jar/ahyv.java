import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ahyv
  implements ViewTreeObserver.OnPreDrawListener
{
  ahyv(ahyk paramahyk, ahyx paramahyx) {}
  
  public boolean onPreDraw()
  {
    ahyk.a(this.jdField_a_of_type_Ahyk).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Ahyx.b == 1)
    {
      ahyk.a(this.jdField_a_of_type_Ahyk).setBackgroundDrawable(new arnk(Color.parseColor("#1fa4fc"), 5.0F, afur.a(14.0F, this.jdField_a_of_type_Ahyk.a.getResources()), afur.a(14.0F, this.jdField_a_of_type_Ahyk.a.getResources())));
      ahyk.b(this.jdField_a_of_type_Ahyk).setBackgroundDrawable(new arnk(Color.parseColor("#1fa4fc"), 5.0F, ahyk.b(this.jdField_a_of_type_Ahyk).getMeasuredWidth(), ahyk.b(this.jdField_a_of_type_Ahyk).getMeasuredHeight()));
      ahyk.a(this.jdField_a_of_type_Ahyk).setImageResource(2130839204);
    }
    for (;;)
    {
      ahyk.a(this.jdField_a_of_type_Ahyk).setBackgroundDrawable(new arnk(Color.parseColor("#b2b5bd"), 5.0F, ahyk.a(this.jdField_a_of_type_Ahyk).getMeasuredWidth(), ahyk.a(this.jdField_a_of_type_Ahyk).getMeasuredHeight()));
      ahyk.c(this.jdField_a_of_type_Ahyk).setBackgroundDrawable(new arnk(Color.parseColor("#b2b5bd"), 5.0F, ahyk.c(this.jdField_a_of_type_Ahyk).getMeasuredWidth(), ahyk.c(this.jdField_a_of_type_Ahyk).getMeasuredHeight()));
      return true;
      ahyk.a(this.jdField_a_of_type_Ahyk).setBackgroundDrawable(new arnk(Color.parseColor("#ff5fb5"), 5.0F, afur.a(14.0F, this.jdField_a_of_type_Ahyk.a.getResources()), afur.a(14.0F, this.jdField_a_of_type_Ahyk.a.getResources())));
      ahyk.b(this.jdField_a_of_type_Ahyk).setBackgroundDrawable(new arnk(Color.parseColor("#ff5fb5"), 5.0F, ahyk.b(this.jdField_a_of_type_Ahyk).getMeasuredWidth(), ahyk.b(this.jdField_a_of_type_Ahyk).getMeasuredHeight()));
      ahyk.a(this.jdField_a_of_type_Ahyk).setImageResource(2130839203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyv
 * JD-Core Version:    0.7.0.1
 */