package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyz
  extends com.tencent.mm.bv.a
{
  public String cqq;
  public String url;
  public int wAx;
  public int yfY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96317);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.yfY);
      paramVarArgs.aO(2, this.wAx);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.cqq != null) {
        paramVarArgs.e(4, this.cqq);
      }
      AppMethodBeat.o(96317);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.yfY) + 0 + e.a.a.b.b.a.bl(2, this.wAx);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.url);
      }
      i = paramInt;
      if (this.cqq != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.cqq);
      }
      AppMethodBeat.o(96317);
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
      AppMethodBeat.o(96317);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cyz localcyz = (cyz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96317);
        return -1;
      case 1: 
        localcyz.yfY = locala.CLY.sl();
        AppMethodBeat.o(96317);
        return 0;
      case 2: 
        localcyz.wAx = locala.CLY.sl();
        AppMethodBeat.o(96317);
        return 0;
      case 3: 
        localcyz.url = locala.CLY.readString();
        AppMethodBeat.o(96317);
        return 0;
      }
      localcyz.cqq = locala.CLY.readString();
      AppMethodBeat.o(96317);
      return 0;
    }
    AppMethodBeat.o(96317);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyz
 * JD-Core Version:    0.7.0.1
 */