package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ewv
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b TpC;
  public com.tencent.mm.bx.b Zsu;
  public long abyW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259604);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zsu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(259604);
        throw paramVarArgs;
      }
      if (this.Zsu != null) {
        paramVarArgs.d(1, this.Zsu);
      }
      if (this.TpC != null) {
        paramVarArgs.d(2, this.TpC);
      }
      paramVarArgs.bv(3, this.abyW);
      AppMethodBeat.o(259604);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zsu == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.c(1, this.Zsu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TpC != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.TpC);
      }
      paramInt = i.a.a.b.b.a.q(3, this.abyW);
      AppMethodBeat.o(259604);
      return i + paramInt;
      i.a.a.a.a locala;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        locala = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala)) {
          if (!super.populateBuilderWithField(locala, this, paramInt)) {
            locala.kFT();
          }
        }
        if (paramVarArgs == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: data");
          AppMethodBeat.o(259604);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259604);
        return 0;
      }
      if (paramInt == 3)
      {
        locala = (i.a.a.a.a)paramVarArgs[0];
        ewv localewv = (ewv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259604);
          return -1;
        case 1: 
          localewv.Zsu = locala.ajGk.kFX();
          AppMethodBeat.o(259604);
          return 0;
        case 2: 
          localewv.TpC = locala.ajGk.kFX();
          AppMethodBeat.o(259604);
          return 0;
        }
        localewv.abyW = locala.ajGk.aaw();
        AppMethodBeat.o(259604);
        return 0;
      }
      AppMethodBeat.o(259604);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewv
 * JD-Core Version:    0.7.0.1
 */