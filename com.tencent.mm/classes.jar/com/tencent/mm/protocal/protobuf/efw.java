package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efw
  extends com.tencent.mm.bw.a
{
  public String Mmv;
  public int NfQ;
  public int NfR;
  public String jfi;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153306);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mmv != null) {
        paramVarArgs.e(1, this.Mmv);
      }
      paramVarArgs.aM(2, this.NfQ);
      paramVarArgs.aM(3, this.NfR);
      if (this.xut != null) {
        paramVarArgs.e(4, this.xut);
      }
      if (this.jfi != null) {
        paramVarArgs.e(5, this.jfi);
      }
      AppMethodBeat.o(153306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mmv == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mmv) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.NfQ) + g.a.a.b.b.a.bu(3, this.NfR);
      paramInt = i;
      if (this.xut != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xut);
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.jfi);
      }
      AppMethodBeat.o(153306);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153306);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        efw localefw = (efw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153306);
          return -1;
        case 1: 
          localefw.Mmv = locala.UbS.readString();
          AppMethodBeat.o(153306);
          return 0;
        case 2: 
          localefw.NfQ = locala.UbS.zi();
          AppMethodBeat.o(153306);
          return 0;
        case 3: 
          localefw.NfR = locala.UbS.zi();
          AppMethodBeat.o(153306);
          return 0;
        case 4: 
          localefw.xut = locala.UbS.readString();
          AppMethodBeat.o(153306);
          return 0;
        }
        localefw.jfi = locala.UbS.readString();
        AppMethodBeat.o(153306);
        return 0;
      }
      AppMethodBeat.o(153306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efw
 * JD-Core Version:    0.7.0.1
 */