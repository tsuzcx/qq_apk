import com.tencent.mobileqq.activity.Leba.30.1;
import com.tencent.qphone.base.util.QLog;

public class abau
  extends akfr
{
  abau(abai paramabai) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onReadInJoyNotifyRedTouchUpdate, isSuccess=" + paramBoolean1 + ",isUpdate=" + paramBoolean2 + ", type=" + paramInt);
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt & 0x1) != 0)) {
      this.a.a(new Leba.30.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abau
 * JD-Core Version:    0.7.0.1
 */