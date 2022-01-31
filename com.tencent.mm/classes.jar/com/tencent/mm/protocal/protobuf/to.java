package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class to
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public long kfs;
  public int kft;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11736);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.kfs);
      paramVarArgs.aO(2, this.kft);
      if (this.cwc != null) {
        paramVarArgs.e(3, this.cwc);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      AppMethodBeat.o(11736);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.kfs) + 0 + e.a.a.b.b.a.bl(2, this.kft);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.cwc);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.path);
      }
      AppMethodBeat.o(11736);
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
      AppMethodBeat.o(11736);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      to localto = (to)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(11736);
        return -1;
      case 1: 
        localto.kfs = locala.CLY.sm();
        AppMethodBeat.o(11736);
        return 0;
      case 2: 
        localto.kft = locala.CLY.sl();
        AppMethodBeat.o(11736);
        return 0;
      case 3: 
        localto.cwc = locala.CLY.readString();
        AppMethodBeat.o(11736);
        return 0;
      }
      localto.path = locala.CLY.readString();
      AppMethodBeat.o(11736);
      return 0;
    }
    AppMethodBeat.o(11736);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.to
 * JD-Core Version:    0.7.0.1
 */