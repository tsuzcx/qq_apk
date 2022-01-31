package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bor
  extends com.tencent.mm.bv.a
{
  public String cqq;
  public String cyc;
  public String url;
  public int version;
  public boolean xCN;
  public int xCO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96282);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xCN);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.cqq != null) {
        paramVarArgs.e(3, this.cqq);
      }
      paramVarArgs.aO(4, this.version);
      paramVarArgs.aO(5, this.xCO);
      if (this.cyc != null) {
        paramVarArgs.e(6, this.cyc);
      }
      AppMethodBeat.o(96282);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.cqq != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cqq);
      }
      i = i + e.a.a.b.b.a.bl(4, this.version) + e.a.a.b.b.a.bl(5, this.xCO);
      paramInt = i;
      if (this.cyc != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.cyc);
      }
      AppMethodBeat.o(96282);
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
      AppMethodBeat.o(96282);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bor localbor = (bor)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96282);
        return -1;
      case 1: 
        localbor.xCN = locala.CLY.emu();
        AppMethodBeat.o(96282);
        return 0;
      case 2: 
        localbor.url = locala.CLY.readString();
        AppMethodBeat.o(96282);
        return 0;
      case 3: 
        localbor.cqq = locala.CLY.readString();
        AppMethodBeat.o(96282);
        return 0;
      case 4: 
        localbor.version = locala.CLY.sl();
        AppMethodBeat.o(96282);
        return 0;
      case 5: 
        localbor.xCO = locala.CLY.sl();
        AppMethodBeat.o(96282);
        return 0;
      }
      localbor.cyc = locala.CLY.readString();
      AppMethodBeat.o(96282);
      return 0;
    }
    AppMethodBeat.o(96282);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bor
 * JD-Core Version:    0.7.0.1
 */