package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uz
  extends com.tencent.mm.bv.a
{
  public String coV;
  public String coW;
  public int version;
  public int wNA;
  public int wNB;
  public String wNC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28365);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.version);
      paramVarArgs.aO(2, this.wNA);
      paramVarArgs.aO(3, this.wNB);
      if (this.coW != null) {
        paramVarArgs.e(4, this.coW);
      }
      if (this.wNC != null) {
        paramVarArgs.e(5, this.wNC);
      }
      if (this.coV != null) {
        paramVarArgs.e(6, this.coV);
      }
      AppMethodBeat.o(28365);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.version) + 0 + e.a.a.b.b.a.bl(2, this.wNA) + e.a.a.b.b.a.bl(3, this.wNB);
      paramInt = i;
      if (this.coW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.coW);
      }
      i = paramInt;
      if (this.wNC != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wNC);
      }
      paramInt = i;
      if (this.coV != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.coV);
      }
      AppMethodBeat.o(28365);
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
      AppMethodBeat.o(28365);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      uz localuz = (uz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28365);
        return -1;
      case 1: 
        localuz.version = locala.CLY.sl();
        AppMethodBeat.o(28365);
        return 0;
      case 2: 
        localuz.wNA = locala.CLY.sl();
        AppMethodBeat.o(28365);
        return 0;
      case 3: 
        localuz.wNB = locala.CLY.sl();
        AppMethodBeat.o(28365);
        return 0;
      case 4: 
        localuz.coW = locala.CLY.readString();
        AppMethodBeat.o(28365);
        return 0;
      case 5: 
        localuz.wNC = locala.CLY.readString();
        AppMethodBeat.o(28365);
        return 0;
      }
      localuz.coV = locala.CLY.readString();
      AppMethodBeat.o(28365);
      return 0;
    }
    AppMethodBeat.o(28365);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uz
 * JD-Core Version:    0.7.0.1
 */