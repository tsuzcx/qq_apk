package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dby
  extends com.tencent.mm.bw.a
{
  public String HKt;
  public String className;
  public String dGe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.d(1, this.className);
      }
      if (this.dGe != null) {
        paramVarArgs.d(2, this.dGe);
      }
      if (this.HKt != null) {
        paramVarArgs.d(3, this.HKt);
      }
      AppMethodBeat.o(122531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dGe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dGe);
      }
      i = paramInt;
      if (this.HKt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HKt);
      }
      AppMethodBeat.o(122531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122531);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dby localdby = (dby)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122531);
          return -1;
        case 1: 
          localdby.className = locala.OmT.readString();
          AppMethodBeat.o(122531);
          return 0;
        case 2: 
          localdby.dGe = locala.OmT.readString();
          AppMethodBeat.o(122531);
          return 0;
        }
        localdby.HKt = locala.OmT.readString();
        AppMethodBeat.o(122531);
        return 0;
      }
      AppMethodBeat.o(122531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dby
 * JD-Core Version:    0.7.0.1
 */