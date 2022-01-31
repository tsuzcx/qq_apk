package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aco
  extends com.tencent.mm.bv.a
{
  public String AesKey;
  public String Md5;
  public String wUW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51402);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      if (this.wUW != null) {
        paramVarArgs.e(3, this.wUW);
      }
      AppMethodBeat.o(51402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.AesKey);
      }
      i = paramInt;
      if (this.wUW != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wUW);
      }
      AppMethodBeat.o(51402);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(51402);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aco localaco = (aco)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(51402);
          return -1;
        case 1: 
          localaco.Md5 = locala.CLY.readString();
          AppMethodBeat.o(51402);
          return 0;
        case 2: 
          localaco.AesKey = locala.CLY.readString();
          AppMethodBeat.o(51402);
          return 0;
        }
        localaco.wUW = locala.CLY.readString();
        AppMethodBeat.o(51402);
        return 0;
      }
      AppMethodBeat.o(51402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aco
 * JD-Core Version:    0.7.0.1
 */