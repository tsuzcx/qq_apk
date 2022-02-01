import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.15.1;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class adfg
  extends CardObserver
{
  public adfg(EditInfoActivity paramEditInfoActivity) {}
  
  public void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (!this.a.j) {}
    do
    {
      return;
      this.a.j = false;
      this.a.runOnUiThread(new EditInfoActivity.15.1(this, paramBoolean, paramCard, paramInt));
    } while (!QLog.isColorLevel());
    QLog.d("EditInfoActivity", 2, String.format("onGetDetailInfo, isSuccess: %s, resultCode:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfg
 * JD-Core Version:    0.7.0.1
 */