import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afzt
  implements View.OnClickListener
{
  afzt(afzr paramafzr, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((afzr.a(this.jdField_a_of_type_Afzr) != null) && (afzr.a(this.jdField_a_of_type_Afzr).isShowing())) {
      afzr.a(this.jdField_a_of_type_Afzr).dismiss();
    }
    if ((this.jdField_a_of_type_Afzr.a != null) && (this.jdField_a_of_type_Afzr.a.isShowing()))
    {
      this.jdField_a_of_type_Afzr.a.dismiss();
      this.jdField_a_of_type_Afzr.a = null;
    }
    afzr.a(this.jdField_a_of_type_Afzr, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzt
 * JD-Core Version:    0.7.0.1
 */