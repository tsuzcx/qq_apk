import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aadd
  implements View.OnClickListener
{
  aadd(aadb paramaadb1, aadb paramaadb2, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.b.a.a(this.jdField_a_of_type_Aadb, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadd
 * JD-Core Version:    0.7.0.1
 */