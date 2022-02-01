package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ha
  extends com.tencent.mm.bw.a
{
  public int DAn;
  public boolean FRP;
  public String FRQ;
  public String dwk;
  public String dwl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.FRP);
      paramVarArgs.aS(2, this.DAn);
      if (this.dwk != null) {
        paramVarArgs.d(3, this.dwk);
      }
      if (this.dwl != null) {
        paramVarArgs.d(4, this.dwl);
      }
      if (this.FRQ != null) {
        paramVarArgs.d(5, this.FRQ);
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.bz(2, this.DAn);
      paramInt = i;
      if (this.dwk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dwk);
      }
      i = paramInt;
      if (this.dwl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dwl);
      }
      paramInt = i;
      if (this.FRQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FRQ);
      }
      AppMethodBeat.o(19404);
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
        localha.FRP = locala.OmT.gvY();
        AppMethodBeat.o(19404);
        return 0;
      case 2: 
        localha.DAn = locala.OmT.zc();
        AppMethodBeat.o(19404);
        return 0;
      case 3: 
        localha.dwk = locala.OmT.readString();
        AppMethodBeat.o(19404);
        return 0;
      case 4: 
        localha.dwl = locala.OmT.readString();
        AppMethodBeat.o(19404);
        return 0;
      }
      localha.FRQ = locala.OmT.readString();
      AppMethodBeat.o(19404);
      return 0;
    }
    AppMethodBeat.o(19404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ha
 * JD-Core Version:    0.7.0.1
 */