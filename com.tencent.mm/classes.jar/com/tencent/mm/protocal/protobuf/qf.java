package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qf
  extends com.tencent.mm.bw.a
{
  public int EgT;
  public int EgU;
  public int EgV;
  public int EgW;
  public int EgX;
  public int EgY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EgT);
      paramVarArgs.aR(2, this.EgU);
      paramVarArgs.aR(3, this.EgV);
      paramVarArgs.aR(4, this.EgW);
      paramVarArgs.aR(5, this.EgX);
      paramVarArgs.aR(6, this.EgY);
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EgT);
      int i = f.a.a.b.b.a.bx(2, this.EgU);
      int j = f.a.a.b.b.a.bx(3, this.EgV);
      int k = f.a.a.b.b.a.bx(4, this.EgW);
      int m = f.a.a.b.b.a.bx(5, this.EgX);
      int n = f.a.a.b.b.a.bx(6, this.EgY);
      AppMethodBeat.o(133161);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      qf localqf = (qf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133161);
        return -1;
      case 1: 
        localqf.EgT = locala.LVo.xF();
        AppMethodBeat.o(133161);
        return 0;
      case 2: 
        localqf.EgU = locala.LVo.xF();
        AppMethodBeat.o(133161);
        return 0;
      case 3: 
        localqf.EgV = locala.LVo.xF();
        AppMethodBeat.o(133161);
        return 0;
      case 4: 
        localqf.EgW = locala.LVo.xF();
        AppMethodBeat.o(133161);
        return 0;
      case 5: 
        localqf.EgX = locala.LVo.xF();
        AppMethodBeat.o(133161);
        return 0;
      }
      localqf.EgY = locala.LVo.xF();
      AppMethodBeat.o(133161);
      return 0;
    }
    AppMethodBeat.o(133161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qf
 * JD-Core Version:    0.7.0.1
 */