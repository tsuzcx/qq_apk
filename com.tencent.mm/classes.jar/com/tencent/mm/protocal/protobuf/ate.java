package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ate
  extends com.tencent.mm.bv.a
{
  public String CellTitle;
  public String xiv;
  public String xiw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80104);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.e(1, this.CellTitle);
      }
      if (this.xiv != null) {
        paramVarArgs.e(2, this.xiv);
      }
      if (this.xiw != null) {
        paramVarArgs.e(3, this.xiw);
      }
      AppMethodBeat.o(80104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CellTitle == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.CellTitle) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xiv != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xiv);
      }
      i = paramInt;
      if (this.xiw != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xiw);
      }
      AppMethodBeat.o(80104);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80104);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ate localate = (ate)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80104);
          return -1;
        case 1: 
          localate.CellTitle = locala.CLY.readString();
          AppMethodBeat.o(80104);
          return 0;
        case 2: 
          localate.xiv = locala.CLY.readString();
          AppMethodBeat.o(80104);
          return 0;
        }
        localate.xiw = locala.CLY.readString();
        AppMethodBeat.o(80104);
        return 0;
      }
      AppMethodBeat.o(80104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ate
 * JD-Core Version:    0.7.0.1
 */