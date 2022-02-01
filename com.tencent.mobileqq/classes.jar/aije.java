import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aije
  implements View.OnClickListener
{
  aije(aijc paramaijc, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((aijc.a(this.jdField_a_of_type_Aijc) != null) && (aijc.a(this.jdField_a_of_type_Aijc).isShowing())) {
      aijc.a(this.jdField_a_of_type_Aijc).dismiss();
    }
    if ((this.jdField_a_of_type_Aijc.a != null) && (this.jdField_a_of_type_Aijc.a.isShowing()))
    {
      this.jdField_a_of_type_Aijc.a.dismiss();
      this.jdField_a_of_type_Aijc.a = null;
    }
    aijc.a(this.jdField_a_of_type_Aijc, this.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aije
 * JD-Core Version:    0.7.0.1
 */