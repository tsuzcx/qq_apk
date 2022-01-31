public class aglq
  extends aglx
{
  private aglx i;
  
  public aglq(aglx paramaglx)
  {
    this.i = paramaglx;
  }
  
  public boolean a()
  {
    return this.i.a();
  }
  
  public boolean a(String paramString)
  {
    if (!super.a(paramString)) {
      return false;
    }
    String[] arrayOfString = agmo.a(paramString);
    if ((arrayOfString != null) && ("image".equals(arrayOfString[0])) && ("gif".equals(arrayOfString[1]))) {
      return true;
    }
    return this.i.a(paramString);
  }
  
  public boolean b()
  {
    return this.i.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aglq
 * JD-Core Version:    0.7.0.1
 */