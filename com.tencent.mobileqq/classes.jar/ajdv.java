import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ajdv
{
  public static bhvt a;
  public static bhvt b = new bhvt(2131364364, BaseApplicationImpl.getContext().getString(2131720646), BaseApplicationImpl.getContext().getString(2131720646), 2130843850);
  public static bhvt c = new bhvt(2131364361, BaseApplicationImpl.getContext().getString(2131720644), BaseApplicationImpl.getContext().getString(2131720644), 2130843849);
  public Activity a;
  private bhvq jdField_a_of_type_Bhvq;
  private bhvu jdField_a_of_type_Bhvu;
  private bhvv jdField_a_of_type_Bhvv;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<bhvt> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Bhvt = new bhvt(2131364363, BaseApplicationImpl.getContext().getString(2131720645), BaseApplicationImpl.getContext().getString(2131720645), 2130843851);
  }
  
  public ajdv(Activity paramActivity, List<bhvt> paramList, bhvu parambhvu)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bhvu = parambhvu;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bhvq != null) && (this.jdField_a_of_type_Bhvq.isShowing());
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(i));
        i += 1;
      }
    }
    this.jdField_a_of_type_Bhvq = bhvq.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Bhvu, this.jdField_a_of_type_Bhvv);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bhvq.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bhvq == null) {
      b();
    }
    this.jdField_a_of_type_Bhvq.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdv
 * JD-Core Version:    0.7.0.1
 */