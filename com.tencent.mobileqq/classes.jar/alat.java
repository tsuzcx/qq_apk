import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class alat
{
  public static bknl a;
  public static bknl b = new bknl(2131364577, BaseApplicationImpl.getContext().getString(2131718455), BaseApplicationImpl.getContext().getString(2131718455), 2130844313);
  public static bknl c = new bknl(2131364574, BaseApplicationImpl.getContext().getString(2131718453), BaseApplicationImpl.getContext().getString(2131718453), 2130844312);
  public Activity a;
  private bkni jdField_a_of_type_Bkni;
  private bknm jdField_a_of_type_Bknm;
  private bknn jdField_a_of_type_Bknn;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = null;
  private List<bknl> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Bknl = new bknl(2131364576, BaseApplicationImpl.getContext().getString(2131718454), BaseApplicationImpl.getContext().getString(2131718454), 2130844314);
  }
  
  public alat(Activity paramActivity, List<bknl> paramList, bknm parambknm)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Bknm = parambknm;
  }
  
  @NonNull
  private boolean a()
  {
    return (this.jdField_a_of_type_Bkni != null) && (this.jdField_a_of_type_Bkni.isShowing());
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
    this.jdField_a_of_type_Bkni = bkni.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList, this.jdField_a_of_type_Bknm, this.jdField_a_of_type_Bknn);
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_Bkni.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bkni == null) {
      b();
    }
    this.jdField_a_of_type_Bkni.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alat
 * JD-Core Version:    0.7.0.1
 */