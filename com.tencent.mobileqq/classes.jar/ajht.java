import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajht
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  
  protected ajht(ajhq paramajhq) {}
  
  public void onClick(View paramView)
  {
    if (ajhq.a(this.jdField_a_of_type_Ajhq) != null) {
      ajhq.a(this.jdField_a_of_type_Ajhq).a(this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajht
 * JD-Core Version:    0.7.0.1
 */