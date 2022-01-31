import com.tencent.qphone.base.util.QLog;

public abstract class akxl
  implements ajtg
{
  public abstract void a(alfw paramalfw);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARLBSObserver", 2, "type=" + paramInt + ", isSuccess=" + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    try
    {
      a((alfw)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new alfw());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxl
 * JD-Core Version:    0.7.0.1
 */