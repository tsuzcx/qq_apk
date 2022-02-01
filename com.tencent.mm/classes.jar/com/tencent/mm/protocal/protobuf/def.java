package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class def
  extends com.tencent.mm.bx.a
{
  public String kzK;
  public String kzL;
  public String paG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91691);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.kzK != null) {
        paramVarArgs.d(1, this.kzK);
      }
      if (this.kzL != null) {
        paramVarArgs.d(2, this.kzL);
      }
      if (this.paG != null) {
        paramVarArgs.d(3, this.paG);
      }
      AppMethodBeat.o(91691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kzK == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.kzK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kzL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.kzL);
      }
      i = paramInt;
      if (this.paG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.paG);
      }
      AppMethodBeat.o(91691);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91691);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        def localdef = (def)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91691);
          return -1;
        case 1: 
          localdef.kzK = locala.NPN.readString();
          AppMethodBeat.o(91691);
          return 0;
        case 2: 
          localdef.kzL = locala.NPN.readString();
          AppMethodBeat.o(91691);
          return 0;
        }
        localdef.paG = locala.NPN.readString();
        AppMethodBeat.o(91691);
        return 0;
      }
      AppMethodBeat.o(91691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.def
 * JD-Core Version:    0.7.0.1
 */