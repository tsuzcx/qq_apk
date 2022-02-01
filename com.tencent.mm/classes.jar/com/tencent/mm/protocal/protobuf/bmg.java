package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmg
  extends com.tencent.mm.bw.a
{
  public int EJW;
  public int FbB;
  public int FbC;
  public int FbD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EJW);
      paramVarArgs.aR(2, this.FbB);
      paramVarArgs.aR(3, this.FbC);
      paramVarArgs.aR(4, this.FbD);
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EJW);
      int i = f.a.a.b.b.a.bx(2, this.FbB);
      int j = f.a.a.b.b.a.bx(3, this.FbC);
      int k = f.a.a.b.b.a.bx(4, this.FbD);
      AppMethodBeat.o(152617);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bmg localbmg = (bmg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152617);
        return -1;
      case 1: 
        localbmg.EJW = locala.LVo.xF();
        AppMethodBeat.o(152617);
        return 0;
      case 2: 
        localbmg.FbB = locala.LVo.xF();
        AppMethodBeat.o(152617);
        return 0;
      case 3: 
        localbmg.FbC = locala.LVo.xF();
        AppMethodBeat.o(152617);
        return 0;
      }
      localbmg.FbD = locala.LVo.xF();
      AppMethodBeat.o(152617);
      return 0;
    }
    AppMethodBeat.o(152617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmg
 * JD-Core Version:    0.7.0.1
 */