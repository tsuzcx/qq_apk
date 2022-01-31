import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.BaseApplication;

class adrm
  implements Runnable
{
  adrm(adrk paramadrk, ActionGlobalData paramActionGlobalData) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Adrk.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Adrk.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b).setBackgroundColor(0);
      this.jdField_a_of_type_Adrk.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.g();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.c)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131433564), false))) {
      this.jdField_a_of_type_Adrk.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.aB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adrm
 * JD-Core Version:    0.7.0.1
 */