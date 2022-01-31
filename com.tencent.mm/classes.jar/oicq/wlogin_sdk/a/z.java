package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class z
  extends a
{
  public int xry = 0;
  public int xrz = 0;
  
  public z()
  {
    this.xqq = 293;
  }
  
  public final Boolean cUG()
  {
    if (this.xra < 2) {
      return Boolean.valueOf(false);
    }
    this.xry = util.ad(this.xqk, this.xqZ);
    if (this.xra < this.xry + 2 + 2) {
      return Boolean.valueOf(false);
    }
    this.xrz = util.ad(this.xqk, this.xqZ + 2 + this.xry);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.z
 * JD-Core Version:    0.7.0.1
 */