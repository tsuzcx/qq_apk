package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgu
  extends com.tencent.mm.bx.a
{
  public float DEK;
  public float DEL;
  public float DEM;
  public String DEN;
  public String Label;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32326);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.DEK);
      paramVarArgs.x(2, this.DEL);
      paramVarArgs.x(3, this.DEM);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      if (this.DEN != null) {
        paramVarArgs.d(5, this.DEN);
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 4 + 0 + (f.a.a.b.b.a.fY(2) + 4) + (f.a.a.b.b.a.fY(3) + 4);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt;
      if (this.DEN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DEN);
      }
      AppMethodBeat.o(32326);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bgu localbgu = (bgu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32326);
        return -1;
      case 1: 
        localbgu.DEK = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(32326);
        return 0;
      case 2: 
        localbgu.DEL = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(32326);
        return 0;
      case 3: 
        localbgu.DEM = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(32326);
        return 0;
      case 4: 
        localbgu.Label = locala.KhF.readString();
        AppMethodBeat.o(32326);
        return 0;
      }
      localbgu.DEN = locala.KhF.readString();
      AppMethodBeat.o(32326);
      return 0;
    }
    AppMethodBeat.o(32326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgu
 * JD-Core Version:    0.7.0.1
 */