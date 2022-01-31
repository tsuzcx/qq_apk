import com.tencent.qphone.base.util.QLog;

public abstract class akiz
  implements ajfe
{
  public abstract void a(akrk paramakrk);
  
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
      a((akrk)paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      a(new akrk());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akiz
 * JD-Core Version:    0.7.0.1
 */