package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgv
  extends com.tencent.mm.cd.a
{
  public String fwr;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lpy != null) {
        paramVarArgs.f(1, this.lpy);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      AppMethodBeat.o(43117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lpy == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.lpy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fwr);
      }
      AppMethodBeat.o(43117);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43117);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dgv localdgv = (dgv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43117);
          return -1;
        case 1: 
          localdgv.lpy = locala.abFh.readString();
          AppMethodBeat.o(43117);
          return 0;
        }
        localdgv.fwr = locala.abFh.readString();
        AppMethodBeat.o(43117);
        return 0;
      }
      AppMethodBeat.o(43117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgv
 * JD-Core Version:    0.7.0.1
 */