package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ad
  extends a
{
  public int xrC = 0;
  
  public ad()
  {
    this.xqq = 312;
  }
  
  public final Boolean cUG()
  {
    if (this.xra < 4) {
      return Boolean.valueOf(false);
    }
    this.xrC = util.ae(this.xqk, this.xqZ);
    if (this.xra < this.xrC * 10 + 4) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public final int cUI()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.xrC) {
        return 0;
      }
      if (util.ad(this.xqk, this.xqZ + 4 + i * 10) == 266) {
        return util.ae(this.xqk, i * 10 + (this.xqZ + 4) + 2);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ad
 * JD-Core Version:    0.7.0.1
 */