import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import java.util.ArrayList;

class ahxd
  implements View.OnClickListener
{
  ahxd(ahww paramahww, int paramInt, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    if (!ahww.a(this.jdField_a_of_type_Ahww))
    {
      if (this.jdField_a_of_type_Int == 1) {
        SDKSetEmotionPreviewFragment.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), ahww.a(this.jdField_a_of_type_Ahww), null);
      }
    }
    else {
      return;
    }
    paramView = new Intent();
    paramView.putStringArrayListExtra("path_list", this.jdField_a_of_type_JavaUtilArrayList);
    PublicFragmentActivity.a(ahww.a(this.jdField_a_of_type_Ahww), paramView, SDKSetEmotionPreviewFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxd
 * JD-Core Version:    0.7.0.1
 */