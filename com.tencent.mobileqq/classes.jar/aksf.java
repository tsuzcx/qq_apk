import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aksf
  extends ho
{
  private aksf(aksd paramaksd) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((aksd.a(this.a) != null) && (aksd.a(this.a).hasMessages(paramInt))) {
      aksd.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksf
 * JD-Core Version:    0.7.0.1
 */