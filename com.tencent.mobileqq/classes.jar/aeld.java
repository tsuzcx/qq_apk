import com.tencent.qphone.base.util.QLog;

class aeld
  implements bgwm
{
  aeld(aelc paramaelc) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null))
    {
      QLog.i(aelc.a, 2, "error get pskey...");
      return;
    }
    aelc.a(this.a, paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeld
 * JD-Core Version:    0.7.0.1
 */