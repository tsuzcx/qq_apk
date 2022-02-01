package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ha
  extends com.tencent.mm.bx.a
{
  public int DiJ;
  public boolean Fzr;
  public String Fzs;
  public String dvf;
  public String dvg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.Fzr);
      paramVarArgs.aS(2, this.DiJ);
      if (this.dvf != null) {
        paramVarArgs.d(3, this.dvf);
      }
      if (this.dvg != null) {
        paramVarArgs.d(4, this.dvg);
      }
      if (this.Fzs != null) {
        paramVarArgs.d(5, this.Fzs);
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.bz(2, this.DiJ);
      paramInt = i;
      if (this.dvf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dvf);
      }
      i = paramInt;
      if (this.dvg != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dvg);
      }
      paramInt = i;
      if (this.Fzs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fzs);
      }
      AppMethodBeat.o(19404);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ha localha = (ha)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19404);
        return -1;
      case 1: 
        localha.Fzr = locala.NPN.grw();
        AppMethodBeat.o(19404);
        return 0;
      case 2: 
        localha.DiJ = locala.NPN.zc();
        AppMethodBeat.o(19404);
        return 0;
      case 3: 
        localha.dvf = locala.NPN.readString();
        AppMethodBeat.o(19404);
        return 0;
      case 4: 
        localha.dvg = locala.NPN.readString();
        AppMethodBeat.o(19404);
        return 0;
      }
      localha.Fzs = locala.NPN.readString();
      AppMethodBeat.o(19404);
      return 0;
    }
    AppMethodBeat.o(19404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ha
 * JD-Core Version:    0.7.0.1
 */