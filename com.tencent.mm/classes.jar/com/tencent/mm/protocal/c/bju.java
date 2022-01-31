package com.tencent.mm.protocal.c;

public final class bju
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public int number;
  public String type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.type != null) {
        paramVarArgs.d(1, this.type);
      }
      if (this.bQZ != null) {
        paramVarArgs.d(2, this.bQZ);
      }
      paramVarArgs.gB(3, this.number);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bQZ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bQZ);
      }
      return i + d.a.a.a.gy(3, this.number);
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
        bju localbju = (bju)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbju.type = locala.xpH.readString();
          return 0;
        case 2: 
          localbju.bQZ = locala.xpH.readString();
          return 0;
        }
        localbju.number = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bju
 * JD-Core Version:    0.7.0.1
 */