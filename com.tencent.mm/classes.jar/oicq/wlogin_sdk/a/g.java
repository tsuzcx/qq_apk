package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class g
  extends a
{
  public int xrk = 0;
  public int xrl = 0;
  public int xrm = 0;
  public int xrn = 0;
  
  public g()
  {
    this.xqq = 261;
  }
  
  public final Boolean cUG()
  {
    if (this.xra < 2) {
      return Boolean.valueOf(false);
    }
    this.xrl = util.ad(this.xqk, this.xqZ);
    if (this.xra < this.xrl + 2 + 2) {
      return Boolean.valueOf(false);
    }
    this.xrk = util.ad(this.xqk, this.xqZ + 2 + this.xrl);
    if (this.xra < this.xrl + 2 + 2 + this.xrk) {
      return Boolean.valueOf(false);
    }
    this.xrn = (this.xqZ + 2);
    this.xrm = (this.xrl + 2 + 2 + this.xqZ);
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.g
 * JD-Core Version:    0.7.0.1
 */