package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eau
  extends com.tencent.mm.bw.a
{
  public int Eae;
  public int FbR;
  public int Fhl;
  public int Fhm;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FbR);
      paramVarArgs.aR(2, this.Eae);
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.aR(5, this.Fhm);
      paramVarArgs.aR(6, this.Fhl);
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FbR);
      int i = f.a.a.b.b.a.bx(2, this.Eae);
      int j = f.a.a.b.b.a.bx(3, this.Scene);
      int k = f.a.a.b.b.a.bx(5, this.Fhm);
      int m = f.a.a.b.b.a.bx(6, this.Fhl);
      AppMethodBeat.o(50118);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eau localeau = (eau)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(50118);
        return -1;
      case 1: 
        localeau.FbR = locala.LVo.xF();
        AppMethodBeat.o(50118);
        return 0;
      case 2: 
        localeau.Eae = locala.LVo.xF();
        AppMethodBeat.o(50118);
        return 0;
      case 3: 
        localeau.Scene = locala.LVo.xF();
        AppMethodBeat.o(50118);
        return 0;
      case 5: 
        localeau.Fhm = locala.LVo.xF();
        AppMethodBeat.o(50118);
        return 0;
      }
      localeau.Fhl = locala.LVo.xF();
      AppMethodBeat.o(50118);
      return 0;
    }
    AppMethodBeat.o(50118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eau
 * JD-Core Version:    0.7.0.1
 */