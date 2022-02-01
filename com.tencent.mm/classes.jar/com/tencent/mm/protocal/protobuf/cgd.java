package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgd
  extends com.tencent.mm.bw.a
{
  public long KVX;
  public LinkedList<String> MlP;
  
  public cgd()
  {
    AppMethodBeat.i(220713);
    this.KVX = 0L;
    this.MlP = new LinkedList();
    AppMethodBeat.o(220713);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220714);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KVX);
      paramVarArgs.e(2, 1, this.MlP);
      AppMethodBeat.o(220714);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.KVX);
      int i = g.a.a.a.c(2, 1, this.MlP);
      AppMethodBeat.o(220714);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MlP.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(220714);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cgd localcgd = (cgd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(220714);
        return -1;
      case 1: 
        localcgd.KVX = locala.UbS.zl();
        AppMethodBeat.o(220714);
        return 0;
      }
      localcgd.MlP.add(locala.UbS.readString());
      AppMethodBeat.o(220714);
      return 0;
    }
    AppMethodBeat.o(220714);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgd
 * JD-Core Version:    0.7.0.1
 */