import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class alft
{
  public static blek a;
  public static blek b = new blek(2131364737, BaseApplicationImpl.getContext().getString(2131719232), BaseApplicationImpl.getContext().getString(2131719232), 2130844279);
  public static blek c = new blek(2131364734, BaseApplicationImpl.getContext().getString(2131719230), BaseApplicationImpl.getContext().getString(2131719230), 2130844278);
  public Activity a;
  private bleh jdField_a_of_type_Bleh;
  private blel jdField_a_of_type_Blel;
  private blem jdField_a_of_type_Blem;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<blek> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Blek = new blek(2131364736, BaseApplicationImpl.getContext().getString(2131719231), BaseApplicationImpl.getContext().getString(2131719231), 2130844280);
  }
  
  public alft(Activity paramActivity, List<blek> paramList, blel paramblel)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Blel = paramblel;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bleh != null) && (this.jdField_a_of_type_Bleh.isShowing());
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
    this.jdField_a_of_type_Bleh = bleh.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Blel, this.jdField_a_of_type_Blem);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bleh.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bleh == null) {
      b();
    }
    this.jdField_a_of_type_Bleh.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alft
 * JD-Core Version:    0.7.0.1
 */