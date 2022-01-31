package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class zi
  extends com.tencent.mm.bv.a
{
  public int wQm;
  public String wQn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62524);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQn == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(62524);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.wQm);
      if (this.wQn != null) {
        paramVarArgs.e(2, this.wQn);
      }
      AppMethodBeat.o(62524);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wQm) + 0;
      paramInt = i;
      if (this.wQn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wQn);
      }
      AppMethodBeat.o(62524);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wQn == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(62524);
        throw paramVarArgs;
      }
      AppMethodBeat.o(62524);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      zi localzi = (zi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(62524);
        return -1;
      case 1: 
        localzi.wQm = locala.CLY.sl();
        AppMethodBeat.o(62524);
        return 0;
      }
      localzi.wQn = locala.CLY.readString();
      AppMethodBeat.o(62524);
      return 0;
    }
    AppMethodBeat.o(62524);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zi
 * JD-Core Version:    0.7.0.1
 */