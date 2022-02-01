package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dse
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b CAF;
  public int CJI;
  public boolean EGQ;
  public boolean EGR;
  public String Egc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32564);
        throw paramVarArgs;
      }
      if (this.Egc != null) {
        paramVarArgs.d(1, this.Egc);
      }
      paramVarArgs.aR(2, this.CJI);
      if (this.CAF != null) {
        paramVarArgs.c(3, this.CAF);
      }
      paramVarArgs.bg(4, this.EGQ);
      paramVarArgs.bg(5, this.EGR);
      AppMethodBeat.o(32564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Egc == null) {
        break label465;
      }
    }
    label465:
    for (paramInt = f.a.a.b.b.a.e(1, this.Egc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CJI);
      paramInt = i;
      if (this.CAF != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.CAF);
      }
      i = f.a.a.b.b.a.fY(4);
      int j = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(32564);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Egc == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dse localdse = (dse)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32564);
          return -1;
        case 1: 
          localdse.Egc = locala.KhF.readString();
          AppMethodBeat.o(32564);
          return 0;
        case 2: 
          localdse.CJI = locala.KhF.xS();
          AppMethodBeat.o(32564);
          return 0;
        case 3: 
          localdse.CAF = locala.KhF.fMu();
          AppMethodBeat.o(32564);
          return 0;
        case 4: 
          localdse.EGQ = locala.KhF.fHu();
          AppMethodBeat.o(32564);
          return 0;
        }
        localdse.EGR = locala.KhF.fHu();
        AppMethodBeat.o(32564);
        return 0;
      }
      AppMethodBeat.o(32564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dse
 * JD-Core Version:    0.7.0.1
 */