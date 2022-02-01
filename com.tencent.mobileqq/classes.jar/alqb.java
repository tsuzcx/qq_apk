import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class alqb
  extends ho
{
  private alqb(alpz paramalpz) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((alpz.a(this.a) != null) && (alpz.a(this.a).hasMessages(paramInt))) {
      alpz.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqb
 * JD-Core Version:    0.7.0.1
 */