import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class agop
  implements ViewTreeObserver.OnPreDrawListener
{
  agop(agoe paramagoe, agor paramagor) {}
  
  public boolean onPreDraw()
  {
    agoe.a(this.jdField_a_of_type_Agoe).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Agor.b == 1)
    {
      agoe.a(this.jdField_a_of_type_Agoe).setBackgroundDrawable(new apkq(Color.parseColor("#1fa4fc"), 5.0F, aepi.a(14.0F, this.jdField_a_of_type_Agoe.a.getResources()), aepi.a(14.0F, this.jdField_a_of_type_Agoe.a.getResources())));
      agoe.b(this.jdField_a_of_type_Agoe).setBackgroundDrawable(new apkq(Color.parseColor("#1fa4fc"), 5.0F, agoe.b(this.jdField_a_of_type_Agoe).getMeasuredWidth(), agoe.b(this.jdField_a_of_type_Agoe).getMeasuredHeight()));
      agoe.a(this.jdField_a_of_type_Agoe).setImageResource(2130839034);
    }
    for (;;)
    {
      agoe.a(this.jdField_a_of_type_Agoe).setBackgroundDrawable(new apkq(Color.parseColor("#b2b5bd"), 5.0F, agoe.a(this.jdField_a_of_type_Agoe).getMeasuredWidth(), agoe.a(this.jdField_a_of_type_Agoe).getMeasuredHeight()));
      agoe.c(this.jdField_a_of_type_Agoe).setBackgroundDrawable(new apkq(Color.parseColor("#b2b5bd"), 5.0F, agoe.c(this.jdField_a_of_type_Agoe).getMeasuredWidth(), agoe.c(this.jdField_a_of_type_Agoe).getMeasuredHeight()));
      return true;
      agoe.a(this.jdField_a_of_type_Agoe).setBackgroundDrawable(new apkq(Color.parseColor("#ff5fb5"), 5.0F, aepi.a(14.0F, this.jdField_a_of_type_Agoe.a.getResources()), aepi.a(14.0F, this.jdField_a_of_type_Agoe.a.getResources())));
      agoe.b(this.jdField_a_of_type_Agoe).setBackgroundDrawable(new apkq(Color.parseColor("#ff5fb5"), 5.0F, agoe.b(this.jdField_a_of_type_Agoe).getMeasuredWidth(), agoe.b(this.jdField_a_of_type_Agoe).getMeasuredHeight()));
      agoe.a(this.jdField_a_of_type_Agoe).setImageResource(2130839033);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agop
 * JD-Core Version:    0.7.0.1
 */