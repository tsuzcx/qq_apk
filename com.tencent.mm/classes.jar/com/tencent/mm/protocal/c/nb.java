package com.tencent.mm.protocal.c;

public final class nb
  extends com.tencent.mm.bv.a
{
  public String bZc;
  public int end_time;
  public String ioW;
  public int sKM;
  public String sKN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bZc != null) {
        paramVarArgs.d(1, this.bZc);
      }
      if (this.ioW != null) {
        paramVarArgs.d(2, this.ioW);
      }
      paramVarArgs.gB(3, this.end_time);
      paramVarArgs.gB(4, this.sKM);
      if (this.sKN != null) {
        paramVarArgs.d(5, this.sKN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bZc == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = d.a.a.b.b.a.e(1, this.bZc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ioW != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ioW);
      }
      i = i + d.a.a.a.gy(3, this.end_time) + d.a.a.a.gy(4, this.sKM);
      paramInt = i;
      if (this.sKN != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sKN);
      }
      return paramInt;
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
        nb localnb = (nb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localnb.bZc = locala.xpH.readString();
          return 0;
        case 2: 
          localnb.ioW = locala.xpH.readString();
          return 0;
        case 3: 
          localnb.end_time = locala.xpH.oD();
          return 0;
        case 4: 
          localnb.sKM = locala.xpH.oD();
          return 0;
        }
        localnb.sKN = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nb
 * JD-Core Version:    0.7.0.1
 */