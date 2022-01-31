import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.widget.QQToast;

public class acps
  extends alkl
{
  public acps(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    this.a.h();
    if (paramBoolean)
    {
      if (paramBoolean1.booleanValue()) {
        DiscussionInfoCardActivity.e(this.a);
      }
      return;
    }
    QQToast.a(this.a, paramInt, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acps
 * JD-Core Version:    0.7.0.1
 */