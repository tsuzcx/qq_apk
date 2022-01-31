public class afzs
  extends afzz
{
  private afzz i;
  
  public afzs(afzz paramafzz)
  {
    this.i = paramafzz;
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
    String[] arrayOfString = agaq.a(paramString);
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
 * Qualified Name:     afzs
 * JD-Core Version:    0.7.0.1
 */