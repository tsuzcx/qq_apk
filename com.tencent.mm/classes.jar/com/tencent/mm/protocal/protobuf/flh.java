package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class flh
  extends com.tencent.mm.bx.a
{
  public String YRs;
  public LinkedList<String> YTk;
  public long YVJ;
  public String Zxo;
  public String abLI;
  public int bcb;
  
  public flh()
  {
    AppMethodBeat.i(124560);
    this.YTk = new LinkedList();
    AppMethodBeat.o(124560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124561);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YVJ);
      if (this.YRs != null) {
        paramVarArgs.g(2, this.YRs);
      }
      paramVarArgs.e(3, 1, this.YTk);
      if (this.Zxo != null) {
        paramVarArgs.g(4, this.Zxo);
      }
      if (this.abLI != null) {
        paramVarArgs.g(5, this.abLI);
      }
      paramVarArgs.bS(6, this.bcb);
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.YVJ) + 0;
      paramInt = i;
      if (this.YRs != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YRs);
      }
      i = paramInt + i.a.a.a.c(3, 1, this.YTk);
      paramInt = i;
      if (this.Zxo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zxo);
      }
      i = paramInt;
      if (this.abLI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abLI);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.bcb);
      AppMethodBeat.o(124561);
      return i + paramInt;
    }
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
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      flh localflh = (flh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124561);
        return -1;
      case 1: 
        localflh.YVJ = locala.ajGk.aaw();
        AppMethodBeat.o(124561);
        return 0;
      case 2: 
        localflh.YRs = locala.ajGk.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 3: 
        localflh.YTk.add(locala.ajGk.readString());
        AppMethodBeat.o(124561);
        return 0;
      case 4: 
        localflh.Zxo = locala.ajGk.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 5: 
        localflh.abLI = locala.ajGk.readString();
        AppMethodBeat.o(124561);
        return 0;
      }
      localflh.bcb = locala.ajGk.aar();
      AppMethodBeat.o(124561);
      return 0;
    }
    AppMethodBeat.o(124561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flh
 * JD-Core Version:    0.7.0.1
 */