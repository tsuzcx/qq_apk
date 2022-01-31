import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class afjc
  implements View.OnClickListener
{
  afjc(afjb paramafjb, long paramLong) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uinType", this.jdField_a_of_type_Afjb.a.a);
    localIntent.putExtra("uniseq", this.jdField_a_of_type_Long);
    localIntent.putExtra("public_fragment_window_feature", 1);
    adky.a(paramView.getContext(), localIntent, PublicTransFragmentActivity.class, ScoreQAVFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjc
 * JD-Core Version:    0.7.0.1
 */