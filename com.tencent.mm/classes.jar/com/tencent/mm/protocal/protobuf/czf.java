package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czf
  extends com.tencent.mm.bv.a
{
  public int ygg;
  public String ygh;
  public String ygi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11825);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ygg);
      if (this.ygh != null) {
        paramVarArgs.e(2, this.ygh);
      }
      if (this.ygi != null) {
        paramVarArgs.e(3, this.ygi);
      }
      AppMethodBeat.o(11825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.ygg) + 0;
      paramInt = i;
      if (this.ygh != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ygh);
      }
      i = paramInt;
      if (this.ygi != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ygi);
      }
      AppMethodBeat.o(11825);
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
      AppMethodBeat.o(11825);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      czf localczf = (czf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(11825);
        return -1;
      case 1: 
        localczf.ygg = locala.CLY.sl();
        AppMethodBeat.o(11825);
        return 0;
      case 2: 
        localczf.ygh = locala.CLY.readString();
        AppMethodBeat.o(11825);
        return 0;
      }
      localczf.ygi = locala.CLY.readString();
      AppMethodBeat.o(11825);
      return 0;
    }
    AppMethodBeat.o(11825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czf
 * JD-Core Version:    0.7.0.1
 */