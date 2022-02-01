package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbt
  extends com.tencent.mm.bx.a
{
  public long Etu;
  public long Etv;
  public int Etw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Etu);
      paramVarArgs.aG(2, this.Etv);
      paramVarArgs.aR(3, this.Etw);
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.Etu);
      int i = f.a.a.b.b.a.q(2, this.Etv);
      int j = f.a.a.b.b.a.bA(3, this.Etw);
      AppMethodBeat.o(125848);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dbt localdbt = (dbt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125848);
        return -1;
      case 1: 
        localdbt.Etu = locala.KhF.xT();
        AppMethodBeat.o(125848);
        return 0;
      case 2: 
        localdbt.Etv = locala.KhF.xT();
        AppMethodBeat.o(125848);
        return 0;
      }
      localdbt.Etw = locala.KhF.xS();
      AppMethodBeat.o(125848);
      return 0;
    }
    AppMethodBeat.o(125848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbt
 * JD-Core Version:    0.7.0.1
 */