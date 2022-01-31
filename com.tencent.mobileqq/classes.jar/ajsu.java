public final class ajsu
{
  public final int a;
  public final int b;
  
  public ajsu(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static ajsu a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    int i = paramString.indexOf('*');
    if (i < 0) {
      i = paramString.indexOf('x');
    }
    for (;;)
    {
      if (i < 0) {
        throw a(paramString);
      }
      try
      {
        ajsu localajsu = new ajsu(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
        return localajsu;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw a(paramString);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw a(paramString);
      }
    }
  }
  
  private static NumberFormatException a(String paramString)
  {
    throw new NumberFormatException("Invalid SizeF: \"" + paramString + "\"");
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof ajsu));
    paramObject = (ajsu)paramObject;
    if ((this.a == paramObject.a) && (this.b == paramObject.b)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String toString()
  {
    return this.a + "x" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsu
 * JD-Core Version:    0.7.0.1
 */