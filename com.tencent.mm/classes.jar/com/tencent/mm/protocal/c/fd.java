package com.tencent.mm.protocal.c;

public final class fd
  extends com.tencent.mm.bv.a
{
  public String ffk;
  public String hPY;
  public String hRf;
  public int ksV;
  public String svu;
  public int syP;
  public String syQ;
  public String syR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svu != null) {
        paramVarArgs.d(1, this.svu);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      paramVarArgs.gB(4, this.syP);
      if (this.syQ != null) {
        paramVarArgs.d(5, this.syQ);
      }
      if (this.ffk != null) {
        paramVarArgs.d(6, this.ffk);
      }
      if (this.syR != null) {
        paramVarArgs.d(7, this.syR);
      }
      paramVarArgs.gB(8, this.ksV);
      return 0;
    }
    if (paramInt == 1) {
      if (this.svu == null) {
        break label536;
      }
    }
    label536:
    for (int i = d.a.a.b.b.a.e(1, this.svu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hPY);
      }
      i += d.a.a.a.gy(4, this.syP);
      paramInt = i;
      if (this.syQ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.syQ);
      }
      i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.ffk);
      }
      paramInt = i;
      if (this.syR != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.syR);
      }
      return paramInt + d.a.a.a.gy(8, this.ksV);
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
        fd localfd = (fd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localfd.svu = locala.xpH.readString();
          return 0;
        case 2: 
          localfd.hRf = locala.xpH.readString();
          return 0;
        case 3: 
          localfd.hPY = locala.xpH.readString();
          return 0;
        case 4: 
          localfd.syP = locala.xpH.oD();
          return 0;
        case 5: 
          localfd.syQ = locala.xpH.readString();
          return 0;
        case 6: 
          localfd.ffk = locala.xpH.readString();
          return 0;
        case 7: 
          localfd.syR = locala.xpH.readString();
          return 0;
        }
        localfd.ksV = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fd
 * JD-Core Version:    0.7.0.1
 */