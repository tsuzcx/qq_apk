package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwl
  extends com.tencent.mm.bx.a
{
  public int Eok;
  public int Eol;
  public long Eom;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Eok);
      paramVarArgs.aR(2, this.Eol);
      paramVarArgs.aG(3, this.Eom);
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Eok);
      int i = f.a.a.b.b.a.bA(2, this.Eol);
      int j = f.a.a.b.b.a.q(3, this.Eom);
      AppMethodBeat.o(125839);
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
      AppMethodBeat.o(125839);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cwl localcwl = (cwl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125839);
        return -1;
      case 1: 
        localcwl.Eok = locala.KhF.xS();
        AppMethodBeat.o(125839);
        return 0;
      case 2: 
        localcwl.Eol = locala.KhF.xS();
        AppMethodBeat.o(125839);
        return 0;
      }
      localcwl.Eom = locala.KhF.xT();
      AppMethodBeat.o(125839);
      return 0;
    }
    AppMethodBeat.o(125839);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwl
 * JD-Core Version:    0.7.0.1
 */