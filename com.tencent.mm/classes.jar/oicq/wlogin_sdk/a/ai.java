package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ai
  extends a
{
  public int xrH = 0;
  public int xrI = 0;
  public int xrJ = 0;
  
  public ai()
  {
    this.xqq = 326;
  }
  
  public final Boolean cUG()
  {
    if (this.xra < 12) {
      return Boolean.valueOf(false);
    }
    int i = util.ad(this.xqk, this.xqZ + 4);
    if (this.xra < i + 12) {
      return Boolean.valueOf(false);
    }
    this.xrH = i;
    i = util.ad(this.xqk, this.xqZ + 6 + this.xrH);
    if (this.xra < this.xrH + 12 + i) {
      return Boolean.valueOf(false);
    }
    this.xrI = i;
    i = util.ad(this.xqk, this.xqZ + 10 + this.xrH + this.xrI);
    if (this.xra < this.xrH + 12 + this.xrI + i) {
      return Boolean.valueOf(false);
    }
    this.xrJ = i;
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ai
 * JD-Core Version:    0.7.0.1
 */