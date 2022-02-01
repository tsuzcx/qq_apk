import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController.1;
import com.tencent.mobileqq.activity.aio.AIOTipsController.2;
import com.tencent.qphone.base.util.QLog;

public class aged
{
  public agee a;
  private ViewGroup a;
  
  public aged(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
  }
  
  public void a(agee paramagee)
  {
    this.jdField_a_of_type_Agee = paramagee;
  }
  
  public void a(aiwf paramaiwf)
  {
    if (QLog.isColorLevel()) {
      if (paramaiwf != null) {
        break label65;
      }
    }
    label65:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramaiwf)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called object=" + str);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.2(this, paramaiwf));
      return;
    }
  }
  
  public void a(View paramView, aiwf paramaiwf)
  {
    int j;
    if (paramView != null)
    {
      j = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(paramView);
      if (j == -1) {
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, new ViewGroup.LayoutParams(-1, -2));
      }
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
      {
        this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i).setVisibility(8);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        if (paramaiwf != null) {
          break label152;
        }
      }
    }
    label152:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramaiwf)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called childIndex = " + j + " object=" + str);
      paramView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.1(this, paramaiwf));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aged
 * JD-Core Version:    0.7.0.1
 */