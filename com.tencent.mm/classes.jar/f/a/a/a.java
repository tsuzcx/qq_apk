package f.a.a;

import java.io.OutputStream;

public final class a
{
  public int xqf;
  public byte[] xvc;
  public int xvd = 0;
  public int xve;
  public OutputStream xvf;
  
  public final byte KR(int paramInt)
  {
    int i = this.xqf - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.xvd;
    }
    return this.xvc[paramInt];
  }
  
  public final void cVi()
  {
    cVj();
    this.xvf = null;
  }
  
  public final void cVj()
  {
    int i = this.xqf - this.xve;
    if (i == 0) {
      return;
    }
    this.xvf.write(this.xvc, this.xve, i);
    if (this.xqf >= this.xvd) {
      this.xqf = 0;
    }
    this.xve = this.xqf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     f.a.a.a
 * JD-Core Version:    0.7.0.1
 */