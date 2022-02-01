import cooperation.wadl.ipc.WadlResult;

public abstract interface abud
{
  public abstract void onTaskComplete(WadlResult paramWadlResult);
  
  public abstract void onTaskDeleted(String paramString1, String paramString2);
  
  public abstract void onTaskInstall(WadlResult paramWadlResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abud
 * JD-Core Version:    0.7.0.1
 */