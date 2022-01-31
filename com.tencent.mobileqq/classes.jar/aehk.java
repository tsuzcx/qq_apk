import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;

class aehk
  implements DialogInterface.OnDismissListener
{
  aehk(aehj paramaehj) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    int i = 1;
    paramDialogInterface = new NowVideoReporter().h("video_public").i("clk_cancel").e("1").d(SmallVideoSendFragment.a(this.a.a));
    if (SmallVideoSendFragment.a(this.a.a).l == 1) {
      i = 2;
    }
    paramDialogInterface.a(i).b(this.a.a.getActivity().app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aehk
 * JD-Core Version:    0.7.0.1
 */