package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gj
  extends com.tencent.mm.bw.a
{
  public int KKl;
  public String hik;
  public String hio;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hik != null) {
        paramVarArgs.e(1, this.hik);
      }
      paramVarArgs.aM(2, this.KKl);
      if (this.hio != null) {
        paramVarArgs.e(3, this.hio);
      }
      AppMethodBeat.o(152494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hik == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.hik) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KKl);
      paramInt = i;
      if (this.hio != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.hio);
      }
      AppMethodBeat.o(152494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152494);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        gj localgj = (gj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152494);
          return -1;
        case 1: 
          localgj.hik = locala.UbS.readString();
          AppMethodBeat.o(152494);
          return 0;
        case 2: 
          localgj.KKl = locala.UbS.zi();
          AppMethodBeat.o(152494);
          return 0;
        }
        localgj.hio = locala.UbS.readString();
        AppMethodBeat.o(152494);
        return 0;
      }
      AppMethodBeat.o(152494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gj
 * JD-Core Version:    0.7.0.1
 */