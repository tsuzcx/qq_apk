import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Leba.28.1;
import com.tencent.qphone.base.util.QLog;

public class adow
  extends anwh
{
  public adow(Leba paramLeba) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onReadInJoyNotifyRedTouchUpdate, isSuccess=" + paramBoolean1 + ",isUpdate=" + paramBoolean2 + ", type=" + paramInt);
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt & 0x1) != 0)) {
      this.a.b(new Leba.28.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adow
 * JD-Core Version:    0.7.0.1
 */