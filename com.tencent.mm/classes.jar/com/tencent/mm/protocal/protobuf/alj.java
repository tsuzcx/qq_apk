package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alj
  extends com.tencent.mm.bw.a
{
  public boolean GDB;
  public String dyI;
  public String id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152991);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      paramVarArgs.bC(3, this.GDB);
      AppMethodBeat.o(152991);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dyI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dyI);
      }
      paramInt = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(152991);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152991);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alj localalj = (alj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152991);
          return -1;
        case 1: 
          localalj.id = locala.OmT.readString();
          AppMethodBeat.o(152991);
          return 0;
        case 2: 
          localalj.dyI = locala.OmT.readString();
          AppMethodBeat.o(152991);
          return 0;
        }
        localalj.GDB = locala.OmT.gvY();
        AppMethodBeat.o(152991);
        return 0;
      }
      AppMethodBeat.o(152991);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alj
 * JD-Core Version:    0.7.0.1
 */