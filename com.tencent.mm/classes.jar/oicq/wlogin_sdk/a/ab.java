package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ab
  extends a
{
  public int xrB = 0;
  
  public ab()
  {
    this.xqq = 306;
  }
  
  public final Boolean cUG()
  {
    if (this.xra < 2) {
      return Boolean.valueOf(false);
    }
    this.xrB = util.ad(this.xqk, this.xqZ);
    if (this.xrB + 2 > this.xra) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ab
 * JD-Core Version:    0.7.0.1
 */