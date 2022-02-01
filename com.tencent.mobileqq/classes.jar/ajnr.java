import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ajnr
  implements View.OnClickListener
{
  ajnr(ajnk paramajnk, int paramInt, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    if (!ajnk.a(this.jdField_a_of_type_Ajnk))
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label48;
      }
      SDKSetEmotionPreviewFragment.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), ajnk.a(this.jdField_a_of_type_Ajnk), null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("path_list", this.jdField_a_of_type_JavaUtilArrayList);
      PublicFragmentActivity.a(ajnk.a(this.jdField_a_of_type_Ajnk), localIntent, SDKSetEmotionPreviewFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnr
 * JD-Core Version:    0.7.0.1
 */