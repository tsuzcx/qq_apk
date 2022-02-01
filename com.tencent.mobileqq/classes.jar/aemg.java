import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.12.1;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class aemg
  extends anuw
{
  public aemg(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (!this.a.j) {}
    do
    {
      return;
      this.a.j = false;
      this.a.runOnUiThread(new EditInfoActivity.12.1(this, paramBoolean, paramCard, paramInt));
    } while (!QLog.isColorLevel());
    QLog.d("EditInfoActivity", 2, String.format("onGetDetailInfo, isSuccess: %s, resultCode:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemg
 * JD-Core Version:    0.7.0.1
 */