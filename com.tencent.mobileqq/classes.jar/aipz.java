import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class aipz
  extends aodo
{
  public aipz(BlessResultActivity paramBlessResultActivity) {}
  
  public void onCheckRealNameRsp(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoRedbag, onCheckRealNameRsp in bless");
    }
    if ((paramBoolean) && (paramInt == bdcw.a)) {
      bhdj.a(this.a.getActivity(), 0, null, this.a.getString(2131718857), 2131718859, 2131718858, new aiqa(this), new aiqb(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipz
 * JD-Core Version:    0.7.0.1
 */