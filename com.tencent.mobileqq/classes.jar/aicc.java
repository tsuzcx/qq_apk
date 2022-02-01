import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aicc
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  
  protected aicc(aibz paramaibz) {}
  
  public void onClick(View paramView)
  {
    if (aibz.a(this.jdField_a_of_type_Aibz) != null) {
      aibz.a(this.jdField_a_of_type_Aibz).a(this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicc
 * JD-Core Version:    0.7.0.1
 */