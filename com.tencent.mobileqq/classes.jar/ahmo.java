import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ahmo
{
  public static bfuf a;
  public static bfuf b = new bfuf(2131364297, BaseApplicationImpl.getContext().getString(2131720099), BaseApplicationImpl.getContext().getString(2131720099), 2130843490);
  public static bfuf c = new bfuf(2131364294, BaseApplicationImpl.getContext().getString(2131720097), BaseApplicationImpl.getContext().getString(2131720097), 2130843489);
  public Activity a;
  private bfuc jdField_a_of_type_Bfuc;
  private bfug jdField_a_of_type_Bfug;
  private bfuh jdField_a_of_type_Bfuh;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<bfuf> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Bfuf = new bfuf(2131364296, BaseApplicationImpl.getContext().getString(2131720098), BaseApplicationImpl.getContext().getString(2131720098), 2130843491);
  }
  
  public ahmo(Activity paramActivity, List<bfuf> paramList, bfug parambfug)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bfug = parambfug;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bfuc != null) && (this.jdField_a_of_type_Bfuc.isShowing());
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
    this.jdField_a_of_type_Bfuc = bfuc.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Bfug, this.jdField_a_of_type_Bfuh);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bfuc.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bfuc == null) {
      b();
    }
    this.jdField_a_of_type_Bfuc.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmo
 * JD-Core Version:    0.7.0.1
 */