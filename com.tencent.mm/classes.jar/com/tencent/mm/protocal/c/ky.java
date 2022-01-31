package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ky
  extends com.tencent.mm.bv.a
{
  public long sGd;
  public String sGe;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sGe == null) {
        throw new b("Not all required fields were included: ObjectDesc");
      }
      paramVarArgs.Y(1, this.sGd);
      if (this.sGe != null) {
        paramVarArgs.d(2, this.sGe);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.X(1, this.sGd) + 0;
      paramInt = i;
    } while (this.sGe == null);
    return i + d.a.a.b.b.a.e(2, this.sGe);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sGe == null) {
        throw new b("Not all required fields were included: ObjectDesc");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ky localky = (ky)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localky.sGd = locala.xpH.oE();
        return 0;
      }
      localky.sGe = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ky
 * JD-Core Version:    0.7.0.1
 */