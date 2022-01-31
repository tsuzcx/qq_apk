package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abb
  extends com.tencent.mm.bv.a
{
  public String Name;
  public long ltw;
  public int wRF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73703);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.ltw);
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      paramVarArgs.aO(3, this.wRF);
      AppMethodBeat.o(73703);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.ltw) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Name);
      }
      i = e.a.a.b.b.a.bl(3, this.wRF);
      AppMethodBeat.o(73703);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(73703);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      abb localabb = (abb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(73703);
        return -1;
      case 1: 
        localabb.ltw = locala.CLY.sm();
        AppMethodBeat.o(73703);
        return 0;
      case 2: 
        localabb.Name = locala.CLY.readString();
        AppMethodBeat.o(73703);
        return 0;
      }
      localabb.wRF = locala.CLY.sl();
      AppMethodBeat.o(73703);
      return 0;
    }
    AppMethodBeat.o(73703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abb
 * JD-Core Version:    0.7.0.1
 */