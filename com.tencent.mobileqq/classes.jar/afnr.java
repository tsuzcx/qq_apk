import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class afnr
  implements View.OnClickListener
{
  afnr(afnq paramafnq, long paramLong) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uinType", this.jdField_a_of_type_Afnq.a.a);
    localIntent.putExtra("uniseq", this.jdField_a_of_type_Long);
    localIntent.putExtra("public_fragment_window_feature", 1);
    adpn.a(paramView.getContext(), localIntent, PublicTransFragmentActivity.class, ScoreQAVFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnr
 * JD-Core Version:    0.7.0.1
 */