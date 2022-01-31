import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;

public class adgi
  extends aqbl
{
  public adgi(Leba paramLeba) {}
  
  protected void a(int paramInt)
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
 * Qualified Name:     adgi
 * JD-Core Version:    0.7.0.1
 */