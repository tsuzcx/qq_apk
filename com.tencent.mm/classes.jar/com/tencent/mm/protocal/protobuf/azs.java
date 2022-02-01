package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azs
  extends com.tencent.mm.bw.a
{
  public String LJx;
  public String eventName;
  public long twd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.twd);
      if (this.eventName != null) {
        paramVarArgs.e(2, this.eventName);
      }
      if (this.LJx != null) {
        paramVarArgs.e(3, this.LJx);
      }
      AppMethodBeat.o(209618);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.twd) + 0;
      paramInt = i;
      if (this.eventName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.eventName);
      }
      i = paramInt;
      if (this.LJx != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LJx);
      }
      AppMethodBeat.o(209618);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209618);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      azs localazs = (azs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209618);
        return -1;
      case 1: 
        localazs.twd = locala.UbS.zl();
        AppMethodBeat.o(209618);
        return 0;
      case 2: 
        localazs.eventName = locala.UbS.readString();
        AppMethodBeat.o(209618);
        return 0;
      }
      localazs.LJx = locala.UbS.readString();
      AppMethodBeat.o(209618);
      return 0;
    }
    AppMethodBeat.o(209618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azs
 * JD-Core Version:    0.7.0.1
 */