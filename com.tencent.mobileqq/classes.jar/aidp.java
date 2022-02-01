import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aidp
  implements View.OnClickListener
{
  aidp(aido paramaido, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((aido.a(this.jdField_a_of_type_Aido) == null) || (aido.a(this.jdField_a_of_type_Aido).a.a(this.jdField_a_of_type_JavaLangString) == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = aido.a(this.jdField_a_of_type_Aido).a.a(this.jdField_a_of_type_JavaLangString, aido.a(this.jdField_a_of_type_Aido).jdField_d_of_type_Int, aido.a(this.jdField_a_of_type_Aido).jdField_d_of_type_JavaUtilList);
    String str2 = aido.a(this.jdField_a_of_type_Aido) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      bdll.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 1, 0, str2, str1, "", "");
      this.jdField_a_of_type_Aido.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidp
 * JD-Core Version:    0.7.0.1
 */