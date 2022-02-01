package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eir
  extends com.tencent.mm.bw.a
{
  public boolean IlR;
  public boolean IlS;
  public int IlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.IlR);
      paramVarArgs.bC(2, this.IlS);
      paramVarArgs.aS(3, this.IlT);
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.bz(3, this.IlT);
      AppMethodBeat.o(50120);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50120);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eir localeir = (eir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50120);
        return -1;
      case 1: 
        localeir.IlR = locala.OmT.gvY();
        AppMethodBeat.o(50120);
        return 0;
      case 2: 
        localeir.IlS = locala.OmT.gvY();
        AppMethodBeat.o(50120);
        return 0;
      }
      localeir.IlT = locala.OmT.zc();
      AppMethodBeat.o(50120);
      return 0;
    }
    AppMethodBeat.o(50120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eir
 * JD-Core Version:    0.7.0.1
 */