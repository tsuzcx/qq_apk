package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abt
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> Zkn;
  public String Zko;
  
  public abt()
  {
    AppMethodBeat.i(152518);
    this.Zkn = new LinkedList();
    AppMethodBeat.o(152518);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152519);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Zkn);
      if (this.Zko != null) {
        paramVarArgs.g(2, this.Zko);
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.a.c(1, 1, this.Zkn) + 0;
      paramInt = i;
      if (this.Zko != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zko);
      }
      AppMethodBeat.o(152519);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zkn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      abt localabt = (abt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152519);
        return -1;
      case 1: 
        localabt.Zkn.add(locala.ajGk.readString());
        AppMethodBeat.o(152519);
        return 0;
      }
      localabt.Zko = locala.ajGk.readString();
      AppMethodBeat.o(152519);
      return 0;
    }
    AppMethodBeat.o(152519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abt
 * JD-Core Version:    0.7.0.1
 */