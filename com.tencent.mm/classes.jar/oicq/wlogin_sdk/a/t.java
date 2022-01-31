package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class t
  extends a
{
  public int xrw = 0;
  
  public t()
  {
    this.xqq = 282;
  }
  
  public final Boolean cUG()
  {
    if (this.xra < 5) {
      return Boolean.valueOf(false);
    }
    int i = util.ac(this.xqk, this.xqZ + 2 + 1 + 1);
    if (this.xra < i + 5) {
      return Boolean.valueOf(false);
    }
    this.xrw = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.t
 * JD-Core Version:    0.7.0.1
 */