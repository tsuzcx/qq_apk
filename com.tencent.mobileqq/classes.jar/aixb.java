import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aixb
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  
  protected aixb(aiwy paramaiwy) {}
  
  public void onClick(View paramView)
  {
    if (aiwy.a(this.jdField_a_of_type_Aiwy) != null) {
      aiwy.a(this.jdField_a_of_type_Aiwy).a(this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixb
 * JD-Core Version:    0.7.0.1
 */