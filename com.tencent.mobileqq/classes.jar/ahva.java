import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ahva
  extends anaz
{
  public ahva(BlessResultActivity paramBlessResultActivity) {}
  
  public void onCheckRealNameRsp(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoRedbag, onCheckRealNameRsp in bless");
    }
    if ((paramBoolean) && (paramInt == bbwb.a)) {
      bfur.a(this.a.getActivity(), 0, null, this.a.getString(2131718471), 2131718473, 2131718472, new ahvb(this), new ahvc(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahva
 * JD-Core Version:    0.7.0.1
 */