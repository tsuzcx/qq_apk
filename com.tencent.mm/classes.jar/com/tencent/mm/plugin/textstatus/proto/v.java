package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class v
  extends com.tencent.mm.bx.a
{
  public int Tps;
  public b Tpu;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290053);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Tps);
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.Tpu != null) {
        paramVarArgs.d(4, this.Tpu);
      }
      AppMethodBeat.o(290053);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Tps) + 0 + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.Tpu != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.Tpu);
      }
      AppMethodBeat.o(290053);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290053);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(290053);
        return -1;
      case 1: 
        localv.Tps = locala.ajGk.aar();
        AppMethodBeat.o(290053);
        return 0;
      case 2: 
        localv.wuz = locala.ajGk.aar();
        AppMethodBeat.o(290053);
        return 0;
      case 3: 
        localv.wuA = locala.ajGk.readString();
        AppMethodBeat.o(290053);
        return 0;
      }
      localv.Tpu = locala.ajGk.kFX();
      AppMethodBeat.o(290053);
      return 0;
    }
    AppMethodBeat.o(290053);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.v
 * JD-Core Version:    0.7.0.1
 */