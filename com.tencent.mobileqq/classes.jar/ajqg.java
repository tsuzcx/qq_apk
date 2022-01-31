import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ajqg
  extends hp
{
  private ajqg(ajqe paramajqe) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((ajqe.a(this.a) != null) && (ajqe.a(this.a).hasMessages(paramInt))) {
      ajqe.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqg
 * JD-Core Version:    0.7.0.1
 */