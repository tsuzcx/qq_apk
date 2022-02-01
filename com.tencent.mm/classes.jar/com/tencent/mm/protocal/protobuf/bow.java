package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bow
  extends com.tencent.mm.bx.a
{
  public float GJE;
  public float GJF;
  public float GJG;
  public String GJH;
  public String Label;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32326);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.GJE);
      paramVarArgs.z(2, this.GJF);
      paramVarArgs.z(3, this.GJG);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      if (this.GJH != null) {
        paramVarArgs.d(5, this.GJH);
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alU(1) + 0 + f.a.a.b.b.a.alU(2) + f.a.a.b.b.a.alU(3);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt;
      if (this.GJH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GJH);
      }
      AppMethodBeat.o(32326);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bow localbow = (bow)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32326);
        return -1;
      case 1: 
        localbow.GJE = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(32326);
        return 0;
      case 2: 
        localbow.GJF = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(32326);
        return 0;
      case 3: 
        localbow.GJG = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(32326);
        return 0;
      case 4: 
        localbow.Label = locala.NPN.readString();
        AppMethodBeat.o(32326);
        return 0;
      }
      localbow.GJH = locala.NPN.readString();
      AppMethodBeat.o(32326);
      return 0;
    }
    AppMethodBeat.o(32326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bow
 * JD-Core Version:    0.7.0.1
 */