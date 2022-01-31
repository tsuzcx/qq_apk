package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aze
  extends com.tencent.mm.bv.a
{
  public int type;
  public String url;
  public String wFW;
  public boolean xoA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56848);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.wFW != null) {
        paramVarArgs.e(3, this.wFW);
      }
      paramVarArgs.aS(4, this.xoA);
      AppMethodBeat.o(56848);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.wFW != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wFW);
      }
      paramInt = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(56848);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56848);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aze localaze = (aze)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56848);
        return -1;
      case 1: 
        localaze.type = locala.CLY.sl();
        AppMethodBeat.o(56848);
        return 0;
      case 2: 
        localaze.url = locala.CLY.readString();
        AppMethodBeat.o(56848);
        return 0;
      case 3: 
        localaze.wFW = locala.CLY.readString();
        AppMethodBeat.o(56848);
        return 0;
      }
      localaze.xoA = locala.CLY.emu();
      AppMethodBeat.o(56848);
      return 0;
    }
    AppMethodBeat.o(56848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aze
 * JD-Core Version:    0.7.0.1
 */