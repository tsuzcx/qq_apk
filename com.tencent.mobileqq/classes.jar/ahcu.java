import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.qphone.base.util.QLog;

public class ahcu
  extends amco
{
  public ahcu(BlessResultActivity paramBlessResultActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoRedbag, onCheckRealNameRsp in bless");
    }
    if ((paramBoolean) && (paramInt == azjh.a)) {
      bdgm.a(this.a.getActivity(), 0, null, this.a.getString(2131720135), 2131720137, 2131720136, new ahcv(this), new ahcw(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcu
 * JD-Core Version:    0.7.0.1
 */