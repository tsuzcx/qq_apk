import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController.1;
import com.tencent.mobileqq.activity.aio.AIOTipsController.2;
import com.tencent.qphone.base.util.QLog;

public class acis
{
  public acit a;
  private ViewGroup a;
  
  public acis(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
  }
  
  public void a(acit paramacit)
  {
    this.jdField_a_of_type_Acit = paramacit;
  }
  
  public void a(aenz paramaenz)
  {
    if (QLog.isColorLevel()) {
      if (paramaenz != null) {
        break label65;
      }
    }
    label65:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramaenz)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called object=" + str);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.2(this, paramaenz));
      return;
    }
  }
  
  public void a(View paramView, aenz paramaenz)
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
        if (paramaenz != null) {
          break label152;
        }
      }
    }
    label152:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramaenz)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called childIndex = " + j + " object=" + str);
      paramView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.post(new AIOTipsController.1(this, paramaenz));
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acis
 * JD-Core Version:    0.7.0.1
 */