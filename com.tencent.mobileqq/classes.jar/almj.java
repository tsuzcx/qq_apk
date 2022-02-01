import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class almj
{
  public static bloo a;
  public static bloo b = new bloo(2131364622, BaseApplicationImpl.getContext().getString(2131718591), BaseApplicationImpl.getContext().getString(2131718591), 2130844327);
  public static bloo c = new bloo(2131364619, BaseApplicationImpl.getContext().getString(2131718589), BaseApplicationImpl.getContext().getString(2131718589), 2130844326);
  public Activity a;
  private blol jdField_a_of_type_Blol;
  private blop jdField_a_of_type_Blop;
  private bloq jdField_a_of_type_Bloq;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<bloo> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Bloo = new bloo(2131364621, BaseApplicationImpl.getContext().getString(2131718590), BaseApplicationImpl.getContext().getString(2131718590), 2130844328);
  }
  
  public almj(Activity paramActivity, List<bloo> paramList, blop paramblop)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Blop = paramblop;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Blol != null) && (this.jdField_a_of_type_Blol.isShowing());
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
    this.jdField_a_of_type_Blol = blol.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Blop, this.jdField_a_of_type_Bloq);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Blol.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Blol == null) {
      b();
    }
    this.jdField_a_of_type_Blol.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almj
 * JD-Core Version:    0.7.0.1
 */