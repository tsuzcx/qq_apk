import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahtf
  implements View.OnClickListener
{
  ahtf(ahte paramahte, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((ahte.a(this.jdField_a_of_type_Ahte) == null) || (ahte.a(this.jdField_a_of_type_Ahte).a.a(this.jdField_a_of_type_JavaLangString) == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = ahte.a(this.jdField_a_of_type_Ahte).a.a(this.jdField_a_of_type_JavaLangString, ahte.a(this.jdField_a_of_type_Ahte).jdField_d_of_type_Int, ahte.a(this.jdField_a_of_type_Ahte).jdField_d_of_type_JavaUtilList);
    String str2 = ahte.a(this.jdField_a_of_type_Ahte) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      bdla.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 1, 0, str2, str1, "", "");
      this.jdField_a_of_type_Ahte.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtf
 * JD-Core Version:    0.7.0.1
 */