package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awm
  extends com.tencent.mm.cd.a
{
  public String RFn;
  public String RFo;
  public int RFq;
  public String ugh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208163);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RFn != null) {
        paramVarArgs.f(1, this.RFn);
      }
      if (this.RFo != null) {
        paramVarArgs.f(2, this.RFo);
      }
      if (this.ugh != null) {
        paramVarArgs.f(3, this.ugh);
      }
      paramVarArgs.aY(4, this.RFq);
      AppMethodBeat.o(208163);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RFn == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.RFn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RFo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RFo);
      }
      i = paramInt;
      if (this.ugh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ugh);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.RFq);
      AppMethodBeat.o(208163);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208163);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        awm localawm = (awm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208163);
          return -1;
        case 1: 
          localawm.RFn = locala.abFh.readString();
          AppMethodBeat.o(208163);
          return 0;
        case 2: 
          localawm.RFo = locala.abFh.readString();
          AppMethodBeat.o(208163);
          return 0;
        case 3: 
          localawm.ugh = locala.abFh.readString();
          AppMethodBeat.o(208163);
          return 0;
        }
        localawm.RFq = locala.abFh.AK();
        AppMethodBeat.o(208163);
        return 0;
      }
      AppMethodBeat.o(208163);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awm
 * JD-Core Version:    0.7.0.1
 */