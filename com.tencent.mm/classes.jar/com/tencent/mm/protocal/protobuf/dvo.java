package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvo
  extends com.tencent.mm.bx.a
{
  public int DGc;
  public String DGl;
  public String EJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123706);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DGl != null) {
        paramVarArgs.d(1, this.DGl);
      }
      paramVarArgs.aR(2, this.DGc);
      if (this.EJE != null) {
        paramVarArgs.d(3, this.EJE);
      }
      AppMethodBeat.o(123706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DGl == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.DGl) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DGc);
      paramInt = i;
      if (this.EJE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EJE);
      }
      AppMethodBeat.o(123706);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123706);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvo localdvo = (dvo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123706);
          return -1;
        case 1: 
          localdvo.DGl = locala.KhF.readString();
          AppMethodBeat.o(123706);
          return 0;
        case 2: 
          localdvo.DGc = locala.KhF.xS();
          AppMethodBeat.o(123706);
          return 0;
        }
        localdvo.EJE = locala.KhF.readString();
        AppMethodBeat.o(123706);
        return 0;
      }
      AppMethodBeat.o(123706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvo
 * JD-Core Version:    0.7.0.1
 */