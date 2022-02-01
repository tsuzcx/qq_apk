package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ccx
  extends com.tencent.mm.bx.a
{
  public String aamn;
  public int aamo;
  public int aamp;
  public long aamq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152542);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aamn != null) {
        paramVarArgs.g(1, this.aamn);
      }
      paramVarArgs.bS(2, this.aamo);
      paramVarArgs.bS(3, this.aamp);
      paramVarArgs.bv(99, this.aamq);
      AppMethodBeat.o(152542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aamn == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.aamn) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aamo);
      int j = i.a.a.b.b.a.cJ(3, this.aamp);
      int k = i.a.a.b.b.a.q(99, this.aamq);
      AppMethodBeat.o(152542);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152542);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ccx localccx = (ccx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152542);
          return -1;
        case 1: 
          localccx.aamn = locala.ajGk.readString();
          AppMethodBeat.o(152542);
          return 0;
        case 2: 
          localccx.aamo = locala.ajGk.aar();
          AppMethodBeat.o(152542);
          return 0;
        case 3: 
          localccx.aamp = locala.ajGk.aar();
          AppMethodBeat.o(152542);
          return 0;
        }
        localccx.aamq = locala.ajGk.aaw();
        AppMethodBeat.o(152542);
        return 0;
      }
      AppMethodBeat.o(152542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccx
 * JD-Core Version:    0.7.0.1
 */