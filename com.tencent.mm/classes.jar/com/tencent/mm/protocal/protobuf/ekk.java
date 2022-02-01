package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekk
  extends com.tencent.mm.bw.a
{
  public int Hte;
  public String Inr;
  public boolean Inw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Inr != null) {
        paramVarArgs.d(1, this.Inr);
      }
      paramVarArgs.bC(2, this.Inw);
      paramVarArgs.aS(3, this.Hte);
      AppMethodBeat.o(50127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Inr == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = f.a.a.b.b.a.e(1, this.Inr) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.bz(3, this.Hte);
      AppMethodBeat.o(50127);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ekk localekk = (ekk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50127);
          return -1;
        case 1: 
          localekk.Inr = locala.OmT.readString();
          AppMethodBeat.o(50127);
          return 0;
        case 2: 
          localekk.Inw = locala.OmT.gvY();
          AppMethodBeat.o(50127);
          return 0;
        }
        localekk.Hte = locala.OmT.zc();
        AppMethodBeat.o(50127);
        return 0;
      }
      AppMethodBeat.o(50127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekk
 * JD-Core Version:    0.7.0.1
 */