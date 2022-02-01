package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctt
  extends com.tencent.mm.cd.a
{
  public int RIs;
  public String TBB;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TBB != null) {
        paramVarArgs.f(1, this.TBB);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      paramVarArgs.aY(3, this.RIs);
      AppMethodBeat.o(124528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TBB == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.TBB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fwr);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.RIs);
      AppMethodBeat.o(124528);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124528);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ctt localctt = (ctt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124528);
          return -1;
        case 1: 
          localctt.TBB = locala.abFh.readString();
          AppMethodBeat.o(124528);
          return 0;
        case 2: 
          localctt.fwr = locala.abFh.readString();
          AppMethodBeat.o(124528);
          return 0;
        }
        localctt.RIs = locala.abFh.AK();
        AppMethodBeat.o(124528);
        return 0;
      }
      AppMethodBeat.o(124528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctt
 * JD-Core Version:    0.7.0.1
 */