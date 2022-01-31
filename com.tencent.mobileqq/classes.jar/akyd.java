import android.view.View;
import com.tencent.mobileqq.arcard.ARCardLoadingProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.BaseApplication;

class akyd
  implements Runnable
{
  akyd(akyc paramakyc, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (((ARCardLoadingProgressView)this.jdField_a_of_type_Akyc.a.getView().findViewById(2131375511)).getVisibility() == 0)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0))
      {
        WorldCupShareFragment.a(this.jdField_a_of_type_Akyc.a);
        WorldCupShareFragment.b(this.jdField_a_of_type_Akyc.a);
      }
    }
    else {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Int == 12)
    {
      i = 2131439380;
      WorldCupShareFragment.a("0X8009319", 2);
    }
    for (;;)
    {
      QQToast.a(BaseApplication.getContext(), 1, i, 0).a();
      break;
      i = 2131439375;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyd
 * JD-Core Version:    0.7.0.1
 */