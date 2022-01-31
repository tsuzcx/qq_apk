package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckh
  extends com.tencent.mm.bv.a
{
  public String kWy;
  public String path;
  public int showType;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80197);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.showType);
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.kWy != null) {
        paramVarArgs.e(3, this.kWy);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      AppMethodBeat.o(80197);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.showType) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.kWy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kWy);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.path);
      }
      AppMethodBeat.o(80197);
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
      AppMethodBeat.o(80197);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ckh localckh = (ckh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80197);
        return -1;
      case 1: 
        localckh.showType = locala.CLY.sl();
        AppMethodBeat.o(80197);
        return 0;
      case 2: 
        localckh.title = locala.CLY.readString();
        AppMethodBeat.o(80197);
        return 0;
      case 3: 
        localckh.kWy = locala.CLY.readString();
        AppMethodBeat.o(80197);
        return 0;
      }
      localckh.path = locala.CLY.readString();
      AppMethodBeat.o(80197);
      return 0;
    }
    AppMethodBeat.o(80197);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckh
 * JD-Core Version:    0.7.0.1
 */