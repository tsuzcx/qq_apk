package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhe
  extends com.tencent.mm.bx.a
{
  public int CWL;
  public String sac;
  public String uwt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CWL);
      if (this.uwt != null) {
        paramVarArgs.d(2, this.uwt);
      }
      if (this.sac != null) {
        paramVarArgs.d(3, this.sac);
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CWL) + 0;
      paramInt = i;
      if (this.uwt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uwt);
      }
      i = paramInt;
      if (this.sac != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sac);
      }
      AppMethodBeat.o(32332);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bhe localbhe = (bhe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32332);
        return -1;
      case 1: 
        localbhe.CWL = locala.KhF.xS();
        AppMethodBeat.o(32332);
        return 0;
      case 2: 
        localbhe.uwt = locala.KhF.readString();
        AppMethodBeat.o(32332);
        return 0;
      }
      localbhe.sac = locala.KhF.readString();
      AppMethodBeat.o(32332);
      return 0;
    }
    AppMethodBeat.o(32332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhe
 * JD-Core Version:    0.7.0.1
 */