import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class aajl
  implements View.OnClickListener
{
  aajl(aajp paramaajp, String paramString, bkho parambkho) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aajp.a(false, this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_Bkho.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajl
 * JD-Core Version:    0.7.0.1
 */