package com.tencent.mm.protocal.c;

public final class bfr
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String tAy;
  public int tAz;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bQZ != null) {
        paramVarArgs.d(1, this.bQZ);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.tAy != null) {
        paramVarArgs.d(3, this.tAy);
      }
      paramVarArgs.gB(4, this.tAz);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bQZ == null) {
        break label324;
      }
    }
    label324:
    for (int i = d.a.a.b.b.a.e(1, this.bQZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.tAy != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tAy);
      }
      return i + d.a.a.a.gy(4, this.tAz);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bfr localbfr = (bfr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbfr.bQZ = locala.xpH.readString();
          return 0;
        case 2: 
          localbfr.url = locala.xpH.readString();
          return 0;
        case 3: 
          localbfr.tAy = locala.xpH.readString();
          return 0;
        }
        localbfr.tAz = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfr
 * JD-Core Version:    0.7.0.1
 */