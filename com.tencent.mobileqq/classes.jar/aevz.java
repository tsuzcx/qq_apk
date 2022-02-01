import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;

public class aevz
  extends asvt
{
  public aevz(Leba paramLeba) {}
  
  protected void l_(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.lebatab.leba", 2, "onUpdateRedPoint " + paramInt);
    }
    if (Leba.a(this.a) != null) {
      Leba.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevz
 * JD-Core Version:    0.7.0.1
 */