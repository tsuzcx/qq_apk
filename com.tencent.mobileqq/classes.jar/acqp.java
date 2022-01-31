import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.widget.QQToast;

public class acqp
  extends alnn
{
  public acqp(EditActivity paramEditActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    EditActivity.a(this.a);
    if (paramBoolean)
    {
      paramObject = (CustomEmotionData)paramObject;
      if (paramObject != null)
      {
        ((apkf)this.a.app.getManager(103)).c(paramObject);
        EditActivity.b(this.a);
      }
    }
    while (!(paramObject instanceof String)) {
      return;
    }
    QQToast.a(this.a, 1, (String)paramObject, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqp
 * JD-Core Version:    0.7.0.1
 */