import com.tencent.mobileqq.now.enter.NowFestivalEnterFragment;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager.ReqNowLiveStatusCallback;
import com.tencent.qphone.base.util.QLog;

public class agem
  implements NowAnswerPreloadManager.ReqNowLiveStatusCallback
{
  public agem(NowFestivalEnterFragment paramNowFestivalEnterFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowFestivalEnterFragment", 2, "reqNowLiveStatusAndOpenRoom result, isAutoOpenRoom=" + paramBoolean);
    }
    NowFestivalEnterFragment.a(this.a, paramBoolean);
    NowFestivalEnterFragment.b(this.a, true);
    if ((!paramBoolean) && (NowFestivalEnterFragment.a(this.a))) {
      NowFestivalEnterFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agem
 * JD-Core Version:    0.7.0.1
 */