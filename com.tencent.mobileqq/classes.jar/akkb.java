import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class akkb
{
  public static bjsy a;
  public static bjsy b = new bjsy(2131364653, BaseApplicationImpl.getContext().getString(2131718839), BaseApplicationImpl.getContext().getString(2131718839), 2130844212);
  public static bjsy c = new bjsy(2131364650, BaseApplicationImpl.getContext().getString(2131718837), BaseApplicationImpl.getContext().getString(2131718837), 2130844211);
  public Activity a;
  private bjsv jdField_a_of_type_Bjsv;
  private bjsz jdField_a_of_type_Bjsz;
  private bjta jdField_a_of_type_Bjta;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<bjsy> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Bjsy = new bjsy(2131364652, BaseApplicationImpl.getContext().getString(2131718838), BaseApplicationImpl.getContext().getString(2131718838), 2130844213);
  }
  
  public akkb(Activity paramActivity, List<bjsy> paramList, bjsz parambjsz)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bjsz = parambjsz;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bjsv != null) && (this.jdField_a_of_type_Bjsv.isShowing());
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
    this.jdField_a_of_type_Bjsv = bjsv.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Bjsz, this.jdField_a_of_type_Bjta);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bjsv.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bjsv == null) {
      b();
    }
    this.jdField_a_of_type_Bjsv.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkb
 * JD-Core Version:    0.7.0.1
 */