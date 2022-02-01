import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class alzr
  implements View.OnClickListener
{
  alzr(alzq paramalzq, alzp paramalzp, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Alzp.a.isChecked()) {}
    for (((aohd)this.jdField_a_of_type_Alzq.a.get(this.jdField_a_of_type_Int)).a = false;; ((aohd)this.jdField_a_of_type_Alzq.a.get(this.jdField_a_of_type_Int)).a = true)
    {
      this.jdField_a_of_type_Alzq.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Alzq.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzr
 * JD-Core Version:    0.7.0.1
 */