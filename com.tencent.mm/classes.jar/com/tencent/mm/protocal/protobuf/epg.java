package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epg
  extends com.tencent.mm.cd.a
{
  public String Tna;
  public int TxQ;
  public String Use;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TxQ);
      if (this.Tna != null) {
        paramVarArgs.f(2, this.Tna);
      }
      if (this.Use != null) {
        paramVarArgs.f(3, this.Use);
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TxQ) + 0;
      paramInt = i;
      if (this.Tna != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tna);
      }
      i = paramInt;
      if (this.Use != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Use);
      }
      AppMethodBeat.o(152708);
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
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      epg localepg = (epg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152708);
        return -1;
      case 1: 
        localepg.TxQ = locala.abFh.AK();
        AppMethodBeat.o(152708);
        return 0;
      case 2: 
        localepg.Tna = locala.abFh.readString();
        AppMethodBeat.o(152708);
        return 0;
      }
      localepg.Use = locala.abFh.readString();
      AppMethodBeat.o(152708);
      return 0;
    }
    AppMethodBeat.o(152708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epg
 * JD-Core Version:    0.7.0.1
 */