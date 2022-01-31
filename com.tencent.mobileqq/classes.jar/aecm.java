import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class aecm
  implements ViewTreeObserver.OnPreDrawListener
{
  aecm(aecb paramaecb, aeco paramaeco) {}
  
  public boolean onPreDraw()
  {
    aecb.a(this.jdField_a_of_type_Aecb).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Aeco.b == 1)
    {
      aecb.a(this.jdField_a_of_type_Aecb).setBackgroundDrawable(new amyn(Color.parseColor("#1fa4fc"), 5.0F, aciy.a(14.0F, this.jdField_a_of_type_Aecb.a.getResources()), aciy.a(14.0F, this.jdField_a_of_type_Aecb.a.getResources())));
      aecb.b(this.jdField_a_of_type_Aecb).setBackgroundDrawable(new amyn(Color.parseColor("#1fa4fc"), 5.0F, aecb.b(this.jdField_a_of_type_Aecb).getMeasuredWidth(), aecb.b(this.jdField_a_of_type_Aecb).getMeasuredHeight()));
      aecb.a(this.jdField_a_of_type_Aecb).setImageResource(2130838932);
    }
    for (;;)
    {
      aecb.a(this.jdField_a_of_type_Aecb).setBackgroundDrawable(new amyn(Color.parseColor("#b2b5bd"), 5.0F, aecb.a(this.jdField_a_of_type_Aecb).getMeasuredWidth(), aecb.a(this.jdField_a_of_type_Aecb).getMeasuredHeight()));
      aecb.c(this.jdField_a_of_type_Aecb).setBackgroundDrawable(new amyn(Color.parseColor("#b2b5bd"), 5.0F, aecb.c(this.jdField_a_of_type_Aecb).getMeasuredWidth(), aecb.c(this.jdField_a_of_type_Aecb).getMeasuredHeight()));
      return true;
      aecb.a(this.jdField_a_of_type_Aecb).setBackgroundDrawable(new amyn(Color.parseColor("#ff5fb5"), 5.0F, aciy.a(14.0F, this.jdField_a_of_type_Aecb.a.getResources()), aciy.a(14.0F, this.jdField_a_of_type_Aecb.a.getResources())));
      aecb.b(this.jdField_a_of_type_Aecb).setBackgroundDrawable(new amyn(Color.parseColor("#ff5fb5"), 5.0F, aecb.b(this.jdField_a_of_type_Aecb).getMeasuredWidth(), aecb.b(this.jdField_a_of_type_Aecb).getMeasuredHeight()));
      aecb.a(this.jdField_a_of_type_Aecb).setImageResource(2130838931);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecm
 * JD-Core Version:    0.7.0.1
 */