import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.database.corrupt.DBFixManager;

class abph
  implements Runnable
{
  abph(abpg paramabpg) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null) {
      this.a.a.a(BaseActivity.sTopActivity, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abph
 * JD-Core Version:    0.7.0.1
 */