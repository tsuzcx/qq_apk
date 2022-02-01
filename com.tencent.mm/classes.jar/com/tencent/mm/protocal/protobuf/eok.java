package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eok
  extends com.tencent.mm.bw.a
{
  public String KZR;
  public int Myg;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200232);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      paramVarArgs.aM(2, this.Myg);
      if (this.KZR != null) {
        paramVarArgs.e(3, this.KZR);
      }
      AppMethodBeat.o(200232);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Myg);
      paramInt = i;
      if (this.KZR != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KZR);
      }
      AppMethodBeat.o(200232);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200232);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eok localeok = (eok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200232);
          return -1;
        case 1: 
          localeok.url = locala.UbS.readString();
          AppMethodBeat.o(200232);
          return 0;
        case 2: 
          localeok.Myg = locala.UbS.zi();
          AppMethodBeat.o(200232);
          return 0;
        }
        localeok.KZR = locala.UbS.readString();
        AppMethodBeat.o(200232);
        return 0;
      }
      AppMethodBeat.o(200232);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eok
 * JD-Core Version:    0.7.0.1
 */