import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ahmm
{
  public static bfuw a;
  public static bfuw b = new bfuw(2131364296, BaseApplicationImpl.getContext().getString(2131720110), BaseApplicationImpl.getContext().getString(2131720110), 2130843491);
  public static bfuw c = new bfuw(2131364293, BaseApplicationImpl.getContext().getString(2131720108), BaseApplicationImpl.getContext().getString(2131720108), 2130843490);
  public Activity a;
  private bfut jdField_a_of_type_Bfut;
  private bfux jdField_a_of_type_Bfux;
  private bfuy jdField_a_of_type_Bfuy;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<bfuw> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Bfuw = new bfuw(2131364295, BaseApplicationImpl.getContext().getString(2131720109), BaseApplicationImpl.getContext().getString(2131720109), 2130843492);
  }
  
  public ahmm(Activity paramActivity, List<bfuw> paramList, bfux parambfux)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bfux = parambfux;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bfut != null) && (this.jdField_a_of_type_Bfut.isShowing());
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
    this.jdField_a_of_type_Bfut = bfut.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Bfux, this.jdField_a_of_type_Bfuy);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bfut.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bfut == null) {
      b();
    }
    this.jdField_a_of_type_Bfut.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmm
 * JD-Core Version:    0.7.0.1
 */