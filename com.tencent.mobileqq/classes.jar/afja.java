import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import java.util.ArrayList;

class afja
  implements View.OnClickListener
{
  afja(afiu paramafiu, int paramInt, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    if (!afiu.a(this.jdField_a_of_type_Afiu))
    {
      if (this.jdField_a_of_type_Int == 1) {
        SDKSetEmotionPreviewFragment.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), afiu.a(this.jdField_a_of_type_Afiu), null);
      }
    }
    else {
      return;
    }
    paramView = new Intent();
    paramView.putStringArrayListExtra("path_list", this.jdField_a_of_type_JavaUtilArrayList);
    PublicFragmentActivity.a(afiu.a(this.jdField_a_of_type_Afiu), paramView, SDKSetEmotionPreviewFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afja
 * JD-Core Version:    0.7.0.1
 */