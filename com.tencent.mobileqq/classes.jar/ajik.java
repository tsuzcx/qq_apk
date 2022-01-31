import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class ajik
{
  public static biaa a;
  public static biaa b = new biaa(2131364366, BaseApplicationImpl.getContext().getString(2131720658), BaseApplicationImpl.getContext().getString(2131720658), 2130843922);
  public static biaa c = new biaa(2131364363, BaseApplicationImpl.getContext().getString(2131720656), BaseApplicationImpl.getContext().getString(2131720656), 2130843921);
  public Activity a;
  private bhzx jdField_a_of_type_Bhzx;
  private biab jdField_a_of_type_Biab;
  private biac jdField_a_of_type_Biac;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<biaa> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Biaa = new biaa(2131364365, BaseApplicationImpl.getContext().getString(2131720657), BaseApplicationImpl.getContext().getString(2131720657), 2130843923);
  }
  
  public ajik(Activity paramActivity, List<biaa> paramList, biab parambiab)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Biab = parambiab;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bhzx != null) && (this.jdField_a_of_type_Bhzx.isShowing());
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
    this.jdField_a_of_type_Bhzx = bhzx.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Biab, this.jdField_a_of_type_Biac);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bhzx.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bhzx == null) {
      b();
    }
    this.jdField_a_of_type_Bhzx.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajik
 * JD-Core Version:    0.7.0.1
 */