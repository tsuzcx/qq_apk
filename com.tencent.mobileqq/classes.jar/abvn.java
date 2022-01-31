import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

class abvn
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  abvn(abvl paramabvl) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      abvl.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abvn
 * JD-Core Version:    0.7.0.1
 */