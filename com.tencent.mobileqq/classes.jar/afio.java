import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class afio
  implements View.OnClickListener
{
  afio(afim paramafim, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((afim.a(this.jdField_a_of_type_Afim) != null) && (afim.a(this.jdField_a_of_type_Afim).isShowing())) {
      afim.a(this.jdField_a_of_type_Afim).dismiss();
    }
    if ((this.jdField_a_of_type_Afim.a != null) && (this.jdField_a_of_type_Afim.a.isShowing()))
    {
      this.jdField_a_of_type_Afim.a.dismiss();
      this.jdField_a_of_type_Afim.a = null;
    }
    afim.a(this.jdField_a_of_type_Afim, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afio
 * JD-Core Version:    0.7.0.1
 */