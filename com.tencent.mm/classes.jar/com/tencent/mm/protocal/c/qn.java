package com.tencent.mm.protocal.c;

public final class qn
  extends com.tencent.mm.bv.a
{
  public double latitude;
  public double longitude;
  public String sOp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sOp != null) {
        paramVarArgs.d(1, this.sOp);
      }
      paramVarArgs.b(2, this.longitude);
      paramVarArgs.b(3, this.latitude);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sOp == null) {
        break label246;
      }
    }
    label246:
    for (paramInt = d.a.a.b.b.a.e(1, this.sOp) + 0;; paramInt = 0)
    {
      return paramInt + (d.a.a.b.b.a.dQ(2) + 8) + (d.a.a.b.b.a.dQ(3) + 8);
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
        qn localqn = (qn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localqn.sOp = locala.xpH.readString();
          return 0;
        case 2: 
          localqn.longitude = locala.xpH.readDouble();
          return 0;
        }
        localqn.latitude = locala.xpH.readDouble();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qn
 * JD-Core Version:    0.7.0.1
 */