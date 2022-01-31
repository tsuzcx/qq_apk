import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class aenl
  implements ViewTreeObserver.OnPreDrawListener
{
  aenl(aena paramaena, aenn paramaenn) {}
  
  public boolean onPreDraw()
  {
    aena.a(this.jdField_a_of_type_Aena).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Aenn.b == 1)
    {
      aena.a(this.jdField_a_of_type_Aena).setBackgroundDrawable(new anov(Color.parseColor("#1fa4fc"), 5.0F, actn.a(14.0F, this.jdField_a_of_type_Aena.a.getResources()), actn.a(14.0F, this.jdField_a_of_type_Aena.a.getResources())));
      aena.b(this.jdField_a_of_type_Aena).setBackgroundDrawable(new anov(Color.parseColor("#1fa4fc"), 5.0F, aena.b(this.jdField_a_of_type_Aena).getMeasuredWidth(), aena.b(this.jdField_a_of_type_Aena).getMeasuredHeight()));
      aena.a(this.jdField_a_of_type_Aena).setImageResource(2130838953);
    }
    for (;;)
    {
      aena.a(this.jdField_a_of_type_Aena).setBackgroundDrawable(new anov(Color.parseColor("#b2b5bd"), 5.0F, aena.a(this.jdField_a_of_type_Aena).getMeasuredWidth(), aena.a(this.jdField_a_of_type_Aena).getMeasuredHeight()));
      aena.c(this.jdField_a_of_type_Aena).setBackgroundDrawable(new anov(Color.parseColor("#b2b5bd"), 5.0F, aena.c(this.jdField_a_of_type_Aena).getMeasuredWidth(), aena.c(this.jdField_a_of_type_Aena).getMeasuredHeight()));
      return true;
      aena.a(this.jdField_a_of_type_Aena).setBackgroundDrawable(new anov(Color.parseColor("#ff5fb5"), 5.0F, actn.a(14.0F, this.jdField_a_of_type_Aena.a.getResources()), actn.a(14.0F, this.jdField_a_of_type_Aena.a.getResources())));
      aena.b(this.jdField_a_of_type_Aena).setBackgroundDrawable(new anov(Color.parseColor("#ff5fb5"), 5.0F, aena.b(this.jdField_a_of_type_Aena).getMeasuredWidth(), aena.b(this.jdField_a_of_type_Aena).getMeasuredHeight()));
      aena.a(this.jdField_a_of_type_Aena).setImageResource(2130838952);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenl
 * JD-Core Version:    0.7.0.1
 */