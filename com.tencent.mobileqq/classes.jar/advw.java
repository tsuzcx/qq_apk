import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.widget.QQToast;

public class advw
  extends anub
{
  public advw(EditActivity paramEditActivity) {}
  
  protected void onModifyFavData(boolean paramBoolean, Object paramObject)
  {
    EditActivity.a(this.a);
    if (paramBoolean)
    {
      paramObject = (CustomEmotionData)paramObject;
      if (paramObject != null)
      {
        ((asfl)this.a.app.getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).c(paramObject);
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
 * Qualified Name:     advw
 * JD-Core Version:    0.7.0.1
 */