import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class agka
  implements ViewTreeObserver.OnPreDrawListener
{
  agka(agjp paramagjp, agkc paramagkc) {}
  
  public boolean onPreDraw()
  {
    agjp.a(this.jdField_a_of_type_Agjp).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Agkc.b == 1)
    {
      agjp.a(this.jdField_a_of_type_Agjp).setBackgroundDrawable(new apgh(Color.parseColor("#1fa4fc"), 5.0F, aekt.a(14.0F, this.jdField_a_of_type_Agjp.a.getResources()), aekt.a(14.0F, this.jdField_a_of_type_Agjp.a.getResources())));
      agjp.b(this.jdField_a_of_type_Agjp).setBackgroundDrawable(new apgh(Color.parseColor("#1fa4fc"), 5.0F, agjp.b(this.jdField_a_of_type_Agjp).getMeasuredWidth(), agjp.b(this.jdField_a_of_type_Agjp).getMeasuredHeight()));
      agjp.a(this.jdField_a_of_type_Agjp).setImageResource(2130839033);
    }
    for (;;)
    {
      agjp.a(this.jdField_a_of_type_Agjp).setBackgroundDrawable(new apgh(Color.parseColor("#b2b5bd"), 5.0F, agjp.a(this.jdField_a_of_type_Agjp).getMeasuredWidth(), agjp.a(this.jdField_a_of_type_Agjp).getMeasuredHeight()));
      agjp.c(this.jdField_a_of_type_Agjp).setBackgroundDrawable(new apgh(Color.parseColor("#b2b5bd"), 5.0F, agjp.c(this.jdField_a_of_type_Agjp).getMeasuredWidth(), agjp.c(this.jdField_a_of_type_Agjp).getMeasuredHeight()));
      return true;
      agjp.a(this.jdField_a_of_type_Agjp).setBackgroundDrawable(new apgh(Color.parseColor("#ff5fb5"), 5.0F, aekt.a(14.0F, this.jdField_a_of_type_Agjp.a.getResources()), aekt.a(14.0F, this.jdField_a_of_type_Agjp.a.getResources())));
      agjp.b(this.jdField_a_of_type_Agjp).setBackgroundDrawable(new apgh(Color.parseColor("#ff5fb5"), 5.0F, agjp.b(this.jdField_a_of_type_Agjp).getMeasuredWidth(), agjp.b(this.jdField_a_of_type_Agjp).getMeasuredHeight()));
      agjp.a(this.jdField_a_of_type_Agjp).setImageResource(2130839032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agka
 * JD-Core Version:    0.7.0.1
 */