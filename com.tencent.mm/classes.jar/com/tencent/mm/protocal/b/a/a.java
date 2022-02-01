package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class a
  extends com.tencent.mm.bx.a
{
  public String YzG;
  public String YzH;
  public int actionType;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123716);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YzG == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.id);
      paramVarArgs.bS(2, this.actionType);
      if (this.YzG != null) {
        paramVarArgs.g(3, this.YzG);
      }
      if (this.YzH != null) {
        paramVarArgs.g(4, this.YzH);
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.id) + 0 + i.a.a.b.b.a.cJ(2, this.actionType);
      paramInt = i;
      if (this.YzG != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YzG);
      }
      i = paramInt;
      if (this.YzH != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YzH);
      }
      AppMethodBeat.o(123716);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YzG == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(123716);
        throw paramVarArgs;
      }
      AppMethodBeat.o(123716);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123716);
        return -1;
      case 1: 
        locala1.id = locala.ajGk.aar();
        AppMethodBeat.o(123716);
        return 0;
      case 2: 
        locala1.actionType = locala.ajGk.aar();
        AppMethodBeat.o(123716);
        return 0;
      case 3: 
        locala1.YzG = locala.ajGk.readString();
        AppMethodBeat.o(123716);
        return 0;
      }
      locala1.YzH = locala.ajGk.readString();
      AppMethodBeat.o(123716);
      return 0;
    }
    AppMethodBeat.o(123716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.a
 * JD-Core Version:    0.7.0.1
 */