package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wg
  extends com.tencent.mm.bx.a
{
  public int VQU;
  public String VcU;
  public String VcV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113965);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.VcU != null) {
        paramVarArgs.g(1, this.VcU);
      }
      if (this.VcV != null) {
        paramVarArgs.g(2, this.VcV);
      }
      paramVarArgs.bS(3, this.VQU);
      AppMethodBeat.o(113965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.VcU == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.VcU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.VcV != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.VcV);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.VQU);
      AppMethodBeat.o(113965);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113965);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        wg localwg = (wg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113965);
          return -1;
        case 1: 
          localwg.VcU = locala.ajGk.readString();
          AppMethodBeat.o(113965);
          return 0;
        case 2: 
          localwg.VcV = locala.ajGk.readString();
          AppMethodBeat.o(113965);
          return 0;
        }
        localwg.VQU = locala.ajGk.aar();
        AppMethodBeat.o(113965);
        return 0;
      }
      AppMethodBeat.o(113965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wg
 * JD-Core Version:    0.7.0.1
 */