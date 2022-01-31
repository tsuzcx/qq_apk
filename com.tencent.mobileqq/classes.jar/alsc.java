import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class alsc
  implements alpg
{
  protected void a(List<CustomEmotionData> paramList) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (paramObject == null);
      a(((Boolean)paramObject).booleanValue());
      return;
    case 1: 
      try
      {
        a((ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("FavEmoRoamingObserver", 1, "onUploadReq error, ", paramObject);
        return;
      }
    case 2: 
      b(paramBoolean, paramObject);
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alsc
 * JD-Core Version:    0.7.0.1
 */