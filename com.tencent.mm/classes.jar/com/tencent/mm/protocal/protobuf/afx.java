package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afx
  extends com.tencent.mm.bw.a
{
  public boolean Gwf;
  public boolean Gwg;
  public String Gwh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113998);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.Gwf);
      paramVarArgs.bC(2, this.Gwg);
      if (this.Gwh != null) {
        paramVarArgs.d(3, this.Gwh);
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.Gwh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gwh);
      }
      AppMethodBeat.o(113998);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afx localafx = (afx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113998);
        return -1;
      case 1: 
        localafx.Gwf = locala.OmT.gvY();
        AppMethodBeat.o(113998);
        return 0;
      case 2: 
        localafx.Gwg = locala.OmT.gvY();
        AppMethodBeat.o(113998);
        return 0;
      }
      localafx.Gwh = locala.OmT.readString();
      AppMethodBeat.o(113998);
      return 0;
    }
    AppMethodBeat.o(113998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afx
 * JD-Core Version:    0.7.0.1
 */