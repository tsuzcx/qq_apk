import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class agzz
{
  public static beml a;
  public static beml b = new beml(2131298740, BaseApplicationImpl.getContext().getString(2131654209), BaseApplicationImpl.getContext().getString(2131654209), 2130843406);
  public static beml c = new beml(2131298737, BaseApplicationImpl.getContext().getString(2131654207), BaseApplicationImpl.getContext().getString(2131654207), 2130843405);
  public Activity a;
  private bemi jdField_a_of_type_Bemi;
  private bemm jdField_a_of_type_Bemm;
  private bemn jdField_a_of_type_Bemn;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<beml> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Beml = new beml(2131298739, BaseApplicationImpl.getContext().getString(2131654208), BaseApplicationImpl.getContext().getString(2131654208), 2130843407);
  }
  
  public agzz(Activity paramActivity, List<beml> paramList, bemm parambemm)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bemm = parambemm;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bemi != null) && (this.jdField_a_of_type_Bemi.isShowing());
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
    this.jdField_a_of_type_Bemi = bemi.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Bemm, this.jdField_a_of_type_Bemn);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bemi.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bemi == null) {
      b();
    }
    this.jdField_a_of_type_Bemi.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzz
 * JD-Core Version:    0.7.0.1
 */