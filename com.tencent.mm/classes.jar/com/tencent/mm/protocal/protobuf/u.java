package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bx.a
{
  public String CsC;
  public long CsD;
  public int CsE;
  public long Csv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CsC != null) {
        paramVarArgs.d(1, this.CsC);
      }
      paramVarArgs.aG(2, this.Csv);
      paramVarArgs.aG(3, this.CsD);
      paramVarArgs.aR(4, this.CsE);
      AppMethodBeat.o(91332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CsC == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.CsC) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.Csv);
      int j = f.a.a.b.b.a.q(3, this.CsD);
      int k = f.a.a.b.b.a.bA(4, this.CsE);
      AppMethodBeat.o(91332);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91332);
          return -1;
        case 1: 
          localu.CsC = locala.KhF.readString();
          AppMethodBeat.o(91332);
          return 0;
        case 2: 
          localu.Csv = locala.KhF.xT();
          AppMethodBeat.o(91332);
          return 0;
        case 3: 
          localu.CsD = locala.KhF.xT();
          AppMethodBeat.o(91332);
          return 0;
        }
        localu.CsE = locala.KhF.xS();
        AppMethodBeat.o(91332);
        return 0;
      }
      AppMethodBeat.o(91332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.u
 * JD-Core Version:    0.7.0.1
 */