import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class adyt
  extends anuw
{
  public adyt(BaseChatPie paramBaseChatPie) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.d(this.a, paramBoolean, paramObject);
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.aR();
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    ((agss)this.a.a(70)).a();
    if (paramBoolean)
    {
      this.a.a.showDialog(232);
      return;
    }
    this.a.a.showDialog(233);
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays");
      }
      this.a.aR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyt
 * JD-Core Version:    0.7.0.1
 */