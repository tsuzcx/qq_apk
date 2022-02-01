package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class evc
  extends com.tencent.mm.cd.a
{
  public b UwQ;
  public String UwR;
  public b UwS;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82480);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UwQ != null) {
        paramVarArgs.c(1, this.UwQ);
      }
      if (this.UwR != null) {
        paramVarArgs.f(2, this.UwR);
      }
      if (this.UwS != null) {
        paramVarArgs.c(3, this.UwS);
      }
      paramVarArgs.aY(4, this.uin);
      AppMethodBeat.o(82480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UwQ == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.b(1, this.UwQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UwR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UwR);
      }
      i = paramInt;
      if (this.UwS != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UwS);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.uin);
      AppMethodBeat.o(82480);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82480);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        evc localevc = (evc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82480);
          return -1;
        case 1: 
          localevc.UwQ = locala.abFh.iUw();
          AppMethodBeat.o(82480);
          return 0;
        case 2: 
          localevc.UwR = locala.abFh.readString();
          AppMethodBeat.o(82480);
          return 0;
        case 3: 
          localevc.UwS = locala.abFh.iUw();
          AppMethodBeat.o(82480);
          return 0;
        }
        localevc.uin = locala.abFh.AK();
        AppMethodBeat.o(82480);
        return 0;
      }
      AppMethodBeat.o(82480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evc
 * JD-Core Version:    0.7.0.1
 */