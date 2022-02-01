import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahub
  implements View.OnClickListener
{
  ahub(ahua paramahua, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((ahua.a(this.jdField_a_of_type_Ahua) == null) || (ahua.a(this.jdField_a_of_type_Ahua).a.a(this.jdField_a_of_type_JavaLangString) == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = ahua.a(this.jdField_a_of_type_Ahua).a.a(this.jdField_a_of_type_JavaLangString, ahua.a(this.jdField_a_of_type_Ahua).jdField_d_of_type_Int, ahua.a(this.jdField_a_of_type_Ahua).jdField_d_of_type_JavaUtilList);
    String str2 = ahua.a(this.jdField_a_of_type_Ahua) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      bcst.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 1, 0, str2, str1, "", "");
      this.jdField_a_of_type_Ahua.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahub
 * JD-Core Version:    0.7.0.1
 */