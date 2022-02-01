package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckt
  extends com.tencent.mm.cd.a
{
  public String CNG;
  public String GTG;
  public int Tsk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Tsk);
      if (this.GTG != null) {
        paramVarArgs.f(2, this.GTG);
      }
      if (this.CNG != null) {
        paramVarArgs.f(3, this.CNG);
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Tsk) + 0;
      paramInt = i;
      if (this.GTG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.GTG);
      }
      i = paramInt;
      if (this.CNG != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNG);
      }
      AppMethodBeat.o(32332);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ckt localckt = (ckt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32332);
        return -1;
      case 1: 
        localckt.Tsk = locala.abFh.AK();
        AppMethodBeat.o(32332);
        return 0;
      case 2: 
        localckt.GTG = locala.abFh.readString();
        AppMethodBeat.o(32332);
        return 0;
      }
      localckt.CNG = locala.abFh.readString();
      AppMethodBeat.o(32332);
      return 0;
    }
    AppMethodBeat.o(32332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckt
 * JD-Core Version:    0.7.0.1
 */