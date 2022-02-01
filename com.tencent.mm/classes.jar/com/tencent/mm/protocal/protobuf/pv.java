package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pv
  extends com.tencent.mm.bx.a
{
  public String YRs;
  public LinkedList<String> YTk;
  public String YTn;
  
  public pv()
  {
    AppMethodBeat.i(257813);
    this.YTk = new LinkedList();
    AppMethodBeat.o(257813);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257816);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRs != null) {
        paramVarArgs.g(1, this.YRs);
      }
      paramVarArgs.e(2, 1, this.YTk);
      if (this.YTn != null) {
        paramVarArgs.g(3, this.YTn);
      }
      AppMethodBeat.o(257816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRs == null) {
        break label330;
      }
    }
    label330:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRs) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.YTk);
      paramInt = i;
      if (this.YTn != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YTn);
      }
      AppMethodBeat.o(257816);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YTk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257816);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        pv localpv = (pv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257816);
          return -1;
        case 1: 
          localpv.YRs = locala.ajGk.readString();
          AppMethodBeat.o(257816);
          return 0;
        case 2: 
          localpv.YTk.add(locala.ajGk.readString());
          AppMethodBeat.o(257816);
          return 0;
        }
        localpv.YTn = locala.ajGk.readString();
        AppMethodBeat.o(257816);
        return 0;
      }
      AppMethodBeat.o(257816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pv
 * JD-Core Version:    0.7.0.1
 */