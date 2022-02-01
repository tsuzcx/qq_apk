package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eoa
  extends com.tencent.mm.bx.a
{
  public String DVu;
  public long YUq;
  public String YUu;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259656);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.DVu != null) {
        paramVarArgs.g(1, this.DVu);
      }
      paramVarArgs.bv(2, this.YUq);
      paramVarArgs.bS(3, this.status);
      if (this.YUu != null) {
        paramVarArgs.g(4, this.YUu);
      }
      AppMethodBeat.o(259656);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DVu == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.DVu) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YUq) + i.a.a.b.b.a.cJ(3, this.status);
      paramInt = i;
      if (this.YUu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YUu);
      }
      AppMethodBeat.o(259656);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259656);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eoa localeoa = (eoa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259656);
          return -1;
        case 1: 
          localeoa.DVu = locala.ajGk.readString();
          AppMethodBeat.o(259656);
          return 0;
        case 2: 
          localeoa.YUq = locala.ajGk.aaw();
          AppMethodBeat.o(259656);
          return 0;
        case 3: 
          localeoa.status = locala.ajGk.aar();
          AppMethodBeat.o(259656);
          return 0;
        }
        localeoa.YUu = locala.ajGk.readString();
        AppMethodBeat.o(259656);
        return 0;
      }
      AppMethodBeat.o(259656);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoa
 * JD-Core Version:    0.7.0.1
 */