import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ahhs
  extends hn
{
  private ahhs(ahhq paramahhq) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((ahhq.a(this.a) != null) && (ahhq.a(this.a).hasMessages(paramInt))) {
      ahhq.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhs
 * JD-Core Version:    0.7.0.1
 */