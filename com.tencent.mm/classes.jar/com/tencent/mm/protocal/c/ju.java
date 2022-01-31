package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class ju
  extends com.tencent.mm.bv.a
{
  public int port;
  public b sEA;
  public b sEB;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.type);
      paramVarArgs.gB(2, this.port);
      if (this.sEA != null) {
        paramVarArgs.b(3, this.sEA);
      }
      if (this.sEB != null) {
        paramVarArgs.b(4, this.sEB);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.type) + 0 + d.a.a.a.gy(2, this.port);
      paramInt = i;
      if (this.sEA != null) {
        paramInt = i + d.a.a.a.a(3, this.sEA);
      }
      i = paramInt;
    } while (this.sEB == null);
    return paramInt + d.a.a.a.a(4, this.sEB);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ju localju = (ju)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localju.type = locala.xpH.oD();
        return 0;
      case 2: 
        localju.port = locala.xpH.oD();
        return 0;
      case 3: 
        localju.sEA = locala.cUs();
        return 0;
      }
      localju.sEB = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ju
 * JD-Core Version:    0.7.0.1
 */