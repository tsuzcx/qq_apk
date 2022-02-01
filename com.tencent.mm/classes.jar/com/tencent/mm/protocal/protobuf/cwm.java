package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwm
  extends com.tencent.mm.bx.a
{
  public int DIr;
  public int DbH;
  public int Eon;
  public int Eoo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125840);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DbH);
      paramVarArgs.aR(2, this.DIr);
      paramVarArgs.aR(3, this.Eon);
      paramVarArgs.aR(4, this.Eoo);
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DbH);
      int i = f.a.a.b.b.a.bA(2, this.DIr);
      int j = f.a.a.b.b.a.bA(3, this.Eon);
      int k = f.a.a.b.b.a.bA(4, this.Eoo);
      AppMethodBeat.o(125840);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cwm localcwm = (cwm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125840);
        return -1;
      case 1: 
        localcwm.DbH = locala.KhF.xS();
        AppMethodBeat.o(125840);
        return 0;
      case 2: 
        localcwm.DIr = locala.KhF.xS();
        AppMethodBeat.o(125840);
        return 0;
      case 3: 
        localcwm.Eon = locala.KhF.xS();
        AppMethodBeat.o(125840);
        return 0;
      }
      localcwm.Eoo = locala.KhF.xS();
      AppMethodBeat.o(125840);
      return 0;
    }
    AppMethodBeat.o(125840);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwm
 * JD-Core Version:    0.7.0.1
 */