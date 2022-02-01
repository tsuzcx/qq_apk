package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eft
  extends com.tencent.mm.bw.a
{
  public int NfL;
  public String NfM;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153305);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.NfL);
      if (this.NfM != null) {
        paramVarArgs.e(4, this.NfM);
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(2, this.oUv) + 0 + g.a.a.b.b.a.bu(3, this.NfL);
      paramInt = i;
      if (this.NfM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NfM);
      }
      AppMethodBeat.o(153305);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eft localeft = (eft)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153305);
        return -1;
      case 2: 
        localeft.oUv = locala.UbS.zi();
        AppMethodBeat.o(153305);
        return 0;
      case 3: 
        localeft.NfL = locala.UbS.zi();
        AppMethodBeat.o(153305);
        return 0;
      }
      localeft.NfM = locala.UbS.readString();
      AppMethodBeat.o(153305);
      return 0;
    }
    AppMethodBeat.o(153305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eft
 * JD-Core Version:    0.7.0.1
 */