import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ajlr
  extends hp
{
  private ajlr(ajlp paramajlp) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((ajlp.a(this.a) != null) && (ajlp.a(this.a).hasMessages(paramInt))) {
      ajlp.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlr
 * JD-Core Version:    0.7.0.1
 */