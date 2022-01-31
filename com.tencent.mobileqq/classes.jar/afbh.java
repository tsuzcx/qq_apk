import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class afbh
  implements afal
{
  private BaseChatPie a;
  
  public afbh(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a != null)
    {
      BaseActivity localBaseActivity = this.a.a();
      localObject1 = localObject2;
      if (localBaseActivity != null) {
        localObject1 = localBaseActivity.getIntent();
      }
    }
    a((Intent)localObject1);
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.a == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.a.a;
    } while ((localQQAppInterface == null) || (!paramIntent.getBooleanExtra("key_reactive_push_tip", false)));
    azmj.b(localQQAppInterface, "dc00898", "", "", "0X800A1BF", "0X800A1BF", 0, 0, "", "", "", "");
  }
  
  public int[] a()
  {
    return new int[] { 2, 11 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbh
 * JD-Core Version:    0.7.0.1
 */