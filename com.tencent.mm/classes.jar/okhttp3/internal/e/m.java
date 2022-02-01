package okhttp3.internal.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  int ajSe;
  final int[] aql;
  
  public m()
  {
    AppMethodBeat.i(186864);
    this.aql = new int[10];
    AppMethodBeat.o(186864);
  }
  
  final boolean hT(int paramInt)
  {
    return (1 << paramInt & this.ajSe) != 0;
  }
  
  final int kIg()
  {
    if ((this.ajSe & 0x2) != 0) {
      return this.aql[1];
    }
    return -1;
  }
  
  final int kIh()
  {
    if ((this.ajSe & 0x80) != 0) {
      return this.aql[7];
    }
    return 65535;
  }
  
  final m qG(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.aql.length)) {
      return this;
    }
    this.ajSe = (1 << paramInt1 | this.ajSe);
    this.aql[paramInt1] = paramInt2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.e.m
 * JD-Core Version:    0.7.0.1
 */