package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxl
  extends com.tencent.mm.bx.a
{
  public String aagj;
  public long aagk;
  public int aagl;
  public int aagm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258293);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aagj != null) {
        paramVarArgs.g(1, this.aagj);
      }
      paramVarArgs.bv(2, this.aagk);
      paramVarArgs.bS(3, this.aagl);
      paramVarArgs.bS(4, this.aagm);
      AppMethodBeat.o(258293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aagj == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.aagj) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.aagk);
      int j = i.a.a.b.b.a.cJ(3, this.aagl);
      int k = i.a.a.b.b.a.cJ(4, this.aagm);
      AppMethodBeat.o(258293);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258293);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bxl localbxl = (bxl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258293);
          return -1;
        case 1: 
          localbxl.aagj = locala.ajGk.readString();
          AppMethodBeat.o(258293);
          return 0;
        case 2: 
          localbxl.aagk = locala.ajGk.aaw();
          AppMethodBeat.o(258293);
          return 0;
        case 3: 
          localbxl.aagl = locala.ajGk.aar();
          AppMethodBeat.o(258293);
          return 0;
        }
        localbxl.aagm = locala.ajGk.aar();
        AppMethodBeat.o(258293);
        return 0;
      }
      AppMethodBeat.o(258293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxl
 * JD-Core Version:    0.7.0.1
 */