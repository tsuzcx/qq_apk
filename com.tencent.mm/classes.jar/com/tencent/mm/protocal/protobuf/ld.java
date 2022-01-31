package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ld
  extends com.tencent.mm.bv.a
{
  public String wxi;
  public int wyS;
  public int wyT;
  public long wyU;
  public String wyV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151371);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wyS);
      paramVarArgs.aO(2, this.wyT);
      paramVarArgs.am(3, this.wyU);
      if (this.wyV != null) {
        paramVarArgs.e(4, this.wyV);
      }
      if (this.wxi != null) {
        paramVarArgs.e(5, this.wxi);
      }
      AppMethodBeat.o(151371);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wyS) + 0 + e.a.a.b.b.a.bl(2, this.wyT) + e.a.a.b.b.a.p(3, this.wyU);
      paramInt = i;
      if (this.wyV != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wyV);
      }
      i = paramInt;
      if (this.wxi != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wxi);
      }
      AppMethodBeat.o(151371);
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
      AppMethodBeat.o(151371);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ld localld = (ld)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151371);
        return -1;
      case 1: 
        localld.wyS = locala.CLY.sl();
        AppMethodBeat.o(151371);
        return 0;
      case 2: 
        localld.wyT = locala.CLY.sl();
        AppMethodBeat.o(151371);
        return 0;
      case 3: 
        localld.wyU = locala.CLY.sm();
        AppMethodBeat.o(151371);
        return 0;
      case 4: 
        localld.wyV = locala.CLY.readString();
        AppMethodBeat.o(151371);
        return 0;
      }
      localld.wxi = locala.CLY.readString();
      AppMethodBeat.o(151371);
      return 0;
    }
    AppMethodBeat.o(151371);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ld
 * JD-Core Version:    0.7.0.1
 */