import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class abay
  extends ajfo
{
  abay(abai paramabai) {}
  
  protected void onGetWholePeopleVoteLebaSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, String.format(Locale.getDefault(), "onGetWholePeopleVoteLebaSwitch isSuc: %b cur: %b pre: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    }
    if ((paramBoolean1) && (paramBoolean2 != paramBoolean3)) {
      this.a.a.sendEmptyMessage(11340002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abay
 * JD-Core Version:    0.7.0.1
 */