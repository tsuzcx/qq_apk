package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fcr
  extends com.tencent.mm.bx.a
{
  public String YPU;
  public String YPV;
  public String desc;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259051);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.state);
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.YPU != null) {
        paramVarArgs.g(3, this.YPU);
      }
      if (this.YPV != null) {
        paramVarArgs.g(4, this.YPV);
      }
      AppMethodBeat.o(259051);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.state) + 0;
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.YPU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YPU);
      }
      paramInt = i;
      if (this.YPV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YPV);
      }
      AppMethodBeat.o(259051);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259051);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fcr localfcr = (fcr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259051);
        return -1;
      case 1: 
        localfcr.state = locala.ajGk.aar();
        AppMethodBeat.o(259051);
        return 0;
      case 2: 
        localfcr.desc = locala.ajGk.readString();
        AppMethodBeat.o(259051);
        return 0;
      case 3: 
        localfcr.YPU = locala.ajGk.readString();
        AppMethodBeat.o(259051);
        return 0;
      }
      localfcr.YPV = locala.ajGk.readString();
      AppMethodBeat.o(259051);
      return 0;
    }
    AppMethodBeat.o(259051);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcr
 * JD-Core Version:    0.7.0.1
 */