import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.BaseApplication;

class aenc
  implements Runnable
{
  aenc(aena paramaena, ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Aena.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Aena.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b).setBackgroundColor(0);
      this.jdField_a_of_type_Aena.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.g();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.c)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131433595), false))) {
      this.jdField_a_of_type_Aena.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.aB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenc
 * JD-Core Version:    0.7.0.1
 */