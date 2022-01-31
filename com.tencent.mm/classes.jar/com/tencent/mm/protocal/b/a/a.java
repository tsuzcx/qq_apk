package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class a
  extends com.tencent.mm.bv.a
{
  public int actionType;
  public int id;
  public String wjR;
  public String wjS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105576);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wjR == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(105576);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.id);
      paramVarArgs.aO(2, this.actionType);
      if (this.wjR != null) {
        paramVarArgs.e(3, this.wjR);
      }
      if (this.wjS != null) {
        paramVarArgs.e(4, this.wjS);
      }
      AppMethodBeat.o(105576);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.id) + 0 + e.a.a.b.b.a.bl(2, this.actionType);
      paramInt = i;
      if (this.wjR != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wjR);
      }
      i = paramInt;
      if (this.wjS != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wjS);
      }
      AppMethodBeat.o(105576);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wjR == null)
      {
        paramVarArgs = new b("Not all required fields were included: btnStr");
        AppMethodBeat.o(105576);
        throw paramVarArgs;
      }
      AppMethodBeat.o(105576);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(105576);
        return -1;
      case 1: 
        locala1.id = locala.CLY.sl();
        AppMethodBeat.o(105576);
        return 0;
      case 2: 
        locala1.actionType = locala.CLY.sl();
        AppMethodBeat.o(105576);
        return 0;
      case 3: 
        locala1.wjR = locala.CLY.readString();
        AppMethodBeat.o(105576);
        return 0;
      }
      locala1.wjS = locala.CLY.readString();
      AppMethodBeat.o(105576);
      return 0;
    }
    AppMethodBeat.o(105576);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.a
 * JD-Core Version:    0.7.0.1
 */