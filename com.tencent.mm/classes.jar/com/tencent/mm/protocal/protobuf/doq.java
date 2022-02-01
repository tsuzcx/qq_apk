package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doq
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> aaVD;
  public String cBw;
  
  public doq()
  {
    AppMethodBeat.i(116473);
    this.aaVD = new LinkedList();
    AppMethodBeat.o(116473);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116474);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.cBw != null) {
        paramVarArgs.g(1, this.cBw);
      }
      paramVarArgs.e(2, 1, this.aaVD);
      AppMethodBeat.o(116474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cBw == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.cBw) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aaVD);
      AppMethodBeat.o(116474);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaVD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116474);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        doq localdoq = (doq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116474);
          return -1;
        case 1: 
          localdoq.cBw = locala.ajGk.readString();
          AppMethodBeat.o(116474);
          return 0;
        }
        localdoq.aaVD.add(locala.ajGk.readString());
        AppMethodBeat.o(116474);
        return 0;
      }
      AppMethodBeat.o(116474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doq
 * JD-Core Version:    0.7.0.1
 */