package com.tencent.mm.protocal.c;

public final class awf
  extends com.tencent.mm.bv.a
{
  public float tsF;
  public float tsG;
  public float tsH;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.m(1, this.tsF);
      paramVarArgs.m(2, this.tsG);
      paramVarArgs.m(3, this.tsH);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.b.b.a.dQ(1) + 4 + 0 + (d.a.a.b.b.a.dQ(2) + 4) + (d.a.a.b.b.a.dQ(3) + 4);
    }
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
      awf localawf = (awf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localawf.tsF = locala.xpH.readFloat();
        return 0;
      case 2: 
        localawf.tsG = locala.xpH.readFloat();
        return 0;
      }
      localawf.tsH = locala.xpH.readFloat();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awf
 * JD-Core Version:    0.7.0.1
 */