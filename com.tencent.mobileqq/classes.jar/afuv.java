import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import java.util.ArrayList;

class afuv
  implements View.OnClickListener
{
  afuv(afup paramafup, int paramInt, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    if (!afup.a(this.jdField_a_of_type_Afup))
    {
      if (this.jdField_a_of_type_Int == 1) {
        SDKSetEmotionPreviewFragment.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), afup.a(this.jdField_a_of_type_Afup), null);
      }
    }
    else {
      return;
    }
    paramView = new Intent();
    paramView.putStringArrayListExtra("path_list", this.jdField_a_of_type_JavaUtilArrayList);
    PublicFragmentActivity.a(afup.a(this.jdField_a_of_type_Afup), paramView, SDKSetEmotionPreviewFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuv
 * JD-Core Version:    0.7.0.1
 */