package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bry
  extends com.tencent.mm.bv.a
{
  public LinkedList<Integer> tIA = new LinkedList();
  public LinkedList<String> tIx = new LinkedList();
  public LinkedList<String> tIy = new LinkedList();
  public LinkedList<Integer> tIz = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 1, this.tIx);
      paramVarArgs.d(2, 1, this.tIy);
      paramVarArgs.d(3, 2, this.tIz);
      paramVarArgs.d(4, 2, this.tIA);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.c(1, 1, this.tIx) + 0 + d.a.a.a.c(2, 1, this.tIy) + d.a.a.a.c(3, 2, this.tIz) + d.a.a.a.c(4, 2, this.tIA);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tIx.clear();
      this.tIy.clear();
      this.tIz.clear();
      this.tIA.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      bry localbry = (bry)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbry.tIx.add(locala.xpH.readString());
        return 0;
      case 2: 
        localbry.tIy.add(locala.xpH.readString());
        return 0;
      case 3: 
        localbry.tIz.add(Integer.valueOf(locala.xpH.oD()));
        return 0;
      }
      localbry.tIA.add(Integer.valueOf(locala.xpH.oD()));
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bry
 * JD-Core Version:    0.7.0.1
 */