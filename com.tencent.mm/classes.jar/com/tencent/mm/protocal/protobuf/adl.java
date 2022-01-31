package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adl
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public String id;
  public boolean wWx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55700);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      paramVarArgs.aS(3, this.wWx);
      AppMethodBeat.o(55700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cyA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cyA);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(55700);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55700);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        adl localadl = (adl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55700);
          return -1;
        case 1: 
          localadl.id = locala.CLY.readString();
          AppMethodBeat.o(55700);
          return 0;
        case 2: 
          localadl.cyA = locala.CLY.readString();
          AppMethodBeat.o(55700);
          return 0;
        }
        localadl.wWx = locala.CLY.emu();
        AppMethodBeat.o(55700);
        return 0;
      }
      AppMethodBeat.o(55700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adl
 * JD-Core Version:    0.7.0.1
 */