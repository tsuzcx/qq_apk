package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bst
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public int number;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48952);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.type != null) {
        paramVarArgs.e(1, this.type);
      }
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      paramVarArgs.aO(3, this.number);
      AppMethodBeat.o(48952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cyA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cyA);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.number);
      AppMethodBeat.o(48952);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48952);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bst localbst = (bst)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48952);
          return -1;
        case 1: 
          localbst.type = locala.CLY.readString();
          AppMethodBeat.o(48952);
          return 0;
        case 2: 
          localbst.cyA = locala.CLY.readString();
          AppMethodBeat.o(48952);
          return 0;
        }
        localbst.number = locala.CLY.sl();
        AppMethodBeat.o(48952);
        return 0;
      }
      AppMethodBeat.o(48952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bst
 * JD-Core Version:    0.7.0.1
 */