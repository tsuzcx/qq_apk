package com.tencent.mm.storage;

public final class bl
  extends com.tencent.mm.bv.a
{
  public long bIt;
  public long gih;
  public long ugr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.bIt);
      paramVarArgs.Y(2, this.gih);
      paramVarArgs.Y(3, this.ugr);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.bIt) + 0 + d.a.a.a.X(2, this.gih) + d.a.a.a.X(3, this.ugr);
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
      bl localbl = (bl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbl.bIt = locala.xpH.oE();
        return 0;
      case 2: 
        localbl.gih = locala.xpH.oE();
        return 0;
      }
      localbl.ugr = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bl
 * JD-Core Version:    0.7.0.1
 */