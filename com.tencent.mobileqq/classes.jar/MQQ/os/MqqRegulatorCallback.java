package mqq.os;

public abstract interface MqqRegulatorCallback
{
  public abstract void checkInRegulatorMsg();
  
  public abstract boolean regulatorThread(Thread paramThread);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.os.MqqRegulatorCallback
 * JD-Core Version:    0.7.0.1
 */