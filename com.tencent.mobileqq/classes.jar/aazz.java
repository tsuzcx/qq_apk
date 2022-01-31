import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.11.1;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class aazz
  extends ajto
{
  public aazz(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (!this.a.j) {}
    do
    {
      return;
      this.a.j = false;
      this.a.runOnUiThread(new EditInfoActivity.11.1(this, paramBoolean, paramCard));
    } while (!QLog.isColorLevel());
    QLog.d("EditInfoActivity", 2, String.format("onGetDetailInfo, isSuccess: %s, resultCode:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aazz
 * JD-Core Version:    0.7.0.1
 */