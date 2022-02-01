import android.content.Context;
import android.graphics.Color;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class aiij
  implements ViewTreeObserver.OnPreDrawListener
{
  aiij(aihy paramaihy, aiil paramaiil) {}
  
  public boolean onPreDraw()
  {
    aihy.a(this.jdField_a_of_type_Aihy).getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.jdField_a_of_type_Aiil.b == 1)
    {
      aihy.a(this.jdField_a_of_type_Aihy).setBackgroundDrawable(new asda(Color.parseColor("#1fa4fc"), 5.0F, agej.a(14.0F, this.jdField_a_of_type_Aihy.a.getResources()), agej.a(14.0F, this.jdField_a_of_type_Aihy.a.getResources())));
      aihy.b(this.jdField_a_of_type_Aihy).setBackgroundDrawable(new asda(Color.parseColor("#1fa4fc"), 5.0F, aihy.b(this.jdField_a_of_type_Aihy).getMeasuredWidth(), aihy.b(this.jdField_a_of_type_Aihy).getMeasuredHeight()));
      aihy.a(this.jdField_a_of_type_Aihy).setImageResource(2130839212);
    }
    for (;;)
    {
      aihy.a(this.jdField_a_of_type_Aihy).setBackgroundDrawable(new asda(Color.parseColor("#b2b5bd"), 5.0F, aihy.a(this.jdField_a_of_type_Aihy).getMeasuredWidth(), aihy.a(this.jdField_a_of_type_Aihy).getMeasuredHeight()));
      aihy.c(this.jdField_a_of_type_Aihy).setBackgroundDrawable(new asda(Color.parseColor("#b2b5bd"), 5.0F, aihy.c(this.jdField_a_of_type_Aihy).getMeasuredWidth(), aihy.c(this.jdField_a_of_type_Aihy).getMeasuredHeight()));
      return true;
      aihy.a(this.jdField_a_of_type_Aihy).setBackgroundDrawable(new asda(Color.parseColor("#ff5fb5"), 5.0F, agej.a(14.0F, this.jdField_a_of_type_Aihy.a.getResources()), agej.a(14.0F, this.jdField_a_of_type_Aihy.a.getResources())));
      aihy.b(this.jdField_a_of_type_Aihy).setBackgroundDrawable(new asda(Color.parseColor("#ff5fb5"), 5.0F, aihy.b(this.jdField_a_of_type_Aihy).getMeasuredWidth(), aihy.b(this.jdField_a_of_type_Aihy).getMeasuredHeight()));
      aihy.a(this.jdField_a_of_type_Aihy).setImageResource(2130839211);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiij
 * JD-Core Version:    0.7.0.1
 */