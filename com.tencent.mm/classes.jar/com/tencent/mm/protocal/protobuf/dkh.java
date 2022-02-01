package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkh
  extends com.tencent.mm.bw.a
{
  public String MOh;
  public String MOi;
  public int MOj;
  public int MOk = 0;
  public String MOl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117895);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MOh != null) {
        paramVarArgs.e(1, this.MOh);
      }
      if (this.MOi != null) {
        paramVarArgs.e(2, this.MOi);
      }
      paramVarArgs.aM(3, this.MOj);
      paramVarArgs.aM(4, this.MOk);
      if (this.MOl != null) {
        paramVarArgs.e(5, this.MOl);
      }
      AppMethodBeat.o(117895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MOh == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.MOh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MOi != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MOi);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MOj) + g.a.a.b.b.a.bu(4, this.MOk);
      paramInt = i;
      if (this.MOl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MOl);
      }
      AppMethodBeat.o(117895);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117895);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dkh localdkh = (dkh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117895);
          return -1;
        case 1: 
          localdkh.MOh = locala.UbS.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 2: 
          localdkh.MOi = locala.UbS.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 3: 
          localdkh.MOj = locala.UbS.zi();
          AppMethodBeat.o(117895);
          return 0;
        case 4: 
          localdkh.MOk = locala.UbS.zi();
          AppMethodBeat.o(117895);
          return 0;
        }
        localdkh.MOl = locala.UbS.readString();
        AppMethodBeat.o(117895);
        return 0;
      }
      AppMethodBeat.o(117895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkh
 * JD-Core Version:    0.7.0.1
 */