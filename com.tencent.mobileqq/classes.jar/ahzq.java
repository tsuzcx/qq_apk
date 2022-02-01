import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahzq
  implements View.OnClickListener
{
  ahzq(ahzo paramahzo, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((ahzo.a(this.jdField_a_of_type_Ahzo) != null) && (ahzo.a(this.jdField_a_of_type_Ahzo).isShowing())) {
      ahzo.a(this.jdField_a_of_type_Ahzo).dismiss();
    }
    if ((this.jdField_a_of_type_Ahzo.a != null) && (this.jdField_a_of_type_Ahzo.a.isShowing()))
    {
      this.jdField_a_of_type_Ahzo.a.dismiss();
      this.jdField_a_of_type_Ahzo.a = null;
    }
    ahzo.a(this.jdField_a_of_type_Ahzo, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzq
 * JD-Core Version:    0.7.0.1
 */