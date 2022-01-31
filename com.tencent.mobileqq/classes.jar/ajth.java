import com.tencent.mobileqq.data.CameraEmotionData;

public class ajth
  implements ajte
{
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt, CameraEmotionData paramCameraEmotionData) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void b(int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (CameraEmotionData)paramObject[1]);
      return;
    case 2: 
      a(((Integer)paramObject).intValue());
      return;
    case 3: 
      b(((Integer)paramObject).intValue());
      return;
    case 4: 
      a();
      return;
    }
    a(paramBoolean, ((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajth
 * JD-Core Version:    0.7.0.1
 */