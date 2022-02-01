package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zp
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LkR;
  public String LkS;
  
  public zp()
  {
    AppMethodBeat.i(152518);
    this.LkR = new LinkedList();
    AppMethodBeat.o(152518);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152519);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.LkR);
      if (this.LkS != null) {
        paramVarArgs.e(2, this.LkS);
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.a.c(1, 1, this.LkR) + 0;
      paramInt = i;
      if (this.LkS != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LkS);
      }
      AppMethodBeat.o(152519);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LkR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      zp localzp = (zp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152519);
        return -1;
      case 1: 
        localzp.LkR.add(locala.UbS.readString());
        AppMethodBeat.o(152519);
        return 0;
      }
      localzp.LkS = locala.UbS.readString();
      AppMethodBeat.o(152519);
      return 0;
    }
    AppMethodBeat.o(152519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zp
 * JD-Core Version:    0.7.0.1
 */