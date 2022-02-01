package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvr
  extends com.tencent.mm.bx.a
{
  public double FIb;
  public double FIc;
  public String GPU;
  public String GPV;
  public String GPW;
  public String qdY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.FIc);
      paramVarArgs.e(2, this.FIb);
      if (this.qdY != null) {
        paramVarArgs.d(3, this.qdY);
      }
      if (this.GPU != null) {
        paramVarArgs.d(4, this.GPU);
      }
      if (this.GPV != null) {
        paramVarArgs.d(5, this.GPV);
      }
      if (this.GPW != null) {
        paramVarArgs.d(6, this.GPW);
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alT(1) + 0 + f.a.a.b.b.a.alT(2);
      paramInt = i;
      if (this.qdY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qdY);
      }
      i = paramInt;
      if (this.GPU != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GPU);
      }
      paramInt = i;
      if (this.GPV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GPV);
      }
      i = paramInt;
      if (this.GPW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GPW);
      }
      AppMethodBeat.o(32338);
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
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvr localbvr = (bvr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32338);
        return -1;
      case 1: 
        localbvr.FIc = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(32338);
        return 0;
      case 2: 
        localbvr.FIb = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(32338);
        return 0;
      case 3: 
        localbvr.qdY = locala.NPN.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 4: 
        localbvr.GPU = locala.NPN.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 5: 
        localbvr.GPV = locala.NPN.readString();
        AppMethodBeat.o(32338);
        return 0;
      }
      localbvr.GPW = locala.NPN.readString();
      AppMethodBeat.o(32338);
      return 0;
    }
    AppMethodBeat.o(32338);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvr
 * JD-Core Version:    0.7.0.1
 */