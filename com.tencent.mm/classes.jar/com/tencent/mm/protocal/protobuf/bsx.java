package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsx
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String path;
  public String tMg;
  public int type;
  public String xGz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56957);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      if (this.xGz != null) {
        paramVarArgs.e(3, this.xGz);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      if (this.tMg != null) {
        paramVarArgs.e(5, this.tMg);
      }
      AppMethodBeat.o(56957);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = paramInt;
      if (this.xGz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xGz);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.path);
      }
      i = paramInt;
      if (this.tMg != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.tMg);
      }
      AppMethodBeat.o(56957);
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
      AppMethodBeat.o(56957);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bsx localbsx = (bsx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56957);
        return -1;
      case 1: 
        localbsx.type = locala.CLY.sl();
        AppMethodBeat.o(56957);
        return 0;
      case 2: 
        localbsx.cwc = locala.CLY.readString();
        AppMethodBeat.o(56957);
        return 0;
      case 3: 
        localbsx.xGz = locala.CLY.readString();
        AppMethodBeat.o(56957);
        return 0;
      case 4: 
        localbsx.path = locala.CLY.readString();
        AppMethodBeat.o(56957);
        return 0;
      }
      localbsx.tMg = locala.CLY.readString();
      AppMethodBeat.o(56957);
      return 0;
    }
    AppMethodBeat.o(56957);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsx
 * JD-Core Version:    0.7.0.1
 */