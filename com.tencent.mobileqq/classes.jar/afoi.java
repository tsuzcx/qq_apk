import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController.1;
import com.tencent.mobileqq.activity.aio.AIOTipsController.2;
import com.tencent.qphone.base.util.QLog;

public class afoi
{
  public afoj a;
  private ViewGroup a;
  
  public afoi(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
  }
  
  public void a(afoj paramafoj)
  {
    this.jdField_a_of_type_Afoj = paramafoj;
  }
  
  public void a(ailp paramailp)
  {
    if (QLog.isColorLevel()) {
      if (paramailp != null) {
        break label65;
      }
    }
    label65:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramailp)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called object=" + str);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.2(this, paramailp));
      return;
    }
  }
  
  public void a(View paramView, ailp paramailp1, ailp paramailp2)
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
        if (paramailp2 != null) {
          break label158;
        }
      }
    }
    label158:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramailp2)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called childIndex = " + j + " object=" + str);
      paramView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.1(this, paramailp1, paramailp2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afoi
 * JD-Core Version:    0.7.0.1
 */